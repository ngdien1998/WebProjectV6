<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chi tiết thực đơn</title>


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
    <script src="https://code.jquery.com/jquery-3.2.1.js"></script>
    <!-- JS tạo nút bấm di chuyển trang start -->
    <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
    <!-- JS tạo nút bấm di chuyển trang end -->
    <script type="text/javascript">
        $(function () {
            var pageSize = 12; // Hiển thị 6 sản phẩm trên 1 trang
            showPage = function (page) {
                $(".contentPage").hide();
                $(".contentPage").each(function (n) {
                    if (n >= pageSize * (page - 1) && n < pageSize * page)
                        $(this).show();
                });
            }
            showPage(1);
            ///** Cần truyền giá trị vào đây **///
            var totalRows = ${requestScope.soLuong}; // Tổng số sản phẩm hiển thị
            var btnPage = 3; // Số nút bấm hiển thị di chuyển trang
            var iTotalPages = Math.ceil(totalRows / pageSize);

            var obj = $('#pagination').twbsPagination({
                totalPages: iTotalPages,
                visiblePages: btnPage,
                onPageClick: function (event, page) {
                    /* console.info(page); */
                    showPage(page);
                }
            });
            /*console.info(obj.data());*/
        });
    </script>
    <style>
        /* CSS căn id pagination ra giữa màn hình */
        #pagination {
            display: flex;
            display: -webkit-flex; /* Safari 8 */
            flex-wrap: wrap;
            -webkit-flex-wrap: wrap; /* Safari 8 */
            justify-content: center;
            -webkit-justify-content: center;
        }
    </style>


</head>

<body>

<jsp:include page="_shared/user/nav.jsp" flush="true"/>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
        <li class="breadcrumb-item"><a href="#">Danh mục</a></li>
        <li class="breadcrumb-item active" aria-current="page">
            Chi tiết thực đơn
        </li>
    </ol>
</nav>

<div class="maincontent">
    <div class="container">
        <div class="row">
            <div class="col-sm-2"></div>
            <div class="col-sm-4">
                <img src="${requestScope.thucDon.hinhThucDon}" alt="" width="400px" height="250px">
            </div>
            <div class="col-sm-4 ml-5">
                <h2 class="title">Mô tả thực đơn</h2>
                <hr>
                <h1 class="title text-danger">${requestScope.thucDon.tenThucDon}</h1>
                <h3 class="title">Mô tả : ${requestScope.thucDon.moTa}</h3>
                <h3 class="title text-primary">Giá: ${requestScope.thucDon.gia}đ</h3>
                <h3 class="title text-warning">Phần trăm khuyến mãi : ${requestScope.thucDon.phanTramKhuyenMai} %</h3>
            </div>
            <div class="col-sm-2"></div>
        </div>
        <hr>
        <h1 class="text-center title">Các món ăn trong thực đơn</h1>
        <div class="row">
            <c:forEach var="monAn" items="${requestScope.monAns}">
                <div class="food-item col-md-3 col-sm-6 col-12 mb-5 contentPage">
                    <a href="/chi-tiet-mon-an?idMonAn=${monAn.idMonAn}">
                        <div class="food-img">
                            <img src="${monAn.hinhMonAn}" height="170px"/>
                        </div>
                        <div class="row">
                            <p class="col-8 food-name" style="line-height: 30px">${monAn.tenMonAn}</p>
                            <p class="col-4 price">${monAn.gia} đ</p>
                        </div>
                        <p class="price old-price"
                           style="position: absolute; right: 17px;top: 208px;">${monAn.khuyenMai == 0 ? '' : monAn.gia + (monAn.gia * monAn.khuyenMai)/100}</p>
                    </a>
                </div>
            </c:forEach>
        </div>
        <div>
            <!-- Hiên thị nút bấm -->
            <ul id="pagination" class="text-center"></ul>
        </div>
    </div>
</div>

<script type="text/javascript">
    $("#filter-mon-an").change(() => {
        let selectedVal = $("#filter-mon-an").val();
        $.post("/admin/ajax-filter-mon-an", {typeFilter: selectedVal}, content => $(".monan").html(content));
    });

</script>
<jsp:include page="_shared/user/footer.jsp" flush="true"/>