<%@ include file="/init.jsp"%>

<!--  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.20.0/jquery.validate.min.js"></script> -->
	
	
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/bootstrap-multiselect.min.css">
<script src="<%= request.getContextPath() %>/js/bootstrap-multiselect.min.js"></script>

<portlet:actionURL var="createSpecificationURL"
	name="createSpecification" />

<portlet:renderURL var="viewUrl"></portlet:renderURL>

<!-- <div class="c-loader d-none">
	<span></span>
</div> -->

<form method="post" action="${createSpecificationURL}"
	name="<portlet:namespace/>specificationForm" id="specificationForm">
	
	<input type="hidden" id="submitButtonType"
		name="<portlet:namespace/>submitButtonType" /> <input type="hidden"
		name="<portlet:namespace/>specificationDetails"
		id="<portlet:namespace/>specificationDetails" value="" />

	<div class="container">
		<div class="addProductTitle">
			<h1 class="titlePage mt-4">Create Specification</h1>
			<div>
				<button type="button" class="btn btn-outline-secondary"
					onclick="formSubmit()">Save as Draft</button>
			</div>
		</div>
	</div>

	<div class="container specificationPage">
		<div class="customform stepperCustomform mb-4">
			<h2 class="h2Form">Specification Details</h2>

			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label for="specificationLabel"><liferay-ui:message
								key="specificationName" /><span class="requiredStar">*</span></label> <input
							type="text" id="specificationLabel"
							class="form-control editField requiredInput"
							name="<portlet:namespace/>specificationLabel"
							onpaste="return false;"
							onkeydown="return /[a-zA-Z\s]/.test(event.key);" maxlength="50"
							placeholder="Enter Specification Name"
							onblur="isSpecificationCreated()"> <label
							class="error errorMsg d-none specificationReq">This field
							cannot be left blank.</label> <label
							class="error errorMsg d-none specificationVal">Specification
							already exists.</label>
					</div>
				</div>
				<div class="col-md-12">
					<div class="form-group">
						<label for="specificationDescription"><liferay-ui:message
								key="specificationDescription" /></label>
						<textarea class="form-control editField"
							id="specificationDescription"
							name="<portlet:namespace/>specificationDescription"
							placeholder="Enter Specification Description"
							onkeydown="return /[a-zA-Z0-9|\.|,\s#!%&[\]'.,\/?*\$\{\}]/.test(event.key);"
							maxlength="250" onblur="checkValidationDesc(this.value)"></textarea>
						<label class="error errorMsg d-none invalidDesc">Invalid
							input</label>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="specificationFieldType"><liferay-ui:message
								key="specificationFieldType" /><span class="requiredStar">*</span></label>
						<select class="form-control editField requiredInput"
							id="specificationFieldType"
							name="<portlet:namespace/>specificationFieldType"
							onchange="getFieldType(this)">
							<option value="">Select Field Type</option>
							<c:forEach items="${specFieldTypes}" var="fieldType">
								<option value="${fieldType.specFieldTypeId}">${fieldType.fieldTypeName}</option>
							</c:forEach>
						</select> <label class="error errorMsg d-none fieldTypeReq">This
							field cannot be left blank.</label>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="specificationFieldDataType"><liferay-ui:message
								key="specificationFieldDataType" /><span class="requiredStar"
							id="fieldDataTypeReqStar">*</span></label> <select
							class="form-control editField requiredInput"
							id="specificationFieldDataType"
							name="<portlet:namespace/>specificationFieldDataType"
							onchange="addDataTypeInValueLabel();">
							<option value="">Select Field Data Type</option>
							<c:forEach items="${specFieldDataTypes}" var="dataType">
								<option value="${dataType.specFieldDataTypeId}">${dataType.fieldDataTypeName}</option>
							</c:forEach>
						</select> <label class="error errorMsg d-none fieldDataTypeReq">This
							field cannot be left blank.</label>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label for="selectCategory"><liferay-ui:message
								key="selectCategory" /></label>
						<%-- <div>
							<select class="multiselect-checkbox form-control" size="4" name="selectCategory" multiple="multiple" id="selectCategory">
							    <c:forEach items="${categories}" var="category">
								    <option value="${category.categoryId}" onchange="triggerCategorySelection(this);">${category.categoryName}</option>
							    </c:forEach>
							</select>
						</div> --%>


						<div class="dropdown multiselectCheckboxBox">
							<button class="btn btn-default dropdown-toggle form-control"
								type="button" data-toggle="dropdown">
								<span class="dropdown-text">Choose Category</span> <span
									class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<c:forEach items="${categories}" var="category">
									<li><label> <input name="category" type="checkbox"
											class="category" value='${category.categoryId}'
											data-categoryname="${category.categoryName}"
											onchange="triggerCategorySelection(this);" />
											${category.categoryName}
									</label></li>
								</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>

			<div class="table-responsive">
				<table class="table table-bordered" id="selectedCategories">
					<thead>
						<tr>
							<th style="min-width: 65px; width: 65px;">S. No</th>
							<th style="min-width: 280px;">Selected Category</th>
							<th width="180px" style="min-width: 180px;">Mandatory /<br>Non-Mandatory
							</th>
							<th width="80px" class="actionTd">Action</th>
						</tr>
					</thead>
					<tbody id="items-container">
						<tr id="noCategoriesMessage">
							<td colspan="4" class="text-center">No Categories selected</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div id="specificationValuesSection">
				<h2 class="h2Form">Specification Values</h2>
				<div class="table-responsive">
					<table class="table table-bordered" id="specificationValueTable">
						<thead>
							<tr>
								<th style="min-width: 65px; width: 65px;">S. No</th>
								<th style="min-width: 280px;">Value Label<span class="requiredStar">*</span></th>
								<th width="180px" style="min-width: 180px;">Unit of
									Measurement</th>
								<th width="80px" class="actionTd">Action</th>
							</tr>
						</thead>
						<tbody id="items-container">
							<tr class="item-container">
								<td>1</td>
								<td><input type="text"
									class="form-control valueLabel requiredInput" name="valueLabel"
									placeholder="Enter Value Label" /> <label
									class="error errorMsg d-none valueLabelReq">This field
										cannot be left blank.</label><label
									class="error errorMsg d-none valueLabelDupEditError">Duplicate
										name not valid.</label></td>
								<td><select class="form-control editField valueUOM"
									id="valueUOM" name="<portlet:namespace/>valueUOM">
										<option value="">Select UOM</option>
										<c:forEach items="${specValueUoms}" var="uom">
											<option value="${uom.valueUomName}">${uom.valueUomName}</option>
										</c:forEach>
								</select></td>
								<td class="actionTd">
									<button type="button" class="btn btn-link"
										style="text-transform: none;" onclick="checkDefaultRow();">
										<i class="fas fa-trash-alt delete-item"></i>
									</button>
								</td>
							</tr>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="4" class="text-right">
									<button id="add-item-btn" type="button"
										class="btn btn-link pl-0 pr-0">ADD VALUE</button>
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
			</div>

			<div class="bottomBarButton">
				<button type="button" onclick="window.location.replace('${viewUrl}');" class="btn btn-outline-secondary bigBtton">Cancel</button>
				<button class="btn btn-primary bigBtton" type="button"
					onclick="validateForm()">Submit</button>
			</div>

		</div>
	</div>
</form>


<script>

	var optionValueAddPendingArry = [];
	var optionValueEditPendingArry = [];
	var imagePath = "<%=request.getContextPath()%>";
	var fieldType;
	var descFlag = true;
	var labelFlag = true;
	var submitTypeFlag = true;
	
	$(document).ready(function() {
		$(".c-loader").removeClass("d-none");
		$(".portlet-title-text").addClass("d-none");
		//getDefault();
		$(".c-loader").addClass("d-none");
		validateRequiredInputs();
		
		// $('.multiselect-checkbox').multiselect();
		
	});
	
	function checkValidationDesc(value) {
		if (value !== "") {
			let regex = /^[a-zA-Z0-9|\.|,\s#!%&[\]'.,\/?*\$\{\}]+$/;
			if (regex.test(value)) {
				$(".invalidDesc").addClass("d-none");
				descFlag = true;
			} else {
				$(".invalidDesc").removeClass("d-none");
				descFlag = false;
			}
		} else {
			descFlag = true;
		}
	}

	function isSpecificationCreated() {
		var specificationLabel = $("#specificationLabel").val().trim();
		
		if (specificationLabel) {
			$.ajax({
				type : "GET",
				url : specificationLabelValURL,
				async : false,
				dataType : 'json',
				data : {
					"<portlet:namespace/>specificationLabel" : specificationLabel
				},
				success : function(data) {
					if (data.specificationLabelSize != '0') {
						$(".specificationVal").removeClass("d-none");
						$(".specificationReq").addClass("d-none");
						labelFlag = false;
					} else {
						$(".specificationVal").addClass("d-none");
						$(".specificationReq").addClass("d-none");
						labelFlag = true;
					}
				},
			});
		}
	}

	/* function getDefault() {
		var table = $('#specificationValueTable');

		// Destroy the DataTable
		table.DataTable().destroy();

		var table = $('#specificationValueTable')
				.DataTable(
						{
							"dom" : 't',
							"paging" : false,
							"language" : {
								"emptyTable" : '<div class="c-empty-state c-empty-state-animation"><div class="c-empty-state-image"><div class="c-empty-state-aspect-ratio"><img alt="" class="aspect-ratio-item aspect-ratio-item-fluid" src="'+imagePath+'/images/search_state.gif"></div></div><div class="c-empty-state-title"><span class="text-truncate-inline"><span class="text-truncate">No Results Found</span></span></div><div class="c-empty-state-text">Sorry, no results were found.</div></div>'
							}
						});

		if (table.data().count() === 0) {
			$('.dataTables_empty').parent('tr').remove();
		}
	}

	function addSpecificationValueDataTable() {
		var valueLabel = $(".specificationValueAddForm").find(
				'input[name="<portlet:namespace/>valueLabel"]').val();
		var valueUOM = $(".specificationValueAddForm").find(
				'select[name="<portlet:namespace/>valueUOM"]').val();
		var table = $('#specificationValueTable').DataTable();
		var data = table.rows().data().toArray();
		var randomNumber = Math.floor(Math.random() * 999) + 1;
		var newRow = {
			valueLabel : valueLabel,
			specificationValueId : randomNumber,
			valueUOM : valueUOM
		};
		data.push(newRow);
		optionValueAddPendingArry.push(newRow);
		var jsonString = JSON.stringify(optionValueAddPendingArry);
		$("#specificationValueHidden").val(jsonString);

		// Destroy the DataTable
		var dataTable = $('#specificationValueTable');
		dataTable.DataTable().destroy();

		var table = $('#specificationValueTable')
				.DataTable(
						{
							"dom" : 't',
							"paging" : false,
							"language" : {
								"emptyTable" : '<div class="c-empty-state c-empty-state-animation"><div class="c-empty-state-image"><div class="c-empty-state-aspect-ratio"><img alt="" class="aspect-ratio-item aspect-ratio-item-fluid" src="'+imagePath+'/images/search_state.gif"></div></div><div class="c-empty-state-title"><span class="text-truncate-inline"><span class="text-truncate">No Results Found</span></span></div><div class="c-empty-state-text">Sorry, no results were found.</div></div>'
							},
							data : data,
							"columns" : [
									{
										data : function(data) {
											return '<span>' + data.valueLabel
													+ '</span>';
										}
									},
									{
										data : "valueUOM"
									},
									{
										data : function(data) {
											return '<div><button type="button" onclick="editSpecificationValue(this, '
													+ data.specificationValueId
													+ ')" class="btn btn-link"><i class="fa fa-edit" aria-hidden="true"></i></button><button type="button" onclick="deleteSpecificationValue(this, '
													+ data.specificationValueId
													+ ')" class="btn btn-link"><i class="fa fa-trash" aria-hidden="true"></i></button></div>';
										}
									} ]
						});

		if (table.data().count() === 0) {
			$('.dataTables_empty').parent('tr').remove();
		}
	}

	function deleteSpecificationValue(e, specificationValueId) {
		var table = $('#specificationValueTable').DataTable();
		var data = table.rows().data().toArray();

		var foundObject = data.find(function(item) {
			return item.specificationValueId == specificationValueId;
		});
		console.log(foundObject);
		if (foundObject) {
			data = data.filter(function(item) {
				return item != foundObject;
			});
			// Update the DataTable with the modified data
			table.clear().rows.add(data).draw();

			//remove from optionValueAddPendingArry
			optionValueAddPendingArry = optionValueAddPendingArry
					.filter(function(item) {
						return item != foundObject;
					});

			var jsonString = JSON.stringify(optionValueAddPendingArry);
			$("#specificationValueHidden").val(jsonString);
		}
	}

	function editSpecificationValue(e, specificationValueId) {
		$('#editModal').modal('show');
		$('.valueLabelDupEditError').addClass('d-none');
		$('.valueUOMEditError').addClass('d-none');
		$('.valueLabelEditError').addClass('d-none');
		var parentTr = $(e).closest("tr");
		var valueLabel = parentTr.find("td:nth-child(1)").text();
		var valueUOM = parentTr.find("td:nth-child(2)").text();
		$(".specificationValueEditForm").find(
				'input[name="<portlet:namespace/>valueLabelEdit"]').val(
				valueLabel);
		$(".specificationValueEditForm").find(
				'select[name="<portlet:namespace/>valueUOMEdit"]')
				.val(valueUOM);
		$(".specificationValueEditForm").find(
				'input[name="<portlet:namespace/>valueLabelEdit"]').attr(
				"data-id", valueLabel);
		$("#editSaveBtn").data("id", specificationValueId);
	}

	function saveEditSpecificationValue() {
		var valueLabelEdit = $(".specificationValueEditForm").find(
				'input[name="<portlet:namespace/>valueLabelEdit"]').val();
		var reqValidation = editSpecificationValueValidation();
		var noChange = $(".specificationValueEditForm").find(
				'input[name="<portlet:namespace/>valueLabelEdit"]').attr(
				"data-id") == valueLabelEdit;
		if (noChange) {
			editSpecificationValueDataTable();
			$('#editModal').modal('hide');
		} else if (reqValidation) {
			if (editValueDuplicateValidation(valueLabelEdit)) {
				editSpecificationValueDataTable();
				$('#editModal').modal('hide');
			}
		}
	}

	function editSpecificationValueValidation() {
		var valueLabelEditLength = $(".specificationValueEditForm").find(
				'input[name="<portlet:namespace/>valueLabelEdit"]').val().length;
		var valueUOMEditLength = $(".specificationValueEditForm").find(
				'select[name="<portlet:namespace/>valueUOMEdit"]').val().length;

		if (valueLabelEditLength == 0) {
			$('.valueLabelEditError').removeClass('d-none');
		} else {
			$('.valueLabelEditError').addClass('d-none');
		}

		if (valueUOMEditLength == 0) {
			$('.valueUOMEditError').removeClass('d-none');
		} else {
			$('.valueUOMEditError').addClass('d-none');
		}

		if (valueLabelEditLength != 0 && valueUOMEditLength != 0) {
			return true;
		} else {
			return false;
		}
	}

	function editValueDuplicateValidation(valueLabelEdit) {
		var table = $('#specificationValueTable').DataTable();
		var data = table.rows().data().toArray();
		var duplicateValueLabel = true;
		var valueLabels = data.map(function(item) {
			if (valueLabelEdit.toLowerCase() == item.valueLabel.toLowerCase()) {
				duplicateValueLabel = false;
				return;
			}
		});

		if (duplicateValueLabel) {
			$('.valueLabelDupEditError').addClass('d-none');
		} else {
			$('.valueLabelDupEditError').removeClass('d-none');
		}
		return duplicateValueLabel;
	}

	function editSpecificationValueDataTable() {
		var valueLabelEdit = $(".specificationValueEditForm").find(
				'input[name="<portlet:namespace/>valueLabelEdit"]').val();
		var valueUOMEdit = $(".specificationValueEditForm").find(
				'select[name="<portlet:namespace/>valueUOMEdit"]').val();
		var specificationValueId = $("#editSaveBtn").data("id");

		var table = $('#specificationValueTable').DataTable();
		var data = table.rows().data().toArray();
		var newRow = {
			valueLabel : valueLabelEdit,
			specificationValueId : specificationValueId,
			valueUOM : valueUOMEdit
		};

		data = data.filter(function(item) {
			return item.specificationValueId != newRow.specificationValueId;
		});
		data.push(newRow);

		if (newRow.specificationValueId < 1000) {
			var specificationValueHidden = $("#specificationValueHidden").val();
			if (specificationValueHidden == ""
					|| specificationValueHidden == "[]") {
				optionValueAddPendingArry.push(newRow);
				var jsonString = JSON.stringify(optionValueAddPendingArry);
				$("#specificationValueHidden").val(jsonString);
			} else {
				optionValueAddPendingArry = optionValueAddPendingArry
						.filter(function(item) {
							return item.specificationValueId != newRow.specificationValueId;
						});
				optionValueAddPendingArry.push(newRow)
				$("#specificationValueHidden").val(
						JSON.stringify(optionValueAddPendingArry));
			}
		} else {
			var specificationValueEditHidden = $(
					"#specificationValueEditHidden").val();
			if (specificationValueEditHidden == ""
					|| specificationValueEditHidden == "[]") {
				optionValueEditPendingArry.push(newRow);
				var jsonString = JSON.stringify(optionValueEditPendingArry);
				$("#specificationValueEditHidden").val(jsonString);
			} else {
				optionValueEditPendingArry = optionValueAddPendingArry
						.filter(function(item) {
							return item.specificationValueId != newRow.specificationValueId;
						});
				optionValueEditPendingArry.push(newRow);
				$("#specificationValueEditHidden").val(
						JSON.stringify(optionValueEditPendingArry));
			}
		}

		// Destroy the DataTable
		var dataTable = $('#specificationValueTable');
		dataTable.DataTable().destroy();

		var table = $('#specificationValueTable')
				.DataTable(
						{
							"dom" : 't',
							"paging" : false,
							"language" : {
								"emptyTable" : '<div class="c-empty-state c-empty-state-animation"><div class="c-empty-state-image"><div class="c-empty-state-aspect-ratio"><img alt="" class="aspect-ratio-item aspect-ratio-item-fluid" src="'+imagePath+'/images/search_state.gif"></div></div><div class="c-empty-state-title"><span class="text-truncate-inline"><span class="text-truncate">No Results Found</span></span></div><div class="c-empty-state-text">Sorry, no results were found.</div></div>'
							},
							data : data,
							"columns" : [
									{
										data : function(data) {
											return '<span>' + data.valueLabel
													+ '</span>';
										}
									},
									{
										data : "valueUOM"
									},
									{
										data : function(data) {
											return '<div><button type="button" onclick="editSpecificationValue(this, '
													+ data.specificationValueId
													+ ')" class="btn btn-link"><i class="fa fa-edit" aria-hidden="true"></i></button><button type="button" onclick="deleteSpecificationValue(this, '
													+ data.specificationValueId
													+ ')" class="btn btn-link"><i class="fa fa-trash" aria-hidden="true"></i></button></div>';
										}
									} ]
						});

		if (table.data().count() === 0) {
			$('.dataTables_empty').parent('tr').remove();
		}
	} */

	function getFieldType(obj) {
		if (obj.value != "") {
			$.ajax({
				type : "GET",
				url : specificationFieldTypeValURL,
				async : false,
				dataType : 'json',
				data : {
					"<portlet:namespace/>fieldTypeId" : obj.value
				},
				success : function(data) {
					fieldType = data.fieldType;
				},
			});
		}
		
		addDataTypeInValueLabel();

		if($(obj).find('option:selected').text().trim() === 'Free Text') {
			$('#specificationValuesSection').addClass('d-none');
			$('#specificationFieldDataType').attr('disabled', true);
			$('#specificationFieldDataType').removeClass('requiredInput');
			$('.fieldDataTypeReq').addClass('d-none');
			$('#fieldDataTypeReqStar').addClass('d-none');
			$('.valueLabel').removeClass('requiredInput');
		} else {
			$('#specificationValuesSection').removeClass('d-none');
			$('#specificationFieldDataType').attr('disabled', false);
			$('#specificationFieldDataType').addClass('requiredInput');
			$('#fieldDataTypeReqStar').removeClass('d-none');
			$('.valueLabel').addClass('requiredInput');
		}
		
	}

	function formSubmit() {
		var specificationLabel = $("#specificationLabel").val().trim();
		if (submitTypeFlag) {
			$("#submitButtonType").val('SAVE_AS_DRAFT');
		}

		if (specificationLabel == "") {
			$(".specificationReq").removeClass("d-none");
			$(".specificationVal").addClass("d-none");
			$("#specificationLabel").focus();
		}

		if (specificationLabel != "" && labelFlag) {
			
			$('#<portlet:namespace/>specificationDetails').val(constructFormJson());
			
			$("#specificationForm").submit();
		}
	}

	/* Start of New Code For specification Creation */
	
	// Event delegation for delete button functionality
	document.querySelectorAll('#items-container').forEach(element => {
		element.addEventListener('click', function(event) {
			if (event.target.classList.contains('delete-item')) {
				event.target.parentElement.parentElement.parentElement.remove();
				generateSerialNumbers('specificationValueTable');
			}
		});
	});
	
	document.getElementById('add-item-btn').addEventListener('click', function() {
		
		var isNotEmpty = true;
		var isDuplicate = false;
		
		$('.noPackageContentError').addClass('d-none');
		
		$('#specificationValuesSection table tbody tr').each(function() {
	
	        $(this).find('input.form-control').each(function() {
	            if($(this).val() == '') {
					isNotEmpty = false;
					$(this).siblings('label.valueLabelReq').removeClass('d-none');
				} else if(!isValueLabelUnique($(this))) {
					isDuplicate = true;
					return;
				}
	        });
		});
		
		if(isNotEmpty && !isDuplicate) {
			
			$('#specificationValuesSection table tbody tr label.error').each(function() {
				$(this).addClass('d-none');
			});
			
			addRowToSpecificationTable();
			validateValueLabel();
		}
	    
	});
	
	var addRowToSpecificationTable = () => {
		
		var itemsContainer = document.querySelector('#specificationValueTable #items-container');
	      
	    // Create container for new item
	    var newItemContainer = document.createElement('tr');
	    newItemContainer.classList.add('item-container');
	
	    var sNoTd = '<td></td>';
	    newItemContainer.innerHTML += sNoTd;
	    
	    var valueLabelTd = `<td>
							<input type="text" class="form-control valueLabel requiredInput" name="valueLabel" placeholder="Enter Value Label" /> <label
								class="error errorMsg d-none valueLabelReq">This field cannot be
								left blank.</label> <label
								class="error errorMsg d-none valueLabelDupEditError">Duplicate
								name not valid.</label>
	    						</td>`;
	    newItemContainer.innerHTML += valueLabelTd;
	    
	    var uomTd = `<td>
	  	  				<select class="form-control editField valueUOM" id="valueUOM"
							name="<portlet:namespace/>valueUOM">
							<option value="">Select UOM</option>
							<c:forEach items="${specValueUoms}" var="uom">
								<option value="${uom.valueUomName}">${uom.valueUomName}</option>
							</c:forEach>
						</select>
  				   </td>`;
	    newItemContainer.innerHTML += uomTd;
	    
	    var deleteActionTd = `<td class="actionTd">
	  	  						<button type="button" class="btn btn-link" style="text-transform: none;" onclick="checkDefaultRow();">
								<i class="fas fa-trash-alt delete-item"></i>
							</button>
						</td>`;
	    newItemContainer.innerHTML += deleteActionTd;
	    
	    itemsContainer.append(newItemContainer);
	    
	    validateRequiredInputs();
	    
	    generateSerialNumbers('specificationValueTable');
		
	};
	
	var triggerCategorySelection = currentObj => {
		
		var itemsContainer = document.querySelector('#selectedCategories #items-container');
		var currentObjValue = currentObj.value;

		if(currentObj.checked) {
			
			$('#noCategoriesMessage').addClass('d-none');
			
		    // Create container for new item
		    var newItemContainer = document.createElement('tr');
		    newItemContainer.classList.add('item-container');
		    newItemContainer.dataset.categoryid = currentObj.value;
		
		    var sNoTd = '<td></td>';
		    newItemContainer.innerHTML += sNoTd;
		    
		    var categoryNameTd = '<td><label class="categoryName mb-0" data-categoryid="' + currentObjValue + '" data-categoryname="'+ currentObj.dataset.categoryname + '">' + currentObj.dataset.categoryname + '</label></td>';
		    newItemContainer.innerHTML += categoryNameTd;
		    
		    var isCategoryMandatory = '<td><input type="checkbox" class="isCategoryMandatory" name="isCategoryMandatory" id="" /></td>';
		    newItemContainer.innerHTML += isCategoryMandatory;
		    
		    var deleteActionTd = '<td class="actionTd">' +
		  	  						'<button type="button" class="btn btn-link" style="text-transform: none;" onclick="unselectCheckedCategory(' + currentObjValue + ');">' +
									'<i class="fas fa-trash-alt delete-item"></i>' +
								'</button>' +
							'</td>';
		    newItemContainer.innerHTML += deleteActionTd;
		    
		    itemsContainer.append(newItemContainer);
			
		} else {
			
			$(itemsContainer).find('.item-container').each(function() {
				
				if($(this).attr('data-categoryid') === currentObjValue) {
					$(this).remove();
				}
				
			});
			
		}
		
		generateSerialNumbers('selectedCategories');
		
	};
	
	var unselectCheckedCategory = categoryId => {
		
		$('.category:checked').each(function() {
			if($(this).val() == categoryId) {
				$(this).prop('checked', false);
				return;
			}
		});
		
		generateSerialNumbers('selectedCategories');
		
	};
	
	var generateSerialNumbers = (tableId) => {
		
		$('#' + tableId).find('tbody tr:not(#noCategoriesMessage)').each(function(index) {
			$(this).find('td').eq(0).text(index + 1);
		});
		
		var itemsContainer = document.querySelector('#selectedCategories #items-container');
		
		if($(itemsContainer).find('.item-container').length == 0)
			$('#noCategoriesMessage').removeClass('d-none');
		
	};
	
	var constructFormJson = () => {
		
		var selectedCategories = [];
		var specificationValues = [];
		
		$('#selectedCategories tbody tr:not(#noCategoriesMessage)').each(function() {
			
			var categoryId = $(this).find('.categoryName').attr('data-categoryid');
			var categoryName = $(this).find('.categoryName').attr('data-categoryname');
			var isCategoryMandatory = $(this).find('.isCategoryMandatory').prop('checked');
			
			var category = {
				'categoryId' : categoryId,
				'categoryName' : categoryName,
				'isCategoryMandatory' : isCategoryMandatory
			};
			
			selectedCategories.push(category);
			
		});
		
		$('#specificationValueTable tbody tr').each(function() {
			
			var valueLabel = $(this).find('.valueLabel').val();
			var valueUOM = '';
			
			if($(this).find('.valueUOM').val()) {
				valueUOM = $(this).find('.valueUOM').val();
			}
			
			var specificationValue = {
				'valueLabel' : valueLabel,
				'valueUOM' : valueUOM
			};
			
			specificationValues.push(specificationValue);
			
		});
		
		var formJson = {
			'selectedCategories' : selectedCategories,
			'specificationValues' : specificationValues
		};
		
		return JSON.stringify(formJson);
		
	};
	
	var checkDefaultRow = () => {
		if(($('#specificationValuesSection table tbody tr').length - 1) === 0) {
			addRowToSpecificationTable();
		}
	};
	
	var validateRequiredInputs = () => {
		$('.requiredInput').on('change', function() {
			if($(this).val()) {
				$(this).siblings('label.error').eq(0).addClass('d-none');
			} else {
				$(this).siblings('label.error').eq(0).removeClass('d-none');
			}
		});
	};
	
	var validateValueLabel = currObj => {
		if($(currObj).val()) {
			$(currObj).siblings('label.error').eq(0).addClass('d-none')
		} else {
			$(currObj).siblings('label.error').eq(0).removeClass('d-none')
		}
	};
	
	var addDataTypeInValueLabel = () => {
		
		$('#specificationValuesSection .delete-item').click();
		
		validateValueLabel();
		
	};
	
	var validateValueLabel = () => {
		
		var allowedEventsArr = ['Backspace','Delete','ArrowLeft','ArrowRight', 'Tab', 'ctrlKey', 'Space'];
		
		$('.valueLabel').on('keydown', function(event) {
			if($('#specificationFieldDataType').val()) {
				
				switch($('#specificationFieldDataType').find('option:selected').text().trim()) {
				
				case 'Text' : return /[a-zA-Z\s]/.test(event.key) || allowedEventsArr.includes(event.code); 
					break;
				
				case 'Numeric' : return /^\d+$/.test(event.key) || allowedEventsArr.includes(event.code);
					break;
					
				case 'Alphanumeric' : return /[a-zA-Z0-9\s]/.test(event.key) || allowedEventsArr.includes(event.code);
					break;
				
				}
				
			}
		});
		
		$('.valueLabel').on('input', function() {
			
			if($('#specificationFieldDataType').val()) {
				
				switch($('#specificationFieldDataType').find('option:selected').text().trim()) {
				
				case 'Text' : {
						$(this).val($(this).val().replace(/[^a-z\s]/gi, ''));
					}
					break;
				
				case 'Numeric' : {
						$(this).val($(this).val().replace(/[^0-9]/gi, ''));
					}
					break;
					
				case 'Alphanumeric' : {
					$(this).val($(this).val().replace(/[^a-zA-Z0-9\s]/gi, ''));
					}
					break;
				}
				
			}
			
		});
		
		$('.valueLabel').on('focusout', function() {
			
			if($(this).val()) {
				if(!isValueLabelUnique($(this))) {
					$(this).siblings('.valueLabelReq').eq(0).addClass('d-none');
					$(this).siblings('.valueLabelDupEditError').eq(0).removeClass('d-none');
					$(this).focus();
				} else {
					$(this).siblings('.valueLabelDupEditError').eq(0).addClass('d-none');
				}
			}
			
		});
		
	};
	
	var isValueLabelUnique = (currObj) => {
		return $('.valueLabel').filter(function() {return $(this).val().trim() === $(currObj).val().trim()}).length <= 1;
	};
	
	var validateForm = () => {
		
		var isNotEmpty = true;
		
		$('.requiredInput').each(function() {
			if(!$(this).val()) {
				$(this).siblings('label.error').eq(0).removeClass('d-none');
				isNotEmpty = false;
				return isNotEmpty;
			} else {
				$(this).siblings('label.error').eq(0).addClass('d-none');
				isNotEmpty = true;
			}
		});
		
		if(isNotEmpty && labelFlag && descFlag) {
			$("#submitButtonType").val('SUBMIT_FORM');
			$('label.error').addClass('d-none');
			submitTypeFlag = false;
			
			formSubmit();
		} else {
			return false;
		}
		
	};
	
</script>
