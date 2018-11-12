<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Quản lý món ăn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card" style="margin: 16px 0;">
    <div class="card-body">
        <h3 class="card-title">Sửa loại món</h3>
        <!--<p class="card-description">
            Vui lòng nhập đầy đủ thông tin yêu cầu
        </p>-->
        <form class="forms-sample" action="/admin/sua-loai-mon" method="post">
            <div class="form-row">
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="ID-loai-mon">ID loại món</label>
                    <input type="text" class="form-control" id="ID-loai-mon" placeholder="Mã loại món" value="${loaiMon.idLoaiMon}" readonly name="txtIdLoaiMon">
                    <small class="text-danger" id="validate-id-loai-mon"></small>
                </div>
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="ten">Tên loại món(bắt buộc)</label>
                    <input type="text" class="form-control" id="ten" placeholder="Tên" value="${loaiMon.tenLoaiMon}" name="txtTenLoaiMon">
                    <small class="text-danger" id="validate-ten"></small>
                </div>
            </div>
            <label for="mota">Mô tả</label>
            <textarea rows="5" class="form-control" id="mota" placeholder="Mô tả" name="txtMoTa">${loaiMon.moTa}</textarea>
            <small class="text-danger" id="validate-mota"></small>
            <br>
            <div class="form-row">
                <input type="submit" class="btn btn-primary btn-rounded mr-2" id="btn-submit" value="Sửa loại món"/>
                <a href="admin/loai-mon" class="btn btn-primary btn-rounded">Hủy bỏ</a>
            </div>

        </form>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<script type="text/javascript">
    function validateForIDLoaiMon() {
        let hodem = $("#ID-loai-mon").val().trim();
        if (hodem === "") {
            $("#validate-id-loai-mon").html("Bạn chưa nhập ID loại món");
            return false;
        }
        $("#validate-id-loai-mon").html("");
        return true;
    }

    $("#ID-loai-mon").blur(() => validateForIDLoaiMon());

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
    $("#ID-loai-mon").blur(() => validateForIDLoaiMon());

    function validateForMota() {
        let ten = $("#mota").val().trim();
        if (ten === "") {
            $("#validate-mota").html("Bạn chưa nhập mô tả");
            return false;
        }
        $("#validate-mota").html("");
        return true;
    }

    $("#mota").blur(() => validateForMota());

    $("#btn-submit").click(() => {
        let res = validateForIDLoaiMon() & validateForTen() & validateForMota();
        if (res === 0) {
            return false;
        }
        return true;
    });
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />