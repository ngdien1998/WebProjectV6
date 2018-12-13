<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thực đơn nhà hàng</title>
    <script type="text/javascript" src="assests/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="assests/js/parallax.min.js"></script>
    <script type="text/javascript" src="assests/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="assests/js/script.thuc-don.js"></script>
    <link rel="stylesheet" type="text/css" href="assests/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="./assests/css/style.trang-chu.css">
    <link rel="stylesheet" type="text/css" href="assests/css/style.thuc-don.css"/>
    <link rel="stylesheet" type="text/css" href="assests/css/global.css"/>
    <script type="text/javascript">
        function getMenu(htmlObj) {
            $(".day").removeClass("active");
            let id = "#" + $(htmlObj).attr("id");
            console.log(id);
            $(id).addClass("active");
        }
    </script>
</head>

<body>

<jsp:include page="_shared/user/nav.jsp" flush="true"/>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
        <li class="breadcrumb-item"><a href="#">Danh mục</a></li>
        <li class="breadcrumb-item active" aria-current="page">Thực đơn món ăn</li>
    </ol>
</nav>
<div class="top-menus">
    <div class="top-menus-title">
        <h1 class="font-blonde-script">Thực đơn hot trong tuần</h1>
        <p><i>Các thực đơn bán chạy trong tuần với sức mua nhiều nhất</i></p>
    </div>
    <div class="top-menu-items container">
        <div class="row">
            <c:forEach var="thucDon" items="${requestScope.thucDons}">
                <div class="top-menu-item col-12 col-sm-6 col-md-3">
                    <a href="/chi-tiet-thuc-don?idThucDon=${thucDon.idThucDon}">
                        <div class="menu-image">
                            <img src="${thucDon.hinhThucDon}" height="170px">
                        </div>
                        <div class="row mt-2">
                            <p class="col-8 menu-name">${thucDon.tenThucDon}</p>
                            <p class="col-4 menu-price">${thucDon.gia}đ</p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>

    <div class="menu" id="menu-0">
        <div class="row">
            <div class="col-3 menu-title">
                <h1 class="font-blonde-script menu-name">${requestScope.infoThucDonSang.tenThucDon}</h1>
                <p class="menu-description">${requestScope.infoThucDonSang.moTa}</p>
                <a href="/chi-tiet-thuc-don?idThucDon=${requestScope.infoThucDonSang.idThucDon}" class="btn btn-success">Xem món ăn</a>
            </div>
            <div class="col-9">
                <div class="row">
                    <c:forEach var="monAn" items="${requestScope.bonMonAnThucDonSang}">
                        <div class="col-md-3 col-sm-6 col-12">
                            <a href="/chi-tiet-mon-an?idMonAn=${monAn.idMonAn}" class="card food-menu">
                                <img class="card-img-top" src="${monAn.hinhMonAn}" alt="Banh xeo" height="160px">
                                <div class="card-body">
                                    <p class="card-text">${monAn.tenMonAn}</p>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <div class="menu" id="menu-1">
        <div class="row">
            <div class="col-3 menu-title">
                <h1 class="font-blonde-script menu-name">${requestScope.infoThucDonTrua.tenThucDon}</h1>
                <p class="menu-description">${requestScope.infoThucDonTrua.moTa}</p>
                <a href="/chi-tiet-thuc-don?idThucDon=${requestScope.infoThucDonTrua.idThucDon}" class="btn btn-success">Xem món ăn</a>
            </div>
            <div class="col-9">
                <div class="row">
                    <c:forEach var="monAn" items="${requestScope.bonMonAnThucDonTrua}">
                        <div class="col-md-3 col-sm-6 col-12">
                            <a href="/chi-tiet-mon-an?idMonAn=${monAn.idMonAn}" class="card food-menu">
                                <img class="card-img-top" src="${monAn.hinhMonAn}"  height="160px">
                                <div class="card-body">
                                    <p class="card-text">${monAn.tenMonAn}</p>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>

    <div class="menu" id="menu-2">
        <div class="row">
            <div class="col-3 menu-title">
                <h1 class="font-blonde-script menu-name">${requestScope.infoThucDonToi.tenThucDon}</h1>
                <p class="menu-description">${requestScope.infoThucDonToi.moTa}</p>
                <a href="/chi-tiet-thuc-don?idThucDon=${requestScope.infoThucDonToi.idThucDon}" class="btn btn-success">Xem món ăn</a>
            </div>
            <div class="col-9">
                <div class="row">
                    <c:forEach var="monAn" items="${requestScope.bonMonAnThucDonToi}">
                        <div class="col-md-3 col-sm-6 col-12">
                            <a href="/chi-tiet-mon-an?idMonAn=${monAn.idMonAn}" class="card food-menu">
                                <img class="card-img-top" src="${monAn.hinhMonAn}"  height="160px">
                                <div class="card-body">
                                    <p class="card-text">${monAn.tenMonAn}</p>
                                </div>
                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
    <br>
    <br>
    <div class="top-menus-title">
        <h1 class="font-blonde-script">Tất cả thực đơn</h1>
    </div>
    <hr>
    <div class="top-menu-items container">
        <div class="row">
            <c:forEach var="thucDon" items="${requestScope.tatCaThucDons}">
                <div class="top-menu-item col-12 col-sm-6 col-md-3 mb-5">
                    <a href="/chi-tiet-thuc-don?idThucDon=${thucDon.idThucDon}">
                        <div class="menu-image">
                            <img src="${thucDon.hinhThucDon}" height="170px">
                        </div>
                        <div class="row mt-2">
                            <p class="col-8 menu-name">${thucDon.tenThucDon}</p>
                            <p class="col-4 menu-price">${thucDon.gia}đ</p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<jsp:include page="_shared/user/footer.jsp" flush="true"/>