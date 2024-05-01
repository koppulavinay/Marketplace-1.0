<%@ include file="/init.jsp"%>

<script type="text/javascript">
	$('#customLoader').show();
</script>

<portlet:renderURL var="backURL">
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

<portlet:actionURL var="variantSelectionURL" name="variantSelection" />

<liferay-ui:success key="specification-key" message="Specification Details Saved Successfully!" />

<form action="${variantSelectionURL}" method="post" id="variantForm">

	<input type="hidden" id="<portlet:namespace/>productStatus" name="<portlet:namespace/>productStatus" value="" />
	<input type="hidden" id="<portlet:namespace/>stepNumber" name="<portlet:namespace/>stepNumber" value="4" />

	<div class="container">
		<div class="addProductTitle">
			<h1 class="titlePage mt-4">Product Creation</h1>
			<div>
				<%@ include file="/last_modified_date.jsp"%>
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
								<a href="${backURL}">3</a>
							</div>
							<div class="step-name">Specification</div>
						</div>
						<div class="stepper-item active">
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
					</div>
				</div>
			</section>

			<h2 class="h2Form">Variant</h2>
			<input type="hidden" id="draftProductId"
				name="<portlet:namespace/>draftProductId" value="${draftProductId}">

			<div class="row">
				<div class="col-md-12 mb-5">
					<div class="variantBox">
					<div id="editInputContainer" style="display: none;">
						<div class="form-group">
						<label>List Name</label>
						<!-- Static input field -->
						<input type="text" id="editStaticInput" class="form-control" placeholder="List Name" 
							onpaste="return false;" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" maxlength="25"
							onblur="capitalizeFirst(this); enableUpdateButton()">
						<div class="editInputErrorMessage" style="display: none;">Please enter a unique value.</div>
						</div>
						
						<div class="form-group mb-0">
							<label>Values (Note: Minimum one value required)</label>
						</div>
						<!-- Initially, there is one dynamic input field -->
						<div id="editDynamicInputsContainer">
								<div class="inputBox">
									<input type="text" class="form-control editDynamicInput" value="" placeholder="Value"
										onpaste="return false;" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" maxlength="25"
										onblur="capitalizeFirst(this)">
									<div class="editErrorMessage" style="display: none;">Please enter a unique value.</div>
									<!-- Error message for duplication -->
								</div>
						</div>
					</div>

					<div class="variantBtnBar">
					<!-- Submit button to get values -->
					<button type="button" class="btn btn-outline-secondary updateBack mb-4" style="display: none">Cancel</button>
					<button id="editSubmitButton" class="btn btn-primary mb-4"
						style="display: none;" type="button" onclick="updateVariantForm()">Update Variant Details</button>
					</div>

					<div id="outputValues"></div>

					<!-- Display area for input values -->
					<div id="inputValues" style="width: 100%;"></div>

					<!-- Container for static and dynamic input fields -->
					<div id="inputContainer" style="display: none;">
						<div class="form-group">
							<input type="hidden" name="<portlet:namespace/>variantValueHidden"
								id="variantValueHidden" />
								
							<label>List Name</label>
							<!-- Static input field -->
							<input type="text" id="staticInput" class="form-control" placeholder="List Name" 
								onpaste="return false;" onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" maxlength="25"
								onblur="capitalizeFirst(this); enableSubmitButton()">
							<div class="inputErrorMessage" style="display: none;">Please enter a unique value.</div>
						</div>
						
						<div class="form-group mb-0">
							<label>Values (Note: Minimum one value required)</label>
						</div>
						
						<!-- Initially, there is one dynamic input field -->
						<div id="dynamicInputsContainer">
							<div class="inputBox">
								<input type="text" class="dynamicInput form-control" value="" placeholder="Value"
									onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\s]/.test(event.key)" maxlength="25"
									onblur="capitalizeFirst(this)">
								<div class="errorMessage" style="display: none;">Please enter a unique value.</div>
								<!-- Error message for duplication -->
								<button class="btn btn-link deleteButton" type="button"><i class="fas fa-trash-alt"></i></button>
							</div>
						</div>
					</div>
					
					<div class="variantBtnBar">
					<!-- Submit button to get values -->
					<button type="button" class="btn btn-outline-secondary submitBack mb-4" style="display: none">Cancel</button>
					<button id="submitButton" class="btn btn-primary mb-4"
						style="display: none;" type="button" onclick="submitVariantForm()">Save Variant Details</button>
					</div>

					<div class="addVariant">
						<button id="showInputs" type="button"
							class="btn btn-link pl-0 pr-0">+ Add Variant</button>
					</div>
					
					</div>

					<div class="stepperBarButton">
						<a href="${backURL}" class="btn btn-outline-secondary bigButton">Back</a>
						<button type="submit" class="btn btn-primary bigButton">Save & Continue</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</form>

<form id="submitForm">
	<input type="hidden" id="draftProductId"
		name="<portlet:namespace/>draftProductId" value="${draftProductId}">
	<input type="hidden" name="<portlet:namespace/>cmd" value="Add">
	<div id="mainCat"></div>
	<div id="subCat"></div>
</form>

<form id="updateForm">
	<input type="hidden" id="draftProductId"
		name="<portlet:namespace/>draftProductId" value="${draftProductId}">
	<input type="hidden" id="productVariantId"
		name="<portlet:namespace/>productVariantId"> <input
		type="hidden" name="<portlet:namespace/>cmd" value="Update">
	<div id="editMainCat"></div>
	<div id="editSubCat"></div>
</form>

<script>
        var staticValues = []; // Array to store static values and their corresponding dynamic values
        var editStaticValues = [];
        var newVariantArray = []; // This will hold the array of variant objects
        var allVariantArray = [];
        var output = "<p>Output Values:</p>";
        var editVariantName = "";
        var variants = [];
	
       function submitVariantForm(){
    	   var mainCat= "<input type='hidden' id='mainCatId' name='<portlet:namespace/>variantName' value='"+$("#staticInput").val()+"' />";
    	   $("#mainCat").append(mainCat);
    	   var subcat ="";
    	   $(".dynamicInput").each(function() {
    		   var val = $(this).val().trim();
    		   if(val != ''){
    			   subcat = subcat + "<input type='hidden' class='subCatId' name='<portlet:namespace/>variantValues' value='"+val+"' />";
    		   }
    	   });
    	   
    	   $("#subCat").append(subcat);
    	   
    	   var ajaxForm = $("#submitForm");
    	   $.ajax({
				type:"GET",
				url:saveVariantValueURL,
				async:false,
				dataType: 'json',
				data:ajaxForm.serialize(),
				success:function(data){
		             $("#staticInput").val("");
		             $(".dynamicInput").val(""); // Clear dynamic inputs
		             $("#inputContainer").hide(); // Hide input container after submitting
		             $("#submitButton").hide();
		             $(".addVariant").removeClass("d-none");
		             location.reload();
				},
			});
       }
       
       function updateVariantForm(){
    	   var mainCat= "<input type='hidden' id='mainCatId' name='<portlet:namespace/>variantName' value='"+$("#editStaticInput").val()+"' />";
    	   $("#editMainCat").append(mainCat);
    	   var subcat ="";
    	   $(".editDynamicInput").each(function() {
    		   var val = $(this).val().trim();
    		   var id = $(this).attr("data-id");
    		   if(val != ''){
    			   subcat = subcat + "<input type='hidden' class='subCatId' name='<portlet:namespace/>variantValueId' value='"+id+"' />";
    			   subcat = subcat + "<input type='hidden' class='subCatName' name='<portlet:namespace/>variantVaue' value='"+val+"' />";
    		   }
    	   });
    	   
    	   $("#editSubCat").append(subcat);
    	   
    	   var ajaxForm = $("#updateForm");
    	   $.ajax({
				type:"GET",
				url:saveVariantValueURL,
				async:false,
				dataType: 'json',
				data:ajaxForm.serialize(),
				success:function(data){
		             $("#editStaticInput").val("");
		             $(".editDynamicInput").val(""); // Clear dynamic inputs
		             $("#editInputContainer").hide(); // Hide input container after submitting
		             $("#editSubmitButton").hide();
		             $(".updateBack").hide();
		             $(".addVariant").removeClass("d-none");
		             location.reload();
				},
			});
       }
       
       function capitalizeFirst(obj) {
    	   	var inputValue = obj.value.trim();
	   	   	var capitalizedValue = inputValue.replace(/(?:^|\s)\S/g, function(a) { return a.toUpperCase(); });
	   		obj.value = capitalizedValue;
       }
       
     // Function to add input field dynamically when user interacts with the last input field
        $("#inputContainer").on("input", ".dynamicInput", function() {
            var $inputBox = $(this).closest(".inputBox");
            var inputValue = $(this).val().trim(); // No lowercase conversion here
			var inputCnt =$(this).closest("#dynamicInputsContainer").find(".inputBox").length;
            
            
            // Check if the last input field has any value
            if ($inputBox.is(":last-child") && inputValue !== "") {
            	var newInputBox = $('<div class="inputBox"><input type="text" class="dynamicInput form-control" value="" placeholder="Value" onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\\s]/.test(event.key)" maxlength="25" onblur="capitalizeFirst(this)"><div class="errorMessage" style="display: none;">Please enter a unique value.</div><button class="btn btn-link deleteButton" type="button"><i class="fas fa-trash-alt"></i></button></div>');
                $("#dynamicInputsContainer").append(newInputBox);
            }
            enableSubmitButton(); // Check duplication and enable/disable submit button
        });

        // Function to add input field dynamically when user interacts with the last input field
        $("#editInputContainer").on("input", ".editDynamicInput", function() {
           
            var $inputBox = $(this).closest(".inputBox");
            var inputValue = $(this).val().trim(); // No lowercase conversion here

            // Check if the last input field has any value
            if ($inputBox.is(":last-child") && inputValue !== "") {
            	var newInputBox = $('<div class="inputBox"><input type="text" class="form-control editDynamicInput" value="" placeholder="Value" onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\\s]/.test(event.key)" maxlength="25" onblur="capitalizeFirst(this)"><div class="editErrorMessage" style="display: none;">Please enter a unique value.</div><button class="btn btn-link editDeleteButton" type="button" onclick="deleteVariant(this, 0)"><i class="fas fa-trash-alt"></i></button></div>');
                $("#editDynamicInputsContainer").append(newInputBox);
            }
            enableUpdateButton(); // Check duplication and enable/disable submit button
        });
        
        $(document).ready(function() {
        	
            // Initially, the submit button is enabled
            $("#submitButton").prop('disabled', false);
            variants.push('${variants}');
            //newVariantArray.push('${variants}');
            var variantsValue = JSON.parse(variants);
            for(var i=0; i < variantsValue.length; i++){
            	allVariantArray.push(variantsValue[i])
            }
            newVariantArray = variantsValue;

            if (variants != '[]') {
                displayValues(JSON.parse(variants), true);
            }
			
			$('#customLoader').hide();
        });
        
        $(".submitBack").click(function() {
        	$("#inputContainer").toggle(); // Toggle visibility of the input container
            $("#submitButton").toggle(); // Toggle visibility of the submit button
            $(this).hide(); 
            $("#staticInput").val("");
            $(".dynamicInput").val("");
            $(".errorMessage").hide();
            $(".addVariant").removeClass("d-none");
            
        });
        
        $(".updateBack").click(function() {
        	$("#editInputContainer").toggle(); // Toggle visibility of the input container
            $("#editSubmitButton").toggle(); // Toggle visibility of the submit button
            $(this).hide(); 
            $("#editStaticInput").val("");
            $(".editDynamicInput").val("");
            $(".editErrorMessage").hide();
            $(".addVariant").removeClass("d-none");
            displayValues(JSON.parse(variants), true);
            
        });

        //Function to show static and dynamic input fields
        $("#showInputs").click(function() {
            $("#inputContainer").toggle(); // Toggle visibility of the input container
            $("#submitButton").toggle(); // Toggle visibility of the submit button
            $(".submitBack").toggle(); 
            if ($("#inputContainer").is(":visible")) {
                // Remove all dynamic input fields except the first one
                $("#dynamicInputsContainer").find('.inputBox:not(:first)').remove();
                $("#staticInput").focus(); // Focus on the static input field
            } else {
                // Clear all input fields and error messages
                $("#staticInput").val("");
                $(".dynamicInput").val("");
                $(".errorMessage").hide();
            }
            enableSubmitButton(); // Check if submit button should be enabled/disabled
            $(".addVariant").addClass("d-none");
        });

        // Function to delete the respective input box
        $("#inputContainer").on("click", ".deleteButton", function() {
            $(this).parent().remove();
            enableSubmitButton(); // Enable submit button if any input box is removed
        });

        function displayValues(data, flag) {
            var deleteVariantId;
            var outputTag = "";
            for (var i = 0; i < data.length; i++) {
            	outputTag += "<p class='variantGroup ptag__"+data[i].variantName+"'>" + "<strong><span class='variantNameCheck'>" + data[i].variantName + "</span></strong>";

                if (flag) {
                    deleteVariantId = data[i].productVariantId;
                } else {
                    deleteVariantId = 0;
                }

                // Hidden productVariantId
                outputTag += "<input type='hidden' name='productVariantId'  class='productVariantId' value='" + data[i].productVariantId + "' />";

                // Iterate through each variant value
                for (var j = 0; j < data[i].variantValues.length; j++) {
                    var variantValue = data[i].variantValues[j];

                    // Hidden variantValueId
                    outputTag += "<span style='display:none;'>";
                    outputTag += "<input type='hidden' name='variantValueId'  data-id='"+variantValue.variantValueId+"' value='" + variantValue.variantValueId + "' />";
                    outputTag += "</span>";

                    outputTag += "<span class='varValue'>" + variantValue.variantValue + "</span>"; // Display variantValue

                    // Check if it's not the last variant value
                    if (j !== data[i].variantValues.length - 1) {
                    	outputTag += ""; // Add a comma if it's not the last variant value
                    }
                }

                outputTag += " <button type='button' class='btn btn-link editVariant' onclick='editVariant(" + JSON.stringify(data[i]) + ", " + flag + ", " + data[i].productVariantId +  ", \"" + data[i].variantName +"\")'><i class='fas fa-pen'></i></button><button type='button' class='btn btn-link deleteButton1' onclick='deleteVariant(this, " + deleteVariantId + ")'><i class='fas fa-trash-alt'></i></button></p>";
            }

            $("#outputValues").html(outputTag);
        }
		
        // Function to enable submit button if all input fields are valid
        function enableUpdateButton() {
            
            var isDuplicate = false;

            if($("#editStaticInput").val().trim() !== '') {
	            $(".variantNameCheck").each(function() {
	            	var variantName = $(this).text().trim().toLowerCase();
	            	
	            	if (variantName !== '' && !isDuplicate && editVariantName.toLowerCase() !== variantName) {
	                    if (variantName == $("#editStaticInput").val().toLowerCase()) {
	                        isDuplicate = true;
	                        $('.editInputErrorMessage').show();
	                    } else {
	                    	$('.editInputErrorMessage').hide();
	                    	isDuplicate = false;
	                    }
	                }
	            });
	            
	            // Check for duplication
	            if(!isDuplicate && areUpdateValuesPresent()) {
		            var values = {};
		            $(".editDynamicInput").each(function() {
		                var value = $(this).val().trim().toLowerCase(); // Convert to lowercase here for comparison
		                if (value !== '') {
		                    if (values[value]) {
		                        isDuplicate = true;
		                        $(this).closest('.inputBox').find('.editErrorMessage').show();
		                    } else {
		                        $(this).closest('.inputBox').find('.editErrorMessage').hide();
		                    }
		                    values[value] = true;
		                }
		            });
		
	            } else {
	            	isDuplicate = true;
	            }
            } else {
            	isDuplicate = true;
            }
            
            $("#editSubmitButton").prop('disabled', isDuplicate); // Enable submit button if all inputs are valid
        }
        
        function areUpdateValuesPresent(){
        	return $(".editDynamicInput").filter(function() {return $(this).val().trim() !== ''}).length > 0;
        }

        // Function to enable submit button if all input fields are valid
        function enableSubmitButton() {
            var isDuplicate = false;
            
			if($("#staticInput").val().trim() !== '') {
	            $(".variantNameCheck").each(function() {
	            	var variantName = $(this).text().trim().toLowerCase();
	            	
	            	if (variantName !== '' && !isDuplicate) {
	                    if (variantName == $("#staticInput").val().toLowerCase()) {
	                        isDuplicate = true;
	                        $('.inputErrorMessage').show();
	                    } else {
	                    	$('.inputErrorMessage').hide();
	                    	isDuplicate = false;
	                    }
	                }
	            });
	            
	            // Check for duplication
	            if(!isDuplicate && areSubmitValuesPresent()) {
		            var values = {};
		            $(".dynamicInput").each(function() {
		                var value = $(this).val().trim().toLowerCase(); // Convert to lowercase here for comparison
		                if (value !== '') {
		                    if (values[value]) {
		                        isDuplicate = true;
		                        $(this).closest('.inputBox').find('.errorMessage').show();
		                    } else {
		                        $(this).closest('.inputBox').find('.errorMessage').hide();
		                    }
		                    values[value] = true;
		                }
		            });
	
	            } else {
	            	isDuplicate = true;
	            }
			} else {
				isDuplicate = true;
			}
            
            $("#submitButton").prop('disabled', isDuplicate); // Enable submit button if all inputs are valid
        }
        
        function areSubmitValuesPresent(){
        	return $(".dynamicInput").filter(function() {return $(this).val().trim() !== ''}).length > 0;
        }

        function editVariant(value, flag, variantId, variantName) {
            var deleteVariantId;
            $("#inputContainer").hide();
            $("#submitButton").hide();
            $(".submitBack").hide(); 
            $("#productVariantId").val(variantId);
            $("#editStaticInput").val(value.variantName);
            $("#editDynamicInputsContainer").empty();
            $(".variantGroup").addClass('d-none');
            editVariantName = variantName;

            for (var i = 0; i < value.variantValues.length; i++) {
                //if (flag) {
                    deleteVariantId = value.variantValues[i].variantValueId;
               // } else {
                    //deleteVariantId = 0;
                //}
                var dynamicInputBox = $('<div class="inputBox"><input type="text" class="editDynamicInput form-control" placeholder="Value" var-id="'+value.productVariantId+'" data-id="' + deleteVariantId + '" value="' + value.variantValues[i].variantValue + '" onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\\s]/.test(event.key)" maxlength="25" onblur="capitalizeFirst(this)"><div class="editErrorMessage" style="display: none;">Please enter a unique value.</div><button type="button" class="btn btn-link editDeleteButton" onclick="deleteVariantValue(this, ' + deleteVariantId + ')"><i class="fas fa-trash-alt"></i></button></div>');
                $("#editDynamicInputsContainer").append(dynamicInputBox);
            }

            var emptyDynamicInputBox = $('<div class="inputBox"><input type="text" class="editDynamicInput form-control" placeholder="Value" var-id="'+value.productVariantId+'" data-id="0"  value="" onpaste="return false;"  onkeydown="return /[a-zA-Z0-9\\s]/.test(event.key)" maxlength="25" onblur="capitalizeFirst(this)"><div class="editErrorMessage" style="display: none;">Please enter a unique value.</div><button type="button" class="btn btn-link editDeleteButton" onclick="deleteVariantValue(this, 0)"><i class="fas fa-trash-alt"></i></button></div>');
            $("#editDynamicInputsContainer").append(emptyDynamicInputBox);

            $("#editInputContainer").show();
            $("#editSubmitButton").show();
            $(".updateBack").show();
            $("#editSubmitButton").prop('disabled', false);
            $(".addVariant").addClass("d-none");

        }
        
        function deleteVariantValue(obj, val){
        	obj.parentElement.remove();
        	enableUpdateButton();
//         	if(val != 0){
//             	$.ajax({
//     				type:"GET",
//     				url:deleteVariantValueURL,
//     				async:false,
//     				dataType: 'json',
//     				data:{
//     					"<portlet:namespace/>variantValueId":val
//     				},
//     				success:function(data){
//     					obj.parentElement.remove();
//     					//enableUpdateButton();
//     				},
//     			});
//             } else {
//             	obj.parentElement.remove();
//             }
        }

        function deleteVariant(obj, val) {
            if(val != 0){
            	$.ajax({
    				type:"GET",
    				url:deleteVariantURL,
    				async:false,
    				dataType: 'json',
    				data:{
    					"<portlet:namespace/>variantId":val
    				},
    				success:function(data){
    					obj.parentElement.remove();
    				},
    			});
            } else {
            	obj.parentElement.remove();
            }
            
        }
        
        var saveAsDraft = form => {
        	$('#<portlet:namespace/>productStatus').val('DRAFT');
        	$(form).submit();
        };
        
</script>
