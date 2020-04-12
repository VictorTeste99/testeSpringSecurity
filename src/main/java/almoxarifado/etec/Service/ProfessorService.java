package almoxarifado.etec.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import almoxarifado.etec.Model.Professor;
import almoxarifado.etec.Repository.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository professorRepository;

    public Professor professorAtualizar(Long codigo, Professor pedido) {
        Professor pedidoSalvo = buscarProfessorPeloCodigo(codigo);
        BeanUtils.copyProperties(pedido, pedidoSalvo, "codigo");
        return professorRepository.save(pedidoSalvo);
    }

    public Professor buscarProfessorPeloCodigo(Long codigo) {
        Professor pedido = professorRepository.findById(codigo).orElse(null);
        return pedido;
    }
}