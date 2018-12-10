<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<div id="footer">
    <div class="container-fluid">
        <div class="footer-title">
            <h1 class="font-blonde-script">Liên hệ</h1>
            <img src="assests/images/logo.png" height="100" width="100"/>
            <p>
                <i>Lorem Ipsum is simply dummy text of the printing and typesetting industry</i>
            </p>
            <form action="" method="post" class="email-input">
                <div class="row">
                    <div class="input-group col-6 offset-3">
                        <input type="text" class="form-control" placeholder="Nhập email của bạn"
                               aria-label="Recipient's username"
                               aria-describedby="button-addon2">
                        <div class="input-group-append">
                            <input class="btn btn-info" type="submit" id="button-addon2" value="Đăng ký"/>
                        </div>
                    </div>
                </div>
            </form>
        </div>
        <div style="margin-top: 64px; text-align: left;" class="row">
            <div class="col-md-4 col-sm-6 col-12 footer-content">
                <h1 class="font-blonde-script content-header">Thời gian</h1>
                <table class="table">
                    <tr>
                        <td style="padding-top: 0;">Thứ 2</td>
                        <td style="padding-top: 0;" align="right">8:00 - 22:00</td>
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
                <h1 class="font-blonde-script content-header">Thông tin liên hệ</h1>
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
                <span class="social"></span>
            </div>
            <div class="col-md-4 col-sm-6 col-12 send-contact footer-content">
                <h1 class="font-blonde-script content-header">Gửi liên hệ</h1>
                <form action="#" method="post">
                    <div class="form-row">
                        <div class="col-6">
                            <input type="text" class="form-control" placeholder="Họ tên"/>
                        </div>
                        <div class="col-6">
                            <input type="text" class="form-control" placeholder="email"/>
                        </div>
                    </div>
                    <textarea class="form-control" rows="8" placeholder="Nội dung liên hệ"></textarea>
                    <input type="submit" value="Gửi" class="btn btn-light"/>
                    <input type="button" value="Hủy" class="btn btn-light"/>
                </form>
            </div>
        </div>
    </div>
</div>
</body>

</html>
