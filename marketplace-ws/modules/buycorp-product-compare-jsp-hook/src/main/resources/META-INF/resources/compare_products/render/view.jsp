<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@page import="java.util.stream.Collectors"%>
<%@page import="java.util.Locale"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.marketplace.product.master.service.ProductLocalServiceUtil"%>
<%@page import="com.marketplace.product.master.model.Product"%>
<%@page import="com.buycorp.common.util.CompareUtil"%>
<%@ include file="/init.jsp" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.commerce.product.catalog.CPSku"%>
<%-- <%@ page import="com.liferay.commerce.product.internal.catalog.CPSkuImpl" %> --%>
<%@page import="com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil"%>
<%@page import="com.liferay.asset.entry.rel.model.AssetEntryAssetCategoryRel"%>
<%@page import="com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetEntry"%>
<%@page import="com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.commerce.product.model.CPDefinition"%>
<%@page import="com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.asset.kernel.model.AssetVocabulary"%>
<%@page import="com.liferay.asset.kernel.model.AssetCategory"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.Collections"%>
<%@page import="com.liferay.commerce.product.model.CPInstance"%>
<%@page import="com.liferay.commerce.product.service.CPDefinitionLocalServiceUtil"%>
<%@page import="java.math.BigDecimal"%>
<%@ page import="com.liferay.commerce.product.service.CPInstanceLocalServiceUtil" %>
<%@ page import="java.lang.Long" %>
<%@ page import="com.liferay.commerce.product.service.CPDefinitionOptionRelLocalServiceUtil" %>
<%@ page import ="com.liferay.commerce.product.model.CPDefinitionOptionRel" %>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%
CPCompareContentHelper cpCompareContentHelper = (CPCompareContentHelper)request.getAttribute(CPContentWebKeys.CP_COMPARE_CONTENT_HELPER);

CPDataSourceResult cpDataSourceResult = (CPDataSourceResult)request.getAttribute(CPWebKeys.CP_DATA_SOURCE_RESULT);

List<CPCatalogEntry> cpCatalogEntries = cpDataSourceResult.getCPCatalogEntries();
long categoryId = 0L;

if(!cpCatalogEntries.isEmpty()) {
	AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(CPDefinition.class.getName(), cpCatalogEntries.get(0).getCPDefinitionId());
	//System.out.println("Asset Entry " + assetEntry);
	List<AssetEntryAssetCategoryRel> assetEntryAssetCategoryRelList = AssetEntryAssetCategoryRelLocalServiceUtil.getAssetEntryAssetCategoryRelsByAssetEntryId(assetEntry.getEntryId());
	for(AssetEntryAssetCategoryRel assetCategoryRel : assetEntryAssetCategoryRelList){
		AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(assetCategoryRel.getAssetCategoryId());
		AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getVocabulary(assetCategory.getVocabularyId());
		
		if(assetVocabulary.getName().equalsIgnoreCase("select category")){
	  		categoryId=assetCategory.getCategoryId();
	  		//System.out.println(categoryId);
	  	}
		
	}
	List<AssetEntryAssetCategoryRel> assetEntryCategory = AssetEntryAssetCategoryRelLocalServiceUtil.getAssetEntryAssetCategoryRelsByAssetCategoryId(categoryId);
	
	CPInstance minPriceCPInstance = null;
	BigDecimal minPrice = BigDecimal.valueOf(Double.MAX_VALUE); // Initialize with the maximum possible value
	
	for (AssetEntryAssetCategoryRel assetCategoryRel : assetEntryCategory) {
	    AssetEntry assetEntry1 = AssetEntryLocalServiceUtil.getEntry(assetCategoryRel.getAssetEntryId());
	    CPDefinition cpDefinition = CPDefinitionLocalServiceUtil.getCPDefinition(assetEntry1.getClassPK());
	    if(cpDefinition.getStatus() == WorkflowConstants.STATUS_APPROVED) {
		    List<CPInstance> cpInstanceList = CPDefinitionLocalServiceUtil.getCPDefinition(cpDefinition.getCPDefinitionId()).getCPInstances();
		    for (CPInstance cpInstance : cpInstanceList) {
		        if (cpInstance.isApproved() && cpInstance.getPrice().compareTo(minPrice) < 0) {
		            minPrice = cpInstance.getPrice();
		            minPriceCPInstance = cpInstance;
		        }
		    }
	    }
	}
	//System.out.println("True or false :::::: " + CompareUtil.compareCPDefinitionIds(cpCatalogEntries,assetEntryCategory));
	if( CompareUtil.compareCPDefinitionIds(cpCatalogEntries,assetEntryCategory)){
		final CPDefinition cpDefinition1 = CPDefinitionLocalServiceUtil.getCPDefinition(minPriceCPInstance.getCPDefinitionId());
		CPCatalogEntry cpCatalogEntry1 = CompareUtil.getCpCatalogEntry(cpDefinition1,minPriceCPInstance,languageId);
		cpCatalogEntries.add(0, cpCatalogEntry1);
	}
}

Set<String> cpDefinitionOptionRelTitles = cpCompareContentHelper.getCPDefinitionOptionRelNames(cpDataSourceResult, locale);
Set<CPSpecificationOption> cpSpecificationOptions = cpCompareContentHelper.getCPSpecificationOptions(cpDataSourceResult);
Set<CPSpecificationOption> categorizedCPSpecificationOptions = cpCompareContentHelper.getCategorizedCPSpecificationOptions(cpDataSourceResult);
List<CPOptionCategory> cpOptionCategories = cpCompareContentHelper.getCPOptionCategories(company.getCompanyId());

%>

<c:if test="<%= !cpCatalogEntries.isEmpty() %>">
	<div class="container">
		<div class="table-responsive">
			<table class="products-comparison-table table table-autofit table-bordered table-list table-nowrap entries-<%= cpCatalogEntries.size() %>">
				<thead>
					<tr>
						<td></td>
		
						<%
						for (CPCatalogEntry cpCatalogEntry : cpCatalogEntries) {
							
							String productName = "";
							String brandName = "";
							CPContentHelper cpContentHelper = (CPContentHelper)request.getAttribute(CPContentWebKeys.CP_CONTENT_HELPER);
							String productDetailURL = cpContentHelper.getFriendlyURL(cpCatalogEntry, themeDisplay);
							boolean hasMultipleCPSkus = cpContentHelper.hasMultipleCPSkus(cpCatalogEntry);
							
							AssetEntry asset = AssetEntryLocalServiceUtil.fetchEntry(CPDefinition.class.getName(), cpCatalogEntry.getCPDefinitionId());
							List<AssetEntryAssetCategoryRel> assetEntryAssetCategoryRelLists = AssetEntryAssetCategoryRelLocalServiceUtil
									.getAssetEntryAssetCategoryRelsByAssetEntryId(asset.getEntryId());
							
							for(AssetEntryAssetCategoryRel assetCategoryRel : assetEntryAssetCategoryRelLists){
								AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(assetCategoryRel.getAssetCategoryId());
						    	AssetVocabulary assetVocabulary = AssetVocabularyLocalServiceUtil.getVocabulary(assetCategory.getVocabularyId());
						    	if(assetVocabulary.getName().equalsIgnoreCase("select brand")){
						    		brandName=assetCategory.getName();
						    	}
						    }
							
							Product product = ProductLocalServiceUtil.findByCPDefinitionId(cpCatalogEntry.getCPDefinitionId());
							if(product.getModelNumber() != "") {
								productName = cpCatalogEntry.getName() + " - " + product.getModelNumber();
							} else {
								productName = cpCatalogEntry.getName();
							}
							
							List<CPInstance> cpInstanceLists = CPDefinitionLocalServiceUtil.getCPDefinition(cpCatalogEntry.getCPDefinitionId()).getCPInstances();
							CPInstance cpInstance = cpInstanceLists.stream().filter(CPInstance::isApproved).collect(Collectors.minBy
									(Comparator.comparing(CPInstance::getPrice))).get();
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
		
							<td class="table-cell-expand">
							<div class="productData">
								<div class="brandName"><%= brandName %></div>
								<div class="productTitle"><a style="display:block !important" href="<%=productDetailURL%>"><%= productName %></a></div>
								<div class="productDescription"><%= cpCatalogEntry.getShortDescription() %></div>
							</div>
						<%
							if(!hasMultipleCPSkus) {
						%>
							<span class="greenColor">(<%= formattedPercentageDiscount %>% off)</span>
						<%
							}
						%>
								<liferay-commerce-product:product-list-entry-renderer
									CPCatalogEntry="<%= cpCatalogEntry %>"
								/>
							</td>
		
						<%
						}
						%>
		
					</tr>
				</thead>
		
				<tbody>
					<%-- <c:if test="<%= !cpDefinitionOptionRelTitles.isEmpty() %>">
						<tr>
							<td colspan="<%= cpCatalogEntries.size() + 1 %>">
								<liferay-ui:message key="options" />
							</td>
						</tr>
		
						<%
						for (String cpDefinitionOptionRelTitle : cpDefinitionOptionRelTitles) {
						%>
		
							<tr>
								<td>
									<%= HtmlUtil.escape(cpDefinitionOptionRelTitle) %>
								</td>
		
								<%
								for (CPCatalogEntry cpCatalogEntry : cpCatalogEntries) {
								%>
		
									<td class="table-cell-expand">
										<%= HtmlUtil.escape(cpCompareContentHelper.getCPDefinitionOptionValueRels(cpCatalogEntry, cpDefinitionOptionRelTitle, locale)) %>
									</td>
		
								<%
								}
								%>
		
							</tr>
		
						<%
						}
						%>
		
					</c:if> --%>
		
					<c:if test="<%= !cpSpecificationOptions.isEmpty() %>">
						<tr class="table-divider">
							<th>
								<liferay-ui:message key="specifications" />
							</th>
							<td colspan="<%= cpCatalogEntries.size() %>"></td>
						</tr>
		
						<%
						for (CPSpecificationOption cpSpecificationOption : cpSpecificationOptions) {
						%>
		
							<tr>
								<th>
								
									<%= HtmlUtil.escape(cpSpecificationOption.getTitle(languageId)) %>
								</th>
		
								<%
								for (CPCatalogEntry cpCatalogEntry : cpCatalogEntries) {
								%>
		
									<td class="table-cell-expand">
								
										<%= HtmlUtil.escape(cpCompareContentHelper.getCPDefinitionSpecificationOptionValue(
												cpCatalogEntry.getCPDefinitionId(), cpSpecificationOption.getCPSpecificationOptionId(), locale)) %>
									</td>
		
								<%
								}
								%>
		
							</tr>
		
						<%
						}
						%>
		
					</c:if>
		
					<%
					for (CPOptionCategory cpOptionCategory : cpOptionCategories) {
					%>
		
						<c:if test="<%= cpCompareContentHelper.hasCategorizedCPDefinitionSpecificationOptionValues(cpDataSourceResult, 
								cpOptionCategory.getCPOptionCategoryId()) %>">
							<tr class="table-divider">
								<td colspan="<%= cpCatalogEntries.size() + 1 %>">
									<%= HtmlUtil.escape(cpOptionCategory.getTitle(languageId)) %>
								</td>
							</tr>
		
							<%
							for (CPSpecificationOption cpSpecificationOption : categorizedCPSpecificationOptions) {
								if (cpSpecificationOption.getCPOptionCategoryId() != cpOptionCategory.getCPOptionCategoryId()) {
									continue;
								}
							%>
		
								<tr>
									<td>
										<%= HtmlUtil.escape(cpSpecificationOption.getTitle(languageId)) %>
									</td>
		
									<%
									for (CPCatalogEntry cpCatalogEntry : cpCatalogEntries) {
									%>
		
										<td class="table-cell-expand">
											<%= HtmlUtil.escape(cpCompareContentHelper.getCPDefinitionSpecificationOptionValue(
													cpCatalogEntry.getCPDefinitionId(), cpSpecificationOption.getCPSpecificationOptionId(), locale)) %>
										</td>
		
									<%
									}
									%>
		
								</tr>
		
							<%
							}
							%>
		
						</c:if>
		
					<%
					}
					%>
		
				</tbody>
			</table>
		</div>
	</div>
</c:if>

<script>

$(document).ready(function() {
	 $('.products-comparison-table td .cp-information .card-text .flex-row.text-truncate').addClass('priceProduct');
});

$(window).on('load', function() {
	$('td').each(function() {
	    $(this).find('.productData').appendTo($(this).find('.cp-information'));
	    $(this).find('.greenColor').appendTo($(this).find('.price.compact'));
	});
});

</script>
