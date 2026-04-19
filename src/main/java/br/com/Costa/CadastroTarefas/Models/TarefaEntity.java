package br.com.Costa.CadastroTarefas.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.UUID;


@Entity
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarefaEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String titulo;
        private String descricao;
        private String status;
        private Date data;


}
