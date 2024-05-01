package com.marketplace.product.view.resource;

import com.buycorp.common.util.CommonUtil;
import com.liferay.commerce.product.model.CPAttachmentFileEntry;
import com.liferay.commerce.product.model.CPDefinition;
import com.liferay.commerce.product.service.CPAttachmentFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.mediasku.master.model.ProductMediaSKU;
import com.marketplace.product.mediasku.master.service.ProductMediaSKULocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.handler.SKUMediaHandler;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author sobhit
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name="
				+ ProductViewPortletKeys.SKU_MEDIA_REMOVE_RESOURCE_CMD, }, service = MVCResourceCommand.class)
public class SKUMediaDeleteResource implements MVCResourceCommand {

	
	private static final Log LOGGER = LogFactoryUtil.getLog(SKUMediaDeleteResource.class.getName());
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
	        throws PortletException {
		LOGGER.info("-------------- SKU Media Images Remove Resource -------------");
	    long productMediaskuId = ParamUtil.getLong(resourceRequest, "productskuMediaId");
	    try {
	        ProductMediaSKU productMediaSKU = productMediaSKULocalService.getProductMediaSKU(productMediaskuId);
	        Product product = productLocalService.fetchProduct(productMediaSKU.getDraftProductId());
	        
	        // Delete the same image from LR
	        deleteMediaLR(product, productMediaSKU);
	        
	        skuMediaHandler.deleteDocumentFromDMSById(productMediaSKU.getFileEntryId());
	        productMediaSKULocalService.deleteProductMediaSKU(productMediaskuId);
	        CommonUtil.getPrintWriter(resourceResponse).write("SUCCESS");
	    } catch (PortalException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	// Delete the image from LR
	private void deleteMediaLR(Product product, ProductMediaSKU productMediaSKU) throws PortalException {
		LOGGER.info(":::: Inside deleteMediaLR method ::::");
		if(product.getCpDefinitionId() > 0) {
			long classNameId = ClassNameLocalServiceUtil.getClassName(CPDefinition.class.getName()).getClassNameId();
			List<CPAttachmentFileEntry> cpAttachmentFileEntries =  CPAttachmentFileEntryLocalServiceUtil
					.getCPAttachmentFileEntries(classNameId, product.getCpDefinitionId(), 0, 0, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			for (CPAttachmentFileEntry cpAttachmentFileEntry : cpAttachmentFileEntries) {
				if(productMediaSKU.getFileEntryId() == cpAttachmentFileEntry.getFileEntryId()) {
					LOGGER.info("Deleting the image from LR of fileEntryId :: " + cpAttachmentFileEntry.getFileEntryId());
					CPAttachmentFileEntryLocalServiceUtil.deleteCPAttachmentFileEntry(cpAttachmentFileEntry.getCPAttachmentFileEntryId());
				}
			}
		}
	}
	
	@Reference
	private ProductMediaSKULocalService productMediaSKULocalService;
	
	@Reference
	private SKUMediaHandler skuMediaHandler;
	
	@Reference
	private ProductLocalService productLocalService;

}