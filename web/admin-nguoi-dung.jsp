<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Danh sách người dùng</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Quản lý người dùng</h2>
        <div class="row">
            <div class="col-sm-12 col-md-6">
            </div>
            <div class="col-sm-12 col-md-6">
                <input type="search" class="form-control" placeholder="Tìm kiếm người dùng"
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
                <th>Nữ</th>
                <th>Điện thoại</th>
                <th>Trạng thái</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="nguoiDung" items="${nguoiDungs}">
                <tr>
                    <td>
                        <c:choose>
                            <c:when test="${!nguoiDung.avatar.equals(\"\")}">
                                <img src="${nguoiDung.avatar}"/>
                            </c:when>
                            <c:otherwise>
                                <img src=""/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${nguoiDung.hoDem} ${nguoiDung.ten}</td>
                    <td>${nguoiDung.email}</td>
                    <td>${nguoiDung.ngaySinh}</td>
                    <td>
                        <c:choose>
                            <c:when test="${nguoiDung.nu}">
                                <c:out value="Nữ"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="Nam"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${nguoiDung.dienThoai}</td>
                    <td>
                        <c:choose>
                            <c:when test="${nguoiDung.kichHoat}">
                                <c:out value="Kích hoạt"/>
                            </c:when>
                            <c:otherwise>
                                <c:out value="Khóa"/>
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <a href="/admin/xem-nguoi-dung?email=${nguoiDung.email}">Xem</a> |
                        <a href="/admin/xoa-nguoi-dung?email=${nguoiDung.email}">Xóa</a>
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