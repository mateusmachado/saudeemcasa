package com.saude.web.rest;

import com.saude.domain.ProfissionalSaude;
import com.saude.repository.ProfissionalSaudeRepository;
import com.saude.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.saude.domain.ProfissionalSaude}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ProfissionalSaudeResource {

    private final Logger log = LoggerFactory.getLogger(ProfissionalSaudeResource.class);

    private static final String ENTITY_NAME = "profissionalSaude";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProfissionalSaudeRepository profissionalSaudeRepository;

    public ProfissionalSaudeResource(ProfissionalSaudeRepository profissionalSaudeRepository) {
        this.profissionalSaudeRepository = profissionalSaudeRepository;
    }

    /**
     * {@code POST  /profissional-saudes} : Create a new profissionalSaude.
     *
     * @param profissionalSaude the profissionalSaude to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new profissionalSaude, or with status {@code 400 (Bad Request)} if the profissionalSaude has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/profissional-saudes")
    public ResponseEntity<ProfissionalSaude> createProfissionalSaude(@RequestBody ProfissionalSaude profissionalSaude) throws URISyntaxException {
        log.debug("REST request to save ProfissionalSaude : {}", profissionalSaude);
        if (profissionalSaude.getId() != null) {
            throw new BadRequestAlertException("A new profissionalSaude cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ProfissionalSaude result = profissionalSaudeRepository.save(profissionalSaude);
        return ResponseEntity.created(new URI("/api/profissional-saudes/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /profissional-saudes} : Updates an existing profissionalSaude.
     *
     * @param profissionalSaude the profissionalSaude to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated profissionalSaude,
     * or with status {@code 400 (Bad Request)} if the profissionalSaude is not valid,
     * or with status {@code 500 (Internal Server Error)} if the profissionalSaude couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/profissional-saudes")
    public ResponseEntity<ProfissionalSaude> updateProfissionalSaude(@RequestBody ProfissionalSaude profissionalSaude) throws URISyntaxException {
        log.debug("REST request to update ProfissionalSaude : {}", profissionalSaude);
        if (profissionalSaude.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ProfissionalSaude result = profissionalSaudeRepository.save(profissionalSaude);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, profissionalSaude.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /profissional-saudes} : get all the profissionalSaudes.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of profissionalSaudes in body.
     */
    @GetMapping("/profissional-saudes")
    public List<ProfissionalSaude> getAllProfissionalSaudes() {
        log.debug("REST request to get all ProfissionalSaudes");
        return profissionalSaudeRepository.findAll();
    }

    /**
     * {@code GET  /profissional-saudes/:id} : get the "id" profissionalSaude.
     *
     * @param id the id of the profissionalSaude to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the profissionalSaude, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/profissional-saudes/{id}")
    public ResponseEntity<ProfissionalSaude> getProfissionalSaude(@PathVariable Long id) {
        log.debug("REST request to get ProfissionalSaude : {}", id);
        Optional<ProfissionalSaude> profissionalSaude = profissionalSaudeRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(profissionalSaude);
    }

    /**
     * {@code DELETE  /profissional-saudes/:id} : delete the "id" profissionalSaude.
     *
     * @param id the id of the profissionalSaude to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/profissional-saudes/{id}")
    public ResponseEntity<Void> deleteProfissionalSaude(@PathVariable Long id) {
        log.debug("REST request to delete ProfissionalSaude : {}", id);
        profissionalSaudeRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
