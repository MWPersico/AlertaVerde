package br.senac.ead.alerta_verde.repositories;

import br.senac.ead.alerta_verde.entities.Denuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface DenunciaRepository extends JpaRepository<Denuncia, Integer> {
    @Query("""
        SELECT DISTINCT a
        FROM Denuncia a
        LEFT JOIN FETCH a.usuario
        LEFT JOIN FETCH a.midias
        WHERE a.id = :id
    """)
    Optional<Denuncia> findByIdWithUsuarioAndMidiaDenuncia(Integer id);

    @Query("""
        SELECT a
        FROM Denuncia a
        LEFT JOIN FETCH a.usuario
        LEFT JOIN FETCH a.midias
    """)
    List<Denuncia> findAllWithUsuarioAndMidiaDenuncia();
}
