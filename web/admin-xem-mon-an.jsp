<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Chi tiết món ăn</title>
<style>
    thead tr th {
        font-weight: bold !important;
    }
</style>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card pl-2 pr-2" style="margin: 16px 0;">
    <div class="card-body">
        <h2>Thông tin chi tiết món ăn: ${requestScope.monAn.tenMonAn}</h2>
    </div>
    <div class="row">
        <%--<div class="col-12 mb-3">--%>
        <%--<span class="label">Ảnh</span> <br>--%>
        <%--<div class="row">--%>
        <%--<div class="col-2"><img src="" alt="Ảnh" width="100%"></div>--%>
        <%--<div class="col-2"><img src="./assests/images/Trua-Nay-An-Gi.jpg" alt="Ảnh" width="100%"></div>--%>
        <%--<div class="col-2"><img src="./assests/images/Trua-Nay-An-Gi.jpg" alt="Ảnh" width="100%"></div>--%>
        <%--<div class="col-2"><img src="./assests/images/Trua-Nay-An-Gi.jpg" alt="Ảnh" width="100%"></div>--%>
        <%--<div class="col-2"><img src="./assests/images/Trua-Nay-An-Gi.jpg" alt="Ảnh" width="100%"></div>--%>
        <%--<div class="col-2"><img src="./assests/images/Trua-Nay-An-Gi.jpg" alt="Ảnh" width="100%"></div>--%>
        <%--</div>--%>
        <%--</div>--%>
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
                    <td>Mô Tả</td>
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
                    <td>Ngày Thêm</td>
                    <td>${requestScope.monAn.ngayThem}</td>
                </tr>
                <tr>
                    <td>Loại Món Ăn:</td>
                    <td>${requestScope.loaiMon.tenLoaiMon}</td>
                </tr>
                <%--<tr>--%>
                <%--<td>Thực Đơn:</td>--%>
                <%--&lt;%&ndash;<td>${requestScope.thucDon.tenThucDon}</td>&ndash;%&gt;--%>
                <%--</tr>--%>
            </table>
        </div>
    </div>
    <div class="row justify-content-center mt-3 mb-4">
        <a href="/admin/sua-mon-an?idMonAn=${monAn.idMonAn}" class="btn btn-primary btn-rounded">Sửa
            món ăn</a> &nbsp; &nbsp;
        <a href="/admin/mon-an" class="btn btn-success btn-rounded">Về trang quản lý món ăn</a>
    </div>
</div>


<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>