<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Danh sách quản trị viên</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Quản lý quản trị viên</h2>
        <div class="row">
            <div class="col-sm-12 col-md-6">
                <a href="/admin/them-quan-tri-vien" class="btn btn-primary btn-rounded">Thêm mới</a>
            </div>
            <div class="col-sm-12 col-md-6">
                <input type="search" class="form-control" placeholder="Tìm kiếm quản trị viên"
                        aria-controls="order-listing">
            </div>
        </div>
        <table class="table table-hover" style="margin: 16px 0;">
            <thead>
            <tr>
                <th>Ảnh</th>
                <th>Tên</th>
                <th>Email</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>Điện thoại</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="qtv" items="${requestScope.qtvs}">
                <tr>
                    <td>
                        <c:if test="${qtv.avatar != null}">
                            <img src="${qtv.avatar}" alt="QTV"/>
                        </c:if>
                    </td>
                    <td>${qtv.ten} ${qtv.hoDem}</td>
                    <td>${qtv.email}</td>
                    <td>${qtv.ngaySinh}</td>
                    <td>
                        <c:choose>
                            <c:when test="${qtv.nu}">Nữ</c:when>
                            <c:otherwise>Nam</c:otherwise>
                        </c:choose>
                    </td>
                    <td>${qtv.dienThoai}</td>
                    <td>
                        <a href="/admin/xem-quan-tri-vien?email=${qtv.email}">Xem</a> |
                        <a href="/admin/xoa-quan-tri-vien?email=${qtv.email}">Xóa</a> |
                        <a href="/admin/phan-quyen?email=${qtv.email}">Phân quyền</a>
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