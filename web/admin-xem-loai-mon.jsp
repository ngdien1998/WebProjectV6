<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Xem chi tiết loại món</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card">
    <div class="card-body">
        <h3 class="card-title">Thông tin loại món: ${requestScope.loaiMon.tenLoaiMon}</h3>
        <p class="card-description">
            Thông tin chi tiết
        </p>
        <div class="row" style="margin-bottom: 16px;">
            <table class="table table-striped">
                <tr>
                    <td>ID loại món:</td>
                    <td>${requestScope.loaiMon.idLoaiMon}</td>
                </tr>
                <tr>
                    <td>Tên loại món:</td>
                    <td>${requestScope.loaiMon.tenLoaiMon}</td>
                </tr>
                <tr>
                    <td>Mô tả:</td>
                    <td>${requestScope.loaiMon.moTa}</td>
                </tr>
            </table>
        </div>
        <div class="form-row justify-content-center mt-2">
            <form method="post" action="XacNhanXemLoaiMon">
                <input type="hidden" value="1" name="idloaimon"/>
                <a class="btn btn-primary btn-rounded" href="/admin/sua-loai-mon?idLoaiMon=${requestScope.loaiMon.idLoaiMon}">Sửa loại món</a>
                <a href="/admin/loai-mon" class="btn btn-success btn-rounded">Về trang quản lý loại món</a>
            </form>
        </div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />