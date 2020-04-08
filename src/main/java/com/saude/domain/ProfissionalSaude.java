package com.saude.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Objects;
import java.time.Instant;

/**
 * A ProfissionalSaude.
 */
@Entity
@Table(name = "profissional_saude")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProfissionalSaude implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "nome_completo")
    private String nomeCompleto;

    @Column(name = "data_nascimento")
    private Instant dataNascimento;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Column(name = "nome_pai")
    private String nomePai;

    @Column(name = "nacionalidade")
    private String nacionalidade;

    @Column(name = "rg_rne")
    private String rgRne;

    @Column(name = "orga_expedidor_uf")
    private String orgaExpedidorUf;

    @Column(name = "cpf")
    private Integer cpf;

    @Column(name = "estado_civil")
    private String estadoCivil;

    @Column(name = "pis_pasep")
    private Integer pisPasep;

    @Column(name = "profissao_area_atuacao")
    private String profissaoAreaAtuacao;

    @Column(name = "numero_registro_profissional")
    private Integer numeroRegistroProfissional;

    @Column(name = "uf")
    private String uf;

    @Column(name = "rqe_comprovante_especializacao")
    private String rqeComprovanteEspecializacao;

    @Column(name = "comprovante_residencia_medica")
    private String comprovanteResidenciaMedica;

    @Column(name = "numero_cartao_sus")
    private Integer numeroCartaoSus;

    @Column(name = "endereco_residencial_comercial")
    private String enderecoResidencialComercial;

    @Column(name = "numero")
    private Integer numero;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "bairro")
    private String bairro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "cep")
    private Integer cep;

    @Column(name = "telefone_fixo")
    private Integer telefoneFixo;

    @Column(name = "celular")
    private Integer celular;

    @Column(name = "data_cadastro")
    private Instant dataCadastro;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public ProfissionalSaude email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public ProfissionalSaude nomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
        return this;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public Instant getDataNascimento() {
        return dataNascimento;
    }

    public ProfissionalSaude dataNascimento(Instant dataNascimento) {
        this.dataNascimento = dataNascimento;
        return this;
    }

    public void setDataNascimento(Instant dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public ProfissionalSaude nomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
        return this;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNomePai() {
        return nomePai;
    }

    public ProfissionalSaude nomePai(String nomePai) {
        this.nomePai = nomePai;
        return this;
    }

    public void setNomePai(String nomePai) {
        this.nomePai = nomePai;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public ProfissionalSaude nacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
        return this;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getRgRne() {
        return rgRne;
    }

    public ProfissionalSaude rgRne(String rgRne) {
        this.rgRne = rgRne;
        return this;
    }

    public void setRgRne(String rgRne) {
        this.rgRne = rgRne;
    }

    public String getOrgaExpedidorUf() {
        return orgaExpedidorUf;
    }

    public ProfissionalSaude orgaExpedidorUf(String orgaExpedidorUf) {
        this.orgaExpedidorUf = orgaExpedidorUf;
        return this;
    }

    public void setOrgaExpedidorUf(String orgaExpedidorUf) {
        this.orgaExpedidorUf = orgaExpedidorUf;
    }

    public Integer getCpf() {
        return cpf;
    }

    public ProfissionalSaude cpf(Integer cpf) {
        this.cpf = cpf;
        return this;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public ProfissionalSaude estadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
        return this;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getPisPasep() {
        return pisPasep;
    }

    public ProfissionalSaude pisPasep(Integer pisPasep) {
        this.pisPasep = pisPasep;
        return this;
    }

    public void setPisPasep(Integer pisPasep) {
        this.pisPasep = pisPasep;
    }

    public String getProfissaoAreaAtuacao() {
        return profissaoAreaAtuacao;
    }

    public ProfissionalSaude profissaoAreaAtuacao(String profissaoAreaAtuacao) {
        this.profissaoAreaAtuacao = profissaoAreaAtuacao;
        return this;
    }

    public void setProfissaoAreaAtuacao(String profissaoAreaAtuacao) {
        this.profissaoAreaAtuacao = profissaoAreaAtuacao;
    }

    public Integer getNumeroRegistroProfissional() {
        return numeroRegistroProfissional;
    }

    public ProfissionalSaude numeroRegistroProfissional(Integer numeroRegistroProfissional) {
        this.numeroRegistroProfissional = numeroRegistroProfissional;
        return this;
    }

    public void setNumeroRegistroProfissional(Integer numeroRegistroProfissional) {
        this.numeroRegistroProfissional = numeroRegistroProfissional;
    }

    public String getUf() {
        return uf;
    }

    public ProfissionalSaude uf(String uf) {
        this.uf = uf;
        return this;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getRqeComprovanteEspecializacao() {
        return rqeComprovanteEspecializacao;
    }

    public ProfissionalSaude rqeComprovanteEspecializacao(String rqeComprovanteEspecializacao) {
        this.rqeComprovanteEspecializacao = rqeComprovanteEspecializacao;
        return this;
    }

    public void setRqeComprovanteEspecializacao(String rqeComprovanteEspecializacao) {
        this.rqeComprovanteEspecializacao = rqeComprovanteEspecializacao;
    }

    public String getComprovanteResidenciaMedica() {
        return comprovanteResidenciaMedica;
    }

    public ProfissionalSaude comprovanteResidenciaMedica(String comprovanteResidenciaMedica) {
        this.comprovanteResidenciaMedica = comprovanteResidenciaMedica;
        return this;
    }

    public void setComprovanteResidenciaMedica(String comprovanteResidenciaMedica) {
        this.comprovanteResidenciaMedica = comprovanteResidenciaMedica;
    }

    public Integer getNumeroCartaoSus() {
        return numeroCartaoSus;
    }

    public ProfissionalSaude numeroCartaoSus(Integer numeroCartaoSus) {
        this.numeroCartaoSus = numeroCartaoSus;
        return this;
    }

    public void setNumeroCartaoSus(Integer numeroCartaoSus) {
        this.numeroCartaoSus = numeroCartaoSus;
    }

    public String getEnderecoResidencialComercial() {
        return enderecoResidencialComercial;
    }

    public ProfissionalSaude enderecoResidencialComercial(String enderecoResidencialComercial) {
        this.enderecoResidencialComercial = enderecoResidencialComercial;
        return this;
    }

    public void setEnderecoResidencialComercial(String enderecoResidencialComercial) {
        this.enderecoResidencialComercial = enderecoResidencialComercial;
    }

    public Integer getNumero() {
        return numero;
    }

    public ProfissionalSaude numero(Integer numero) {
        this.numero = numero;
        return this;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public ProfissionalSaude complemento(String complemento) {
        this.complemento = complemento;
        return this;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public ProfissionalSaude bairro(String bairro) {
        this.bairro = bairro;
        return this;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public ProfissionalSaude cidade(String cidade) {
        this.cidade = cidade;
        return this;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getCep() {
        return cep;
    }

    public ProfissionalSaude cep(Integer cep) {
        this.cep = cep;
        return this;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public Integer getTelefoneFixo() {
        return telefoneFixo;
    }

    public ProfissionalSaude telefoneFixo(Integer telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
        return this;
    }

    public void setTelefoneFixo(Integer telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public Integer getCelular() {
        return celular;
    }

    public ProfissionalSaude celular(Integer celular) {
        this.celular = celular;
        return this;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public Instant getDataCadastro() {
        return dataCadastro;
    }

    public ProfissionalSaude dataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
        return this;
    }

    public void setDataCadastro(Instant dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProfissionalSaude)) {
            return false;
        }
        return id != null && id.equals(((ProfissionalSaude) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ProfissionalSaude{" +
            "id=" + getId() +
            ", email='" + getEmail() + "'" +
            ", nomeCompleto='" + getNomeCompleto() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            ", nomeMae='" + getNomeMae() + "'" +
            ", nomePai='" + getNomePai() + "'" +
            ", nacionalidade='" + getNacionalidade() + "'" +
            ", rgRne='" + getRgRne() + "'" +
            ", orgaExpedidorUf='" + getOrgaExpedidorUf() + "'" +
            ", cpf=" + getCpf() +
            ", estadoCivil='" + getEstadoCivil() + "'" +
            ", pisPasep=" + getPisPasep() +
            ", profissaoAreaAtuacao='" + getProfissaoAreaAtuacao() + "'" +
            ", numeroRegistroProfissional=" + getNumeroRegistroProfissional() +
            ", uf='" + getUf() + "'" +
            ", rqeComprovanteEspecializacao='" + getRqeComprovanteEspecializacao() + "'" +
            ", comprovanteResidenciaMedica='" + getComprovanteResidenciaMedica() + "'" +
            ", numeroCartaoSus=" + getNumeroCartaoSus() +
            ", enderecoResidencialComercial='" + getEnderecoResidencialComercial() + "'" +
            ", numero=" + getNumero() +
            ", complemento='" + getComplemento() + "'" +
            ", bairro='" + getBairro() + "'" +
            ", cidade='" + getCidade() + "'" +
            ", cep=" + getCep() +
            ", telefoneFixo=" + getTelefoneFixo() +
            ", celular=" + getCelular() +
            ", dataCadastro='" + getDataCadastro() + "'" +
            "}";
    }
}
