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
                    <a href="#!">
                        <div class="menu-image">
                            <img src="${thucDon.hinhThucDon}" height="170px">
                        </div>
                        <div class="row">
                            <p class="col-8 menu-name">${thucDon.tenThucDon}</p>
                            <p class="col-4 menu-price">${thucDon.gia}</p>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="menu" id="menu-1">
        <div class="row">
            <div class="col-3 menu-title">
                <h1 class="font-blonde-script menu-name">Thực đơn 1</h1>
                <p class="menu-description">Lorem Ipsum is simply dummy text of the printing and typesetting
                    industry.
                    Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown
                    printer took a galley of type and scrambled it to make a type specimen book</p>
                <a href="#!" class="btn btn-success">Xem món ăn</a>
            </div>
            <div class="col-9">
                <div class="row">
                    <div class="col-md-3 col-sm-6 col-12">
                        <a href="#!" class="card food-menu">
                            <img class="card-img-top" src="assests/images/banh-xeo.jpg" alt="Banh xeo">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up
                                    the
                                    bulk of the card's content.</p>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-3 col-sm-6 col-12">
                        <a href="#!" class="card food-menu">
                            <img class="card-img-top" src="assests/images/banh-xeo.jpg" alt="Banh xeo">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up
                                    the
                                    bulk of the card's content.</p>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-3 col-sm-6 col-12">
                        <a href="#!" class="card food-menu">
                            <img class="card-img-top" src="assests/images/banh-xeo.jpg" alt="Banh xeo">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up
                                    the
                                    bulk of the card's content.</p>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-3 col-sm-6 col-12">
                        <a href="#!" class="card food-menu">
                            <img class="card-img-top" src="assests/images/banh-xeo.jpg" alt="Banh xeo">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up
                                    the
                                    bulk of the card's content.</p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="menu-by-day">
        <nav class="day-of-week">
            <ul class="nav nav-pills justify-content-center">
                <li class="nav-item">
                    <a class="nav-link day active" href="#!" onclick="getMenu(this);" id="thu2">Thứ hai</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link day" href="#!" onclick="getMenu(this);" id="thu3">Thứ ba</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link day" href="#!" onclick="getMenu(this);" id="thu4">Thứ tư</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link day" href="#!" onclick="getMenu(this);" id="thu5">Thứ năm</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link day" href="#!" onclick="getMenu(this);" id="thu6">Thứ sáu</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link day" href="#!" onclick="getMenu(this);" id="thu7">Thứ bảy</a>
                </li>
            </ul>
        </nav>
        <div class="content-show container">
            <div class="align-content-center menu-by-day-title">
                <h1 class="font-blonde-script">Thực đơn món nướng</h1>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been
                    the
                    industry's standard dummy text ever since the 1500s</p>
            </div>
            <div class="row">
                <div class="col-3">
                    <a href="#!">
                        <div class="food-image">
                            <img src="assests/images/banh-trang-cuon-thit-heo.jpg"/>
                        </div>
                        <div class="food-info row">
                            <p class="col-6 menu-name">Tên món ăn</p>
                            <p class="col-6 menu-price">200 000đ</p>
                        </div>
                    </a>
                </div>
                <div class="col-3">
                    <a href="#!">
                        <div class="food-image">
                            <img src="assests/images/banh-trang-cuon-thit-heo.jpg"/>
                        </div>
                        <div class="food-info row">
                            <p class="col-6 menu-name">Tên món ăn</p>
                            <p class="col-6 menu-price">200 000đ</p>
                        </div>
                    </a>
                </div>
                <div class="col-3">
                    <a href="#!">
                        <div class="food-image">
                            <img src="assests/images/banh-trang-cuon-thit-heo.jpg"/>
                        </div>
                        <div class="food-info row">
                            <p class="col-6 menu-name">Tên món ăn</p>
                            <p class="col-6 menu-price">200 000đ</p>
                        </div>
                    </a>
                </div>
                <div class="col-3">
                    <a href="#!">
                        <div class="food-image">
                            <img src="assests/images/banh-trang-cuon-thit-heo.jpg"/>
                        </div>
                        <div class="food-info row">
                            <p class="col-6 menu-name">Tên món ăn</p>
                            <p class="col-6 menu-price">200 000đ</p>
                        </div>
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="col-3">
                    <a href="#!">
                        <div class="food-image">
                            <img src="assests/images/banh-trang-cuon-thit-heo.jpg"/>
                        </div>
                        <div class="food-info row">
                            <p class="col-6 menu-name">Tên món ăn</p>
                            <p class="col-6 menu-price">200 000đ</p>
                        </div>
                    </a>
                </div>
                <div class="col-3">
                    <a href="#!">
                        <div class="food-image">
                            <img src="assests/images/banh-trang-cuon-thit-heo.jpg"/>
                        </div>
                        <div class="food-info row">
                            <p class="col-6 menu-name">Tên món ăn</p>
                            <p class="col-6 menu-price">200 000đ</p>
                        </div>
                    </a>
                </div>
                <div class="col-3">
                    <a href="#!">
                        <div class="food-image">
                            <img src="assests/images/banh-trang-cuon-thit-heo.jpg"/>
                        </div>
                        <div class="food-info row">
                            <p class="col-6 menu-name">Tên món ăn</p>
                            <p class="col-6 menu-price">200 000đ</p>
                        </div>
                    </a>
                </div>
                <div class="col-3">
                    <a href="#!">
                        <div class="food-image">
                            <img src="assests/images/banh-trang-cuon-thit-heo.jpg"/>
                        </div>
                        <div class="food-info row">
                            <p class="col-6 menu-name">Tên món ăn</p>
                            <p class="col-6 menu-price">200 000đ</p>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <div class="menu" id="menu-2">
        <div class="row">
            <div class="col-3 menu-title">
                <h1 class="font-blonde-script menu-name">Thực đơn 1</h1>
                <p class="menu-description">Lorem Ipsum is simply dummy text of the printing and typesetting
                    industry.
                    Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown
                    printer took a galley of type and scrambled it to make a type specimen book</p>
                <a href="#!" class="btn btn-success">Xem món ăn</a>
            </div>
            <div class="col-9">
                <div class="row">
                    <div class="col-md-3 col-sm-6 col-12">
                        <a href="#!" class="card food-menu">
                            <img class="card-img-top" src="assests/images/banh-xeo.jpg" alt="Banh xeo">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up
                                    the
                                    bulk of the card's content.</p>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-3 col-sm-6 col-12">
                        <a href="#!" class="card food-menu">
                            <img class="card-img-top" src="assests/images/banh-xeo.jpg" alt="Banh xeo">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up
                                    the
                                    bulk of the card's content.</p>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-3 col-sm-6 col-12">
                        <a href="#!" class="card food-menu">
                            <img class="card-img-top" src="assests/images/banh-xeo.jpg" alt="Banh xeo">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up
                                    the
                                    bulk of the card's content.</p>
                            </div>
                        </a>
                    </div>
                    <div class="col-md-3 col-sm-6 col-12">
                        <a href="#!" class="card food-menu">
                            <img class="card-img-top" src="assests/images/banh-xeo.jpg" alt="Banh xeo">
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up
                                    the
                                    bulk of the card's content.</p>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="_shared/user/footer.jsp" flush="true"/>