<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="list" type="java.util.List" required="true"%>


<c:forEach items="${list}" var="item">
    <li>${item}</li>
</c:forEach>