package br.fatec.Agenda.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.Agenda.entities.Agenda;

public interface AgendaRepository extends JpaRepository<Agenda, Long>{
    
}
