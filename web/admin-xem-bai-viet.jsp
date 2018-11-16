<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Xem chi tiết bài viêt</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card">
    <div class="card-body">
        <h3 class="card-title">Thông tin bài viết</h3>

        <h4><b>${requestScope.baiViet.tenBaiViet}</b></h4>
        <p>${requestScope.nguoiViet.hoDem} ${requestScope.nguoiViet.ten} - ${requestScope.baiViet.ngayViet}</p>
        <p>${requestScope.loaiBaiViet.tenLoaiBaiViet}</p>
        <div class="noi-dung-bai-viet">
            ${requestScope.baiViet.noiDung}
        </div>
        <div class="row justify-content-center">
            <a href="/admin/sua-bai-viet?id=${requestScope.baiViet.idBaiViet}" class="btn btn-primary btn-rounded">Sửa bài viết</a>
            <a href="/admin/bai-viet" class="btn btn-success btn-rounded"
                    style="margin-left: 16px;">Quay lại</a>
        </div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />