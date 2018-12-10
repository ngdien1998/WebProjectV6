package quanlynhahang.controllers.nguoidung;

import quanlynhahang.common.Consts;
import quanlynhahang.common.DbAccess;
import quanlynhahang.models.businessmodels.NguoiDungService;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.Random;

@WebServlet(name = "QuenMatKhauServlet", urlPatterns = {"/quen-mat-khau"})
public class QuenMatKhauServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String newPass = generatePassword();

            String emailTo = request.getParameter("txtEmail");
            String emailFrom = "ngdien1998@gmail.com";
            String pass = "Continuum10";
            String subject = "Khôi phục mật khẩu người dùng";
            String content = "Mật khẩu mới của bạn là '" + newPass + "'. Hãy đổi mật khẩu sau khi đăng nhập lại.";

            NguoiDungService service = new NguoiDungService(DbAccess.getValue(request));
            service.suaMatKhaunguoiDung(emailTo, newPass);

            sendEmail(emailFrom, pass, emailTo, subject, content);
            HttpSession session = request.getSession();
            session.setAttribute(Consts.FORGOT_PASSWORD_MSG, "Vui lòng kiểm tra email để lấy lại mật khẩu");
            response.sendRedirect("/dang-nhap");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().print(e.toString());
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/quen-mk.jsp");
        dispatcher.forward(request, response);
    }

    private String generatePassword() throws NoSuchAlgorithmException {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i <= 10; i++) {
            text.append((char) getRandomNumberInRange(32, 126));
        }
        return md5Hash(text.toString()).substring(0, 10);
    }

    private int getRandomNumberInRange(int min, int max) throws IllegalArgumentException {
        if (min >= max) {
            throw new IllegalArgumentException("Max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    private String md5Hash(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] array = md.digest(text.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : array) {
            sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);
        }
        return sb.toString();
    }

    private boolean sendEmail(String from, String pass, String to, String subject, String content) {
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(props, new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, pass);
                }
            });

            MimeMessage message = new MimeMessage(session);
            message.setHeader("Content-Type", "text/plain; charset=UTF-8");
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject, "UTF-8");
            message.setText(content, "UTF-8");
            Transport.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
