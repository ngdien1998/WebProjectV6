<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Thống kê món ăn - thực đơn</title>
<!-- load Google AJAX API -->
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
        data.addColumn('number', 'Món ăn');
        data.addRows([
            <c:forEach var="monAn" items="${requestScope.thongKeMonAns}">
                ['${monAn.tenMonAn}', ${monAn.soLuong}],
            </c:forEach>
        ]);

        //instantiate our chart object
        var chart = new google.visualization.ColumnChart(document.getElementById('chart'));

        //define options for visualization
        var options = {is3D: false, width: 1000, height: 400, title: ''};

        //draw our chart
        chart.draw(data, options);

    }
</script>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
    // Load the Visualization API and the piechart package.
    google.load('visualization', '1', {'packages': ['columnchart']});

    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);

    function drawChart() {

        // Create the data table.
        var data = google.visualization.arrayToDataTable([
            ['Country', 'Area(square km)'],
            <c:forEach var="thucDon" items="${requestScope.thongKeThucDon}">
                ['${thucDon.tenThucDon}', ${thucDon.soLanSuDung}],
            </c:forEach>
        ]);
        // Set chart options
        var options = {
            'title': '',
            is3D: true,
            pieSliceText: 'label',
            tooltip: {showColorCode: true},
            'width': 700,
            'height': 300
        };

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart2'));
        chart.draw(data, options);
    }
</script>

<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h1 class="text-center text-danger">Top 10 món ăn bán chạy nhất tháng trước</h1>
        <div id="chart"></div>
        <br>
        <hr>
        <br>
        <h1 class="text-center text-danger">Tổng quan các thực đơn được sử dụng</h1>
        <div id="chart2"></div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>
