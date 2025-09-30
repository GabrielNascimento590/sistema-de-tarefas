package service;

import model.Tarefa;
import org.springframework.stereotype.Service;
import repository.TarefaRepository;

import java.util.List;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    public List<Tarefa> getAll() {
        return tarefaRepository.findAll();
    }

    public Tarefa getById(Long id) {
        return tarefaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
    }

    public Tarefa create(Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }

    public Tarefa updateTarefa(Long id, Tarefa tarefaDetails) {
        Tarefa tarefa = getById(id);

        tarefa.setTitulo(tarefaDetails.getTitulo());
        tarefa.setDescrição(tarefaDetails.getDescrição());
        tarefa.setPrazo(tarefaDetails.getPrazo());
        tarefa.setUser(tarefaDetails.getUser());

        return tarefaRepository.save(tarefa);
    }

    public void delete(Long id) {
        tarefaRepository.deleteById(id);
    }

}


















