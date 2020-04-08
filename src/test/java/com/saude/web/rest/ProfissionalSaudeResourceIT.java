package com.saude.web.rest;

import com.saude.RedisTestContainerExtension;
import com.saude.SaudeemcasaApp;
import com.saude.domain.ProfissionalSaude;
import com.saude.repository.ProfissionalSaudeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ProfissionalSaudeResource} REST controller.
 */
@SpringBootTest(classes = SaudeemcasaApp.class)
@ExtendWith({ RedisTestContainerExtension.class, MockitoExtension.class })
@AutoConfigureMockMvc
@WithMockUser
public class ProfissionalSaudeResourceIT {

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final String DEFAULT_NOME_COMPLETO = "AAAAAAAAAA";
    private static final String UPDATED_NOME_COMPLETO = "BBBBBBBBBB";

    private static final Instant DEFAULT_DATA_NASCIMENTO = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATA_NASCIMENTO = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_NOME_MAE = "AAAAAAAAAA";
    private static final String UPDATED_NOME_MAE = "BBBBBBBBBB";

    private static final String DEFAULT_NOME_PAI = "AAAAAAAAAA";
    private static final String UPDATED_NOME_PAI = "BBBBBBBBBB";

    private static final String DEFAULT_NACIONALIDADE = "AAAAAAAAAA";
    private static final String UPDATED_NACIONALIDADE = "BBBBBBBBBB";

    private static final String DEFAULT_RG_RNE = "AAAAAAAAAA";
    private static final String UPDATED_RG_RNE = "BBBBBBBBBB";

    private static final String DEFAULT_ORGA_EXPEDIDOR_UF = "AAAAAAAAAA";
    private static final String UPDATED_ORGA_EXPEDIDOR_UF = "BBBBBBBBBB";

    private static final Integer DEFAULT_CPF = 1;
    private static final Integer UPDATED_CPF = 2;

    private static final String DEFAULT_ESTADO_CIVIL = "AAAAAAAAAA";
    private static final String UPDATED_ESTADO_CIVIL = "BBBBBBBBBB";

    private static final Integer DEFAULT_PIS_PASEP = 1;
    private static final Integer UPDATED_PIS_PASEP = 2;

    private static final String DEFAULT_PROFISSAO_AREA_ATUACAO = "AAAAAAAAAA";
    private static final String UPDATED_PROFISSAO_AREA_ATUACAO = "BBBBBBBBBB";

    private static final Integer DEFAULT_NUMERO_REGISTRO_PROFISSIONAL = 1;
    private static final Integer UPDATED_NUMERO_REGISTRO_PROFISSIONAL = 2;

    private static final String DEFAULT_UF = "AAAAAAAAAA";
    private static final String UPDATED_UF = "BBBBBBBBBB";

    private static final String DEFAULT_RQE_COMPROVANTE_ESPECIALIZACAO = "AAAAAAAAAA";
    private static final String UPDATED_RQE_COMPROVANTE_ESPECIALIZACAO = "BBBBBBBBBB";

    private static final String DEFAULT_COMPROVANTE_RESIDENCIA_MEDICA = "AAAAAAAAAA";
    private static final String UPDATED_COMPROVANTE_RESIDENCIA_MEDICA = "BBBBBBBBBB";

    private static final Integer DEFAULT_NUMERO_CARTAO_SUS = 1;
    private static final Integer UPDATED_NUMERO_CARTAO_SUS = 2;

    private static final String DEFAULT_ENDERECO_RESIDENCIAL_COMERCIAL = "AAAAAAAAAA";
    private static final String UPDATED_ENDERECO_RESIDENCIAL_COMERCIAL = "BBBBBBBBBB";

    private static final Integer DEFAULT_NUMERO = 1;
    private static final Integer UPDATED_NUMERO = 2;

    private static final String DEFAULT_COMPLEMENTO = "AAAAAAAAAA";
    private static final String UPDATED_COMPLEMENTO = "BBBBBBBBBB";

    private static final String DEFAULT_BAIRRO = "AAAAAAAAAA";
    private static final String UPDATED_BAIRRO = "BBBBBBBBBB";

    private static final String DEFAULT_CIDADE = "AAAAAAAAAA";
    private static final String UPDATED_CIDADE = "BBBBBBBBBB";

    private static final Integer DEFAULT_CEP = 1;
    private static final Integer UPDATED_CEP = 2;

    private static final Integer DEFAULT_TELEFONE_FIXO = 1;
    private static final Integer UPDATED_TELEFONE_FIXO = 2;

    private static final Integer DEFAULT_CELULAR = 1;
    private static final Integer UPDATED_CELULAR = 2;

    private static final Instant DEFAULT_DATA_CADASTRO = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_DATA_CADASTRO = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private ProfissionalSaudeRepository profissionalSaudeRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restProfissionalSaudeMockMvc;

    private ProfissionalSaude profissionalSaude;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ProfissionalSaude createEntity(EntityManager em) {
        ProfissionalSaude profissionalSaude = new ProfissionalSaude()
            .email(DEFAULT_EMAIL)
            .nomeCompleto(DEFAULT_NOME_COMPLETO)
            .dataNascimento(DEFAULT_DATA_NASCIMENTO)
            .nomeMae(DEFAULT_NOME_MAE)
            .nomePai(DEFAULT_NOME_PAI)
            .nacionalidade(DEFAULT_NACIONALIDADE)
            .rgRne(DEFAULT_RG_RNE)
            .orgaExpedidorUf(DEFAULT_ORGA_EXPEDIDOR_UF)
            .cpf(DEFAULT_CPF)
            .estadoCivil(DEFAULT_ESTADO_CIVIL)
            .pisPasep(DEFAULT_PIS_PASEP)
            .profissaoAreaAtuacao(DEFAULT_PROFISSAO_AREA_ATUACAO)
            .numeroRegistroProfissional(DEFAULT_NUMERO_REGISTRO_PROFISSIONAL)
            .uf(DEFAULT_UF)
            .rqeComprovanteEspecializacao(DEFAULT_RQE_COMPROVANTE_ESPECIALIZACAO)
            .comprovanteResidenciaMedica(DEFAULT_COMPROVANTE_RESIDENCIA_MEDICA)
            .numeroCartaoSus(DEFAULT_NUMERO_CARTAO_SUS)
            .enderecoResidencialComercial(DEFAULT_ENDERECO_RESIDENCIAL_COMERCIAL)
            .numero(DEFAULT_NUMERO)
            .complemento(DEFAULT_COMPLEMENTO)
            .bairro(DEFAULT_BAIRRO)
            .cidade(DEFAULT_CIDADE)
            .cep(DEFAULT_CEP)
            .telefoneFixo(DEFAULT_TELEFONE_FIXO)
            .celular(DEFAULT_CELULAR)
            .dataCadastro(DEFAULT_DATA_CADASTRO);
        return profissionalSaude;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ProfissionalSaude createUpdatedEntity(EntityManager em) {
        ProfissionalSaude profissionalSaude = new ProfissionalSaude()
            .email(UPDATED_EMAIL)
            .nomeCompleto(UPDATED_NOME_COMPLETO)
            .dataNascimento(UPDATED_DATA_NASCIMENTO)
            .nomeMae(UPDATED_NOME_MAE)
            .nomePai(UPDATED_NOME_PAI)
            .nacionalidade(UPDATED_NACIONALIDADE)
            .rgRne(UPDATED_RG_RNE)
            .orgaExpedidorUf(UPDATED_ORGA_EXPEDIDOR_UF)
            .cpf(UPDATED_CPF)
            .estadoCivil(UPDATED_ESTADO_CIVIL)
            .pisPasep(UPDATED_PIS_PASEP)
            .profissaoAreaAtuacao(UPDATED_PROFISSAO_AREA_ATUACAO)
            .numeroRegistroProfissional(UPDATED_NUMERO_REGISTRO_PROFISSIONAL)
            .uf(UPDATED_UF)
            .rqeComprovanteEspecializacao(UPDATED_RQE_COMPROVANTE_ESPECIALIZACAO)
            .comprovanteResidenciaMedica(UPDATED_COMPROVANTE_RESIDENCIA_MEDICA)
            .numeroCartaoSus(UPDATED_NUMERO_CARTAO_SUS)
            .enderecoResidencialComercial(UPDATED_ENDERECO_RESIDENCIAL_COMERCIAL)
            .numero(UPDATED_NUMERO)
            .complemento(UPDATED_COMPLEMENTO)
            .bairro(UPDATED_BAIRRO)
            .cidade(UPDATED_CIDADE)
            .cep(UPDATED_CEP)
            .telefoneFixo(UPDATED_TELEFONE_FIXO)
            .celular(UPDATED_CELULAR)
            .dataCadastro(UPDATED_DATA_CADASTRO);
        return profissionalSaude;
    }

    @BeforeEach
    public void initTest() {
        profissionalSaude = createEntity(em);
    }

    @Test
    @Transactional
    public void createProfissionalSaude() throws Exception {
        int databaseSizeBeforeCreate = profissionalSaudeRepository.findAll().size();

        // Create the ProfissionalSaude
        restProfissionalSaudeMockMvc.perform(post("/api/profissional-saudes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(profissionalSaude)))
            .andExpect(status().isCreated());

        // Validate the ProfissionalSaude in the database
        List<ProfissionalSaude> profissionalSaudeList = profissionalSaudeRepository.findAll();
        assertThat(profissionalSaudeList).hasSize(databaseSizeBeforeCreate + 1);
        ProfissionalSaude testProfissionalSaude = profissionalSaudeList.get(profissionalSaudeList.size() - 1);
        assertThat(testProfissionalSaude.getEmail()).isEqualTo(DEFAULT_EMAIL);
        assertThat(testProfissionalSaude.getNomeCompleto()).isEqualTo(DEFAULT_NOME_COMPLETO);
        assertThat(testProfissionalSaude.getDataNascimento()).isEqualTo(DEFAULT_DATA_NASCIMENTO);
        assertThat(testProfissionalSaude.getNomeMae()).isEqualTo(DEFAULT_NOME_MAE);
        assertThat(testProfissionalSaude.getNomePai()).isEqualTo(DEFAULT_NOME_PAI);
        assertThat(testProfissionalSaude.getNacionalidade()).isEqualTo(DEFAULT_NACIONALIDADE);
        assertThat(testProfissionalSaude.getRgRne()).isEqualTo(DEFAULT_RG_RNE);
        assertThat(testProfissionalSaude.getOrgaExpedidorUf()).isEqualTo(DEFAULT_ORGA_EXPEDIDOR_UF);
        assertThat(testProfissionalSaude.getCpf()).isEqualTo(DEFAULT_CPF);
        assertThat(testProfissionalSaude.getEstadoCivil()).isEqualTo(DEFAULT_ESTADO_CIVIL);
        assertThat(testProfissionalSaude.getPisPasep()).isEqualTo(DEFAULT_PIS_PASEP);
        assertThat(testProfissionalSaude.getProfissaoAreaAtuacao()).isEqualTo(DEFAULT_PROFISSAO_AREA_ATUACAO);
        assertThat(testProfissionalSaude.getNumeroRegistroProfissional()).isEqualTo(DEFAULT_NUMERO_REGISTRO_PROFISSIONAL);
        assertThat(testProfissionalSaude.getUf()).isEqualTo(DEFAULT_UF);
        assertThat(testProfissionalSaude.getRqeComprovanteEspecializacao()).isEqualTo(DEFAULT_RQE_COMPROVANTE_ESPECIALIZACAO);
        assertThat(testProfissionalSaude.getComprovanteResidenciaMedica()).isEqualTo(DEFAULT_COMPROVANTE_RESIDENCIA_MEDICA);
        assertThat(testProfissionalSaude.getNumeroCartaoSus()).isEqualTo(DEFAULT_NUMERO_CARTAO_SUS);
        assertThat(testProfissionalSaude.getEnderecoResidencialComercial()).isEqualTo(DEFAULT_ENDERECO_RESIDENCIAL_COMERCIAL);
        assertThat(testProfissionalSaude.getNumero()).isEqualTo(DEFAULT_NUMERO);
        assertThat(testProfissionalSaude.getComplemento()).isEqualTo(DEFAULT_COMPLEMENTO);
        assertThat(testProfissionalSaude.getBairro()).isEqualTo(DEFAULT_BAIRRO);
        assertThat(testProfissionalSaude.getCidade()).isEqualTo(DEFAULT_CIDADE);
        assertThat(testProfissionalSaude.getCep()).isEqualTo(DEFAULT_CEP);
        assertThat(testProfissionalSaude.getTelefoneFixo()).isEqualTo(DEFAULT_TELEFONE_FIXO);
        assertThat(testProfissionalSaude.getCelular()).isEqualTo(DEFAULT_CELULAR);
        assertThat(testProfissionalSaude.getDataCadastro()).isEqualTo(DEFAULT_DATA_CADASTRO);
    }

    @Test
    @Transactional
    public void createProfissionalSaudeWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = profissionalSaudeRepository.findAll().size();

        // Create the ProfissionalSaude with an existing ID
        profissionalSaude.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restProfissionalSaudeMockMvc.perform(post("/api/profissional-saudes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(profissionalSaude)))
            .andExpect(status().isBadRequest());

        // Validate the ProfissionalSaude in the database
        List<ProfissionalSaude> profissionalSaudeList = profissionalSaudeRepository.findAll();
        assertThat(profissionalSaudeList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllProfissionalSaudes() throws Exception {
        // Initialize the database
        profissionalSaudeRepository.saveAndFlush(profissionalSaude);

        // Get all the profissionalSaudeList
        restProfissionalSaudeMockMvc.perform(get("/api/profissional-saudes?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(profissionalSaude.getId().intValue())))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].nomeCompleto").value(hasItem(DEFAULT_NOME_COMPLETO)))
            .andExpect(jsonPath("$.[*].dataNascimento").value(hasItem(DEFAULT_DATA_NASCIMENTO.toString())))
            .andExpect(jsonPath("$.[*].nomeMae").value(hasItem(DEFAULT_NOME_MAE)))
            .andExpect(jsonPath("$.[*].nomePai").value(hasItem(DEFAULT_NOME_PAI)))
            .andExpect(jsonPath("$.[*].nacionalidade").value(hasItem(DEFAULT_NACIONALIDADE)))
            .andExpect(jsonPath("$.[*].rgRne").value(hasItem(DEFAULT_RG_RNE)))
            .andExpect(jsonPath("$.[*].orgaExpedidorUf").value(hasItem(DEFAULT_ORGA_EXPEDIDOR_UF)))
            .andExpect(jsonPath("$.[*].cpf").value(hasItem(DEFAULT_CPF)))
            .andExpect(jsonPath("$.[*].estadoCivil").value(hasItem(DEFAULT_ESTADO_CIVIL)))
            .andExpect(jsonPath("$.[*].pisPasep").value(hasItem(DEFAULT_PIS_PASEP)))
            .andExpect(jsonPath("$.[*].profissaoAreaAtuacao").value(hasItem(DEFAULT_PROFISSAO_AREA_ATUACAO)))
            .andExpect(jsonPath("$.[*].numeroRegistroProfissional").value(hasItem(DEFAULT_NUMERO_REGISTRO_PROFISSIONAL)))
            .andExpect(jsonPath("$.[*].uf").value(hasItem(DEFAULT_UF)))
            .andExpect(jsonPath("$.[*].rqeComprovanteEspecializacao").value(hasItem(DEFAULT_RQE_COMPROVANTE_ESPECIALIZACAO)))
            .andExpect(jsonPath("$.[*].comprovanteResidenciaMedica").value(hasItem(DEFAULT_COMPROVANTE_RESIDENCIA_MEDICA)))
            .andExpect(jsonPath("$.[*].numeroCartaoSus").value(hasItem(DEFAULT_NUMERO_CARTAO_SUS)))
            .andExpect(jsonPath("$.[*].enderecoResidencialComercial").value(hasItem(DEFAULT_ENDERECO_RESIDENCIAL_COMERCIAL)))
            .andExpect(jsonPath("$.[*].numero").value(hasItem(DEFAULT_NUMERO)))
            .andExpect(jsonPath("$.[*].complemento").value(hasItem(DEFAULT_COMPLEMENTO)))
            .andExpect(jsonPath("$.[*].bairro").value(hasItem(DEFAULT_BAIRRO)))
            .andExpect(jsonPath("$.[*].cidade").value(hasItem(DEFAULT_CIDADE)))
            .andExpect(jsonPath("$.[*].cep").value(hasItem(DEFAULT_CEP)))
            .andExpect(jsonPath("$.[*].telefoneFixo").value(hasItem(DEFAULT_TELEFONE_FIXO)))
            .andExpect(jsonPath("$.[*].celular").value(hasItem(DEFAULT_CELULAR)))
            .andExpect(jsonPath("$.[*].dataCadastro").value(hasItem(DEFAULT_DATA_CADASTRO.toString())));
    }
    
    @Test
    @Transactional
    public void getProfissionalSaude() throws Exception {
        // Initialize the database
        profissionalSaudeRepository.saveAndFlush(profissionalSaude);

        // Get the profissionalSaude
        restProfissionalSaudeMockMvc.perform(get("/api/profissional-saudes/{id}", profissionalSaude.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(profissionalSaude.getId().intValue()))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.nomeCompleto").value(DEFAULT_NOME_COMPLETO))
            .andExpect(jsonPath("$.dataNascimento").value(DEFAULT_DATA_NASCIMENTO.toString()))
            .andExpect(jsonPath("$.nomeMae").value(DEFAULT_NOME_MAE))
            .andExpect(jsonPath("$.nomePai").value(DEFAULT_NOME_PAI))
            .andExpect(jsonPath("$.nacionalidade").value(DEFAULT_NACIONALIDADE))
            .andExpect(jsonPath("$.rgRne").value(DEFAULT_RG_RNE))
            .andExpect(jsonPath("$.orgaExpedidorUf").value(DEFAULT_ORGA_EXPEDIDOR_UF))
            .andExpect(jsonPath("$.cpf").value(DEFAULT_CPF))
            .andExpect(jsonPath("$.estadoCivil").value(DEFAULT_ESTADO_CIVIL))
            .andExpect(jsonPath("$.pisPasep").value(DEFAULT_PIS_PASEP))
            .andExpect(jsonPath("$.profissaoAreaAtuacao").value(DEFAULT_PROFISSAO_AREA_ATUACAO))
            .andExpect(jsonPath("$.numeroRegistroProfissional").value(DEFAULT_NUMERO_REGISTRO_PROFISSIONAL))
            .andExpect(jsonPath("$.uf").value(DEFAULT_UF))
            .andExpect(jsonPath("$.rqeComprovanteEspecializacao").value(DEFAULT_RQE_COMPROVANTE_ESPECIALIZACAO))
            .andExpect(jsonPath("$.comprovanteResidenciaMedica").value(DEFAULT_COMPROVANTE_RESIDENCIA_MEDICA))
            .andExpect(jsonPath("$.numeroCartaoSus").value(DEFAULT_NUMERO_CARTAO_SUS))
            .andExpect(jsonPath("$.enderecoResidencialComercial").value(DEFAULT_ENDERECO_RESIDENCIAL_COMERCIAL))
            .andExpect(jsonPath("$.numero").value(DEFAULT_NUMERO))
            .andExpect(jsonPath("$.complemento").value(DEFAULT_COMPLEMENTO))
            .andExpect(jsonPath("$.bairro").value(DEFAULT_BAIRRO))
            .andExpect(jsonPath("$.cidade").value(DEFAULT_CIDADE))
            .andExpect(jsonPath("$.cep").value(DEFAULT_CEP))
            .andExpect(jsonPath("$.telefoneFixo").value(DEFAULT_TELEFONE_FIXO))
            .andExpect(jsonPath("$.celular").value(DEFAULT_CELULAR))
            .andExpect(jsonPath("$.dataCadastro").value(DEFAULT_DATA_CADASTRO.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingProfissionalSaude() throws Exception {
        // Get the profissionalSaude
        restProfissionalSaudeMockMvc.perform(get("/api/profissional-saudes/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateProfissionalSaude() throws Exception {
        // Initialize the database
        profissionalSaudeRepository.saveAndFlush(profissionalSaude);

        int databaseSizeBeforeUpdate = profissionalSaudeRepository.findAll().size();

        // Update the profissionalSaude
        ProfissionalSaude updatedProfissionalSaude = profissionalSaudeRepository.findById(profissionalSaude.getId()).get();
        // Disconnect from session so that the updates on updatedProfissionalSaude are not directly saved in db
        em.detach(updatedProfissionalSaude);
        updatedProfissionalSaude
            .email(UPDATED_EMAIL)
            .nomeCompleto(UPDATED_NOME_COMPLETO)
            .dataNascimento(UPDATED_DATA_NASCIMENTO)
            .nomeMae(UPDATED_NOME_MAE)
            .nomePai(UPDATED_NOME_PAI)
            .nacionalidade(UPDATED_NACIONALIDADE)
            .rgRne(UPDATED_RG_RNE)
            .orgaExpedidorUf(UPDATED_ORGA_EXPEDIDOR_UF)
            .cpf(UPDATED_CPF)
            .estadoCivil(UPDATED_ESTADO_CIVIL)
            .pisPasep(UPDATED_PIS_PASEP)
            .profissaoAreaAtuacao(UPDATED_PROFISSAO_AREA_ATUACAO)
            .numeroRegistroProfissional(UPDATED_NUMERO_REGISTRO_PROFISSIONAL)
            .uf(UPDATED_UF)
            .rqeComprovanteEspecializacao(UPDATED_RQE_COMPROVANTE_ESPECIALIZACAO)
            .comprovanteResidenciaMedica(UPDATED_COMPROVANTE_RESIDENCIA_MEDICA)
            .numeroCartaoSus(UPDATED_NUMERO_CARTAO_SUS)
            .enderecoResidencialComercial(UPDATED_ENDERECO_RESIDENCIAL_COMERCIAL)
            .numero(UPDATED_NUMERO)
            .complemento(UPDATED_COMPLEMENTO)
            .bairro(UPDATED_BAIRRO)
            .cidade(UPDATED_CIDADE)
            .cep(UPDATED_CEP)
            .telefoneFixo(UPDATED_TELEFONE_FIXO)
            .celular(UPDATED_CELULAR)
            .dataCadastro(UPDATED_DATA_CADASTRO);

        restProfissionalSaudeMockMvc.perform(put("/api/profissional-saudes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedProfissionalSaude)))
            .andExpect(status().isOk());

        // Validate the ProfissionalSaude in the database
        List<ProfissionalSaude> profissionalSaudeList = profissionalSaudeRepository.findAll();
        assertThat(profissionalSaudeList).hasSize(databaseSizeBeforeUpdate);
        ProfissionalSaude testProfissionalSaude = profissionalSaudeList.get(profissionalSaudeList.size() - 1);
        assertThat(testProfissionalSaude.getEmail()).isEqualTo(UPDATED_EMAIL);
        assertThat(testProfissionalSaude.getNomeCompleto()).isEqualTo(UPDATED_NOME_COMPLETO);
        assertThat(testProfissionalSaude.getDataNascimento()).isEqualTo(UPDATED_DATA_NASCIMENTO);
        assertThat(testProfissionalSaude.getNomeMae()).isEqualTo(UPDATED_NOME_MAE);
        assertThat(testProfissionalSaude.getNomePai()).isEqualTo(UPDATED_NOME_PAI);
        assertThat(testProfissionalSaude.getNacionalidade()).isEqualTo(UPDATED_NACIONALIDADE);
        assertThat(testProfissionalSaude.getRgRne()).isEqualTo(UPDATED_RG_RNE);
        assertThat(testProfissionalSaude.getOrgaExpedidorUf()).isEqualTo(UPDATED_ORGA_EXPEDIDOR_UF);
        assertThat(testProfissionalSaude.getCpf()).isEqualTo(UPDATED_CPF);
        assertThat(testProfissionalSaude.getEstadoCivil()).isEqualTo(UPDATED_ESTADO_CIVIL);
        assertThat(testProfissionalSaude.getPisPasep()).isEqualTo(UPDATED_PIS_PASEP);
        assertThat(testProfissionalSaude.getProfissaoAreaAtuacao()).isEqualTo(UPDATED_PROFISSAO_AREA_ATUACAO);
        assertThat(testProfissionalSaude.getNumeroRegistroProfissional()).isEqualTo(UPDATED_NUMERO_REGISTRO_PROFISSIONAL);
        assertThat(testProfissionalSaude.getUf()).isEqualTo(UPDATED_UF);
        assertThat(testProfissionalSaude.getRqeComprovanteEspecializacao()).isEqualTo(UPDATED_RQE_COMPROVANTE_ESPECIALIZACAO);
        assertThat(testProfissionalSaude.getComprovanteResidenciaMedica()).isEqualTo(UPDATED_COMPROVANTE_RESIDENCIA_MEDICA);
        assertThat(testProfissionalSaude.getNumeroCartaoSus()).isEqualTo(UPDATED_NUMERO_CARTAO_SUS);
        assertThat(testProfissionalSaude.getEnderecoResidencialComercial()).isEqualTo(UPDATED_ENDERECO_RESIDENCIAL_COMERCIAL);
        assertThat(testProfissionalSaude.getNumero()).isEqualTo(UPDATED_NUMERO);
        assertThat(testProfissionalSaude.getComplemento()).isEqualTo(UPDATED_COMPLEMENTO);
        assertThat(testProfissionalSaude.getBairro()).isEqualTo(UPDATED_BAIRRO);
        assertThat(testProfissionalSaude.getCidade()).isEqualTo(UPDATED_CIDADE);
        assertThat(testProfissionalSaude.getCep()).isEqualTo(UPDATED_CEP);
        assertThat(testProfissionalSaude.getTelefoneFixo()).isEqualTo(UPDATED_TELEFONE_FIXO);
        assertThat(testProfissionalSaude.getCelular()).isEqualTo(UPDATED_CELULAR);
        assertThat(testProfissionalSaude.getDataCadastro()).isEqualTo(UPDATED_DATA_CADASTRO);
    }

    @Test
    @Transactional
    public void updateNonExistingProfissionalSaude() throws Exception {
        int databaseSizeBeforeUpdate = profissionalSaudeRepository.findAll().size();

        // Create the ProfissionalSaude

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restProfissionalSaudeMockMvc.perform(put("/api/profissional-saudes")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(profissionalSaude)))
            .andExpect(status().isBadRequest());

        // Validate the ProfissionalSaude in the database
        List<ProfissionalSaude> profissionalSaudeList = profissionalSaudeRepository.findAll();
        assertThat(profissionalSaudeList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteProfissionalSaude() throws Exception {
        // Initialize the database
        profissionalSaudeRepository.saveAndFlush(profissionalSaude);

        int databaseSizeBeforeDelete = profissionalSaudeRepository.findAll().size();

        // Delete the profissionalSaude
        restProfissionalSaudeMockMvc.perform(delete("/api/profissional-saudes/{id}", profissionalSaude.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ProfissionalSaude> profissionalSaudeList = profissionalSaudeRepository.findAll();
        assertThat(profissionalSaudeList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
