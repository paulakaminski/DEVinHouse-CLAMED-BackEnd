//exercicio 05
//Assim como fizemos com servlets, no package “service”, vamos criar um service para Pessoa que conterá os métodos:
// “getPessoas”, “getPessoa”, “postPessoa”, “updatePessoa”. Nesse momento, apenas faça a criação retornando void,
// ao decorrer dos exercícios você irá implementar não só a lógica, mas as rotas da sua API.

//exercicio 06
//Utilizando no service, crie uma lista estática de “Pessoa” e no método “GetPessoas”, se a lista for maior que 0,
// retorne a lista completa, caso contrário, retorne o status code 204.

//exercicio 07
//Seguindo a mesma lógica do exercício anterior, vamos utilizar o método “getPessoa” na qual receberá um id e buscará
// na lista de pessoas o objeto conforme sua id. Se encontrar, retorne esse objeto, caso contrário retorne o status code 204.

//exercicio 08
//Vamos agora criar uma rota post e esperar que nela venha no payload o objeto “Pessoa”, se for válido, você irá chamar
// o método “postPessoa”, que receberá pessoa por parâmetro e incluirá na lista retornando status code 200.

//exercicio 09
//Vamos criar uma rota de atualização de objeto na qual receberá uma pessoa como parâmetro e ao chamar o “updatePessoa”,
// irá buscar a pessoa conforme sua ID e substituirá na lista. Se não encontrado, deverá retornar o statuscode 204.

//exercicio 10
//Para finalizar, vamos criar uma rota de delete na qual receberá como parâmetro o id de uma pessoa que você irá remover
// da lista estática. Caso não encontre, você deverá retornar o statuscode 204.

package exercicios.semana08.exerciciosspring.service;

import exercicios.semana08.exerciciosspring.model.PessoaModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//exercicio 05
@Service
public class PessoaService {

    //exercicio 06
    private static List<PessoaModel> pessoas = new ArrayList<>();

    public List<PessoaModel> getPessoas() {
        if (pessoas.isEmpty()) {
            return null;
        } else {
            return pessoas;
        }

    }

    //exercicio 07
    public PessoaModel getPessoa(Long id) {

        for (PessoaModel p : this.pessoas) {
            if (p.getId().equals(id)) {
                return p;
            }
        }

        return null;
    }

    //exercicio 08
    public void postPessoa(PessoaModel pessoa) {
        pessoa.setId(System.currentTimeMillis());
        pessoas.add(pessoa);
    }

    //exercicio 09
    public void updatePessoa(PessoaModel pessoa) {
        for(PessoaModel currentPessoa : pessoas) {
            if(Objects.equals(currentPessoa.getId(), pessoa.getId())) {
                currentPessoa.setId(pessoa.getId());
                currentPessoa.setNome(pessoa.getNome());
                currentPessoa.setEmail(pessoa.getEmail());
            }
        }
    }

    //exercicio10
    public void deletePessoa(Long id) {

        for (PessoaModel p : this.pessoas) {
            if (p.getId().equals(id)) {
                pessoas.remove(p);
            }
        }

    }

}
