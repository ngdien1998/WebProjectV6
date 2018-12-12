 <%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="contact-bar row">
     <div class="col-3 contact-bar-greeting">
         <i>Hân hạnh được phục vụ quý khách</i>
     </div>

     <div class="col-9 contact-bar-functions">
         <c:choose>
             <c:when test="${sessionScope.nguoiDungHienTai != null}">
                 <a href="/sua-thong-tin-ca-nhan">Chào mừng ${sessionScope.nguoiDungHienTai.hoDem} ${sessionScope.nguoiDungHienTai.ten} đến với website</a>
                 <a href="/dang-xuat">Đăng xuất</a>
                 <c:if test="${sessionScope.nguoiDungHienTai.quanTriVien}">
                     <a href="/admin/ket-noi-database">Quản trị</a>
                 </c:if>
             </c:when>
             <c:otherwise>
                 <a href="/dang-nhap">Đăng nhập</a>
                 <a href="/dang-ky">Đăng ký</a>
             </c:otherwise>
         </c:choose>
         <a href="/gio-hang">Giỏ hàng</a>
     </div>
 </div>


<nav class="navbar navbar-expand-lg row" id="navbar-absolute" style="background-color: white !important;">
    <a class="navbar-brand font-blonde-script text-dark font-size-h3" href="#">
        <img src="assests/images/logo.png" width="50" height="50" class="d-inline-block align-top" alt="logo">
        Restaurant
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown"
            aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse justify-content-end" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link font-blonde-script text-dark font-size-h5" href="./trang-chu">Trang chủ
                    <span class="sr-only">(current)</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-dark font-size-h5" href="./thuc-don">Thực đơn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-dark font-size-h5" href="./tat-ca-mon-an">Món ăn</a>
            </li><li class="nav-item">
                <a class="nav-link font-blonde-script text-dark font-size-h5" href="./tat-ca-mon-an">Đặt món nhóm</a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-dark font-size-h5" href="./tin-tuc">Bài viết</a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-dark font-size-h5" href="./gioi-thieu">Nhà hàng</a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-dark font-size-h5" href="./dat-ban">Đặt bàn</a>
            </li>
            <li class="nav-item">
                <a class="nav-link font-blonde-script text-dark font-size-h5" href="./lien-he">Liên hệ</a>
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

