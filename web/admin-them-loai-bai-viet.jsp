<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Thêm loại bài viết</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Thêm loại bài viết</h2>
        <p class="card-description">Vui lòng cung cấp đủ các thông tin sau</p>
        <form class="forms-sample" action="/admin/them-loai-bai-viet" method="post">
            <div class="form-row">
                <label for="ten">Tên loại bài viết</label>
                <input type="text" class="form-control" id="ten" placeholder="Tên loại bài viết" name="txtTenLoai">
                <small class="text-danger" id="validate-ten-loai-bai-viet"></small>
            </div>
            <div class="form-row">
                <label for="mo-ta">Mô tả</label>
                <input type="text" class="form-control" id="mo-ta" placeholder="Mô tả" name="txtMoTa">
                <small class="text-danger" id="validate-mo-ta"></small>
            </div>
            <div class="form-row justify-content-center">
                <input type="submit" value="Thêm" class="btn btn-primary btn-rounded">
                <a href="/admin/loai-bai-viet" class="btn btn-success btn-rounded">Hủy bỏ</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script>
    function validateForTen() {
        let ten = $("#ten").val().trim();
        if (ten === "") {
            $("#validate-ten-loai-bai-viet").html("Bạn chưa nhập tên");
            return false;
        }
        $("#validate-ten").html("");
        return true;
    }
    $("#ten").blur(() => validateForTen());
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>