<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Chi tiết món ăn trong thực đơn</title>
<style>
    thead tr th {
        font-weight: bold !important;
    }
</style>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card pl-2 pr-2">
    <div class="card-body">
        <h2>Chi tiết các món ăn trong thực đơn</h2>
    </div>
    <div class="row">
        <div class="table-responsive">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Tên món ăn</th>
                    <th>Đơn vị tính</th>
                    <th>Mô tả</th>
                    <th>Giá</th>
                    <th>Khuyến mãi</th>
                    <th>Ngày thêm</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="monAn" items="${requestScope.monAns}">
                    <tr>
                        <td>${monAn.tenMonAn}</td>
                        <td>${monAn.donViTinh}</td>
                        <td>${monAn.moTa}</td>
                        <td>${monAn.gia}đ</td>
                        <td>${monAn.khuyenMai}%</td>
                        <td>${monAn.ngayThem}</td>
                        <td><a href="/admin/xoa-mon-an-khoi-thuc-don?idThucDon=${requestScope.idThucDon}&idMonAn=${monAn.idMonAn}">Xóa</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row justify-content-center mt-3 mb-4">
        <a href="/admin/thuc-don" class="btn btn-success btn-rounded">Về trang quản lý thực đơn</a>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>