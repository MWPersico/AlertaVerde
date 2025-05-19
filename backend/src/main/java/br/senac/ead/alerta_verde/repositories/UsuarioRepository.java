package br.senac.ead.alerta_verde.repositories;

import br.senac.ead.alerta_verde.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query("""
        SELECT DISTINCT a
        FROM Usuario a
        JOIN FETCH a.denuncias
        WHERE a.id = :id
    """)
    Optional<Usuario> findByIdWithDenuncias(Integer id);

    @Query("""
        SELECT a
        FROM Usuario a
        JOIN FETCH a.denuncias
    """)
    List<Usuario> findAllWithDenuncias();

    Optional<Usuario> findByEmail(String email);
}
