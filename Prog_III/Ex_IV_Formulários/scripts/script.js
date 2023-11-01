function validarFormulario(){
    let cnpj = document.getElementById("cnpj");
    let telefone = document.getElementById("telefone");

    //Verificar CNPJ
    let cnpjRegEx = /^\d{2}\.\d{3}\.\d{3}\/\d{4}\-\d{2}$/;
    if(!cnpjRegEx.test(cnpj.value)){
        alert('O CNPJ deve estar no formato XX.XXX.XXX/XXXX-XX');
        return false;
    }
    // Verificação do telefone de contato
    let telefoneRegex = /^\(\d{2}\)\d{4,5}-\d{4}$/;
    if (!telefoneRegex.test(telefone.value)) {
        alert('O telefone de contato deve estar no formato (XX)XXXXX-XXXX');
        return false;
    }
    return true;
}