<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Quản lý món ăn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card">
    <div class="card-body">
    <h2 class="card-title">Quản lý món ăn</h2>
    <div class="row">
        <div class="col-sm-12 col-md-6">
            <a href="/admin/them-mon-an" class="btn btn-primary btn-rounded">Thêm món ăn</a>
        </div>
        <div class="col-sm-12 col-md-6">
            <input type="search" class="form-control search" placeholder="Search" aria-controls="order-listing">
        </div>

    </div>
    <table class="table table-hover results" style="margin: 16px 0;">
        <thead>
        <tr>
            <th width="170">Tên</th>
            <th>Đơn Vị</th>
            <th width="240">Mô Tả</th>
            <th>Giá</th>
            <th>KM</th>
            <th>Ngày Thêm</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="monAn" items="${requestScope.monAns}">
            <tr>
                <td>
                    <div class="text">${monAn.tenMonAn}</div>
                </td>
                <td>${monAn.donViTinh}</td>
                <td>
                    <div class="text">${monAn.moTa}</div>
                </td>
                <td>${monAn.gia}</td>
                <td>${monAn.khuyenMai}%</td>
                <td>${monAn.ngayThem}</td>
                <td>
                    <a href="/admin/xem-mon-an?id=${monAn.idMonAn}">Xem</a> |
                    <a href="/admin/sua-mon-an?id=${monAn.idMonAn}">Sửa</a> |
                    <a href="/admin/xoa-mon-an?id=${monAn.idMonAn}">Xóa</a>
                </td>
                <td><a href="/admin/binh-luan-mon-an?id=${monAn.idMonAn}">Bình Luận</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="row">
        <nav>
            <ul class="pagination flat pagination-primary">
                <li class="page-item"><a class="page-link" href="#"><i class="mdi mdi-chevron-left"></i></a></li>
                <li class="page-item active"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#"><i class="mdi mdi-chevron-right"></i></a></li>
            </ul>
        </nav>
    </div>
</div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />