<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Test</title>
  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
  <script src="js/bootstrap.js"></script>
  <link rel="stylesheet" href="css/bootstrap.css">
</head>
<body>
  <div class="container p-3">
    <div class="row">
      <h2>Upload .csv file to perform the matching process.</h2>
    </div>
    <div class="row alert mt-2" id="message" hidden></div>
    <div class="row mt-2">
      <form id="file-upload-form" enctype="multipart/form-data">
        <input type="file" name="file" class="form-control-file">
      </form>
    </div>
    <div class="row">
      <input type="button" class="btn btn-sm btn-primary" id="upload-btn" value="Upload"/>
    </div>
    <div class="row mt-4">
      <div id="match-result"></div>
    </div>
  </div>
</body>
<script>
  $("#upload-btn").click(function () {
      var form = $("#file-upload-form")[0];
      console.log(form);
      var formData = new FormData(form);
      $.ajax({
        url: 'performmatching',
        data: formData,
        type: 'POST',
        contentType: false,
        processData: false,
        success: function (result) {
          if (result.text) {
            $("#message").text(result.text);
            $("#message").addClass("alert-" + result.level);
            $("#message").removeAttr("hidden");
          } else {
            $("#message").attr("hidden", true);
            $("#match-result").html(result);
          }
        },
        error: function (res) {
          console.error(res);
        }
      });
  });

</script>
</html>
