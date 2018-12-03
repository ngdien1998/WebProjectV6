<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/_shared/user/top-of-page.jsp"/>
<title>Đặt món nhóm</title>
<jsp:include page="_shared/user/page-header.jsp"/>
<link rel="stylesheet" href="<%= request.getContextPath() %>/assests/css/style.dat-mon-nhom.css">

<nav style="margin: 16px; text-align: center;" aria-label="breadcrumb" role="navigation">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Home</a></li>
        <li class="breadcrumb-item"><a href="#">Library</a></li>
        <li class="breadcrumb-item"><a href="#">Data</a></li>
        <li class="breadcrumb-item"><a href="#">Files</a></li>
        <li class="breadcrumb-item"><a href="#">Music</a></li>
        <li class="breadcrumb-item active" aria-current="page">New</li>
    </ol>
</nav>

<div class="intro container">
    <div class="row justify-content-center">
        <div class="image col-md-4 col-12" style="padding-bottom: 32px;">
            <img src="assests/images/dat-mon-banner.jpg" alt="" style="width: 100%;"/>
        </div>
        <div class="intro-content col-md-6 col-12" style="padding: 0 16px 32px 16px;">
            <div style="padding-bottom: 8px;" class="sub">ĐẶT MÓN ONLINE - <a href="/trang-chu">Chi nhánh chính</a>
            </div>
            <div style="padding-bottom: 8px;" class="main">Nhà hàng Thịnh Tráng Điền, chi nhánh Quận 9</div>
            <div style="padding-bottom: 8px;" class="sub">75/6, Trương Văn Hải, Quận 9</div>
            <div style="color: #08a445; padding-bottom: 8px; font-weight: bold;">Đang mở cửa</div>
            <div style="color: #ababab; padding-bottom: 8px;">25000 đồng - 55000 đồng</div>
        </div>
    </div>
</div>

<div class="book container-fluid" style="margin-bottom: 32px; padding: 0 16px;">
    <div class="row">
        <div class="book-detail col-md-4 col-sm-12">
            <div class="card">
                <div class="card-body">
                    <div class="row">
                        <div class="col-7 card-title">Đơn hàng theo nhóm</div>
                        <div class="col-5" style="text-align: right;">
                            <div class="badge badge-danger" style="cursor: pointer;">Xóa đơn hàng</div>
                        </div>
                    </div>
                    <div class="card-description">
                        <div class="badge badge-success" id="share-don-hang" style="width: 100%;">Đơn hàng tạo bởi Nguyễn Lê Điền - 0 phần/0 người</div>
                        <div class="input-group form-group" style="margin-top: 8px;">
                            <input type="text" class="form-control" id="txt-link" value="Copy link chia sẻ">
                            <div class="input-group-append">
                                <input class="btn btn-info" type="button" value="Copy share link" id="btn-copy-link">
                            </div>
                        </div>
                    </div>
                    <div class="tinh-trang-gio-hang">
                        <h4>Tình trạng giỏ hàng</h4>
                        <div class="alert alert-success">
                            <span class="btn-xoa">x</span>
                            <span class="btn-cong">+</span>
                            <span class="so-luong">1</span>
                            <span class="btn-tru">-</span>
                            <span class="ten-mon-an" style="font-weight: bold;">Trà sửa phỉ thúy phô mai</span>
                            <span class="gia" style="color: #939b9d; font-size: small;">45000 đồng</span>
                        </div>
                        <div class="alert alert-success">
                            <span class="btn-xoa">x</span>
                            <span class="btn-cong">+</span>
                            <span class="so-luong">1</span>
                            <span class="btn-tru">-</span>
                            <span class="ten-mon-an" style="font-weight: bold;">Trà sửa phỉ thúy phô mai</span>
                            <span class="gia" style="color: #939b9d; font-size: small;">45000 đồng</span>
                        </div>
                    </div>
                    <div class="thong-tin-thanh-toan">
                        <table class="table tbl-thanh-toan">
                            <tr>
                                <td>Cộng</td>
                                <td class="text-right">
                                    <div class="badge badge-outline-warning">100 000 đồng</div>
                                </td>
                            </tr>
                            <tr>
                                <td>Phí vận chuyển</td>
                                <td class="text-right">
                                    <div class="badge badge-outline-success">7 000 đồng</div>
                                </td>
                            </tr>
                            <tr>
                                <td>Tổng cộng</td>
                                <td class="text-right">
                                    <div class="badge badge-outline-info">107 000 đồng</div>
                                </td>
                            </tr>
                        </table>
                        <div class="row justify-content-center" style="margin-top: 16px;">
                            <a href="#" class="btn btn-primary btn-rounded" style="width: 100%;">Thanh toán</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="food col-md-8 col-sm-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Danh sách món ăn nhà hàng bán</h4>
                    <ul class="nav nav-tabs tab-solid  tab-solid-primary" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active btn-rounded" id="tab-tat-ca-mon-an" data-toggle="tab" href="#tat-ca-mon-an" role="tab"
                                    aria-controls="home-6-1" aria-selected="true">Tất cả món ăn</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link btn-rounded" id="tab-thuc-an-nhanh" data-toggle="tab" href="#thuc-an-nhanh" role="tab"
                                    aria-controls="profile-6-2" aria-selected="false">Thức ăn nhanh</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link btn-rounded" id="tab-do-uong" data-toggle="tab" href="#do-uong" role="tab"
                                    aria-controls="contact-6-3" aria-selected="false">Đồ uống</a>
                        </li>
                        <li>
                            <input type="text" placeholder="Tìm món ăn" class="form-control" style="width: 300px;">
                        </li>
                    </ul>
                    <div class="tab-content tab-content-solid">
                        <div class="tab-pane fade show active" id="tat-ca-mon-an" role="tabpanel" aria-labelledby="tab-tab-tat-ca-mon-an">
                            <div class="food col-md-4 col-sm-6 col-12">
                                <a href="/chi-tiet-mon-an?id=1">
                                    <img src="assests/images/banh-xeo.jpg" alt="" />
                                    <div class="row" style="padding-top: 8px;">
                                        <div class="col-8"style="font-size: 18px;">Bánh xèo - 50 000đ</div>
                                        <div class="col-4" style="text-align: right;">
                                            <div class="badge badge-primary" style="cursor: pointer;">Mua</div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="food col-md-4 col-sm-6 col-12">
                                <a href="/chi-tiet-mon-an?id=1">
                                    <img src="assests/images/banh-xeo.jpg" alt="" />
                                    <div class="row" style="padding-top: 8px;">
                                        <div class="col-8"style="font-size: 18px;">Bánh xèo - 50 000đ</div>
                                        <div class="col-4" style="text-align: right;">
                                            <div class="badge badge-primary" style="cursor: pointer;">Mua</div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="food col-md-4 col-sm-6 col-12">
                                <a href="/chi-tiet-mon-an?id=1">
                                    <img src="assests/images/banh-xeo.jpg" alt="" />
                                    <div class="row" style="padding-top: 8px;">
                                        <div class="col-8"style="font-size: 18px;">Bánh xèo - 50 000đ</div>
                                        <div class="col-4" style="text-align: right;">
                                            <div class="badge badge-primary" style="cursor: pointer;">Mua</div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="food col-md-4 col-sm-6 col-12">
                                <a href="/chi-tiet-mon-an?id=1">
                                    <img src="assests/images/banh-xeo.jpg" alt="" />
                                    <div class="row" style="padding-top: 8px;">
                                        <div class="col-8"style="font-size: 18px;">Bánh xèo - 50 000đ</div>
                                        <div class="col-4" style="text-align: right;">
                                            <div class="badge badge-primary" style="cursor: pointer;">Mua</div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="food col-md-4 col-sm-6 col-12">
                                <a href="/chi-tiet-mon-an?id=1">
                                    <img src="assests/images/banh-xeo.jpg" alt="" />
                                    <div class="row" style="padding-top: 8px;">
                                        <div class="col-8"style="font-size: 18px;">Bánh xèo - 50 000đ</div>
                                        <div class="col-4" style="text-align: right;">
                                            <div class="badge badge-primary" style="cursor: pointer;">Mua</div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="food col-md-4 col-sm-6 col-12">
                                <a href="/chi-tiet-mon-an?id=1">
                                    <img src="assests/images/banh-xeo.jpg" alt="" />
                                    <div class="row" style="padding-top: 8px;">
                                        <div class="col-8"style="font-size: 18px;">Bánh xèo - 50 000đ</div>
                                        <div class="col-4" style="text-align: right;">
                                            <div class="badge badge-primary" style="cursor: pointer;">Mua</div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="food col-md-4 col-sm-6 col-12">
                                <a href="/chi-tiet-mon-an?id=1">
                                    <img src="assests/images/banh-xeo.jpg" alt="" />
                                    <div class="row" style="padding-top: 8px;">
                                        <div class="col-8"style="font-size: 18px;">Bánh xèo - 50 000đ</div>
                                        <div class="col-4" style="text-align: right;">
                                            <div class="badge badge-primary" style="cursor: pointer;">Mua</div>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="thuc-an-nhanh" role="tabpanel" aria-labelledby="tab-thuc-an-nhanh">

                        </div>
                        <div class="tab-pane fade" id="do-uong" role="tabpanel" aria-labelledby="tab-do-uong">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="_shared/user/page-footer.jsp"/>
<script type="text/javascript"
        src="<%= request.getContextPath() + "/" %>../../assests/js/script.dat-mon-nhom.js"></script>
<jsp:include page="_shared/user/end-of-file.jsp"/>