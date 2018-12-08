<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:include page="/_shared/user/top-of-page.jsp"/>
<title>Đặt món nhóm</title>
<jsp:include page="_shared/user/page-header.jsp"/>
<link rel="stylesheet" href="<%= request.getContextPath() %>/assests/css/style.dat-mon-nhom.css">

<nav style="margin: 16px; text-align: center;" aria-label="breadcrumb" role="navigation">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
        <li class="breadcrumb-item"><a href="#">Món ăn</a></li>
        <li class="breadcrumb-item active" aria-current="page">Đặt món nhóm</li>
    </ol>
</nav>

<div class="intro container">
    <div class="row justify-content-center">
        <div class="image col-md-4 col-12" style="padding-bottom: 32px;">
            <img src="assests/images/dat-mon-banner.jpg" alt="" style="width: 100%;"/>
        </div>
        <div class="intro-content col-md-6 col-12" style="padding: 0 16px 32px 16px;">
            <div style="padding-bottom: 8px;" class="sub">ĐẶT MÓN ONLINE - <a href="/trang-chu">Chi nhánh chính</a>
            </div>
            <div style="padding-bottom: 8px;" class="main">Nhà hàng Thịnh Tráng Điền, chi nhánh Quận 9</div>
            <div style="padding-bottom: 8px;" class="sub">75/6, Trương Văn Hải, Quận 9</div>
            <div style="color: #08a445; padding-bottom: 8px; font-weight: bold;">Đang mở cửa</div>
            <div style="color: #ababab; padding-bottom: 8px;">25000 đồng - 55000 đồng</div>
        </div>
    </div>
</div>

<div class="book container-fluid" style="margin-bottom: 32px; padding: 0 16px;">
    <div class="row">
        <div class="book-detail col-md-4 col-sm-12">
            <div class="card">
                <div class="card-body">
                    <div id="gio-hang">
                        <div class="row card-title">
                            <div class="col-7" id="gio-hang-nhom"
                                    data-id-gio-hang="${requestScope.hoaDon.idHoaDonNhom}">Giỏ hàng nhóm
                            </div>
                            <c:if test="${requestScope.isInGroup && requestScope.hoaDon.emailNguoiTao == sessionScope.nguoiDungHienTai.email}">
                                <div class="col-5" id="xoa-don-hang" style="text-align: right;">
                                    <form action="/xoa-gio-hang-nhom" method="post">
                                        <input type="hidden" name="idGioHang" id="txt-id-gio-hang"
                                                value="${requestScope.hoaDon.idHoaDonNhom}">
                                        <input type="submit" id="btn-xoa" value="Xóa" class="btn btn-danger btn-rounded">
                                    </form>
                                </div>
                            </c:if>
                        </div>
                        <div class="card-description" id="shared-link">
                            <c:choose>
                                <c:when test="${requestScope.isInGroup}">
                                    <div class="badge badge-success"
                                            style="width: 100%;">Giỏ hàng tạo bởi ${requestScope.hoaDon.tenNguoiTao}
                                    </div>
                                    <div class="input-group form-group" style="margin-top: 8px;">
                                        <input id="txt-link" type="text" class="form-control" id="txt-link"
                                                value="${requestScope["javax.servlet.forward.request_uri"]}?id=${requestScope.hoaDon.idHoaDonNhom}">
                                        <div class="input-group-append">
                                            <input class="btn btn-info" type="button" value="Copy link"
                                                    id="btn-copy-link"/>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <form action="/tao-hoa-don-nhom" method="get">
                                        <input type="submit" class="btn btn-success btn-rounded" value="Tạo giỏ hàng"
                                                style="width: 100%;">
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="tinh-trang-gio-hang">
                            <c:if test="${requestScope.isInGroup}">
                                <div id="gio-hang-main-content">
                                    <c:choose>
                                        <c:when test="${requestScope.hoaDon.monAnNhoms.size() > 0}">
                                            <h4>Tình trạng giỏ hàng</h4>
                                            <div id="gio-hang-items">
                                                <c:forEach var="monAn" items="${requestScope.hoaDon.monAnNhoms}">
                                                    <div class="item-gio-hang">
                                                        <c:choose>
                                                            <c:when test="${monAn.emailNguoiDat == sessionScope.nguoiDungHienTai.email}">
                                                                <small>
                                                                    <b>Bạn</b> đã đặt
                                                                </small>
                                                                <div class="alert alert-warning"
                                                                        data-id="${monAn.idMonAn}">
                                                            <span class="btn-xoa"
                                                                    onclick="xoaMon(${requestScope.hoaDon.idHoaDonNhom}, ${monAn.idMonAn}, '${monAn.emailNguoiDat}');">x</span>
                                                                    <span class="btn-cong"
                                                                            onclick="themMon(${requestScope.hoaDon.idHoaDonNhom}, ${monAn.idMonAn}, '${monAn.emailNguoiDat}');">+</span>
                                                                    <span id="so-luong-${monAn.idMonAn}">${monAn.soLuong}</span>
                                                                    <span class="btn-tru"
                                                                            onclick="botMon(${requestScope.hoaDon.idHoaDonNhom}, ${monAn.idMonAn}, '${monAn.emailNguoiDat}');">-</span>
                                                                    <span class="ten-mon-an"
                                                                            style="font-weight: bold;">${monAn.tenMonAn}</span>
                                                                    <span class="gia"
                                                                            style="color: #939b9d; font-size: small;">${monAn.gia}đ</span>
                                                                </div>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <small>
                                                                    <b>${monAn.tenNguoiDat}</b> đã đặt
                                                                </small>
                                                                <div class="alert alert-success"
                                                                        data-id="${monAn.idMonAn}">
                                                            <span class="btn-xoa"
                                                                    onclick="xoaMon(${requestScope.hoaDon.idHoaDonNhom}, ${monAn.idMonAn}, '${monAn.emailNguoiDat}');">x</span>
                                                                    <span class="btn-cong"
                                                                            onclick="themMon(${requestScope.hoaDon.idHoaDonNhom}, ${monAn.idMonAn}, '${monAn.emailNguoiDat}');">+</span>
                                                                    <span id="so-luong-${monAn.idMonAn}">${monAn.soLuong}</span>
                                                                    <span class="btn-tru"
                                                                            onclick="botMon(${requestScope.hoaDon.idHoaDonNhom}, ${monAn.idMonAn}, '${monAn.emailNguoiDat}');">-</span>
                                                                    <span class="ten-mon-an"
                                                                            style="font-weight: bold;">${monAn.tenMonAn}</span>
                                                                    <span class="gia"
                                                                            style="color: #939b9d; font-size: small;">${monAn.gia}đ</span>
                                                                </div>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </div>
                                                </c:forEach>
                                            </div>
                                            <div class="thong-tin-thanh-toan">
                                                <table class="table tbl-thanh-toan">
                                                    <tr>
                                                        <td>Cộng</td>
                                                        <td class="text-right">
                                                            <div class="badge badge-outline-warning"
                                                                    id="cong">${requestScope.cong} đồng
                                                            </div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Phí vận chuyển</td>
                                                        <td class="text-right">
                                                            <div class="badge badge-outline-success">7 000 đồng</div>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>Tổng cộng</td>
                                                        <td class="text-right">
                                                            <div class="badge badge-outline-info"
                                                                    id="tong-cong">1${requestScope.tongCong} đồng
                                                            </div>
                                                        </td>
                                                    </tr>
                                                </table>

                                                <c:if test="${requestScope.hoaDon.emailNguoiTao == sessionScope.nguoiDungHienTai.email}">
                                                    <input id="btn-thanh-toan" type="button"
                                                            onclick="thanhToanGioHang(${requestScope.hoaDon.idHoaDonNhom})"
                                                            class="btn btn-primary btn-rounded"
                                                            style="margin-top: 16px; width: 100%;" value="Thanh toán">
                                                </c:if>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <h4>Tình trạng giỏ hàng</h4>
                                            <div class="alert-warning alert">Giỏ hàng chưa có món ăn nào. Hãy chia sẻ link để mọi người cùng đặt món</div>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                                <script type="text/javascript">
                                    let timmer = setInterval(() => capNhatGioHang(), 5000);
                                </script>
                            </c:if>
                        </div>
                    </div>
                    <div class="alert">
                        <h4>Chức năng tạo đơn hàng theo nhóm</h4>
                        <p style="opacity: 0.7">Sử dụng tính năng này dể dàng qua các bước sau:</p>
                        <ol>
                            <li>Nhấn vào nút Tạo giỏ hàng</li>
                            <li>Copy link của giỏ hàng và share cho những người sẽ cùng đặt món với bạn</li>
                            <li>Những người bạn của bạn sẽ được chọn món ăn theo ý của họ mà không cần phụ thuộc vào người nào</li>
                            <li>Sau khi thỏa thuận xong. Bạn, chính là người tạo ra giỏ hàng sẽ nhấn nút Đặt hàng và chờ đợi giao hàng đến</li>
                        </ol>
                        <p style="opacity: 0.7">Chúc các bạn trải nghiệm tốt dịch vụ và thưởng thức món ăn ngon miệng</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="food col-md-8 col-sm-12">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Danh sách món ăn nhà hàng bán</h4>
                    <ul class="nav nav-tabs tab-solid  tab-solid-primary" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active btn-rounded" id="tab-tat-ca-mon-an" data-toggle="tab"
                                    href="#tat-ca-mon-an" role="tab"
                                    aria-controls="home-6-1" aria-selected="true">Tất cả món ăn</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link btn-rounded" id="tab-thuc-an-nhanh" data-toggle="tab"
                                    href="#thuc-an-nhanh" role="tab"
                                    aria-controls="profile-6-2" aria-selected="false">Thức ăn nhanh</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link btn-rounded" id="tab-do-uong" data-toggle="tab" href="#do-uong"
                                    role="tab"
                                    aria-controls="contact-6-3" aria-selected="false">Đồ uống</a>
                        </li>
                        <li>
                            <input type="text" placeholder="Tìm món ăn" class="form-control" style="width: 300px;">
                        </li>
                    </ul>
                    <div class="tab-content tab-content-solid">
                        <div class="tab-pane fade show active" id="tat-ca-mon-an" role="tabpanel"
                                aria-labelledby="tab-tab-tat-ca-mon-an">
                            <c:forEach var="monAn" items="${requestScope.monAns}">
                                <div class="food col-md-4 col-sm-6 col-12">
                                    <a href="/chi-tiet-mon-an?id=${monAn.idMonAn}">
                                        <img src="${monAn.hinhMonAn}" alt=""/>
                                    </a>
                                    <div class="row" style="padding-top: 8px;">
                                        <div class="badge badge-primary mua-mon-an" data-id-mon-an="${monAn.idMonAn}"
                                                style="margin: 0 10px; cursor: pointer; width: 100%; overflow: hidden;">Mua ${monAn.gia + monAn.gia * monAn.khuyenMai}đ - ${monAn.tenMonAn}
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="tab-pane fade" id="thuc-an-nhanh" role="tabpanel"
                                aria-labelledby="tab-thuc-an-nhanh">
                            <c:forEach var="monAn" items="${requestScope.monAnNhanhs}">
                                <div class="food col-md-4 col-sm-6 col-12">
                                    <a href="/chi-tiet-mon-an?id=${monAn.idMonAn}">
                                        <img src="assests/images/banh-xeo.jpg" alt=""/>
                                    </a>
                                    <div class="row" style="padding-top: 8px;">
                                        <div class="badge badge-primary mua-mon-an" data-id-mon-an="${monAn.idMonAn}"
                                                style="margin: 0 10px; cursor: pointer; width: 100%; overflow: hidden;">Mua ${monAn.gia + monAn.gia * monAn.khuyenMai}đ - ${monAn.tenMonAn}đ
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="tab-pane fade" id="do-uong" role="tabpanel" aria-labelledby="tab-do-uong">
                            <c:forEach var="monAn" items="${requestScope.doUongs}">
                                <div class="food col-md-4 col-sm-6 col-12">
                                    <a href="/chi-tiet-mon-an?id=${monAn.idMonAn}">
                                        <img src="assests/images/banh-xeo.jpg" alt=""/>
                                    </a>
                                    <div class="row" style="padding-top: 8px;">
                                        <div class="badge badge-primary mua-mon-an" data-id-mon-an="${monAn.idMonAn}"
                                                style="margin: 0 10px; cursor: pointer; width: 100%; overflow: hidden;">Mua ${monAn.gia + monAn.gia * monAn.khuyenMai}đ - ${monAn.tenMonAn}</div>
                                    </div>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="_shared/user/page-footer.jsp"/>
<script type="text/javascript">
    function addLoader() {
        $("#gio-hang-main-content").html('<div class="circle-loader"></div>');
    }

    function choPhepSuaMonAn(emailNguoiDatMon) {
        let emailLogin = $("#email-nguoi-dang-nhap").data("email");
        return emailLogin === emailNguoiDatMon;
    }

    function capNhatGioHang() {
        $.post("/cap-nhap-trang-thai-gio-hang", {
            idGioHang: $("#gio-hang-nhom").data("id-gio-hang")
        }, content => $("#gio-hang-main-content").html(content));
    }

    function botMon(idHoaDon, idMonAn, emailNguoiDat) {
        if (!choPhepSuaMonAn(emailNguoiDat)) {
            alert("Bạn không được chỉnh sửa món ăn của người khác");
            return;
        }
        let soLuong = parseInt($("#so-luong-" + idMonAn).html());
        if (soLuong > 1) {
            $("#so-luong-" + idMonAn).html(soLuong - 1);
            $.post("/tru-bot-mon-an-nhom", {
                idHoaDon: idHoaDon,
                idMonAn: idMonAn,
                emailNguoiDat: emailNguoiDat,
                soLuong: soLuong
            }, () => capNhatGioHang());
        }
    }

    function themMon(idHoaDon, idMonAn, emailNguoiDat) {
        if (!choPhepSuaMonAn(emailNguoiDat)) {
            alert("Bạn không được chỉnh sửa món ăn của người khác");
            return;
        }
        let soLuong = parseInt($("#so-luong-" + idMonAn).html());
        $("#so-luong-" + idMonAn).html(soLuong + 1);
        $.post("/cong-them-mon-an-nhom", {
            idHoaDon: idHoaDon,
            idMonAn: idMonAn,
            emailNguoiDat: emailNguoiDat,
            soLuong: soLuong
        }, () => capNhatGioHang());
    }

    function xoaMon(idHoaDon, idMonAn, emailNguoiDat) {
        if (!choPhepSuaMonAn(emailNguoiDat)) {
            alert("Bạn không được chỉnh sửa món ăn của người khác");
            return;
        }
        if (confirm("Bạn có thực sự muốn xóa món ăn này không?")) {
            addLoader();
            $.post("/xoa-mon-an-nhom", {
                idHoaDon: idHoaDon,
                idMonAn: idMonAn,
                emailNguoiDat: emailNguoiDat
            }, () => capNhatGioHang());
        }
    }

    function thanhToanGioHang(idHoaDon) {
        clearInterval(timmer);
        $(".thong-tin-thanh-toan").append('<div class="flip-square-loader mx-auto"></div>');
        $.post("/thanh-toan-gio-hang-nhom", {idHoaDon: idHoaDon}, content => {
            $("#gio-hang").css("opacity", "0.5");
            $("#btn-thanh-toan").attr("disabled", "disabled");
            $("#btn-xoa").val("Thành công");
            $("#btn-xoa").removeClass("btn-primary");
            $("#btn-xoa").addClass("btn-success");
            $("#btn-xoa").attr("disabled", "disabled");
            $("#txt-link").attr("disabled", "disabled");
            $("#btn-copy-link").attr("disabled", "disabled");
            $(".mua-mon-an").css("cursor", "not-allowed");
            $(".mua-mon-an").unbind("click");
            $(".flip-square-loader").remove();
            alert("Bạn đã đặt " + content.soLuong + " món với tổng cộng " + content.tongTien + " đồng. Vui lòng chờ đợi trong thời gian chúng tôi giao hàng cho bạn. Cảm ơn đã sử dụng dịch vụ này!" );
        });
    }

    $("#btn-copy-link").click(() => {
        $("#txt-link").select();
        document.execCommand("copy");
    });

    $(".mua-mon-an").click(e => {
        if ($("#gio-hang-nhom").data("id-gio-hang") !== "") {
            addLoader();
            let idMonAn = $(e.target).data("id-mon-an");
            let idGioHang = $("#gio-hang-nhom").data("id-gio-hang");
            $.post("/them-mon-an-vao-gio-hang", {
                idMonAn: idMonAn,
                idGioHang: idGioHang
            }, content => {
                if (content === "redirect") {
                    location.href = "/dang-nhap";
                } else {
                    capNhatGioHang();
                }
            });
        } else {
            alert("Bạn cần tạo giỏ hàng trước khi chọn mua món nào đó");
        }
    });
</script>
<jsp:include page="_shared/user/end-of-file.jsp"/>