<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>

<%

CPPriceRangeFacetsDisplayContext cpPriceRangeFacetsDisplayContext = (CPPriceRangeFacetsDisplayContext)request.getAttribute(WebKeys.PORTLET_DISPLAY_CONTEXT);

%>

<c:choose>
	<c:when test="<%= !cpPriceRangeFacetsDisplayContext.hasCommerceChannel() && !cpPriceRangeFacetsDisplayContext.isStagingEnabled() %>">
		<div class="alert alert-info mx-auto">
		<liferay-ui:message key="this-site-does-not-have-a-channel" />
		</div>
	</c:when>
	<c:otherwise>

		<%
		Facet facet = cpPriceRangeFacetsDisplayContext.getFacet();

		String max = ParamUtil.getString(PortalUtil.getOriginalServletRequest(request), "max");

		double maxDouble = ParamUtil.getDouble(PortalUtil.getOriginalServletRequest(request), "max");

		if ((maxDouble == Double.MAX_VALUE) || (maxDouble == 0)) {
			max = StringPool.BLANK;
		}

		String min = StringPool.BLANK;

		double minDouble = ParamUtil.getDouble(PortalUtil.getOriginalServletRequest(request), "min");

		if (minDouble != 0) {
			min = ParamUtil.getString(PortalUtil.getOriginalServletRequest(request), "min");
		}
		%>

		<liferay-ui:panel-container
			extended="<%= true %>"
			markupView="lexicon"
			persistState="<%= true %>"
		>
			<liferay-ui:panel
				collapsible="<%= true %>"
				cssClass="search-facet"
				markupView="lexicon"
				persistState="<%= true %>"
				title="price-range"
			>
				<c:choose>
					<c:when test="<%= facet != null %>">

						<%
						FacetCollector facetCollector = facet.getFacetCollector();

						List<TermCollector> termCollectors = facetCollector.getTermCollectors();
						%>

						<c:if test="<%= !termCollectors.isEmpty() %>">
							<aui:form method="post" name='<%= "assetEntriesFacetForm_" + facet.getFieldName() %>'>
								<aui:input cssClass="facet-parameter-name" name="facet-parameter-name" type="hidden" value="<%= facet.getFieldName() %>" />
								<aui:input cssClass="start-parameter-name" name="start-parameter-name" type="hidden" value="<%= cpPriceRangeFacetsDisplayContext.getPaginationStartParameterName() %>" />

								<aui:fieldset>
								
							<div class="priceRangeBox">
							  <div class="slider">
<!-- 							    <div class="progress"></div> -->
							    <div id="slider-range"></div>
							  </div>
							  <!-- <div class="range-input">
							    <input type="range" class="range-min" min="0" max="300000" value="0" step="1000">
							    <input type="range" class="range-max" min="0" max="300000" value="300000" step="1000">
							  </div> -->
							</div>

									<ul class="list-unstyled d-none">

									<%
									int i = 0;

									for (TermCollector termCollector : termCollectors) {
										i++;
									%>

									<li class="facet-value">
										<div class="custom-checkbox custom-control">
											<label class="facet-checkbox-label" for="<portlet:namespace />term_<%= facet.getFieldName() + i %>">
												<input
													class="custom-control-input facet-term"
													data-term-id="<%= HtmlUtil.escapeAttribute(termCollector.getTerm()) %>"
													id="<portlet:namespace />term_<%= facet.getFieldName() + i %>"
													name="<portlet:namespace />term_<%= facet.getFieldName() + i %>"
													onChange="Liferay.Search.FacetUtil.changeSelection(event);"
													type="checkbox"
													<%= cpPriceRangeFacetsDisplayContext.isCPPriceRangeValueSelected(facet.getFieldName(), termCollector.getTerm()) ? "checked" : "" %>
												/>

												<span class="custom-control-label term-name <%= cpPriceRangeFacetsDisplayContext.isCPPriceRangeValueSelected(facet.getFieldName(), termCollector.getTerm()) ? "facet-term-selected" : "facet-term-unselected" %>">
													<span class="custom-control-label-text"><%= cpPriceRangeFacetsDisplayContext.getPriceRangeLabel(termCollector.getTerm()) %></span>
												</span>

											</label>
										</div>
									</li>

									<%
									}
									%>
									</ul>
								</aui:fieldset>
							</aui:form>
						</c:if>
					</c:when>
					<c:otherwise>
						<div class="alert alert-info">
							<liferay-ui:message key="no-facets-were-found" />
						</div>
					</c:otherwise>
				</c:choose>

				<c:if test="<%= cpPriceRangeFacetsDisplayContext.showInputRange() %>">
					<div class="priceRangeBox">
					<!-- <div class="mt-3 row price-input"> -->
					<div class="price-input">
						<div>
							<label>Min</label>
							<%-- <aui:input cssClass="price-range-input" label="<%= StringPool.BLANK %>" min="0" name="minimum" prefix="<%= HtmlUtil.escape(cpPriceRangeFacetsDisplayContext.getCurrentCommerceCurrencySymbol()) %>" type="number" value="<%= min %>" wrapperCssClass="col-md-5 price-range-input-wrapper" /> --%>
							<aui:input cssClass="price-range-input" label="<%= StringPool.BLANK %>" min="0" name="minimum" type="number" value="<%= min %>" wrapperCssClass="col-md-5 price-range-input-wrapper" />
						</div>
						<!-- <span class="mt-auto price-range-seperator text-center">-</span> -->
						
						<div>
							<label>Max</label>
							<%-- <aui:input cssClass="price-range-input" label="<%= StringPool.BLANK %>" name="maximum" prefix="<%= HtmlUtil.escape(cpPriceRangeFacetsDisplayContext.getCurrentCommerceCurrencySymbol()) %>" type="number" value="<%= max %>" wrapperCssClass="col-md-5 price-range-input-wrapper" /> --%>
							<aui:input cssClass="price-range-input" label="<%= StringPool.BLANK %>" name="maximum" type="number" value="<%= max %>" wrapperCssClass="col-md-5 price-range-input-wrapper" />
						</div>

						<div class="col-md-3 ml-2 p-0 d-none">
							<button class="btn btn-secondary price-range-btn" id="<portlet:namespace />priceRangeButton"><liferay-ui:message key="go" /></button>
						</div>
					</div>
					</div>
				</c:if>
			</liferay-ui:panel>
		</liferay-ui:panel-container>
	</c:otherwise>
</c:choose>

<aui:script use="liferay-search-facet-util" />

<liferay-frontend:component
	context='<%=
		HashMapBuilder.<String, Object>put(
			"maxValue", Double.MAX_VALUE
		).build()
	%>'
	module="js/price_range_facets/view"
/>

<link rel="stylesheet" href="<%= request.getContextPath() %>/cdn/css/jquery-ui.css">
 
<script src="<%= request.getContextPath() %>/cdn/js/jquery-ui.js"></script>

<script>
	
	$(window).on('load', function() {
    	//$(".mt-3.row").addClass("price-input");
    	$(".price-input > div:nth-child(1) .price-range-input").addClass("input-min");
    	$(".price-input > div:nth-child(2) .price-range-input").addClass("input-max");
    	// $(".price-input").appendTo(".priceRangeBox");

		var urlString = document.URL;
		var url = new URL(urlString);
		var searchParams = new URLSearchParams(url.search);
		var minVal = searchParams.get('min');
		var maxVal = searchParams.get('max');

        if(minVal == null)
        	minVal = '0';
        
        if(maxVal == null)
        	maxVal = '300000';
        
        $(".input-min").val(minVal);
        $(".input-max").val(maxVal);
        
        $(function() {
        	
            // Initialize slider
            $("#slider-range").slider({
              range: true,
              min: 0,
              max: 300000,
              values: [minVal, maxVal],
              slide: function(event, ui) {
                $(".input-min").val(ui.values[0]);
                $(".input-max").val(ui.values[1]);
				 setTimeout(() => {
    		    	$(".price-range-btn").click();
    			}, 100);
              }
            });

            // Set initial input values
            $(".input-min").val($("#slider-range").slider("values", 0));
            $(".input-max").val($("#slider-range").slider("values", 1));

            // Update slider when input fields are manually edited
            $(".input-min, .input-max").change(function() {
            	
              var minValue = parseInt($(".input-min").val());
              var maxValue = parseInt($(".input-max").val());

              setTimeout(() => {
    		    	$(".price-range-btn").click();
    			}, 100);
              
              // Ensure min value is less than max value
              if (minValue > maxValue) {
                var temp = minValue;
                minValue = maxValue;
                maxValue = temp;
                $(".input-min").val(minValue);
                $(".input-max").val(maxValue);
              }

              $("#slider-range").slider("values", [minValue, maxValue]);
              
            });
          });
	});
	
</script>

