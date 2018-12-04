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
                    <div class="row">
                        <div class="col-7 card-title">Đơn hàng theo nhóm</div>
                        <div class="col-5" id="xoa-don-hang" style="text-align: right;">
                            <c:if test="${requestScope.isInGroup}">
                                <div class="badge badge-danger" id="ban-xoa-don-hang"
                                        style="cursor: pointer;">Xóa đơn hàng
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <div class="card-description" id="shared-link">
                        <c:choose>
                            <c:when test="${requestScope.isInGroup}">
                                <div class="badge badge-success"
                                        style="width: 100%;">Đơn hàng tạo bởi Nguyễn Lê Điền - 0 phần/0 người
                                </div>
                                <div class="input-group form-group" style="margin-top: 8px;">
                                    <input type="text" class="form-control" id="txt-link"
                                            value="${requestScope["javax.servlet.forward.request_uri"]}?id=${requestScope.hoaDon.idHoaDonNhom}">
                                    <div class="input-group-append">
                                        <input class="btn btn-info" type="submit" value="Copy link" id="btn-copy-link"/>
                                    </div>
                                </div>
                                <script type="text/javascript">
                                    <%--setInterval(() => {--%>
                                        <%--$.post("/cap-nhap-trang-thai-gio-hang", {--%>
                                            <%--idGioHang: ${requestScope.hoaDon.idHoaDonNhom}--%>
                                        <%--}, content => {--%>
                                            <%--for (let i = 0; i < content.length; i++) {--%>
                                                <%--let html = '';--%>
                                            <%--}--%>
                                        <%--});--%>
                                    <%--}, 30000);--%>
                                </script>
                            </c:when>
                            <c:otherwise>
                                <div class="badge badge-success" id="btn-tao-hoa-don"
                                        style="width: 100%; cursor: pointer;" onclick="taoGioHang()">Tạo giỏ hàng
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="tinh-trang-gio-hang">
                        <c:if test="${requestScope.isInGroup}">
                            <c:choose>
                                <c:when test="${requestScope.hoaDon.monAnNhoms.size() > 0}">
                                    <h4>Tình trạng giỏ hàng</h4>
                                    <c:forEach var="monAn" items="${requestScope.hoaDon.monAnNhoms}">
                                        <div id="item-gio-hang-${monAn.idMonAn}">
                                            <small data-id="${monAn.emailNguoiDat}" class="nguoi-dat"><b>${monAn.tenNguoiDat}</b> đã đặt</small>
                                            <div class="alert alert-success" data-id="${monAn.idMonAn}">
                                            <span class="btn-xoa" data-id-mon-an="${monAn.idMonAn}" data-id-hoa-don="${requestScope.hoaDon.idHoaDonNhom}" data-email="${monAn.emailNguoiDat}">x</span>
                                                <span class="btn-cong" data-id-mon-an="${monAn.idMonAn}" data-id-hoa-don="${requestScope.hoaDon.idHoaDonNhom}" data-email="${monAn.emailNguoiDat}">+</span>
                                                <span id="so-luong-${monAn.idMonAn}">${monAn.soLuong}</span>
                                                <span class="btn-tru" data-id-mon-an="${monAn.idMonAn}" data-id-hoa-don="${requestScope.hoaDon.idHoaDonNhom}" data-email="${monAn.emailNguoiDat}">-</span>
                                                <span class="ten-mon-an"
                                                        style="font-weight: bold;">${monAn.tenMonAn}đ</span>
                                                <span class="gia"
                                                        style="color: #939b9d; font-size: small;">${monAn.gia}</span>
                                            </div>
                                        </div>
                                    </c:forEach>
                                    <div class="thong-tin-thanh-toan">
                                        <table class="table tbl-thanh-toan">
                                            <tr>
                                                <td>Cộng</td>
                                                <td class="text-right">
                                                    <div class="badge badge-outline-warning">100 000 đồng</div>
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
                                                    <div class="badge badge-outline-info">107 000 đồng</div>
                                                </td>
                                            </tr>
                                        </table>
                                        <div class="row justify-content-center" style="margin-top: 16px;">
                                            <a href="#" class="btn btn-primary btn-rounded"
                                                    style="width: 100%;">Thanh toán</a>
                                        </div>
                                    </div>
                                </c:when>
                                <c:otherwise>
                                    <h4>Tình trạng giỏ hàng</h4>
                                    <div class="alert-warning alert">Giỏ hàng chưa có món ăn nào. Hãy chia sẻ link để mọi người cùng đặt món</div>
                                </c:otherwise>
                            </c:choose>
                        </c:if>
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
                                        <div class="row" style="padding-top: 8px;">
                                            <div class="col-8"
                                                    style="font-size: 16px;">${monAn.tenMonAn} - ${monAn.gia + monAn.gia * monAn.khuyenMai}</div>
                                            <div class="col-4" style="text-align: right;">
                                                <div class="badge badge-primary" style="cursor: pointer;">Mua</div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="tab-pane fade" id="thuc-an-nhanh" role="tabpanel"
                                aria-labelledby="tab-thuc-an-nhanh">
                            <c:forEach var="monAn" items="${requestScope.monAnNhanhs}">
                                <div class="food col-md-4 col-sm-6 col-12">
                                    <a href="/chi-tiet-mon-an?id=${monAn.idMonAn}">
                                        <img src="assests/images/banh-xeo.jpg" alt=""/>
                                        <div class="row" style="padding-top: 8px;">
                                            <div class="col-8"
                                                    style="font-size: 16px;">${monAn.tenMonAn} - ${monAn.gia + monAn.gia * monAn.khuyenMai}</div>
                                            <div class="col-4" style="text-align: right;">
                                                <div class="badge badge-primary" style="cursor: pointer;">Mua</div>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>
                        </div>
                        <div class="tab-pane fade" id="do-uong" role="tabpanel" aria-labelledby="tab-do-uong">
                            <c:forEach var="monAn" items="${requestScope.doUongs}">
                                <div class="food col-md-4 col-sm-6 col-12">
                                    <a href="/chi-tiet-mon-an?id=${monAn.idMonAn}">
                                        <img src="assests/images/banh-xeo.jpg" alt=""/>
                                        <div class="row" style="padding-top: 8px;">
                                            <div class="col-8"
                                                    style="font-size: 16px;">${monAn.tenMonAn} - ${monAn.gia + monAn.gia * monAn.khuyenMai}</div>
                                            <div class="col-4" style="text-align: right;">
                                                <div class="badge badge-primary" style="cursor: pointer;">Mua</div>
                                            </div>
                                        </div>
                                    </a>
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
    function botMon(idHoaDon, idMonAn, emailNguoiDat) {
        let soLuong = parseInt($("#so-luong-" + idMonAn).html());
        if (soLuong > 1) {
            $("#so-luong-" + idMonAn).html(soLuong - 1);
            $.post("/cong-them-mon-an-nhom", {
                idHoaDon: idHoaDon,
                idMonAn: idMonAn,
                emailNguoiDat: emailNguoiDat
            }, () =>  content => console.log(content));
        }
    }

    function themMon(idHoaDon, idMonAn, emailNguoiDat) {
        let soLuong = parseInt($("#so-luong-" + idMonAn).html());
        $("#so-luong-" + idMonAn).html(soLuong + 1);
        $.post("/cong-them-mon-an-nhom", {
            idHoaDon: idHoaDon,
            idMonAn: idMonAn,
            emailNguoiDat: emailNguoiDat
        }, content => console.log(content));
    }

    function xoaMon(idHoaDon, idMonAn, emailNguoiDat) {
        $.post("/xoa-mon-an-nhom", {
            idHoaDon: idHoaDon,
            idMonAn: idMonAn,
            emailNguoiDat: emailNguoiDat
        }, () => $("#item-gio-hang-" + idMonAn).remove());
    }

    $(".btn-xoa").click(e => {
        let idHoaDon = $(e.target).data("id-hoa-don");
        let idMonAn = $(e.target).data("id-mon-an");
        let emailNguoiDat = $(e.target).data("email");
        xoaMon(idHoaDon, idMonAn, emailNguoiDat);
    });

    $(".btn-cong").click(e => {
        let idHoaDon = $(e.target).data("id-hoa-don");
        let idMonAn = $(e.target).data("id-mon-an");
        let emailNguoiDat = $(e.target).data("email");
        themMon(idHoaDon, idMonAn, emailNguoiDat);
    });

    $(".btn-tru").click(e => {
        let idHoaDon = $(e.target).data("id-hoa-don");
        let idMonAn = $(e.target).data("id-mon-an");
        let emailNguoiDat = $(e.target).data("email");
        botMon(idHoaDon, idMonAn, emailNguoiDat);
    });

    $("#btn-copy-link").click(() => {
        $("#txt-link").select();
        document.execCommand("copy");
    });

    function taoGioHang() {
        $("#shared-link").html(
            '<div style="text-align: center; margin-bottom: 16px;">Đang tạo giỏ hàng</div>' +
            '<div class="bar-loader">\n' +
            '<span></span>\n' +
            '<span></span>\n' +
            '<span></span>\n' +
            '<span></span>\n' +
            '</div>\n'
        );
        $.post("/tao-hoa-don-nhom", content => {
            $("#shared-link").html(
                '<div class="badge badge-success" style="width: 100%;">Giỏ hàng tạo bởi ' + content.tenNguoiTao + ' - 0 phần/0 người</div>\n' +
                '<div class="input-group form-group" style="margin-top: 8px;">\n' +
                '<input type="text" class="form-control" id="txt-link" value="${requestScope["javax.servlet.forward.request_uri"]}?id=' + content.idHoaDon + '">\n' +
                '<div class="input-group-append">\n' +
                '<input class="btn btn-info" type="submit" value="Copy link" id="btn-copy-link"/>\n' +
                '</div>\n' +
                '</div>' +
                '<h4>Tình trạng giỏ hàng</h4>\n' +
                '<div class="alert-warning alert">Giỏ hàng chưa có món ăn nào. Hãy chia sẻ link để mọi người cùng đặt món</div>'
            );
            $("#xoa-don-hang").html('<div class="badge badge-danger" id="ban-xoa-don-hang" style="cursor: pointer;" onclick="xoaDonHang(' + content.idHoaDon + ')">Xóa đơn hàng</div>');
        });
    }

    function xoaDonHang(idDonHang) {
        $("#shared-link").html(
            '<div style="text-align: center; margin-bottom: 16px;">Đang xóa giỏ hàng</div>' +
            '<div class="bar-loader">\n' +
            '<span></span>\n' +
            '<span></span>\n' +
            '<span></span>\n' +
            '<span></span>\n' +
            '</div>\n'
        );
        $.post("/xoa-gio-hang-nhom", {idGioHang: idDonHang}, () => {
            $("#shared-link").html('<div class="badge badge-success" id="btn-tao-hoa-don" style="width: 100%; cursor: pointer;" onclick="taoGioHang()">Tạo giỏ hàng</div>');
            $("#xoa-don-hang").html("");
        });
    }
</script>
<jsp:include page="_shared/user/end-of-file.jsp"/>