<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Thêm thực đơn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>
<div class="card">
    <div class="card-body">
        <h3 class="card-title">Thêm thực đơn mới</h3>
        <p class="card-description">
            Vui lòng nhập đầy đủ thông tin yêu cầu
        </p>
        <form class="forms-sample" action="/admin/them-thuc-don" method="post" enctype="multipart/form-data" >
            <div class="form-row">
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="ten">Tên thực đơn (bắt buộc)</label>
                    <input type="text" class="form-control" id="ten" placeholder="Tên thực đơn" name="txtTenThucDon">
                    <small class="text-danger" id="validate-ten"></small>
                </div>
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="gia">Giá</label>
                    <input type="text" class="form-control" id="gia" placeholder="Giá" name="txtGia">
                    <small class="text-danger" id="validate-gia"></small>
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="phan-tram-khuyen-mai">Phần trăm khuyến mãi</label>
                    <input type="number" class="form-control" id="phan-tram-khuyen-mai"
                           placeholder="Phần trăm khuyến mãi" value="0" name="txtPhanTramKhuyenMai">
                    <small class="text-danger" id="validate-phan-tram-khuyen-mai"></small>
                </div>
                <div class="col-md-6 col-sm-12 form-group">
                    <label>Thứ</label>
                    <select class="form-control" name="cmbThu">
                        <option value="2">Thứ 2</option>
                        <option value="3">Thứ 3</option>
                        <option value="4">Thứ 4</option>
                        <option value="5">Thứ 5</option>
                        <option value="6">Thứ 6</option>
                        <option value="7">Thứ 7</option>
                        <option value="8">Chủ Nhật</option>
                    </select>
                </div>
            </div>

            <br>
            <label for="mota">Mô tả</label>
            <textarea rows="5" class="form-control" id="mota" placeholder="Mô tả"></textarea>
            <small class="text-danger"></small>
            <br>
            <div>
                <label for="mota">Ảnh</label>
                <br>
                <input type="file" name="filecover">
            </div>
            <br>
            <div class="form-row">
                <input type="submit" class="btn btn-primary btn-rounded mr-2" id="btn-submit"
                       value="Thêm thực đơn"/>
                <a href="/admin/thuc-don" class="btn btn-primary btn-rounded">Quay về trang quản lý thực đơn</a>
            </div>

        </form>
    </div>
</div>
<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>


<script type="text/javascript">
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

    // function validateForMota() {
    //     let mota = $("#mota").val().trim();
    //     if (mota === "") {
    //         $("#validate-mota").html("Bạn chưa nhập mô tả");
    //         return false;
    //     }
    //     $("#validate-mota").html("");
    //     return true;
    // }
    //
    // $("#mota").blur(() => validateForMota());

    function validateForGia() {
        let gia = $("#gia").val().trim();
        if (gia === "") {
            $("#validate-gia").html("Bạn chưa nhập giá");
            return false;
        }
        if (parseInt(gia) <= 0) {
            $("#validate-gia").html("Giá không hợp lệ.");
            return false;
        }
        $("#validate-gia").html("");
        return true;
    }

    $("#gia").blur(() => validateForGia());

    function validateForPhanTramKhuyenMai() {
        let ptkm = $("#phan-tram-khuyen-mai").val().trim();
        if (ptkm === "") {
            $("#validate-phan-tram-khuyen-mai").html("Bạn chưa nhập phần trăm khuyến mãi");
            return false;
        }
        if (parseInt(ptkm) < 0 || parseInt(ptkm) > 100) {
            $("#validate-phan-tram-khuyen-mai").html("Phần trăm khuyến mãi không hợp lệ.");
            return false;
        }
        $("#validate-phan-tram-khuyen-mai").html("");
        return true;
    }

    $("#phan-tram-khuyen-mai").blur(() => validateForPhanTramKhuyenMai());

    // function validateForThu() {
    //     let thu = $("#thu").val().trim();
    //     if (thu === "") {
    //         $("#validate-thu").html("Bạn chưa nhập thứ");
    //         return false;
    //     }
    //     if (parseInt(thu) < 2 || parseInt(thu) > 8) {
    //         $("#validate-thu").html("Thứ không hợp lệ.");
    //         return false;
    //     }
    //     $("#validate-thu").html("");
    //     return true;
    // }
    //
    // $("#thu").blur(() => validateForThu());

    $("#btn-submit").click(() => {
        let res = validateForTen()
            & validateForGia() & validateForPhanTramKhuyenMai();
        if (res === 0) {
            return false;
        }
        return true;
    });
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>