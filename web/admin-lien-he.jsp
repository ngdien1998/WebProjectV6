<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Quản lý liên hệ</title>

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
        <h2 class="card-title">Quản Lý liên hệ</h2>
        <div class="row">
            <div class="col-sm-12 col-md-6">
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
                    <th>Họ tên</th>
                    <th>Số điện thoại</th>
                    <th width="240">Nội dung</th>
                    <th>Thời gian</th>
                    <th>Trạng thái seen</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="lienHe" items="${requestScope.lienHes}">
                    <tr class="contentPage">
                        <td>
                            <div class="text">${lienHe.email}</div>
                        </td>
                        <td>${lienHe.hoTen}</td>
                        <td>${lienHe.soDT}</td>
                        <td>
                            <div class="text">${lienHe.noiDung}</div>
                        </td>
                        <td>${lienHe.thoiGian}</td>
                        <td>${lienHe.trangThaiSeen}</td>
                        <%--<td>--%>
                            <%--<a href="/admin/xem-hoa-don?idHoaDon=${hoaDon.idHoaDon}">Xem chi tiết</a>--%>
                        <%--</td>--%>
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
<!-- content-wrapper ends -->
<!-- partial:partials/_footer.html -->
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
<script>
    $(document).ready(function () {
        $(".search").keyup(function () {
            var searchTerm = $(".search").val();
            var listItem = $('.results tbody').children('tr');
            var searchSplit = searchTerm.replace(/ /g, "'):containsi('")

            $.extend($.expr[':'], {
                'containsi': function (elem, i, match, array) {
                    return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
                }
            });

            $(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function (e) {
                $(this).attr('visible', 'false');
            });

            $(".results tbody tr:containsi('" + searchSplit + "')").each(function (e) {
                $(this).attr('visible', 'true');
            });

            var jobCount = $('.results tbody tr[visible="true"]').length;
            $('.counter').text(jobCount + ' item');

            if (jobCount == '0') {
                $('.no-result').show();
            } else {
                $('.no-result').hide();
            }
        });
    });
</script>
</body>

</html>