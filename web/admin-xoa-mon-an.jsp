<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Xác nhận xóa món ăn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card pl-2 pr-2" style="margin: 16px 0;">
    <div class="card-body">
        <h2>Thông tin chi tiết món ăn: ${requestScope.monAn.tenMonAn}</h2>
    </div>
    <div class="row">
        <div class="col-sm-5">
            <img src="${requestScope.monAn.hinhMonAn}" alt="" width="420px" height="325px">
        </div>
        <div class="col-sm-7">
            <table class="table table-striped">
                <tr>
                    <td>Tên Món Ăn:</td>
                    <td>${requestScope.monAn.tenMonAn}</td>
                </tr>
                <tr>
                    <td>Đơn vị tính:</td>
                    <td>${requestScope.monAn.donViTinh}</td>
                </tr>
                <tr>
                    <td>Mô Tả:</td>
                    <td>${requestScope.monAn.moTa}</td>
                </tr>
                <tr>
                    <td>Giá:</td>
                    <td>${requestScope.monAn.gia}đ</td>
                </tr>
                <tr>
                    <td>Phần Trăm Khuyến Mãi:</td>
                    <td>${requestScope.monAn.khuyenMai}%</td>
                </tr>
                <tr>
                    <td>Ngày Thêm:</td>
                    <td>${requestScope.monAn.ngayThem}</td>
                </tr>
                <tr>
                    <td>Loại Món Ăn:</td>
                    <td>${requestScope.loaiMon.tenLoaiMon}</td>
                </tr>
                <%--<tr>--%>
                    <%--<td>Thực Đơn:</td>--%>
                    <%--<td>${requestScope.thucDon.tenThucDon}</td>--%>
                <%--</tr>--%>
            </table>
        </div>
    </div>
    <form action="/admin/xoa-mon-an" method="post" class="mt-4 mb-4">
        <input type="hidden" value="${requestScope.monAn.idMonAn}" name="txtIdMonAn">
        <div class="form-row justify-content-center">
            <input type="submit" value="Xóa" class="btn btn-primary btn-rounded"> &nbsp;
            <a href="/admin/mon-an" class="btn btn-success btn-rounded">Hủy bỏ</a>
        </div>
    </form>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>

<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>
