package exercicios.semana10.service;

import exercicios.semana10.controller.dto.AssuntoResponse;
import exercicios.semana10.controller.dto.PerguntaRequest;
import exercicios.semana10.controller.dto.PerguntaResponse;
import exercicios.semana10.dataprovider.entity.AssuntoEntity;
import exercicios.semana10.dataprovider.entity.PerguntaEntity;
import exercicios.semana10.dataprovider.repository.AssuntoRepository;
import exercicios.semana10.dataprovider.repository.PerguntaRepository;
import exercicios.semana10.exception.NotFoundException;
import exercicios.semana10.exception.ServerSideException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerguntaService {
    private final PerguntaRepository perguntaRepository;

    private final AssuntoRepository assuntoRepository;


    public PerguntaService(PerguntaRepository perguntaRepository, AssuntoRepository assuntoRepository) {
        this.perguntaRepository = perguntaRepository;
        this.assuntoRepository = assuntoRepository;
    }

    public List<PerguntaResponse> encontrarPerguntas() {
        List<PerguntaEntity> entityList = perguntaRepository.findAll();

        List<PerguntaResponse> responseList = new ArrayList<>();
        for (PerguntaEntity entity : entityList) {
            responseList.add(
                    new PerguntaResponse(entity.getTitulo()
                            , entity.getTexto()
                            , new AssuntoResponse(entity.getAssuntoEntity().getNome()))
            );
        }

        return responseList;
    }

    public PerguntaResponse encontrarPerguntaPorId(Long id) {
        PerguntaEntity perguntaEntity = perguntaRepository.findById(id)
                .orElseThrow(()->new NotFoundException("Pergunta não encontrada pelo id: " + id));

        return new PerguntaResponse(
                        perguntaEntity.getTitulo(),
                        perguntaEntity.getTexto(),
                        new AssuntoResponse(perguntaEntity.getAssuntoEntity().getNome()));
    }

    public List<PerguntaResponse> encontrarPerguntasPorAssunto(String id) {
        List<PerguntaEntity> perguntaEntities = perguntaRepository.findPerguntaEntitiesByAssuntoEntity_Id(Long.parseLong(id));

        List<PerguntaResponse> responseList = new ArrayList<>();
        for (PerguntaEntity entity : perguntaEntities) {
            responseList.add(
                    new PerguntaResponse(entity.getTitulo()
                            , entity.getTexto()
                            , new AssuntoResponse(entity.getAssuntoEntity().getNome()))
            );
        }

        if(responseList.isEmpty()) {
            throw new NotFoundException("Perguntas não encontradas com assunto de id: " + id);
        }

        return responseList;
    }

    public PerguntaResponse salvarNovaPergunta(PerguntaRequest perguntaRequest) {
        try {
            AssuntoEntity assuntoEntity = assuntoRepository.findById(perguntaRequest.getIdAssunto())
                    .orElseThrow(()->new NotFoundException("Assunto não encontrado pelo id: " + perguntaRequest.getIdAssunto()));

            PerguntaEntity perguntaEntity = perguntaRepository.save(new PerguntaEntity(perguntaRequest.getTitulo()
                    , perguntaRequest.getTexto()
                    , assuntoEntity));

            return new PerguntaResponse(perguntaEntity.getTitulo()
                            , perguntaEntity.getTexto()
                            , new AssuntoResponse(perguntaEntity.getAssuntoEntity().getNome())
            );
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerSideException("Erro ao salvar pergunta, mensagem localizada: " + e.getLocalizedMessage());
        }

    }

    public PerguntaResponse atualizarPerguntaPorId(Long id, PerguntaRequest perguntaRequest) {
        try {
            AssuntoEntity assuntoEntity = assuntoRepository.findById(perguntaRequest.getIdAssunto())
                    .orElseThrow(()->new NotFoundException("Assunto não encontrado pelo id: " + perguntaRequest.getIdAssunto()));

            PerguntaEntity perguntaEntity = perguntaRepository.findById(id)
                    .orElseThrow(()->new NotFoundException("Pergunta não encontrada pelo id: " + id));
            perguntaEntity.setTitulo(perguntaRequest.getTitulo());
            perguntaEntity.setTexto(perguntaRequest.getTexto());
            perguntaEntity.setAssuntoEntity(assuntoEntity);
            perguntaRepository.save(perguntaEntity);

            return new PerguntaResponse(perguntaEntity.getTitulo()
                            , perguntaEntity.getTexto()
                            , new AssuntoResponse(perguntaEntity.getAssuntoEntity().getNome()));

        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerSideException("Erro ao atualizar pergunta, mensagem localizada: " + e.getLocalizedMessage());
        }

    }

    public void deletarPerguntaPorId(Long id) {
        perguntaRepository.deleteById(id);
    }

}
