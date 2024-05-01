package com.marketplace.product.view.util;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.marketplace.product.master.model.Product;
import com.marketplace.product.master.service.ProductLocalServiceUtil;
import com.marketplace.product.view.constants.ProductViewPortletKeys;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;

/**
 * 
 * @author anubhav.kalra
 *
 */
public interface ProductViewUtil {

	/**
	 * Updates product status as draft or submitted in the database along with the
	 * step number when user has parked their product creation journey.
	 * 
	 * @param draftProductId
	 * @param productStatus
	 * @param stepNumber
	 * @return
	 * @throws PortalException
	 */
	static Product updateProductStatus(long draftProductId, long stepNumber, long userId, String productStatus)
			throws PortalException {

		Product product = ProductLocalServiceUtil.getProduct(draftProductId);

		product.setProductStatus(productStatus);
		product.setStepNumber(stepNumber);
		product.setModifiedDate(new Date());
		product.setModifiedBy(userId);

		return ProductLocalServiceUtil.updateProduct(product);

	}

	static void redirectToNextStep(ActionRequest actionRequest, ActionResponse actionResponse, String mvcCommandName) {

		long draftProductId = ParamUtil.getLong(actionRequest, ProductViewPortletKeys.DRAFT_PRODUCT_ID);

		actionResponse.getRenderParameters().setValue(ProductViewPortletKeys.DRAFT_PRODUCT_ID,
				String.valueOf(draftProductId));
		actionResponse.getRenderParameters().setValue(ProductViewPortletKeys.MVC_RENDER_COMMAND_NAME, mvcCommandName);

	}

	static void redirectToPIMProductListing(ActionResponse actionResponse) {
		actionResponse.getRenderParameters().setValue(ProductViewPortletKeys.MVC_RENDER_COMMAND_NAME,
				ProductViewPortletKeys.PIM_PRODUCT_LISTING_RENDER_CMD);
	}

	static void setLastModifiedDateInRequest(PortletRequest portletRequest, Product product, long draftProductId) throws PortalException {

		Date modifiedDate = null;

		if (Validator.isNotNull(product)) {
			modifiedDate = product.getModifiedDate();
		} else {
			modifiedDate = ProductLocalServiceUtil.getProduct(draftProductId).getModifiedDate();
		}

		String formattedDate =  formatDateInUTC(modifiedDate);
		
		portletRequest.setAttribute(ProductViewPortletKeys.MODIFIED_DATE, formattedDate);
	}

	static String formatDateInUTC(Date date) {

		return new SimpleDateFormat("MMM dd, yyyy, HH:mm").format(date);
	}
	
	/**
	 * Redirecting to edit step of a product where a user has left their product
	 * creation journey by doing saving as draft.
	 * 
	 * @param stepNumber
	 * @param draftProductId
	 * @param actionResponse
	 * @return
	 */
	static void redirectToStep(long stepNumber, long draftProductId, ActionResponse actionResponse) {

		String renderCommandName = StringPool.BLANK;

		switch ((int) stepNumber) {
		case 2:
			renderCommandName = ProductViewPortletKeys.BASIC_INFO_RENDER_CMD;
			break;
		case 3:
			renderCommandName = ProductViewPortletKeys.SELECT_SPECIFICATIONS_RENDER_CMD;
			break;
		case 4:
			renderCommandName = ProductViewPortletKeys.VARIANT_CREATION_RENDER;
			break;
		case 5:
			renderCommandName = ProductViewPortletKeys.SELECT_SKU_RENDER_CMD;
			break;
		case 6:
			renderCommandName = ProductViewPortletKeys.ADDITIONAL_INFORMATION_RENDER_CMD;
			break;
		default:
			renderCommandName = ProductViewPortletKeys.BRAND_CATEGORY_SELECT_RENDER_CMD;
		}

		actionResponse.getRenderParameters().setValue(ProductViewPortletKeys.DRAFT_PRODUCT_ID,
				String.valueOf(draftProductId));
		actionResponse.getRenderParameters().setValue(ProductViewPortletKeys.MVC_RENDER_COMMAND_NAME,
				renderCommandName);

	}

}
