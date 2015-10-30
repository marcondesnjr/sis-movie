<div class="modal fade" id="alv">
    <div class="modal-dialog">
        <div class="modal-content" style="padding: 10px">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title">Avalie este filme</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="control?command=AvaliarFilme" method="POST">
                    <div class="form-group">
                        <label for="rating">Rating:</label>
                        <input type="number" max="5" min="1" name="rating" id="rating">
                    </div>
                    <div class="form-group">
                        <label for="coment">Comentário:</label>
                        <textarea class="form-control" name="coment" id="comment"></textarea>
                    </div>
                    <input type="submit" value="Avaliar">
                    <input type="hidden" value="${filme.id}" name="idFilme">
                </form>
            </div>
        </div>

    </div>
</div>

<div class="container">
    <div class="row">
        <%-- Coluna da esquerda --%> 
        <div class="col-md-3">
            <div class="panel-filme-left">
                <img id="foto-perfil" src="${filme.foto}" alt="Foto do Filme">
                <span>Rating: ${media}</span>
                <a href="#" data-toggle="modal" data-target="#alv"><img src alt="AvaliarFilme"></a>
            </div>
        </div>
        <%-- Coluna da direita --%>
        <div class="col-md-9">
            <div class="panel-filme">
                <h2>${filme.titulo}</h2>
                <p>${filme.sinopse}</p>
            </div>
            
            <div class="panel-filme" style="margin-top: 50px">
                <c:forEach items="${avaliacoes}" var="avl">
                    <div class="alv-separpator">
                        <div class="row">
                            <div class="col-sm-2">
                                <img class="max-width" src="${avl.usr.foto}" alt="foto do usuário">
                            </div>
                            <div class="col-sm-10">
                                <div class="col-sm-10">
                                    <h4>${avl.usr.nome} ${avl.usr.sobrenome}</h4>
                                </div>
                                <div class="col-sm-2">
                                    <h5>Rating: ${avl.rating}</h5>
                                </div> 
                                <p>
                                    ${avl.desc}
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

    </div>
</div>
