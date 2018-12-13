<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Quản lý bình luận món ăn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card pl-2 pr-2" style="margin: 16px 0;">
    <div class="card-body">
        <h2>Thông Tin Bình Luận Món Ăn: ${requestScope.monAn.tenMonAn}</h2>
    </div>
    <div class="row">
        <table class="table table-hover" style="margin: 16px 0;">
            <thead>
            <tr>
                <th>Email</th>
                <th>Bình Luận</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="binhLuan" items="${requestScope.binhLuans}">
                <tr>
                    <td>${binhLuan.email}</td>
                    <td>${binhLuan.noiDung}</td>
                    <td>
                        <a href="/admin/xoa-binh-luan-mon-an?idMonAn=${requestScope.monAn.idMonAn}&idBinhLuan=${binhLuan.idBinhLuan}">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="row justify-content-center mt-3 mb-4">
        <a href="/admin/mon-an" class="btn btn-primary btn-rounded">Về trang quản lý món ăn</a>
    </div>
</div>
<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>

<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>