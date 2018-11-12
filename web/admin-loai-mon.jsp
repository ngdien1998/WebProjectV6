<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Quản lý loại món</title>
<style>
    thead tr th{
        font-weight: bold !important;
    }
</style>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Quản Lý Loại Món</h2>
        <div class="row">
            <div class="col-sm-12 col-md-6">
                <a href="/admin/them-loai-mon" class="btn btn-primary btn-rounded">Thêm loại món</a>
            </div>
            <div class="col-sm-12 col-md-6">
                <input type="search" class="form-control" placeholder="Search"
                       aria-controls="order-listing">
            </div>
        </div>
        <div class="table-responsive">
            <table class="table table-hover" style="margin: 16px 0; width: 100px">
                <thead class="text-center" >
                <tr>
                    <th>ID loại món</th>
                    <th>Tên loại món</th>
                    <th>Mô tả</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>1</td>
                    <td>Món Bắc</td>
                    <td>Món miền Bắc</td>
                </tr>

                <c:forEach var="loaimon" items="${loaiMons}">
                    <tr>
                        <td>${loaimon.idLoaiMon}</td>
                        <td>${loaimon.tenLoaiMon}</td>
                        <td>${loaimon.moTa}</td>
                        <td>
                            <a href="/admin/xem-loai-mon?idLoaiMon=${loaimon.idLoaiMon}">Xem</a> |
                            <a href="/admin/sua-loai-mon?idLoaiMon=${loaimon.idLoaiMon}">Sửa</a> |
                            <a href="/admin/xoa-loai-mon?idLoaiMon=${loaimon.idLoaiMon}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row">
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