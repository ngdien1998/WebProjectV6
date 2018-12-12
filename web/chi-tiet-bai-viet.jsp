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
    <script type="text/javascript" src="assests/js/script.chi-tiet-tin-tuc.js"></script>
    <link rel="stylesheet" type="text/css" href="assests/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="assests/css/style.chi-tiet-tin-tuc.css"/>
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
<div class="main-content container" style="margin: 2rem auto;">
    <div class="row">
        <div class="col-md-3 sidebar">
            <h5>Tin tức liên quan</h5>
            <hr>
            <c:forEach var="baiViet" items="${requestScope.baiViets}">
                <a href="/chi-tiet-bai-viet?idBaiViet=${baiViet.idBaiViet}">
                    <div class="relational-news row">
                        <div class="relational-new-img col-4">
                            <img src="${baiViet.hinh}" alt="">
                        </div>
                        <div class="relational-news-title col-8">
                            <p>${baiViet.tenBaiViet}</p>
                        </div>
                    </div>
                </a>
            </c:forEach>
        </div>
        <div class="col-md-9 content">
            <h6>Chuyên mục <a href="/tin-tuc?loaiBaiViet=${requestScope.baiViet.idLoaiBaiViet}">${requestScope.baiViet.loaiBaiViet}</a>
            </h6>
            <h1 id="news-title">${requestScope.baiViet.tenBaiViet}</h1>
            <p id="news-info">
                <small id="news-author">${requestScope.baiViet.nguoiViet}</small>
                <small id="date-create">${requestScope.baiViet.thoiGianViet}</small>
            </p>
            <p id="new-description">
                <b>${requestScope.baiViet.moTa}</b>
            </p>
            <div class="news-content">
                ${requestScope.baiViet.noiDung}
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <div class="danhgia">
                <form action="/binh-luan-bai-viet" method="post">
                    <input type="hidden" name="txtIdBaiViet" value="${requestScope.baiViet.idBaiViet}">
                    <textarea class="form-control" rows="3" id="comment"
                              placeholder="Nhập góp ý của quý khách" name="comment"></textarea>
                    <br>
                    <button class="btn btn-success margin-top-8px" style="float:right" id="binh-luan-mon-an">
                        Góp ý
                    </button>
                    <script>

                    </script>
                </form>
            </div>

            <div class="clearfix"></div>

            <div id="user-comments">
                <c:forEach var="binhLuan" items="${requestScope.binhLuans}">
                    <div class="comment" style="margin-top: 16px">
                        <div class="user-avatar" style="float: left; width: 64px">
                            <img src="${binhLuan.avatar}" alt="user-avatar" width="50" height="50"
                                 style="border-radius:50%" style="border-radius:50%">
                        </div>

                        <div class="user-comment" style="float: right; width: calc(100% - 64px); border-bottom: 1px dashed #DDD;">
                            <div class="user-name" >
                                <p class="no-margin">
                                    <b>${binhLuan.email}</b>
                                </p>
                                <p class="date-comment" class="small-text" style="color: #858585;margin-top: 2px;font-size: 12px">${binhLuan.thoiGian}</p>
                            </div>
                            <p class="comment-text" class="lighten-text">
                                    ${binhLuan.noiDung}
                            </p>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/_shared/user/footer.jsp" flush="true" />