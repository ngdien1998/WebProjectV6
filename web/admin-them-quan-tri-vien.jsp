<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Thêm quản trị viên</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card" style="margin: 16px 0;">
    <div class="card-body">
        <h3 class="card-title">Thêm quản trị viên mới</h3>
        <p class="card-description">
            Vui lòng nhập đầy đủ thông tin yêu cầu
        </p>
        <form action="/admin/them-quan-tri-vien" method="post">
            <div class="form-row">
                <div class="col-12 col-sm-6">
                    <div class="form-group">
                        <label for="allow">Trạng thái tài khoản</label>
                        <div class="form-check form-check-flat">
                            <label class="form-check-label">
                                <input type="checkbox" class="form-check-input" id="allow" name="chkChoPhep"
                                        <c:if test="${requestScope.nguoiDung.choPhep}">checked</c:if> />
                                Cho phép hoạt động
                            </label>
                        </div>
                    </div>
                </div>
                <div class="col-12 col-sm-6">
                    <div class="form-group">
                        <label for="allow">Trạng thái hoạt động</label>
                        <div class="form-check form-check-flat">
                            <label class="form-check-label">
                                <input type="checkbox" class="form-check-input" id="kich-hoat" name="chkKichHoat"
                                        <c:if test="${requestScope.nguoiDung.kichHoat}">checked</c:if> readonly/>
                                Đã kích hoạt
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="ho-dem">Họ đệm (bắt buộc)</label>
                    <input type="text" class="form-control" id="ho-dem" placeholder="Họ đệm" name="txtHoDem">
                    <small class="text-danger" id="validate-ho-dem"></small>
                </div>
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="ten">Tên (bắt buộc)</label>
                    <input type="text" class="form-control" id="ten" placeholder="Tên" name="txtTen">
                    <small class="text-danger" id="validate-ten"></small>
                </div>
            </div>
            <div class="form-group">
                <label for="email">Địa chỉ email (bắt buộc)</label>
                <input type="email" class="form-control" id="email" placeholder="Email" name="txtEmail">
                <small class="text-danger" id="validate-email"></small>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6 col-sm-12">
                    <label for="mat-khau">Mật khẩu (bắt buộc)</label>
                    <input type="password" class="form-control" id="mat-khau" placeholder="Mật khẩu" name="txtMatKhau">
                    <small class="text-danger" id="validate-mat-khau"></small>
                </div>
                <div class="form-group col-md-6 col-sm-12">
                    <label for="xac-nhan-mat-khau">Xác nhận mật khẩu (bắt buộc)</label>
                    <input type="password" class="form-control" id="xac-nhan-mat-khau"
                            placeholder="Xác nhận mật khẩu">
                    <small class="text-danger" id="validate-xac-nhan-mat-khau"></small>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4 col-sm-6 col-12">
                    <label>Giới tính</label>
                    <div class="row" style="padding-left: 16px;">
                        <div class="col form-radio">
                            <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="radGioiTinh" value="nam"
                                        id="nam">Nam
                                <i class="input-helper"></i>
                            </label>
                        </div>
                        <div class="col form-radio">
                            <label class="form-check-label">
                                <input type="radio" class="form-check-input" name="radGioiTinh" value="nu"
                                        id="nu">Nữ
                                <i class="input-helper"></i>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group col-md-4 col-sm-6 col-12">
                    <label for="ngay-sinh">Ngày sinh</label>
                    <input type="date" class="form-control" id="ngay-sinh" name="dteNgaySinh">
                    <small class="text-danger" id="validate-ngay-sinh"></small>
                </div>
                <div class="form-group col-md-4 col-sm-12">
                    <label for="xac-nhan-mat-khau">Số điện thoại</label>
                    <input type="text" class="form-control" id="dien-thoai"
                            placeholder="Số điện thoại" name="txtDienThoai">
                    <small class="text-danger" id="validate-dien-thoai"></small>
                </div>
            </div>
            <div class="form-group">
                <label for="dia-chi">Địa chỉ</label>
                <input type="text" class="form-control" id="dia-chi" placeholder="Địa chỉ" name="txtDiaChi">
            </div>
            <div class="justify-content-center">
                <input type="submit" class="btn btn-primary btn-rounded" id="btn-submit" value="Thêm quản trị viên"/>
                <a href="admin-quan-tri-vien.html" class="btn btn-success btn-rounded"
                        style="margin-left: 16px;">Về trang chủ</a>
            </div>
        </form>
        <h1>${sessionScope.error}</h1>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>
<script type="text/javascript">
    function validateForHoDem() {
        let hodem = $("#ho-dem").val().trim();
        if (hodem === "") {
            $("#validate-ho-dem").html("Bạn chưa nhập họ đệm");
            return false;
        }
        $("#validate-ho-dem").html("");
        return true;
    }

    $("#ho-dem").blur(() => validateForHoDem());

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

    function validateForEmail() {
        let email = $('#email').val().trim();
        if (email === "") {
            $("#validate-email").html("Bạn chưa nhập email");
            return false;
        }
        let emailreg = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
        if (!emailreg.test(email)) {
            $("#validate-email").html("Email không hợp lệ");
            return false;
        }

        $("#validate-email").html("");
        return true;
    }

    $("#email").blur(() => validateForEmail());

    function validateForMatKhau() {
        let matKhau = $("#mat-khau").val().trim();
        if (matKhau === "") {
            $("#validate-mat-khau").html("Bạn chưa nhập mật khẩu");
            return false;
        }
        if (matKhau.length < 8) {
            $("#validate-mat-khau").html("Mật khẩu phải có tối thiểu 8 ký tự");
            return false;
        }

        $("#validate-mat-khau").html("");
        return true;
    }

    $("#mat-khau").blur(() => validateForMatKhau());

    function validateForXacNhanMatKhau() {
        let matKhau = $("#xac-nhan-mat-khau").val().trim();
        if (matKhau === "") {
            $("#validate-xac-nhan-mat-khau").html("Bạn chưa nhập xác nhận mật khẩu");
            return false;
        }
        if (matKhau !== $("#mat-khau").val().trim()) {
            $("#validate-xac-nhan-mat-khau").html("Mật khẩu và xác nhận mật khẩu không trùng khớp");
            return false;
        }

        $("#validate-xac-nhan-mat-khau").html("");
        return true;
    }

    $("#xac-nhan-mat-khau").blur(() => validateForXacNhanMatKhau());

    function validateForDienThoai() {
        let dienThoai = $("#dien-thoai").val().trim();
        let reg = /^\+?\d{1,3}?[- .]?\(?(?:\d{2,3})\)?[- .]?\d\d\d[- .]?\d\d\d\d$/;
        if (dienThoai !== "" && !reg.test(dienThoai)) {
            $("#validate-dien-thoai").html("Số điện thoại không hợp lệ");
            return false;
        }

        $("#validate-dien-thoai").html("");
        return true;
    }

    $("#dien-thoai").blur(() => validateForDienThoai());

    $("#btn-submit").click(() => {
        let res = validateForHoDem() & validateForTen() & validateForEmail()
            & validateForMatKhau() & validateForXacNhanMatKhau() & validateForDienThoai();
        if (res === 0) {
            return false;
        }
        return true;
    });
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>