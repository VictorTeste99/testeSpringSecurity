package almoxarifado.etec.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import almoxarifado.etec.Model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}