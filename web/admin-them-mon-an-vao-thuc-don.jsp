<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Thêm món ăn vào thực đơn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card pl-2 pr-2" style="margin: 16px 0;">
    <form class="forms-sample" action="/admin/them-mon-an-vao-thuc-don" method="post">
        <div class="card-body">
            <h2>Thêm món ăn vào thực đơn: ${requestScope.thucDon.tenThucDon}</h2>
        </div>
        <div class="row">
            <div class="form-group col-md-12 col-sm-6 col-12">
                <label for="loai-mon">Chọn món ăn để thêm vào thực đơn (Có thể chọn nhiều món)</label>
                <select class="form-control" id="loai-mon" name="cmbMonAn" multiple>
                    <c:forEach var="monAn" items="${requestScope.listMonAn}">
                        <option value="${monAn.idMonAn}">${monAn.tenMonAn}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="txtIdThucDon" value="${requestScope.thucDon.idThucDon}">
            </div>
        </div>
        <div class="row justify-content-center mt-3 mb-4">
            <input type="submit" class="btn btn-primary btn-rounded" id="btn-submit"
                   value="Thêm"/> &nbsp;
            <a href="/admin/thuc-don" class="btn btn-success btn-rounded">Về trang quản lý thực đơn</a>
        </div>
    </form>
</div>
<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>

<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>