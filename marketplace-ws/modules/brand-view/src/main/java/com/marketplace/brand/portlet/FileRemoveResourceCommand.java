package com.marketplace.brand.portlet;

import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.brand.constants.BrandViewPortletKeys;
import com.marketplace.brand.document.master.model.BrandDocumentUpload;
import com.marketplace.brand.document.master.service.BrandDocumentUploadLocalServiceUtil;

import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, property = { "javax.portlet.name=" + BrandViewPortletKeys.BRANDVIEW,
"mvc.command.name=fileRemoveCommand" }, service = MVCResourceCommand.class)

	//Ajax Servo Resource File
public class FileRemoveResourceCommand extends BaseMVCResourceCommand {
	
	private static final Log logger = LogFactoryUtil.getLog(FileRemoveResourceCommand.class);
	
	// removing files which are multiple file upload 
	@Override
	protected void doServeResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws Exception {
		
		//  removeing file using ajax
		logger.info(BrandViewPortletKeys.LOGGER_INFO_PREFIX + "Inside fileRemove Method" + BrandViewPortletKeys.LOGGER_INFO_SUFFIX);
		long fileEntryId = ParamUtil.getLong(resourceRequest, "fileEntryId");
		long brandId = ParamUtil.getLong(resourceRequest, BrandViewPortletKeys.BRAND_ID);
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		boolean docFlag = false;
		List<BrandDocumentUpload> brandDocumentUploads = BrandDocumentUploadLocalServiceUtil
				.findByBrandAndFileId(brandId, fileEntryId);
		for (BrandDocumentUpload brandDocumentUpload : brandDocumentUploads) {
			DLFileEntryLocalServiceUtil.deleteDLFileEntry(brandDocumentUpload.getDocumentId());
			BrandDocumentUploadLocalServiceUtil.deleteBrandDocumentUpload(brandDocumentUpload.getBrandDocumentUploadId());
			docFlag = true;
		}
		jsonObject.put("docFlag", docFlag);
		resourceResponse.getWriter().print(jsonObject);
		
	}

}
