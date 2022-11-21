//exercicio 01
//Para iniciar nossa jornada com Java Web, iremos primeiramente fazer uma criação de um projeto Web 
//utilizando Servlet, conforme visto em nossa primeira aula. Neste momento, não precisamos fazer nada 
//além da inicialização. Após gerar os arquivos, certifique-se que o servidor foi configurado e o GET 
//do arquivo gerado esteja funcionando corretamente.

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.PessoaModel;
import service.PessoaService;

/**
 * Servlet implementation class Exercicio01
 */
@WebServlet("/Exercicio01")
public class Exercicio01 extends HttpServlet {

	private PessoaService service = new PessoaService();
	private Gson gson = new Gson();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String json = "";
		if (id != null) {
			json = gson.toJson(this.service.getPessoa(Long.parseLong(id)));
		} else {
			json = gson.toJson(this.service.getPessoas());
		}
		response.getWriter().append(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedReader reader = request.getReader();
		PessoaModel pessoa = gson.fromJson(reader, PessoaModel.class);
		
		service.postPessoa(pessoa);
		
		doGet(request, response);
	}

}
