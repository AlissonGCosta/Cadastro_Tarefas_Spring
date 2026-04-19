package br.com.Costa.CadastroTarefas.Controller;


import br.com.Costa.CadastroTarefas.Exception.NotFoundException;
import br.com.Costa.CadastroTarefas.Models.TarefaEntity;
import br.com.Costa.CadastroTarefas.Services.TarefaService;
import br.com.Costa.CadastroTarefas.dtos.TarefaEntityDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;



@RestController
@RequestMapping("/v1/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TarefaEntity> findAll() {
        return tarefaService.findAll();
    }

    @GetMapping("/{id}")
    public TarefaEntity findById(@PathVariable UUID id) {

        return tarefaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build()).getBody();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TarefaEntity createTarefa(@RequestBody TarefaEntityDto tarefaEntityDto) {
        return tarefaService.createTarefa(tarefaEntityDto);

    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public TarefaEntity updateTarefa(@PathVariable UUID id,
            @RequestBody TarefaEntityDto tarefaEntityDto) throws NotFoundException {
        return tarefaService.updateTarefa(tarefaEntityDto, id);
    }

}

