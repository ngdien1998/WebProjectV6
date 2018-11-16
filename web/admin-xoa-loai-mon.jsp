<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Xóa loại món</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Xóa loại món: ${requestScope.loaiMon.tenLoaiMon}</h2>
        <p class="card-description">Thông tin chi tiết</p>


        <table class="table table-hover" style="margin: 16px 0;">
            <tr>
                <td>Tên loại món:</td>
                <td>${requestScope.loaiMon.tenLoaiMon}</td>

            </tr>
            <tr>
                <td>Mô tả :</td>
                <td>${requestScope.loaiMon.moTa}</td>
            </tr>
        </table>

        <form action="/admin/xoa-loai-mon" method="post">
            <input type="hidden" value="${requestScope.loaiMon.idLoaiMon}" name="txtIdLoaiMon">
            <div class="form-row justify-content-center">
                <input type="submit" value="Xóa" class="btn btn-primary btn-rounded"> &nbsp;
                <a href="/admin/loai-mon" class="btn btn-success btn-rounded">Hủy bỏ</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script></script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>