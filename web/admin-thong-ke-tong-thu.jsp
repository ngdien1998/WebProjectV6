<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Thống kê món ăn</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script>
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawBasic);

    function drawBasic() {

        var data = new google.visualization.DataTable();
        data.addColumn('number', 'X');
        data.addColumn('number', '');

        data.addRows([
            <c:forEach var="tongThu" items="${requestScope.thongKeTongThu}">
            [${tongThu.thoiGian}, ${tongThu.tongTien}],
            </c:forEach>
        ]);

        var options = {
            hAxis: {
                title: 'Ngày'
            },
            vAxis: {
                title: 'Tổng thu'
            }
        };

        var chart = new google.visualization.LineChart(document.getElementById('chart'));

        chart.draw(data, options);
    }
</script>
<%--Tor6ng3 thu từng ngày trong tháng này--%>
<script>
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawBasic);

    function drawBasic() {

        var data = new google.visualization.DataTable();
        data.addColumn('number', 'X');
        data.addColumn('number', '');

        data.addRows([
            <c:forEach var="tongThuThangNay" items="${requestScope.thongKeTongThuThangnay}">
                [${tongThuThangNay.thoiGian}, ${tongThuThangNay.tongTien}],
            </c:forEach>
        ]);

        var options = {
            hAxis: {
                title: 'Ngày'
            },
            vAxis: {
                title: 'Tổng thu'
            }
        };

        var chart = new google.visualization.LineChart(document.getElementById('chart_0'));

        chart.draw(data, options);
    }
</script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
    //load the Google Visualization API and the chart
    google.load('visualization', '1', {'packages': ['columnchart']});

    //set callback
    google.setOnLoadCallback(createChart);

    //callback function
    function createChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Tổng thu');
        data.addRows([
            <c:forEach var="tongThu" items="${requestScope.thongKeTongThuTungThang}">
            ['${tongThu.thoiGian}', ${tongThu.tongTien}],
            </c:forEach>
        ]);

        //instantiate our chart object
        var chart = new google.visualization.ColumnChart(document.getElementById('chart_2'));

        //define options for visualization
        var options = {is3D: false, width: 1000, height: 400, title: ''};

        //draw our chart
        chart.draw(data, options);

    }
</script>
<style>
    .table-wrapper-scroll-y {
        display: block;
        max-height:450px;
        overflow-y: auto;
        -ms-overflow-style: -ms-autohiding-scrollbar;
    }
</style>

<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h1 class="text-center text-danger">Tổng thu từng ngày trong tháng trước</h1>
        <div id="chart"></div>
        <br>
        <hr>
        <h1 class="text-center text-danger">Tổng thu từng ngày trong tháng này</h1>
        <div id="chart_0"></div>
        <hr>
        <br>
        <h1 class="text-center text-danger">Tổng thu từng tháng</h1>
        <div id="chart_2"></div>
        <form action="/admin/chi-tiet-tong-thu-theo-thang" method="post">
            <div class="form-group">
                <label>Xem chi tiết tổng thu của tháng:</label>
                <select name="thang" id="tong-thu-theo-thang" class="form-control">
                    <option value="1">Tháng 1</option>
                    <option value="2">Tháng 2</option>
                    <option value="3">Tháng 3</option>
                    <option value="4">Tháng 4</option>
                    <option value="5">Tháng 5</option>
                    <option value="6">Tháng 6</option>
                    <option value="7">Tháng 7</option>
                    <option value="8">Tháng 8</option>
                    <option value="9">Tháng 9</option>
                    <option value="10">Tháng 10</option>
                    <option value="11">Tháng 11</option>
                    <option value="12">Tháng 12</option>
                </select>
            </div>
            <%--<a class="btn btn-success"--%>
            <%--onclick="location.href='/admin/chi-tiet-thong-thu-theo-thang?thang='+document.getElementById('tong-thu-theo-thang').innerHTML">Xem--%>
            <%--chi tiết</a>--%>
            <button class="btn btn-success">Xem chi tiết</button>
            <c:if test="${requestScope.thang != null}">
                <button type="button" onclick="xuatBaoCao('${requestScope.thang}');" id="btn-bao-cao" class="btn btn-primary">Xuất excel</button>
            </c:if>
        </form>

        <c:choose>
            <c:when test="${requestScope.thongKeTongThuChiTietTungThang == null}">
            </c:when>
            <c:otherwise>
                <br>
                <div class="table-responsive table-wrapper-scroll-y">
                    <table class="table table-hover">
                        <thead>
                        <tr>
                            <th>Mã hóa đơn</th>
                            <th>Email</th>
                            <th>Tên món ăn</th>
                            <th>Số lượng</th>
                            <th>Đơn giá</th>
                            <th>Thời gian</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="thongKe" items="${requestScope.thongKeTongThuChiTietTungThang}">
                            <tr>
                                <td>ID: ${thongKe.idHoaDon}</td>
                                <td>${thongKe.email}</td>
                                <td>${thongKe.tenMonAn}</td>
                                <td>${thongKe.soLuong} đơn vị</td>
                                <td>${thongKe.donGia}đ</td>
                                <td>${thongKe.thoiGian}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
<script>
    function xuatBaoCao(thang) {
        $("#btn-bao-cao").html("Đang tạo file");
        $.get("/admin/excel-report/doanh-thu-theo-thang", { thang: thang }, content => {
            if (content.res !== null) {
                $("#btn-bao-cao").attr("onclick", "downloadReport('" + content.res + "')");
                $("#btn-bao-cao").html("Tải xuống");
            }
        });
    }

    function downloadReport(fileName) {
        let url = "/document/download?fileName=" + fileName;
        window.open(url, "_blank");
    }
</script>
<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>