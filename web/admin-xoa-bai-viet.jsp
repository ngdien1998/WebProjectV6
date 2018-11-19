<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Xóa bài viêt</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card">
    <div class="card-body">
        <h3 class="card-title">Bạn có chắc chắn xóa bài viết này không?</h3>

        <h4><b>${requestScope.baiViet.tenBaiViet}</b></h4>
        <p>${requestScope.nguoiViet.hoDem} ${requestScope.nguoiViet.ten} - ${requestScope.baiViet.ngayViet}</p>
        <p>${requestScope.loaiBaiViet.tenLoaiBaiViet}</p>
        <div class="noi-dung-bai-viet">
            ${requestScope.baiViet.noiDung}
        </div>
        <div class="row justify-content-center">
            <form action="/admin/xoa-bai-viet" method="post">
                <input type="hidden" value="${requestScope.baiViet.idBaiViet}" name="txtIdBaiViet" />
                <input type="submit" class="btn btn-primary btn-rounded" value="Xóa" />
                <a href="/admin/bai-viet" class="btn btn-success btn-rounded"
                style="margin-left: 16px;">Hủy</a>
            </form>
        </div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />