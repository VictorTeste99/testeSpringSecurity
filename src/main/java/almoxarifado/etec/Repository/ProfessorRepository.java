package almoxarifado.etec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import almoxarifado.etec.Model.Professor;

public interface ProfessorRepository extends JpaRepository <Professor, Long> {

}