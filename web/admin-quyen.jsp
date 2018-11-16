<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Quyền</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Quản lý quyền</h2>
        <div class="row">
            <div class="col-sm-12 col-md-6">
                <a href="/admin/them-quyen" class="btn btn-primary btn-rounded">Thêm quyền</a>
            </div>
            <div class="col-sm-12 col-md-6">
                <input type="search" class="form-control" placeholder="Search"
                       aria-controls="order-listing">
            </div>
        </div>
        <table class="table table-hover" style="margin: 16px 0;">
            <thead>
            <tr>
                <th>ID quyền</th>
                <th>Tên quyền</th>
                <th>Mô tả</th>
                <th>ID nghiệp vụ</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="quyen" items="${quyens}">
            <tr>
                <td>${quyen.idQuyen}</td>
                <td>${quyen.tenQuyen}</td>
                <td>${quyen.moTa}</td>
                <td>${quyen.idNghiepVu}</td>
                <td>
                    <a href="/admin/xem-quyen?idQuyen=${quyen.idQuyen}">Xem</a> |
                    <a href="/admin/sua-quyen?idQuyen=${quyen.idQuyen}">Sửa</a> |
                    <a href="/admin/xoa-quyen?idQuyen=${quyen.idQuyen}">Xóa</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
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
<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />
