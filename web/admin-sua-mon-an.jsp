<%@ page import="java.util.ArrayList" %>
<%@ page import="quanlynhahang.models.datamodels.ThucDon" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Sửa thông tin món ăn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card" style="margin: 16px 0;">
    <div class="card-body">
        <h3 class="card-title">Sửa Thông Tin Món Ăn : ${requestScope.monAn.tenMonAn}</h3>
        <form class="forms-sample" action="/admin/sua-mon-an" method="post" enctype="multipart/form-data" >
            <div class="form-row">
                <div class="col-md-6 col-sm-12 form-group">
                    <input type="hidden" name="txtIdMonAn" value="${requestScope.monAn.idMonAn}">
                    <label for="ten-mon-an">Tên Món Ăn (bắt buộc)</label>
                    <input type="text" class="form-control" id="ten-mon-an" placeholder="Tên món ăn"
                           value="${requestScope.monAn.tenMonAn}" name="txtTenMonAn">
                    <small class="text-danger" id="validate-ten-mon-an"></small>
                </div>
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="don-vi-tinh">Đơn Vị Tính</label>
                    <input type="text" class="form-control" id="don-vi-tinh" placeholder="Đơn vị"
                           value="${requestScope.monAn.donViTinh}" name="txtDonViTinh">
                    <small class="text-danger" id="validate-don-vi-tinh"></small>
                </div>
            </div>
            <div class="form-group">
                <label for="">Mô Tả</label>
                <textarea class="form-control" rows="3"
                          placeholder="Mô Tả" name="txtMoTa"> ${requestScope.monAn.moTa}</textarea>
                <small class="text-danger"></small>
            </div>
            <div class="form-group">
                <label>Mô Tả Chi Tiết</label>
                <textarea class="form-control"rows="5"
                          placeholder="Mô Tả Chi Tiết" name="txtMoTaChiTiet">${requestScope.monAn.moTaChiTiet}</textarea>
                <small class="text-danger" ></small>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6 col-sm-12">
                    <label for="gia-tien">Giá (bắt buộc)</label>
                    <input type="number" class="form-control" id="gia-tien" placeholder="150.000"
                           value="${requestScope.monAn.gia}" name="txtGia">
                    <small class="text-danger" id="validate-gia-tien"></small>
                </div>
                <div class="form-group col-md-6 col-sm-12">
                    <label>Phần Trăm Khuyến Mãi</label>
                    <input type="number" class="form-control" id="" placeholder="10%"
                           value="${requestScope.monAn.khuyenMai}"
                           name="txtKhuyenMai">
                    <small class="text-danger" id="validate-xac-nhan-mat-khau"></small>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6 col-sm-6 col-12">
                    <label>Ngày Thêm</label>
                    <div class="form-group">
                        <div class='input-group date' id='datetimepicker2'>
                            <input type='date' class="form-control" name="dteNgayThem"
                                   value="${requestScope.monAn.ngayThem}"/>
                            <span class="input-group-addon">
                                                    <span class="glyphicon glyphicon-calendar"></span>
                                                </span>
                        </div>
                    </div>
                    <script type="text/javascript">
                        $(function () {
                            $('#datetimepicker2').datetimepicker({
                                locale: 'ru'
                            });
                        });
                    </script>
                </div>
                <div class="form-group col-md-6 col-sm-6 col-12">
                    <label for="">Loại Món Ăn</label>
                    <select class="form-control" name="cmbIdLoaiMon">
                        <c:forEach var="loaiMon" items="${requestScope.listLoaiMon}">
                            <c:choose>
                                <c:when test="${loaiMon.idLoaiMon eq monAn.idLoaiMon}">
                                    <option value="${loaiMon.idLoaiMon}" selected>${loaiMon.tenLoaiMon}</option>
                                </c:when>
                                <c:otherwise>
                                    <option value="${loaiMon.idLoaiMon}">${loaiMon.tenLoaiMon}</option>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <script>
                function bs_input_file() {
                    $(".input-file").before(
                        function () {
                            if (!$(this).prev().hasClass('input-ghost')) {
                                var element = $("<input type='file' class='input-ghost' style='visibility:hidden; height:0'>");
                                element.attr("name", $(this).attr("name"));
                                element.change(function () {
                                    element.next(element).find('input').val((element.val()).split('\\').pop());
                                });
                                $(this).find("button.btn-choose").click(function () {
                                    element.click();
                                });
                                $(this).find("button.btn-reset").click(function () {
                                    element.val(null);
                                    $(this).parents(".input-file").find('input').val('');
                                });
                                $(this).find('input').css("cursor", "pointer");
                                $(this).find('input').mousedown(function () {
                                    $(this).parents('.input-file').prev().click();
                                    return false;
                                });
                                return element;
                            }
                        }
                    );
                }

                $(function () {
                    bs_input_file();
                });
            </script>
            <div>
                <label>Ảnh</label>
                <br>
                <input type="file" name="filecover" value="${requestScope.hinhMonAn}">
                <br>
            </div>
            <br>
            <div class="form-row justify-content-center">
                <input type="submit" class="btn btn-primary btn-rounded" id="btn-submit" value="Lưu"/> &nbsp;
                <a href="/admin/mon-an" class="btn btn-success btn-rounded"> Hủy bỏ</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>

<script>
    $(document).ready(function () {
        $("#btn-submit").click(() => {
            console.log($(#cmbIdLoaiMon).val(), $("#cmbIdThucDon").val());
            return false;
        })
    })
</script>

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
        let res = validateForTenMonAn() & validateForGiaTien();
        if (res === 0) {
            return false;
        }
        return true;
    });
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>