<%@ page import="quanlynhahang.models.datamodels.NguoiDung" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page import="quanlynhahang.common.Consts" %>
<%@ page import="quanlynhahang.models.viewmodels.UserDbConnect" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    NguoiDung nguoiDung = null;
    try {
        nguoiDung = new NguoiDung();
        nguoiDung.setEmail("ngdien1998@mail.com");
        nguoiDung.setHoDem("Nguyễn Lê");
        nguoiDung.setTen("Điền");
        nguoiDung.setMatKhau("1234");
        nguoiDung.setAvatar(null);
        nguoiDung.setDienThoai("0967397916");
        nguoiDung.setDiaChi("Mỏ Cày Nam, Bến Tre");
        nguoiDung.setNgaySinh(new Date(new SimpleDateFormat("dd/MM/yyyy").parse("22/11/1998").getTime()));
        nguoiDung.setKichHoat(true);
        nguoiDung.setChoPhep(true);
        nguoiDung.setQuanTriVien(true);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    session.setAttribute(Consts.WEBSITE_LOGIN, nguoiDung);

    UserDbConnect userDbConnect = new UserDbConnect();
    userDbConnect.setUsername(nguoiDung.getEmail());
    userDbConnect.setPassword(nguoiDung.getMatKhau());
    userDbConnect.setAdmin(nguoiDung.isQuanTriVien());
    session.setAttribute(Consts.USER_DB_CONNECT, userDbConnect);
%>
<c:redirect url="/admin/ket-noi-database" />