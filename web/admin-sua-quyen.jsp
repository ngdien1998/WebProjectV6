<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Sửa quyền</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Sửa quyền : ${quyen.tenQuyen}</h2>
        <p class="card-description">Vui lòng cung cấp đủ các thông tin sau</p>
        <form action="/admin/sua-quyen" method="post">
            <input type="hidden" value="${quyen.idQuyen}" name="txtIdQuyen">
            <div class="form-row">
                <label for="ten">Tên quyền</label>
                <input type="text" class="form-control" id="ten" placeholder="Tên quyền" name="txtTenQuyen" value="${quyen.tenQuyen}">
                <small class="text-danger" id="validate-ten"></small>
            </div>
            <div class="form-row">
                <label for="mo-ta">Mô tả</label>
                <input type="text" class="form-control" id="mo-ta" placeholder="Mô tả" name="txtMoTa" value="${quyen.moTa}">
                <small class="text-danger" id="validate-mo-ta"></small>
            </div>
            <div class="form-row">
                <label for="ID-nghiep-vu">ID nghiệp vụ</label>
                <input type="text" class="form-control" id="ID-nghiep-vu" placeholder="nghiệp vụ" name="txtIdNghiepVu" value="${quyen.moTa}">
                <small class="text-danger" id="validate-id-nghiep-vu"></small>
            </div>
            <div class="form-row justify-content-center">
                <input type="submit" value="Lưu lại" class="btn btn-primary btn-rounded">
                <a href="/admin/quyen" class="btn btn-success btn-rounded">Hủy bỏ</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script type="text/javascript">
    function validateForIDQuyen() {
        let idquyen = $("#ID-quyen").val().trim();
        if (idquyen === "") {
            $("#validate-id-quyen").html("Bạn chưa nhập ID quyền");
            return false;
        }
        $("#validate-id-quyen").html("");
        return true;
    }
    $("#ID-quyen").blur(() => validateForIDQuyen());

    function validateForTen() {
        let ten = $("#ten").val().trim();
        if (ten === "") {
            $("#validate-ten").html("Bạn chưa nhập tên");
            return false;
        }
        $("#validate-ten").html("");
        return true;
    }

    $("#ten").blur(() => validateForTen());

    function validateForIDNghiepVu() {
        let idnghiepvu = $("#ID-nghiep-vu").val().trim();
        if (idnghiepvu === "") {
            $("#validate-id-nghiep-vu").html("Bạn chưa nhập ID nghiệp vụ");
            return false;
        }
        $("#validate-id-nghiep-vu").html("");
        return true;
    }
    $("#ID-nghiep-vu").blur(() => validateForIDNghiepVu());

    function validateForMota() {
        let mota = $("#mota").val().trim();
        if (mota === "") {
            $("#validate-mota").html("Bạn chưa nhập mô tả");
            return false;
        }
        $("#validate-mota").html("");
        return true;
    }
    $("#mota").blur(() => validateForMota());



    $("#btn-submit").click(() => {
        let res = validateForIDQuyen() & validateForTen() & validateForMota() & validateForIDNghiepVu();
        if (res === 0) {
            return false;
        }
        return true;
    });
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>