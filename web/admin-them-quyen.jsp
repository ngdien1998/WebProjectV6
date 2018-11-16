<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Thêm quyền</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>
<div class="card" style="margin: 16px 0;">
    <div class="card-body">
        <h3 class="card-title">Thêm quyền mới</h3>
        <p class="card-description">
            Vui lòng nhập đầy đủ thông tin yêu cầu
        </p>
        <form action="/admin/them-quyen" method="post">
            <div class="form-row">
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="ID-quyen">ID quyền</label>
                    <input type="text" class="form-control" id="ID-quyen" placeholder="Mã quyền" name="txtIDQuyen">
                    <small class="text-danger" id="validate-id-quyen"></small>
                </div>
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="ten">Tên thực đơn(bắt buộc)</label>
                    <input type="text" class="form-control" id="ten" placeholder="Tên" name="txtTenQuyen">
                    <small class="text-danger" id="validate-ten"></small>
                </div>
            </div>

            <label for="ID-nghiep-vu">ID nghiệp vụ</label>
            <input type="text" class="form-control" id="ID-nghiep-vu" placeholder="Mã nghiệp vụ" name="txtIDNghiepVu">
            <small class="text-danger" id="validate-id-nghiep-vu"></small>
            <br>
            <label for="mota">Mô tả</label>
            <textarea rows="5" class="form-control" id="mota" placeholder="Mô tả" name="txtMoTa"></textarea>
            <small class="text-danger" id="validate-mota"></small>
            <br>
            <div class="form-row justify-content-center">

                    <input type="hidden" value="1" name="txtIdQuyen"/>
                <input type="submit" class="btn btn-primary btn-rounded mr-2" id="btn-submit"
                       value="Thêm quyền"/>
                    <a href="/admin/quyen" class="btn btn-primary btn-rounded">Quay về trang chủ</a>
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