<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Plus Admin</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assests/node_modules/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assests/node_modules/flag-icon-css/css/flag-icon.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assests/node_modules/perfect-scrollbar/css/perfect-scrollbar.css">
    <!-- endinject -->
    <!-- inject:css -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/assests/css/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="<%=request.getContextPath()%>/assests/images/favicon.png"/>
</head>

<body>
<div class="container-scroller">
    <div class="container-fluid page-body-wrapper full-page-wrapper">
        <div class="content-wrapper d-flex align-items-center text-center error-page bg-warning">
            <div class="row flex-grow">
                <div class="col-lg-7 mx-auto text-white">
                    <div class="row align-items-center d-flex flex-row">
                        <div class="col-lg-6 text-lg-right pr-lg-4">
                            <h1 class="display-1 mb-0">404</h1>
                        </div>
                        <div class="col-lg-6 error-page-divider text-lg-left pl-lg-4">
                            <div style="font-size: 50px;">LỖI TRUY CẬP</div>
                            <h3 class="font-weight-light">Trang web bạn truy cập không có, vui lòng kiểm tra lại!</h3>
                        </div>
                    </div>
                    <div class="row mt-5">
                        <div class="col-12 text-center mt-xl-2">
                            <a class="text-white font-weight-medium" href="/trang-chu">VỀ TRANG CHỦ</a>
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
${sessionScope.abc}
</body>

</html>
