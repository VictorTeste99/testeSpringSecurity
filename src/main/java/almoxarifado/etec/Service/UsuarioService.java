package almoxarifado.etec.Service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import almoxarifado.etec.Model.Usuario;
import almoxarifado.etec.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario professorAtualizar(Long codigo, Usuario usuario) {
        Usuario pedidoSalvo = buscarUsuarioPeloCodigo(codigo);
        BeanUtils.copyProperties(usuario, pedidoSalvo, "codigo");
        return usuarioRepository.save(pedidoSalvo);
    }

    public Usuario buscarUsuarioPeloCodigo(Long codigo) {
        Usuario pedido = usuarioRepository.findById(codigo).orElse(null);
        return pedido;
    }
}