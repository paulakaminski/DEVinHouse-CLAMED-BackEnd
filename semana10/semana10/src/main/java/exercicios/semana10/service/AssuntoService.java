package exercicios.semana10.service;

import exercicios.semana10.controller.dto.AssuntoRequest;
import exercicios.semana10.controller.dto.AssuntoResponse;
import exercicios.semana10.dataprovider.entity.AssuntoEntity;
import exercicios.semana10.dataprovider.repository.AssuntoRepository;
import exercicios.semana10.dataprovider.repository.PerguntaRepository;
import exercicios.semana10.exception.NotFoundException;
import exercicios.semana10.exception.ServerSideException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AssuntoService {

    private final AssuntoRepository assuntoRepository;

    public AssuntoService(AssuntoRepository assuntoRepository, PerguntaRepository perguntaRepository) {
        this.assuntoRepository = assuntoRepository;
    }

    public List<AssuntoResponse> encontrarAssuntos() {

        List<AssuntoEntity> entityList = assuntoRepository.findAll();

        List<AssuntoResponse> responseList = new ArrayList<>();
        for (AssuntoEntity entity:
                entityList) {
            responseList.add(
                    new AssuntoResponse(entity.getNome())
            );
        }
        return responseList;
    }

    public AssuntoResponse encontrarAssuntoPorId(Long id) {
        AssuntoEntity assuntoEntity = assuntoRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Assunto não encontrado pelo id: " + id));

//        if(assuntoEntity == null){
//            throw new NotFoundException("Assunto não encontrado pelo id: " + id);
//        }

        return new AssuntoResponse(assuntoEntity.getNome());

    }

    public AssuntoResponse salvarNovoAssunto(AssuntoRequest assuntoRequest) {
        try {
            AssuntoEntity assuntoEntity = assuntoRepository.save(new AssuntoEntity(assuntoRequest.getNome()));
            return new AssuntoResponse(assuntoEntity.getNome());
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerSideException("Erro ao salvar assunto, mensagem localizada: " + e.getLocalizedMessage());
        }
    }

    public AssuntoResponse atualizarAssuntoPorId(Long id, AssuntoRequest assuntoRequest) {
        try {
            AssuntoEntity assuntoEntity = assuntoRepository.findById(id)
                    .orElseThrow(()->new NotFoundException("Assunto não encontrado pelo id: " + id));

            assuntoEntity.setNome(assuntoRequest.getNome());
            assuntoRepository.save(assuntoEntity);

            return new AssuntoResponse(assuntoEntity.getNome());
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerSideException("Erro ao atualizar assunto, mensagem localizada: " + e.getLocalizedMessage());
        }

    }

    public void deletarAssuntoPorId(Long id) {
        assuntoRepository.deleteById(id);
    }

}
