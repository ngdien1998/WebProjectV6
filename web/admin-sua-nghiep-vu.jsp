<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Sửa nghiệp vụ</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Sửa nghiệp vụ: ${nghiepVu.tenNghiepVu}</h2>
        <p class="card-description">Vui lòng cung cấp đủ các thông tin sau</p>
        <form action="/admin/sua-nghiep-vu" method="post">
            <input type="hidden" value="${nghiepVu.idNghiepVu}" name="txtIdNghiepVu">
            <div class="form-row">
                <label for="ten">Tên nghiệp vụ</label>
                <input type="text" class="form-control" id="ten" placeholder="Tên nghiệp vụ" name="txtTenNghiepVu" value="${nghiepVu.tenNghiepVu}">
                <small class="text-danger" id="validate-ten"></small>
            </div>
            <!--<div class="form-row">
                <label for="mo-ta">Mô tả</label>
                <input type="text" class="form-control" id="mo-ta" placeholder="Mô tả" name="txtMoTa" value="">
                <small class="text-danger" id="validate-mo-ta"></small>
            </div>-->

            <div class="form-row justify-content-center">
                <input type="submit" value="Lưu lại" class="btn btn-primary btn-rounded">
                <a href="/admin/nghiep-vu" class="btn btn-success btn-rounded">Hủy bỏ</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script type="text/javascript">
    function validateForIDNghiepVu() {
        let idquyen = $("#ID-nghiep-vu").val().trim();
        if (idquyen === "") {
            $("#validate-id-nghiep-vu").html("Bạn chưa nhập ID nghiệp vụ");
            return false;
        }
        $("#validate-id-nghiep-vu").html("");
        return true;
    }
    $("#ID-quyen").blur(() => validateForIDNghiepVu());

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



/*    function validateForMota() {
        let mota = $("#mota").val().trim();
        if (mota === "") {
            $("#validate-mota").html("Bạn chưa nhập mô tả");
            return false;
        }
        $("#validate-mota").html("");
        return true;
    }
    $("#mota").blur(() => validateForMota());
    */



    $("#btn-submit").click(() => {
        let res = validateForIDQuyen() & validateForTen() & validateForMota() & validateForIDNghiepVu();
        if (res === 0) {
            return false;
        }
        return true;
    });
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>