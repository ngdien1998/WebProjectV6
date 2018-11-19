<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Xóa đặt bàn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Xóa đặt bàn: ${datBan.ban}</h2>
        <p class="card-description">Thông tin chi tiết</p>
        <div class="row" style="margin-bottom: 16px;">
            <table class="table">
                <tr>
                    <td>Bàn</td>
                    <td>${datBan.ban}</td>
                </tr>
                <tr>
                    <td>Thời gian</td>
                    <td>${datBan.thoiGian}</td>
                </tr>
                <tr>
                    <td>Số lượng người</td>
                    <td>${datBan.soLuong}</td>
                </tr>
                <tr>
                    <td>Giá tiền</td>
                    <td>${datBan.giaTien}</td>
                </tr>
                <tr>
                    <td>Ghi chú</td>
                    <td>${datBan.ghiChu}</td>
                </tr>
            </table>
            <form action="/admin/xoa-nghiep-vu" method="post">
                <input type="hidden" value="${datBan.email}" name="txtEmail">
                <div class="form-row justify-content-center">
                    <input type="submit" value="Xóa" class="btn btn-primary btn-rounded">
                    <a href="/admin/dat-ban" class="btn btn-success btn-rounded">Hủy bỏ</a>
                </div>
            </form>
        </div>
    </div>
</div>
    <jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
    <script></script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>