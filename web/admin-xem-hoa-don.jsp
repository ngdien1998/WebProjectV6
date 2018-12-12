<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Quản lý hóa đơn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>
<style>
    thead tr th {
        font-weight: bold !important;
    }

    .pg-normal {
        color: red;
        font-weight: normal;
        text-decoration: none;
        cursor: pointer;
    }

    .pg-selected {
        color: black;
        font-weight: bold;
        text-decoration: underline;
        cursor: pointer;
    }

    .results tr[visible='false'],
    .no-result {
        display: none;
    }

    .results tr[visible='true'] {
        display: table-row;
    }

    .counter {
        padding: 8px;
        color: #ccc;
    }

    .text {
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        line-height: 16px;
        max-height: 32px;
        -webkit-line-clamp: 1;
        -webkit-box-orient: vertical;
    }
</style>
<div class="card">
    <div class="card-body">
        <h2 class="card-title">Chi Tiết Hóa Đơn ID: </h2>
        <table class="table table-hover results" style="margin: 16px 0;" id="result">
            <thead>
            <tr>
                <th width="170">Email</th>
                <th>Thời Gian</th>
                <th width="240">Ghi chú</th>
                <th>Tên món ăn</th>
                <th>Số lượng</th>
                <th>Đơn giá</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="hoaDon" items="${requestScope.hoaDons}">
                <tr class="contentPage">
                    <td>
                        <div class="text">${hoaDon.email}</div>
                    </td>
                    <td>${hoaDon.thoiGian}</td>
                    <td>
                        <div class="text">${hoaDon.ghiChu}</div>
                    </td>
                    <td>
                        <div class="text">${hoaDon.tenMon}</div>
                    </td>
                    <td>
                        <div class="text">${hoaDon.soLuong}</div>
                    </td>
                    <td>
                        <div class="text">${hoaDon.donGia}</div>
                    </td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="row justify-content-center mt-3 mb-4">
            <a href="/admin/hoa-don" class="btn btn-primary btn-rounded">Về trang quản lý hóa đơn</a>
        </div>
    </div>
</div>

<!-- container-scroller -->


<!-- plugins:js -->
<script src="assests/node_modules/jquery/dist/jquery.min.js"></script>
<script src="assests/node_modules/popper.js/dist/umd/popper.min.js"></script>
<script src="assests/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="assests/node_modules/perfect-scrollbar/dist/perfect-scrollbar.min.js"></script>
<!-- endinject -->
<!-- Plugin js for this page-->
<script src="assests/node_modules/jquery-sparkline/jquery.sparkline.min.js"></script>
<!-- End plugin js for this page-->
<!-- inject:js -->
<script src="assests/js/off-canvas.js"></script>
<script src="assests/js/hoverable-collapse.js"></script>
<script src="assests/js/misc.js"></script>
<script src="assests/js/settings.js"></script>
<script src="assests/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<script src="assests/js/todolist.js"></script>
<script src="assests/js/dashboard.js"></script>
<!-- End custom js for this page-->
</body>

</html>