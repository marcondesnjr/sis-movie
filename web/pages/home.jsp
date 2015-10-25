<div class="container-fluid">

    <div class="row">
        <div class="col-lg-2">
            <img id="pfimg" src="${usrLog.foto}" alt="Imagem de perfil">
            <form>
                <label for="foto">Mude sua foto</label>
                <input type="file" name="foto" id="foto">
                <input type="submit">
            </form>
        </div>
        <div class="col-lg-6">
            <h1>Edite as suas informações</h1>
            <form action="CadastroUsuario" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="nome">Digite seu nome</label>
                    <input class="form-control" type="text" name="nome"  id="nome" value="${usrLog.nome}">
                </div>
                <div class="form-group">
                    <label for="sobrenome">Digite seu sobrenome</label>
                    <input class="form-control" type="text" name="sobrenome" id="sobrenome" value="${usrLog.sobrenome}">
                </div>
                <div class="form-group">
                    <label for="apelido">Digite seu apelido</label>
                    <input class="form-control" type="text" name="apelido" id="apelido" value="${usrLog.apelido}">
                </div>
                <div class="form-group">
                    <label for="email">Digite seu email</label>
                    <input class="form-control" type="email" name="email" id="email" value="${usrLog.email}">
                </div>
                <div class="form-group">
                    <label for="senha">Digite sua senha</label>
                    <input class="form-control" type="password" name="senha" id="senha">
                </div>
                <div class="form-group">
                    <label for="dataNasc">Digite sua data de Nascimento</label>
                    <input type="date" name="dataNasc" id="dataNasc">
                </div>
                <div class="form-group">
                    <label for="cidade">Digite sua cidade</label>
                    <input class="form-control" type="text" name="cidade" id="cidade" value="${usrLog.cidade}">
                </div>
                <div class="form-group">
                    <label for="estado">Digite seu estado</label>
                    <select id="estado" name="estado">
                        ${estados}
                        <c:forEach items="${estados}" var="estado">
                            <option <c:if test="${estado eq usrLog.estado}">selected</c:if> value="${estado}">${estado}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <input type="submit" value="salvar"><br>
                </div>      
            </form>
        </div>
        <%-- Coluna da Direita --%>
        <div class="col-lg-4">
            <%-- Linha de amigos--%>
            <div class="row">
                <h2>Amigos</h2>
            </div>
            <%-- Linha de grupos --%>
            <div class="row">
                <h2>Grupos</h2>
            </div>
        </div>
    </div>

</div>
