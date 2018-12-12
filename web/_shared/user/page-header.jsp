<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet"
        href="<%= request.getContextPath() + "/" %>../../assests/node_modules/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
        href="<%= request.getContextPath() + "/" %>../../assests/node_modules/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet"
        href="<%= request.getContextPath() + "/" %>../../assests/node_modules/perfect-scrollbar/css/perfect-scrollbar.css">
<link rel="stylesheet"
        href="<%= request.getContextPath() + "/" %>../../assests/node_modules/jvectormap/jquery-jvectormap.css"/>
<link rel="stylesheet" href="<%= request.getContextPath() + "/" %>../../assests/css/style.css">
<link rel="shortcut icon" href="<%= request.getContextPath() + "/" %>../../assests/images/favicon.png"/>
<link rel="stylesheet" href="<%= request.getContextPath() + "/" %>../../assests/node_modules/jquery-toast-plugin/dist/jquery.toast.min.css">

<style>
    a.navbar-brand {
        text-decoration: none;
        color: #fff;
        padding-left: 8px;
    }

    a.greetng-bat-item {
        font-size: small;
        text-decoration: none;
        color: #fff;
        padding-left: 8px;
    }

    a.greetng-bat-item:hover, .nav-item-text:hover, a.navbar-brand:hover {
        text-decoration: none;
        color: #fff;
    }

    .nav-item-text {
        text-decoration: none;
        color: #fff;
        font-size: 18px;
    }

    .breadcrumb {
        border: none;
    }
</style>
</head>

<body style="background-color: #F6F8FA;">
<div class="row" style="padding: 2px 8px; background-color: #0c85d0; color: #fff; font-size: small;">
    <div class="col-md-3">Hân hạnh được phục vụ quý khách</div>
    <div class="col-md-9 col-sm-12" style="text-align: right;">
        <c:choose>
            <c:when test="${sessionScope.nguoiDungHienTai != null}">
                Chào mừng <a data-email="${sessionScope.nguoiDungHienTai.email}" id="email-nguoi-dang-nhap" style="color: #fff;"
                    href="/sua-thong-tin-ca-nhan">${sessionScope.nguoiDungHienTai.hoDem} ${sessionScope.nguoiDungHienTai.ten}</a> đến với website
                <a class="greetng-bat-item" href="/dang-xuat">Đăng xuất</a>
                <c:if test="${sessionScope.nguoiDungHienTai.quanTriVien}">
                    <a class="greetng-bat-item" href="/admin/ket-noi-database">Quản trị</a>
                </c:if>
                <a class="greetng-bat-item" href="/gio-hang">Giỏ hàng</a>
            </c:when>
            <c:otherwise>
                <a class="greetng-bat-item" href="/dang-nhap">Đăng nhập</a>
                <a class="greetng-bat-item" href="/dang-ky">Đăng ký</a>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<nav class="navbar navbar-expand-lg row" id="navbar-absolute">
    <a class="navbar-brand" href="/trang-chu" style="line-height: 50px;">
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
                <a class="nav-link nav-item-text" href="/trang-chu">Trang chủ
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link nav-item-text" href="/thuc-don">Thực đơn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link nav-item-text" href="/tat-ca-mon-an">Tất cả
                    món ăn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link nav-item-text" href="/tin-tuc">Bài
                    viết</a>
            </li>
            <li class="nav-item">
                <a class="nav-link nav-item-text" href="/gioi-thieu">Nhà
                    hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link nav-item-text" href="/dat-ban">Đặt bàn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link nav-item-text" href="/lien-he">Liên hệ</a>
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