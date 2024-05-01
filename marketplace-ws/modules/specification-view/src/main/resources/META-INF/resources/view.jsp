<%@ include file="init.jsp" %>

<!-- <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.css"/>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.22/datatables.min.js"></script> -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>

<portlet:renderURL var="updateSpecificationURL">
    <portlet:param name="mvcRenderCommandName" value="updateSpecificationRender" />
</portlet:renderURL>

<portlet:renderURL var="createSpecificationURL">
	<portlet:param name="mvcRenderCommandName" value="createSpecificationRender" />
</portlet:renderURL>

<liferay-ui:success key="success-key" message="Specification Created Successfully" />
<liferay-ui:success key="update-key" message="Specification Updated Successfully" />


<div class="c-loader d-none">
    <span></span>
</div>



<section class="mt-3">
	<div class="container containerMob minMamTableWidth mt-3">
		<a href="${createSpecificationURL}" class="btn btn-primary addSpecification ml-2">Add Specification</a>
		
		<table id="specification-tables" class="w-100"></table>		
		
	</div>
</section>


<%-- <section class="c-maincontainer pd-tb70-lr45 sm-pd-tb24-lr0">
	<div class="container-fluid">
		<a href="${createSpecificationURL}" class="btn btn-primary">Add Specification</a>
		<div class="blueHeader-table border-0">
			<table id="specification-tables" class="display nowrap" width="100%"></table>		
		</div>		
	</div>
</section> --%>



<link rel="stylesheet" href="<%= request.getContextPath() %>/css/jquery.dataTables.css">
<script src="<%= request.getContextPath() %>/js/jquery.dataTables.js"></script>



<script>

	$(window).on('load', function() {
		$(".dataTables_filter").append($(".addSpecification"));
	 	$(".dataTables_filter").prepend('<h1 class="titlePage">Specification Listing</h1>');
	});

	var specificationTable;
	
	$(document).ready(function() {
		$(".c-loader").removeClass("d-none");
		$(".portlet-header").hide();
		getSpecifications();
		$(".c-loader").addClass("d-none");
	});
	
	function getSpecifications(){
		$.ajax({
			type:"GET",
			url:getAllSpecificationsURL,
			data:{	
			},
			dataType:"json",
			success:function(data){
				addSpecification(data);
			},
		});
	}

	function addSpecification(data){
		specificationTable = $("#specification-tables").DataTable({
		"dom": '<f<"table-responsive" t><"tableFootBar"pil>>',
		"info": false, 
		"iDisplayLength":25,
		"ordering" : true,
		"searching" : true,
		"bLengthChange" : true,
		"destroy" : true,
		"columnDefs": [
		    { 
	    		"orderable": false, 
	    		"targets": "no-sort" 
    		} // Applies the option to all columns
		],
		"language": {
			"emptyTable": "No data available",
			"sLengthMenu": "",
			"infoEmpty": "",
			
			paginate: {
	            previous: '<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M5.15356 0.501202L1.1151 4.53966L5.15356 8.57812" stroke="#404040" stroke-linecap="round" stroke-linejoin="round"/></svg>',
	            next: '<svg width="6" height="10" viewBox="0 0 6 10" fill="none" xmlns="http://www.w3.org/2000/svg"><path d="M0.92334 8.57692L4.9618 4.53846L0.92334 0.5" stroke="#404040" stroke-linecap="round" stroke-linejoin="round"/></svg>'
	          },
			 search: "_INPUT_",
			 searchPlaceholder: "Search...",
			 lengthMenu: 'Show _MENU_ ',
	         entries: {
	             _: 'people',
	             1: 'person'
	         }
          
		},
		"deferLoading": 20, 
		"aaData": data,
		"aoColumns" :
			[
				{
					"mData" : "specificationLabel",
			    	"sTitle": "Specification Name"
			   	},
			   	{
			    	"mData" : "specificationStatus",
			    	"sTitle": "Status",
			   	},
			   	{
			    	"mData" : "specificationValueCount",
			    	"sTitle": "Values",
			   	},
			   	{
			    	"mData" : "createDate",
			    	"sTitle": "Created Date",
			   	},
			   	{
			    	"mData" : "modifiedDate",
			    	"sTitle": "Modified Date",
			   	},
			   	{
				    "mData" : null,
				    "sTitle": "Action",
				    "className": 'specification-details',
				 	"render" : function(data,type,meta){
					/* return '<div class="action-item">'+
			    				'<a href="" class="btn btn-link updateButton"><i class="icon-pencil"></i></a>'+
			    				'<a href="" class="btn btn-link deleteButton"><i class="fas fa-trash-alt"></i></a>'+
				    		'</div>';
					} */
				 	return '<div class="action-item">'+
	    				'<a href="" class="btn btn-link updateButton"><i class="icon-pencil"></i></a>'+
	    				'<button type="button" class="btn btn-link deleteButton"><i class="fas fa-trash-alt"></i></button>'+
		    		'</div>';
					}
				}
			],
			"createdRow":function(row,data,index) {
				$(".deleteButton", row).on('click',function(){
			    	if (confirm('Do you want to delete specification?')) {
						txt = "OK!";
					} else {
						txt = "Cancel!";
					}
					if (txt == "OK!") {
				       var element = $(this);
				       var txt;
	                   $.ajax({
							  type: "GET",
							  url: deleteSpecificationURL,
							  dataType : 'json',
							  data : {
								  <portlet:namespace/>specificationId :data.specificationId,
							  },
							  cache : false,
							  success : function(data) {
									var row = specificationTable.row(element.parents('tr'));
									row.remove();
									specificationTable.draw(false);
							  },
						});
					}
				});
				    
			}
		});
	}

	$(document).on('click', "td.specification-details .updateButton", function() {
		var tr = $(this).closest('tr');
		var row = specificationTable.row(tr);
		var data = row.data();
		var url = '${updateSpecificationURL.toString()}';
		window.location.href = url+"&<portlet:namespace/>specificationId="+data.specificationId;
		
	});
	

	
</script>
