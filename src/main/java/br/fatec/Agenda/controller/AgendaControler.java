package br.fatec.Agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.Agenda.dto.AgendaResponce;
import br.fatec.Agenda.service.AgendaService;

@RestController
@RequestMapping("agendas")
public class AgendaControler {
    
    @Autowired
    private AgendaService service;

    @GetMapping
    public ResponseEntity<List<AgendaResponce>>getAgenda(){
        return ResponseEntity.ok(this.service.getAgenda());
    }
}
