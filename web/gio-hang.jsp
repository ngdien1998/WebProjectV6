<%@ page import="quanlynhahang.models.viewmodels.MonAnVM" %>
<%@ page import="quanlynhahang.common.Consts" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html >

<head>
    <%--<link rel="stylesheet" href="assests/css/style.gio-hang.css">--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="assests/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="assests/js/parallax.min.js"></script>
    <script type="text/javascript" src="assests/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="assests/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="assests/css/style.gio-hang.css"/>
    <link rel="stylesheet" type="text/css" href="assests/css/global.css"/>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
</head>

<body>
<%--<div class="contact-bar row">--%>
    <%--<div class="col-3 contact-bar-greeting">--%>
        <%--<i>Hân hạnh được phục vụ quý khách</i>--%>
    <%--</div>--%>
    <%--<div class="col-9 contact-bar-functions">--%>
        <%--<a href="#!"><i class="glyphicon glyphicon-shopping-cart"></i>Tài khoản--%>
        <%--</a>--%>
        <%--<a href="#!">Thanh toán</a>--%>
        <%--<a href="/gio-hang">Giỏ hàng</a>--%>
    <%--</div>--%>
<%--</div>--%>
<jsp:include page="_shared/user/nav.jsp" flush="true"/>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
        <%--<li class="breadcrumb-item"><a href="#">Danh mục</a></li>--%>
        <li class="breadcrumb-item active" aria-current="page">
            Giỏ hàng
        </li>
    </ol>
</nav>
<%--<div class="top-content">--%>
    <%--<nav class="navbar navbar-expand-lg row" id="navbar-absolute">--%>
        <%--<a class="navbar-brand font-blonde-script text-white font-size-h3" href="#">--%>
            <%--<img src="assests/images/logo.png" width="50" height="50" class="d-inline-block align-top" alt="logo">--%>
            <%--Restaurant--%>
        <%--</a>--%>
        <%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"--%>
                <%--aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">--%>
            <%--<span class="navbar-toggler-icon"></span>--%>
        <%--</button>--%>
        <%--<div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">--%>
            <%--<ul class="navbar-nav">--%>
                <%--<li class="nav-item active">--%>
                    <%--<a class="nav-link font-blonde-script text-white font-size-h5" href="./trang-chu">Trang chủ--%>
                        <%--<span class="sr-only">(current)</span>--%>
                    <%--</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link font-blonde-script text-white font-size-h5" href="./thuc-don">Thực đơn</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link font-blonde-script text-white font-size-h5" href="./tat-ca-mon-an">Món ăn</a>--%>
                <%--</li><li class="nav-item">--%>
                <%--<a class="nav-link font-blonde-script text-white font-size-h5" href="./tat-ca-mon-an">Đặt món nhóm</a>--%>
            <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link font-blonde-script text-white font-size-h5" href="./tin-tuc">Bài viết</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link font-blonde-script text-white font-size-h5" href="./gioi-thieu">Nhà hàng</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link font-blonde-script text-white font-size-h5" href="./dat-ban">Đặt bàn</a>--%>
                <%--</li>--%>
                <%--<li class="nav-item">--%>
                    <%--<a class="nav-link font-blonde-script text-white font-size-h5" href="./lien-he">Liên hệ</a>--%>
                <%--</li>--%>
            <%--</ul>--%>
            <%--<form class="form-inline my-2 my-lg-0">--%>
                <%--<div class="input-group">--%>
                    <%--<input type="text" class="form-control" placeholder="Nhập thông tin tìm kiếm"--%>
                            <%--id="txt-tim-kiem"/>--%>
                    <%--<div class="input-group-append">--%>
                        <%--<input class="btn btn-info" type="submit" value="Tìm" id="btn-tim-kiem"/>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</form>--%>

        <%--</div>--%>
    <%--</nav>--%>
    <%--<nav aria-label="breadcrumb">--%>
        <%--<ol class="breadcrumb">--%>
            <%--<li class="breadcrumb-item"><a href="/trang-chu">Trang chủ</a></li>--%>
            <%--<li class="breadcrumb-item"><a href="#">Giỏ hàng</a></li>--%>
            <%--<li class="breadcrumb-item active" aria-current="page">--%>
                <%--Giỏ hàng--%>
            <%--</li>--%>
        <%--</ol>--%>
    <%--</nav>--%>
<%--</div>--%>


<div class="container">
    <c:choose>
        <c:when test="${requestScope.gioHangRong}">
            <h4 style="text-align: center; margin: 64px auto;">Giỏ hàng hiện tại rỗng, hãy <a href="/tat-ca-mon-an">chọn món ăn</a> và thêm vào giỏ</h4>
        </c:when>
        <c:otherwise>
            <form action="/xoa-gio-hang" method="post">
                <table class="table">
                    <thead class="font-size-h5">
                    <tr>
                        <th>Sản phẩm</th>
                        <th>Đơn giá</th>
                        <th>Số lượng</th>
                        <th>Giá tiền</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="monAn" items="${sessionScope.gioHang}">
                        <tr>
                            <td>${monAn.tenMonAn}</td>
                            <td>${monAn.gia} đồng</td>
                            <td>
                                <input type="number" data-id="${monAn.idMonAn}"
                                        value="${monAn.soLuong}"
                                        class="form-control txt-so-luong">
                            </td>
                            <td id="tinh-tien-${monAn.idMonAn}">${monAn.tinhTien()} đồng</td>
                            <td>
                                <a class="btn btn-success" href="javascript:xoaKhoiGioHang(${monAn.idMonAn})">Xóa món này</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <div class="row justify-content-center">
                    <button class="btn btn-success" id="btnUpdate" type="submit"
                            style="margin-right: 16px;">Xóa giỏ hàng
                    </button>
                    <a href="/tat-ca-mon-an" class="btn btn-primary">Mua món khác</a>
                </div>
            </form>
        </c:otherwise>
    </c:choose>

    <br>
    <div class="form-group">
        <div class="row">
            <div class="col-6">
            </div>
            <div class="col-6 ">
                <form>
                    <h2 class="pt-5 ml-5">Tổng tiền</h2>
                    <table class="table table-bordered">
                        <tr>
                            <td>Vận chuyển</td>
                            <td>0 đồng</td>
                        </tr>
                        <tr>
                            <td><strong>Tổng tiền</strong></td>
                            <td id="tong-tien">${requestScope.tongTien} đồng</td>
                        </tr>
                    </table>
                    <button class="btn btn-success" id="pay" type="submit">Thanh toán</button>
                </form>
            </div>
        </div>
    </div>
    <br>
</div>
<div class="footer parallax-window" data-parallax="scroll"
        data-image-src="assests/images/blur-close-up-cutlery-370984.jpg">
    <div class="container-fluid">
        <div class="footer-title">
            <h1 class="font-blonde-script">Liên hệ</h1>
            <img src="assests/images/logo.png" height="100" width="100"/>
            <form action="" method="post" class="email-input">
                <div class="row">
                    <div class="input-group col-6 offset-3">
                        <input type="text" class="form-control" placeholder="Nhập email của bạn"
                                aria-label="Recipient's username"
                                aria-describedby="button-addon2">
                        <div class="input-group-append">
                            <input class="btn btn-info" type="submit" id="button-addon2" value="Đăng ký"/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-6 col-12 footer-content">
                <h1 class="font-blonde-script content-header">Thời gian</h1>
                <table class="table">
                    <tr>
                        <td style="padding-top: 0;">Thứ 2</td>
                        <td style="padding-top: 0;" align="right">8:00 - 22:00</td>
                    </tr>
                    <tr>
                        <td>Thứ 3</td>
                        <td align="right">8:00 - 22:00</td>
                    </tr>
                    <tr>
                        <td>Thứ 4</td>
                        <td align="right">8:00 - 22:00</td>
                    </tr>
                    <tr>
                        <td>Thứ 6</td>
                        <td align="right">8:00 - 22:00</td>
                    </tr>
                    <tr>
                        <td>Thứ 7</td>
                        <td align="right">8:00 - 22:00</td>
                    </tr>
                </table>
            </div>
            <div class="col-md-4 col-sm-6 col-12 footer-content">
                <h1 class="font-blonde-script content-header">Thông tin liên hệ</h1>
                <p>
                    <b>Địa chỉ:</b>
                    75/6 Trương Văn Hải, Tăng Nhơn Phú B, Q9
                </p>
                <p>
                    <b>Email:</b>
                    nhahang@gmail.com
                </p>
                <p>
                    <b>Hot line:</b>
                    (098) 765 9898
                </p>
                <span class="social">
                            <a></a>
                        </span>
            </div>
            <div class="col-md-4 col-sm-6 col-12 send-contact footer-content">
                <h1 class="font-blonde-script content-header">Gửi liên hệ</h1>
                <form action="#" method="post">
                    <div class="form-row">
                        <div class="col-6">
                            <input type="text" class="form-control"/>
                        </div>
                        <div class="col-6">
                            <input type="text" class="form-control"/>
                        </div>
                    </div>
                    <textarea class="form-control" rows="8"></textarea>
                    <input type="submit" value="Gửi" class="btn btn-light"/>
                    <input type="button" value="Hủy" class="btn btn-light"/>
                </form>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">
    function xoaKhoiGioHang(idMonAn) {
        $.post("/xoa-mon-an-trong-gio-hang", { txtIdMon: idMonAn }, content => {
            if (content === "true") {
                location.href = "/gio-hang";
            }
        });
    }

    $(".txt-so-luong").blur((e) => {
        let idMonAn = $(e.target).data("id");
        $.post("/cap-nhat-gio-hang", {
            txtIdMon: idMonAn,
            txtSoLuong: $(e.target).val()
        }, content => {
            $("#tinh-tien-" + idMonAn).html(content.giaMoi + " đồng");
            $("#tong-tien").html(content.tongTien + " đồng");
        });
    });
</script>
</body>

</html>