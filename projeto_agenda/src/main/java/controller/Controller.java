package controller;

import java.io.IOException;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/main", "/insert", "/select", "/update", "/delete", "/report" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The dao. */
	DAO dao = new DAO();
	
	/** The contato J beans. */
	JavaBeans contatoJBeans = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/main")) {
			listarContatos(request, response);
		} else if (action.equals("/insert")) {
			criarContato(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else if (action.equals("/report")) {
			gerarRelatorio(request, response);
		} else {
			response.sendRedirect("agenda.jsp");
		}
	}

	/**
	 * Listar contatos.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<JavaBeans> contatos = dao.listarContatos();

		request.setAttribute("contatos", contatos);
		RequestDispatcher rd = request.getRequestDispatcher("agenda.jsp");
		rd.forward(request, response);
	}

	/**
	 * Criar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void criarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contatoJBeans.setNome(request.getParameter("nome"));
		contatoJBeans.setFone(request.getParameter("fone"));
		contatoJBeans.setEmail(request.getParameter("email"));

		dao.inserirContato(contatoJBeans);

		response.sendRedirect("main");

	}

	/**
	 * Listar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contatoJBeans.setIdContatos(request.getParameter("idcon"));

		dao.selecionarContato(contatoJBeans);

		request.setAttribute("idcon", contatoJBeans.getIdContatos());
		request.setAttribute("nome", contatoJBeans.getNome());
		request.setAttribute("fone", contatoJBeans.getFone());
		request.setAttribute("email", contatoJBeans.getEmail());

		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		contatoJBeans.setIdContatos(request.getParameter("idcon"));
		contatoJBeans.setNome(request.getParameter("nome"));
		contatoJBeans.setFone(request.getParameter("fone"));
		contatoJBeans.setEmail(request.getParameter("email"));

		dao.alterarContato(contatoJBeans);

		response.sendRedirect("main");
	}

	/**
	 * Remover contato.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerContato(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		contatoJBeans.setIdContatos(request.getParameter("idcon"));

		dao.deletarContato(contatoJBeans);

		response.sendRedirect("main");
	}
	
	/**
	 * Gerar relatorio.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Document documento = new Document();
		try {
			response.setContentType("apllication/pdf");
			
			response.addHeader("Content-Disposition", "inline; filename=" + "contatos.pdf");
			
			PdfWriter.getInstance(documento, response.getOutputStream());
			
			documento.open();
			documento.add(new Paragraph("Lista de Contatos"));
			documento.add(new Paragraph(" "));
			
			PdfPTable tabela = new PdfPTable(3);
			
			PdfPCell col1 = new PdfPCell(new Paragraph("Nome"));
			PdfPCell col2 = new PdfPCell(new Paragraph("Fone"));
			PdfPCell col3 = new PdfPCell(new Paragraph("E-mail"));
			
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);

			List<JavaBeans> contatos = dao.listarContatos();
		
			for (JavaBeans contato : contatos) {
				tabela.addCell(contato.getNome());
				tabela.addCell(contato.getFone());
				tabela.addCell(contato.getEmail());
			}
			
			documento.add(tabela);
			documento.close();
		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}
	}
}

