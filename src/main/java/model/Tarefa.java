package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Spring titulo;
    private String descrição;
    private ZonedDateTime prazo;

    // Muitas tarefas podem pertencer a um usuário
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
