package almoxarifado.etec.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import almoxarifado.etec.Model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}