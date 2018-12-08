<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Xem chi tiết loại món</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Quản lý bài viết</h2>
        <div class="row">
            <div class="col-sm-12 col-md-6">
                <a href="/admin/viet-bai" class="btn btn-primary btn-rounded">Viết bài</a>
            </div>
            <div class="col-sm-12 col-md-6">
                <input type="search" class="form-control" placeholder="Tìm kiếm bài viết"
                        aria-controls="order-listing">
            </div>
        </div>
        <table class="table table-hover" style="margin: 16px 0;">
            <thead>
            <tr>
                <th>Tên bài viết</th>
                <th width="113">Ngày viết</th>
                <th width="230"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="baiViet" items="${requestScope.baiViets}">
                <tr>
                    <td>
                        <div class="text">${baiViet.tenBaiViet}</div>
                    </td>
                    <td>${baiViet.ngayViet}</td>
                    <td>
                        <a href="/admin/xem-bai-viet?id=${baiViet.idBaiViet}">Xem</a> |
                        <a href="/admin/sua-bai-viet?id=${baiViet.idBaiViet}">Sửa</a> |
                        <a href="/admin/xoa-bai-viet?id=${baiViet.idBaiViet}">Xóa</a> |
                        <a href="/admin/binh-luan-bai-viet?idBaiViet=${baiViet.idBaiViet}">Bình luận</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="row">
            <nav>
                <ul class="pagination flat pagination-primary">
                    <li class="page-item"><a class="page-link" href="#"><i
                            class="mdi mdi-chevron-left"></i></a></li>
                    <li class="page-item active"><a class="page-link" href="#">1</a></li>
                    <li class="page-item"><a class="page-link" href="#">2</a></li>
                    <li class="page-item"><a class="page-link" href="#">3</a></li>
                    <li class="page-item"><a class="page-link" href="#">4</a></li>
                    <li class="page-item"><a class="page-link" href="#"><i
                            class="mdi mdi-chevron-right"></i></a></li>
                </ul>
            </nav>
        </div>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />