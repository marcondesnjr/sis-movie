<div class="modal fade" id="new-topic">
    <div class="modal-dialog">
        <div class="modal-content" style="padding: 10px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">Adicione um Tópico</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="control?command=AddTopico" method="POST">
                    <div class="form-group">
                        <label for="titulo">Titulo:</label>
                        <input type="text" maxlength="30" name="titulo" id="titulo">
                    </div>
                    <div class="form-group">
                        <label for="desc">Descricao:</label>
                        <textarea class="form-control" name="desc" id="desc"></textarea>
                    </div>
                    <input type="hidden" name="filme-ref" id="filme-ref" value="">
                    <input type="hidden" name="grupo" id="grupo" value="${grupo.id}">
                    <div class="container">
                        <div class="row">
                            <c:forEach items="${filmes}" var="filme">
                                <div class="col-sm-3">
                                    <a href="#" onclick="setFilmeTopico(${filme.id})"><img src="${filme.foto}"></a>
                                </div>
                            </c:forEach> 
                        </div>
                    </div>
                    <input type="submit" value="Criar">
                    <input type="hidden" value="${filme.id}" name="idFilme">
                </form>
            </div>
        </div>

    </div>
</div>

<div class="container">
    <div class="row">
        <%-- Coluna de tópicos --%>
        <div class="col-md-9">
            <div class="row">
                <div class="col-md-11">
                    <h2>${grupo.nome} </h2>
                </div>
                <div class="col-md-1">
                    <c:if test="${not participante}">
                        <a href="control?command=ParticiparGrupo&id=${grupo.id}">
                            <img src alt="Participar do Grupo">
                        </a>
                    </c:if>
                    <c:if test="${participante}">
                        <a href="#" data-toggle="modal" data-target="#new-topic">
                            <img src alt="Adicionar Tópico">
                        </a>
                    </c:if>
                </div>  
            </div>
            <div class="row">
                <p><c:out value="${grupo.descricao}"/></p>
            </div>
                <c:if test="${tpid eq null}" var="result">
                    <%@include file="topicos.jsp" %>
                </c:if>
                <c:if test="${tpid ne null}">
                    <%@include file="singleTop.jsp" %>
                    <%@include file="comentForm.jsp" %>
                </c:if>
        </div>
        <%-- Coluna de participantes --%>
        <div class="col-md-3">
            <div class="row">
                <div class="col-xs-12">
                    <h3>Participantes</h3>
                    <c:set var="cont" value="0"/>
                    <c:forEach items="${grupo.participantes}" var="part">
                        <c:if test="${cont eq 0}">
                            <div class="row">
                            </c:if>
                            <div class="col-md-3 sm-usuario">
                                <img src="${part.foto}" alt="${part.nome}">
                                <span>
                                    <a href="control?command=ExibirUsuario&email=${part.email}">
                                        ${part.nome} ${part.sobrenome}
                                    </a>
                                </span>
                            </div>
                            <c:set var="cont" value="${cont + 1}"/>
                            <c:if test="${cont eq quantColunas}">
                            </div>
                            <c:set var="cont" value="0"/>
                        </c:if>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
