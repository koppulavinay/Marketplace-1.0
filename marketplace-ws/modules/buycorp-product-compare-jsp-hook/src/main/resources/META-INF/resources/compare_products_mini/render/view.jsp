<%--
/**
 * SPDX-FileCopyrightText: (c) 2000 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
--%>

<%@ include file="/init.jsp" %>
<portlet:resourceURL id="categoryCheck" var="categoryCheckURL" />

<%
CPCompareContentHelper cpCompareContentHelper = (CPCompareContentHelper)request.getAttribute(CPContentWebKeys.CP_COMPARE_CONTENT_HELPER);

CommerceContext commerceContext = (CommerceContext)request.getAttribute(CommerceWebKeys.COMMERCE_CONTEXT);

long commerceAccountId = CommerceUtil.getCommerceAccountId(commerceContext);

List<CPCatalogEntry> cpCatalogEntries = cpCompareContentHelper.getCPCatalogEntries(commerceContext.getCommerceChannelGroupId(), commerceAccountId, request);
%>


<div class="container">
  <!-- Modal -->
  <div class="modal fade" id="sameCategoryModel" role="dialog">
    <div class="modal-dialog modal-dialog-centered">
    
      <!-- Modal content-->
      <div class="modal-content">
      	<button type="button" class="close" data-dismiss="modal"></button>
        <div class="modal-header">
          <h4 class="modal-title">Comparsion not allowed</h4>
        </div>
        <div class="modal-body">
          <p>You cannot compare product of different category</p>
        </div>
        <!-- <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div> -->
      </div>
      
    </div>
  </div>
  
</div>

<div id="mini-compare-root"></div>

<aui:script require="commerce-frontend-js/components/mini_compare/entry as MiniCompare">
	MiniCompare.default('mini-compare', 'mini-compare-root', {
		commerceChannelGroupId:
			'<%= commerceContext.getCommerceChannelGroupId() %>',
		compareProductsURL:
			'<%= cpCompareContentHelper.getCompareProductsURL(themeDisplay) %>',
		items: [

			<%
			for (CPCatalogEntry cpCatalogEntry : cpCatalogEntries) {
			%>

				{
					id: '<%= cpCatalogEntry.getCPDefinitionId() %>',
					thumbnail:
						'<%= cpCompareContentHelper.getDefaultImageFileURL(commerceAccountId, cpCatalogEntry.getCPDefinitionId()) %>',
				},

			<%
			}
			%>

		],
		itemsLimit: <%= cpCompareContentHelper.getProductsLimit(portletDisplay) %>,
		portletNamespace:
			'<%= cpCompareContentHelper.getCompareContentPortletNamespace() %>',
		spritemap: '<%= themeDisplay.getPathThemeSpritemap() %>',
	});
	
	$(document).ready(function(){
	   $('.mini-compare-item').each(function() {
	      var observer = new MutationObserver(function(mutations) {
	        mutations.forEach(function(mutation) {
	          if ($(mutation.target).hasClass('mini-compare-item') && $(mutation.target).hasClass('active')) {
	           fetchCategory();
	          }
	        });
	      });
	
	      observer.observe(this, { attributes: true, attributeFilter: ['class'] });
	    });
  });
  
	function getCookieValue(cookieName) {
	    var cookies = document.cookie.split(';');
	 	for (var i = 0; i < cookies.length; i++) {
	        var cookieParts = cookies[i].split('=');
	        var name = cookieParts[0].trim();
	        var value = cookieParts[1];
	        if (name.includes(cookieName)) {
	            return value;
	        }
	    }
	    return null;
  	}
	
	function fetchCategory() {
	 var cookiedata = getCookieValue('COMMERCE_COMPARE_cpDefinitionIds_');
	    $.ajax({
	        url: '${categoryCheckURL}',
	        type: 'POST',
	        data: { <portlet:namespace/>cookiedata: cookiedata },
	        success: function(data) {
	            console.log("success ");
	            var dataObject = JSON.parse(data);
	          var sameCategories = dataObject.sameCategory;
	          if(sameCategories === false){
	          	for(let i=0;i<3;i++){
	          		$(".mini-compare-delete:first").trigger("click");
	          	}
	          	 	$("#sameCategoryModel").modal("toggle");
	          }
	            },
	        error: function(xhr, status, error) {
	            console.log(error);
	        }
	    });
	}
	
</aui:script>

