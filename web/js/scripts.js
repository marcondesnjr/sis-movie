$(document).ready(function(){
    
    $(".preventDefault").click(function(e){
        e.preventDefault();
    });
    
});


function setFormValue(id,val){
    $('#'+id).val(val);
}

function addGenero(e){
    $("#genero").clone().insertBefore(e);
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



