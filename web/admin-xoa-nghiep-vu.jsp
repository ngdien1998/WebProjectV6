<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Xóa nghiệp vụ</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Xóa nghiệp vụ: ${nghiepVu.tenNghiepVu}</h2>
        <p class="card-description">Thông tin chi tiết</p>
        <div class="row" style="margin-bottom: 16px;">
            <table class="table">
                <tr>
                    <td>Tên quyền</td>
                    <td>${nghiepVu.tenNghiepVu}</td>
                </tr>
            </table>
            <form action="/admin/xoa-nghiep-vu" method="post">
                <input type="hidden" value="${nghiepVu.idNghiepVu}" name="txtIdNghiepVu">
                <div class="form-row justify-content-center">
                    <input type="submit" value="Xóa" class="btn btn-primary btn-rounded">
                    <a href="/admin/nghiep-vu" class="btn btn-success btn-rounded">Hủy bỏ</a>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
    <script></script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>