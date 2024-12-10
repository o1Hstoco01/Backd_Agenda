package br.fatec.Agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.Agenda.dto.AgendaRequest;
import br.fatec.Agenda.dto.AgendaResponce;
import br.fatec.Agenda.service.AgendaService;

@CrossOrigin
@RestController
@RequestMapping("agendas")
public class AgendaControler {
    
    @Autowired
    private AgendaService service;

    @GetMapping
    public ResponseEntity<List<AgendaResponce>>getAgenda(){
        return ResponseEntity.ok(this.service.getAgenda());
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaResponce> getAgenda(@PathVariable long id){
        return ResponseEntity.ok(service.getAgendaById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAgenda(@PathVariable Long id){
        service.deleteAgendaById(id);
        return ResponseEntity.noContent().build();    
    }

    @PostMapping
    public ResponseEntity<AgendaResponce> SaveAgenda(@Validated @RequestBody AgendaRequest agenda){
        AgendaResponce newAgenda = service.save(agenda);
        return ResponseEntity.created(null).body(newAgenda);
    }

    @PutMapping ("{id}")
    public ResponseEntity<Void> updateAgenda(@PathVariable long id, @Validated @RequestBody AgendaRequest agenda){
        service.update(agenda, id);
        return ResponseEntity.ok().build();
    }
}
