<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tất cả món ăn</title>


    <script type="text/javascript" src="assests/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="assests/js/parallax.min.js"></script>
    <script type="text/javascript" src="assests/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="assests/css/bootstrap.min.css"/>

    <link rel="stylesheet" href="./assests/css/style.tat-ca-mon-an.css">
    <link rel="stylesheet" href="./assests//css/global.css">
    <link rel="stylesheet" href="./assests/css/style.trang-chu.css">
    <%--<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"--%>
    <%--integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"--%>
    <%--crossorigin="anonymous">--%>
</head>

<body>

<jsp:include page="_shared/user/nav.jsp" flush="true"/>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
        <li class="breadcrumb-item"><a href="#">Danh mục</a></li>
        <li class="breadcrumb-item active" aria-current="page">
            Tất cả món ăn
        </li>
    </ol>
</nav>

<div class="maincontent">
    <div class="container">
        <div class="row">
            <div class="left-content col-12 col-md-3">
                <div class="danhmuc">
                    <h3 class="left-title">Danh mục</h3>
                    <ul class="left-margin">
                        <li><a href="/trang-chu" class="ml-2">Trang chủ</a></li>
                        <li><a href="/thuc-don" class="ml-2">Thực đơn</a></li>
                        <li><a href="/tin-tuc-su-kien" class="ml-2">Tin tức - sự kiện</a></li>
                        <li><a href="/gioi-thieu" class="ml-2">Giới thiệu</a></li>
                        <li><a href="/lien-he" class="ml-2">Liên hệ</a></li>
                    </ul>
                </div>
                <div class="timtheo">
                    <h3 class="left-title">Tìm theo</h3>
                    <ul class="left-margin">
                        <li>
                            <span class="font-weight-bold"> Giá</span>
                            <input type="range" class="custom-range" id="customRange" name="points1">
                            <span class="left-price ml-65">0đ - 5000000đ</span>
                        </li>
                        <li>
                            <span class="font-weight-bold">Màu sắc</span>
                            <ul class="left-margin">
                                <span class="badge badge-danger">Đỏ</span>
                                <span class="badge badge-warning">Vàng</span>
                                <span class="badge badge-primary">Xanh dương</span>
                                <span class="badge badge-success">Xanh lá</span>
                                <span class="badge badge-info">Xanh nhạt</span>
                                <span class="badge badge-secondary">Xám</span>
                                <span class="badge badge-light">Màu sáng</span>
                                <span class="badge badge-dark">Màu tối</span>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div class="sanphammoi">
                    <h3 class="left-title">Món ăn mới</h3>
                    <c:forEach var="baMonAnMoiNhat" items="${requestScope.baMonAnMoiNhat}">
                        <div class="sanpham d-flex align-items-center justify-content-start pt-2 ">
                            <img src="${baMonAnMoiNhat.hinhMonAn}" alt="" width="100%"
                                 style="width:140px; height: 100px;">
                            <span class="info pl-3">
                                <div class="name">${baMonAnMoiNhat.tenMonAn}</div>
                                <div class="gia">${baMonAnMoiNhat.gia}</div>
                            </span>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="right-content col-12 col-md-9">
                <div class="row">
                    <div class="filter col-12 col-sm-12 col-md-12">

                        <h3 class="right-title">Tất cả món ăn</h3>
                        <div class="option  alert alert-secondary">
                            <%--<a href="#">--%>
                            <%--<button class="btn btn-success"><i class="fas fa-th-large"></i></button>--%>
                            <%--</a>--%>
                            <%--&nbsp;--%>

                            <%--<a href="#">--%>
                            <%--<button class="btn btn-success"><i class="fas fa-list-ul"></i></button>--%>
                            <%--</a>--%>
                            <%--&nbsp; &nbsp;--%>
                            <label>Sắp xếp theo : &nbsp;</label>
                            <div class="form-group tabfilter">
                                <select class="form-control" id="sel1">
                                    <option>Mới nhất</option>
                                    <option>Khuyến mãi</option>
                                    <option>Bán chạy nhất</option>
                                </select>
                            </div>
                        </div>

                    </div>

                    <div class="monan">
                        <div class="row">
                            <c:forEach var="monAn" items="${requestScope.monAns}">
                                <div class="food-item col-md-4 col-sm-6 col-12 mb-5">
                                    <a href="/chi-tiet-mon-an?idMonAn=${monAn.idMonAn}">
                                        <div class="food-img">
                                            <img src="${monAn.hinhMonAn}" height="170px"/>
                                        </div>
                                        <div class="row">
                                            <p class="col-8 food-name" style="line-height: 30px">${monAn.tenMonAn}</p>
                                            <p class="col-4 price">${monAn.gia} đ</p>
                                        </div>
                                        <p class="price old-price" style="position: absolute; right: 17px;top: 208px;">${monAn.khuyenMai == 0 ? '' : monAn.gia + (monAn.gia * monAn.khuyenMai)/100}</p>
                                    </a>
                                </div>
                            </c:forEach>
                        </div>

                        <div class="mt-1">
                            <ul class="pagination justify-content-center">
                                <li class="page-item"><a class="page-link" href="javascript:void(0);">Trang trước</a>
                                </li>
                                <li class="page-item"><a class="page-link" href="javascript:void(0);">1</a></li>
                                <li class="page-item"><a class="page-link" href="javascript:void(0);">2</a></li>
                                <li class="page-item"><a class="page-link" href="javascript:void(0);">Trang sau</a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="_shared/user/footer.jsp" flush="true"/>