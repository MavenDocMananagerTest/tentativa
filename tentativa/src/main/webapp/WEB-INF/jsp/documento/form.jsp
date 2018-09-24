<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="/WEB-INF/jsp/inc/cabecalho.jsp" />
        <div class=" jumbotron-fluid ">  
            <h1 class="display-4">Cadastro de documento</h1>

            <c:if test="${not empty errors}">
                <ul>
                    <c:forEach items="${errors}" var="err">
                        <li>${err.message}</li>
                        </c:forEach>
                </ul>
            </c:if>
            <div class="container jumbotron-fluid col-md-9">
                <form action="${linkTo[DocumentoController].save}" method="POST">
                    <div class="form-group">
                        <label >Descricao</label>
                            <input type="text" class="form-control" name="documento.descricao"/>
                    </div>    
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label>Data</label>
                            <input type="text" class="form-control" name="documento.data"/>
                        </div>

                        <div class="form-group col-md-6">
                            <label>Ultima Atualizacao</label>
                            <input type="text" class="form-control" name="documento.ultatualizacao"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label>Nome</label>
                        <input type="text" class="form-control" name="documento.nome"/>
                    </div>

                    <button type="submit" class="btn btn-primary mb-2" href="doc/${doc.id}">Gravar</button>
                </form>
            </div>       
        </div>
<jsp:include page="/WEB-INF/jsp/inc/rodape.jsp" />
