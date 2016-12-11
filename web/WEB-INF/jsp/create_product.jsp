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
            <form:form name="create_product" action="${pageContext.request.contextPath}/create_product"
                       method="post" modelAttribute="productForm">
                <div class="register-top-grid">
                    <h3>TẠO SẢN PHẨM MỚI</h3>
                    <c:if test="${not empty message }">
                        <div>${message}</div>
                    </c:if>

                    <div>
                        <span>Mã sản phẩm<label>*</label></span>
                        <c:if test="${not empty productForm.code}">
                            <form:hidden path="code"/>${productForm.code}
                        </c:if>
                        <c:if test="${empty productForm.code}">
                            <form:input path="code"/>
                        </c:if>
                        <span><form:errors path="code"/></span>
                    </div>
                    <div>
                        <span>Tên sản phẩm<label>*</label></span>
                        <c:if test="${not empty productForm.name}">
                            <form:input path="name" placeholder="${productForm.name}"/>
                        </c:if>
                        <c:if test="${empty productForm.name}">
                            <form:input path="name"/>
                        </c:if>
                        <span><form:errors path="name"/></span>
                    </div>
                    <div>
                        <span>Giá sản phẩm<label>*</label></span>
                        <c:if test="${not empty productForm.priceTag}">
                            <form:input path="priceTag" placeholder="${productForm.priceTag}"/>
                        </c:if>
                        <c:if test="${empty productForm.priceTag}">
                            <form:input path="priceTag"/>
                        </c:if>
                        <span><form:errors path="priceTag"/></span>
                    </div>
                    <div>
                        <span>Mô tả sản phẩm<label>*</label></span>
                        <c:if test="${not empty productForm.description}">
                            <form:textarea path="description" rows="2" cols="30" placeholder="${productForm.description}"/>
                        </c:if>
                        <c:if test="${empty productForm.description}">
                            <form:textarea path="description" rows="2" cols="30"/>
                        </c:if>
                    </div>
                    <div>
                        <span>Hình ảnh sản phẩm</span>
                        <img src="${productForm.uri}" width="200" height="200"/>
                    </div>
                    <div>
                        <span>URI sản phẩm</span>
                        <c:if test="${not empty productForm.uri}">
                            <form:input path="uri" placeholder="${productForm.uri}"/>
                        </c:if>
                        <c:if test="${empty productForm.uri}">
                            <form:input path="uri"/>
                        </c:if>
                    </div>
                    <div class="register-but">
                        <span>Tải ảnh sản phẩm lên</span>
                        <%--<form:input id="productImage" path="productImage" type="file" cssClass="hidden"/>--%>
                        <%--<form:label path="productImage" for="productImage">Chọn ảnh</form:label>--%>
                        <a href="${pageContext.request.contextPath}/intro">
                            <label>Chọn ảnh ( chức năng đang thử nghiệm )</label>
                        </a>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
                <div class="register-but">
                    <input type="submit" value="Tạo sản phẩm mới"/>
                    <input type="reset" value="Reset"/>
                    <div class="clearfix"></div>
                </div>
            </form:form>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
