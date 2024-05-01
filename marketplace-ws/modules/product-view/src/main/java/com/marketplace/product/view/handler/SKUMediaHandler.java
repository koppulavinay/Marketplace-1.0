package com.marketplace.product.view.handler;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalService;
import com.liferay.document.library.kernel.service.DLFolderLocalService;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadServletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys.SKUMediaConstants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * Handles SKU Media of a Product in Liferay's Document & Media Library. Like
 * uploading files, creating folders, deleting documents and folders from
 * Document & Media Library.
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, service = SKUMediaHandler.class)
public class SKUMediaHandler {

	/**
	 * 
	 * Upload files in the Products folder in Document Media. It will create a
	 * folder hirarchy like Products >> ProductId Folder >> SKU Id Folder >> Images
	 * & Documents. If the folders are present in the Document & Media then it will
	 * use that folder to add documents and if not present then it will create
	 * folder and add documents in it.
	 * 
	 * Returns a JSON object of all the documents with their preview URLs and
	 * Document Id that are mapped with a SKU Id of a Product.
	 * 
	 * @param portletRequest
	 * @return
	 * @throws PortalException
	 */
	public JSONObject uploadFilesToProductsDMS(PortletRequest portletRequest) throws PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(portletRequest);
		
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);
		UploadServletRequest uploadServletRequest = PortalUtil.getUploadServletRequest(httpServletRequest);
		
		String skuIdStr = uploadServletRequest.getParameter("productskuId");
        String draftProductIdStr = uploadServletRequest.getParameter("draftProductId");
        
        long skuId = 0;
        long draftProductId = 0;

        if(Validator.isNotNull(skuIdStr))
            skuId = Long.valueOf(skuIdStr);
        
        if(Validator.isNotNull(draftProductIdStr))
            draftProductId = Long.valueOf(draftProductIdStr);
		
//		long skuId = Long.parseLong(uploadServletRequest.getParameter("productskuId"));
//		long draftProductId = Long.parseLong(uploadServletRequest.getParameter("draftProductId"));//Long.valueOf(PortalUtil.getOriginalServletRequest(httpServletRequest).getParameter(ProductViewPortletKeys.DRAFT_PRODUCT_ID));
		
		
		System.out.println("skuId:66-"+skuId);
		System.out.println("draftProductId:66-"+draftProductId);
		File[] files = uploadServletRequest.getFiles("images");
		System.out.println("file length:"+files.length);
		//Map<String, FileItem[]> files = uploadPortletRequest.getMultipartParameterMap();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), portletRequest);

		long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(),
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

		// Fetching Product Folder Id from the DMS if present and if not then create
		// Product Folder
		long parentProductsFolderId = getDlFolderId(themeDisplay, repositoryId,
				DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, SKUMediaConstants.PRODUCTS.getValue(), StringPool.BLANK,
				serviceContext);

		// Fetching Product Id Folder from the DMS if present and if not then create a
		// folder with Product Id.
		long productFolderId = getDlFolderId(themeDisplay, repositoryId, parentProductsFolderId,
				String.valueOf(draftProductId), StringPool.BLANK, serviceContext);

		// Fetching SKU Folder Id from the Product Folder present in the DMS and if not
		// then create folder with SKU Id.
		long skuFolderId = getDlFolderId(themeDisplay, repositoryId, productFolderId, String.valueOf(skuId),
				StringPool.BLANK, serviceContext);

		JSONObject documentJSON = JSONFactoryUtil.createJSONObject();

		documentJSON.put(ProductViewPortletKeys.DRAFT_PRODUCT_ID, draftProductId);
		documentJSON.put(SKUMediaConstants.SKU_FOLDER_ID.getValue(), skuFolderId);
		documentJSON.put(SKUMediaConstants.SKU_ID.getValue(), skuId);
        documentJSON.put("productFolderId", productFolderId);
		JSONArray documentsArray = JSONFactoryUtil.createJSONArray();
		
		setFileEntries(files, themeDisplay, repositoryId, skuFolderId, serviceContext,
				documentsArray);

		/*
		 * files.entrySet().stream().forEach(file -> { try {
		 * setFileEntries(file.getValue(), themeDisplay, repositoryId, skuFolderId,
		 * serviceContext, documentsArray); } catch (PortalException e) { _log.
		 * warn("Unable to Upload Files in Document & Media. Please enable debug logs for full details."
		 * ); _log.debug(e, e); } });
		 */

		documentJSON.put(SKUMediaConstants.DOCUMENTS.getValue(), documentsArray);

		return documentJSON;

	}
	
	// Copy of set file entries
	private void setFileEntries(File[] files, ThemeDisplay themeDisplay, long repositoryId, long folderId,
            ServiceContext serviceContext, JSONArray documentsArray) throws PortalException {

        long mediaFolderId = 0;

        if(files.length == 0) {
            mediaFolderId = getDlFolderId(themeDisplay, repositoryId, folderId,
                    SKUMediaConstants.IMAGES.getValue(),
                    "This folder contains all the images of the SKU which are uploading programatically.",
                    serviceContext);
        }
        
        for (File file : files) {

            if (Validator.isNotNull(file.getName())) {

                //LOGGER.info("File Name-------------> " + file.getName());

                String mimeType = MimeTypesUtil.getContentType(file);


                if (mimeType.contains(SKUMediaConstants.IMAGE.getValue())) {
                    mediaFolderId = getDlFolderId(themeDisplay, repositoryId, folderId,
                            SKUMediaConstants.IMAGES.getValue(),
                            "This folder contains all the images of the SKU which are uploading programatically.",
                            serviceContext);
                } else {
                    mediaFolderId = getDlFolderId(themeDisplay, repositoryId, folderId,
                            SKUMediaConstants.DOCUMENTS_CAPITAL.getValue(),
                            "This folder contains all the documents of the SKU which are uploading programatically.",
                            serviceContext);
                }

                FileEntry document;

                try {
                    document = dlAppLocalService.addFileEntry(StringPool.BLANK, themeDisplay.getUserId(), repositoryId,
                            mediaFolderId, file.getName(), mimeType, Files.readAllBytes(file.toPath()), null, null,
                            serviceContext);
                } catch (PortalException | IOException e) {

                    //LOGGER.info("File already exist with title-----------> " + file.getName());

                    document = dlAppLocalService.getFileEntry(themeDisplay.getScopeGroupId(), mediaFolderId,
                            file.getName());
                }

                String documentURL = constructDocumentURL(themeDisplay, document);

                documentsArray.put(constructDocumentJson(document.getFileEntryId(), documentURL.toLowerCase()));
            }
        }
    }

	/**
	 * 
	 * Upload Files in the Document & Media by segregating them using the types of
	 * files. Images are stored into the Images folder and Documents are stored in
	 * the Documents Folder of an SKU.
	 * 
	 * @param fileItems
	 * @param themeDisplay
	 * @param repositoryId
	 * @param folderId
	 * @param serviceContext
	 * @param documentsArray
	 * @throws PortalException
	 */
	/*
	 * private void setFileEntries(FileItem[] fileItems, ThemeDisplay themeDisplay,
	 * long repositoryId, long folderId, ServiceContext serviceContext, JSONArray
	 * documentsArray) throws PortalException {
	 * 
	 * File file = null;
	 * 
	 * for (FileItem fileItem : fileItems) {
	 * 
	 * if (Validator.isNotNull(fileItem.getFileName())) {
	 * 
	 * _log.info("File Name-------------> " + fileItem.getFileName());
	 * 
	 * file = fileItem.getStoreLocation(); String mimeType =
	 * MimeTypesUtil.getContentType(file);
	 * 
	 * long mediaFolderId = 0;
	 * 
	 * if (mimeType.contains(SKUMediaConstants.IMAGE.getValue())) { mediaFolderId =
	 * getDlFolderId(themeDisplay, repositoryId, folderId,
	 * SKUMediaConstants.IMAGES.getValue(),
	 * "This folder contains all the images of the SKU which are uploading programatically."
	 * , serviceContext); } else { mediaFolderId = getDlFolderId(themeDisplay,
	 * repositoryId, folderId, SKUMediaConstants.DOCUMENTS_CAPITAL.getValue(),
	 * "This folder contains all the documents of the SKU which are uploading programatically."
	 * , serviceContext); }
	 * 
	 * FileEntry document;
	 * 
	 * try { document = dlAppLocalService.addFileEntry(StringPool.BLANK,
	 * themeDisplay.getUserId(), repositoryId, mediaFolderId,
	 * fileItem.getFileName(), mimeType, Files.readAllBytes(file.toPath()), null,
	 * null, serviceContext); } catch (PortalException | IOException e) {
	 * 
	 * _log.info("File already exist with title-----------> " +
	 * fileItem.getFileName());
	 * 
	 * document = dlAppLocalService.getFileEntry(themeDisplay.getScopeGroupId(),
	 * mediaFolderId, fileItem.getFileName()); }
	 * 
	 * String documentURL = constructDocumentURL(themeDisplay, document);
	 * 
	 * documentsArray.put(constructDocumentJson(document.getFileEntryId(),
	 * documentURL.toLowerCase()));
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

	/**
	 * 
	 * Returns Folder Id of the folder name provided. If folder not present in the
	 * DMS then it will create a folder with the provided folder name and return its
	 * folder Id.
	 * 
	 * @param themeDisplay
	 * @param repositoryId
	 * @param parentFolderId
	 * @param folderName
	 * @param folderDescription
	 * @param serviceContext
	 * @return
	 * @throws PortalException
	 */
	private long getDlFolderId(ThemeDisplay themeDisplay, long repositoryId, long parentFolderId, String folderName,
			String folderDescription, ServiceContext serviceContext) throws PortalException {

		long folderId = 0;

		try {
			// Fetching Folder from the DMS
			folderId = dlFolderLocalService.getFolder(themeDisplay.getScopeGroupId(), parentFolderId, folderName)
					.getFolderId();
		} catch (PortalException e) {

			_log.warn(folderName
					+ " Folder not found in DMS. Creating a folder with the provided Folder Name in DMS....");

			// If folder is not found then create the folder with provided folder name
			folderId = dlAppLocalService.addFolder(StringPool.BLANK, themeDisplay.getUserId(), repositoryId,
					parentFolderId, folderName, folderDescription, serviceContext).getFolderId();
		}

		return folderId;

	}

	/**
	 * 
	 * Returns Document's details in a Json format of Document Id and Document URL.
	 * 
	 * @param themeDisplay
	 * @param documentId
	 * @return
	 * @throws PortalException
	 */
	public JSONObject getDocumentDetailsById(ThemeDisplay themeDisplay, long documentId) throws PortalException {

		FileEntry document = dlAppLocalService.getFileEntry(documentId);

		String documentURL = constructDocumentURL(themeDisplay, document);

		return constructDocumentJson(document.getFileEntryId(), documentURL.toLowerCase());

	}

	/**
	 * 
	 * Returns file's preview URL.
	 * 
	 * @param themeDisplay
	 * @param fileEntry
	 * @return
	 * @throws PortalException
	 */
	private String constructDocumentURL(ThemeDisplay themeDisplay, FileEntry fileEntry) throws PortalException {

		return DLURLHelperUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK);
	}

	/**
	 * 
	 * Constructs Document's JSON by adding document ID and its preview URL.
	 * 
	 * @param documentId
	 * @param documentURL
	 * @return
	 */
	private JSONObject constructDocumentJson(long documentId, String documentURL) {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		jsonObject.put(SKUMediaConstants.DOCUMENT_ID.getValue(), documentId);
		jsonObject.put(SKUMediaConstants.DOCUMENT_URL.getValue(), documentURL);

		return jsonObject;

	}

	/**
	 * 
	 * Deletes a document from the Document & Media.
	 * 
	 * @param documentId
	 * @throws PortalException
	 */
	public void deleteDocumentFromDMSById(long documentId) throws PortalException {

		dlAppLocalService.deleteFileEntry(documentId);
	}

	/**
	 * 
	 * Deletes a folder from the Document and Media.
	 * 
	 * @param folderId
	 * @throws PortalException
	 */
	public void deleteFolderFromDMSById(long folderId) throws PortalException {

		dlFolderLocalService.deleteFolder(folderId);
	}

	@Reference
	private DLFolderLocalService dlFolderLocalService;

	@Reference
	private DLAppLocalService dlAppLocalService;

	@Reference
	private DLFileEntryLocalService dlFileEntryLocalService;

	private static final Log _log = LogFactoryUtil.getLog(SKUMediaHandler.class);

}