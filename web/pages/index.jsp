
<c:if test="${usrLog eq null}">
<!-- //requried-jsfiles-for owl -->
<div class="welcome text-center">
    <div class="container">
        <h2>Conecte-se Com Sua Conta</h2>
        <div class="form-submit">
            <form  class="center" action="realizarLogin" method="post">
                <label for="login">Email:</label>
                <input type="text" name="login" id="login"><br>
                <label for="senha">Senha:</label>
                <input type="password" name="senha" id="senha"><br>
                <input type="submit">
            </form>
        </div>
    </div>
</div>
</c:if>
<!--latest designs-->
<div id="cate" class="categories">
    <div class="container">
        <div class="cat-head">
            <h3>Ultimos Filmes</h3>
        </div>
        <div class="categorie-grids cs-style-1">
          
            <c:forEach items="${filmes}" var="filme">
                <div class="col-md-4 cate-grid grid">
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

            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--//latest designs-->
<!-- testimonials -->
<div class="second-slider">
    <div class="container">
        <h3 class="tes text-center">Testimonials</h3>
        <div  id="top" class="callbacks_container">
            <ul class="rslides" id="slider4">
                <li>
                    <div class="sec-slid-info text-center">
                        <img src="images/tes1.jpg" alt="" />
                        <h4>lora germo</h4>
                        <p>Nam mi enim, auctor non ultricies a, fringilla eu risus. Praesent vitae lorem et elit tincidunt accumsan suscipit eu libero.
                            Nam mi enim, auctor non ultricies a</p>
                    </div>
                </li>
                <li>
                    <div class="sec-slid-info text-center">
                        <img src="images/tes2.jpg" alt="" />
                        <h4>suhiga</h4>
                        <p>Man mi mine, rotcua non ultricies a, allignirf eu susir. Praesent viitae lorem et elit tincidunt accumsan suscipit ue bolero.
                            Ultricies Nam mi enim, auctor non</p>
                    </div>
                </li>
                <li>
                    <div class="sec-slid-info text-center">
                        <img src="images/tes3.jpg" alt="" />
                        <h4>Singem Middile</h4>
                        <p>Vam mi enim, risus non ultricies a, fringilla eu auctor. Vitae praesent lorem et elit accumsan tincidunt suscipit eu libero.
                            Auctor Nam mi enim, auctor non</p>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>	
<!-- //testimonials -->
<!-- news -->
<div class="news" id="blog">
    <div class="container">
        <div class="news-head text-center">
            <h3>Our Blog</h3>
            <p>Cras porttitor imperdiet volutpat nulla malesuada lectus eros ut convallis felis consectetur ut</p>
        </div>
        <div class="news-grids">
            <div class="col-md-4 news-grid">
                <a href="single.html">Interior design article post</a>
                <span>Posted by <a class="admin" href="#">Admin</a>on 09 JUN 2015</span>
                <a class="mask" href="single.html"><img src="images/img1.jpg" class="img-responsive zoom-img" alt="" /></a>
                <div class="news-info">
                    <p>Pellentesque ut urna eu mauris scele risque auctor volutpat et massa pers piciis iste natus scele risque auctor volutpat et massa.</p>
                    <a class="button" href="single.html"><img src="images/read.png" alt=""></a>
                </div>
            </div>
            <div class="col-md-4 news-grid">
                <a href="single.html">Interior design article post</a>
                <span>Posted by <a class="admin" href="#">Admin</a>on 24 SEP 2015</span>
                <a class="mask" href="single.html"><img src="images/img2.jpg" class="img-responsive zoom-img" alt="" /></a>
                <div class="news-info">
                    <p>Pellentesque ut urna eu mauris scele risque auctor volutpat et massa pers piciis iste natus scele risque auctor volutpat et massa.</p>
                    <a class="button" href="single.html"><img src="images/read.png" alt=""></a>
                </div>
            </div>
            <div class="col-md-4 news-grid">
                <a href="single.html">Interior design article post</a>
                <span>Posted by <a class="admin" href="#">Admin</a>on 15 FEB 2015</span>
                <a class="mask" href="single.html"><img src="images/img3.jpg" class="img-responsive zoom-img" alt="" /></a>
                <div class="news-info">
                    <p>Pellentesque ut urna eu mauris scele risque auctor volutpat et massa pers piciis iste natus scele risque auctor volutpat et massa.</p>
                    <a class="button" href="single.html"><img src="images/read.png" alt=""></a>
                </div>
            </div>
            <div class="col-md-4 news-grid">
                <a href="single.html">Interior design article post</a>
                <span>Posted by <a class="admin" href="#">Admin</a>on 10 JUN 2015</span>
                <a class="mask" href="single.html"><img src="images/img4.jpg" class="img-responsive zoom-img" alt="" /></a>
                <div class="news-info">
                    <p>Pellentesque ut urna eu mauris scele risque auctor volutpat et massa pers piciis iste natus scele risque auctor volutpat et massa.</p>
                    <a class="button" href="single.html"><img src="images/read.png" alt=""></a>
                </div>
            </div>
            <div class="col-md-4 news-grid">
                <a href="single.html">Interior design article post</a>
                <span>Posted by <a class="admin" href="#">Admin</a>on 09 JUN 2015</span>
                <a class="mask" href="single.html"><img src="images/img1.jpg" class="img-responsive zoom-img" alt="" /></a>
                <div class="news-info">
                    <p>Pellentesque ut urna eu mauris scele risque auctor volutpat et massa pers piciis iste natus scele risque auctor volutpat et massa.</p>
                    <a class="button" href="single.html"><img src="images/read.png" alt=""></a>
                </div>
            </div>
            <div class="col-md-4 news-grid">
                <a href="single.html">Interior design article post</a>
                <span>Posted by <a class="admin" href="#">Admin</a>on 24 SEP 2015</span>
                <a class="mask" href="single.html"><img src="images/img2.jpg" class="img-responsive zoom-img" alt="" /></a>
                <div class="news-info">
                    <p>Pellentesque ut urna eu mauris scele risque auctor volutpat et massa pers piciis iste natus scele risque auctor volutpat et massa.</p>
                    <a class="button" href="single.html"><img src="images/read.png" alt=""></a>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //news -->
