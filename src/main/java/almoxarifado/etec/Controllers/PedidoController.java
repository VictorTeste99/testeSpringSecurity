package almoxarifado.etec.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import almoxarifado.etec.Model.Pedido;
import almoxarifado.etec.Model.Professor;
import almoxarifado.etec.Repository.PedidoRepository;
import almoxarifado.etec.Service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<?> listarPedido() {
        List<Pedido> pedido = pedidoRepository.findAll();
        return ResponseEntity.ok(pedido);
    }

    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@Valid @RequestBody Pedido pedido) {
        Pedido salvo = pedidoRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pedido> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pedido pedido) {
        System.out.println(pedido + "<<<abc");
        Pedido pedidoSalvo = pedidoService.pedidoAtualizar(codigo, pedido);
        return ResponseEntity.ok(pedidoSalvo);
    }
}