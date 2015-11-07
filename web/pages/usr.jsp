<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <div class="panel-usr-left">
                <img id="foto-perfil" src="${usuario.foto}" alt="${usuario.nome}">
                <a href="control?command=SolicitarAmizade&email=${usuario.email}"><img alt="Mandar convite"></a>
            </div>
        </div>
        <div class="col-md-10">
            <div class="panel-usr">
                <h2><c:out value="${usuario.nome} ${usuario.sobrenome}"/></h2>
                <ul>
                    <li>Email: <c:out value="${usuario.email}"/></li>
                    <li>Data de Nascimento: <c:out value="${usuario.dataNasc}"/></li>
                    <li>Cidade: <c:out value="${usuario.cidade}"/></li>
                    <li>Estado: <c:out value="${usuario.estado}"/></li>
                </ul>
            </div>
        </div>
    </div>
</div>
