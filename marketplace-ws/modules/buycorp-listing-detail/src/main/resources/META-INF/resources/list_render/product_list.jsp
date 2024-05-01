<%@page import="com.marketplace.product.master.service.ProductLocalServiceUtil"%>
<%@page import="com.marketplace.product.master.model.Product"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.commerce.product.service.CPAttachmentFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetVocabulary"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="com.liferay.commerce.product.content.helper.CPCompareContentHelper"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil"%>
<%@page import="com.liferay.asset.entry.rel.model.AssetEntryAssetCategoryRel"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.commerce.product.model.CPDefinition"%>
<%@page import="com.liferay.commerce.product.content.helper.CPContentHelper"%>
<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="com.liferay.commerce.frontend.model.ProductSettingsModel"%>
<%@page import="com.liferay.commerce.product.content.constants.CPContentWebKeys"%>
<%@page import="com.liferay.commerce.product.catalog.CPSku"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.commerce.constants.CommerceWebKeys"%>
<%@page import="com.liferay.commerce.context.CommerceContext"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.math.BigDecimal"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil" %>
<%@taglib uri="http://liferay.com/tld/adaptive-media-image" prefix="liferay-adaptive-media" %>
<%@page import="com.liferay.commerce.product.service.CPDefinitionLocalServiceUtil"%>
<%@page import="com.liferay.commerce.product.model.CPInstance"%>
<%@page import="com.liferay.commerce.product.constants.CPWebKeys"%>
<%@page import="com.liferay.commerce.product.data.source.CPDataSourceResult"%>
<%@page import="com.liferay.commerce.product.catalog.CPCatalogEntry"%>
<%@page import="com.liferay.commerce.product.model.CPAttachmentFileEntry" %>
<%@page import="com.liferay.commerce.product.constants.CPPortletKeys" %>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@include file="/init.jsp"%>

<%
CPDataSourceResult cpDataSourceResult = (CPDataSourceResult)request.getAttribute(CPWebKeys.CP_DATA_SOURCE_RESULT);
CPContentHelper cpContentHelper = (CPContentHelper)request.getAttribute(CPContentWebKeys.CP_CONTENT_HELPER);

CPCompareContentHelper cpCompareContentHelper = (CPCompareContentHelper)request.getAttribute(CPContentWebKeys.CP_COMPARE_CONTENT_HELPER);

%>

	<% if (cpDataSourceResult.getCPCatalogEntries().size() < 1) { %>
			<!-- No Product found container -->
    <section class="c-maincontainer">
        <div class="c-not-found">
            <div class="--notFound-image">
                <img src="${themeDisplay.getPathThemeImages()}/no-data.svg" alt="" class="img-fluid">
            </div>
            <div class="--notFound-title">Oops! No Products Found.</div>
            <p class="--notFound-text">Your search did not match any products.</p>
            <p class="--notFound-text">Please try with different filter options.</p>
        </div>
    </section>
		
			 <% } else { %>
			 	<liferay-util:dynamic-include key="com.liferay.commerce.product.content.web#/add_to_cart#pre" />
			<div class="listCardView gridView">
            <% for (CPCatalogEntry cpCatalogEntry : cpDataSourceResult.getCPCatalogEntries()) {
            	CPSku cpSku = cpContentHelper.getDefaultCPSku(cpCatalogEntry);
            	boolean hasMultipleCPSkus = cpContentHelper.hasMultipleCPSkus(cpCatalogEntry);
	%>
		<%
			String productDetailURL = cpContentHelper.getFriendlyURL(cpCatalogEntry, themeDisplay);
			%>
			
              <%
              CPDefinition cpDefinition = CPDefinitionLocalServiceUtil.getCPDefinition(cpCatalogEntry.getCPDefinitionId());
      			List<CPAttachmentFileEntry> cpAttachmentFileEntries = CPDefinitionLocalServiceUtil
      					.getCPDefinition(cpCatalogEntry.getCPDefinitionId()).getCPAttachmentFileEntries(0, 0);
              //System.out.println("cp file attachments " + cpAttachmentFileEntries);

			  String brandName = "";
              
              AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(CPDefinition.class.getName(), cpDefinition.getCPDefinitionId());
              //System.out.println("Asset Entry " + assetEntry);
              List<AssetEntryAssetCategoryRel> assetEntryAssetCategoryRelList = AssetEntryAssetCategoryRelLocalServiceUtil.getAssetEntryAssetCategoryRelsByAssetEntryId(assetEntry.getEntryId());
              for(AssetEntryAssetCategoryRel assetCategoryRel : assetEntryAssetCategoryRelList){
              	AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(assetCategoryRel.getAssetCategoryId());
              	AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getVocabulary(assetCategory.getVocabularyId());
              	if(assetVocabulary.getName().equalsIgnoreCase("select brand")){
              		brandName=assetCategory.getName();
              	}
              }

				String cpDefinitionCDNURL = cpContentHelper.getCPDefinitionCDNURL(cpCatalogEntry.getCPDefinitionId(), request);
				List<CPInstance> cpInstanceList=CPDefinitionLocalServiceUtil.getCPDefinition(cpCatalogEntry.getCPDefinitionId()).getCPInstances();
				CPInstance cpInstance = cpInstanceList.stream().filter(CPInstance::isApproved).collect(Collectors.minBy(Comparator.comparing(CPInstance::getPrice))).get();
				Product product = ProductLocalServiceUtil.findByCPDefinitionId(cpCatalogEntry.getCPDefinitionId());
				String modelNumber = product.getModelNumber();
				
				%>
				
                  <div class="listCard">
                  	<div class="custom-control compare-checkbox">
                      <commerce-ui:compare-checkbox
							CPCatalogEntry="<%= cpCatalogEntry %>"
							refreshOnRemove="<%= (cpCompareContentHelper != null) && CPPortletKeys.CP_COMPARE_CONTENT_WEB.equals(portletDisplay.getPortletName()) %>"
						/>
                    </div>
                    <!-- <div class="fixLable bestDeals">BEST DEALS</div> -->
                    <div class="productPic">
                    <%
                    if (cpAttachmentFileEntries != null && cpAttachmentFileEntries.size() > 0) {
                    	FileEntry fileEntry = DLAppServiceUtil.getFileEntry(cpAttachmentFileEntries.get(0).getFileEntryId());
		    			String docURL = "/documents/" + fileEntry.getGroupId() + "/" + fileEntry.getFolderId() + "/" + fileEntry.getTitle() + "/" + fileEntry.getUuid();
                    %>
                    	<a href="<%= productDetailURL %>"><img src="<%= docURL %>" alt=""></a>
                    <%
                    	} else {
                    %>
                    	<a href="<%= productDetailURL %>"><img src="/o/buycorp-classic-theme/images/no-image-available.jpg" alt=""></a>
                    <%
                    	}
                    %>
	                    <%-- <c:choose>
							<c:when test="<%= Validator.isNotNull(cpDefinitionCDNURL) %>">
								<a href="<%= productDetailURL %>"><img class="img-fluid product-card-picture" src="<%= cpDefinitionCDNURL %>" /></a>
								<a href="<%= productDetailURL %>"><img src="/o/buycorp-classic-theme/images/no-image-available.jpg" alt="" /></a>
							</c:when>
							<c:otherwise>
								<a href="<%= productDetailURL %>">
									<liferay-adaptive-media:img
										class="img-fluid product-card-picture"
										fileVersion="<%= cpContentHelper.getCPDefinitionImageFileVersion(cpCatalogEntry.getCPDefinitionId(), request) %>" />
								</a>
							</c:otherwise>
						</c:choose> --%>
					</div>
                    <div class="productData">
                        <div class="brandName"><%= brandName%></div>
                        <h3 class="productTitle">
                        	<a style="display:block !important" href="<%=productDetailURL%>">
                        		<%=cpCatalogEntry.getName()%>
                        		<%
                        			if(modelNumber != "") {
                        		%>
                        			<span> - <%=modelNumber%></span>
                        		<%
                        			}
                        		%>
                        	</a>
                        </h3>
                        <div class="reting-orders">
                          <div class="reting star-4-5">4.5</div>  
                          <div class="orderCount">154 orders</div>
                           <div class="inStock">
                           		<%-- <img src="${themeDisplay.getPathThemeImages()}/icon/icon-tick.svg" alt="">In stock --%>
								<commerce-ui:availability-label CPCatalogEntry="<%= cpCatalogEntry %>"/>
                           </div>
                        </div>
                        
                        <p class="productDescription"><%=cpCatalogEntry.getShortDescription()%></p>
                    </div>
                    <div class="productLabel">
                        <div class="labelBox">
                          
                          <c:if test="<%= !hasMultipleCPSkus %>">
						<commerce-ui:availability-label
							CPCatalogEntry="<%= cpCatalogEntry %>"
						/>
                          <commerce-ui:discontinued-label
							CPCatalogEntry="<%= cpCatalogEntry %>"
						/>
						</c:if>
						
                        </div>
                        <div class="priceProduct">
                        <%
	                       
                           BigDecimal originalPrice = cpInstance.getPrice().setScale(2);
	                       BigDecimal discountedPrice = cpInstance.getPromoPrice().setScale(2);
	                       BigDecimal priceDifference = originalPrice.subtract(discountedPrice);
	                       BigDecimal percentageDiscount;
	                       
	                       if (originalPrice.compareTo(BigDecimal.ZERO) != 0) {
	                           percentageDiscount = priceDifference.divide(originalPrice, 2, RoundingMode.HALF_EVEN).multiply(BigDecimal.valueOf(100));
	                       } else {
	                           percentageDiscount = BigDecimal.ZERO;
	                       }

	                       NumberFormat indianFormat = NumberFormat.getNumberInstance(new Locale("en", "IN"));
	                       indianFormat.setMaximumFractionDigits(2);
	                       indianFormat.setMinimumFractionDigits(2);

	                       String formattedPromoPrice = indianFormat.format(cpInstance.getPromoPrice().setScale(2));
	                       String formattedOriginalPrice = indianFormat.format(cpInstance.getPrice().setScale(2));
	                       String formattedPriceDifference = indianFormat.format(priceDifference);
	                       String formattedPercentageDiscount = indianFormat.format(percentageDiscount);


					%>
					    <div class="actualPrice"><sup>₹</sup> <%= formattedPromoPrice %></div>
					    <span class="oldPrice"><sup>₹</sup> <%= formattedOriginalPrice %></span> 
					    <span class="greenColor">₹ <%= formattedPriceDifference %> (<%= formattedPercentageDiscount %>% off)</span> 
					</div>
                        <div class="cardBtnBar">
		                  <liferay-util:dynamic-include key="com.liferay.commerce.product.content.web#/add_to_cart#post" />
		                       <c:choose>
							<c:when test="<%= !hasMultipleCPSkus && (cpSku != null) %>">
							    <c:if test="${isLoggedUser == true}">
							        <commerce-ui:add-to-cart
                                        alignment="full-width"
                                        CPCatalogEntry="<%= cpCatalogEntry %>"
                                        inline="<%= false %>"
                                        size="md"
                                        skuOptions="[]"
                                    />
							    </c:if>
							</c:when>
							<c:otherwise>
									<div class="add-to-cart d-flex" id="<%= PortalUtil.generateRandomKey(request, "taglib") + StringPool.UNDERLINE %>add_to_cart">
									<a class="btn btn-secondary" href="<%= productDetailURL %>" role="button">
										<liferay-ui:message key="view-all-variants" />
									</a>
								</div>
							</c:otherwise>
							</c:choose>
                          <%-- <button type="button" class="btn btn-outline-secondary cyncBtn"><img src="${themeDisplay.getPathThemeImages()}/icon/icon-cync.svg" alt=""></button> --%>
                        </div>
                    </div>
                  </div>
				 
				<%	
			} %>
			</div>
<%}%>

<script>

$(window).on('load', function() {
	
	$(".sideAccordion .portlet-body .collapse-icon.panel-header.panel-header-link").removeAttr("data-parent");
	$(".cardBtnBar .add-to-cart-wrapper .btn-primary").addClass("smallButton");
	
	$(".sideOnOff .panel-collapse").each(function(index) {
      var uniqueID = "collapse" + (index + 1); // Generate unique ID
      $(this).attr("id", uniqueID); // Assign unique ID to collapsible content
      $(this).parent(".panel").children("a").attr("href", "#" + uniqueID); // Update href attribute
    });
	
});

$(document).ready(function(){

    /// Quantity
    $('.quantityInput .add').click(function () {
      $(this).prev().val(+$(this).prev().val() + 1);
    });
    
    $('.quantityInput .sub').click(function () {
        if ($(this).next().val() > 1) {
          if ($(this).next().val() > 1) $(this).next().val(+$(this).next().val() - 1);
        }
    });

    // Collapse
//     $('.panel-group .panel > .collapse-icon.panel-header.panel-header-link').attr("aria-expanded",false);
//     $('.panel-group .panel > .collapse-icon.panel-header.panel-header-link').addClass("collapsed");
//     $('.panel-group .panel > .panel-collapse.collapse').removeClass("show");


    // Start PLP --------
   $(".filtersBtn, .filtersOff").click(function(){
      $('.filtersBtn').toggleClass('d-none');
      $('.sideOnOff').toggleClass('d-none');
    });
    $(".filtersBtn").click(function(){
      localStorage.setItem('product_sideBar', 'sideBar_open'); // localStorage - sideBar_open
    });
    $(".filtersOff").click(function(){
      localStorage.removeItem('product_sideBar', 'sideBar_open'); // localStorage - sideBar_open
    });
    if(localStorage.getItem('product_sideBar') == 'sideBar_open') { // localStorage - sideBar_open
      $('.filtersBtn').addClass('d-none');
      $('.sideOnOff').removeClass('d-none'); 
    }


    $(".listView .btn-secondary").click(function(){
      $('.listView .btn-secondary').toggleClass('active');
      $('.listCardView').toggleClass('gridView');
    });
    $(".listView .btn-secondary:nth-child(1)").click(function(){
      localStorage.setItem('grid_view', 'grid_open'); // localStorage - grid_open
    });
    $(".listView .btn-secondary:nth-child(2)").click(function(){
      localStorage.removeItem('grid_view', 'grid_open'); // localStorage - grid_open
    });
    if(localStorage.getItem('grid_view') == 'grid_open') { // localStorage - grid_open
      $('.listView .btn-secondary').removeClass('active');
      $('.listView .btn-secondary:nth-child(1)').addClass('active');
      $('.listCardView').addClass('gridView'); 
    }
      
    $(".seeAllFilter").click(function(){
        $(this).parent('.card-body').children(".outerHideShow").toggleClass('showAllFilter');
        if ($(this).text() == "See all") {
            $(this).text("See less");
        } else {
            $(this).text("See all");
        }
    });
    // End PLP -------

    // Start Price Range
    const rangeInput = document.querySelectorAll(".range-input input"),
    priceInput = document.querySelectorAll(".price-input input"),
    range = document.querySelector(".slider .progress");
    let priceGap = 1000;
  
    priceInput.forEach((input) => {
        input.addEventListener("input", (e) => {
            let minPrice = parseInt(priceInput[0].value),
            maxPrice = parseInt(priceInput[1].value);
    
            if (maxPrice - minPrice >= priceGap && maxPrice <= rangeInput[1].max) {
            if (e.target.className === "input-min") {
                rangeInput[0].value = minPrice;
                range.style.left = (minPrice / rangeInput[0].max) * 100 + "%";
            } else {
                rangeInput[1].value = maxPrice;
                range.style.right = 100 - (maxPrice / rangeInput[1].max) * 100 + "%";
            }
            }
        });
    });
  
    rangeInput.forEach((input) => {
        input.addEventListener("input", (e) => {
            let minVal = parseInt(rangeInput[0].value),
            maxVal = parseInt(rangeInput[1].value);

            if (maxVal - minVal < priceGap) {
            if (e.target.className === "range-min") {
                rangeInput[0].value = maxVal - priceGap;
            } else {
                rangeInput[1].value = minVal + priceGap;
            }
            } else {
            priceInput[0].value = minVal;
            priceInput[1].value = maxVal;
            range.style.left = (minVal / rangeInput[0].max) * 100 + "%";
            range.style.right = 100 - (maxVal / rangeInput[1].max) * 100 + "%";
            }
        });
    });
    // End Price Range
});

</script>
 
