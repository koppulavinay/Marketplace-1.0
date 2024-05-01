<%@ include file="/init.jsp"%>

<script type="text/javascript">
	$('#customLoader').show();
</script>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=ProductViewPortletKeys.SKU_CREATION_RENDER%>" />
	<portlet:param name="draftProductId" value="${draftProductId}" />
</portlet:renderURL>

<portlet:renderURL var="variantURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%=ProductViewPortletKeys.VARIANT_CREATION_RENDER%>" />
	<portlet:param name="draftProductId" value="${draftProductId}" />
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
	<portlet:param name="mvcRenderCommandName"
		value="/brand/category/select/render" />
	<portlet:param name="draftProductId" value="${draftProductId}" />
</portlet:renderURL>

<liferay-ui:success key="sku-success-key"
	message="SKU Details Saved Successfully!" />

<form action="${additionalInformationActionURL}" method="post">
	<input type="hidden" name="<portlet:namespace/>draftProductId"
		value="${draftProductId}" /> <input type="hidden"
		id="<portlet:namespace/>productStatus"
		name="<portlet:namespace/>productStatus" value="" /> <input
		type="hidden" id="<portlet:namespace/>stepNumber"
		name="<portlet:namespace/>stepNumber" value="6" />

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

	<div class="container additionalConfigurationPage">
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
						<div class="stepper-item completed">
							<div class="step-counter">
								<a href="${backURL}">5</a>
							</div>
							<div class="step-name">SKU</div>
						</div>
						<div class="stepper-item active">
							<div class="step-counter">6</div>
							<div class="step-name">Additional Configuration</div>
						</div>
						<!-- <div class="stepper-item">
							<div class="step-counter">
								<a href="#">7</a>
							</div>
							<div class="step-name">Product Summary</div>
						</div> -->
					</div>
				</div>
			</section>

			<h2 class="h2Form">Additional Configuration</h2>


			<div class="row">
				<div class="col-md-12 mb-5">
					<div class="tab-pane container p-0" id="addConfig">
						<div class="row">
							<div class="col-md-6">
								<div class="form-group">
									<label for="taxCategory">Tax Category<span
										class="requiredStar">*</span></label> <select class="form-control requiredInput"
										id="taxCategory" name="<portlet:namespace/>taxCategory" onfocusout="validateTaxCategory();">
										<option value="">Select Tax Category</option>
										<c:forEach items="${cpTaxCategories}" var="taxCategory">
											<option value="${taxCategory.CPTaxCategoryId}">${taxCategory.name}</option>
										</c:forEach>
									</select> <label class="error d-none taxCategoryReq">Select tax
										category</label>
								</div>
							</div>
							<div class="col-md-6">
								<div class="form-group">
									<label for="searchKey">Search Keyword</label> <input
										type="text" class="form-control" onpaste="return false;" placeholder="Maximum characters limit For One Keyword is 75"
										id="searchKey"
										onkeydown="return /[a-zA-Z0-9\s]/.test(event.key);"> <label
										class="error d-none searchKeywordError"></label>
									<div id="searchKeywordContainer">
										<c:forEach items="${searchKeywords}" var="searchKeyword">
											<div class="chip" data-searchkeyword="${searchKeyword}">
												${searchKeyword}<span class="close-icon"
													onclick="$(this).parent().remove();">&times;</span>
											</div>
										</c:forEach>
									</div>
								</div>
							</div>
						</div>
						<div class="form-group m-0">
							<label>Package Contents / Items Included in the Product</label>
						</div>
						<div>
							<div class="table-responsive">
								<table class="table table-bordered" id="packageContentTable">
									<thead>
										<tr>
											<th width="65px">S. No</th>
											<th class="itemNameCol">Item Name<span
												class="requiredStar">*</span></th>
											<th width="200px">Quantity<span class="requiredStar">*</span></th>
											<th width="80px" class="actionTd">Action</th>
										</tr>
									</thead>
									<tbody id="items-container">
										<c:choose>
											<c:when test="${empty packageContents}">
												<tr class="item-container">
													<td>1</td>
													<td><input type="text"
														class="form-control item-name w-100 requiredInput"
														placeholder="Item name"
														data-validationmessage="Item Name cannot be empty"
														oninput="hideError(this, 0);"
														onfocusout="showError(this, 0);"
														onpaste="return false;" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key);"> <label
														class="error d-none itemError0"></label></td>
													<td><input type="number"
														class="form-control item-quantity w-100 requiredInput" min="0"
														placeholder="Quantity"
														data-validationmessage="Item Quantity cannot be empty"
														oninput="hideError(this, 1);"
														onfocusout="validateItemQty(this, 1);"
														onkeydown="javascript: return ['Backspace','Delete','ArrowLeft','ArrowRight', 'Tab'].includes(event.code) ? true : !isNaN(Number(event.key)) && event.code!=='Space'">
														<label class="error d-none itemError1"></label></td>
													<td class="actionTd">
														<button type="button" class="btn btn-link"
															style="text-transform: none;">
															<i class="fas fa-trash-alt delete-item"></i>
														</button>
													</td>
												</tr>
											</c:when>
											<c:otherwise>
												<c:forEach items="${packageContents}" var="packageContent"
													varStatus="counter">
													<tr class="item-container">
														<td>${counter.count}</td>
														<td><input type="text"
															class="form-control item-name w-100 requiredInput"
															placeholder="Item name"
															data-validationmessage="Item Name cannot be empty"
															oninput="hideError(this, 0);"
															onfocusout="showError(this, 0);"
															value="${packageContent.getItemName()}"> <label
															class="error d-none itemError0"></label></td>
														<td><input type="number"
															class="form-control item-quantity requiredInput" placeholder="Quantity"
															data-validationmessage="Item Quantity cannot be empty"
															oninput="hideError(this, 1);"
															onfocusout="validateItemQty(this, 1);" min="0"
															value="${packageContent.getItemQty()}"
															onkeydown="javascript: return ['Backspace','Delete','ArrowLeft','ArrowRight', 'Tab'].includes(event.code) ? true : !isNaN(Number(event.key)) && event.code!=='Space'">
															<label class="error d-none itemError1"></label></td>
														<td class="actionTd">
															<button type="button" class="btn btn-link"
																style="text-transform: none;">
																<i class="fas fa-trash-alt"></i>
															</button>
														</td>
													</tr>
												</c:forEach>
											</c:otherwise>
										</c:choose>

									</tbody>
									<tfoot>
										<tr>
											<td colspan="4" class="text-right">
												<button id="add-item-btn" type="button"
													class="btn btn-link pl-0 pr-0">Add More Items</button>
											</td>
										</tr>
									</tfoot>
								</table>
							</div>

						</div>

						<div class="stepperBarButton">
							<a href="${backURL}" class="btn btn-outline-secondary bigButton">Back</a>
							<button class="btn btn-primary bigButton" type="button"
								onclick="handleFormSubmit(this.form);">Submit</button>
						</div>

					</div>
				</div>
				<!-- <div class="col-md-5 ml-auto">
					<section class="steperSlider">
						<div class="swiper">
							<div class="swiper-wrapper">
								<div class="swiper-slide">
									<div class="steperCard">
										<p>
											<strong>Help Center</strong>
										</p>
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit. Aenean commodo ligula eget dolor. Aenean massa. Cum
											sociis natoque penatibus et magnis dis parturient montes,
											nascetur ridiculus mus Aenean massa. Cum sociis natoque
											penatibus et magnis dis parturient montes, nascetur.</p>
										<div class="steperSliderPic">
											<img src="/o/buycorp-classic-theme/images/thumbnail.png"
												alt="" class="img-fluid">
										</div>
									</div>
								</div>
								<div class="swiper-slide">
									<div class="steperCard">
										<p>
											<strong>Help Center</strong>
										</p>
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit. Aenean commodo ligula eget dolor. Aenean massa. Cum
											sociis natoque penatibus et magnis dis parturient montes,
											nascetur ridiculus mus Aenean massa. Cum sociis natoque
											penatibus et magnis dis parturient montes, nascetur.</p>
										<div class="steperSliderPic">
											<img src="/o/buycorp-classic-theme/images/thumbnail.png"
												alt="" class="img-fluid">
										</div>
									</div>
								</div>
								<div class="swiper-slide">
									<div class="steperCard">
										<p>
											<strong>Help Center</strong>
										</p>
										<p>Lorem ipsum dolor sit amet, consectetuer adipiscing
											elit. Aenean commodo ligula eget dolor. Aenean massa. Cum
											sociis natoque penatibus et magnis dis parturient montes,
											nascetur ridiculus mus Aenean massa. Cum sociis natoque
											penatibus et magnis dis parturient montes, nascetur.</p>
										<div class="steperSliderPic">
											<img src="/o/buycorp-classic-theme/images/thumbnail.png"
												alt="" class="img-fluid">
										</div>
									</div>
								</div>
							</div>
							<div class="swiper-pagination"></div>
						</div>
					</section>
				</div> -->
			</div>

		</div>
	</div>


</form>

<script>
	$(document).ready(function() {

		if ('${taxCategoryId}' != 0) {
			$("#taxCategory").val('${taxCategoryId}');
		}
	});
</script>

<script
	src="<%=request.getContextPath()%>/js/additional_information.js?ver<%=PwdGenerator.getPassword(2)%>"></script>
