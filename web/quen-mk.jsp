<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Đăng nhập</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assests/node_modules/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assests/node_modules/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assests/node_modules/perfect-scrollbar/css/perfect-scrollbar.css">
    <!-- endinject -->
    <!-- plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assests/css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/assests/images/favicon.png" />
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
                                <h2>Bạn đã quên mật khẩu</h2>
                                <h4 class="font-weight-light">Nhập email để lấy lại tài khoản</h4>
                                <form class="pt-5" action="/quen-mat-khau" method="post">
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="email" name="txtEmail" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Nhập email" value="${requestScope.txtEmail}">
                                        <i class="mdi mdi-account"></i>
                                        <small class="text-danger" id="validate-for-email"></small>
                                    </div>
                                    <div class="mt-5">
                                        <input type="submit" class="btn btn-block btn-primary btn-rounded" value="Gửi email" />
                                    </div>
                                    <div class="mt-3 text-center">
                                        <p class="text-success" id="message-for-email-sent"></p>
                                        <a href="/dang-nhap" class="auth-link text-black">Đăng nhập</a>
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
<script src="<%=request.getContextPath()%>/assests/node_modules/jquery/dist/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/assests/node_modules/popper.js/dist/umd/popper.min.js"></script>
<script src="<%=request.getContextPath()%>/assests/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/assests/node_modules/perfect-scrollbar/dist/perfect-scrollbar.min.js"></script>
<!-- endinject -->
<!-- inject:js -->
<script src="<%=request.getContextPath()%>/assests/js/off-canvas.js"></script>
<script src="<%=request.getContextPath()%>/assests/js/hoverable-collapse.js"></script>
<script src="<%=request.getContextPath()%>/assests/js/misc.js"></script>
<script src="<%=request.getContextPath()%>/assests/js/settings.js"></script>
<script src="<%=request.getContextPath()%>/assests/js/todolist.js"></script>
<!-- endinject -->
</body>

</html>