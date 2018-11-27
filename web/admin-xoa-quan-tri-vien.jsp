<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Xóa quản trị viên</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card" style="margin: 16px 0;">
    <div class="card-body">
        <h3 class="card-title">Bạn có chắc chắn xóa quản trị viên: ${requestScope.qtv.hoDem} ${requestScope.qtv.ten}</h3>
        <p class="card-description">
            Thông tin chi tiết
        </p>
        <div class="row" style="margin-bottom: 16px;">
            <div class="col-3" style="text-align: right; padding-right: 16px;">
                <img src="assests/images/faces/face1.jpg" style="border-radius: 50%;"/>
            </div>
            <div class="col-9">
                <table class="table">
                    <tr>
                        <td>Họ tên:</td>
                        <td>${requestScope.qtv.hoDem} ${requestScope.qtv.ten}</td>
                    </tr>
                    <tr>
                        <td>Email:</td>
                        <td>${requestScope.qtv.email}</td>
                    </tr>
                    <tr>
                        <td>Điện thoại:</td>
                        <td>${requestScope.qtv.dienThoai}</td>
                    </tr>
                    <tr>
                        <td>Ngày sinh</td>
                        <td>${requestScope.qtv.ngaySinh}</td>
                    </tr>
                    <tr>
                        <td>Địa chỉ:</td>
                        <td>${requestScope.qtv.diaChi}</td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="form-row justify-content-center">
            <form method="post" action="/admin/xoa-quan-tri-vien">
                <input type="hidden" value="${requestScope.qtv.email}" name="txtEmail" />
                <input type="submit" class="btn btn-primary btn-rounded" value="Xóa"/>
                <a style="margin-left: 16px;" href="/admin/quan-tri-vien" class="btn btn-success btn-rounded">Huỷ bỏ</a>
            </form>
        </div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />