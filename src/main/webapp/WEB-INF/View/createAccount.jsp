<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Открытие счёта</title>
</head>

<body>
<%@include file="../PartialView/header.jsp"%>

<div class="container">

  <div class="register-account-bank">
    <div class="register-block">
      <div class="title-reg-block">
        <h2>Открытие счёта в банке</h2>
      </div>
      <div class="body">
        <div class="title_choice">
          <h5>Выберите банк для открытия счёта</h5>
        </div>

        <div class="registration-inputs">
          <form action="${pageContext.request.contextPath}/create_account" method="post">
          <div class="select-option">
              <select name="banks" class="select">
                <option value="choice">Выберите банк</option>
                <c:forEach var="item" items="${requestScope.banks}">
                  <option value="${item.name}">${item.name}</option>
                </c:forEach>
              </select>
          </div>

            <div class="register-account-bank-btn">
              <button type="submit">Открыть счёт</button>
            </div>
          </form>

        </div>


        <div class="errors">
          <c:if test="${not empty requestScope.errors}">
            <c:forEach var="error" items="${requestScope.errors}">
                        <span style="color: red;">
                            ${error}<br>
                        </span>
            </c:forEach>
          </c:if>
        </div>


      </div>
    </div>

  </div>

</div>

<style>
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
  .register-account-bank-btn button
  {
    margin-top: 10px;
  }
</style>
</body>



