<%@ include file="/init.jsp"%>

<script type="text/javascript">
	$('#customLoader').show();
</script>

<liferay-portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName"
		value="<%= ProductViewPortletKeys.BRAND_CATEGORY_SELECT_RENDER_CMD %>" />
	<portlet:param name="draftProductId" value="${product.draftProductId}" />
</liferay-portlet:renderURL>

<liferay-ui:success key="brand-category-key" message="Brand and Category Details Saved Successfully!" />

<form method="post" action="${basicInfoActionURL}"
	name="<portlet:namespace/>basicInformation"
	id="<portlet:namespace/>basicInformation" enctype="multipart/form-data">

	<input type="hidden" id="<portlet:namespace/>productStatus" name="<portlet:namespace/>productStatus" value="" />
	<input type="hidden" id="<portlet:namespace/>stepNumber" name="<portlet:namespace/>stepNumber" value="2" />

	<div class="container">
		<div class="addProductTitle">
			<h1 class="titlePage mt-4">Product Creation</h1>
			<div>
				<%@ include file="/last_modified_date.jsp" %>
				<button type="button" class="btn btn-outline-secondary" onclick="saveAsDraft(this.form);">Save as draft</button>
			</div>
		</div>
	</div>

	<div class="container">
		<div class="customform stepperCustomform mb-4">
			<section class="steperBar">
				<div class="container">
					<div class="stepper-wrapper">
						<div class="stepper-item completed">
							<div class="step-counter">
								<a href="${backURL}">1</a>
							</div>
							<div class="step-name">Category and Brand</div>
						</div>
						<div class="stepper-item active">
							<div class="step-counter">2</div>
							<div class="step-name">Product Information</div>
						</div>
						<div class="stepper-item">
							<div class="step-counter">3</div>
							<div class="step-name">Specification</div>
						</div>
						<div class="stepper-item">
							<div class="step-counter">4</div>
							<div class="step-name">Variant Creation</div>
						</div>
						<div class="stepper-item">
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

			<h2 class="h2Form">Product Information</h2>

			<div class="row">
				
				<div class="col-md-6">
				<div class="form-group">
						<input type="hidden" id="draftProductId"
							name="<portlet:namespace/>draftProductId"
							value="${product.draftProductId}">
						<aui:input type="text" label="Enter Product/Service Name" localized="true"
							name="productName" id="productName"
							value="${product.productName}" disabled="true" />
					</div>
				</div>
				
				<div class="col-md-6">
					<div class="form-group">
						<label>Model Number</label> 
						<input type="text" placeholder="Enter Model Number" 
							id="<portlet:namespace/>modelNumber"
							name="<portlet:namespace/>modelNumber"
							value="${product.getModelNumber()}" class="form-control" 
							onkeydown="return /^([a-zA-Z0-9 / : _-]+)$/.test(event.key);" />
					</div>
				</div>
				
				<div class="col-md-12">
					
					<div class="form-group">
						<aui:input type="text" label="Short Description" localized="true"
							name="shortDescription" id="shortDescription"
							onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" 	
							onpaste="return false;"
							value="${product.getShortDescription()}"
							placeholder="Enter Short Description" />
						<label class="error d-none shortDescriptionError"></label>
					</div>
					<div class="form-group">
						<aui:input localized="true" type="editor" label="Long Description"
							name="longDescription" id="longDescription"
							value="${product.getLongDescription()}" />
						<label class="error d-none longDescriptionError"></label>
					</div>
					
					<div class="stepperBarButton">
						<a href="${backURL}" class="btn btn-outline-secondary bigButton">Back</a>
						<button class="btn btn-primary nextBtn bigButton" type="button" onclick="submitForm(this.form);">Save & Continue</button>
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

<script
	src="<%=request.getContextPath()%>/js/basic_information.js?ver<%=PwdGenerator.getPassword(2)%>"></script>
	