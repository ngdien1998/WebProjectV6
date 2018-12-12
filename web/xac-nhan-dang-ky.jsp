<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Xác nhận đăng ký</title>
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
    <link rel="shortcut icon" href="assests/images/favicon.png"/>
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
                                <p id="validate-message" class="text-danger">${requestScope.message}</p>
                                <h2>Đăng ký tài khoản</h2>
                                <h4 class="font-weight-light">Xác nhận đăng ký</h4>
                                <form action="/xac-nhan-dang-ky" method="post">
                                    <div class="form-group">
                                        <label for="txt-code">Nhập mã xác nhận đã được gửi đến email của bản</label>
                                        <input type="text" name="txtCode" class="form-control" id="txt-code"
                                                placeholder="Mã xác nhận" value="${requestScope.maXacNhan}">
                                    </div>
                                    <div class="mt-5">
                                        <input type="submit" class="btn btn-primary btn-rounded" value="Xác nhận"/>
                                        <input type="button" class="btn btn-warning btn-rounded"
                                                onclick="resendCode(${sessionScope.email})" value="Gửi lại mã"/>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="col-lg-6 register-half-bg d-flex flex-row">
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
<script>
    function resendCode(email) {
        $.post("/gui-lai-code", {email: email}, () => $("#validate-message").html("Đã gửi lại mã xác nhận vào email của bản"));
    }
</script>
</body>

</html>