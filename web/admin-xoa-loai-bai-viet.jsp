<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Xóa loại bài viết</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Xóa loại bài viết: ${requestScope.loaiBaiViet.tenLoaiBaiViet}</h2>
        <p class="card-description">Thông tin chi tiết</p>
        <table>
                <tr>
                    <td>Tên loại bài viết</td>
                    <td>${requestScope.loaiBaiViet.tenLoaiBaiViet}</td>
                </tr>
                <tr>
                    <td>Mô tả</td>
                    <td>${requestScope.loaiBaiViet.moTa}</td>
                </tr>
        </table>
        <form action="/admin/xoa-loai-bai-viet" method="post">
            <input type="hidden" value="${requestScope.loaiBaiViet.idLoaiBaiViet}" name="txtIdLoai">
            <div class="form-row justify-content-center">
                <input type="submit" value="Xóa" class="btn btn-primary btn-rounded">
                <a href="/admin/loai-bai-viet" class="btn btn-success btn-rounded">Hủy bỏ</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script></script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>