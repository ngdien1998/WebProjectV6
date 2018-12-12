<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <script
            type="text/javascript"
            src="assests/js/jquery-3.3.1.min.js"
    ></script>
    <script type="text/javascript" src="assests/js/parallax.min.js"></script>
    <script type="text/javascript" src="assests/js/bootstrap.min.js"></script>
    <link
            rel="stylesheet"
            type="text/css"
            href="assests/css/bootstrap.min.css"
    />
    <link
            rel="stylesheet"
            type="text/css"
            href="assests/css/style.gioi-thieu.css"
    />
    <link rel="stylesheet" type="text/css" href="assests/css/global.css"/>
    <meta charset="UTF-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Giới thiệu</title>
    <style>
        .footer {
            padding: 64px 0;
            color: #fff;
        }

        .footer .row {
            margin-top: 32px;
        }

        .footer-title {
            text-align: center;
        }

        .send-contact form .form-row {
            padding-bottom: 10px;
        }

        .content-header {
            margin-bottom: 32px;
        }

        .send-contact input[type = submit], .send-contact input[type = button] {
            margin-top: 10px;
        }

        .table, tr {
            border-top: none;
            border-bottom: 1px solid;
        }

        .email-input input[type = text] {
            border-top-left-radius: 24px;
            border-bottom-left-radius: 24px;
        }

        .email-input input[type = submit] {
            border-top-right-radius: 24px;
            border-bottom-right-radius: 24px;
        }

        .footer-content *:not(h1) {
            font-size: 14px;
        }

        .footer-content table td {
            padding-left: 0;
            padding-right: 0;
            border: unset;
        }

        #doi-ngu-nhan-vien {
            background-image: url("/assests/images/pabecue.png");
            background-repeat: no-repeat;
            background-size: cover;
            padding: 96px 0;
            color: #fff;
            text-align: center;
        }

        #nhan-xet-khach-hang {
            background-image: url("/assests/images/paralax2.png");
            background-repeat: no-repeat;
            background-size: cover;
            padding: 96px 0;
            color: #fff;
            text-align: center;
        }

        #footer {
            background-image: url("/assests/images/footer-img.jpg");
            background-repeat: no-repeat;
            background-size: cover;
            padding: 64px 0;
            color: #fff;
            text-align: center;
        }
    </style>
</head>

<body>
<jsp:include page="_shared/user/nav.jsp" flush="true"/>

<nav aria-label="breadcrumb">
    <ol class="breadcrumb">
        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
        <li class="breadcrumb-item"><a href="#">Danh mục</a></li>
        <li class="breadcrumb-item active" aria-current="page">
            Giới thiệu
        </li>
    </ol>
</nav>

<div class="info-content">
    <div class="container">
        <div class="row">
            <div class="col-7">
                <h2 class="font-blonde-script">NHÀ SÁNG LẬP</h2>
                <blockquote class="text-center">
                    <p>
                        Nhà hàng TTD với diện tích hơn 2 nghìn hecta được thành lập bởi Nguyễn Lê Điền.
                        Nguyễn Lê Điền là một sinh viên khoa Công nghệ thông tin của trường Đại học Sư phạm Kỹ thuật Thành phố Hồ Chí Minh.
                        Vào một ngày đẹp trời, khi được hỏi tên nhà hàng là gì, Điền đã trả lời rằng : "Ai biết, muốn đặt gì đặt đi, gì cũng được hết á".
                        Và thế là cái tên nhà hàng TTD đã ra đời.
                    </p>
                    <footer class="blockquote-footer">
                        Sinh viên <cite title="Source Title">Phạm Gia Thịnh</cite> cho biết.
                    </footer>
                </blockquote>
            </div>
            <div class="col-5">
                <picture>
                    <img
                            src="assests/images/nhahang-gioithieu.jpg"
                            height="300px"
                            width="450px"
                            class="rounded"
                    />
                </picture>
            </div>
        </div>
        <div class="spaceeeee"></div>
        <div class="row">
            <div class="col-6">
                <picture>
                    <img
                            src="assests/images/introduction_food.jpg"
                            height="350px"
                            width="500px"
                            class="rounded"
                    />
                </picture>
            </div>
            <div class="col-6">
                <h2 class="font-blonde-script">LỊCH SỬ NHÀ HÀNG</h2>
                <i
                >Theo Kỷ lục Thế giới Guinness, nhà hàng Botín do đầu bếp Jean Botín và vợ khai trương vào năm 1725, nổi tiếng là nhà hàng lâu đời nhất thế giới. Bên trong vẫn còn giữ lại nội thất của thế kỷ 18, ngay cả bếp để nấu cũng vẫn sử dụng chiếc bếp từ khi khai trương.

                    Sau khi vợ chồng Botín qua đời, do họ không có con nên nhà hàng này được Nguyễn Trường Tráng kế thừa và cùng 2 người bạn đổi tên thành TTD. </i
                >

                <%--<i--%>
                <%-->Excepteur sit occaecat cupidatan is proident, one sunt in culpa--%>
                    <%--qui officia deserunt mollit anim Ut Excepteur sit occaecat--%>
                    <%--cupidatan is proident, one sunt in culpa qui minim veniam--%>
                    <%--laboreua.</i--%>
                <%-->--%>
                <%--<i--%>
                <%-->Consequuntur magni dolores eos ratione voluptatem nesciunt natus--%>
                    <%--error voluptatem accusantium tempo doloremque. Excepteur sit--%>
                    <%--occaecat cupidatan is proident.</i--%>
                <%-->--%>
            </div>
        </div>
    </div>
</div>
<br>

<jsp:include page="_shared/user/footer.jsp" flush="true"/>