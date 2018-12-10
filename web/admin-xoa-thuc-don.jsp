<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="_shared/admin/top-of-page.jsp" flush="true"/>
<title>Xác nhận xóa thực đơn</title>
<jsp:include page="_shared/admin/page-header.jsp" flush="true"/>

<div class="card">
    <div class="card-body">
        <h2 class="card-title">Xóa thực đơn: ${requestScope.thucDon.tenThucDon}</h2>
        <p class="card-description">Thông tin chi tiết</p>

        <div class="row">
            <div class="col-4">
                <img src="${requestScope.thucDon.hinhThucDon}" width="310ox" height="275px" alt="${requestScope.thucDon.tenThucDon}">
            </div>
            <div class="col-8">
                <table class="table table-hover" style="margin: 16px 0;">
                    <tr>
                        <td>Tên thực đơn:</td>
                        <td>${requestScope.thucDon.tenThucDon}</td>

                    </tr>
                    <tr>
                        <td>Mô tả :</td>
                        <td>${requestScope.thucDon.moTa}</td>
                    </tr>
                    <tr>
                        <td>Giá :</td>
                        <td>${requestScope.thucDon.gia}đ</td>
                    </tr>
                    <tr>
                        <td>Khuyến mãi :</td>
                        <td>${requestScope.thucDon.phanTramKhuyenMai}%</td>
                    </tr>
                    <tr>
                        <td>Thứ :</td>
                        <c:choose>
                            <c:when test="${requestScope.thucDon.thu == '8'}">
                                <td>Chủ nhật</td>
                            </c:when>
                            <c:otherwise>
                                <td>${requestScope.thucDon.thu}</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </table>
            </div>
        </div>

        <form action="/admin/xoa-thuc-don" method="post">
            <input type="hidden" value="${requestScope.thucDon.idThucDon}" name="txtIdThucDon">
            <div class="form-row justify-content-center">
                <input type="submit" value="Xóa" class="btn btn-primary btn-rounded"> &nbsp;
                <a href="/admin/thuc-don" class="btn btn-success btn-rounded">Hủy bỏ</a>
            </div>
        </form>
    </div>
</div>

<jsp:include page="_shared/admin/page-footer.jsp" flush="true"/>

<script type="text/javascript">
    function validateForTen() {
        let ten = $("#ten")
            .val()
            .trim();
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
        let gia = $("#gia")
            .val()
            .trim();
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
        let ptkm = $("#phan-tram-khuyen-mai")
            .val()
            .trim();
        if (ptkm === "") {
            $("#validate-phan-tram-khuyen-mai").html(
                "Bạn chưa nhập phần trăm khuyến mãi"
            );
            return false;
        }
        if (parseInt(ptkm) < 0 || parseInt(ptkm) > 100) {
            $("#validate-phan-tram-khuyen-mai").html(
                "Phần trăm khuyến mãi không hợp lệ."
            );
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

    // $("#thu").blur(() => validateForThu());

    $("#btn-submit").click(() => {
        let res =
            validateForTen() & validateForGia() & validateForPhanTramKhuyenMai();
        if (res === 0) {
            return false;
        }
        return true;
    });
</script>
<jsp:include page="_shared/admin/end-of-file.jsp" flush="true"/>
