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

    <%----%>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">--%>

    <link rel="stylesheet" href="http://propeller.in/components/range-slider/css/nouislider.min.css">

    <link rel="stylesheet" href="http://propeller.in/components/textfield/css/textfield.css">

    <link rel="stylesheet" href="http://propeller.in/components/checkbox/css/checkbox.css">

    <link rel="stylesheet" href="http://propeller.in/components/range-slider/css/range-slider.css">
    <%----%>

    <link rel="stylesheet" href="./assests/css/style.tat-ca-mon-an.css">
    <link rel="stylesheet" href="./assests//css/global.css">
    <link rel="stylesheet" href="./assests/css/style.trang-chu.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

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
                            <div id="pmd-slider-value-range" class="pmd-range-slider mt-4"></div>
                            <!-- Values -->
                            <div class="row">
                                <div class="range-value col-sm-6">
                                    <span id="value-min"></span> đ
                                </div>
                                <div class="range-value col-sm-6 text-right">
                                    <span id="value-max"></span> đ
                                </div>
                            </div>
                            <a class="btn btn-primary mb-4 text-white" id="btn-loc-gia" style="margin-left:100px;" onclick="location.href='/loc-mon-an-theo-gia?gia-min='+document.getElementById('value-min').innerHTML+'&gia-max='+document.getElementById('value-max').innerHTML">Lọc</a>
                        </li>
                        <li>
                            <span class="font-weight-bold">Loại món</span>
                            <ul class="left-margin">
                                <a class="badge badge-danger" href="/lay-mon-an-theo-loai-mon?idLoaiMon=11">Món khai
                                    vị</a>
                                <a class="badge badge-warning" href="/lay-mon-an-theo-loai-mon?idLoaiMon=12">Món
                                    chính</a>
                                <a class="badge badge-primary" href="/lay-mon-an-theo-loai-mon?idLoaiMon=13">Món tráng
                                    miệng</a>
                                <a class="badge badge-success" href="/lay-mon-an-theo-loai-mon?idLoaiMon=1">Món
                                    nướng</a>
                                <a class="badge badge-info" href="/lay-mon-an-theo-loai-mon?idLoaiMon=2">Món lẩu</a>
                                <a class="badge badge-secondary" href="/lay-mon-an-theo-loai-mon?idLoaiMon=7">Món
                                    hấp</a>
                                <a class="badge badge-light" href="/lay-mon-an-theo-loai-mon?idLoaiMon=10">Món xào</a>
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
                                <div class="gia text-danger">${baMonAnMoiNhat.gia}đ</div>
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
                            <label style="margin-top:10px">Sắp xếp theo : &nbsp;</label>
                            <div class="form-group tabfilter">
                                <select class="form-control" id="filter-mon-an">
                                    <option value="tat-ca">Tất cả món ăn</option>
                                    <option value="moi-nhat">Mới nhất</option>
                                    <option value="khuyen-mai">Khuyến mãi</option>
                                </select>
                            </div>
                        </div>

                    </div>

                    <div class="monan">
                        <div class="row">
                            <c:forEach var="monAn" items="${requestScope.monAns}">
                                <div class="food-item col-md-4 col-sm-6 col-12 mb-5 contentPage">
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
                    </div>
                    <div style="margin-left:260px">
                        <!-- Hiên thị nút bấm -->
                        <ul id="pagination" class="text-center"></ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- Jquery js -->
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
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
<!-- Slider js -->
<script src="http://propeller.in/components/range-slider/js/wNumb.js"></script>
<script src="http://propeller.in/components/range-slider/js/nouislider.js"></script>

<script type="text/javascript">
    $("#filter-mon-an").change(() => {
        let selectedVal = $("#filter-mon-an").val();
        $.post("/admin/ajax-filter-mon-an", {typeFilter: selectedVal}, content => $(".monan").html(content));
    });

    $(function () {
        $("#slider-range").slider({
            range: true,
            min: 0,
            max: 3000000,
            values: [120000, 550000],
            slide: function (event, ui) {
                $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
            }
        });
        $("#amount").val("$" + $("#slider-range").slider("values", 0) +
            " - $" + $("#slider-range").slider("values", 1));
    });
</script>
<script>
    // multiple handled with value
    var pmdSliderValueRange = document.getElementById('pmd-slider-value-range');

    noUiSlider.create(pmdSliderValueRange, {
        start: [ 70000, 800000 ], // Handle start position
        connect: true, // Display a colored bar between the handles
        tooltips: [ wNumb({ decimals: 0 }), wNumb({ decimals: 0 }) ],
        format: wNumb({
            decimals: 0,
            thousand: '',
            postfix: '',
        }),
        range: { // Slider can select '0' to '100'
            'min': 25000,
            'max': 1000000
        }
    });

    var valueMax = document.getElementById('value-max'),
        valueMin = document.getElementById('value-min');

    // When the slider value changes, update the input and span
    pmdSliderValueRange.noUiSlider.on('update', function( values, handle ) {
        if ( handle ) {
            valueMax.innerHTML = values[handle];
        } else {
            valueMin.innerHTML = values[handle];
        }
    });

</script>
<jsp:include page="_shared/user/footer.jsp" flush="true"/>