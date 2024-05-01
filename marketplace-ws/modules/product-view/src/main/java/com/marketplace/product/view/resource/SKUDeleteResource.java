package com.marketplace.product.view.resource;

import com.buycorp.common.util.CommonUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.marketplace.product.mediasku.master.model.ProductMediaSKU;
import com.marketplace.product.mediasku.master.service.ProductMediaSKULocalService;
import com.marketplace.product.sku.master.model.ProductSKU;
import com.marketplace.product.sku.master.service.ProductSKULocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author sobhit
 *
 */
@Component(immediate = true, property = { "javax.portlet.name=" + ProductViewPortletKeys.PRODUCTVIEW,
		"mvc.command.name="
				+ ProductViewPortletKeys.SKU_DELETE_RESOURCE_CMD, }, service = MVCResourceCommand.class)
public class SKUDeleteResource implements MVCResourceCommand {

	private static final Log LOGGER = LogFactoryUtil.getLog(SKUDeleteResource.class.getName());
	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws PortletException {
		LOGGER.info("---------------- SKU Delete Resource -------------");
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(resourceRequest);
		HttpServletRequest httpOrgServletRequest=PortalUtil.getOriginalServletRequest(httpServletRequest);
		HttpSession httpSession = httpOrgServletRequest.getSession();
		
		String uid = ParamUtil.getString(resourceRequest, "uid");
		String[] str=uid.split("#");
		long productskuId = Long.parseLong(str[0].toString());
		long draftProductId = Long.parseLong(str[1].toString());
		ProductSKU productSKU=productSKULocalService.fetchProductSKU(productskuId);
		httpSession.setAttribute("sessionskuName", productSKU.getSkuName());
		 CommonUtil.getPrintWriter(resourceResponse).write("SUCCESS");
		try {
			productSKULocalService.deleteProductSKU(productskuId);
			List<ProductMediaSKU>  productMediaSKULst=productMediaSKULocalService.findByProductSKUIdWithDraftProductId(draftProductId, productskuId);
			for (ProductMediaSKU productMediaSKU : productMediaSKULst) {
				productMediaSKULocalService.deleteProductMediaSKU(productMediaSKU.getProductMediaSKUId());
			}
			
		} catch (PortalException e) { 
			e.printStackTrace();
		}

		return false;
	}
	
	@Reference
	private ProductMediaSKULocalService productMediaSKULocalService;
	
	@Reference
	private ProductSKULocalService productSKULocalService;

}
