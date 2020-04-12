package almoxarifado.etec.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import almoxarifado.etec.Model.Pedido;
import almoxarifado.etec.Repository.PedidoRepository;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public Pedido pedidoAtualizar(Long codigo, Pedido pedido) {
        Pedido pedidoSalvo = buscarPedidoPeloCodigo(codigo);
        BeanUtils.copyProperties(pedido, pedidoSalvo, "codigo");
        return pedidoRepository.save(pedidoSalvo);
    }

    public Pedido buscarPedidoPeloCodigo(Long codigo) {
        Pedido pedido = pedidoRepository.findById(codigo).orElse(null);
        return pedido;
    }
}