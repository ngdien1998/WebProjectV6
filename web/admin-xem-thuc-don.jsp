<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Chi tiết thực đơn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h3 class="card-title">Chi tiết thực đơn: ${requestScope.thucDon.tenThucDon}</h3>
        <p class="card-description">
        Thông tin chi tiết
        </p>
        <div class="row">
            <div class="col-4">
                <img src="${requestScope.thucDon.hinhThucDon}" alt="" width="310ox" height="275px">
            </div>
            <div class="col-8">
                <table class="table table-striped">
                    <tr>
                        <td>ID thực đơn:</td>
                        <td>${requestScope.thucDon.idThucDon}</td>
                    </tr>
                    <tr>
                        <td>Tên thực đơn:</td>
                        <td>${requestScope.thucDon.tenThucDon}</td>
                    </tr>
                    <tr>
                        <td>Mô tả:</td>
                        <td>${requestScope.thucDon.moTa}</td>
                    </tr>
                    <tr>
                        <td>Giá:</td>
                        <td>${requestScope.thucDon.gia}đ</td>
                    </tr>
                    <tr>
                        <td>Phần trăm khuyến mãi:</td>
                        <td>${requestScope.thucDon.phanTramKhuyenMai}%</td>
                    </tr>
                    <tr>
                        <td>Thứ:</td>
                        <c:choose>
                            <c:when test="${thucDon.thu == '8'}">
                                <td>Chủ nhật</td>
                            </c:when>
                            <c:otherwise>
                                <td>${thucDon.thu}</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </table>
            </div>

        </div>

        <div class="form-row justify-content-center mt-3">
            <form method="post" action="XacNhanXemThucDon">
                <input type="hidden" value="1" name="idloaimon"/>
                <a class="btn btn-primary btn-rounded"
                   href="/admin/sua-thuc-don?idThucDon=${requestScope.thucDon.idThucDon}">Sửa thực đơn</a> &nbsp;
                <a href="/admin/thuc-don" class="btn btn-success btn-rounded">Về trang quản lý thực đơn</a>
            </form>
        </div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>