<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="register-container">
        <div class="title">
            <h1>Регистрация нового пользователя</h1>
        </div>

        <div class="main">
            <form action="${pageContext.request.contextPath}/register" method="post">
                <div class="center">
                    <div class="fio">

                        <label for="name">Имя:
                            <input type="text" name="name" id="name">
                        </label><br>
                        <label for="surname">Фамилия:
                            <input type="text" name="surname" id="surname">
                        </label><br>
                        <label for="patronymic">Отчество:
                            <input type="text" name="patronymic" id="patronymic">
                        </label><br>
                    </div>
                    <div class="second-date">
                        <label for="birthday">Дата рождения:
                            <input type="date" name="birthday" id="birthday">
                        </label><br>
                        <label for="age">Возраст:
                            <input type="number" min="0" max="300" name="age" id="age">
                        </label><br>
                        <label for="passport">Паспорт:
                            <input type="text" name="passport" id="passport">
                        </label><br>

                        <input name="gender" type="radio" value="MALE"> Мужской
                        <br>
                        <input name="gender" type="radio" value="FEMALE"> Женский
                    </div>
                    <div class="web-date">
                        <label for="phone">Номер телефона:
                            <input type="text" name="phone" id="phone">
                        </label><br>
                        <label for="email">Почта:
                            <input type="email" name="email" id="email">
                        </label><br>
                        <label for="password">Пароль:
                            <input type="password" name="password" id="password">
                        </label><br>
                    </div>
                </div>


                <div class="btn">
                    <button type="submit">Зарегистрироваться</button>
                </div>

            </form>
        </div>
    </div>

</body>

    <style type="text/css">
        .register-container{
            width: 800px;
            margin: 0 auto;
            padding: 0;
        }
        .center
        {
            display: flex;
            justify-content: space-between;
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
    </style>
</html>
