<%@page import="com.marketplace.product.master.service.ProductLocalServiceUtil"%>
<%@page import="com.marketplace.product.master.model.Product"%>
<%@page import="com.marketplace.product.pkg.content.model.ProductPackageContent"%>
<%@page import="com.marketplace.product.pkg.content.service.ProductPackageContentLocalServiceUtil"%>
<%@page import="com.marketplace.product.search.keywords.service.ProductSearchKeywordsLocalServiceUtil"%>
<%@page import="com.marketplace.product.search.keywords.model.ProductSearchKeywords"%>
<%@page import="com.liferay.commerce.product.service.CPTaxCategoryLocalServiceUtil"%>
<%@page import="com.liferay.commerce.product.model.CPTaxCategory"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetVocabulary"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.HashMapBuilder"%>
<%@page import="com.liferay.commerce.product.content.util.CPMedia"%>
<%@page import="com.liferay.commerce.product.model.CPOptionCategory"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.commerce.product.content.helper.CPContentSkuOptionsHelper"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.asset.entry.rel.model.AssetEntryAssetCategoryRel"%>
<%@page import="com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONSerializer"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.commerce.frontend.model.ProductSettingsModel"%>
<%@include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.commerce.constants.CommerceWebKeys"%>
<%@page import="com.liferay.commerce.context.CommerceContext"%>
<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.commerce.product.model.CProduct"%>
<%@page import="com.liferay.commerce.product.service.CProductLocalServiceUtil"%>
<%@page import="com.liferay.commerce.product.model.CPDefinitionLink"%>
<%@page import="com.liferay.commerce.product.service.CPDefinitionLinkLocalServiceUtil"%>
<%@page import="com.liferay.commerce.product.service.CPSpecificationOptionLocalServiceUtil"%>
<%@page import="com.liferay.commerce.product.model.CPSpecificationOption"%>
<%@page import="com.liferay.commerce.product.model.CPDefinitionSpecificationOptionValue"%>
<%@page import="com.liferay.commerce.product.model.CPInstanceOptionValueRel"%>	
<%@page import="com.liferay.commerce.product.service.CPInstanceOptionValueRelLocalServiceUtil"%>
<%@page import="com.liferay.commerce.product.model.CPDefinition"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.commerce.product.model.CPDefinitionOptionValueRel"%>
<%@page import="com.liferay.commerce.product.service.CPDefinitionOptionValueRelLocalServiceUtil"%>
<%@page import="com.liferay.commerce.product.model.CPDefinitionOptionRel"%>
<%@page import="com.liferay.commerce.product.service.CPDefinitionOptionRelLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.commerce.product.model.CPOption"%>
<%@page import="com.liferay.commerce.product.service.CPOptionLocalServiceUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="com.liferay.commerce.product.model.CPInstance"%>
<%@page import="java.util.Comparator"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/init.jsp"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.commerce.product.model.CPAttachmentFileEntry"%>
<%@page import="com.liferay.commerce.product.service.CPDefinitionLocalServiceUtil"%>
<%@page import="com.liferay.commerce.product.catalog.CPSku"%>
<%@page import="com.liferay.commerce.product.catalog.CPCatalogEntry"%>
<%@page import="com.liferay.commerce.product.content.constants.CPContentWebKeys"%>
<%@page import="com.liferay.commerce.product.content.helper.CPContentHelper"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException" %>

<%

CPContentHelper cpContentHelper = (CPContentHelper)request.getAttribute(CPContentWebKeys.CP_CONTENT_HELPER);
CPCatalogEntry cpCatalogEntry = cpContentHelper.getCPCatalogEntry(request);
CProduct cprod = CProductLocalServiceUtil.getCProduct(cpCatalogEntry.getCProductId());

CPSku cpSku = cpContentHelper.getDefaultCPSku(cpCatalogEntry);
long cpDefinitionId = cpCatalogEntry.getCPDefinitionId();
long skuId = 0;
if (cpSku != null) {
	skuId = cpSku.getCPInstanceId();
}

Product product = ProductLocalServiceUtil.findByCPDefinitionId(cpDefinitionId);
String modelNumber = product.getModelNumber();
String organizationName = "";

if(product.getOrganizationName() != "" && !product.getOrganizationName().equalsIgnoreCase("null")){
	organizationName = product.getOrganizationName();
} else {
	organizationName = "NA";
}

CPDefinition cpDefinition=CPDefinitionLocalServiceUtil.getCPDefinition(cpDefinitionId);

CPContentSkuOptionsHelper cpContentSkuOptionsHelper = (CPContentSkuOptionsHelper)request.getAttribute(CPContentWebKeys.CP_CONTENT_SKU_OPTIONS_HELPER);

List<CPInstance> cpInstanceList=CPDefinitionLocalServiceUtil.getCPDefinition(cpCatalogEntry.getCPDefinitionId()).getCPInstances();
CPInstance cpInstance=cpInstanceList.stream().filter(CPInstance::isApproved).collect(Collectors.minBy(Comparator.comparing(CPInstance::getPrice))).get();
	
String brandName="";
AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(CPDefinition.class.getName(), cpDefinition.getCPDefinitionId());
List<AssetEntryAssetCategoryRel> assetEntryAssetCategoryRelList=AssetEntryAssetCategoryRelLocalServiceUtil.getAssetEntryAssetCategoryRelsByAssetEntryId(assetEntry.getEntryId());
	for(AssetEntryAssetCategoryRel assetCategoryRel : assetEntryAssetCategoryRelList){
		AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(assetCategoryRel.getAssetCategoryId());
    	AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getVocabulary(assetCategory.getVocabularyId());
    	if(assetVocabulary.getName().equalsIgnoreCase("select brand")){
    		brandName=assetCategory.getName();
    	}
    }
	
%>

<section class="productDetailPage">
      <div class="container">
       <div class="row">
          <div class="col-md-4">
          	<div>
                 <commerce-ui:gallery
				CPDefinitionId="<%= cpDefinitionId %>"
				namespace="<%= "_com_liferay_commerce_product_content_web_internal_portlet_CPContentPortlet" %>"
			/>
			</div>
          </div>
         
          <div class="col-md-5">
            <div class="productDataDetail">
            
              <div class="brandName">Brand: <%= brandName %></div>
             
              <h3 class="productTitle">
              	<a href="#">
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
              <p class="productDescription">${cpCatalogEntry.getShortDescription()}</p>
            </div>


		<liferay-util:dynamic-include key="com.liferay.commerce.product.type.grouped.web#/grouped_product_type.jsp#" />
            <div class="priceDetailPage">
            
              <div class="priceProduct">
                
            	<commerce-ui:price
						CPCatalogEntry="<%= cpCatalogEntry %>"
						namespace="<%= "_com_liferay_commerce_product_content_web_internal_portlet_CPContentPortlet_" %>"
						showDefaultSkuPrice="<%= true %>"
					/>
				
				<liferay-commerce:tier-price
					CPInstanceId="<%= cpSku.getCPInstanceId() %>"
					taglibQuantityInputId='<%= "_com_liferay_commerce_product_content_web_internal_portlet_CPContentPortlet_"+ cpDefinitionId + "Quantity" %>'
				/>
				
				<span class="discountText d-none"></span>
				</div>
				
	              <div class="inStock">
	              			<!-- <img src="/o/buycorp-classic-theme/images/icon/icon-tick.svg" alt="">In stock -->
	              			<%
								String stockQuantity = cpContentHelper.getStockQuantity(request);
	              				//System.out.println("stockQuantity--> " + stockQuantity);
								%><commerce-ui:availability-label
								CPCatalogEntry="<%= cpCatalogEntry %>"
							/>
				 </div>
              
            </div>
            
				<%
					boolean hasReplacement = cpContentHelper.hasReplacement(cpSku, request);
				%>
				<%
					String hideCssClass = StringPool.BLANK;

					if (hasReplacement) {
						hideCssClass = "hide";
					}
				%>
				
            <div class="skuInfo">
              <div class="skuId <%= hideCssClass %>" data-text-cp-instance-sku>
					<span class="font-weight-semi-bold">
					SKU ID:
						<%-- <liferay-ui:message arguments="<%= StringPool.BLANK %>" key="sku-x" /> --%>
					</span>
					<span>
						<%= (cpSku == null) ? StringPool.BLANK : HtmlUtil.escape(cpSku.getSku()) %>
					</span>
				</div>
				
				<div class="variantList">
					<commerce-ui:option-selector
					CPDefinitionId="<%= cpCatalogEntry.getCPDefinitionId() %>"
					namespace="<%= "_com_liferay_commerce_product_content_web_internal_portlet_CPContentPortlet" %>"
					/>
				</div>
            </div>
            </div>

          <div class="col-md-3">
            <div class="borderBox vendorInfo">
                <div class="vendorName">
                   <span class="sortName"><img width="100%" src="${imagePath}" alt=""></span>
                   <p>${vendorName} <br><%= organizationName %></p>
                </div>
                <ul> 
                  <%-- <li><img src="/o/buycorp-classic-theme/images/icon/icon-india-flag.svg" alt="">${shippingAddressCity }, ${shippingAddressCountry}</li> --%>
                  <li><img src="/o/buycorp-classic-theme/images/icon/icon-india-flag.svg" alt="">India</li>
                  <li><img src="/o/buycorp-classic-theme/images/icon/icon-verified-user.svg" alt="">Verified Seller</li>
                  <li><img src="/o/buycorp-classic-theme/images/icon/icon-worldwide.svg" alt="">Worldwide shipping</li>
                </ul>
            </div>

            <div class="borderBox cartQuantity">
                <c:if test="${isLoggedUser == true}">
                    <commerce-ui:add-to-cart
                        alignment="left"
                        CPCatalogEntry="<%= cpCatalogEntry %>"
                        inline="<%= true %>"
                        namespace="<%= liferayPortletResponse.getNamespace() %>"
                        size="lg"
                        skuOptions="<%= cpContentSkuOptionsHelper.getDefaultCPInstanceSkuOptions(cpCatalogEntry.getCPDefinitionId(), request) %>"
                    />
				    <button type="button" onclick="buyNow()" class="btn btn-outline-secondary bigButton w-100 buyNowButton"><%if(!themeDisplay.isSignedIn()){%> <%} %> BUY NOW</button>
				</c:if>

				 <div class="wishlistCompare">
                     <button type="button" class="btn btn-link wishlistBtn"><img src="/o/buycorp-classic-theme/images/icon/icon-wishlist.svg" alt=""> Wishlist</button>

                     <liferay-util:dynamic-include key="com.liferay.commerce.product.type.virtual.web#/virtual_product_type.jsp#" />
                    <commerce-ui:compare-checkbox
                        CPCatalogEntry="<%= cpCatalogEntry %>"
                        label='Add to Compare'
                    />
				</div> 
                </div> 

              <!-- <div class="wishlistCompare"> -->
<%--               <commerce-ui:add-to-wish-list --%>
<%-- 					CPCatalogEntry="<%= cpCatalogEntry %>" --%>
<%-- 					large="<%= true %>" --%>
<%-- 				/> --%>
<!-- 				<liferay-util:dynamic-include key="com.liferay.commerce.product.type.virtual.web#/virtual_product_type.jsp#" /> -->
<%-- 			<commerce-ui:compare-checkbox --%>
<%-- 					CPCatalogEntry="<%= cpCatalogEntry %>" --%>
<%-- 					label="" --%>
<%-- 				/> --%>
                <!-- <button type="button" class="btn btn-link wishlistBtn"><img src="images/icon/icon-wishlist.svg" alt=""> Wishlist</button> -->
                
              <!-- </div> -->
 </div>
            </div>
          </div>
       </div>
      </div>
</section>

<!-- Start Product Description -->
<section class="productDescriptionSection">
  <div class="container">
      <!-- Tab -->
      <ul class="nav nav-tabs">
        <li class="nav-item">
          <a class="nav-link active" data-toggle="tab" href="#description">Description</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="tab" href="#specification">Specification</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="tab" href="#additionalInformation">Additional Information</a>
        </li>
       <!--  <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#returnPolicy">Return Policy</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" data-toggle="tab" href="#deliveryOptions">Delivery Options</a>
          </li> -->
      </ul>

      <!-- Tab content -->
      <div class="tab-content">
        <div class="tab-pane active" id="description">
            <p><%=cpCatalogEntry.getDescription() %></p>

        </div>
        <div class="tab-pane fade" id="specification">
			<table class="table table-bordered pdpTable">                                
	            <tbody>
	               <%
						List<CPDefinitionSpecificationOptionValue> cpDefinitionSpecificationOptionValuesList = cpDefinition.getCPDefinitionSpecificationOptionValues();
						Map<String, List<String>> specificationValuesMap = new HashMap<>();
						for (CPDefinitionSpecificationOptionValue CPDefinitionSpecificationOptionValue : cpDefinitionSpecificationOptionValuesList) {
						    String specificationTitle = CPSpecificationOptionLocalServiceUtil.getCPSpecificationOption(CPDefinitionSpecificationOptionValue
						    		.getCPSpecificationOptionId()).getTitle(themeDisplay.getLocale());
						    String specificationValue = CPDefinitionSpecificationOptionValue.getValue(themeDisplay.getLocale());
						    
						    if (specificationValuesMap.containsKey(specificationTitle)) {
						        specificationValuesMap.get(specificationTitle).add(specificationValue);
						    } else {
						        List<String> valuesList = new ArrayList<>();
						        valuesList.add(specificationValue);
						        specificationValuesMap.put(specificationTitle, valuesList);
						    }
						}
						
						for (List<String> valuesList : specificationValuesMap.values()) {
						    Collections.sort(valuesList);
						}
						
						for (Map.Entry<String, List<String>> entry : specificationValuesMap.entrySet()) {
						    String specificationTitle = entry.getKey();
						    List<String> values = entry.getValue();
						%>  
						    <tr>
						        <th><%= specificationTitle %></th>
						        <td><%= String.join(", ", values) %></td>
						    </tr>
						<% } %>
						
	            </tbody>
			</table> 
		</div>
        
        <div class="tab-pane fade" id="additionalInformation">
            <table class="table table-bordered pdpTable">
            	<tbody>
            		<%
            			CPTaxCategory cpTaxCategory = CPTaxCategoryLocalServiceUtil.getCPTaxCategory(cpDefinition.getCPTaxCategoryId());
            		%>
            		<tr>
            			<th>Tax Category</th>
            			<td><%= cpTaxCategory.getName(themeDisplay.getLocale()) %></td>
            		</tr>
            		<%
            			List<ProductSearchKeywords> productSearchKeywords = ProductSearchKeywordsLocalServiceUtil
            					.findByDraftProductId(product.getDraftProductId());
            			List<String> searchKeywords = new ArrayList<>();
            			for(ProductSearchKeywords productSearchKeyword : productSearchKeywords) {
            				searchKeywords.add(productSearchKeyword.getSearchKeyword());
            			}
            			
            			if(!searchKeywords.isEmpty()) {
            		%>
            			<tr>
	            			<th>Keywords</th>
	            			<td><%= String.join(", ", searchKeywords) %></td>
	            		</tr>
            		<%
            			}
            			
            			List<ProductPackageContent> productPackageContents = ProductPackageContentLocalServiceUtil
            					.findByDraftProductId(product.getDraftProductId());
            			List<String> packageContents = new ArrayList<>();
            			for(ProductPackageContent productPackageContent : productPackageContents) {
            				packageContents.add(productPackageContent.getItemName() + " x " + productPackageContent.getItemQuantity());
            			}
            		%>
            		<tr>
            			<th>Package/Service Content</th>
            			<td><%= String.join(", ", packageContents) %></td>
            		</tr>
            	</tbody>
            </table>
        </div>
<!--         <div class="tab-pane fade" id="returnPolicy">
          <p>Return Policy</p>
        </div>
        <div class="tab-pane fade" id="deliveryOptions">
            <p>Delivery Options</p>
        </div> -->
      </div>
  </div>
</section>
<!-- End Product Description -->

<style>
.priceProduct > span .discountText {display: block !important;}
</style>

<script>

//Function to be called when text content changes
// Select the target node
var targetNode = document.querySelector('.skuId span:nth-child(2)');

// Function to create and configure a MutationObserver
function observeChanges() {
    // Callback function to execute when mutations are observed
  //  debugger
    var callback = function(mutationsList, observer) {
        for(var mutation of mutationsList) {
            if (mutation.type === 'childList') {
                // If child nodes have been added or removed, call the discountFunction
                discountFunction();
                setTimeout(function () {
            		checkAddToCartButton();
                }, 800);
            }
        }
    };

    // Create an observer instance linked to the callback function
    var observer = new MutationObserver(callback);

    // Start observing the target node for changes
    observer.observe(targetNode, { childList: true });
}

observeChanges();

function discountFunction(){
	var listPriceElement = document.querySelector(".price-value-inactive");
	var promoPriceElement = document.querySelector(".price-value-promo");

	// Parse prices to floating-point numbers
	var listPrice = parseFloat(listPriceElement.innerText.trim().replace(/[^\d.-]/g, ''));
	var promoPrice = parseFloat(promoPriceElement.innerText.trim().replace(/[^\d.-]/g, ''));

	// Calculate discount percentage
	var discountPercentage = 0;
	if (!isNaN(listPrice) && !isNaN(promoPrice) && listPrice > 0) {
	    discountPercentage = ((listPrice - promoPrice) / listPrice) * 100;
	}
	
	$(".discountText").html(" (" + discountPercentage.toFixed(2) + " %) Off")
	
}

function checkAddToCartButton() {
    var addToCartButton = document.querySelector('.btn-add-to-cart');
    var buyNowButton = document.querySelector('.buyNowButton');

    if (addToCartButton.disabled) {
        buyNowButton.style.display = 'none';
        //addToCartButton.style.display = 'none';

    } else {
        buyNowButton.style.display = 'block'; 
    }
}

function buyNow(){
	$(".btn-add-to-cart").click();
	setTimeout(function () {
		window.location.href = "<%= themeDisplay.getPortalURL()+themeDisplay.getPathFriendlyURLPublic()+ themeDisplay.getLayout().getGroup().getFriendlyURL()+"/cart"%>";
	}, 1000);
}

$(window).on('load', function() {
	discountFunction();
	setTimeout(function () {
		$(".discountText").appendTo(".priceProduct > span");
		checkAddToCartButton();
    }, 800);
	
});

</script>  

