package br.com.mentoria.repositorio;

import br.com.mentoria.servicos.entidades.Campeao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeaoRepositorio extends JpaRepository <Campeao, Long> {
}
