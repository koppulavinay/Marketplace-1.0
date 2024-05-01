package checkout.custom.cart.helper;

import checkout.custom.model.CartDetails;
import checkout.custom.model.SellerCarts;
import checkout.custom.model.SourceDetails;
import checkout.custom.util.CheckoutUtil;
import com.liferay.commerce.context.CommerceContext;
import com.liferay.commerce.model.CommerceOrder;
import com.liferay.commerce.model.CommerceOrderItem;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author anubhav.kalra
 */
@Component(service = CartDetailsHelper.class, immediate = true)
public class CartDetailsHelper {

    public void setCartDetails(CartDetails cartDetails, CommerceOrder commerceOrder, CommerceContext commerceContext, PortletRequest portletRequest, ThemeDisplay themeDisplay, String arxUserId) {

        List<CommerceOrderItem> commerceOrderItems = commerceOrder.getCommerceOrderItems();

        setCartParentCartId(commerceOrder, cartDetails);
        setCartDates(commerceOrder, cartDetails);
        setCartPurchaseMode(cartDetails);
        setCartSourceDetails(cartDetails);

        setSellerCarts(portletRequest, themeDisplay, commerceContext, commerceOrderItems, cartDetails);
        try {
            cartDetails.setBuyerDetails(buyerDetailsHelper.getBuyerDetails(arxUserId, portletRequest));
        } catch (IOException e) {
            LOGGER.error(e, e);
        }

    }

    private void setCartSourceDetails(CartDetails cartDetails) {
        //Source Details
        SourceDetails sourceDetails = new SourceDetails();
        sourceDetails.setCode("Buycorp_MKP");
        sourceDetails.setId(1);
        sourceDetails.setName("Buycorp Marketplace");
        cartDetails.setSourceDetails(sourceDetails);
    }

    private void setCartPurchaseMode(CartDetails cartDetails) {
        cartDetails.setPurchaseMode("directPurchase");
    }

    private void setCartDates(CommerceOrder commerceOrder, CartDetails cartDetails) {
        cartDetails.setDates(CheckoutUtil.getDates("cart_creation_date", commerceOrder.getCreateDate()));
    }

    private void setCartParentCartId(CommerceOrder commerceOrder, CartDetails cartDetails) {
        cartDetails.setParentCartId(commerceOrder.getCommerceOrderId() + CheckoutUtil.getRandomNumberUsingNextInt(345, 9835));
    }

    private void setSellerCarts(PortletRequest portletRequest, ThemeDisplay themeDisplay, CommerceContext commerceContext, List<CommerceOrderItem> commerceOrderItems, CartDetails cartDetails) {
        List<SellerCarts> sellerCartsList = sellerCartHelper.getSellerCarts(portletRequest, themeDisplay, commerceContext, commerceOrderItems);
        cartDetails.setSellerCarts(sellerCartsList);
    }

    @Reference
    private SellerCartHelper sellerCartHelper;

    @Reference
    private BuyerDetailsHelper buyerDetailsHelper;

    private static final Log LOGGER = LogFactoryUtil.getLog(CartDetailsHelper.class);

}
