<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tất cả món ăn</title>

    <script
            type="text/javascript"
            src="assests/js/jquery-3.3.1.min.js"
    ></script>
    <script type="text/javascript" src="assests/js/parallax.min.js"></script>
    <script type="text/javascript" src="assests/js/bootstrap.min.js"></script>
    <link
            rel="stylesheet"
            type="text/css"
            href="assests/css/bootstrap.min.css"
    />

    <link rel="stylesheet" href="./assests/css/style.tat-ca-mon-an.css"/>
    <link rel="stylesheet" href="./assests//css/global.css"/>
    <link rel="stylesheet" href="./assests/css/style.trang-chu.css"/>
    <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
            integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
            crossorigin="anonymous"
    />
    <link
            rel="stylesheet"
            href="./assests/css/style.xem-thong-tin-ca-nhan.css"
    />
</head>

<body>

<jsp:include page="_shared/user/nav.jsp" flush="true"/>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
        <li class="breadcrumb-item"><a href="#">Thông tin cá nhân</a></li>
    </ol>
</nav>

<div class="maincontent">
    <div class="container">
        <div class="row profile">
            <div class="col-md-3">
                <div class="profile-sidebar">
                    <div class="profile-userpic">
                        <img
                                src="${requestScope.nguoiDung.avatar}"
                                class="img-responsive"
                                alt="Thông tin cá nhân"
                        />
                    </div>
                    <div class="profile-usertitle">
                        <div class="profile-usertitle-name"></div>
                        <!-- <div class="profile-usertitle-job">Web Developer</div> -->
                    </div>
                    <div class="profile-userbuttons">
                        <a href="/trang-chu" class="btn btn-success">
                            Trang chủ
                        </a>
                        <a href="/dang-xuat" class="btn btn-danger">
                            Thoát ra
                        </a>
                    </div>
                    <div class="profile-usermenu">

                        <a href="/sua-thong-tin-ca-nhan" class="btn btn-success" style="width: 100%; margin-top: 4px">
                            Sửa thông tin các nhân
                        </a>
                        <a href="/doi-mat-khau" class="btn btn-primary" style="width: 100%; margin-top: 4px">
                            Đổi mật khẩu
                        </a>
                    </div>
                </div>
            </div>
            <div class="col-md-9">
                <form action="/sua-thong-tin-ca-nhan" method="post" enctype="multipart/form-data">
                    <div class="profile-content">
                        <h2>Sửa thông tin cá nhân</h2>
                        <div class="row">
                            <div class="col-12">
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="text" class="form-control" name="txtEmail"
                                           value="${requestScope.nguoiDung.email}" readonly>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-6">
                                <div class="form-group">
                                    <label>Họ đệm</label>
                                    <input type="text" class="form-control" name="txtHoDem"
                                           value="${requestScope.nguoiDung.hoDem}"/>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group">
                                    <label>Tên</label>
                                    <input type="text" class="form-control" name="txtTen"
                                           value="${requestScope.nguoiDung.ten}">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-4">
                                <div class="form-group">
                                    <label>Ngày sinh</label>
                                    <input type="date" class="form-control" name="dteNgaySinh"
                                           value="${requestScope.nguoiDung.ngaySinh}">
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="form-group">
                                    <label>Giới tính</label>
                                    <%--<input type="text" class="form-control" value="Nữ">--%>
                                    <select name="slGioiTinh" class="form-control">
                                        <c:choose>
                                            <c:when test="${requestScope.nguoiDung.nu == true}">
                                                <option value="0">Nam</option>
                                                <option value="1" selected>Nữ</option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="0" selected>Nam</option>
                                                <option value="1">Nữ</option>
                                            </c:otherwise>
                                        </c:choose>

                                    </select>
                                </div>
                            </div>
                            <div class="col-4">
                                <div class="form-group">
                                    <label>Số điện thoại</label>
                                    <input type="text" class="form-control" name="txtDienThoai"
                                           value="${requestScope.nguoiDung.dienThoai}">
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                <div class="form-group">
                                    <label>Địa chỉ</label>
                                    <input type="text" class="form-control"
                                           value="${requestScope.nguoiDung.diaChi}" name="txtDiaChi">
                                </div>
                            </div>
                        </div>
                        <div>
                            <label>Ảnh đại diện</label>
                            <br>
                            <input type="file" name="filecover">
                        </div>
                        <br>
                        <button class="btn btn-success">Sửa thông tin</button>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>

<footer>
    <div
            class="footer parallax-window"
            data-parallax="scroll"
            data-image-src="assests/images/blur-close-up-cutlery-370984.jpg"
    >
        <div class="container-fluid">
            <div class="footer-title">
                <h1 class="font-blonde-script">Liên hệ</h1>
                <img src="assests/images/logo.png" height="100" width="100"/>
                <p>
                    <i
                    >Lorem Ipsum is simply dummy text of the printing and
                        typesetting industry</i
                    >
                </p>
                <form action="" method="post" class="email-input">
                    <div class="row">
                        <div class="input-group col-6 offset-3">
                            <input
                                    type="text"
                                    class="form-control"
                                    placeholder="Nhập email của bạn"
                                    aria-label="Recipient's username"
                                    aria-describedby="button-addon2"
                            />
                            <div class="input-group-append">
                                <input
                                        class="btn btn-info"
                                        type="submit"
                                        id="button-addon2"
                                        value="Đăng ký"
                                />
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
                    <h1 class="font-blonde-script content-header">
                        Thông tin liên hệ
                    </h1>
                    <p><b>Địa chỉ:</b> 75/6 Trương Văn Hải, Tăng Nhơn Phú B, Q9</p>
                    <p><b>Email:</b> nhahang@gmail.com</p>
                    <p><b>Hot line:</b> (098) 765 9898</p>
                    <span class="social"> <a></a> </span>
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
</footer>
</body>
</html>
