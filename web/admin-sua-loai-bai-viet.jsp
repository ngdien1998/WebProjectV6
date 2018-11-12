<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Sửa loại bài viết</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Sửa loại bài viết: ${requestScope.loaiBaiViet.tenLoaiBaiViet}</h2>
        <p class="card-description">Vui lòng cung cấp đủ các thông tin sau</p>
        <form action="/admin/sua-loai-bai-viet" method="post">
            <input type="hidden" value="${requestScope.loaiBaiViet.idLoaiBaiViet}" name="txtIdLoai">
            <div class="form-row">
                <label for="ten-loai-bai-viet">Tên loại bài viết</label>
                <input type="text" class="form-control" id="ten-loai-bai-viet" placeholder="Tên loại bài viết" name="txtTenLoai" value="${requestScope.loaiBaiViet.tenLoaiBaiViet}">
                <small class="text-danger" id="validate-ten-loai-bai-viet"></small>
            </div>
            <div class="form-row">
                <label for="mo-ta">Mô tả</label>
                <input type="text" class="form-control" id="mo-ta" placeholder="Mô tả" name="txtMoTa" value="${requestScope.loaiBaiViet.moTa}">
                <small class="text-danger" id="validate-mo-ta"></small>
            </div>
            <div class="form-row justify-content-center">
                <input type="submit" value="Lưu lại" class="btn btn-primary btn-rounded">
                <a href="/admin/loai-bai-viet" class="btn btn-success btn-rounded">Hủy bỏ</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script></script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>