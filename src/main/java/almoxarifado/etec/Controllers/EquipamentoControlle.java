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
import org.springframework.web.bind.annotation.RestController;

import almoxarifado.etec.Model.Equipamento;
import almoxarifado.etec.Repository.EquipamentoRepository;
import almoxarifado.etec.Service.EquipamentoService;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoControlle {

    @Autowired
    EquipamentoRepository equipamentoRepository;

    @Autowired
    EquipamentoService equipamentoService;

    @PostMapping
    public ResponseEntity<Equipamento> criarEquipamento(@Valid @RequestBody Equipamento equipamento) {
        Equipamento salvo = equipamentoRepository.save(equipamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @GetMapping
    public ResponseEntity<?> listarEquipamento() {
        List<Equipamento> equipamento = equipamentoRepository.findAll();
        return ResponseEntity.ok(equipamento);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Equipamento> atualizar(@PathVariable Long codigo,
            @Valid @RequestBody Equipamento equipamento) {
        Equipamento equipamentoSalvo = equipamentoService.pedidoAtualizar(codigo, equipamento);
        return ResponseEntity.ok(equipamentoSalvo);
    }
}