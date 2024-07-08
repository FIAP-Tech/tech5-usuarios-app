package br.com.fiap.clientes.domain.repository;

import br.com.fiap.clientes.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNomeIgnoreCaseContaining(String nome);
}
