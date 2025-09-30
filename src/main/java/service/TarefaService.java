package service;

import model.Tarefa;
import org.springframework.stereotype.Service;
import repository.TarefaRepository;
import repository.UserRepository;

import java.util.List;

@Service
public class TarefaService {
    private final TarefaService tarefaService;
    private final UserRepository userRepository;

    public TarefaService (TarefaService tarefaService , UserRepository userRepository) {
        this.tarefaService=tarefaService;
        this.userRepository=userRepository;
    }


    }






