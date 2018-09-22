<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/WEB-INF/jsp/inc/cabecalho.jsp" />

<!-- colocar no final desta página -->
<div class="container jumbotron-fluid">  
<h1 class="display-4">Listagem de documentos</h1>

    <table class="table table-striped  table-dark"">
        <tr>
            <th scope="col">Descricao</th>
            <th scope="col">Data</th>
            <th scope="col">Ultima Atualizacao</th>
            <th scope="col">Nome</th>
            <th scope="col"></th>
        </tr>
        <c:forEach items="${documentoList}" var="doc">
            <tr>
                <td>${doc.descricao}</td>
                <td>${doc.data}</td>
                <td>${doc.ultatualizacao}</td>
                <td>${doc.nome}</td>
                <td><a href="doc/${doc.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include  page="/WEB-INF/jsp/inc/rodape.jsp" />


