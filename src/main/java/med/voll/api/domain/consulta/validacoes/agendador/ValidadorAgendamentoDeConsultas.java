package med.voll.api.domain.consulta.validacoes.agendador;

import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsultas {

    void validar(DadosAgendamentoConsulta dados);
}
