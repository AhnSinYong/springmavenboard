<%--
  Created by IntelliJ IDEA.
  User: ahnsy
  Date: 2017-10-04
  Time: 오후 5:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>게시판</title>
</head>
<body>
<table class="tbl_port" style="border: 1px solid #ccc">
    <caption style="background-color: #ccc">목록</caption>
    <colgroup>
        <col width="10%"/>
        <col width="*"/>
        <col width="15%"/>
        <col width="10%"/>
    </colgroup>
    <thead>
    <tr>
        <th scope="col">글번호</th>
        <th scope="col">제목</th>
        <th scope="col">작성자</th>
        <th scope="col">조회수</th>
    </tr>
    </thead>
    <tbody><c:choose> <c:when test="${fn:length(boardSelectList) > 0}"> <c:forEach items="${boardSelectList}"
                                                                                   var="resultList">
        <tr>
            <th><a href="#">${resultList.docnum}</a></th>
            <th><a href="#">${resultList.title}</a></th>
            <td>${resultList.add_usr_nm}</td>
            <td>${resultList.viewcount}</td>
        </tr>
    </c:forEach> </c:when> <c:otherwise>
        <tr>
            <td colspan="3">조회된 결과가 없습니다.</td>
        </tr>
    </c:otherwise> </c:choose></tbody>
</table>
</body>
</html>
