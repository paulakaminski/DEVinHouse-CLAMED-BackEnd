//exercicio 04
//Após a criação do repository, crie um método de inclusão no service e uma rota no controller que receberá uma pessoa
// que salvará no banco ao ser invocado o save no service.

//exercicio 05
//Contendo dados no banco, crie no service um método que retornará todas as pessoas utilizando o repository. Mapeie esse
// método com a rota equivalente no Controller.

//exercicio 06
//Agora, crie um método que receberá um ID como parâmetro e retornará apenas a pessoa correspondente. Mapeie esse método
// com a rota equivalente no Controller.

//exercicio 07
//Crie um método no repositório que busque apenas as pessoas que estiverem com o status “true”. Assim como nos
// exercícios anteriores, crie uma rota no controller, chama o service que irá buscar no repository esse método.

//exercicio 08
//Crie um método no service que receberá como parâmetro um objeto de Pessoa e se informado o ID e estiver na base, que
// efetue a atualização do objeto.

//exercicio 09
//Crie um método no service que receberá o id de uma pessoa, chame o método de delete do repository para aquele id.
// Assim como nos exercícios anteriores, crie uma rota no controller, chama o service que irá buscar no repository
// esse método.

package tech.semana09.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import tech.semana09.entity.PessoaEntity;
import tech.semana09.repository.PessoaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    //exercicio 04
    public void insert(PessoaEntity pessoa) {
        pessoaRepository.save(pessoa);
    }

    //exercicio 05
    public List<PessoaEntity> getAll() {
        return pessoaRepository.findAll();
    }

    //exercicio 06
    public Optional<PessoaEntity> getById(Long id) {
        Optional<PessoaEntity> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isPresent()) {
            return pessoaOptional;
        }

//        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return null;
    }

    //exercicio 07
    public List<PessoaEntity> getByStatus() {
        return pessoaRepository.findByStatus(true);
    }

//    public void update(PessoaEntity pessoa) {
//        for (PessoaEntity currentPessoa : this.getAll()) {
//            if (Objects.equals(currentPessoa.getId(), pessoa.getId())) {
//                pessoaRepository.save(pessoa);
//            } else {
//                throw new ResponseStatusException(HttpStatus.NO_CONTENT);
//            }
//        }
//    }

    //exercicio 08
    public void update(PessoaEntity pessoa, Long id) {
        Optional<PessoaEntity> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isPresent()) {
            pessoa.setId(id);
            pessoaRepository.save(pessoa);
        } else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

    //exercicio 09
    public void delete(Long id) {
        Optional<PessoaEntity> pessoaOptional = pessoaRepository.findById(id);

        if (pessoaOptional.isPresent()) {
            pessoaRepository.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }

    }

    //exercicio 10
    public List<PessoaEntity> filterByNameOrEmail (String filter) {
        return this.pessoaRepository.filterByNameOrEmail(filter);
    }

}
