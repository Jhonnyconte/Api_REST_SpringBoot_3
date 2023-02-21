package med.voll.api.domain.consulta.validacoes.agendador;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsultas{
    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        //escolha do medico é opcional
        if(dados.idMedico()==null){
            return;
        }

        var medicoEstaAtivo = repository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendade com medico excluido");
        }
    }
}
