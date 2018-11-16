<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Xem quyền</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card" style="margin: 16px 0;">
    <div class="card-body">
        <h3 class="card-title">Thông tin quyền: ${quyen.tenQuyen}</h3>
        <p class="card-description">
            Thông tin chi tiết
        </p>
        <div class="row" style="margin-bottom: 16px;">
            <table class="table">
                <tr>
                    <td>ID quyền:</td>
                    <td>${quyen.idQuyen}</td>
                </tr>
                <tr>
                    <td>Tên quyền:</td>
                    <td>${quyen.tenQuyen}</td>
                </tr>
                <tr>
                    <td>Mô tả:</td>
                    <td>${quyen.moTa}</td>
                </tr>
                <tr>
                    <td>ID nghiệp vụ:</td>
                    <td>${quyen.idNghiepVu}</td>
                </tr>
                </tr>
            </table>
        </div>
        <div class="form-row justify-content-center">
            <form method="post" action="XacNhanXemXoaQuyen">
                <input type="hidden" value="1" name="idquyen"/>
                <a class="btn btn-primary btn-rounded" href="/admin/sua-quyen?idQuyen=${quyen.idQuyen}">Sửa</a>
                <a href="/admin/quyen">Về trang chủ</a>
            </form>
        </div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />