package exercicios.semana10.service;

import exercicios.semana10.controller.dto.AssuntoResponse;
import exercicios.semana10.controller.dto.PerguntaResponse;
import exercicios.semana10.controller.dto.RespostaRequest;
import exercicios.semana10.controller.dto.RespostaResponse;
import exercicios.semana10.dataprovider.entity.PerguntaEntity;
import exercicios.semana10.dataprovider.entity.RespostaEntity;
import exercicios.semana10.dataprovider.repository.PerguntaRepository;
import exercicios.semana10.dataprovider.repository.RespostaRepository;
import exercicios.semana10.exception.NotFoundException;
import exercicios.semana10.exception.ServerSideException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;
    private final PerguntaRepository perguntaRepository;


    public RespostaService(RespostaRepository respostaRepository, PerguntaRepository perguntaRepository) {
        this.respostaRepository = respostaRepository;
        this.perguntaRepository = perguntaRepository;
    }

    public List<RespostaResponse> encontrarRespostas() {
        List<RespostaEntity> entityList = respostaRepository.findAll();

        List<RespostaResponse> responseList = new ArrayList<>();
        for (RespostaEntity entity : entityList) {
            responseList.add(
                    new RespostaResponse(entity.getTexto()
                            , new PerguntaResponse(entity.getPerguntaEntity().getTitulo()
                            , entity.getPerguntaEntity().getTexto()
                            , new AssuntoResponse(entity.getPerguntaEntity().getAssuntoEntity().getNome()))));
        }

        return responseList;
    }

    public RespostaResponse encontrarRespostaPorId(Long id) {
        RespostaEntity respostaEntity = respostaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Resposta não encontrada pelo id: " + id));

        return new RespostaResponse(
                        respostaEntity.getTexto()
                        , new PerguntaResponse(
                        respostaEntity.getPerguntaEntity().getTitulo()
                        , respostaEntity.getPerguntaEntity().getTexto()
                        , new AssuntoResponse(respostaEntity.getPerguntaEntity().getAssuntoEntity().getNome())

                ));
    }

    public List<RespostaResponse> encontrarRespostasPorPergunta(String id) {
        List<RespostaEntity> respostaEntities = respostaRepository.findRespostaEntitiesByPerguntaEntity_Id(Long.parseLong(id));

        List<RespostaResponse> responseList = new ArrayList<>();
        for (RespostaEntity respostaEntity:respostaEntities) {
            responseList.add(
                    new RespostaResponse(
                            respostaEntity.getTexto()
                            , new PerguntaResponse(
                            respostaEntity.getPerguntaEntity().getTitulo()
                            , respostaEntity.getPerguntaEntity().getTexto()
                            , new AssuntoResponse(respostaEntity.getPerguntaEntity().getAssuntoEntity().getNome()))
                    )
            );
        }

        if(responseList.isEmpty()) {
            throw new NotFoundException("Respostas não encontradas com pergunta de id: " + id);
        }

        return responseList;
    }

    public RespostaResponse salvarNovaResposta(RespostaRequest respostaRequest) {
        try {
            PerguntaEntity perguntaEntity = perguntaRepository.findById(respostaRequest.getIdPergunta())
                    .orElseThrow(()->new NotFoundException("Pergunta não encontrada pelo id: " + respostaRequest.getIdPergunta()));

            RespostaEntity respostaEntity = respostaRepository.save(new RespostaEntity(respostaRequest.getTexto()
                    , perguntaEntity));

            return new RespostaResponse(respostaEntity.getTexto()
                    , new PerguntaResponse(
                    respostaEntity.getPerguntaEntity().getTitulo()
                    , respostaEntity.getPerguntaEntity().getTexto()
                    , new AssuntoResponse(respostaEntity.getPerguntaEntity().getAssuntoEntity().getNome()))
            );
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerSideException("Erro ao salvar resposta, mensagem localizada: " + e.getLocalizedMessage());
        }

    }

    public RespostaResponse atualizarRespostaPorId(Long id, RespostaRequest respostaRequest) {
        try {
            PerguntaEntity perguntaEntity = perguntaRepository.findById(respostaRequest.getIdPergunta())
                    .orElseThrow(()->new NotFoundException("Pergunta não encontrada pelo id: " + respostaRequest.getIdPergunta()));

            RespostaEntity respostaEntity = respostaRepository.findById(id)
                    .orElseThrow(()->new NotFoundException("Resposta não encontrada pelo id: " + id));
            respostaEntity.setTexto(respostaRequest.getTexto());
            respostaEntity.setPerguntaEntity(perguntaEntity);
            respostaRepository.save(respostaEntity);

            return new RespostaResponse(
                    respostaEntity.getTexto()
                    , new PerguntaResponse(
                    respostaEntity.getPerguntaEntity().getTitulo()
                    , respostaEntity.getPerguntaEntity().getTexto()
                    , new AssuntoResponse(respostaEntity.getPerguntaEntity().getAssuntoEntity().getNome()))
            );
        } catch (NotFoundException e) {
            throw e;
        } catch (Exception e) {
            throw new ServerSideException("Erro ao atualizar resposta, mensagem localizada: " + e.getLocalizedMessage());
        }
    }

    public void deletarRespostaPorId(Long id) {
        respostaRepository.deleteById(id);
    }

}
