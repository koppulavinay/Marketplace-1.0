package com.marketplace.product.view.helper;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalService;
import com.marketplace.product.view.constants.ProductViewPortletKeys;
import com.marketplace.product.view.constants.ProductViewPortletKeys.BasicInformationConstants;

import java.util.Date;
import java.util.Locale;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Handles all the business logics of Product's Basic Information Page.
 * 
 * @author anubhav.kalra
 *
 */
@Component(immediate = true, service = BasicInformationHelper.class)
public class BasicInformationHelper {

	/**
	 * 
	 * Adds Product's Information in the Database.
	 * 
	 * @param portletRequest
	 * @return
	 * @throws PortalException
	 */
	public Product addBasicInformation(PortletRequest portletRequest) throws PortalException {

		// Fetching Basic Information Form Data
		long draftProductId = ParamUtil.getLong(portletRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);
		String modelNumber = ParamUtil.getString(portletRequest, BasicInformationConstants.MODEL_NUMBER.getValue());
		Map<Locale, String> shortDescription = LocalizationUtil.getLocalizationMap(portletRequest,
				BasicInformationConstants.SHORT_DESCRIPTION.getValue());
		Map<Locale, String> longDescription = LocalizationUtil.getLocalizationMap(portletRequest,
				BasicInformationConstants.LONG_DESCRIPTION.getValue());

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);

		// Setting Basic Information for the draft product
		Product draftProduct = productLocalService.getProduct(draftProductId);

		draftProduct.setShortDescriptionMap(shortDescription);
		draftProduct.setLongDescriptionMap(longDescription);
		draftProduct.setModelNumber(modelNumber);
		draftProduct.setModifiedBy(themeDisplay.getUserId());
		draftProduct.setModifiedDate(new Date());
		draftProduct.setStepNumber(0);
		draftProduct.setProductStatus(null);

		return productLocalService.updateProduct(draftProduct);
	}

	@Reference
	private ProductLocalService productLocalService;

}
