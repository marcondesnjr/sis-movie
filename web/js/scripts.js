$(document).ready(function(){
    
    $(".preventDefault").click(function(e){
        e.preventDefault();
    });
    
});


function setFormValue(id,val){
    $('#'+id).val(val);
}

function addGenero(e){
    $("<select name='genero' id='genero'>\n\
        <c:forEach items='{generos}' var='gen'>\n\
            <option selected value='${gen.name}'>${gen}</option>\n\
        </c:forEach>\n\
    </select>").insertBefore(e);
    e.preventDefault();
    return false;
    
}

function addAtor(e){
    $("<input type='text' name='ator' id='ator'>").insertBefore(e);
    e.preventDefault();
}
function addDiretor(e){
    $("<input type='text' name='diretor' id='diretor'>").insertBefore(e);
    e.preventDefault();
}



