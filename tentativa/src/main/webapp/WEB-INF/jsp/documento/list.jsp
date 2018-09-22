<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:import url="/WEB-INF/jsp/inc/cabecalho.jsp" />

<!-- colocar no final desta página -->
<jsp:include  page="/WEB-INF/jsp/inc/rodape.jsp" />

<h1>Documento (List)</h1>

<table class="table table-striped">
    <tr>
        <th>Descricao</th>
        <th>Data</th>
        <th>Ultima Atualizacao</th>
        <th>Nome</th>
    </tr>
    <c:forEach items="${documentoList}" var="doc">
        <tr>
            <td>${doc.descricao}</td>
            <td>${doc.data}</td>
            <td>${doc.ultatualizacao}</td>
            <td>${doc.nome}</td>
            <td><a href="edit/${doc.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>

${mensagem} <br/> ${data}
