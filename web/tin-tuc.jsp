<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tin tức</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="assests/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="assests/js/parallax.min.js"></script>
    <script type="text/javascript" src="assests/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assests/js/script.tin-tuc.js"></script>
    <link rel="stylesheet" type="text/css" href="assests/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="assests/css/style.tin-tuc.css"/>
    <link rel="stylesheet" type="text/css" href="assests/css/global.css"/>
</head>
<body>
<div class="contact-bar row" style="background-color: #0e0e0e;">
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
<nav class="navbar navbar-expand-lg row" id="navbar-absolute" style="background-color: #000;">
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
<div class="main-content row">
    <div class="col-sm-12 col-md-3">
        <div class="card" id="danh-muc">
            <div class="card-header">Danh mục bài viết</div>
            <ul class="list-group list-group-flush">
                <c:forEach var="loaiBv" items="${requestScope.loaiBaiViets}">
                    <li class="list-group-item">
                        <a href="/tin-tuc?loaiBaiViet=${loaiBv.idLoaiBaiViet}">${loaiBv.tenLoaiBaiViet}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="col-sm-12 col-md-9">
        <div class="card" id="tin-tuc">
            <div class="card-header row">
                <div class="col-md-3 col-sm-12"><h5 style="line-height: unset;">Danh sách bài viết</h5></div>
                <div class="col-md-9 col-sm-12">
                    <form action="/tim-tin-tuc" method="post">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Nhập bài viết muốn tìm">
                            <div class="input-group-append">
                                <input type="submit" class="btn btn-primary" value="Tìm bài viết"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <div class="card-body">
                <div class="row">
                    <div class="col-md-8 col-sm-12 newest-bai-viet-main">
                        <c:if test="${requestScope.baiViet1 != null}">
                            <a href="/chi-tiet-bai-viet?idBaiViet=${requestScope.baiViet1.idBaiViet}">
                                <img src="${requestScope.baiViet1.hinh}" alt=""/>
                                <div class="new-title">
                                    <h4>${requestScope.baiViet1.tenBaiViet}</h4>
                                    <small class="date">${requestScope.baiViet1.ngayViet}</small>
                                </div>
                            </a>
                        </c:if>
                    </div>
                    <div class="col-md-4 col-sm-12" style="padding: 0;">
                        <div class="row">
                            <div class="col newest-bai-viet-sub">
                                <c:if test="${requestScope.baiViet2 != null}">
                                    <a href="/chi-tiet-bai-viet?idBaiViet=${requestScope.baiViet2.idBaiViet}">
                                        <img src="${requestScope.baiViet2.hinh}" alt=""/>
                                        <div class="new-title">
                                            <h5>${requestScope.baiViet2.tenBaiViet}</h5>
                                            <small class="date">${requestScope.baiViet2.ngayViet}</small>
                                        </div>
                                    </a>
                                </c:if>
                            </div>
                            <div class="w-100" style="padding-bottom: 16px;"></div>
                            <div class="col newest-bai-viet-sub">
                                <c:if test="${requestScope.baiViet3 != null}">
                                    <a href="/chi-tiet-bai-viet?idBaiViet=${requestScope.baiViet3.idBaiViet}">
                                        <img src="${requestScope.baiViet3.hinh}" alt=""/>
                                        <div class="new-title">
                                            <h5>${requestScope.baiViet3.tenBaiViet}</h5>
                                            <small class="date">${requestScope.baiViet3.ngayViet}</small>
                                        </div>
                                    </a>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>

                <c:forEach var="baiViet" items="${requestScope.baiViets}" varStatus="stt">
                    <div class="other-news">
                        <a href="/chi-tiet-bai-viet?idBaiViet=${baiViet.idBaiViet}">
                            <div class="row">
                                <div class="news-img col-md-4 col-12">
                                    <img src="${baiViet.hinh}" alt="">
                                </div>
                                <div class="news-content col-md-8 col-12">
                                    <h5>${baiViet.tenBaiViet}</h5>
                                    <p>${baiViet.ngayViet}</p>
                                    <p class="sumary">${baiViet.moTa}</p>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<jsp:include page="_shared/user/footer.jsp" />