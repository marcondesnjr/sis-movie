<div class="container-fluid">
    <div class="row">
        <form action="pesquisar" method="GET">
            <div class="form-group">
                <label for="nome">Pesquise: </label>
                <input type="search" name="nome" id="nome">
                <input type="submit" value="Pesquisar">
            </div>
        </form>
        <c:forEach items="${usuarios}" var="usuario">
            <div class="col-lg-1 col-md-2">
                    <div class="sm-usuario">
                        <img src="${usuario.foto}" alt="${usuario.nome}">
                        <span><a href="exibirUsuario?email=${usuario.email}">${usuario.nome} ${usuario.sobrenome}</a></span>
                </div>
            </div>
        </c:forEach>
    </div>
</div>