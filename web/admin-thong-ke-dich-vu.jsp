<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Thống kê món ăn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js" ></script>
<script>
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawBasic);

    function drawBasic() {

        var data = new google.visualization.DataTable();
        data.addColumn('number', 'X');
        data.addColumn('number', '');

        data.addRows([
            <c:forEach var="datBan" items="${requestScope.thongKeDatBanBieuDo}">
            [${datBan.ngay}, ${datBan.soLuong}],
            </c:forEach>
        ]);

        var options = {
            hAxis: {
                title: 'Ngày'
            },
            vAxis: {
                title: 'Số lượng bàn đặt'
            }
        };

        var chart = new google.visualization.LineChart(document.getElementById('chart'));

        chart.draw(data, options);
    }
</script>
<script>
    google.charts.load('current', {packages: ['corechart', 'line']});
    google.charts.setOnLoadCallback(drawBasic);

    function drawBasic() {

        var data = new google.visualization.DataTable();
        data.addColumn('number', 'X');
        data.addColumn('number', '');

        data.addRows([
            <c:forEach var="binhLuan" items="${requestScope.thongKeBinhLuanBieuDo}">
            [${binhLuan.ngay}, ${binhLuan.soLuong}],
            </c:forEach>
        ]);

        var options = {
            hAxis: {
                title: 'Ngày'
            },
            vAxis: {
                title: 'Số lượng bình luận'
            }
        };

        var chart = new google.visualization.LineChart(document.getElementById('chart_2'));

        chart.draw(data, options);
    }
</script>
<div class="card">
    <div class="card-body">
        <h1 class="text-center text-danger">Số hóa đơn đặt bàn theo ngày của tháng trước</h1>
        <div id="chart"></div>
        <br>
        <h1 class="text-center text-danger">Chi tiết</h1>
        <br>
        <hr>
        <br>
        <h1 class="text-center text-danger">Thống kê bình luận tháng trước</h1>
        <div id="chart_2"></div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />