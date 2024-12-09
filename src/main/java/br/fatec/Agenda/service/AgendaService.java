package br.fatec.Agenda.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.Agenda.dto.AgendaResponce;
import br.fatec.Agenda.entities.Agenda;
import br.fatec.Agenda.mappers.AgendaMapper;
import br.fatec.Agenda.repositories.AgendaRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class AgendaService {
    
    @Autowired
    private AgendaRepository repository;


    public List<AgendaResponce> getAgenda(){
        List<Agenda> agendas = repository.findAll();
        return agendas.stream().map(a -> AgendaMapper.toDTO(a)).collect(Collectors.toList());
    }
    

    public AgendaResponce getAgendaById(long id){
        Agenda agenda = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Agenda não cadastrada")
        );
        return AgendaMapper.toDTO(agenda);
    }
}