<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
session.setAttribute("loginedUserEmail", "ngdien1998@gmail.com");
%>
<c:redirect url="/admin/phan-quyen" />