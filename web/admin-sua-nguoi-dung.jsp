<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true" />
<title>Sửa thông tin người dùng</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true" />

<div class="card" style="margin: 16px 0;">
    <div class="card-body">
        <h3 class="card-title">Sửa người dùng ${requestScope.nguoiDung.hoDem} ${requestScope.nguoiDung.ten}</h3>
        <p class="card-description">
            Vui lòng nhập đầy đủ thông tin yêu cầu
        </p>
        <form class="forms-sample" action="/admin/sua-nguoi-dung" method="post">
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
                                        <c:if test="${requestScope.nguoiDung.kichHoat}">checked</c:if> readonly />
                                Đã kích hoạt
                            </label>
                        </div>
                    </div>
                </div>
            </div>
            <div class="form-row">
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="ho-dem">Họ đệm (bắt buộc)</label>
                    <input readonly type="text" class="form-control" id="ho-dem" placeholder="Họ đệm"
                            name="txtHoDem"
                            value="${requestScope.nguoiDung.hoDem}">
                    <small class="text-danger" id="validate-ho-dem"></small>
                </div>
                <div class="col-md-6 col-sm-12 form-group">
                    <label for="ten">Tên (bắt buộc)</label>
                    <input readonly type="text" class="form-control" id="ten" placeholder="Tên"
                            value="${requestScope.nguoiDung.ten}" name="txtTen">
                    <small class="text-danger" id="validate-ten"></small>
                </div>
            </div>
            <div class="form-group">
                <label for="email">Địa chỉ email (bắt buộc)</label>
                <input readonly type="email" class="form-control" id="email" placeholder="Email"
                        name="txtEmail"
                        value="${requestScope.nguoiDung.email}">
                <small class="text-danger" id="validate-email"></small>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6 col-sm-12">
                    <label for="mat-khau">Mật khẩu (bắt buộc)</label>
                    <input readonly type="password" class="form-control" id="mat-khau" name="txtMatKhau"
                            placeholder="Mật khẩu"
                            value="${requestScope.nguoiDung.matKhau}">
                    <small class="text-danger" id="validate-mat-khau"></small>
                </div>
                <div class="form-group col-md-6 col-sm-12">
                    <label for="xac-nhan-mat-khau">Xác nhận mật khẩu (bắt buộc)</label>
                    <input readonly type="password" class="form-control" id="xac-nhan-mat-khau"
                            placeholder="Xác nhận mật khẩu" value="${requestScope.nguoiDung.matKhau}">
                    <small class="text-danger" id="validate-xac-nhan-mat-khau"></small>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-4 col-sm-6 col-12">
                    <label>Giới tính</label>
                    <div class="row" style="padding-left: 16px;">
                        <div class="col form-radio">
                            <label class="form-check-label">
                                <input disabled type="radio" class="form-check-input" name="radNam"
                                        id="nam"
                                        <c:if test="${requestScope.nguoiDung.nu ne true}">checked</c:if> />
                                Nam
                                <i class="input-helper"></i>
                            </label>
                        </div>
                        <div class="col form-radio">
                            <label class="form-check-label">
                                <input disabled type="radio" class="form-check-input" name="radNu"
                                        id="nu"
                                        <c:if test="${requestScope.nguoiDung.nu}">checked</c:if> />Nữ
                                <i class="input-helper"></i>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group col-md-4 col-sm-6 col-12">
                    <label for="ngay-sinh">Ngày sinh</label>
                    <input type="date" readonly class="form-control" id="ngay-sinh"
                            value="${requestScope.nguoiDung.ngaySinh}" name="dteNgaySinh">
                    <small class="text-danger" id="validate-ngay-sinh"></small>
                </div>
                <div class="form-group col-md-4 col-sm-12">
                    <label for="xac-nhan-mat-khau">Số điện thoại</label>
                    <input readonly type="text" class="form-control" id="dien-thoai" name="txtDienThoai"
                            placeholder="Số điện thoại" value="${requestScope.nguoiDung.dienThoai}">
                    <small class="text-danger" id="validate-dien-thoai"></small>
                </div>
            </div>
            <div class="form-group">
                <label>Ảnh đại diện</label>
                <input type="file" name="anhDaiDien" class="file-upload-default">
                <div class="input-group col-xs-12">
                    <input type="text" class="form-control file-upload-info" readonly
                            placeholder="Ảnh đại diện" name="txtAvatar"
                            value="${requestScope.nguoiDung.avatar}">
                    <span class="input-group-append">
                          <button class="btn btn-primary" type="button">Chọn ảnh từ Server</button>
                        </span>
                </div>
            </div>
            <div class="form-group">
                <label for="dia-chi">Địa chỉ</label>
                <input readonly type="text" class="form-control" id="dia-chi" placeholder="Địa chỉ"
                        name="txtDiaChi"
                        value="${requestScope.nguoiDung.diaChi}">
            </div>
            <div class="form-row justify-content-center">
                <input readonly type="submit" class="btn btn-primary btn-rounded" id="btn-submit"
                        value="Sửa người dùng" />
                <a href="/admin/nguoi-dung" class="btn btn-success btn-rounded"
                        style="margin-left: 16px;">Về trang chủ</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true" />
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true" />