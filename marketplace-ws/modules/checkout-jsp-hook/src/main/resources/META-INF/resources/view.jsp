<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@page import="com.marketplace.custom.checkout.model.CommerceOrderItemModel"%>
<%@ include file="/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayPortletURL"%>
<%@ page import="javax.portlet.*"%>
<%@ page import="com.liferay.portal.kernel.util.PortalUtil"%>

<%
	CheckoutDisplayContext checkoutDisplayContext = (CheckoutDisplayContext) request
			.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);
%>

<c:choose>
	<c:when test="<%=!checkoutDisplayContext.hasCommerceChannel()%>">
		<div class="alert alert-info mx-auto">
			<liferay-ui:message key="this-site-does-not-have-a-channel" />
		</div>
	</c:when>
	<c:otherwise>
		<div class="row">
			<div class="commerce-checkout container-fluid container-fluid-max-xl">
				<c:choose>
					<c:when test="<%=checkoutDisplayContext.isEmptyCommerceOrder()%>">
						<div class="alert alert-info mx-auto">
							<liferay-ui:message key="the-cart-is-empty" />
							<liferay-ui:message
								key="please-add-products-to-proceed-with-the-checkout" />
						</div>
					</c:when>
					<c:otherwise>
						<%-- <ul class="commerce-multi-step-nav multi-step-indicator-label-top multi-step-nav multi-step-nav-collapse-sm">

							<%
							boolean complete = true;
							String currentCheckoutStepName = checkoutDisplayContext.getCurrentCheckoutStepName();
							int step = 1;

							List<CommerceCheckoutStep> commerceCheckoutSteps = checkoutDisplayContext.getCommerceCheckoutSteps();

							Iterator<CommerceCheckoutStep> commerceCheckoutStepIterator = commerceCheckoutSteps.iterator();

							while (commerceCheckoutStepIterator.hasNext()) {
								CommerceCheckoutStep commerceCheckoutStep = commerceCheckoutStepIterator.next();

								String name = commerceCheckoutStep.getName();

								if (!currentCheckoutStepName.equals(name) && !commerceCheckoutStep.isVisible(request, response)) {
									continue;
								}

								String cssClass = "multi-step-item";

								if (commerceCheckoutStepIterator.hasNext()) {
									cssClass += " multi-step-item-expand";
								}

								if (currentCheckoutStepName.equals(name)) {
									cssClass += " active";
									complete = false;
								}

								if (complete) {
									cssClass += " complete";
								}
							%>

								<li class="<%= cssClass %>">
									<div class="multi-step-divider"></div>
									<div class="multi-step-indicator">
										<div class="multi-step-indicator-label">
											<liferay-ui:message key="<%= HtmlUtil.escape(commerceCheckoutStep.getLabel(locale)) %>" />
										</div>

										<span class="multi-step-icon" data-multi-step-icon="<%= step %>"></span>
									</div>
								</li>

							<%
								step++;
							}
							%>

						</ul> --%>

						<%
							String currentCheckoutStepName = checkoutDisplayContext.getCurrentCheckoutStepName();
						%>

						<portlet:actionURL name="/commerce_checkout/save_step"
							var="saveStepURL" />

						<aui:form action="<%=saveStepURL%>"
							data-senna-off="<%=checkoutDisplayContext.isSennaDisabled()%>"
							method="post" name="fm"
							onSubmit='<%="event.preventDefault(); " + liferayPortletResponse.getNamespace()
										+ "saveCheckoutStep();"%>'>
							<aui:input name="checkoutStepName" type="hidden"
								value="<%=currentCheckoutStepName%>" />
							<aui:input name="commerceOrderUuid" type="hidden"
								value="<%=checkoutDisplayContext.getCommerceOrderUuid()%>" />
							<aui:input name="redirect" type="hidden" value="<%=currentURL%>" />
							<aui:input name="currentBtn" id="currentBtn" type="hidden"
								value="checkout" />

							<%
								checkoutDisplayContext.renderCurrentCheckoutStep(pageContext);
							%>

							<div class="container">
								<div class="bottomBarButton mb-5">

									<c:if test="<%=checkoutDisplayContext.showControls()%>">

										<%
											String backURL = StringPool.BLANK;
										
											if (checkoutDisplayContext.getCurrentCheckoutStepName()
													.equalsIgnoreCase("checkout-consignee-step")) {
												
												PortletURL cartPageURL = PortletURLFactoryUtil.create(request,
														"com_liferay_commerce_cart_content_web_internal_portlet_CommerceCartContentPortlet",
														PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(),
																"com_liferay_commerce_cart_content_web_internal_portlet_CommerceCartContentPortlet"),
														PortletRequest.RENDER_PHASE);
												backURL = cartPageURL.toString();
												
											} else if (Validator
													.isNotNull(checkoutDisplayContext.getPreviousCheckoutStepName())){
										%>
												<portlet:renderURL var="previousStepURL">
													<portlet:param name="commerceOrderUuid"
														value="<%=String.valueOf(checkoutDisplayContext.getCommerceOrderUuid())%>" />
													<portlet:param name="checkoutStepName"
														value="<%=checkoutDisplayContext.getPreviousCheckoutStepName()%>" />
												</portlet:renderURL>
										<%
												backURL = previousStepURL.toString();
											}
										%>

										<aui:button-row>
											<aui:button cssClass="btn btn-outline-secondary bigButton"
												href="<%=backURL%>" value="back" />
											<aui:button cssClass="pull-right d-none" name="continue"
												primary="<%=true%>" type="submit" value="Continue" />

											<%
												if (checkoutDisplayContext.getCurrentCheckoutStepName().equalsIgnoreCase("order-summary")) {
											%>
													<aui:button cssClass="ml-3 btn-lg btn-primary bigButton"
														name="continue" type="submit"
														onclick="createOrderFunction()" value="Create Order" />
													<aui:button cssClass="ml-3 btn-lg btn-primary bigButton"
														name="bid" type="submit" onclick="bidFunction()"
														value="Send to Bid" />
											<%
												} else if (checkoutDisplayContext.getCurrentCheckoutStepName()
																					.equalsIgnoreCase("checkout-consignee-step")) {
											%>
													<button type="button" class="btn btn-primary bigButton"
														name="<portlet:namespace/>redirectToOrderSummary"
														id="<portlet:namespace/>redirectToOrderSummary"
														onclick="submitConsigneeDetails();">Save & Continue</button>
											<%
												}
											%>
										</aui:button-row>
									</c:if>
								</div>
							</div>

						</aui:form>

						<aui:script>
							function createOrderFunction(){
									AUI().use('aui-base', function(A) {
							            A.one('#<portlet:namespace />currentBtn').val('create-order');
							        });
								submitForm(document.<portlet:namespace />fm);
							}
							function bidFunction(){
									AUI().use('aui-base', function(A) {
							            A.one('#<portlet:namespace />currentBtn').val('sent-to-bid');
							        });
								submitForm(document.<portlet:namespace />fm);
							}
							function <portlet:namespace />saveCheckoutStep() {
								submitForm(document.<portlet:namespace />fm);
							}
						</aui:script>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</c:otherwise>
</c:choose>