<%@ page contentType="text/html;charset=UTF-8" %>

<div class="footer container-fluid" style="background-color: #fff;">
    <div class="footer-title" style="text-align: center;">
        <h1 class="font-blonde-script" align="center">Liên hệ</h1>
        <img src="assests/images/logo.png" height="100" width="100" alt="logo"/>
        <p align="center"><i>Lorem Ipsum is simply dummy text of the printing and typesetting industry</i></p>
        <form action="" method="post" class="email-input">
            <div class="row justify-content-center">
                <div class="input-group col-9">
                    <input type="text" class="form-control file-upload-info" placeholder="Nhập email của bạn">
                    <span class="input-group-append">
                          <input class="btn btn-info" type="submit" value="Đăng ký"/>
                        </span>
                </div>
            </div>
        </form>
    </div>
    <div class="row" style="margin-top: 32px;">
        <div class="col-md-4 col-sm-6 col-12 footer-content" style="padding-right: 32px;">
            <h2 class="content-header">Thời gian</h2>
            <table class="table">
                <tr>
                    <td>Thứ 2</td>
                    <td align="right">8:00 - 22:00</td>
                </tr>
                <tr>
                    <td>Thứ 3</td>
                    <td align="right">8:00 - 22:00</td>
                </tr>
                <tr>
                    <td>Thứ 4</td>
                    <td align="right">8:00 - 22:00</td>
                </tr>
                <tr>
                    <td>Thứ 6</td>
                    <td align="right">8:00 - 22:00</td>
                </tr>
                <tr>
                    <td>Thứ 7</td>
                    <td align="right">8:00 - 22:00</td>
                </tr>
            </table>
        </div>
        <div class="col-md-4 col-sm-6 col-12 footer-content">
            <h2 class="content-header">Thông tin liên hệ</h2>
            <p>
                <b>Địa chỉ:</b>
                75/6 Trương Văn Hải, Tăng Nhơn Phú B, Q9
            </p>
            <p>
                <b>Email:</b>
                nhahang@gmail.com
            </p>
            <p>
                <b>Hot line:</b>
                (098) 765 9898
            </p>
            <span class="social">
                        <a></a>
                    </span>
        </div>
        <div class="col-md-4 col-sm-6 col-12 send-contact footer-content">
            <h2 class="content-header">Gửi liên hệ</h2>
            <form action="#" method="post">
                <div class="form-row">
                    <div class="col-6">
                        <input type="text" class="form-control" placeholder="Họ và tên"/>
                    </div>
                    <div class="col-6">
                        <input type="text" class="form-control" placeholder="Email"/>
                    </div>
                </div>
                <textarea style="margin: 8px 0;" class="form-control" rows="8"
                        placeholder="Nội dung liên hệ"></textarea>
                <input type="submit" value="Gửi" class="btn btn-primary"/>
                <input type="button" value="Hủy" class="btn btn-primary"/>
            </form>
        </div>
    </div>
</div>

<!-- plugins:js -->
<script src="<%= request.getContextPath() + "/" %>../../assests/node_modules/jquery/dist/jquery.min.js"></script>
<script src="<%= request.getContextPath() + "/" %>../../assests/node_modules/popper.js/dist/umd/popper.min.js"></script>
<script src="<%= request.getContextPath() + "/" %>../../assests/node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
<script src="<%= request.getContextPath() + "/" %>../../assests/node_modules/perfect-scrollbar/dist/perfect-scrollbar.min.js"></script>

<script src="<%= request.getContextPath() %>/assests/node_modules/jquery-toast-plugin/dist/jquery.toast.min.js"></script>

<!-- endinject -->
<!-- Plugin js for this page-->
<script src="<%= request.getContextPath() + "/" %>../../assests/node_modules/jquery-sparkline/jquery.sparkline.min.js"></script>
<!-- End plugin js for this page-->
<!-- inject:js -->
<script src="<%= request.getContextPath() + "/" %>../../assests/js/off-canvas.js"></script>
<script src="<%= request.getContextPath() + "/" %>../../assests/js/hoverable-collapse.js"></script>
<script src="<%= request.getContextPath() + "/" %>../../assests/js/misc.js"></script>
<script src="<%= request.getContextPath() + "/" %>../../assests/js/settings.js"></script>
<script src="<%= request.getContextPath() + "/" %>../../assests/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<script src="<%= request.getContextPath() + "/" %>../../assests/js/todolist.js"></script>
<script src="<%= request.getContextPath() + "/" %>../../assests/js/dashboard.js"></script>
<!-- End custom js for this page-->
<script src="<%= request.getContextPath() %>/assests/js/toastDemo.js"></script>
<script src="<%= request.getContextPath() %>/assests/node_modules/sweetalert/dist/sweetalert.min.js"></script>
<script src="<%= request.getContextPath() %>/assests/node_modules/jquery.avgrund/jquery.avgrund.min.js"></script>
<script src="<%= request.getContextPath() %>/assests/js/alerts.js"></script>
<script src="<%= request.getContextPath() %>/assests/js/avgrund.js"></script>