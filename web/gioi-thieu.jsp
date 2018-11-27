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
                <h2 class="font-blonde-script">FOUNDER</h2>
                <blockquote class="text-center">
                    <p>
                        Pellentesque mi purus, eleifend sedt commodo vel, sagittis elts
                        vesti ulum dui sagittis mlste sagittis elts. Exercitation photo
                        booth that is end stumptown tote bag Banksy, elit small batch
                        freegan sed craft a beer elit seitan exercitation, photo booth
                        et kale chips hillwave deep laborum mlste sagittis sunt culpa
                        only oficia Excepteur sit occaecat cupidatan is proident, one
                        sunt in culpa qui officia deserunt mollit anim Ut Excepteur sit
                        occaecat cupidatan is proident end stumptown tote bag Banksy.
                    </p>
                    <footer class="blockquote-footer">
                        Someone famous in <cite title="Source Title">Source Title</cite>
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
                <h2 class="font-blonde-script">OUR HISTORY</h2>
                <i
                >Excepteur sit occaecat cupidatan is proident, one sunt in culpa
                    qui officia deserunt mollit anim Ut minim veniam laboreua dolore
                    magna aliqua. Consequuntur magni dolores eos ratione voluptatem
                    nesciunt natus error voluptatem accusantium tempo doloremque
                    Excepteur sit occaecat cupidatan is proident, one sunt in
                    culpa.</i
                >

                <i
                >Excepteur sit occaecat cupidatan is proident, one sunt in culpa
                    qui officia deserunt mollit anim Ut Excepteur sit occaecat
                    cupidatan is proident, one sunt in culpa qui minim veniam
                    laboreua.</i
                >
                <i
                >Consequuntur magni dolores eos ratione voluptatem nesciunt natus
                    error voluptatem accusantium tempo doloremque. Excepteur sit
                    occaecat cupidatan is proident.</i
                >
            </div>
        </div>
    </div>
</div>

<jsp:include page="_shared/user/footer.jsp" flush="true"/>
