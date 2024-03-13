<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header>
    <%@include file="/WEB-INF/PartialView/linkOpenSans.jsp"%>
    <div class="container" id="header">
        <div class="center-title-block">
            <div class="center-position">

                <div class="name-information-block">
                    <span>${requestScope.lastName}</span>
                    <span>${requestScope.firstName}</span>
                    <span>${requestScope.patronymic}</span>
                </div>
            </div>
        </div>
        <div class="right-block">

            <div class="btn-create-account btn-header">
                <form action="${pageContext.request.contextPath}/create_account">
                    <button type="submit">Создать счёт в банке</button>
                </form>
            </div>

            <div class="btn-logout btn-header">
                <form action="${pageContext.request.contextPath}/logout" method="post">
                    <button type="submit">Выйти</button>
                </form>

            </div>

        </div>
    </div>
</header>