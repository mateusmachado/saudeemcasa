package com.saude.repository;

import com.saude.domain.ProfissionalSaude;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ProfissionalSaude entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProfissionalSaudeRepository extends JpaRepository<ProfissionalSaude, Long> {
}
