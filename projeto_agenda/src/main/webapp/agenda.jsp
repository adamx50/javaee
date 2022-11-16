
<%@page import="java.util.List"%>
<%@page import="model.JavaBeans"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	@SuppressWarnings("unchecked")
	List<JavaBeans> contatos = (ArrayList<JavaBeans>) request.getAttribute("contatos");
%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="UTF-8">
<title>Agenda de contatos</title>
<link rel="icon" href="imagens/phone.png" />
<link rel="stylesheet" href="style.css" />
</head>
<body>
	<img alt="Agenda" src="imagens/agenda.png" height="200px">
	<h1>Agenda de contatos</h1>
	<a href="novo.html" class="botao1">Novo Contato</a>
	<a href="report" class="botao2">Relatório</a>

	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Fone</th>
				<th>E-mail</th>
				<th>Opcões</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (JavaBeans contato : contatos) {
			%>
			<tr>
				<td><%=contato.getIdContatos()%></td>
				<td><%=contato.getNome()%></td>
				<td><%=contato.getFone()%></td>
				<td><%=contato.getEmail()%></td>
				<td><a href="select?idcon=<%=contato.getIdContatos()%>"
					class="botao1">Editar</a> <a
					href="javascript: confirmar(<%=contato.getIdContatos()%>)"
					class="botao2">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>

	</table>
	<script type="text/javascript" src="scripts/confirmador.js"></script>
</body>
</html>