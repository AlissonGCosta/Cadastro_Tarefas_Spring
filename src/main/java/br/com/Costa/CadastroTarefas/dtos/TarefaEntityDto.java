package br.com.Costa.CadastroTarefas.dtos;

import jakarta.persistence.Entity;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class TarefaEntityDto {
    private String titulo;
    private String descricao;
    private String status;
    private Date data;

}
