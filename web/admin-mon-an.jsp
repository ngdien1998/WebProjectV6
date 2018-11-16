<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Quản lý món ăn</title>
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
</style>
<script type="text/javascript">
    //<![CDATA[
    function Pager(tableName, itemsPerPage) {
        this.tableName = tableName;
        this.itemsPerPage = itemsPerPage;
        this.currentPage = 1;
        this.pages = 0;
        this.inited = false;

        this.showRecords = function (from, to) {
            var rows = document.getElementById(tableName).rows;
            // i starts from 1 to skip table header row
            for (var i = 1; i < rows.length; i++) {
                if (i < from || i > to)
                    rows[i].style.display = 'none';
                else
                    rows[i].style.display = '';
            }
        }

        this.showPage = function (pageNumber) {
            if (!this.inited) {
                alert("not inited");
                return;
            }
            var oldPageAnchor = document.getElementById('pg' + this.currentPage);
            oldPageAnchor.className = 'pg-normal';

            this.currentPage = pageNumber;
            var newPageAnchor = document.getElementById('pg' + this.currentPage);
            newPageAnchor.className = 'pg-selected';

            var from = (pageNumber - 1) * itemsPerPage + 1;
            var to = from + itemsPerPage - 1;
            this.showRecords(from, to);
        }

        this.prev = function () {
            if (this.currentPage > 1)
                this.showPage(this.currentPage - 1);
        }

        this.next = function () {
            if (this.currentPage < this.pages) {
                this.showPage(this.currentPage + 1);
            }
        }

        this.init = function () {
            var rows = document.getElementById(tableName).rows;
            var records = (rows.length - 1);
            this.pages = Math.ceil(records / itemsPerPage);
            this.inited = true;
        }
        this.showPageNav = function (pagerName, positionId) {
            if (!this.inited) {
                alert("not inited");
                return;
            }
            var element = document.getElementById(positionId);

            var pagerHtml = '<span onclick="' + pagerName + '.prev();" class="pg-normal"> &#171 Prev </span> | ';
            for (var page = 1; page <= this.pages; page++)
                pagerHtml += '<span id="pg' + page + '" class="pg-normal" onclick="' + pagerName + '.showPage(' + page + ');">' + page + '</span> | ';
            pagerHtml += '<span onclick="' + pagerName + '.next();" class="pg-normal"> Next &#187;</span>';

            element.innerHTML = pagerHtml;
        }
    }

    //]]>
</script>

<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Quản lý món ăn</h2>
        <div class="row">
            <div class="col-sm-12 col-md-6">
                <a href="/admin/them-mon-an" class="btn btn-primary btn-rounded">Thêm món ăn</a>
            </div>
            <div class="col-sm-12 col-md-6">
                <input type="search" class="form-control search" placeholder="Search" aria-controls="order-listing">
            </div>

        </div>
        <div class="table-responsive">
            <table class="table table-hover results" style="margin: 16px 0;" id="result">
                <thead>
                <tr>
                    <th width="170">Tên</th>
                    <th>Đơn Vị</th>
                    <th width="240">Mô Tả</th>
                    <th>Giá</th>
                    <th>KM</th>
                    <th>Ngày Thêm</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="monAn" items="${requestScope.monAns}">
                    <tr>
                        <td>
                            <div class="text">${monAn.tenMonAn}</div>
                        </td>
                        <td>${monAn.donViTinh}</td>
                        <td>
                            <div class="text">${monAn.moTa}</div>
                        </td>
                        <td>${monAn.gia}đ</td>
                        <td>${monAn.khuyenMai}%</td>
                        <td>${monAn.ngayThem}</td>
                        <td>
                            <a href="/admin/xem-mon-an?idMonAn=${monAn.idMonAn}">Xem</a> |
                            <a href="/admin/sua-mon-an?idMonAn=${monAn.idMonAn}">Sửa</a> |
                            <a href="/admin/xoa-mon-an?idMonAn=${monAn.idMonAn}">Xóa</a>
                        </td>
                        <td><a href="/admin/binh-luan-mon-an?idMonAn=${monAn.idMonAn}">Bình Luận</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <%--<div class="row justify-content-center">--%>
            <%--<nav>--%>
                <%--<ul class="pagination flat pagination-primary">--%>
                    <%--<li class="page-item"><a class="page-link" href="#"><i class="mdi mdi-chevron-left"></i></a></li>--%>
                    <%--<li class="page-item active"><a class="page-link" href="#">1</a></li>--%>
                    <%--<li class="page-item"><a class="page-link" href="#">2</a></li>--%>
                    <%--<li class="page-item"><a class="page-link" href="#">3</a></li>--%>
                    <%--<li class="page-item"><a class="page-link" href="#">4</a></li>--%>
                    <%--<li class="page-item"><a class="page-link" href="#"><i class="mdi mdi-chevron-right"></i></a></li>--%>
                <%--</ul>--%>
            <%--</nav>--%>
        <%--</div>--%>

        <div id="pageNavPosition"></div>

    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script type="text/javascript">
    $(document).ready(()=>{
        var pager = new Pager('results', 3);
        pager.init();
        pager.showPageNav('pager', 'pageNavPosition');
        pager.showPage(1);
    })

</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>