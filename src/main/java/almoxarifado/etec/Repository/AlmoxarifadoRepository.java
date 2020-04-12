package almoxarifado.etec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import almoxarifado.etec.Model.AlmoxarifadoSetor;

public interface AlmoxarifadoRepository extends JpaRepository<AlmoxarifadoSetor, Long> {

}