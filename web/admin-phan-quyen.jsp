<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Sửa loại bài viết</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Phân quyền cho quản trị viên: ${requestScope.qtv.hoDem} ${requestScope.qtv.ten}</h2>
        <p class="card-description">Chọn các quyền cần gán theo danh sách dưới đây</p>
        <div class="row">
            <div class="col-12 col-md-5">
                <h3>Nghiệp vụ phân quyền</h3>
                <label for="nghiep-vu">Chọn nghiệp vụ</label>
                <select name="cmbNghiepVu" id="nghiep-vu" class="form-control">
                    <option value="-1" selected>Chọn nghiệp vụ</option>
                    <c:forEach var="nghiepVu" items="${requestScope.nghiepVus}">
                        <option value="${nghiepVu.idNghiepVu}">${nghiepVu.tenNghiepVu}</option>
                    </c:forEach>
                </select>
                <p class="business-description">Bạn chưa chọn nghiệp vụ</p>
            </div>
            <div class="col-12 col-md-6 offset-1">
                <h3>Danh sách quyền hạn</h3>
                <div class="quyen">
                    <p>Vui lòng chọn nghiệp vụ để thực hiện gán quyền cho quản trị viên này</p>
                </div>
                <div class="thong-bao-phan-quyen"></div>
            </div>
        </div>
        <div class="row justify-content-center" style="padding-top: 32px;">
            <a href="/admin/quan-tri-vien" class="btn btn-success btn-rounded">Xong</a>
        </div>
    </div>
</div>
<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script type="text/javascript">
    $("#nghiep-vu").change(() => {
        let selectedVal = $("#nghiep-vu").val();
        if (selectedVal === "-1") {
            $(".business-description").html("Bạn chưa chọn nghiệp vụ");
            $(".quyen").html("Vui lòng chọn nghiệp vụ đề phân quyền");
            return;
        }
        $.post("/admin/ajax-get-mo-ta-nghiep-vu", {idNghiepVu: selectedVal}, content => $(".business-description").html(content));
        $.post("/admin/ajax-get-quyen", {
            idNghiepVu: selectedVal,
            email: "${requestScope.qtv.email}"
        }, content => $(".quyen").html(content));
    });

    $(".quyen").change(event => {
        let id = event.target.value;
        let action = event.target.checked ? "add" : "remove";
        $.post("/admin/ajax-cap-nhap-phan-quyen", {
            idQuyen: id,
            email: "${requestScope.qtv.email}",
            action: action
        }, content => {
            if (content === "true") {
                if (action === "add") {
                    showSuccessToast();
                } else if (action === "remove") {
                    showDangerToast();
                }
            }
        });
    });
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>