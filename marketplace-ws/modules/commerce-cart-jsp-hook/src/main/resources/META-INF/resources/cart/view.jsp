<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp"%>
<%@page import="com.liferay.commerce.currency.service.CommerceCurrencyLocalServiceUtil"%>
<%@page import="com.liferay.commerce.price.list.service.CommercePriceListLocalServiceUtil"%>

<%
	CommerceCartContentDisplayContext commerceCartContentDisplayContext = (CommerceCartContentDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
	
	Map<String, Object> contextObjects = HashMapBuilder.<String, Object>put(
		"commerceCartContentDisplayContext", commerceCartContentDisplayContext
	).build();
	
	SearchContainer<CommerceOrderItem> commerceOrderItemSearchContainer = commerceCartContentDisplayContext.getSearchContainer();
	
	PortletURL portletURL = PortletURLBuilder.create(
		commerceCartContentDisplayContext.getPortletURL()
	).setParameter(
		"searchContainerId", "commerceOrderItems"
	).buildPortletURL();
	
	request.setAttribute("view.jsp-portletURL", portletURL);
	
	List<CommerceOrderValidatorResult> commerceOrderValidatorResults = new ArrayList<>();
	
	Map<Long, List<CommerceOrderValidatorResult>> commerceOrderValidatorResultsMap = commerceCartContentDisplayContext.getCommerceOrderValidatorResults();
%>

<liferay-ui:error
	exception="<%= CommerceOrderValidatorException.class %>">

	<%
		CommerceOrderValidatorException commerceOrderValidatorException = (CommerceOrderValidatorException)errorException;
	
		if (commerceOrderValidatorException != null) {
			commerceOrderValidatorResults = commerceOrderValidatorException.getCommerceOrderValidatorResults();
		}
	
		for (CommerceOrderValidatorResult commerceOrderValidatorResult : commerceOrderValidatorResults) {
	%>

		<liferay-ui:message
			key="<%= HtmlUtil.escape(commerceOrderValidatorResult.getLocalizedMessage()) %>" />

	<%
		}
	%>

</liferay-ui:error>

<div class="container">
    <div class="addProductTitle">
       <h1 class="titlePage mt-4">Cart Summary</h1>
    </div>
	<liferay-ddm:template-renderer
		className="<%= CommerceCartContentPortlet.class.getName() %>"
		contextObjects="<%= contextObjects %>"
		displayStyle="<%= commerceCartContentDisplayContext.getDisplayStyle() %>"
		displayStyleGroupId="<%= commerceCartContentDisplayContext.getDisplayStyleGroupId() %>"
		entries="<%= commerceOrderItemSearchContainer.getResults() %>">


		<div id="<portlet:namespace />orderItemsContainer">
			<div class="commerce-order-items-container"
				id="<portlet:namespace />entriesContainer">
				<liferay-ui:search-container id="commerceOrderItems"
					iteratorURL="<%= portletURL %>"
					searchContainer="<%= commerceOrderItemSearchContainer %>"
					delta="10">
					<liferay-ui:search-container-row
						className="com.liferay.commerce.model.CommerceOrderItem"
						keyProperty="CommerceOrderItemId" modelVar="commerceOrderItem">
						<%
							CPInstance cpInstance = commerceOrderItem.fetchCPInstance();
		
							long cpDefinitionId = 0;
		
							StringJoiner stringJoiner = new StringJoiner(StringPool.COMMA);
		
							String cpInstanceCDNURL = commerceCartContentDisplayContext.getCPInstanceCDNURL(commerceOrderItem);
		
							if (cpInstance != null) {
								CPDefinition cpDefinition = commerceOrderItem.getCPDefinition();
		
								cpDefinitionId = cpDefinition.getCPDefinitionId();
		
								for (KeyValuePair keyValuePair : commerceCartContentDisplayContext.getKeyValuePairs(commerceOrderItem.getCPDefinitionId(), commerceOrderItem.getJson(), locale)) {
									stringJoiner.add(keyValuePair.getValue());
								}
							}
							
							String modelNumber = StringPool.BLANK;
							String organizationName = StringPool.BLANK;
						
							try {
								Product product = ProductLocalServiceUtil.findByCPDefinitionId(cpDefinitionId);
								modelNumber = StringPool.SPACE + StringPool.DASH + StringPool.SPACE + product.getModelNumber();
								organizationName = product.getOrganizationName();
							} catch (NoSuchProductException e) {
								System.out.println("[Custom Logger] [commerce-cart-jsp-hook view.jsp:105] No Product found by CPDefinitionId {" + cpDefinitionId + "}");
							}
						
						%>

						<liferay-ui:search-container-column-text name="Items"
							cssClass="heading">
							<span class="sticker sticker-xl"> <span
								class="sticker-overlay"> <c:choose>
										<c:when test="<%= Validator.isNotNull(cpInstanceCDNURL) %>">
											<img class="sticker-img" src="<%= cpInstanceCDNURL %>" />
										</c:when>
										<c:otherwise>
											<liferay-adaptive-media:img class="sticker-img"
												fileVersion="<%= commerceCartContentDisplayContext.getCPInstanceImageFileVersion(commerceOrderItem) %>" />
										</c:otherwise>
									</c:choose>
							</span>
							</span>

							<a class="font-weight-bold text-decoration-none"
								href="<%= (cpDefinitionId == 0) ? StringPool.BLANK : commerceCartContentDisplayContext.getCPDefinitionURL(cpDefinitionId, themeDisplay) %>">

								<%= HtmlUtil.escape(commerceOrderItem.getName(languageId)) %>
								<%= modelNumber %>

							</a>

							<h6 class="text-default seller-name">
								<%= HtmlUtil.escape(stringJoiner.toString()) %>
								<div class="pt-1">Seller: <%= organizationName %></div>
							</h6>

							<c:if test="<%= !commerceOrderValidatorResultsMap.isEmpty() %>">

								<%
									commerceOrderValidatorResults = commerceOrderValidatorResultsMap.get(commerceOrderItem.getCommerceOrderItemId());
		
									for (CommerceOrderValidatorResult commerceOrderValidatorResult : commerceOrderValidatorResults) {
								%>
										<div class="alert-danger commerce-alert-danger">
											<liferay-ui:message
												key="<%= HtmlUtil.escape(commerceOrderValidatorResult.getLocalizedMessage()) %>" />
										</div>
								<%
									}
								%>

							</c:if>
						</liferay-ui:search-container-column-text>

						<%-- <liferay-ui:search-container-column-text
						name="description"
					>
						<a class="font-weight-bold" href="<%= (cpDefinitionId == 0) ? StringPool.BLANK : commerceCartContentDisplayContext.getCPDefinitionURL(cpDefinitionId, themeDisplay) %>">
							<%= HtmlUtil.escape(commerceOrderItem.getName(languageId)) %>
						</a>

						<h6 class="text-default">
							<%= HtmlUtil.escape(stringJoiner.toString()) %>
						</h6>

						<c:if test="<%= !commerceOrderValidatorResultsMap.isEmpty() %>">

							<%
							commerceOrderValidatorResults = commerceOrderValidatorResultsMap.get(commerceOrderItem.getCommerceOrderItemId());

							for (CommerceOrderValidatorResult commerceOrderValidatorResult : commerceOrderValidatorResults) {
							%>

								<div class="alert-danger commerce-alert-danger">
									<liferay-ui:message key="<%= HtmlUtil.escape(commerceOrderValidatorResult.getLocalizedMessage()) %>" />
								</div>

							<%
							}
							%>

						</c:if>
					</liferay-ui:search-container-column-text> --%>

						<liferay-ui:search-container-column-text name="Offer Price (Unit)">

							<%
	                           BigDecimal originalPrice = cpInstance.getPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN);
	                           BigDecimal discountedPrice = cpInstance.getPromoPrice().setScale(2, BigDecimal.ROUND_HALF_EVEN);
	                           BigDecimal priceDifference = originalPrice.subtract(discountedPrice);
	                           BigDecimal percentageDiscount;
	
	                           if (originalPrice.compareTo(BigDecimal.ZERO) != 0) {
	                               percentageDiscount = priceDifference.divide(originalPrice, 2, RoundingMode.HALF_EVEN).multiply(BigDecimal.valueOf(100));
	                           } else {
	                               percentageDiscount = BigDecimal.ZERO;
	                           }
	
	                    	%>
							<div class="priceProduct">
								<div class="actualPrice">
									<%
									    long commercePriceListId = commerceOrderItem.getCommercePriceListId();
									    long commerceCurrencyId = CommercePriceListLocalServiceUtil.getCommercePriceList(commercePriceListId).getCommerceCurrencyId();
									    String currencySymbol = CommerceCurrencyLocalServiceUtil.getCommerceCurrency(commerceCurrencyId).getSymbol();

                                     %>

									<%= currencySymbol+cpInstance.getPromoPrice().setScale(0,BigDecimal.ROUND_DOWN)%>
								</div>
								<span class="oldPrice"><%= currencySymbol+cpInstance.getPrice().setScale(0, BigDecimal.ROUND_DOWN)%></span>
								<span class="greenColor"> (<%=percentageDiscount%>% off)</span>
							</div>

							<%-- <c:if
							test="<%= commerceCartContentDisplayContext.hasViewPricePermission() %>">

							<%
							CommerceMoney unitPriceCommerceMoney = commerceCartContentDisplayContext.getUnitPriceCommerceMoney(commerceOrderItem);
							CommerceMoney unitPromoPriceCommerceMoney = commerceCartContentDisplayContext.getUnitPromoPriceCommerceMoney(commerceOrderItem);
							%>

							<c:choose>
								<c:when
									test="<%= commerceCartContentDisplayContext.isUnitPromoPriceActive(commerceOrderItem) %>">
									<%= HtmlUtil.escape(unitPromoPriceCommerceMoney.format(locale)) %>
								</c:when>
								<c:otherwise>
									<%= HtmlUtil.escape(unitPriceCommerceMoney.format(locale)) %>
								</c:otherwise>
							</c:choose>
						</c:if> --%>
						</liferay-ui:search-container-column-text>

						<%-- <liferay-ui:search-container-column-text
						name="discount"
					>
						<c:if test="<%= commerceCartContentDisplayContext.hasViewPricePermission() %>">

							<%
							CommerceMoney discountAmountCommerceMoney = commerceCartContentDisplayContext.getDiscountAmountCommerceMoney(commerceOrderItem);
							%>

							<%= HtmlUtil.escape(discountAmountCommerceMoney.format(locale)) %>
						</c:if>
					</liferay-ui:search-container-column-text> --%>

						<liferay-ui:search-container-column-text
							cssClass="quantity-control-column" name="quantity">
							<liferay-commerce-cart:quantity-control
								commerceOrderItemId="<%= commerceOrderItem.getCommerceOrderItemId() %>"
								showInputLabel="<% true %>" useSelect="<%= false %>" />
						</liferay-ui:search-container-column-text>

						<liferay-ui:search-container-column-text name="total">
							<c:if
								test="<%= commerceCartContentDisplayContext.hasViewPricePermission() %>">

								<%
							CommerceMoney finalPriceCommerceMoney = commerceCartContentDisplayContext.getFinalPriceCommerceMoney(commerceOrderItem);
							%>

								<%= HtmlUtil.escape(finalPriceCommerceMoney.format(locale)) %>

								<commerce-ui:product-subscription-info
									CPInstanceId="<%= commerceOrderItem.getCPInstanceId() %>"
									showDuration="<%= false %>" />
							</c:if>
						</liferay-ui:search-container-column-text>

						<liferay-ui:search-container-column-text name="action">
							<c:if
								test="<%= commerceCartContentDisplayContext.hasPermission(ActionKeys.UPDATE) %>">
								<button type="button" class="btn btn-link"
									data-parentcartid="<%= commerceOrderItem.getCommerceOrderId() %>"
									data-orderitemid="<%= commerceOrderItem.getCommerceOrderItemId() %>"
									data-deleteitemurl="<%= commerceCartContentDisplayContext.getDeleteURL(commerceOrderItem) %>"
								 	data-toggle="modal" data-target="#deleteOrderItem"
									onclick="openDeleteConfirmation(this);"><i class="fas fa-trash-alt"></i></button>
								<%-- <liferay-ui:icon-delete label="<%= false %>"
									showIcon="<%= true %>" cssClass="btn-link"
									url="<%= commerceCartContentDisplayContext.getDeleteURL(commerceOrderItem) %>" /> --%>
							</c:if>
						</liferay-ui:search-container-column-text>
					</liferay-ui:search-container-row>

					<liferay-ui:search-iterator displayStyle="list"
						markupView="lexicon"
						searchContainer="<%= commerceOrderItemSearchContainer %>" />
				</liferay-ui:search-container>
			</div>

			<liferay-frontend:component module="js/cart_total/view" />

		</div>

	</liferay-ddm:template-renderer>

</div>

<div class="modal fade" id="deleteOrderItem">
   <div class="modal-dialog modal-dialog-centered">
     <div class="modal-content">

       <button type="button" class="close" data-dismiss="modal"></button>

       <!-- Modal Header -->
       <div class="modal-header">
         <div class="modal-title">Delete Cart Item</div>
       </div>

       <!-- Modal body -->
       <div class="modal-body">
         <p>Are you sure, you want to delete this? It will be deleted immediately.</p>
       </div>

       <!-- Modal footer -->
       <div class="modal-footer">
       <button type="button" class="btn btn-outline-secondary cancelbtn" data-dismiss="modal">Cancel</button>
       	<button type="button" class="btn btn-primary deletebtn" id="deleteModelYesBtn" onclick="deleteItemFromCart(this);"
       		data-parentcartid=""
       		data-orderitemid=""
			data-deleteitemurl="">Delete</button>
       </div>

     </div>
   </div>
</div>

<script>
	/* Changing Quantity Update button text to Save and adding css */
	/* $('form button.btn.btn-primary').text('Save');
	$('form button.btn.btn-primary').addClass('btn-outline-secondary');
	$('form button.btn.btn-outline-secondary').removeClass('btn-primary'); */
	/* ------- End of CSS to Update button --------- */

	/* Adding Placeholder in Quantity Input field */
	$('form .field.commerce-input').attr('placeholder', 'Enter Quantity');
	
	var openDeleteConfirmation = (currObj) => {
		
		$('#deleteModelYesBtn').attr('data-parentcartid', $(currObj).attr('data-parentcartid'));
		$('#deleteModelYesBtn').attr('data-orderitemid', $(currObj).attr('data-orderitemid'));
		$('#deleteModelYesBtn').attr('data-deleteitemurl', $(currObj).attr('data-deleteitemurl'));
		
	};
	
	var deleteItemFromCart = async (currObj) => {
		
		var parentCartId = $(currObj).attr('data-parentcartid');
		var orderItemId = $(currObj).attr('data-orderitemid');
		var deleteItemUrl = $(currObj).attr('data-deleteitemurl');
		
		Liferay.Service('/marketplace_consigneedetails.checkoutconsigneedetails/delete-consignees-for-order-items', {
		    parentCartId: parentCartId,
		    orderItemId: orderItemId
		}, function(obj) {
			window.location.replace(deleteItemUrl);
		});
		
	};
	
</script>
