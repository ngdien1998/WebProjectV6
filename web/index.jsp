<%@ page import="quanlynhahang.models.datamodels.NguoiDung" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
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
    session.setAttribute("nguoiDungHienTai", nguoiDung);
%>
<c:redirect url="/admin/bai-viet"/>