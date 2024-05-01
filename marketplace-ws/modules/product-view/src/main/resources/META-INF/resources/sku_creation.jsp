<%@ include file="/init.jsp" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<portlet:actionURL var="skuInfoActionURL" name="<%= ProductViewPortletKeys.SELECT_SKU_ACTION_CMD %>" />
<liferay-portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName" value="skuCreationRender" />
	<portlet:param name="draftProductId" value="${product.draftProductId}" />
</liferay-portlet:renderURL>

 <portlet:actionURL var="skuInfoActionURL"
	name="<%=ProductViewPortletKeys.SELECT_SKU_ACTION_CMD%>" />
	
 <%-- <portlet:actionURL var="nextURL"
	name="<%=ProductViewPortletKeys.SELECT_REDIRECT_SKU_ACTION_CMD%>" /> --%>

<portlet:renderURL var="variantURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=ProductViewPortletKeys.VARIANT_CREATION_RENDER%>" />
	<portlet:param name="draftProductId" value="${draftProductId}" />
</portlet:renderURL>

<portlet:renderURL var="nextURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=ProductViewPortletKeys.ADDITIONAL_INFORMATION_RENDER_CMD%>" />
	<portlet:param name="draftProductId" value="${draftProductId}" />
	<portlet:param name="skuSuccessKey" value="sku-success-key" />
</portlet:renderURL>

<portlet:renderURL var="specificationURL">
	<portlet:param name="mvcRenderCommandName"
		value="/select/specifications/render" />
	<portlet:param name="draftProductId" value="${draftProductId}" />
</portlet:renderURL>

<portlet:renderURL var="productInfoURL">
	<portlet:param name="mvcRenderCommandName"
		value="/basic/information/render" />
	<portlet:param name="draftProductId" value="${draftProductId}" />
</portlet:renderURL>

<portlet:renderURL var="brandCategoryURL">
	<portlet:param name="mvcRenderCommandName" value="/brand/category/select/render" />
	<portlet:param name="draftProductId" value="${draftProductId}" />
</portlet:renderURL>

<liferay-ui:success key="variant-key" message="Variant Details Saved Successfully!" />

<div class="container">
	<div class="addProductTitle">
		<h1 class="titlePage mt-4">Product Creation</h1>
		<div>
			<%@ include file="/last_modified_date.jsp"%>
			<button type="button" class="btn btn-outline-secondary"
				onclick="saveAsDraft(this.form);">Save as draft</button>
		</div>
	</div>
</div>
<input type="hidden" id="<portlet:namespace/>productStatus" name="<portlet:namespace/>productStatus" value="" />
<input type="hidden" id="<portlet:namespace/>stepNumber" name="<portlet:namespace/>stepNumber" value="5" />

<div class="container">
    <div class="customform stepperCustomform mb-4">
    <section class="steperBar">
        <div class="container">
            <div class="stepper-wrapper">
                <div class="stepper-item completed">
                    <div class="step-counter">
                        <a href="${brandCategoryURL}">1</a>
                    </div>
                    <div class="step-name">Category and Brand</div>
                </div>
                <div class="stepper-item completed">
                    <div class="step-counter">
                        <a href="${productInfoURL}">2</a>
                    </div>
                    <div class="step-name">Product Information</div>
                </div>
                <div class="stepper-item completed">
                    <div class="step-counter">
                        <a href="${specificationURL}">3</a>
                    </div>
                    <div class="step-name">Specification</div>
                </div>
                <div class="stepper-item completed">
                    <div class="step-counter">
                        <a href="${variantURL}">4</a>
                    </div>
                    <div class="step-name">Variant Creation</div>
                </div>
                <div class="stepper-item active">
                    <div class="step-counter">5</div>
                    <div class="step-name">SKU</div>
                </div>
                <div class="stepper-item">
                    <div class="step-counter">6</div>
                    <div class="step-name">Additional Configuration</div>
                </div>
                <!-- <div class="stepper-item">
                    <div class="step-counter">7</div>
                    <div class="step-name">Product Summary</div>
                </div> -->
            </div>
        </div>
    </section>

    <h2 class="h2Form">Add SKU Details</h2>
<div id="divgloid" style="display:none;" class="card-title errorMsg"></div>
        <div id="accordion" class="skuAccordion">
               <c:if test="${variantPermutations.size() > 0}">
                  <c:forEach var="variantPermutations" items="${variantPermutations}" varStatus="counter">
                    <form method="post" action="${skuInfoActionURL}"
                    id="myForm${variantPermutations.productSKUId}"
                    name="myForm${variantPermutations.productSKUId}"
                    enctype="multipart/form-data">
                 
                
                    <input type="hidden" name="productskuId" value="${variantPermutations.productSKUId}" />
                    <input type="hidden" name="draftProductId" value="${variantPermutations.draftProductId}" />
                    
                    <div class="card">
                            <div class="card-header" id="heading${variantPermutations.productSKUId}">
                                <a class="card-link collapsed" data-toggle="collapse" href="#collapse${counter.count}" aria-expanded="false" aria-controls="collapse${variantPermutations.productSKUId}">
                                ${variantPermutations.skuCreationName}
                                <i class="fas fa-chevron-down"></i>
                            	</a>
                        	</div>

                        <div id="collapse${counter.count}" class="collapse" aria-labelledby="heading${variantPermutations.productSKUId}" data-parent="#accordion">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-lg-12">
                        
                         <button type="button" id="remove${variantPermutations.productSKUId}" onClick="removeSkuDetails('${variantPermutations.productSKUId}','${variantPermutations.draftProductId}');" class="btn btn-link text-danger removeSkuDetails"><i class="fas fa-trash-alt"></i>SKU Details</button>
                        <!-- Start SKU Details -->
                         <h3 class="h3Form">SKU Details</h3>
                         <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="skuid">SKU Id <span class="requiredStar">*</span></label>
                                    <input type="text" class="form-control" name="skuid" id="skuid" value="${variantPermutations.skuId}" placeholder="SKU" disabled>
                                        <div id="div1_${variantPermutations.productSKUId}" style="display:none;" class="card-title errorMsg"></div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="sellerskuid">Seller SKU Id</label><span class="requiredStar">*</span>
                                    <input type="text" class="form-control" name="sellerskuid" value="${variantPermutations.sellerSkuId}" 
                                    	id="sellerskuid${variantPermutations.productSKUId}" placeholder="Seller Sku Id" oninput="this.value = this.value.replace(/[^a-zA-Z0-9]/g, '')">
                                     <div id="div2_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <div class="custom-control custom-checkbox">
                                        <label>
                                            <c:if test="${variantPermutations.defaultSku == 'on'}">
                                                <input type="checkbox" class="custom-control-input" name="defaultsku" value="on" checked  id="defaultsku${variantPermutations.productSKUId}">
                                               </c:if>
                                              <c:if test = "${variantPermutations.defaultSku != 'on'}">
                                              <input type="checkbox" class="custom-control-input" name="defaultsku" value="off" id="defaultsku${variantPermutations.productSKUId}">
                                              </c:if>
                                          <span class="custom-control-label"><span class="custom-control-label-text">Default SKU</span><span class="requiredStar">*</span></span>
                                        </label>
                                        <div id="div3_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>
                                      </div>

                                </div>
                            </div>
                         </div>

                          
                        </div>
                        <!--end col-->

                        <div class="col-12"><div class="hr"></div></div>

                        <div class="col-lg-12">
                        
                        <!-- Start SKU Price -->
                        <h3 class="h3Form">SKU Price</h3>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="baseprice">Base Price</label><span class="requiredStar">*</span>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                              <span class="input-group-text">&#8377;</span>
                                        </div>
                                        <input type="text" class="form-control" onchange="calculate_decimal('baseprice${variantPermutations.productSKUId}');" name="baseprice" value="<c:out value="${variantPermutations.basePrice eq 0 ? '': variantPermutations.basePrice}"/>" id="baseprice${variantPermutations.productSKUId}" placeholder="Base Price"  maxlength=10 onkeydown="return /^[0-9.,\b]+$/.test(event.key) || (event.keyCode == 8) ;">
                                    </div>
                                    <div id="div4_${variantPermutations.productSKUId}" style="display: none;color:red;" class="card-title errorMsg"></div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="offerprice">Offer Price</label><span class="requiredStar">*</span>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                              <span class="input-group-text">&#8377;</span>
                                        </div>
                                        <input type="text" class="form-control" onchange="calculate_margin('${variantPermutations.productSKUId}');" name="offerprice" value="<c:out value="${variantPermutations.offerPrice eq 0 ? '': variantPermutations.offerPrice}"/>" id="offerprice${variantPermutations.productSKUId}"  maxlength=10 onkeydown="return /^[0-9.,\b]+$/.test(event.key) || (event.keyCode == 8) ;">
                                    </div>
                                    <div id="div5_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>

                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="cost">Cost</label><span class="requiredStar">*</span>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                              <span class="input-group-text">&#8377;</span>
                                        </div>
                                        <input type="text" class="form-control" onchange="calculate_margin('${variantPermutations.productSKUId}');" name="cost" value="<c:out value="${variantPermutations.cost eq 0 ? '': variantPermutations.cost}"/>" id="cost${variantPermutations.productSKUId}" placeholder="Cost"  maxlength=10 onkeydown="return /^[0-9.,\b]+$/.test(event.key) || (event.keyCode == 8) ;">
                                    </div>
                                    <div id="div6_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="margin">Margin</label>
                                    <div class="input-group">
                                        <div class="input-group-prepend">
                                              <span class="input-group-text">&#8377;</span>
                                        </div>
                                        <input type="text" class="form-control" name="margin" value="${variantPermutations.margin}" id="margin${variantPermutations.productSKUId}" placeholder="Margin" disabled>
                                    </div>
                                    <div id="div7_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>
                                </div>
                            </div>
                        </div>

                           
                        </div>
                        <!--end col-->

                        <div class="col-12"><div class="hr"></div></div>

                        
                        <div class="col-lg-12">
                        <!--  Start Inventory -->
                        <h3 class="h3Form">Inventory</h3>

                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="availablestock">Stock Available</label><span class="requiredStar">*</span>
                                    <input type="text" class="form-control" id="availablestock${variantPermutations.productSKUId}" value="<c:out value="${variantPermutations.stock}"/>" name="availablestock" placeholder="SKU"  maxlength=10 onkeydown="return /^[0-9.,\b]+$/.test(event.key) || (event.keyCode == 8) ;">
                                    <div id="div8_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group d-none">
                                    <label for="uom">UOM</label>
                                    <select name="uom" class="form-control" id="uom"   aria-label="Floating label select example">
                                        <option selected="${variantPermutations.uom}">Select UOM</option>
                                      </select>
                                    <div id="div9_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="minumiumqty">Minimum Order Quantity</label><span class="requiredStar">*</span>
                                   
                                    <input type="text" class="form-control" name="minumiumqty"  value="<c:out value="${variantPermutations.minimumOrderQuantity}"/>"  id="minumiumqty${variantPermutations.productSKUId}" placeholder="Minumium Order Quantity"  maxlength=10 onkeydown="return /^[0-9.,\b]+$/.test(event.key) || (event.keyCode == 8) ;">
                                    <div id="div10_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="maximumqty">Maximum  Order Quantity</label><span class="requiredStar">*</span>
                                     
                                    <input type="text" class="form-control" name="maximumqty" value="<c:out value="${variantPermutations.maximumOrderQuantity}"/>" id="maximumqty${variantPermutations.productSKUId}" placeholder="Maximum Order Quantity"  maxlength=10 onkeydown="return /^[0-9.,\b]+$/.test(event.key) || (event.keyCode == 8) ;">
                                    <div id="div11_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group">
                                    <label for="lowstockthreshold">Low Stock Threshold</label><span class="requiredStar">*</span>
                                    <input type="text" name="lowstockthreshold" value="<c:out value="${variantPermutations.lowStockThreshold}"/>" class="form-control" id="lowstockthreshold${variantPermutations.productSKUId}" placeholder="Stock Threshold"  maxlength=10 onkeydown="return /^[0-9.,\b]+$/.test(event.key) || (event.keyCode == 8) ;">
                                    <div id="div12_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>
                                </div>
                            </div>
                        
                        </div>

                            
                        </div>
                        <!--end col-->

                        <div class="col-12 d-none"><div class="hr"></div></div>

                        <div class="col-lg-12 d-none">
                        
                        <!--  start Tax Details -->
                            <h3 class="h3Form">Tax Details</h3>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="tax">Select Tax Details</label>
                                        <select name="tax" class="form-control" id="tax" aria-label="Floating label select example">
                                            <option selected="value="${variantPermutations.tax}"">Select Tax</option>
                                          </select>
                                          <div id="div13_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!--end col-->
                
                        <div class="col-12"><div class="hr"></div></div>	
                        
                        <div class="col-lg-12">
                            <!-- Start Dates -->
                            <h3 class="h3Form">Dates</h3>
                            <div class="row">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="skupublishingdate">SKU Publishing Date</label><span class="requiredStar">*</span>
                                        <input type="date" name="skupublishingdate"  class="form-control" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${variantPermutations.skuPublishingDate}" />" id="${variantPermutations.productSKUId}skupublishingdate" placeholder="SKU Publishing Date">
                                        <div id="div14_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <label for="skuexpirydate">SKU Expiry Date</label><!-- <span class="requiredStar">*</span> -->
                                        <input type="date" name="skuexpirydate" class="form-control" value="<fmt:formatDate pattern = "yyyy-MM-dd" value = "${variantPermutations.skuExpiryDate}" />" id="${variantPermutations.productSKUId}skuexpirydate" placeholder="SKU Expiry Date">
                                        <div id="div15_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div> 
                                    </div>
                                </div>
                            </div>

                        </div>
                        <!--end card-->
                        
                        <div class="col-12"><div class="hr"></div></div>	
                        
                        <div class="col-lg-12">
                            
                            <h3 class="h3Form">Media Upload</h3>
                            
                                     <div class="form-floating">
                                     
                                      <div class="module-section module-rec-image active" >
                                   <div class="f-record-main stop-recording page-photos  page-photos-uploads">

                                            <div class="section-photos55">
                                                <div class="section-photos-inner">
                                                    <div class="items" count="0">
                                                        <div class="item-add">
                                                            
                                                            
                                                            
                                                             <div class="uploadFile">
														        <div class="form-group">
														          <label for="" class="d-block">Upload Product Images</label>
														          <div class="inputFile">
														            <!-- <img src="/o/buycorp-classic-theme/images/icon/icon-upload-files.svg" alt="">Upload Files -->
														            <input type="file"  onchange="loadFile(this,'${variantPermutations.productSKUId}')" multiple="multiple" class="fileInput" name="${variantPermutations.productSKUId}" id="${variantPermutations.productSKUId}" accept="image/*" />
														          </div>
														          <div class="mb-1 mt-1 uploadInfo">(JPG, JPEG, PNG / Max Size: 5 MB)</div>
														          <label for="${variantPermutations.productSKUId}" class="custom-file-upload d-block"></label>
														        </div>
														      </div>
														      <div id="div16_${variantPermutations.productSKUId}" style="display:none;color:red;" class="card-title errorMsg"></div> 
                                                        </div>
                                                        
                                                        <div class="photoMedialist">
	                                                        <c:forEach var="medialst" items="${variantPermutations.productMediaSkuLst}" varStatus="theCount">
	                                                        <div class="item item-${theCount.index}"><div class="item-inner"><img width="75" height="75" id="canvas-image-${medialst.productMediaSKUId}" src="${medialst.imageUrl}"><div class="open-delete"><div class="open-delete-btns"><!-- <span class="open"></span> --><span class="delete">&#10006;</span></div></div></div></div>
	                                                        <%-- <div class="item item-${theCount.index}"><div class="item-inner"><img width="75" height="75" id="canvas-image-${medialst.productMediaSKUId}" src="${medialst.imageUrl}"><div class="open-delete"><div class="open-delete-btns"><!-- <span class="open"></span> --><span class="delete"><i class="fas fa-trash-alt"></i></span></div></div></div></div> --%>
	                                                       </c:forEach>
                                                         </div>
                                                       
                                                        <div  class="item${variantPermutations.productSKUId}">
                                                      
                                                        
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                </div>
                                
                                    </div>
                        </div><!--end col-->
			
						<div class="col-lg-12">
	                       <div class="stepperBarButton">
								<p class="result-json-output"></p>
								<!-- <button type="button" class="btn btn-outline-secondary">Cancel</button> -->
								<button type="submit"
									id="submit${variantPermutations.productSKUId}"
									class="btn btn-primary" >Save SKU Details</button>
									

							</div>
                        </div>
                       <!--end col-->


                            </div>
                      </div>
                  </div>
             </div>
             </form>
          </c:forEach>                      
 </c:if>                                       
                   
           <c:if test="${variantPermutations.size() == 0}">                     
           <div class="col-lg-12">
            <p class="card-title">No Record Exist !</p>
           </div>   
           </c:if>                           
                                        
           <div class="stepperBarButton">
			<a href="${variantURL}" class="btn btn-outline-secondary bigButton">Back</a>
			  <a href="#" id="saveContinueButton" onClick="globalValidation();" class="btn btn-primary bigButton">Save & Continue</a> 

		</div>                     
                                        
	</div>                                 

    </div>
</div>


<script>
  // Get all the checkboxes within the forms
  var checkboxes = document.querySelectorAll('input[type=checkbox][name="defaultsku"]');
  
  // Add event listener to each checkbox
  checkboxes.forEach(function(checkbox) {
    checkbox.addEventListener('change', function() {
      // Uncheck all checkboxes
      checkboxes.forEach(function(cb) {
        if (cb !== checkbox) {
          cb.checked = false;
		  cb.value='off';
        }
      });

      // If checkbox is checked, fetch the selected value
      if (checkbox.checked) {
	  checkbox.value='on';
        console.log("Selected value:", checkbox.value);
      }else{
    	  checkbox.value='off';
          console.log("Selected value:", checkbox.value);  
      }
	  
    });
  });

function removeSkuDetails(productskuId,draftProductId){
	var uid=productskuId+"#"+draftProductId;
	//alert(uid);
	if(uid != ""){
		$.ajax({
			type:"GET",
			url:skuDeleteURL,
			async:false,
			dataType: 'json',
			data:{
				"<portlet:namespace/>uid":uid
			},
			success:function(data){
				
			},
		});
	}
	setTimeout(function(){ window.location.reload(); }, 3000);
}

function getDefaultSkuCount(msg){
	 <c:forEach var="variantPermutations" items="${variantPermutations}" varStatus="counter">
		 var formName="${variantPermutations.productSKUId}";
		 var defaultsku = $("form[name='myForm"+formName+"'] input[name='defaultsku']").val();
		 var statusCount=0;
		// alert(defaultsku);
		 if(defaultsku=='on'){
			// alert("condition");
			 statusCount=statusCount+1;
		 }
	</c:forEach>
	//alert(statusCount);
	if(statusCount>1){
		showErrors(msg,'Multiple Default Sku cannot be Selected !');
		return false;
	} else {
		//alert("else con");
		showErrors(msg,'Default Sku cannot be blank!');
		return false;	
	}
}

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2) 
        month = '0' + month;
    if (day.length < 2) 
        day = '0' + day;

    return [year, month, day].join('-');
}

function globalValidation() {
	 var msg="";
	<c:forEach var="variantPermutations" items="${variantPermutations}" varStatus="counter">
	
    var msg="";
    var editmsg="";
    var defaultSkuOn=0;
    var defaultSkuOff=0;
   <c:forEach var="variantPermutations" items="${variantPermutations}" varStatus="counter">
   
   	   var bdsellerskuid="${variantPermutations.sellerSkuId}";
       var dbdefaultskuid="${variantPermutations.defaultSku}";
       var bdbaseprice="${variantPermutations.basePrice}";
       var bdofferprice="${variantPermutations.offerPrice}";
       var bdcost="${variantPermutations.cost}";
       var bdmargin="${variantPermutations.margin}";
       var bdavailablestock="${variantPermutations.stock}";
       var bdminumiumqty="${variantPermutations.minimumOrderQuantity}";
       var bdmaximumqty="${variantPermutations.maximumOrderQuantity}";
       var bdlowstockthreshold="${variantPermutations.lowStockThreshold}";
       var bdskupublishingdate="${variantPermutations.skuPublishingDate}";
   
       var formName="${variantPermutations.productSKUId}";
       var skuid = $("form[name='myForm"+formName+"'] input[name='skuid']").val();
       var sellerskuid = $("form[name='myForm"+formName+"'] input[name='sellerskuid']").val();
       var defaultsku = $("form[name='myForm"+formName+"'] input[name='defaultsku']").val();
       var baseprice = $("form[name='myForm"+formName+"'] input[name='baseprice']").val();
       var offerprice = $("form[name='myForm"+formName+"'] input[name='offerprice']").val();
       var cost = $("form[name='myForm"+formName+"'] input[name='cost']").val();
       var margin = $("form[name='myForm"+formName+"'] input[name='margin']").val();
       var availablestock = $("form[name='myForm"+formName+"'] input[name='availablestock']").val();
       var minumiumqty = $("form[name='myForm"+formName+"'] input[name='minumiumqty']").val();
       var maximumqty = $("form[name='myForm"+formName+"'] input[name='maximumqty']").val();
       var lowstockthreshold = $("form[name='myForm"+formName+"'] input[name='lowstockthreshold']").val();
       var skupublishingdate = $("form[name='myForm"+formName+"'] input[name='skupublishingdate']").val();
       //var skuexpirydate = $("form[name='myForm"+formName+"'] input[name='skuexpirydate']").val();
       var status=false;
       if(skuid=='' || sellerskuid=='' ||   baseprice=='' || offerprice=='' || cost=='' || margin=='' || availablestock=='' || minumiumqty=='' || maximumqty=='' || lowstockthreshold=='' || skupublishingdate==''){
        status=true;
       } if(bdsellerskuid=='' ||   bdbaseprice=='' || bdofferprice=='' || bdcost=='' || bdmargin=='' || bdskupublishingdate==''){
        msg=msg+ "," + "${variantPermutations.skuCreationName}";
       }if(dbdefaultskuid==''){
    	   dbdefaultskuid='off'; 
       }if(defaultsku=='off'){
    	   defaultSkuOff=defaultSkuOff+1;
       }if(defaultsku=='on'){
    	   defaultSkuOn=defaultSkuOn+1;
       }
     if((dbdefaultskuid=='off')&& (defaultsku=='on' )){
  	   editmsg= "${variantPermutations.skuCreationName}";
         showErrors('divgloid',editmsg+' Kindly save SKU details before clicking on Save and Continue.');
         return false;
      }
       if(bdsellerskuid!=sellerskuid ||   bdbaseprice!=baseprice || bdofferprice!=offerprice || bdcost!=cost  || bdavailablestock!=availablestock || bdminumiumqty!=minumiumqty || bdmaximumqty!=maximumqty || bdlowstockthreshold!=lowstockthreshold || formatSkuDate(bdskupublishingdate)!=skupublishingdate ){
    	   editmsg= "${variantPermutations.skuCreationName}";
           showErrors('divgloid',editmsg+' Kindly save SKU details before clicking on Save and Continue.');
           return false;
        }
       
   </c:forEach>
   if(defaultSkuOn==0){
	   showErrors('divgloid',msg+' Kindly Save any one default Sku before proceeding further.');
	   return false;
   }if(status){
	   showErrors('divgloid',msg+' Save SKU details before proceeding further.');
   } else{
       window.location.href = '${nextURL}';
   }
   return false;
}

function removeMediaFiles(productskuMediaId){
	if(productskuMediaId != ""){
		$.ajax({
			type:"GET",
			url:skuMediaRemoveURL,
			async:false,
			dataType: 'json',
			data:{
				"<portlet:namespace/>productskuMediaId":productskuMediaId
			},
			success:function(data){
				
			},
		});
	}
}

function calculate_margin(skuName) {
	calculate_decimal("cost"+skuName);
	calculate_decimal("offerprice"+skuName);
	 const costinputString = $("#cost"+skuName).prop('value'); 
	 const offerpriceinputString = $("#offerprice"+skuName).prop('value'); 
	 const margininputString = offerpriceinputString-costinputString;
	 $('#margin'+skuName).val(margininputString); 
	 calculate_decimal("margin"+skuName);
}
function isPrecise(num){
	  return String(num).split(".")[1]?.length == 2;
	}
function calculate_decimal(id) {
	 const amount = $("#"+id).prop('value'); 
	 if(amount!=''){
	 var status=Number.isInteger(amount);
	 if(status==true){
		 currentNumber=currentNumber+.00;
		 $('#'+id).val(currentNumber.toFixed(2)); 
	 }else{
		 var currentNumber = parseFloat(amount);
		 $('#'+id).val(currentNumber.toFixed(2)); 
	  }
	}
}
		
function hideErrors (id) {
	document.getElementById(id).innerHTML = ""; 
    $('#'+id).hide();
}

function showErrors (id,msg) {
	    $('#'+id).show();
	    document.getElementById(id).innerHTML = ""; 
	    $('#'+id).append(msg);
}
	
var saveSKUDetails = async (requestBody) => {
	const response = await fetch(saveSKUDetailsURL, {
		method: 'POST',
		body: requestBody
	});
	const data = await response.text();
	var flagData = JSON.parse(data);
	if(flagData.isDataSaved){
	    window.location.reload();
	}
	setTimeout(function(){ window.location.reload(); }, 4000);
};

$(".close").on("click", function() {
  $("#modalContainer").hide();
  $('.open-canvas canvas').remove();
});

$('.mod-rec-image-btn').click(function(e){
	//alert("1");
  e.preventDefault();
  $('.rec_main_before').removeClass('active');
  $('.all-module').addClass('active');
  $('.module-rec-image').addClass('active');

});

$('.module-rec-image .items').on('click', '.delete', function(){
  var photoCount = $('.module-rec-image .items .item').length;
  var thisCanvas = $(this).closest('.item').find('img');
  removeMediaFiles(thisCanvas[0].id.replace('canvas-image-', ''));
  $(this).closest('.item').remove();
  if($('.module-rec-image .f-record-main').hasClass('stop-upload')) $('.module-rec-image .f-record-main').removeClass('stop-upload');
});

$('.module-rec-image .items').on('click', '.open', function(){
	  var streamWidth = $('.stream-w').val();
	  var streamHeight = $('.stream-h').val();
	  var thisCanvas = $(this).closest('.item').find('img');
	  var newCanvas = thisCanvas.clone().appendTo( ".open-canvas" );
	  console.log(newCanvas);
	  $("#modalContainer").show();
  
});

$(".close").on("click", function() {
  $("#modalContainer").hide();
  $('.open-canvas img').remove();
});



var uploadFiles = async (fileuploadid,draftProductId,productskuId,skuDetailsMain) => {
    var images = $('#'+fileuploadid).prop('files');
    var formData = new FormData();
    formData.append('draftProductId', draftProductId);
    formData.append('productskuId', productskuId);
    for(let index = 0; index < images.length; index ++)
        formData.append('images', images[index], images[index].name);
    const response = await fetch(skuMediaURL, {
        method: 'POST',
        body: formData
    });
    
    const data = await response.json();
    if(data){
    	   if(data.isDataSaved){
    	      saveSKUDetails(JSON.stringify(skuDetailsMain));
    	   }
    	}
    
};

function validateFileSize(fileSizeCount) {
	var maxSize = 5*1024*1024;
    var inputFile = $("#brandImageUpload")[0];
    if (inputFile.files.length > 0) {
       var fileSize = inputFile.files[0].size;
       if(fileSize > maxSize){
			return false;
		}
    }
    return true;
}

var loadFile = (evt,skuName)=> {
	 var itemid='item'+skuName; 
	 itemid.innerHTML = "";
	 var fileUpload = $('#'+skuName).prop('files');
	 var regex = /^([a-zA-Z0-9\s_\\.\-:])+(.jpg|.png|.jpeg)$/;
	 var fileSizeCount=0;
	 for (var i = 0; i < event.target.files.length; i++) {
     	var file = event.target.files[i];
     	fileSizeCount=fileSizeCount+file.size;
     	if (regex.test(file.name.toLowerCase())) {
     		var reader = new FileReader();
			reader.onload = function(event) {
				var img = $("<img />");
				img.attr("style", "height:100px;width: 100px");
				img.attr("src", event.target.result);
				img.attr("id", canvasId);
				var photoCount = $('.items .item').length;
				var canvasId = "canvas-image-" + photoCount;
				//$('<div class="item item-'+photoCount+'"><div class="item-inner">"'+file.name+'"<div class="open-delete"><div class="open-delete-btns"><span class="open"></span><span class="delete"></span></div></div></div></div>').appendTo('.'+itemid);
				if (photoCount == 2) $('.module-rec-image .f-record-main').addClass('stop-upload');
				//itemid.appendChild(img);
    		}
    
    		reader.readAsDataURL(file);
	     } else {
	    	// alert(file.name + " is not a valid image file.");
	    	 showErrors('div16_'+skuName,file.name+'Kindly Upload Valid image !');
	    	 //skuName.innerHTML = "";
	    	 $("#"+skuName).val(null);
	         return false;
	     }
    }
	 var maxSize = 5*1024*1024;
	 if(fileSizeCount > maxSize){
		 showErrors('div16_'+skuName,'File Size is Invalid Max Size should be 5 MB !');
		 $("#"+skuName).val(null);
		 return false;
	}
};

$(document).ready(function () {
	
	$("#accordion form:first-child .card .collapse").addClass("show"); 
	$("#accordion form:first-child .card .card-link").removeClass("collapsed"); 
	$("#accordion form:first-child .card .card-link").attr("aria-expanded", "true");
	
	var today = new Date();
	var tomorrow = new Date(today);
	tomorrow.setDate(today.getDate() + 1);
	   
	<c:forEach var="variantPermutations" items="${variantPermutations}" varStatus="counter">
		var skuName="${variantPermutations.productSKUId}";
		var publishingDateInput = document.getElementById(skuName+"skupublishingdate");
		var expiryDateInput = document.getElementById(skuName+"skuexpirydate");
		publishingDateInput.min = formatDate(today);
		expiryDateInput.min = formatDate(tomorrow);
	</c:forEach>
	
	$("form").submit(function () {
    	
		var clikedForm = $(this); // Select Form
		var skuName = clikedForm[0].id.replace('myForm', '');
      
		if (clikedForm.find("[name='skuid']").val() == '') {
		  	showErrors('div1_'+skuName,'SKU id cannot be blank!');
		  	return false;
		} else {
			hideErrors('div1_'+skuName);
		}
      
		if (clikedForm.find("[name='sellerskuid']").val() == '') {
		 	showErrors('div2_'+skuName,'Seller SKU id cannot be blank!');
		 	$("#sellerskuid"+skuName).focus();
		  	return false;
		} else {
			
		 	hideErrors('div1_'+skuName);
		 	hideErrors('div2_'+skuName);
		}
      
		if (clikedForm.find("[name='defaultsku']").val() == '' || clikedForm.find("[name='defaultsku']").val() != '') {
		 //getDefaultSkuCount('div3_'+skuName);
		 var statusCount=0;
		 <c:forEach var="variantPermutations" items="${variantPermutations}" varStatus="counter">
			 var formName="${variantPermutations.productSKUId}";
			 var defaultsku = $("form[name='myForm"+formName+"'] input[name='defaultsku']").val();
			 
			// alert(defaultsku);
			 if(defaultsku=='on'){
				// alert("condition");
				 statusCount=statusCount+1;
			 }
		</c:forEach>
		//alert(statusCount);
		if(statusCount==0){
			showErrors('div3_'+skuName,'Default Sku cannot be blank!');
			 $("#defaultsku"+skuName).focus();
			return false;
		}    		
		
		// showErrors('div3_'+skuName,'Default Sku cannot be blank!');
		 // return false;
		}else{
			 hideErrors('div1_'+skuName);
			 hideErrors('div2_'+skuName);
			 hideErrors('div3_'+skuName);
		}
      
      
		if (clikedForm.find("[name='baseprice']").val() == '') {
			 showErrors('div4_'+skuName,'Base Price cannot be blank!');
			 $("#baseprice"+skuName).focus();
			 return false;
		}else{
			 hideErrors('div1_'+skuName);
			 hideErrors('div2_'+skuName);
			 hideErrors('div3_'+skuName);
			 hideErrors('div4_'+skuName);
		}
      
		if (clikedForm.find("[name='offerprice']").val() == '') {
			 showErrors('div5_'+skuName,'Offer Price cannot be blank!');
			 $("#offerprice"+skuName).focus();
			 return false;
		} else {
			 var offerpriceCount=clikedForm.find("[name='offerprice']").val();
			 var basepriceCount= clikedForm.find("[name='baseprice']").val();
			 
			 if(parseInt(offerpriceCount)>parseInt(basepriceCount)){
				  showErrors('div5_'+skuName,'Offer Price can not be greater than Base Price!');
				  return false;
			 }
			 
			 hideErrors('div1_'+skuName);
			 hideErrors('div2_'+skuName);
			 hideErrors('div3_'+skuName);
			 hideErrors('div4_'+skuName);
			 hideErrors('div5_'+skuName);
		}
      
		if (clikedForm.find("[name='cost']").val() == '') {
			 showErrors('div6_'+skuName,'Cost cannot be blank!');
			 $("#cost"+skuName).focus();
			 return false;
		} else {
			 hideErrors('div1_'+skuName);
			 hideErrors('div2_'+skuName);
			 hideErrors('div3_'+skuName);
			 hideErrors('div4_'+skuName);
			 hideErrors('div5_'+skuName);
			 hideErrors('div6_'+skuName);
		}
      
      
		if (clikedForm.find("[name='margin']").val() == '') {
		 	showErrors('div7_'+skuName,'Margin cannot be blank!');
		 	$("#margin"+skuName).focus();
		  	return false;
		} else {
			 /* var marginCount=clikedForm.find("[name='margin']").val();
			 
			 if(marginCount<0){
			  	showErrors('div7_'+skuName,'Margin value cannot be Negative!');
			    return false;
			 } */
			 
			 hideErrors('div1_'+skuName);
			 hideErrors('div2_'+skuName);
			 hideErrors('div3_'+skuName);
			 hideErrors('div4_'+skuName);
			 hideErrors('div5_'+skuName);
			 hideErrors('div6_'+skuName);
			 hideErrors('div7_'+skuName);
		}
      
		if (clikedForm.find("[name='availablestock']").val() == '') {
			 showErrors('div8_'+skuName,'Available Stock Cannot be blank!');
			 $("#availablestock"+skuName).focus();
			 return false;
		} else {
			 hideErrors('div1_'+skuName);
			 hideErrors('div2_'+skuName);
			 hideErrors('div3_'+skuName);
			 hideErrors('div4_'+skuName);
			 hideErrors('div5_'+skuName);
			 hideErrors('div6_'+skuName);
			 hideErrors('div7_'+skuName);
			 hideErrors('div8_'+skuName);
		}
      
		if (clikedForm.find("[name='uom']").val() == '') {
			 showErrors('div9_'+skuName,'UOM can not be blank !');
			 return false;
		} else {
			 hideErrors('div1_'+skuName);
			 hideErrors('div2_'+skuName);
			 hideErrors('div3_'+skuName);
			 hideErrors('div4_'+skuName);
			 hideErrors('div5_'+skuName);
			 hideErrors('div6_'+skuName);
			 hideErrors('div7_'+skuName);
			 hideErrors('div8_'+skuName);
			 hideErrors('div9_'+skuName);
		}
      
		if (clikedForm.find("[name='minumiumqty']").val() == '' || parseInt(clikedForm.find("[name='minumiumqty']").val())==0) {
			 showErrors('div10_'+skuName,'Minimum Quantity can not be blank or zero !');
			 $("#minumiumqty"+skuName).focus();
			 return false;
		} else {
			 var minCount=clikedForm.find("[name='minumiumqty']").val();
			 var availablestockCount= clikedForm.find("[name='availablestock']").val();
			 var maxqtyCount=clikedForm.find("[name='maximumqty']").val();
			 
			 if(parseInt(minCount)>parseInt(availablestockCount)){
			  	showErrors('div10_'+skuName,'Minimum Order Quantity can not be greater than Available Stock!');
			  	$("#minumiumqty"+skuName).focus();
			    return false;
			 }
			 
			 if(parseInt(minCount)>parseInt(maxqtyCount)){
				  	showErrors('div10_'+skuName,'Minimum Order Quantity can not be greater than Maximum Quantity!');
				  	$("#minumiumqty"+skuName).focus();
				    return false;
			 }
			 
			 hideErrors('div1_'+skuName);
			 hideErrors('div2_'+skuName);
			 hideErrors('div3_'+skuName);
			 hideErrors('div4_'+skuName);
			 hideErrors('div5_'+skuName);
			 hideErrors('div6_'+skuName);
			 hideErrors('div7_'+skuName);
			 hideErrors('div8_'+skuName);
			 hideErrors('div9_'+skuName);
			 hideErrors('div10_'+skuName);
		}
      
		if (clikedForm.find("[name='maximumqty']").val() == '' || parseInt(clikedForm.find("[name='maximumqty']").val()) == 0) {
			 showErrors('div11_'+skuName,'Maximum Quantity can not be blank or zero !');
			 $("#maximumqty"+skuName).focus();
			 return false;
		} else {
			 var maxCount=clikedForm.find("[name='maximumqty']").val();
			 var availablestockCount= clikedForm.find("[name='availablestock']").val();
			 
			 if(parseInt(maxCount)>parseInt(availablestockCount)){
			  	showErrors('div11_'+skuName,'Maximum Order Quantity can not be greater then Available Stock!');
			  	$("#maximumqty"+skuName).focus();
			    return false;
			 }
			 
			 hideErrors('div1_'+skuName);
			 hideErrors('div2_'+skuName);
			 hideErrors('div3_'+skuName);
			 hideErrors('div4_'+skuName);
			 hideErrors('div5_'+skuName);
			 hideErrors('div6_'+skuName);
			 hideErrors('div7_'+skuName);
			 hideErrors('div8_'+skuName);
			 hideErrors('div9_'+skuName);
			 hideErrors('div10_'+skuName);
			 hideErrors('div11_'+skuName);
		}
      
		if (clikedForm.find("[name='lowstockthreshold']").val() == '') {
			 showErrors('div12_'+skuName,'Low Stock Threshold can not be blank !');
			 $("#lowstockthreshold"+skuName).focus();
			 return false;
		} else {
			 var thresholdCount=clikedForm.find("[name='lowstockthreshold']").val();
			 var availablestockCount= clikedForm.find("[name='availablestock']").val();
			 
			 if(parseInt(thresholdCount)>parseInt(availablestockCount)){
			  	showErrors('div12_'+skuName,'Low stock threshold can not be greater than Available Stock!');
			  	$("#lowstockthreshold"+skuName).focus();
			    return false;
			 }
			 
			 hideErrors('div1_'+skuName);
			 hideErrors('div2_'+skuName);
			 hideErrors('div3_'+skuName);
			 hideErrors('div4_'+skuName);
			 hideErrors('div5_'+skuName);
			 hideErrors('div6_'+skuName);
			 hideErrors('div7_'+skuName);
			 hideErrors('div8_'+skuName);
			 hideErrors('div9_'+skuName);
			 hideErrors('div10_'+skuName);
			 hideErrors('div11_'+skuName);
			 hideErrors('div12_'+skuName);
		}
      
		if (clikedForm.find("[name='tax']").val() == '') {
		 	showErrors('div13_'+skuName,'Tax can not be Blank!');
		  	return false;
		} else {
			 hideErrors('div1_'+skuName);
			 hideErrors('div2_'+skuName);
			 hideErrors('div3_'+skuName);
			 hideErrors('div4_'+skuName);
			 hideErrors('div5_'+skuName);
			 hideErrors('div6_'+skuName);
			 hideErrors('div7_'+skuName);
			 hideErrors('div8_'+skuName);
			 hideErrors('div9_'+skuName);
			 hideErrors('div10_'+skuName);
			 hideErrors('div11_'+skuName);
			 hideErrors('div12_'+skuName);
			 hideErrors('div13_'+skuName);
		}
      
      if (clikedForm.find("[name='skupublishingdate']").val() == '') {
			showErrors('div14_'+skuName,'Sku Publishing Date can not be Blank !');
			$("#skupublishingdate"+skuName).focus();
        	return false;
      } else {
    	  hideErrors('div1_'+skuName);
    	  hideErrors('div2_'+skuName);
    	  hideErrors('div3_'+skuName);
    	  hideErrors('div4_'+skuName);
    	  hideErrors('div5_'+skuName);
    	  hideErrors('div6_'+skuName);
    	  hideErrors('div7_'+skuName);
    	  hideErrors('div8_'+skuName);
    	  hideErrors('div9_'+skuName);
    	  hideErrors('div10_'+skuName);
    	  hideErrors('div11_'+skuName);
    	  hideErrors('div12_'+skuName);
    	  hideErrors('div13_'+skuName);
    	  hideErrors('div14_'+skuName);
      }
      
      if (clikedForm.find("[name='skuexpirydate']").val() != '') {
		var selectedPublishingDate = new Date(clikedForm.find("[name='skupublishingdate']").val());
		var selectedExpiryDate = new Date(clikedForm.find("[name='skuexpirydate']").val());
		
		// Check if expiry date is same or older than publishing date
		if (selectedExpiryDate <= selectedPublishingDate) {
		  //  alert("SKU Expiry Date must be lesser than SKU Publishing Date.");
		    selectedExpiryDate.value = "";
		    showErrors('div15_'+skuName,'SKU Expiry Date must be greater than SKU Publishing Date. !');
		    $("#skuexpirydate"+skuName).focus();
		    return false;
		}
      } else {
    	  hideErrors('div1_'+skuName);
    	  hideErrors('div2_'+skuName);
    	  hideErrors('div3_'+skuName);
    	  hideErrors('div4_'+skuName);
    	  hideErrors('div5_'+skuName);
    	  hideErrors('div6_'+skuName);
    	  hideErrors('div7_'+skuName);
    	  hideErrors('div8_'+skuName);
    	  hideErrors('div9_'+skuName);
    	  hideErrors('div10_'+skuName);
    	  hideErrors('div11_'+skuName);
    	  hideErrors('div12_'+skuName);
    	  hideErrors('div13_'+skuName);
    	  hideErrors('div14_'+skuName);
    	  hideErrors('div15_'+skuName);
      }
      
      if (clikedForm.find("[name='images']").val() == '') {
    	showErrors('div16_'+skuName,'Image can not be blank !');
    	 var textbox = document.getElementById(skuName);
		 textbox.focus();
		 textbox.scrollIntoView();
		return false;
      } else {
    	  hideErrors('div1_'+skuName);
    	  hideErrors('div2_'+skuName);
    	  hideErrors('div3_'+skuName);
    	  hideErrors('div4_'+skuName);
    	  hideErrors('div5_'+skuName);
    	  hideErrors('div6_'+skuName);
    	  hideErrors('div7_'+skuName);
    	  hideErrors('div8_'+skuName);
    	  hideErrors('div9_'+skuName);
    	  hideErrors('div10_'+skuName);
    	  hideErrors('div11_'+skuName);
    	  hideErrors('div12_'+skuName);
    	  hideErrors('div13_'+skuName);
    	  hideErrors('div14_'+skuName);
    	  hideErrors('div15_'+skuName);
    	  hideErrors('div16_'+skuName);
      }
      
		var skuid=clikedForm.find("[name='skuid']").val();
		var sellerskuid=clikedForm.find("[name='sellerskuid']").val();
		var defaultsku=clikedForm.find("[name='defaultsku']").val();
		var baseprice=clikedForm.find("[name='baseprice']").val();
		var offerprice=clikedForm.find("[name='offerprice']").val();
		var cost=clikedForm.find("[name='cost']").val();
		var margin=clikedForm.find("[name='margin']").val();
		var availablestock=clikedForm.find("[name='availablestock']").val();
		var uom=clikedForm.find("[name='uom']").val();
		var minumiumqty=clikedForm.find("[name='minumiumqty']").val();
		var maximumqty=clikedForm.find("[name='maximumqty']").val();
		var lowstockthreshold=clikedForm.find("[name='lowstockthreshold']").val();
		var tax=clikedForm.find("[name='tax']").val();
		var skupublishingdate=clikedForm.find("[name='skupublishingdate']").val();
		var skuexpirydate=clikedForm.find("[name='skuexpirydate']").val();
		var productskuId=clikedForm.find("[name='productskuId']").val();
		var draftProductId=clikedForm.find("[name='draftProductId']").val();
		   
		var skuDetailsMain = new Object();
		var skuDetails = new Object();
		skuDetails.productskuId = productskuId;
		skuDetails.draftProductId = draftProductId;
		skuDetails.skuid = skuid;
		skuDetails.sellerskuid = sellerskuid;
		skuDetails.defaultsku = defaultsku;
		skuDetails.baseprice = baseprice;
		skuDetails.offerprice = offerprice;
		skuDetails.cost = cost;
		skuDetails.margin = margin;
		skuDetails.availablestock = availablestock;
		skuDetails.uom = uom;
		skuDetails.minumiumqty = minumiumqty;
		skuDetails.maximumqty = maximumqty;
		skuDetails.lowstockthreshold = lowstockthreshold;
		skuDetails.tax = tax;
		skuDetails.skupublishingdate = skupublishingdate;
		skuDetails.skuexpirydate = skuexpirydate;
		skuDetailsMain.skuDetails = skuDetails;
		document.getElementById('submit'+skuName).dissaveSKUDetailsabled = true;
		document.getElementById('submit'+skuName).innerHTML = "Processing...";
		 if (clikedForm.find("[name='"+skuName+"']").val() != '') {      
		uploadFiles(skuName,draftProductId,productskuId,skuDetailsMain);
		 }else{
		saveSKUDetails(JSON.stringify(skuDetailsMain));
		 }
		return false;
    });
});

  function formatDate(date) {
      var year = date.getFullYear();
      var month = (date.getMonth() + 1 < 10 ? '0' : '') + (date.getMonth() + 1);
      var day = (date.getDate() < 10 ? '0' : '') + date.getDate();
      return year + "-" + month + "-" + day;
  }

  function formatSkuDate(inputDate) {
	    // Parsing the input date string into a Date object
	    var date = new Date(inputDate);

	    // Getting day, month, and year components from the Date object
	    var day = date.getDate();
	    var month = date.getMonth() + 1; // Months are zero-based
	    var year = date.getFullYear();

	    // Formatting day and month to ensure they have two digits
	    if (day < 10) {
	        day = '0' + day;
	    }
	    if (month < 10) {
	        month = '0' + month;
	    }

	    // Returning the formatted date in dd-mm-yyyy format
	    return year + '-' + month + '-' + day;
	}
 
</script>
