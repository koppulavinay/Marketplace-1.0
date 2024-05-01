<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@ page import="javax.portlet.*"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>

<%
CommerceCartContentTotalDisplayContext commerceCartContentTotalDisplayContext = (CommerceCartContentTotalDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

CommerceMoney subtotalCommerceMoney = null;
CommerceMoney taxValueCommerceMoney = null;
CommerceMoney totalOrderCommerceMoney = null;
CommerceMoney totalDiscountAmountCommerceMoney = null;
CommerceMoney subtotalDiscountAmountCommerceMoney = null;
CommerceDiscountValue totalCommerceDiscountValue = null;
CommerceDiscountValue subtotalCommerceDiscountValue = null;

String priceDisplayType = commerceCartContentTotalDisplayContext.getCommercePriceDisplayType();

CommerceOrderPrice commerceOrderPrice = commerceCartContentTotalDisplayContext.getCommerceOrderPrice();

if (commerceOrderPrice != null) {
	subtotalCommerceMoney = commerceOrderPrice.getSubtotal();

	subtotalCommerceDiscountValue = commerceOrderPrice.getSubtotalDiscountValue();

	if (subtotalCommerceDiscountValue != null) {
		subtotalDiscountAmountCommerceMoney = subtotalCommerceDiscountValue.getDiscountAmount();
	}

	taxValueCommerceMoney = commerceOrderPrice.getTaxValue();
	totalOrderCommerceMoney = commerceOrderPrice.getTotal();

	totalCommerceDiscountValue = commerceOrderPrice.getTotalDiscountValue();

	if (totalCommerceDiscountValue != null) {
		totalDiscountAmountCommerceMoney = totalCommerceDiscountValue.getDiscountAmount();
	}

	if (priceDisplayType.equals(CommercePricingConstants.TAX_INCLUDED_IN_PRICE)) {
		subtotalCommerceMoney = commerceOrderPrice.getSubtotalWithTaxAmount();

		subtotalCommerceDiscountValue = commerceOrderPrice.getSubtotalDiscountValueWithTaxAmount();

		if (subtotalCommerceDiscountValue != null) {
			subtotalDiscountAmountCommerceMoney = subtotalCommerceDiscountValue.getDiscountAmount();
		}

		totalOrderCommerceMoney = commerceOrderPrice.getTotalWithTaxAmount();

		totalCommerceDiscountValue = commerceOrderPrice.getTotalDiscountValueWithTaxAmount();

		if (totalCommerceDiscountValue != null) {
			totalDiscountAmountCommerceMoney = totalCommerceDiscountValue.getDiscountAmount();
		}
	}
}

Map<String, Object> contextObjects = HashMapBuilder.<String, Object>put(
	"commerceCartContentTotalDisplayContext", commerceCartContentTotalDisplayContext
).build();

SearchContainer<CommerceOrderItem> commerceOrderItemSearchContainer = commerceCartContentTotalDisplayContext.getSearchContainer();
%>

<div class="container cartValuePage">
<liferay-ddm:template-renderer
	className="<%= CommerceCartContentTotalPortlet.class.getName() %>"
	contextObjects="<%= contextObjects %>"
	displayStyle="<%= commerceCartContentTotalDisplayContext.getDisplayStyle() %>"
	displayStyleGroupId="<%= commerceCartContentTotalDisplayContext.getDisplayStyleGroupId() %>"
	entries="<%= commerceOrderItemSearchContainer.getResults() %>"
>

		<div class="cart-value">
			<ul>
				<c:if test="<%=subtotalCommerceMoney != null%>">
					<li><c:if
							test="<%=subtotalCommerceDiscountValue != null%>">
        	(<%=HtmlUtil.escape(subtotalDiscountAmountCommerceMoney.format(locale))%>)
        </c:if> SubTotal : <span><%=HtmlUtil.escape(subtotalCommerceMoney.format(locale))%></span> </li>
				</c:if>
				<c:if
					test="<%=(taxValueCommerceMoney != null)
							&& priceDisplayType.equals(CommercePricingConstants.TAX_EXCLUDED_FROM_PRICE)%>">
					<li>Tax : <span><%=HtmlUtil.escape(taxValueCommerceMoney.format(locale))%></span></li>
				</c:if>

				<c:if test="<%=totalOrderCommerceMoney != null%>">

					<li class="total-value"><c:if
							test="<%=totalCommerceDiscountValue != null%>">
        (<%=HtmlUtil.escape(totalDiscountAmountCommerceMoney.format(locale))%>)
        </c:if> <strong> Total : <span> </strong> <strong><%=HtmlUtil.escape(totalOrderCommerceMoney.format(locale))%></strong></span>
					</li>
				</c:if>

			</ul>
		</div>



		<%-- <div class="order-total text-dark">
 	<c:if test="<%= subtotalCommerceMoney != null %>">
			<div class="row">
				<c:if test="<%= subtotalCommerceDiscountValue != null %>">
					<div class="col-auto">
						<h4><liferay-ui:message key="subtotal-discount" /></h4>
					</div>

					<div class="col-auto">
						<span>(<%= HtmlUtil.escape(subtotalDiscountAmountCommerceMoney.format(locale)) %>)</span>
					</div>
				</c:if>

				<div class="col-auto">
					<h3 class="h4 cart-value my-data">Subtotal<span> :</span></h3>
				</div>

				<div class="col text-right ">
					<h3 class="h4 cart-value"><%= HtmlUtil.escape(subtotalCommerceMoney.format(locale)) %></h3>
				</div>
			</div>
		</c:if> --%>

	<%-- 	<c:if test="<%= (taxValueCommerceMoney != null) && priceDisplayType.equals(CommercePricingConstants.TAX_EXCLUDED_FROM_PRICE) %>">
			<div class="row">
				<div class="col-auto">
					<h3 class="h4 cart-value my-data">Tax <span> :</span></h3>
				</div>

				<div class="col   text-right">
					<h3 class="h4 cart-value"><%= HtmlUtil.escape(taxValueCommerceMoney.format(locale)) %></h3>
				</div>
			</div>
		</c:if> --%>

		<%-- <c:if test="<%= totalOrderCommerceMoney != null %>">
			<div class="row">
				<c:if test="<%= totalCommerceDiscountValue != null %>">
					<div class="col-auto">
						<h4><liferay-ui:message key="total-discount" /></h4>
					</div>

					<div class="col-auto">
						<span>(<%= HtmlUtil.escape(totalDiscountAmountCommerceMoney.format(locale)) %>)</span>
					</div>
				</c:if>

				<div class="col-auto">
					<h3 class="h4 my-data">Total <span> :</span></h3>
				</div>

				<div class="col text-right">
					<h3 class="h4"><%= HtmlUtil.escape(totalOrderCommerceMoney.format(locale)) %></h3>
				</div>
			</div>
		</c:if>
	</div>
 --%>
	<aui:button-row>

		<%
			PortletURL checkoutPortletURL = commerceCartContentTotalDisplayContext.getCheckoutPortletURL();
			String checkoutOrderSummaryURL = checkoutPortletURL.toString().replace("shipping-address", "checkout-consignee-step");

			PortletURL cartPageURL = PortletURLFactoryUtil.create(request,
                    "com_liferay_commerce_product_content_search_web_internal_portlet_CPSearchResultsPortlet",
                    PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),
                            "com_liferay_commerce_product_content_search_web_internal_portlet_CPSearchResultsPortlet"),
                    PortletRequest.RENDER_PHASE);
           String backURL = cartPageURL.toString();
		%>

		<div class="bottomBarButton mb-5">
		<a href="<%=backURL%>" class="btn btn-outline-secondary bigButton">Back</a>
		<%-- <aui:button cssClass="btn-outline-secondary bigButton"  value="Back" /> --%>
		<aui:button cssClass="btn-lg btn-primary bigButton" disabled="<%= !commerceCartContentTotalDisplayContext.isValidCommerceOrder() %>" href="<%= checkoutOrderSummaryURL %>" value="Proceed to checkout" />
		</div>
		<c:if test="<%= commerceCartContentTotalDisplayContext.isRequestQuoteEnabled() && commerceCartContentTotalDisplayContext.isValidCommerceOrder() %>">
			<aui:button cssClass="btn-lg request-quote" id="requestQuote"  value='<%= LanguageUtil.get(request, "request-a-quote") %>' />
		</c:if>
	</aui:button-row>

	<%@ include file="/cart_total/request_quote.jspf" %>

	<liferay-frontend:component
		module="js/cart_total/view"
	/>
</liferay-ddm:template-renderer>

</div>