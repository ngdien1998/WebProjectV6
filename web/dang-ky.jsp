<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                                <p class="text-danger">${requestScope.message}</p>
                                <h2>Đăng ký tài khoản</h2>
                                <h4 class="font-weight-light">Chào mừng bạn đến với website nhà hàng</h4>
                                <form class="pt-4" action="/dang-ky" method="post">
                                    <div class="form-group">
                                        <label for="txt-email">Email</label>
                                        <input type="email" name="txtEmail" class="form-control" id="txt-email"
                                                aria-describedby="emailHelp" placeholder="Nhập email">
                                        <i class="mdi mdi-account"></i>
                                    </div>
                                    <div class="form-group">
                                        <label for="txt-mat-khau">Mật khẩu</label>
                                        <input type="password" name="txtMatKhau" class="form-control" id="txt-mat-khau"
                                                placeholder="Nhập mật khẩu">
                                        <i class="mdi mdi-eye"></i>
                                    </div>
                                    <div class="form-group">
                                        <label for="txt-re-pass">Password</label>
                                        <input type="password" name="txtReMatKhau" class="form-control" id="txt-re-pass"
                                                placeholder="Xác nhận mật khẩu">
                                        <i class="mdi mdi-eye"></i>
                                    </div>
                                    <div class="mt-5">
                                        <input type="submit" class="btn btn-block btn-primary btn-rounded"
                                                value="Đăng ký"/>
                                    </div>
                                    <div class="mt-2 w-75 mx-auto">
                                        <div class="form-check form-check-flat">
                                            <label class="form-check-label">
                                                <input type="checkbox" class="form-check-input" checked>
                                                Đồng ý điều khoản của website
                                            </label>
                                        </div>
                                    </div>
                                    <div class="mt-2 text-center">
                                        <a href="dang-nhap.html" class="auth-link text-black">Đã có tài khoản? <span
                                                class="font-weight-medium">Đăng nhập</span></a>
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

</script>
</body>

</html>