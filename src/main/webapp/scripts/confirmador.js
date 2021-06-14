/**
 * Confirmador de exclusão
 */

function confirmarFuncionario(codFunc){
	let resposta = confirm("Confirma a exclusão deste usuário?")
	console.log(codFunc)
	if(resposta === true){
		window.location.href = "deleteUsuario?codfunc=" + codFunc
	}
}

function confirmarCliente(CodCli){
	let resposta = confirm("Confirma a exclusão deste cliente?")
	if (resposta === true){
		window.location.href = "deletecliente?CodCli=" + CodCli
	}
}

function cancelar(){
	let resposta = confirm("Cancelar a operação?")
	if (resposta === true){
		window.location.href = "Menu.jsp"
	}
}