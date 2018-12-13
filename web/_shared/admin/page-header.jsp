<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="/admin/thong-bao"></jsp:include>
<!-- plugins:css -->
<link rel="stylesheet"
      href="<%= request.getContextPath() + "/" %>../../assests/node_modules/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet"
      href="<%= request.getContextPath() + "/" %>../../assests/node_modules/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet"
      href="<%= request.getContextPath() + "/" %>../../assests/node_modules/perfect-scrollbar/css/perfect-scrollbar.css">

<!-- endinject -->
<!-- plugin css for this page -->
<link rel="stylesheet"
      href="<%= request.getContextPath() + "/" %>../../assests/node_modules/jvectormap/jquery-jvectormap.css"/>
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%= request.getContextPath() + "/" %>../../assests/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%= request.getContextPath() + "/" %>../../assests/images/favicon.png"/>

<link rel="stylesheet"
      href="<%= request.getContextPath() + "/" %>../../assests/node_modules/jquery-toast-plugin/dist/jquery.toast.min.css">
<style>
    .results tr[visible='false'],
    .no-result {
        display: none;
    }

    .results tr[visible='true'] {
        display: table-row;
    }

    .counter {
        padding: 8px;
        color: #ccc;
    }

    .text {
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        line-height: 16px;
        max-height: 32px;
        -webkit-line-clamp: 1;
        -webkit-box-orient: vertical;
    }

    li {
        list-style-type: none;
    }
</style>
</head>

<body>
<div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
            <a class="navbar-brand brand-logo" href="" style="color: #616161;">
                <b>ADMINISTRATOR</b>
            </a>
            <a class="navbar-brand brand-logo-mini" href=""><img
                    src="<%= request.getContextPath() + "/" %>../../assests/images/logo.png" alt="logo"/></a>
        </div>
        <div class="navbar-menu-wrapper d-flex align-items-stretch">
            <button class="navbar-toggler navbar-toggler align-self-center mr-2" type="button" data-toggle="minimize">
                <i class="mdi mdi-menu"></i>
            </button>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="mdi mdi-reload"></i>
                    </a>
                </li>

                <li class="nav-item dropdown" href="#">
                    <a class="nav-link count-indicator dropdown-toggle" id="notificationDropdown" href="#"
                       data-toggle="dropdown">
                        <i class="mdi mdi-bell-outline"></i>
                        <span class="count"></span>
                    </a>
                    <div class="dropdown-menu navbar-dropdown navbar-dropdown-large preview-list"
                         aria-labelledby="notificationDropdown">
                        <h6 class="p-3 mb-0 text-center">Thông báo</h6>
                        <c:forEach var="lienHe" items="${requestScope.lienHes}">
                            <c:if test="${lienHe.trangThaiSeen==false}">
                                <a class="dropdown-item preview-item" href="/admin/lien-he">
                                    <div class="preview-thumbnail">
                                        <img src="/assests/images/profile.jpg" class="profile-pic">
                                    </div>
                                    <div class="preview-item-content">
                                        <p class="mb-0">${lienHe.hoTen} <span
                                                class="text-small text-muted">${lienHe.noiDung}</span></p>
                                    </div>
                                </a>
                            </c:if>
                        </c:forEach>
                        <%--<a class="dropdown-item preview-item">--%>
                        <%--<div class="preview-thumbnail">--%>
                        <%--<img src="<%= request.getContextPath() + "/" %>../../assests/images/faces/face3.jpg" class="profile-pic">--%>
                        <%--</div>--%>
                        <%--<div class="preview-item-content">--%>
                        <%--<p class="mb-0">James <span class="text-small text-muted">posted a photo on your--%>
                        <%--wall</span></p>--%>
                        <%--</div>--%>
                        <%--</a>--%>
                        <%--<a class="dropdown-item preview-item">--%>
                        <%--<div class="preview-thumbnail">--%>
                        <%--<img src="<%= request.getContextPath() + "/" %>../../assests/images/faces/face2.jpg" class="profile-pic">--%>
                        <%--</div>--%>
                        <%--<div class="preview-item-content">--%>
                        <%--<p class="mb-0">Alex <span class="text-small text-muted">just mentioned you in his--%>
                        <%--post</span></p>--%>
                        <%--</div>--%>
                        <%--</a>--%>
                        <div class="dropdown-divider"></div>
                        <p class="p-3 mb-0 text-center">View all activities</p>
                    </div>
                </li>

                <li class="nav-item nav-search">
                    <form class="nav-link form-inline mt-2 mt-md-0 d-none d-lg-flex">
                        <div class="input-group">
                            <div class="input-group-prepend">
                                <span class="input-group-text">
                                    <i class="mdi mdi-magnify"></i>
                                </span>
                            </div>
                            <input type="text" class="form-control" placeholder="Tìm kiếm">
                        </div>
                    </form>
                </li>
            </ul>
            <ul class="navbar-nav navbar-nav-right">
                <li class="nav-item  nav-profile dropdown">
                    <a class="nav-link" href="#">
                        <i class="mdi mdi-home-circle"></i>
                    </a>
                </li>
            </ul>
            <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button"
                    data-toggle="offcanvas">
                <span class="mdi mdi-menu"></span>
            </button>
        </div>
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_settings-panel.html -->
        <div class="theme-setting-wrapper">
            <div id="settings-trigger"><i class="mdi mdi-settings"></i></div>
            <div id="theme-settings" class="settings-panel">
                <i class="settings-close mdi mdi-close"></i>
                <p class="settings-heading">SIDEBAR SKINS</p>
                <div class="sidebar-bg-options selected" id="sidebar-light-theme">
                    <div class="img-ss rounded-circle bg-light border mr-3"></div>
                    Light
                </div>
                <div class="sidebar-bg-options" id="sidebar-dark-theme">
                    <div class="img-ss rounded-circle bg-dark border mr-3"></div>
                    Dark
                </div>
                <p class="settings-heading mt-2">HEADER SKINS</p>
                <div class="color-tiles mx-0 px-4">
                    <div class="tiles light"></div>
                    <div class="tiles success"></div>
                    <div class="tiles warning"></div>
                    <div class="tiles danger"></div>
                    <div class="tiles pink"></div>
                    <div class="tiles info"></div>
                    <div class="tiles dark"></div>
                    <div class="tiles default"></div>
                </div>
            </div>
        </div>
        <!-- partial -->
        <!-- partial:partials/_sidebar.html -->
        <nav class="sidebar sidebar-offcanvas" id="sidebar">
            <ul class="nav">
                <li class="nav-item nav-profile">
                    <a href="#" class="nav-link">
                            <span class="nav-profile-image">
                                <img src="<%= request.getContextPath() + "/" %>../../assests/images/faces/face1.jpg"
                                     alt="profile">
                                <span class="login-status online"></span>
                                <!--change to offline or busy as needed-->
                            </span>
                    </a>
                </li>
                <li class="nav-item nav-category">
                    <span class="nav-link justify-content-center text-danger"><b>QUẢN TRỊ WEBSITE</b></span>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="./admin-dashboard.html">
                        <i class="mdi mdi-compass-outline menu-icon"></i>
                        <span class="menu-title">Dashboard</span>
                    </a>
                </li>
                <li class="nav-item nav-category">
                    <span class="nav-link justify-content-center text-danger"><b>DANH MỤC QUẢN LÝ</b></span>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/thuc-don">
                        <i class="mdi mdi-silverware-variant menu-icon"></i>
                        <span class="menu-title">Quản Lý Thực Đơn</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/loai-mon">
                        <i class="mdi mdi-format-list-bulleted-type menu-icon"></i>
                        <span class="menu-title">Quản Lý Loại Món</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/mon-an">
                        <i class="mdi mdi-food-fork-drink menu-icon"></i>
                        <span class="menu-title">Quản Lý Món Ăn</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/bai-viet">
                        <i class="mdi mdi-book-open-page-variant menu-icon"></i>
                        <span class="menu-title">Quản Lý Bài viết</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/dat-ban">
                        <i class="mdi mdi-book-open-page-variant menu-icon"></i>
                        <span class="menu-title">Quản Lý Đặt Bàn</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/lien-he">
                        <i class="mdi mdi-book-open-page-variant menu-icon"></i>
                        <span class="menu-title">Quản Lý Liên Hệ</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/hoa-don">
                        <i class="mdi mdi-book-open-page-variant menu-icon"></i>
                        <span class="menu-title">Quản Lý Hóa Đơn</span>
                    </a>
                </li>
                <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/admin/dat-ban">--%>
                <%--<i class="mdi mdi-table menu-icon"></i>--%>
                <%--<span class="menu-title">Quản Lý Đặt Bàn</span>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/admin/hoa-don">--%>
                <%--<i class="mdi mdi-content-paste menu-icon"></i>--%>
                <%--<span class="menu-title">Quản Lý Hóa Đơn</span>--%>
                <%--</a>--%>
                <%--</li>--%>
                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#page-layouts" aria-expanded="false"
                       aria-controls="page-layouts">
                        <i class="mdi mdi-account-card-details menu-icon"></i>
                        <span class="menu-title">Quản Lý Người Dùng</span>
                        <i class="menu-arrow"></i>
                    </a>
                    <div class="collapse" id="page-layouts">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item d-none d-lg-block"><a class="nav-link"
                                                                      href="/admin/nguoi-dung">Người Dùng</a></li>
                            <li class="nav-item"><a class="nav-link" href="/admin/quan-tri-vien">Quản Trị Viên</a>
                            </li>
                        </ul>
                    </div>
                </li>

                <li class="nav-item">
                    <a class="nav-link" data-toggle="collapse" href="#page-layouts1" aria-expanded="false"
                       aria-controls="page-layouts">
                        <i class="mdi mdi-account-card-details menu-icon"></i>
                        <span class="menu-title">Thống kê</span>
                        <i class="menu-arrow"></i>
                    </a>
                    <div class="collapse" id="page-layouts1">
                        <ul class="nav flex-column sub-menu">
                            <li class="nav-item d-none d-lg-block"><a class="nav-link"
                                                                      href="/admin/mon-an-thuc-don">Món ăn - Thực
                                đơn</a></li>
                            <li class="nav-item"><a class="nav-link" href="/admin/thong-ke-dich-vu">Dịch vụ</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="/admin/thong-ke-tong-thu">Tổng thu</a>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="/admin/xuat-pdf">Xuất báo cáo</a>
                            </li>
                        </ul>
                    </div>
                </li>
                <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/admin/nghiep-vu">--%>
                <%--<i class="mdi mdi-account-convert menu-icon"></i>--%>
                <%--<span class="menu-title">Quản Nghiệp vụ</span>--%>
                <%--</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/admin/quyen">--%>
                <%--<i class="mdi mdi-account-key menu-icon"></i>--%>
                <%--<span class="menu-title">Quản Lý Quyền</span>--%>
                <%--</a>--%>
                <%--</li>--%>
            </ul>
        </nav>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <!-- Hiện content ở chổ này -->