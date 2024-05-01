package com.marketplace.custom.checkout.util;

import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.List;

public interface CheckoutConsigneeStepUtil {

	static CommerceOrder getCommerceOrder(CommerceContext commerceContext) {

		return commerceContext.getCommerceOrder();
	}

	static List<CommerceOrderItem> getCommerceOrderItems(CommerceOrder commerceOrder) {

		return commerceOrder.getCommerceOrderItems();
	}

	static String getPDPFriendlyUrl(ThemeDisplay themeDisplay, CommerceOrderItem commerceOrderItem)
			throws PortalException {

		String productDetailUrl = themeDisplay.getPortalURL() + themeDisplay.getPathFriendlyURLPublic()
				+ themeDisplay.getLayout().getGroup().getFriendlyURL() + "/p/"
				+ commerceOrderItem.getCPDefinition().getURL(themeDisplay.getLocale().getLanguage());

		return productDetailUrl;
	}

}
