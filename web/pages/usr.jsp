<div class="container-fluid">
    <div class="row">
        <div class="col-md-2">
            <div class="panel-usr-left">
                <img id="foto-perfil" src="${usuario.foto}" alt="${usuario.nome}">
                <img alt="Mandar convite">
            </div>
        </div>
        <div class="col-md-10">
            <div class="panel-usr">
                <h2>${usuario.nome} ${usuario.sobrenome}</h2>
                <ul>
                    <li>Email: ${usuario.email}</li>
                    <li>Data de Nascimento: ${usuario.dataNasc}</li>
                    <li>Cidade: ${usuario.cidade}</li>
                    <li>Estado: ${usuario.estado}</li>
                </ul>
            </div>
        </div>
    </div>
</div>
