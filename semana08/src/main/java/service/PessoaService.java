//exercicio 02
//Vamos criar um serviço que terá uma lista estática de pessoas. Esse modelo Pessoas deverá conter as informações: Id e Nome.
//No serviço “PessoaService”, você criará um método chamado postPessoa, que receberá os dados de uma pessoa e a salvará na lista estática.
//Utilize o método POST para resgatar as informações recebidas no payload e salve, utilizando o serviço, a pessoa na lista estática.

//exercicio 03
//Utilize o serviço criando no exercício anterior e retorne o nome da pessoa conforme ID recebido como parâmetro. 
//Utilize esse novo método e retorne via GET, quando receber a query param de ID, o nome da pessoa.

package service;

import java.util.ArrayList;
import java.util.List;

import model.PessoaModel;

public class PessoaService {
	
	//exercicio 02
	private static List<PessoaModel> pessoas = new ArrayList<PessoaModel>();
	
	public void postPessoa(PessoaModel pessoa) {
		pessoa.setId(System.currentTimeMillis());
		this.pessoas.add(pessoa);
	}
	
	public List<PessoaModel> getPessoas() {
		return this.pessoas;
	}
	
	//exercicio 03
	public PessoaModel getPessoa(Long id) {
		for(PessoaModel p: this.pessoas) {
			if (p.getId().equals(id)) {
				return p;
			}
		}
		
		return null;
	}
	
}
