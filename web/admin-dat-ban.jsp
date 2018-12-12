<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>

<title>Quản lý đặt bàn</title>

<style>
    /* CSS căn id pagination ra giữa màn hình */
    #pagination {
        display: flex;
        display: -webkit-flex; /* Safari 8 */
        flex-wrap: wrap;
        -webkit-flex-wrap: wrap; /* Safari 8 */
        justify-content: center;
        -webkit-justify-content: center;
    }
</style>
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
                    <th>Thời Gian</th>
                    <th>Ngày</th>
                    <th>Số lượng người</th>
                    <th>Ghi chú</th>
                    <th>Họ tên</th>
                    <th>Số điện thoại</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="datBan" items="${requestScope.datBans}">
                    <tr>
                        <td>
                            <div class="text">${datBan.email}</div>
                        </td>
                        <td>
                            <div class="text">${datBan.thoiGian}</div>
                        </td>
                        <td>
                            <div class="text">${datBan.ngay}</div>
                        </td>
                        <td>${datBan.soLuong}</td>
                        <td>${datBan.ghiChu}</td>
                        <td>
                            <div class="text">${datBan.hoTen}</div>
                        </td>
                        <td>
                            <div class="text">${datBan.soDT}</div>
                        </td>
                        <td>
                            <a href="/admin/xoa-dat-ban?email=${datBan.email}">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <!-- Hiên thị nút bấm -->
            <ul id="pagination" class="text-center"></ul>
        </div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script>
</script>
    <script src="https://code.jquery.com/jquery-3.2.1.js" ></script>
    <script src="http://1892.yn.lt/blogger/JQuery/Pagging/js/jquery.twbsPagination.js" type="text/javascript"></script>
    <!-- JS tạo nút bấm di chuyển trang end -->
    <script type="text/javascript">
        $(function () {
            var pageSize = 10; // Hiển thị 6 sản phẩm trên 1 trang
            showPage = function (page) {
                $(".contentPage").hide();
                $(".contentPage").each(function (n) {
                    if (n >= pageSize * (page - 1) && n < pageSize * page)
                        $(this).show();
                });
            }
            showPage(1);
            ///** Cần truyền giá trị vào đây **///
            var totalRows = ${requestScope.soLuong}; // Tổng số sản phẩm hiển thị
            var btnPage = 3; // Số nút bấm hiển thị di chuyển trang
            var iTotalPages = Math.ceil(totalRows / pageSize);

            var obj = $('#pagination').twbsPagination({
                totalPages: iTotalPages,
                visiblePages: btnPage,
                onPageClick: function (event, page) {
                    /* console.info(page); */
                    showPage(page);
                }
            });
            /*console.info(obj.data());*/
        });
    </script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>