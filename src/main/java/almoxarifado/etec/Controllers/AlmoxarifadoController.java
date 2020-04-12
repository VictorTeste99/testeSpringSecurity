package almoxarifado.etec.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import almoxarifado.etec.Model.AlmoxarifadoSetor;


import almoxarifado.etec.Repository.AlmoxarifadoRepository;

@RestController
@RequestMapping("/almoxarifado")
public class AlmoxarifadoController {

    @Autowired
    AlmoxarifadoRepository almoxarifadoRepository;

    @GetMapping
    public ResponseEntity<?> listarAlmoxarifado() {
        List<AlmoxarifadoSetor> almoxarifado = almoxarifadoRepository.findAll();
        return ResponseEntity.ok(almoxarifado);
    }

    @PostMapping
    public ResponseEntity<AlmoxarifadoSetor> criarAlmoxarifado(@Valid @RequestBody AlmoxarifadoSetor almoxarifadoSetor) {
        AlmoxarifadoSetor salvo = almoxarifadoRepository.save(almoxarifadoSetor);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }
}