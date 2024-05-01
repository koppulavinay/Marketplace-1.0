<%@ include file="/init.jsp" %>

<form method="post" enctype="multipart/form-data">
	<div class="container mt-5">
	  <h3>Upload Images</h3>
	  <div class="form-group">
	    <label for="image-upload" class="btn btn-primary">
	      Select Images
	      <input type="file" id="image-upload" name="<portlet:namespace/>images" multiple style="display: none;" >
	    </label>
	  </div>
	  <div class="form-group">
	    <input type="text" id="selected-images" class="form-control" readonly>
	  </div>
	  <div class="form-group">
	    <label for="documents-upload" class="btn btn-primary">
	      Select Images
	      <input type="file" id="documents-upload" name="<portlet:namespace/>documents" multiple style="display: none;" >
	    </label>
	  </div>
	  <div class="form-group">
	    <input type="text" id="selected-documents" class="form-control" readonly>
	  </div>
	</div>
	<button type="button" onclick="uploadFiles();">Submit</button>
</form>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
  $(document).ready(function() {
    $('#image-upload').on('change', function() {
      var files = $(this)[0].files;
      var names = [];
      for (var i = 0; i < files.length; i++) {
        names.push(files[i].name);
      }
      $('#selected-images').val(names.join(', '));
    });
    $('#documents-upload').on('change', function() {
      var files = $(this)[0].files;
      var names = [];
      for (var i = 0; i < files.length; i++) {
        names.push(files[i].name);
      }
      $('#selected-documents').val(names.join(', '));
    });
  });
  
  
  var uploadFiles = async () => {
	  var images = $('#image-upload').prop('files');
	
	  var formData = new FormData();
	  
	  formData.append('param1', '1234');
	  
	  for(let index = 0; index < images.length; index ++)
	  	formData.append('images', images[index], images[index].name);

	  //const data = new URLSearchParams(new FormData(formElement));
	  
	  const response = await fetch(skuMediaURL, {
		  method: 'POST',
		  body: formData
	  });
	  
	  const data = await response.text();
	  
	  console.log(data);
	  
  };
  
  
</script>