<div class="container">
    <div class="row row-centered">
        <div class="col-md-4 col-centered">
            <form class="form-horizontal" action="control?command=CadastrarFilme" method="post" enctype="multipart/form-data">
                <div class="form-group">            
                    <label for="foto">Capa do Filme</label><br>
                    <input class="form-control" type="file" name="foto" id="foto"><br>
                </div>
                <div class="form-group">
                    <label for="titulo">Titulo do Filme</label><br>
                    <input class="form-control" type="text" name="titulo"  id="titulo" required><br>
                </div>
                <div class="form-group">
                    <label for="sinopse">sinopse</label><br>
                    <textarea class="form-control" name="sinopse" id="sinopse"></textarea>
                </div>
                <div class="form-group">
                    <label for="ano">ano</label><br>
                    <input class="form-control" type="number" name="ano" id="ano"><br>
                </div>
                <div class="form-group">
                    <label for="genero">Gerero</label><br>
                    <select name="genero" id="genero">
                        <c:forEach items="${generos}" var="gen">
                            <option selected value="${gen.name}">${gen}</option>
                        </c:forEach>
                    </select>
                    <a href="#" class="preventDefault" onclick="addGenero(this)"><input type="button" value="MORE"></a><br>
                </div>
                <div class="form-group">
                    <label for="ator">Atores</label><br>
                    <input type="text" name="ator" id="ator">
                    <a href="#" class="preventDefault" onclick="addAtor(this)"><input type="button" value="MORE"></a><br>
                </div>
                <div class="form-group">
                    <label for="diretor">Diretores</label><br>
                    <input type="text" name="diretor" id="diretor">
                    <a href="#" class="preventDefault" onclick="addDiretor(this)"><input type="button" value="MORE"></a><br>
                </div>
                <div class="form-group">
                    <label for="cidade">Digite sua cidade</label><br>
                    <input class="form-control" type="text" name="cidade" id="cidade"><br>
                </div>
                <div class="form-group">
                    <label for="estado">Digite seu estado</label><br>
                    <input class="form-control" type="text" name="estado" id="estado"><br>
                </div>
                <input type="submit" value="enviar"><br>
            </form>
        </div>
    </div>
</div>