<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Đăng ký tài khoản</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="assests/node_modules/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="assests/node_modules/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="assests/node_modules/perfect-scrollbar/css/perfect-scrollbar.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="assests/css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="assests/images/favicon.png" />
</head>

<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center auth">
            <div class="row w-100">
                <div class="col-lg-8 mx-auto">
                    <div class="row">
                        <div class="col-lg-6 bg-white">
                            <div class="auth-form-light text-left p-5">
                                <h2>Kết nối database</h2>
                                <h4 class="font-weight-light">Chọn server để thực kết nối vào cơ sở dữ liệu</h4>
                                <form class="pt-5" action="/admin/ket-noi-database" method="post">
                                    <div class="form-group">
                                        <label for="server">Chọn server</label>
                                        <input type="text" name="txtServer" class="form-control" id="server" placeholder="Nhập tên server muốn kết nối" value="${requestScope.server}">
                                    </div>
                                    <div class="form-group">
                                        <label for="port">Port</label>
                                        <input type="text" name="txtPort" class="form-control" id="port" value="1433">
                                    </div>
                                    <div class="mt-2 w-75 mx-auto">
                                        <div class="form-check form-check-flat">
                                            <label class="form-check-label">
                                                <input type="checkbox" class="form-check-input" id="chk-server" name="chkServer">
                                                Sử dụng local host database
                                            </label>
                                        </div>
                                    </div>
                                    <div class="mt-5 form-row">
                                        <div class="col-md-6">
                                            <input type="submit" class="btn btn-block btn-primary btn-rounded" value="Đăng nhập" />
                                        </div>
                                        <div class="col-md-6">
                                            <a href="/trang-chu" class="btn btn-warning btn-rounded">Hủy bỏ</a>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-lg-6 login-half-bg d-flex flex-row">
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- content-wrapper ends -->
    </div>
    <!-- page-body-wrapper ends -->
</div>
<!-- container-scroller -->
<!-- plugins:js -->
<script src="assests/node_modules/jquery/dist/jquery.min.js"></script>
<script src="assests/node_modules/popper.js/dist/umd/popper.min.js"></script>
<script src="assests/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="assests/node_modules/perfect-scrollbar/dist/perfect-scrollbar.min.js"></script>
<!-- endinject -->
<!-- inject:js -->
<script src="assests/js/off-canvas.js"></script>
<script src="assests/js/hoverable-collapse.js"></script>
<script src="assests/js/misc.js"></script>
<script src="assests/js/settings.js"></script>
<script src="assests/js/todolist.js"></script>
<!-- endinject -->
<script type="text/javascript">
    $("#chk-server").change(() => {
        if ($("#chk-server").is(":checked")) {
            $("#server").attr("readonly", "readonly");
            $("#port").attr("readonly", "readonly");
        } else {
            $("#server").removeAttr("readonly");
            $("#port").removeAttr("readonly");
        }
    });
</script>
</body>

</html>