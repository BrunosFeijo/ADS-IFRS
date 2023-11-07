/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validarFormulario() {
    var email = document.getElementById("email").value;
    var telefone = document.getElementById("telefone").value;
    
    if (email.trim() === "") {
        alert("O campo E-mail é obrigatório. Por favor, preencha-o.");
        return false;
    }

    var telefonePattern = /^\([0-9]{2}\) [0-9]{4}-[0-9]{4}$/;
    var telefoneValido = telefonePattern.test(telefone);

    if (!telefoneValido) {
        alert("Telefone inválido. Por favor, insira um telefone no formato (XX) XXXX-XXXX.");
        return false;
    }

    return true;
}
function popularSecoes() {
    var params = '{}';
    $.ajax({
        type: "GET",
        url: "https://servicodados.ibge.gov.br/api/v2/cnae/secoes",
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {

            $("#secao option.sec").remove();
            for (var i=0; i<msg.length; i++) {
                $("#secao").append("<option class=\"sec\" value=\""+msg[i].id+"\">"+msg[i].descricao+"</option>");
            }
        },
        error: function(xhr, msg, e) {
            alert(xhr.responseJSON.message);
            $("#secao li.sec").remove();
        }
    });
}
function popularGrupos() {
    var params = '{}';
    var secaoId = $("#secao").val();
    var grupoSelect = $("#grupo");

    $.ajax({
        type: "GET",
        url: "https://servicodados.ibge.gov.br/api/v2/cnae/secoes/" + secaoId + "/grupos",
        data: params,
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        success: function(msg, status) {
            $("#grupo option.gru").remove();
            for (var i=0; i<msg.length; i++) {
                grupoSelect.append("<option class=\"gru\" value=\""+msg[i].id+"\">"+msg[i].descricao+"</option>");
            }
        },
        error: function(xhr, msg, e) {
            alert(xhr.responseJSON.message);
            $("#grupo li.gru").remove();
        }
    });
}
