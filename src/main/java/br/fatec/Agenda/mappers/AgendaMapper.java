package br.fatec.Agenda.mappers;

import br.fatec.Agenda.dto.AgendaRequest;
import br.fatec.Agenda.dto.AgendaResponce;
import br.fatec.Agenda.entities.Agenda;

public class AgendaMapper {
    
    public static Agenda toEntity(AgendaRequest request){
        Agenda agenda = new Agenda();
        agenda.setCompromisso(request.compromisso());
        agenda.setData(request.data());
        agenda.setHorario(request.horario());
        agenda.setLocal(request.local());
        return agenda;
    }

    public static AgendaResponce toDTO(Agenda agenda){
        return new AgendaResponce(agenda.getId(), agenda.getCompromisso(),agenda.getData(),agenda.getHorario(),agenda.getLocal());
    }
}
