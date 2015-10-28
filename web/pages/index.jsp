<c:if test="${usrLog eq null}">
    <!-- //requried-jsfiles-for owl -->
    <div class="welcome text-center">
        <div class="container">
            <h2>Conecte-se Com Sua Conta</h2>
            <div class="form-submit">
                <form  class="center" action="control?command=LogIn" method="post">
                    <div class="form-group">
                        <label for="login">Email:</label>
                        <input type="text" name="login" id="login"><br>
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha:</label>
                        <input type="password" name="senha" id="senha"><br>
                    </div>
                    <input type="submit">
                </form>
            </div>
        </div>
    </div>
</c:if>
<br><br><br><br><br><br><br>
<!--latest designs-->
<div class="exb-filme">
    <div id="cate" class="categories">
        <div class="container">
            <div class="cat-head">
                <h3>Ultimos Filmes</h3>
            </div>
            <div class="categorie-grids cs-style-1">
                <div class="row">
                    <c:forEach items="${filmes}" var="filme">

                        <div class="col-md-4 col-sm-6 col-xs-12 cate-grid grid">
                            <figure>
                                <img src="${filme.foto}" alt="">
                                <figcaption>
                                    <h3>${filme.titulo}</h3>
                                    <span>${filme.sinopse}</span>
                                    <a class="example-image-link" href="images/c1.jpg" data-lightbox="example-1" data-title="Interior Design">VIEW</a>
                                </figcaption>
                            </figure>
                        </div>

                    </c:forEach>
                </div>

                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<!--//latest designs-->
