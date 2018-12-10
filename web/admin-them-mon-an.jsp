<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Thêm món ăn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card" style="margin: 16px 0;">
    <div class="card-body">
        <h3 class="card-title">Thêm Món Ăn Mới</h3>
        <p class="card-description">
            Vui lòng nhập đầy đủ thông tin yêu cầu
        </p>

        <form class="forms-sample" action="/admin/them-mon-an" method="post" enctype="multipart/form-data">
            <div class="form-row">
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="ten-mon-an">Tên Món Ăn (bắt buộc)</label>
                    <input type="text" class="form-control" id="ten-mon-an" placeholder="Tên món ăn" name="txtTenMonAn">
                    <small class="text-danger" id="validate-ten-mon-an"></small>
                </div>
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="don-vi-tinh">Đơn Vị Tính</label>
                    <input type="text" id="don-vi-tinh" name="txtDonViTinh" class="form-control">
                    <small class="text-danger" id="validate-don-vi-tinh"></small>
                </div>
            </div>
            <div class="form-group">
                <label for="mo-ta">Mô Tả</label>
                <textarea class="form-control" id="mo-ta" rows="2"
                          placeholder="Mô Tả" name="txtMoTa"></textarea>
                <small class="text-danger" id="validate-mo-ta"></small>
            </div>
            <div class="form-group">
                <label for="mo-ta">Mô Tả Chi Tiết</label>
                <textarea class="form-control"rows="5"
                          placeholder="Mô Tả Chi Tiết" name="txtMoTaChiTiet"></textarea>
                <small class="text-danger" ></small>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6 col-sm-12">
                    <label for="gia-tien">Giá (bắt buộc)</label>
                    <input type="number" class="form-control" id="gia-tien" placeholder="150.000" name="txtGia">
                    <small class="text-danger" id="validate-gia-tien"></small>
                </div>
                <div class="form-group col-md-6 col-sm-12">
                    <label>Phần Trăm Khuyến Mãi</label>
                    <input type="number" class="form-control" id="xac-nhan-mat-khau" placeholder="10%"
                           name="txtKhuyenMai" value="0">
                    <small class="text-danger"></small>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6 col-sm-6 col-12">
                    <label>Ngày Thêm</label>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker2'>
                            <input type='date' class="form-control" id="today" name="dteNgayThem"/>
                            <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                        </div>
                    </div>
                    <script type="text/javascript">
                        document.querySelector("#today").valueAsDate = new Date();
                    </script>
                </div>
                <div class="form-group col-md-6 col-sm-6 col-12">
                    <label for="loai-mon">Loại Món Ăn</label>
                    <select class="form-control" id="loai-mon" name="cmbLoaiMon">
                        <c:forEach var="loaiMon" items="${requestScope.listLoaiMon}">
                            <option value="${loaiMon.idLoaiMon}">${loaiMon.tenLoaiMon}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div>
                <label>Ảnh món ăn</label>
                <br>
                <input type="file" name="filecover">
                <br>
            </div>
            <br>
            <div class="row justify-content-center">
                <input type="submit" class="btn btn-primary btn-rounded" id="btn-submit"
                       value="Thêm món ăn"/>
                <a href="/admin/mon-an" class="btn btn-success btn-rounded"> Hủy bỏ
                    </a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script type="text/javascript">
    function validateForTenMonAn() {
        let hodem = $("#ten-mon-an").val().trim();
        if (hodem === "") {
            $("#validate-ten-mon-an").html("Bạn chưa nhập tên món ăn");
            return false;
        }
        $("#validate-ten-mon-an").html("");
        return true;
    }

    $("#ten-mon-an").blur(() => validateForTenMonAn());

    function validateForDonViTinh() {
        let donVi = $("#don-vi-tinh").val().trim();
        if (donVi === "") {
            $("#validate-don-vi-tinh").html("Bạn chưa nhập đơn vị");
            return false;
        }
        $("#validate-don-vi-tinh").html("");
        return true;
    }

    $("#don-vi-tinh").blur(() => validateForDonViTinh());

    function validateForGiaTien() {
        let ten = $("#gia-tien").val().trim();
        if (ten === "") {
            $("#validate-gia-tien").html("Bạn chưa nhập giá tiền");
            return false;
        }
        $("#validate-gia-tien").html("");
        return true;
    }

    $("#gia-tien").blur(() => validateForGiaTien());


    $("#btn-submit").click(() => {
        let res = validateForTenMonAn() & validateForGiaTien() & validateForDonViTinh();
        if (res === 0) {
            return false;
        }
        return true;
    });
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>