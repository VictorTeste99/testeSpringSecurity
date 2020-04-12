package almoxarifado.etec.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import almoxarifado.etec.Model.Professor;

import almoxarifado.etec.Repository.ProfessorRepository;
import almoxarifado.etec.Service.ProfessorService;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    ProfessorRepository professorRepository;

    @Autowired
    ProfessorService professorService;

    @GetMapping
    public ResponseEntity<?> listarProfessor() {
        List<Professor> professor = professorRepository.findAll();
        return ResponseEntity.ok(professor);
    }

    @PostMapping
    public ResponseEntity<Professor> criarProfessor(@Valid @RequestBody Professor professor) {
        Professor salvo = professorRepository.save(professor);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvo);
    }

    @PutMapping("/{codigo}")
    // @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Professor> atualizar(@PathVariable Long codigo, @Valid @RequestBody Professor professor) {
        Professor pedidoSalvo = professorService.professorAtualizar(codigo, professor);
        return ResponseEntity.ok(pedidoSalvo);
    }
}