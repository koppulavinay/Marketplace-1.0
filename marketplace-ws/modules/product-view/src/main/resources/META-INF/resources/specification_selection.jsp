<%@ include file="/init.jsp"%>

<script type="text/javascript">
	$('#customLoader').show();
</script>

<portlet:renderURL var="backURL">
	<portlet:param name="mvcRenderCommandName"
		value="/basic/information/render" />
	<portlet:param name="draftProductId" value="${draftProductId}" />
</portlet:renderURL>

<portlet:renderURL var="brandCategoryURL">
	<portlet:param name="mvcRenderCommandName"
		value="/brand/category/select/render" />
	<portlet:param name="draftProductId" value="${draftProductId}" />
</portlet:renderURL>

<liferay-ui:success key="product-information-key"
	message="Product Information Saved Successfully!" />

<form action="${selectSpecificationActionURL}" method="post">

	<input type="hidden" id="<portlet:namespace/>productStatus"
		name="<portlet:namespace/>productStatus" value="" /> <input
		type="hidden" id="<portlet:namespace/>stepNumber"
		name="<portlet:namespace/>stepNumber" value="3" />

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


	<div class="container specificationPage">
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
								<a href="${backURL}">2</a>
							</div>
							<div class="step-name">Product Information</div>
						</div>
						<div class="stepper-item active">
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

			<h2 class="h2Form">Specification</h2>

			<input type="hidden" name="<portlet:namespace/>draftProductId"
				value="${draftProductId}" />
			<div class="row">
				<div class="col-md-6">

					<div id="<portlet:namespace/>selectSpecificationsSection">
						<div class="form-group mb-4">
							<label>Add Specifications from list</label>
							<div class="input-group">
								<select class="custom-select selectSpecifications"
									id="<portlet:namespace/>approvedSpecifications"
									placeholder="Select Specification"
									onchange="enableAddSpecificationBtn(this.value);">
									<option value="">Select Specification</option>
									<c:forEach var="approvedSpecification"
										items="${approvedSpecifications}">
										<option value="${approvedSpecification.getSpecificationId()}"
											data-specificationid="${approvedSpecification.getSpecificationId()}"
											data-specificationlabel="${approvedSpecification.getSpecificationLabel()}"
											data-specificationfieldtypeid="${approvedSpecification.getSpecificationFieldType()}"
											data-specificationfielddatatypeid="${approvedSpecification.getSpecificationFieldDataType()}">${approvedSpecification.getSpecificationLabel()}</option>
									</c:forEach>
								</select>
								<div class="input-group-append">
									<button class="btn btn-primary" type="button"
										onclick="addSpecification();"
										id="<portlet:namespace/>addSpecification" disabled="true">
										<i class="fas fa-plus"></i>
									</button>
								</div>
							</div>
							<label class="error d-none selectSpecificationError"></label>
						</div>

					</div>

					<div class="form-group mb-0">
						<label>Add Category Tagged Specifications</label>
					</div>

					<div class="table-responsive">
						<table class="table table-sm table-bordered">
							<thead>
								<tr>
									<th>Specification Label</th>
									<th class="lastTd">Action</th>
								</tr>
							</thead>
							<tbody class="table-group-divider">
								<c:choose>
									<c:when test="${not empty nonMandatorySpecCategories}">
										<c:forEach items="${nonMandatorySpecCategories}"
											var="approvedSpecification">
											<tr>
												<td>${approvedSpecification.getSpecificationLabel()}<label
													class="d-none error specCategoryError"></label>
												</td>
												<td class="lastTd">
													<button type="button" class="btn btn-primary" id=""
														data-specificationid="${approvedSpecification.getSpecificationId()}"
														data-specificationlabel="${approvedSpecification.getSpecificationLabel()}"
														data-specificationfieldtypeid="${approvedSpecification.getSpecificationFieldType()}"
														data-specificationfielddatatypeid="${approvedSpecification.getSpecificationFieldDataType()}"
														onclick="selectSpecification(this);">Add</button>
												</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<td colspan="2" class="text-center">No Data Found</td>
									</c:otherwise>
								</c:choose>
							</tbody>
						</table>
					</div>
				</div>

				<div class="col-md-12">
					<div class="form-group mb-0">
						<label>Product Specifications</label>
					</div>
					<div class="table-responsive">
						<table class="table table-sm table-bordered"
							style="min-width: 600px;"
							id="<portlet:namespace/>selectedSpecifications">
							<thead>
								<tr>
									<th scope="col" style="width: 200px;">Specification Label</th>
									<th scope="col">Specification Value</th>
									<th scope="col" class="d-none">Specification Value UOM</th>
									<th scope="col" class="lastTd">Action</th>
								</tr>
							</thead>
							<tbody class="table-group-divider">

								<c:if test="${not empty mandatorySpecCategories}">
									<c:forEach var="mandatorySpecCategory"
										items="${mandatorySpecCategories}">

										<c:set var="specificationId"
											value="${mandatorySpecCategory.getLong('specificationId')}" />
										<c:set var="specificationLabel"
											value="${mandatorySpecCategory.getString('specificationLabel')}" />
										<c:set var="specificationFieldTypeName"
											value="${mandatorySpecCategory.getString('specFieldTypeName')}" />
										<c:set var="specificationValues"
											value="${mandatorySpecCategory.getJSONArray('specificationValues')}" />
										<c:set var="specificationUOM"
											value="${mandatorySpecCategory.getJSONArray('specificationValues').get(0).getString('specificationValueUOM')}" />

										<tr id="row_${specificationId}" class="specification-row">
											<td><input type="hidden" value="${specificationId}"
												data-attrname="specificationId" /> <input type="hidden"
												value="${specificationLabel}"
												data-attrname="specificationLabel" /> <input type="hidden"
												value="${specificationFieldTypeName}"
												data-attrname="specificationFieldType" /><input
												type="hidden" value="true" data-attrname="isMandatory" />
												${specificationLabel}</td>
											<td><c:choose>
													<c:when test="${specificationFieldTypeName eq 'Free Text'}">
														<input class="form-control" type="text" value=""
															id="<portlet:namespace />specificationValueLabel"
															data-productspecvalueid="0"
															data-attrname="specificationValueLabel"
															data-validationmessage="Enter Specification Value"
															oninput="removeError(this);" />
														<label class="d-none error specificationValueError"></label>
													</c:when>
													<c:otherwise>
														<c:set var="multiSelect" value="" />

														<c:if
															test="${specificationFieldTypeName eq 'Multi Select'}">
															<c:set var="multiSelect" value="multiple" />
														</c:if>

														<select class="specValueLabelOptions form-control"
															${multiSelect} data-attrname="specificationValueLabel"
															data-validationmessage="Select Specification Value"
															onchange="removeError(this);">
															<option value="">Select Specification Value</option>
															<c:if test="${specificationValues.length() == 1}">
																<c:forEach begin="0"
																	end="${specificationValues.length()}" var="index">
																	<option
																		value="${specificationValues.getJSONObject(index).getLong('specificationValueId')}"
																		data-productspecvalueid="0">${specificationValues.getJSONObject(index).getString('specificationValueLabel')}</option>
																</c:forEach>
															</c:if>
															<c:if test="${specificationValues.length() > 1}">
																<c:forEach begin="0"
																	end="${specificationValues.length() - 1}" var="index">
																	<option
																		value="${specificationValues.getJSONObject(index).getLong('specificationValueId')}"
																		data-productspecvalueid="0">${specificationValues.getJSONObject(index).getString('specificationValueLabel')}</option>
																</c:forEach>
															</c:if>
														</select>
														<br>
														<label class="d-none error specificationValueError"></label>
													</c:otherwise>
												</c:choose></td>
											<td class="d-none"><select
												id="<portlet:namespace />specValueUOMOptions"
												class="form-control" data-attrname="specificationValueUOM"
												data-validationmessage="Select Specification UOM"
												onchange="removeError(this);">
													<option value="">Select Specification UOM</option>
													<option value="${specificationUOM}" selected>${specificationUOM}</option>
											</select></td>
											<td></td>
										</tr>
									</c:forEach>
								</c:if>

								<c:forEach items="${productSpecifications}"
									var="productSpecification" varStatus="counter">
									<tr id="row_${productSpecification.getSpecificationId()}"
										class="specification-row">
										<td><input type="hidden" class="form-control"
											value="${productSpecification.getSpecificationId()}"
											data-attrname="specificationId" /> <input type="hidden"
											value="${productSpecification.getSpecificationLabel()}"
											data-attrname="specificationLabel" /> <input type="hidden"
											value="${productSpecification.getSpecificationFieldType()}"
											data-attrname="specificationFieldType" /> <input
											type="hidden"
											value="${productSpecification.getProductSpecificationId()}"
											data-attrname="productSpecificationId" /> <input
											type="hidden" value="${productSpecification.isMandatory()}"
											data-attrname="isMandatory" />
											${productSpecification.getSpecificationLabel()}</td>
										<td><c:choose>
												<c:when
													test="${productSpecification.getSpecificationFieldType() eq 'Free Text'}">
													<input type="text" class="form-control"
														value="${productSpecification.getSingleInputValueLabel()}"
														data-productspecvalueid="${productSpecification.getProductSpecValueId()}"
														data-validationmessage="Enter Specification Value"
														data-attrname="specificationValueLabel"
														oninput="removeError(this);">
												</c:when>
												<c:otherwise>
													<c:set var="multiSelect" value="" />

													<c:if
														test="${productSpecification.getSpecificationFieldType() eq 'Multi Select'}">
														<c:set var="multiSelect" value="multiple" />
													</c:if>

													<select class="specValueLabelOptions" ${multiSelect}
														id="<portlet:namespace/>specificationValueLabel${counter.count}"
														data-attrname="specificationValueLabel"
														data-validationmessage="Select Specification Value"
														onchange="removeError(this);" class="form-control">
														<option value="">Select Specification Value</option>
														<c:if
															test="${not empty productSpecification.getProductSpecificationValues()}">
															<c:forEach
																items="${productSpecification.getProductSpecificationValues()}"
																var="productSpecificationValue">
																<option
																	value="${productSpecificationValue.getSpecificationValueId()}"
																	data-productspecvalueid="${productSpecificationValue.getProductSpecValueId()}"
																	${productSpecificationValue.isSelected() ? 'selected' : ''}>${productSpecificationValue.getSpecificationValueLabel()}
																	${productSpecification.getSpecificationValueUOM()}</option>
															</c:forEach>
														</c:if>
													</select>
												</c:otherwise>
											</c:choose><label class="d-none error specificationValueError"></label></td>
										<td class="d-none"><select
											id="<portlet:namespace />specValueUOMOptions"
											data-attrname="specificationValueUOM"
											data-validationmessage="Select Specification UOM"
											onchange="removeError(this);" class="form-control">
												<option value="">Select Specification UOM</option>
												<option
													value="${productSpecification.getSpecificationValueUOM()}"
													selected>${productSpecification.getSpecificationValueUOM()}</option>
										</select> <label class="d-none error specificationUOMError"></label></td>
										<td class="lastTd"><c:if
												test="${productSpecification.isMandatory() ne true}">
												<button type="button" class="btn btn-link"
													onclick="deleteSpecification(${productSpecification.getSpecificationId()});">
													<i class="fas fa-trash-alt"></i>
												</button>
											</c:if></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>

					<div class="stepperBarButton">
						<a href="${backURL}" class="btn btn-outline-secondary bigButton">Back</a>
						<button class="btn btn-primary bigButton nextBtn" type="button"
							onclick="handleFormSubmit(this.form);">Save & Continue</button>
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
	src="<%=request.getContextPath()%>/js/specification_selection.js?ver<%=PwdGenerator.getPassword(2)%>"> </script>

