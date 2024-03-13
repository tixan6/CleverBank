<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>Авторизация</title>
</head>
<body>
    <div class="login-container">
        <div class="title">
            <h1>Авторизация</h1>
        </div>
        <div class="login">
            <div class="blocks-inputs">
                <form action="${pageContext.request.contextPath}/login" method="post">
                    <label for="email"><span>Почта</span>
                        <input type="email" id="email" required>
                    </label><br>

                    <label for="password"><span>Пароль</span>
                        <input type="password" id="password" required>
                    </label><br>

                    <div class="buttons">
                        <div class="btn-loggin">
                            <button type="submit">Логин</button>
                        </div>

                        <div class="btn-register">
                            <a href="${pageContext.request.contextPath}/register">
                                <button type="button">Регистрация</button>
                            </a>
                        </div>
                    </div>
                </form>
                <div class="error">
                    <c:if test="${param.error != null}" >
                        <h4>Логин или пароль неверен!</h4>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</body>

    <style>
        .login-container
        {
            width: 900px;
            margin: 0 auto;
            padding: 0;
            text-align-last: center;
        }
        .title
        {
            padding-bottom: 10px;
        }
        label
        {
            margin: 8px;
        }
        .buttons
        {
            display: flex;
            margin: 10px;
            justify-content: space-between;
        }
        .blocks-inputs {
            width: 173px;
        }
        .login
        {
            text-align: -webkit-center;
        }
        span
        {
            display: block;
            float: left;
            padding: 5px;
        }
        h4
        {
            color: #ff4343;
        }
    </style>
</html>
