CKEDITOR.editorConfig = function(config) {
    config.filebrowserBrowseUrl = 'http://localhost:8080/assests/js/ckfinder/ckfinder.html';
    config.filebrowserImageBrowseUrl = 'http://localhost:8080/assests/js/ckfinder/ckfinder.html?type=Images';
    config.filebrowserFlashBrowseUrl = 'http://localhost:8080/assests/js/ckfinder/ckfinder.html?type=Flash';
    config.filebrowserUploadUrl = 'http://localhost:8080/assests/js/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files';
    config.filebrowserImageUploadUrl = 'http://localhost:8080/assests/js/ckfinder/core/connector/java/connector.php?command=QuickUpload&type=Images';
    config.filebrowserFlashUploadUrl = 'http://localhost:8080/assests/js/ckfinder/core/connector/java/connector.php?command=QuickUpload&type=Flash';
};