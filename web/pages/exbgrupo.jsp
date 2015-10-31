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
                </div>
                
            </div>
            <div class="row">
                <p>${grupo.descricao}</p>
            </div>
        
    </div>
        <%-- Coluna de participantes --%>
        <div class="col-md-3">
            <div class="row">
                <div class="col-xs-12">
                    <h3>Participantes</h3>
                    <c:set scope="page" var="cont" value="0"/>
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
                            <c:if test="${cont eq 4}">
                            </div>
                            <c:set var="cont" value="0"/>
                        </c:if>
                    </c:forEach>

                </div>
            </div>
        </div>
    </div>
</div>
