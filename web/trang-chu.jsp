<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/_shared/user/top-of-page.jsp"/>
<title>Đặt món nhóm</title>
<jsp:include page="_shared/user/page-header.jsp"/>

<div class="slide-show">
    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="d-block w-100" src="assests/images/banner1.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="assests/images/banner2.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="assests/images/banner3.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="assests/images/banner4.jpg" alt="Second slide">
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" src="assests/images/banner5.jpg" alt="Second slide">
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
        <img src="assests/images/logo.png" height="50" width="50" />
        <h1>Món ăn mới của nhà hàng</h1>
        <i class="secondary-text-color">Những món ăn là tinh hoa ẩm thực của người Việt</i>
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
                            <img src="${monAn.hinhMonAn}" style="width: 100%;"/>
                        </div>
                        <div class="row">
                            <p class="col-8 food-name">${monAn.tenMonAn}</p>
                            <p class="col-4 price" style="text-align: right;">${monAn.gia}đ</p>
                        </div>
                        <p class="price old-price row" style="text-align: right;">${monAn.khuyenMai == 0 ? '': monAn.gia + (monAn.gia * monAn.khuyenMai) }
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
            <h1>Đội ngũ nhân viên</h1>
            <img src="assests/images/logo.png" alt="logo" width="100" height="100">
            <p>
                <i>Những nhân viên nòng cốt và có vai trò chính trong nhà hàng</i>
            </p>
        </div>
        <div class="emp-list">
            <div class="row">
                <div class="col-md-3 col-sm-6 col-12 emp">
                    <img src="assests/images/people.jpg" alt=""/>
                    <p>Nguyễn Lê Điền
                    </p>
                </div>
                <div class="col-md-3 col-sm-6 col-12 emp">
                    <img src="assests/images/people.jpg" alt=""/>
                    <p>Nguyễn Trường Tráng
                    </p>
                </div>
                <div class="col-md-3 col-sm-6 col-12 emp">
                    <img src="assests/images/people.jpg" alt="" />
                    <p>Nguyễn Thanh Tân
                    </p>
                </div>
                <div class="col-md-3 col-sm-6 col-12 emp">
                    <img src="assests/images/people.jpg" alt=""/>
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
        <h1>Thực đơn chính của nhà hàng</h1>
        <i class="secondary-text-color">Thực đơn do chính đầu bếp có kinh nghiệm lựa chọn
        </i>
    </div>
    <div class="menu-foods container">
        <div class="row">
            <c:forEach var="thucDon" items="${requestScope.thucDons}">
                <div class="food-item col-md-3 col-sm-6 col-12">
                    <a href="#!">
                        <div class="food-img">
                            <img src="${thucDon.hinhThucDon}" />
                        </div>
                        <div class="row">
                            <p class="col-6 food-name">${thucDon.tenThucDon}</p>
                            <p class="col-6 price" style="text-align: right;">${thucDon.gia}đ</p>
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
            <h1>Nhận Xét Nhà Hàng</h1>
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
        <h1>Bài viết mới - nổi bật</h1>
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

<jsp:include page="_shared/user/page-footer.jsp"/>
<script type="text/javascript" src="assests/js/script.trang-chu.js"></script>
<jsp:include page="_shared/user/end-of-file.jsp"/>