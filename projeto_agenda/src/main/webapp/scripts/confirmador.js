/**
 * Confirmação de exclusao de um contato
 * @author Adao Oliveira
 * @param idcon
 */
 
 function confirmar(idcon) {
	let resposta = confirm("Confirma a exclusão deste contato?")
	if (resposta === true) {
		window.location.href = "delete?idcon=" + idcon
	}
 }