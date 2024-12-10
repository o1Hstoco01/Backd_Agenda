package br.fatec.Agenda.dto;

import jakarta.validation.constraints.NotBlank;

public record AgendaRequest( 
    
    @NotBlank(message = "Nome em branco")
    String compromisso, 
    
    @NotBlank(message = "Data em branco")
    String data, 
    
    @NotBlank(message = "Horario em branco")
    String horario, 
    
    @NotBlank(message = "Local em branco")
    String local) {
    
}
