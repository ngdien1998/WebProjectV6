<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Quản lý thực đơn</title>
<style>
    thead tr th {
        font-weight: bold !important;
    }
</style>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Quản Lý Thực Đơn</h2>
        <div class="row">
            <div class="col-sm-12 col-md-6">
                <a href="/admin/them-thuc-don" class="btn btn-primary btn-rounded">Thêm thực đơn</a>
            </div>
            <div class="col-sm-12 col-md-6">
                <input type="search" class="form-control" placeholder="Search"
                       aria-controls="order-listing">
            </div>
        </div>
        <div class="table-responsive mb-4 mt-4">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Tên thực đơn</th>
                    <th style="width:220px">Mô tả</th>
                    <th>Giá</th>
                    <th>KM</th>
                    <th>Thứ</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="thucDon" items="${requestScope.thucDons}">
                    <tr>
                        <td>${thucDon.tenThucDon}</td>
                        <td>${thucDon.moTa}</td>
                        <td>${thucDon.gia}đ</td>
                        <td>${thucDon.phanTramKhuyenMai}%</td>
                        <c:choose>
                            <c:when test="${thucDon.thu == '8'}">
                                <td>Chủ nhật</td>
                            </c:when>
                            <c:otherwise>
                                <td>${thucDon.thu}</td>
                            </c:otherwise>
                        </c:choose>
                        <td>
                            <a href="/admin/xem-thuc-don?idThucDon=${thucDon.idThucDon}">Xem</a> |
                            <a href="/admin/sua-thuc-don?idThucDon=${thucDon.idThucDon}">Sửa</a> |
                            <a href="/admin/xoa-thuc-don?idThucDon=${thucDon.idThucDon}">Xóa</a>
                        </td>
                        <td>
                            <a href="/admin/them-mon-an-vao-thuc-don?idThucDon=${thucDon.idThucDon}">Thêm món ăn</a> |
                            <a href="/admin/thuc-don-mon-an?idThucDon=${thucDon.idThucDon}">Xem chi tiết</a>
                        </td>
                    </tr>
                </c:forEach>

                </tbody>
            </table>
        </div>
        <div class="row justify-content-center">
            <nav>
                <ul class="pagination flat pagination-primary">
                    <li class="page-item"><a class="page-link" href="#"><i
                            class="mdi mdi-chevron-left"></i></a></li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item"><a class="page-link" href="#"><i
                            class="mdi mdi-chevron-right"></i></a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>