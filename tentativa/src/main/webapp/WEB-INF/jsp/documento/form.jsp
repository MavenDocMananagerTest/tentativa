<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Documento</title>
    </head>
    <body>
        <h1>Documento (Cadastro)</h1>

        <c:if test="${not empty errors}">
            <ul>
                <c:forEach items="${errors}" var="err">
                    <li>${err.message}</li>
                    </c:forEach>
            </ul>
        </c:if>

        <form action="${linkTo[DocumentoController].save}" method="POST">
            <div>
                <label>Descricao</label>
                <input type="text" name="documento.descricao"/>
            </div>    

            <div>
                <label>Data</label>
                <input type="text" name="documento.data"/>
            </div>

            <div>
                <label>Ultima Atualizacao</label>
                <input type="text" name="documento.ultatualizacao"/>
            </div>

            <div>
                <label>Nome</label>
                <input type="text" name="documento.nome"/>
            </div>
            <button type="submit">Gravar</button>
        </div>

    </form>
</body>
</html>
