<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Quản lý bình luận bài viết</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Bình luận bài viết</h2>
        <h4 class="card-description">${requestScope.tenBaiViet}</h4>
        <div class="row">
            <table class="table table-hover" style="margin: 16px 0;">
                <thead>
                <tr>
                    <th>Email</th>
                    <th>Bình Luận</th>
                    <th></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="binhLuan" items="${requestScope.binhLuans}">
                    <tr>
                        <td>${binhLuan.email}</td>
                        <td>${binhLuan.noiDung}</td>
                        <td>
                            <a href="javascript:xoaBinhLuan(${binhLuan.idBinhLuan})">Xóa</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="row justify-content-center mt-3 mb-4">
            <a href="/admin/bai-viet" class="btn btn-primary btn-rounded">Hủy</a>
        </div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script type="text/javascript">
    function xoaBinhLuan(idBinhLuan) {
        if (confirm("Bạn có thực sự muốn xóa bình luận này không?")) {
            $.urlParam = function(name){
                let results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
                if (results==null) {
                    return null;
                }
                return decodeURI(results[1]) || 0;
            };
            let idBaiViet = $.urlParam("idBaiViet");
            $.post("/xoa-binh-luan", { idBinhLuan: idBinhLuan }, () => location.href = "/admin/binh-luan-bai-viet?idBaiViet=" + idBaiViet);
        }
    }
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>