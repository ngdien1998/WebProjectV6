<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Quản lý đặt bàn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>
<div class="card">
    <div class="card-body">
        <h2 class="card-title">Quản lý đặt bàn</h2>
        <div class="row">
            <div class="col-sm-12 col-md-6">
                <!--<a href="/admin/them-mon-an" class="btn btn-primary btn-rounded">Thêm món ăn</a>-->
            </div>
            <div class="col-sm-12 col-md-6">
                <input type="search" class="form-control search" placeholder="Search" aria-controls="order-listing">
            </div>

        </div>
        <div class="table-responsive">
            <table class="table table-hover results" style="margin: 16px 0;" id="result">
                <thead>
                <tr>
                    <th width="170">Email</th>
                    <th>Bàn</th>
                    <th width="240">Thời Gian</th>
                    <th>Số lượng người</th>
                    <th>Giá</th>
                    <th>Ghi chú</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="datBan" items="${requestScope.datBans}">
                    <tr>
                        <td>
                            <div class="text">${datBan.email}</div>
                        </td>
                        <td>${datBan.ban}</td>
                        <td>
                            <div class="text">${datBan.thoiGian}</div>
                        </td>
                        <td>${datBan.soLuong}</td>
                        <td>${datBan.giaTien}đ</td>
                        <td>${datBan.ghiChu}</td>
                        <td>
                            <a href="/admin/xoa-dat-ban?email=${datBan.email}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row justify-content-center">
        <nav>
        <ul class="pagination flat pagination-primary">
        <li class="page-item"><a class="page-link" href="#"><i class="mdi mdi-chevron-left"></i></a></li>
        <li class="page-item active"><a class="page-link" href="#">1</a></li>
        <li class="page-item"><a class="page-link" href="#">2</a></li>
        <li class="page-item"><a class="page-link" href="#">3</a></li>
        <li class="page-item"><a class="page-link" href="#">4</a></li>
        <li class="page-item"><a class="page-link" href="#"><i class="mdi mdi-chevron-right"></i></a></li>
        </ul>
        </nav>
        </div>

        <div id="pageNavPosition"></div>

    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script>
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>