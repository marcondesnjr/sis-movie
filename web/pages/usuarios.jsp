<div class="container-fluid">
    <div class="row">
        <form action="control?command=Pesquisar" method="POST">
            <div class="form-group">
                <label for="nome">Pesquise: </label>
                <input type="search" name="nome" id="nome">
                <input type="submit" value="Pesquisar">
            </div>
        </form>
        <c:forEach items="${usuarios}" var="usuario">
            <div class="col-lg-1 col-md-2">
                    <div class="mini-block">
                        <img src="${usuario.foto}" alt="${usuario.nome}">
                    <span><a href="usr/${usuario.email}"><c:out value="${usuario.nome} ${usuario.sobrenome}"/></a></span>
                </div>
            </div>
        </c:forEach>
    </div>
</div>