<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 11/27/16
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Organic Fresh Shop</title>
</head>
<body>
<jsp:include page="header.jsp"/>

<div class="single_top">
    <div class="container">
        <div class="register">
            <form:form name="account" action="/register" method="post" modelAttribute="account">
                <div class="register-top-grid">
                    <h3>THÔNG TIN CÁ NHÂN</h3>
                    <div>
                        <span>Tên tài khoản<label>*</label></span>
                        <form:input path="name"/>
                    </div>
                    <div>
                        <span>Số điện thoại<label>*</label></span>
                        <form:input path="phone"/>
                    </div>
                    <div>
                        <span>Địa chỉ<label>*</label></span>
                        <form:input path="address"/>
                    </div>
                    <div>
                        <span>Email<label>*</label></span>
                        <form:input path="email"/>
                    </div>
                    <div class="clearfix"></div>
                    <a class="news-letter" href="/intro">
                        <label class="checkbox"><input type="checkbox" name="checkbox" checked=""><i> </i>Đăng ký để
                            nhận thông tin mới nhất qua email</label>
                    </a>
                </div>
                <div class="register-bottom-grid">
                    <h3>THÔNG TIN ĐĂNG NHẬP</h3>
                    <div>
                        <span>User name<label>*</label></span>
                        <form:input path="username"/>
                    </div>
                    <div>
                        <span>Mật khẩu<label>*</label></span>
                        <form:input path="password"/>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="register-but">
                        <input type="submit" value="Hoàn thành đăng ký"/>
                        <div class="clearfix"></div>
                </div>
            </form:form>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>
