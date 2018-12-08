<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ - Quản lý nhà hàng</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="assests/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="assests/js/parallax.min.js"></script>
    <script type="text/javascript" src="assests/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assests/js/script.trang-chu.js"></script>
    <link rel="stylesheet" type="text/css" href="assests/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="assests/css/style.trang-chu.css"/>
    <link rel="stylesheet" type="text/css" href="assests/css/global.css"/>
</head>
<body>
<div class="contact-bar row">
    <div class="col-3 contact-bar-greeting">
        <i>Hân hạnh được phục vụ quý khách</i>
    </div>
    <div class="col-9 contact-bar-functions">
        <c:choose>
            <c:when test="${sessionScope.nguoiDungHienTai != null}">
                <a href="/sua-thong-tin-ca-nhan">Chào mừng ${sessionScope.nguoiDungHienTai.hoDem} ${sessionScope.nguoiDungHienTai.ten} đến với website</a>
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

<div class="slide-show">
    <nav class="navbar navbar-expand-lg row" id="navbar-absolute">
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
                    <a class="nav-link font-blonde-script text-white font-size-h5" href="/tat-ca-mon-an">Tất cả
                        món ăn</a>
                </li>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link font-blonde-script text-white font-size-h5" href="/bai-viet">Bài--%>
                        <%--viết</a>--%>
                <%--</li>--%>
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
    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="assests/images/banner1.jpg"
                     alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="assests/images/banner2.jpg"
                     alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="assests/images/banner3.jpg"
                     alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="assests/images/banner4.jpg"
                     alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="assests/images/banner5.jpg"
                     alt="Second slide">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<div class="main-menus">
    <div class="title">
        <img src="assests/images/logo.png" height="50" width="50"/>
        <h1 class="font-blonde-script">Món ăn mới của nhà hàng</h1>
        <i class="secondary-text-color"> Những món ăn là tinh hoa ẩm thực của người Việt
        </i>
        <div id="list-menu">
            <a class="food-menu background-blue text-white" href="#!">Shushi</a>
            <a class="food-menu background-yellow text-brown" href="#!">Salad</a>
            <a class="food-menu background-red text-white" href="#!">Thức uống</a>
            <a class="food-menu background-orange text-white" href="#!">Bánh Pizza</a>
            <a class="food-menu background-green text-white" href="#!">Buffet</a>
            <a class="food-menu background-purple text-white" href="#!">Rượu</a>
        </div>
    </div>
    <div class="menu-foods container">
        <div class="row mb-4">
            <c:forEach var="monAn" items="${requestScope.monAns}">
                <div class="food-item col-md-3 col-sm-6 col-12">
                    <a href="/chi-tiet-mon-an?idMonAn=${monAn.idMonAn}">
                        <div class="food-img">
                            <img src="${monAn.hinhMonAn}" height="170px"/>
                        </div>
                        <div class="row">
                            <p class="col-8 food-name" style="line-height: 30px">${monAn.tenMonAn}</p>
                            <p class="col-4 price">${monAn.gia} đ</p>
                        </div>
                        <p class="price old-price" style="position: absolute; right: 17px;top: 208px;">${monAn.khuyenMai == 0 ? '': monAn.gia + (monAn*khuyenMai) }
                            </p>
                    </a>
                </div>
            </c:forEach>
        </div>
        <div class="row">
            <div class="food-ads food-ads-left col-3">
                <div class="food-ads-sub-item">
                    <img src="assests/images/banh-xeo.jpg" alt="food">
                </div>
                <div class="food-ads-sub-item">
                    <img src="assests/images/banh-xeo.jpg" alt="food">
                </div>
            </div>
            <div class="food-ads food-ads-center col-6">
                <div class="food-ads-main-item">
                    <img src="assests/images/bun-mam.jpg"/>
                </div>
            </div>
            <div class="food-ads food-ads-right col-3">
                <div class="food-ads-sub-item">
                    <img src="assests/images/banh-xeo.jpg" alt="food">
                </div>
                <div class="food-ads food-ads-sub-item">
                    <img src="assests/images/banh-xeo.jpg" alt="food">
                </div>
            </div>
        </div>
    </div>
</div>

<div class="parallax-window" data-parallax="scroll" data-image-src="assests/images/pabecue.png">
    <div class="container">
        <div id="emp-title">
            <h1 class="font-blonde-script">Đội ngũ nhân viên</h1>
            <img src="assests/images/logo.png" alt="logo" width="100" height="100">
            <p>
                <i> Những nhân viên nòng cốt và có vai trò chính trong nhà hàng
                </i>
            </p>
        </div>
        <div class="emp-list">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-12 emp">
                    <img src="assests/images/people.jpg"/>
                    <p>Nguyễn Lê Điền
                    </p>
                </div>
                <div class="col-md-3 col-sm-6 col-12 emp">
                    <img src="assests/images/people.jpg"/>
                    <p>Nguyễn Trường Tráng
                    </p>
                </div>
                <div class="col-md-3 col-sm-6 col-12 emp">
                    <img src="assests/images/people.jpg"/>
                    <p>Nguyễn Thanh Tân
                    </p>
                </div>
                <div class="col-md-3 col-sm-6 col-12 emp">
                    <img src="assests/images/people.jpg"/>
                    <p>Phạm Ngọc Diêu
                    </p>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="price-off">
    <div class="title">
        <img src="assests/images/logo.png" height="50" width="50"/>
        <h1 class="font-blonde-script">Thực đơn chính của nhà hàng</h1>
        <i class="secondary-text-color">Thực đơn do chính đầu bếp có kinh nghiệm lựa chọn
        </i>
    </div>
    <div class="menu-foods container">
        <div class="row">
            <c:forEach var="thucDon" items="${requestScope.thucDons}">
                <div class="food-item col-md-3 col-sm-6 col-12">
                    <a href="#!">
                        <div class="food-img">
                            <img src="${thucDon.hinhThucDon}" height="170px"/>
                        </div>
                        <div class="row">
                            <p class="col-6 food-name" style="line-height: 30px">${thucDon.tenThucDon}</p>
                            <p class="col-6 price">${thucDon.gia} đ</p>
                        </div>
                        <%--<p class="price old-price"--%>
                           <%--style="position: absolute; right: 17px;top: 208px;">${thucDon.phanTramKhuyenMai == 0 ? '' : thucDon.gia + (thucDon*phanTramKhuyenMai)} đ</p>--%>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>

<div class="parallax-window" data-parallax="scroll" data-image-src="assests/images/paralax2.png">
    <div class="container">
        <div class="comment-title">
            <h1 class="font-blonde-script">Nhận Xét Nhà Hàng</h1>
            <img src="assests/images/logo.png" alt="logo" width="100" height="100">
            <p>
                <i>Những nhận xét của khách hàng đóng góp có vai trò rất quan trọng trong việc phát triển nhà hàng
                </i>
            </p>
        </div>
        <div class="comment-list">
            <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="avatar-people-cmt" src="assests/images/people.jpg"/>
                        <p class="cmt-text">
                            <i>
                                Nhà hàng có thức ăn khá ngon, nội thất cũng như view rất đẹp. Tuyệt
                            </i>
                        </p>
                    </div>
                    <div class="carousel-item">
                        <img class="avatar-people-cmt" src="assests/images/people.jpg"/>
                        <p class="cmt-text">
                            <i>Tôi rất hài lòng với sự phục vụ nhiệt tình của nhân viên nhà hàng này, rất chu đáo, nhiệt tình cũng như chất lượng thức ăn tốt. Tôi thích món Heo Massage tại đây. Cảm ơn Nhà hàng!
                            </i>
                        </p>
                    </div>
                    <div class="carousel-item">
                        <img class="avatar-people-cmt" src="assests/images/people.jpg"/>
                        <p class="cmt-text">
                            <i>
                                Những món ăn đặc sản miền Tây sông nước của quê tôi tại Nhà hàng  rất ngon và rẻ, vừa túi tiền, phục vụ tận tình chu đáo.
                            </i>
                        </p>
                    </div>
                    <div class="carousel-item">
                        <img class="avatar-people-cmt" src="assests/images/people.jpg"/>
                        <p class="cmt-text">
                            <i>
                                Những món ăn đặc sản miền Tây sông nước của quê tôi tại Nhà hàng Năm Nhỏ, rất ngon và rẻ, vừa túi tiền, phục vụ tận tình chu đáo.
                            </i>
                        </p>
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button"
                   data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleIndicators" role="button"
                   data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </div>
</div>

<div class="blogs container">
    <div class="blog-title">
        <h1 class="font-blonde-script">Bài viết mới - nổi bật</h1>
        <img src="assests/images/logo.png" width="100" height="100"/>
        <p>
            <i>Lorem Ipsum is simply dummy text of the printing and typesetting industry</i>
        </p>
    </div>
    <div class="row blog-list">
        <div class="blog col-md-3 col-sm-6 col-12">
            <a href="#!">
                <img src="assests/images/bun-mam.jpg"/>
                <p class="post-date">8/10/2018</p>
                <p class="post-sumary">Lorem Ipsum is simply dummy text of the printing and typesetting
                    industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when
                    an unknown printer took a galley of type and scrambled it to make a type specimen book. It
                    has survived not only five centuries, but also the leap into electronic typesetting,
                    remaining essentially unchanged
                </p>
            </a>
        </div>
        <div class="blog col-md-3 col-sm-6 col-12">
            <a href="#!">
                <img src="assests/images/bun-mam.jpg"/>
                <p class="post-date">8/10/2018</p>
                <p class="post-sumary">Lorem Ipsum is simply dummy text of the printing and typesetting
                    industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when
                    an unknown printer took a galley of type and scrambled it to make a type specimen book. It
                    has survived not only five centuries, but also the leap into electronic typesetting,
                    remaining essentially unchanged
                </p>
            </a>
        </div>
        <div class="blog col-md-3 col-sm-6 col-12">
            <a href="#!">
                <img src="assests/images/bun-mam.jpg"/>
                <p class="post-date">8/10/2018</p>
                <p class="post-sumary">Lorem Ipsum is simply dummy text of the printing and typesetting
                    industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when
                    an unknown printer took a galley of type and scrambled it to make a type specimen book. It
                    has survived not only five centuries, but also the leap into electronic typesetting,
                    remaining essentially unchanged
                </p>
            </a>
        </div>
        <div class="blog col-md-3 col-sm-6 col-12">
            <a href="#!">
                <img src="assests/images/bun-mam.jpg"/>
                <p class="post-date">8/10/2018</p>
                <p class="post-sumary">Lorem Ipsum is simply dummy text of the printing and typesetting
                    industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when
                    an unknown printer took a galley of type and scrambled it to make a type specimen book. It
                    has survived not only five centuries, but also the leap into electronic typesetting,
                    remaining essentially unchanged
                </p>
            </a>
        </div>
    </div>
</div>

<jsp:include page="_shared/user/footer.jsp" flush="true"/>