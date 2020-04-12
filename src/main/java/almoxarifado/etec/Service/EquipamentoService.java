package almoxarifado.etec.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import almoxarifado.etec.Model.Equipamento;
import almoxarifado.etec.Repository.EquipamentoRepository;

@Service
public class EquipamentoService {

    @Autowired
    EquipamentoRepository equipamentoRepository;

    public Equipamento pedidoAtualizar(Long codigo, Equipamento equipamento) {
        Equipamento equipamentoSalvo = buscarEquipamentoPeloCodigo(codigo);
        BeanUtils.copyProperties(equipamento, equipamentoSalvo, "codigo");
        return equipamentoRepository.save(equipamentoSalvo);
    }

    public Equipamento buscarEquipamentoPeloCodigo(Long codigo) {
        Equipamento pedido = equipamentoRepository.findById(codigo).orElse(null);
        return pedido;
    }
}