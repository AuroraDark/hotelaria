/**
 * Validação de Formulário
 */

function validarCliente() {
	let nome = frmCliente.nome.value
	let fone = frmCliente.fone.value
	let email = frmCliente.email.value
	let cpf = frmCliente.cpf.value
	let dataNascimento = frmCliente.dataNascimento.value
	let cep = frmCliente.cep.value
	let tipo = frmCliente.tipo.value
	let cNome = frmCliente.cNome.value
	let cNum = frmCliente.cNum.value
	let cVal = frmCliente.cVal.value
	if (nome === "") {
		alert('Preencha o campo Nome')
		frmCliente.nome.focus()
		return false
	} else if (fone === "") {
		alert('Preencha o campo Fone')
		frmCliente.fone.focus()
		return false
	} else if (email === "") {
		alert('Preencha o campo E-mail')
		frmCliente.email.focus()
		return false
	} else if (cpf === "") {
		alert('Preencha o campo CPF')
		frmCliente.cpf.focus()
		return false
	} else if (dataNascimento === "") {
		alert('Preencha o campo Data de Nascimento')
		frmCliente.dataNascimento.focus()
		return false
	} else if (cep === "") {
		alert('Preencha o campo CEP')
		frmCliente.cep.focus()
		return false
	} else if (tipo === "") {
		alert('Preencha o campo Tipo de Cartão (1=Crédito, 2=Débito)')
		frmCliente.tipo.focus()
		return false
	} else if (cNome === "") {
		alert('Preencha o campo Nome no Cartão')
		frmCliente.cNome.focus()
		return false
	} else if (cNum === "") {
		alert('Preencha o campo Número do Cartão')
		frmCliente.cNum.focus()
		return false
	} else if (cVal === "") {
		alert('Preencha o campo Validade do Cartão')
		frmCliente.cVal.focus()
		return false
	} else {
		alert('Dados inseridos com sucesso!')
		document.forms["frmCliente"].submit()
	}
}

function validarUsuario() {
	let usuario = formUsuario.usuario.value
	let senha = formUsuario.senha.value
	let nome = formUsuario.nome.value
	let email = formUsuario.email.value
	let cpf = formUsuario.cpf.value
	let dataNasc = formUsuario.dataNasc.value
	let cep = formUsuario.cep.value
	let num = formUsuario.num.value
	if (nome === "") {
		alert('Preencha o campo Nome')
		formUsuario.nome.focus()
		return false

	} else if (cpf === "") {
		alert('Preencha o campo CPF')
		formUsuario.cpf.focus()
		return false

	} else if (email === "") {
		alert('Preencha o campo Email')
		formUsuario.email.focus()
		return false

	} else if (dataNasc === "") {
		alert('Preencha o campo Data de Nascimento')
		formUsuario.dataNasc.focus()
		return false

	} else if (cep === "") {
		alert('Preencha o campo CEP')
		formUsuario.cep.focus()
		return false

	} else if (num === "") {
		alert('Preencha o campo Número')
		formUsuario.num.focus()
		return false

	} else if (usuario === "") {
		alert('Preencha o campo Usuário')
		formUsuario.usuario.focus()
		return false

	} else if (senha === "") {
		alert('Preencha o campo Senha')
		formUsuario.senha.focus()
		return false

	} else {
		alert('Dados inseridos com sucesso!')
		document.forms["formUsuario"].submit()
	}
}

function validarLogin() {
	let usuario = formLogin.usuario.value
	let senha = formLogin.senha.value
	if (usuario === "") {
		alert('Preencha o campo Usuário')
		formLogin.usuario.focus()
		return false

	} else if (senha === "") {
		alert('Preencha o campo Senha')
		formLogin.senha.focus()
		return false

	} else {
		document.forms["formLogin"].submit()
	}
}

function validarReserva(){
	let dataInicio = frmReserva.dataInicio.value
	let dataFim = frmReserva.dataFim.value
	let numQuarto = frmReserva.numQuarto.value
	let dataHoje = new Date()
	let mes = '' + (dataHoje.getMonth() + 1)
	let dia = '' + dataHoje.getDate()
	let ano = '' + dataHoje.getFullYear();
	if(mes.length < 2){
		mes = '0' + mes;
	}
	if(dia.length<2){
		dia = '0' + dia;
	}
	dataHoje = [ano,mes,dia].join('-');

	if(dataInicio === ""){
		alert('Preencha o campo Check-In')
		frmReserva.dataInicio.focus()
		return false
	}else if (dataFim === ""){
		alert('Preencha o campo Check-Out')
		frmReserva.dataFim.focus()
		return false
	}else if (numQuarto === ""){
		alert('Selecione um quarto.')
		frmReserva.numQuarto.focus()
		return false
	}else if(dataInicio<dataHoje){
		alert('Data inválida. Selecione um período de estadia válido.')
		frmReserva.dataInicio.focus()
		return false
	}else if(dataFim<dataInicio){
		alert('Data inválida. Selecione um período de estadia válido.')
		frmReserva.dataFim.focus()
		return false
	}else{
		alert('Datas OK (Fillipe: Código termina aqui)')
		return false
	}
}
