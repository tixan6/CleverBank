<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>

<html>
<head>
    <title>Личный кабинет</title>
    <%@include file="/WEB-INF/PartialView/linkOpenSans.jsp"%>
</head>

<body>

<%@include file="../PartialView/header.jsp"%>


<div class="container">
    <div class="account-list">

        <c:if test="${not empty requestScope.accounts}">
            <div class="list-account scroll">
                <table>

                    <tr>
                        <th>
                            <p>Наименования банка</p>
                        </th>

                        <th>
                            <p>Номер счёта</p>
                        </th>

                        <th>
                            <p>Дата создания счёта</p>
                        </th>

                        <th>
                            <p>Панель действий</p>
                        </th>
                    </tr>
                    <c:forEach var="item" items="${requestScope.accounts}">
                        <tr>
                            <th>
                                <div class="bankName">
                                    <p>${item.getBank().getName()}</p>
                                </div>
                            </th>

                            <th>
                                <div class="accountName">
                                    <p>HR212323DFJSFDH3U312HJ</p>
                                </div>
                            </th>

                            <th>
                                <div class="date">
                                    <p>${item.getDate_foundation()}</p>
                                </div>
                            </th>

                            <th>
                                <div class="panel-buttons">
                                    <form method="post" action="${pageContext.request.contextPath}/index">
                                        <button name="idAccount" value="${item.id}" id="idAccount" type="submit">Удалить счёт</button>
                                    </form>

                                    <form method="post"  action="${pageContext.request.contextPath}/account">
                                        <button name="idAccount" value="${item.id}" type="submit">Перейти</button>
                                    </form>

                                </div>
                            </th>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </c:if>

        <c:if test="${empty requestScope.accounts}">
            <div class="list-account">
                <table>
                        <%--Если нет счёта--%>
                    <div class="error-empty">
                        <h1>У вас нет счетов в банках</h1>
                        <div class="offer">
                            <p>Откройте счёт в банке</p>
                        </div>
                    </div>

                </table>
            </div>
        </c:if>




            <c:if test="${not empty requestScope.new_account}">
                <script type="text/javascript">
                    alert("${requestScope.new_account}");
                </script>
            </c:if>

    </div>
</div>

</body>

<%@include file="/WEB-INF/PartialView/footer.jsp"%>

<style>
    .panel-buttons {
        display: flex;
        justify-content: space-evenly;
    }
    .scroll
    {
        overflow-y: scroll;
        height: 50%;
        margin-top: 50px;
    }

    th div p
    {
        margin: 0;
        padding: 0;
    }
    table {
        width: 100%;
        background: #545454;
        color: #c9c9c9;
        border-spacing: 1px;
    }
    td, th {
        background: #252525;
        padding: 5px;
    }

    .account-list
    {
        text-align-last: center;
    }
    header
    {
        background: #262626;
        width: 100%;
        height: 30px;
        margin: 0 auto;
        padding: 0;
    }
    .container
    {
        padding: 0;
        margin: 0 auto;
        width: 900px;
    }
    .register-block
    {
        text-align-last: center;
        margin-top: 30px;
        border: solid 1px #4d4d4d;
        border-radius: 10px;
        width: 500px;
    }
    .title-reg-block
    {
        text-align-last: center;
    }
    .register-account-bank
    {
        text-align: -webkit-center;
    }
    span
    {
        color: #bdbdbd;
    }
    body
    {
        margin: 0 auto;
        padding: 0;
    }
    .name-information-block
    {
        padding: 5px;
    }
    #header{
        display: flex;
        justify-content: space-between;
    }
    .right-block
    {
        display: flex;
        justify-content: space-between;
    }
    .btn-header
    {
        margin: 5px;
    }
</style>
</html>
