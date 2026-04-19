package br.com.Costa.CadastroTarefas.Services;

import br.com.Costa.CadastroTarefas.Exception.NotFoundException;
import br.com.Costa.CadastroTarefas.Models.TarefaEntity;
import br.com.Costa.CadastroTarefas.dtos.TarefaEntityDto;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.GenericArrayType;
import java.util.*;

@Service
public class TarefaService {


    public static Date dataGerado = new Date();

    public static UUID idGerado(){
        return UUID.randomUUID();
    }


    public static final List<TarefaEntity> Tarefas = new ArrayList<>();
    static{
        Tarefas.add(TarefaEntity.builder()
                        .id(idGerado())
                        .titulo("Fazer Tarefa Faculdade")
                        .descricao("Fazer codigos em python e ler conteudo Cientifico sobre")
                        .status("Em Andamento")
                        .data(dataGerado)
                .build());
        Tarefas.add(TarefaEntity.builder()
                .id(idGerado())
                .titulo("Trabalhar")
                .descricao("Fazer estocagem de Produtos, Limpeza e manter Organizados")
                .status("Completo")
                .data(dataGerado)
                .build());
        Tarefas.add(TarefaEntity.builder()
                .id(idGerado())
                .titulo("Lição De Casa")
                .descricao("Fazer Tarefa da Aula de interfaces")
                .status("Não Iniciada")
                .data(dataGerado)
                .build());
    }

    public  List<TarefaEntity> findAll() {
        return new ArrayList<>(Tarefas);
    }
    public  Optional<TarefaEntity> findById(UUID Id) {
        return Tarefas.stream()
                .filter(tarefa -> tarefa.getId().equals(Id))
                .findFirst();
    }

    public  TarefaEntity createTarefa(TarefaEntityDto tarefaDto) {

        TarefaEntity novaTarefa = TarefaEntity.builder()
                .id(idGerado())
                .titulo(tarefaDto.getTitulo())
                .descricao(tarefaDto.getDescricao())
                .status(tarefaDto.getStatus())
                .data(dataGerado)
        .build();

        Tarefas.add(novaTarefa);

        return novaTarefa;
    }

    public  TarefaEntity updateTarefa(TarefaEntityDto tarefaDto, UUID Id) throws NotFoundException {

        TarefaEntity novaTarefa = Tarefas.stream()
                .filter(i -> i.getId().equals(Id))
                .findAny()
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));

        novaTarefa.setTitulo(tarefaDto.getTitulo());
        novaTarefa.setDescricao(tarefaDto.getDescricao());
        novaTarefa.setStatus(tarefaDto.getStatus());

        return novaTarefa;

    }

    public void  deleteTarefa(UUID Id){
            Tarefas.removeIf(i -> i.getId().equals(Id));
    }
}
