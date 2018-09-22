<%-- 
    Document   : login
    Created on : 06/09/2018, 14:37:37
    Author     : UTFPR
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:import url="/WEB-INF/jsp/inc/cabecalho.jsp" /> 

<form action="${linkTo[AuthController].autenticar}" method="POST">
    <input type="text" class="form-control" name="p.login" placeholder="Login" />
    <input type="password" class="form-control" name="p.senha" placeholder="Senha" />
    <button type="submit" class="btn btn-primary form-control">Login</button>
</form>

<c:import url="/WEB-INF/jsp/inc/rodape.jsp" /> 
