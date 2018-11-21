<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Thêm nghiệp vụ</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>
<div class="card" style="margin: 16px 0;">
    <div class="card-body">
        <h3 class="card-title">Thêm nghiệp vụ</h3>
        <p class="card-description">
            Vui lòng nhập đầy đủ thông tin yêu cầu
        </p>
        <form action="/admin/them-nghiep-vu" method="post">
            <div class="form-row">
                <label for="ten">Tên nghiệp vụ</label>
                <input type="text" class="form-control" id="ten" placeholder="Tên nghiệp vụ" name="txtTenNghiepVu">
                <small class="text-danger" id="validate-ten"></small>
            </div>
            <div class="form-row justify-content-center">
                <input type="submit" value="Thêm" class="btn btn-primary btn-rounded">
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