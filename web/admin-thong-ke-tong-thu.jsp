<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Thống kê món ăn</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js" ></script>
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

<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card">
    <div class="card-body">
        <h1 class="text-center text-danger">Tổng thu từng ngày trong tháng</h1>
        <div id="chart"></div>
        <br>
        <hr>
        <br>
        <h1 class="text-center text-danger">Tổng thu từng tháng</h1>
        <div id="chart_2"></div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />