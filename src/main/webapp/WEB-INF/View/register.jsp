<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%@include file="/WEB-INF/PartialView/linkOpenSans.jsp"%>
</head>
<body>
    <div class="register-container">
        <div class="title">
            <h1>Регистрация нового пользователя</h1>
        </div>

        <div class="main">
            <form action="${pageContext.request.contextPath}/register" method="post">
                <div class="center">

                    <div class="fio mrg">
                        <label for="name">Имя
                            <input type="text" name="name" id="name">
                        </label>
                        <label for="surname">Фамилия
                            <input type="text" name="surname" id="surname">
                        </label>
                        <label for="patronymic">Отчество
                            <input type="text" name="patronymic" id="patronymic">
                        </label>
                    </div>

                    <hr>

                    <div class="second-date mrg">
                        <label for="birthday">Дата рождения
                            <input type="date" name="birthday" id="birthday">
                        </label>
                        <label for="age">Возраст
                            <input type="number" min="0" max="300" name="age" id="age">
                        </label>
                        <label for="passport">Паспорт
                            <input type="text" name="passport" id="passport">
                        </label>

                        <input name="gender" type="radio" value="MALE"> Мужской
                        <input name="gender" type="radio" value="FEMALE"> Женский
                    </div>

                    <hr>

                    <div class="web-date mrg">
                        <label for="phone">Номер телефона
                            <input type="text" name="phone" id="phone">
                        </label>
                        <label for="email">Почта
                            <input type="email" name="email" id="email">
                        </label>
                        <label for="password">Пароль
                            <input type="password" name="password" id="password">
                        </label>
                    </div>


                </div>

                <div class="btn">
                    <button type="submit">Зарегистрироваться</button>
                    <a href="${pageContext.request.contextPath}/login">
                        <button type="button">Логин</button>
                    </a>
                </div>

            </form>

        <div class="error">
            <div class="block-error">
                <c:if test="${not empty requestScope.error}">
                    <c:forEach var="error" items="${requestScope.error}">
                        <span style="color: red;">
                            ${error}<br>
                        </span>
                    </c:forEach>
                </c:if>
            </div>
        </div>


        </div>
    </div>

</body>

    <style type="text/css">
        .mrg
        {
            margin: 10px;
        }
        .register-container{
            width: 800px;
            margin: 0 auto;
        }
        .center
        {
            display: table-caption;
        }
        .title
        {
            display: flex;
            justify-content: center;
        }
        .btn
        {
            display: flex;
            justify-content: center;
            padding-top: 20px;
        }
        .main
        {
            text-align: -webkit-center;
        }
        .btn button
        {
            margin-left: 10px;
        }
    </style>
</html>
