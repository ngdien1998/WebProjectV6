<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Đổi mật khẩu</title>

    <script type="text/javascript" src="assests/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="assests/js/parallax.min.js"></script>
    <script type="text/javascript" src="assests/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="assests/css/bootstrap.min.css"/>

    <link rel="stylesheet" href="./assests/css/style.tat-ca-mon-an.css"/>
    <link rel="stylesheet" href="./assests/css/global.css"/>
    <link rel="stylesheet" href="./assests/css/style.trang-chu.css"/>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
            integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
            crossorigin="anonymous"/>
    <link rel="stylesheet" href="./assests/css/style.xem-thong-tin-ca-nhan.css"/>
    <style>
        * {
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
        }

        .contact-bar {
            padding: 8px;
            background-color: rgba(0, 0, 0, 0.87);
            color: #fff;
            font-size: 13px;
        }

        .contact-bar-functions {
            text-align: right;
        }

        .contact-bar-functions a {
            text-decoration: none;
            color: #fff;
            padding-left: 8px;
        }

        .slide-show {
            position: relative;
        }

        .slide-show #navbar-absolute {
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            z-index: 1;
            background-color: rgba(0, 0, 0, 0.4) !important;
        }

        .nav-item {
            padding-right: 10px;
        }

        #txt-tim-kiem {
            border-top-left-radius: 20px;
            border-bottom-left-radius: 20px;
            font-size: 14px;
        }

        #btn-tim-kiem {
            border-top-right-radius: 20px;
            border-bottom-right-radius: 20px;
            font-size: 14px;
        }

        .footer {
            padding: 64px 0;
            color: #fff;
        }

        .footer .row {
            margin-top: 32px;
        }

        .footer-title {
            text-align: center;
        }

        .send-contact form .form-row {
            padding-bottom: 10px;
        }

        .content-header {
            margin-bottom: 32px;
        }

        .send-contact input[type = submit], .send-contact input[type = button] {
            margin-top: 10px;
        }

        .table, tr {
            border-top: none;
            border-bottom: 1px solid;
        }

        .email-input input[type = text] {
            border-top-left-radius: 24px;
            border-bottom-left-radius: 24px;
        }

        .email-input input[type = submit] {
            border-top-right-radius: 24px;
            border-bottom-right-radius: 24px;
        }

        .footer-content *:not(h1) {
            font-size: 14px;
        }

        .footer-content table td {
            padding-left: 0;
            padding-right: 0;
            border: unset;
        }

        #doi-ngu-nhan-vien {
            background-image: url("/assests/images/pabecue.png");
            background-repeat: no-repeat;
            background-size: cover;
            padding: 96px 0;
            color: #fff;
            text-align: center;
        }

        #nhan-xet-khach-hang {
            background-image: url("/assests/images/paralax2.png");
            background-repeat: no-repeat;
            background-size: cover;
            padding: 96px 0;
            color: #fff;
            text-align: center;
        }

        #footer {
            background-image: url("/assests/images/footer-img.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            padding: 64px 0;
            color: #fff;
            text-align: center;
        }
    </style>
</head>

<body>
<div class="contact-bar row">
    <div class="col-3 contact-bar-greeting">
        <i>Hân hạnh được phục vụ quý khách</i>
    </div>
    <div class="col-9 contact-bar-functions">
        <c:choose>
            <c:when test="${sessionScope.nguoiDungHienTai != null}">
                <a href="/sua-thong-tin-ca-nhan">Chào
                    mừng ${sessionScope.nguoiDungHienTai.hoDem} ${sessionScope.nguoiDungHienTai.ten} đến với website</a>
                <a href="/dang-xuat">Đăng xuất</a>
                <c:if test="${sessionScope.nguoiDungHienTai.quanTriVien}">
                    <a href="/admin/ket-noi-database">Quản trị</a>
                </c:if>
                <a href="/gio-hang">Giỏ hàng</a>
            </c:when>
            <c:otherwise>
                <a href="/dang-nhap">Đăng nhập</a>
                <a href="/dang-ky">Đăng ký</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<nav class="navbar navbar-expand-lg row" id="navbar-absolute" style="background: #000;">
    <a class="navbar-brand font-blonde-script text-white font-size-h3" href="#">
        <img src="assests/images/logo.png" width="50" height="50" class="d-inline-block align-top"
                alt="logo">
        Restaurant
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link font-blonde-script text-white font-size-h5" href="/trang-chu">Trang chủ
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-white font-size-h5" href="/thuc-don">Thực đơn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-white font-size-h5" href="/tat-ca-mon-an">Món ăn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-white font-size-h5" href="/dat-mon-nhom">Đặt món nhóm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-white font-size-h5" href="/bai-viet">Bài
                    viết</a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-white font-size-h5" href="/gioi-thieu">Nhà
                    hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-white font-size-h5" href="/dat-ban">Đặt bàn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-white font-size-h5" href="/lien-he">Liên hệ</a>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Nhập thông tin tìm kiếm"
                        id="txt-tim-kiem"/>
                <div class="input-group-append">
                    <input class="btn btn-info" type="submit" value="Tìm" id="btn-tim-kiem"/>
                </div>
            </div>
        </form>
    </div>
</nav>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
        <li class="breadcrumb-item"><a href="#">Thông tin cá nhân</a></li>
        <li class="breadcrumb-item active" aria-current="page">
            Đổi mật khẩu
        </li>
    </ol>
</nav>

<div class="maincontent">
    <div class="container">
        <div class="row profile">
            <div class="col-md-3">
                <div class="profile-sidebar">
                    <div class="profile-userpic">
                        <c:choose>
                            <c:when test="${sessionScope.avatar == null}">
                                <img src="https://hocwebgiare.com/thiet_ke_web_chuan_demo/bootstrap_user_profile/images/profile_user.jpg"
                                        class="img-responsive" alt="Thông tin cá nhân"/>
                            </c:when>
                            <c:otherwise>
                                <img src="${sessionScope.avatar}" class="img-responsive" alt="Thông tin cá nhân"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="profile-usertitle">
                        <div class="profile-usertitle-name">${sessionScope.hoDem} ${sessionScope.ten}</div>
                    </div>
                    <div class="profile-userbuttons">
                        <a href="/trang-chu" class="btn btn-success btn-sm">Trang chủ</a>
                        <a href="/sua-thong-tin-ca-nhan" class="btn btn-danger btn-sm">Hủy bỏ</a>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <div class="profile-content">
                    <h2 class="justify-content-center">Đổi mật khẩu</h2>
                    <form action="/doi-mat-khau" method="post">
                        <div class="form-group">
                            <label for="mat-khau">Mật khẩu cũ</label>
                            <input type="password" name="txtMatKhau" id="mat-khau" class="form-control"
                                    placeholder="Mật khẩu cũ" onblur="validateForPassword();"/>
                            <small class="text-danger" id="validate-for-mat-khau"></small>
                        </div>
                        <div class="form-group">
                            <label for="mat-khau-moi">Mật khẩu mới</label>
                            <input type="password" class="form-control" name="txtMatKhauMoi" id="mat-khau-moi"
                                    placeholder="Mật khẩu mới" onblur="validateForNewPassword()"/>
                            <small class="text-danger" id="validate-for-mat-khau-moi"></small>
                        </div>
                        <div class="form-group">
                            <label for="re-mat-khau">Xác nhận mật khẩu</label>
                            <input type="password" name="txtReMatKhau" id="re-mat-khau" class="form-control"
                                    placeholder="Xác nhận mật khẩu" onblur="validateForRePassword()"/>
                            <small class="text-danger" id="validate-for-re-mat-khau"></small>
                        </div>
                        <input type="submit" class="btn btn-success" onclick="return validateSubmitting();"
                                value="Đổi mật khẩu">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function validateForPassword() {
        if ($("#mat-khau").val() === "") {
            $("#validate-for-mat-khau").html("Bạn chưa nhập mật khẩu");
            return false;
        }
        $("#validate-for-mat-khau").html("");
        return true;
    }

    function validateForNewPassword() {
        if ($("#mat-khau-moi").val() === "") {
            $("#validate-for-mat-khau-moi").html("Bạn chưa nhập mật khẩu mới");
            return false;
        }
        $("#validate-for-mat-khau-moi").html("");
        return true;
    }

    function validateForRePassword() {
        if ($("#re-mat-khau").val() === "") {
            $("#validate-for-re-mat-khau").html("Bạn chưa nhập mật khẩu xác nhận");
            return false;
        }
        if (newPass !== rePass) {
            $("#validate-for-re-mat-khau").html("Mật khẩu mới không khớp");
            return false;
        }

        $("#validate-for-re-mat-khau").html("");
        return true;
    }

    function validateSubmitting() {
        return (validateForPassword() & validateForNewPassword() & validateForRePassword()) !== 0;
    }
</script>
<jsp:include page="_shared/user/footer.jsp"/>