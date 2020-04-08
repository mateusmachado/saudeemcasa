import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IProfissionalSaude, ProfissionalSaude } from 'app/shared/model/profissional-saude.model';
import { ProfissionalSaudeService } from './profissional-saude.service';

@Component({
  selector: 'jhi-profissional-saude-update',
  templateUrl: './profissional-saude-update.component.html'
})
export class ProfissionalSaudeUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    email: [],
    nomeCompleto: [],
    dataNascimento: [],
    nomeMae: [],
    nomePai: [],
    nacionalidade: [],
    rgRne: [],
    orgaExpedidorUf: [],
    cpf: [],
    estadoCivil: [],
    pisPasep: [],
    profissaoAreaAtuacao: [],
    numeroRegistroProfissional: [],
    uf: [],
    rqeComprovanteEspecializacao: [],
    comprovanteResidenciaMedica: [],
    numeroCartaoSus: [],
    enderecoResidencialComercial: [],
    numero: [],
    complemento: [],
    bairro: [],
    cidade: [],
    cep: [],
    telefoneFixo: [],
    celular: [],
    dataCadastro: []
  });

  constructor(
    protected profissionalSaudeService: ProfissionalSaudeService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ profissionalSaude }) => {
      if (!profissionalSaude.id) {
        const today = moment().startOf('day');
        profissionalSaude.dataNascimento = today;
        profissionalSaude.dataCadastro = today;
      }

      this.updateForm(profissionalSaude);
    });
  }

  updateForm(profissionalSaude: IProfissionalSaude): void {
    this.editForm.patchValue({
      id: profissionalSaude.id,
      email: profissionalSaude.email,
      nomeCompleto: profissionalSaude.nomeCompleto,
      dataNascimento: profissionalSaude.dataNascimento ? profissionalSaude.dataNascimento.format(DATE_TIME_FORMAT) : null,
      nomeMae: profissionalSaude.nomeMae,
      nomePai: profissionalSaude.nomePai,
      nacionalidade: profissionalSaude.nacionalidade,
      rgRne: profissionalSaude.rgRne,
      orgaExpedidorUf: profissionalSaude.orgaExpedidorUf,
      cpf: profissionalSaude.cpf,
      estadoCivil: profissionalSaude.estadoCivil,
      pisPasep: profissionalSaude.pisPasep,
      profissaoAreaAtuacao: profissionalSaude.profissaoAreaAtuacao,
      numeroRegistroProfissional: profissionalSaude.numeroRegistroProfissional,
      uf: profissionalSaude.uf,
      rqeComprovanteEspecializacao: profissionalSaude.rqeComprovanteEspecializacao,
      comprovanteResidenciaMedica: profissionalSaude.comprovanteResidenciaMedica,
      numeroCartaoSus: profissionalSaude.numeroCartaoSus,
      enderecoResidencialComercial: profissionalSaude.enderecoResidencialComercial,
      numero: profissionalSaude.numero,
      complemento: profissionalSaude.complemento,
      bairro: profissionalSaude.bairro,
      cidade: profissionalSaude.cidade,
      cep: profissionalSaude.cep,
      telefoneFixo: profissionalSaude.telefoneFixo,
      celular: profissionalSaude.celular,
      dataCadastro: profissionalSaude.dataCadastro ? profissionalSaude.dataCadastro.format(DATE_TIME_FORMAT) : null
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const profissionalSaude = this.createFromForm();
    if (profissionalSaude.id !== undefined) {
      this.subscribeToSaveResponse(this.profissionalSaudeService.update(profissionalSaude));
    } else {
      this.subscribeToSaveResponse(this.profissionalSaudeService.create(profissionalSaude));
    }
  }

  private createFromForm(): IProfissionalSaude {
    return {
      ...new ProfissionalSaude(),
      id: this.editForm.get(['id'])!.value,
      email: this.editForm.get(['email'])!.value,
      nomeCompleto: this.editForm.get(['nomeCompleto'])!.value,
      dataNascimento: this.editForm.get(['dataNascimento'])!.value
        ? moment(this.editForm.get(['dataNascimento'])!.value, DATE_TIME_FORMAT)
        : undefined,
      nomeMae: this.editForm.get(['nomeMae'])!.value,
      nomePai: this.editForm.get(['nomePai'])!.value,
      nacionalidade: this.editForm.get(['nacionalidade'])!.value,
      rgRne: this.editForm.get(['rgRne'])!.value,
      orgaExpedidorUf: this.editForm.get(['orgaExpedidorUf'])!.value,
      cpf: this.editForm.get(['cpf'])!.value,
      estadoCivil: this.editForm.get(['estadoCivil'])!.value,
      pisPasep: this.editForm.get(['pisPasep'])!.value,
      profissaoAreaAtuacao: this.editForm.get(['profissaoAreaAtuacao'])!.value,
      numeroRegistroProfissional: this.editForm.get(['numeroRegistroProfissional'])!.value,
      uf: this.editForm.get(['uf'])!.value,
      rqeComprovanteEspecializacao: this.editForm.get(['rqeComprovanteEspecializacao'])!.value,
      comprovanteResidenciaMedica: this.editForm.get(['comprovanteResidenciaMedica'])!.value,
      numeroCartaoSus: this.editForm.get(['numeroCartaoSus'])!.value,
      enderecoResidencialComercial: this.editForm.get(['enderecoResidencialComercial'])!.value,
      numero: this.editForm.get(['numero'])!.value,
      complemento: this.editForm.get(['complemento'])!.value,
      bairro: this.editForm.get(['bairro'])!.value,
      cidade: this.editForm.get(['cidade'])!.value,
      cep: this.editForm.get(['cep'])!.value,
      telefoneFixo: this.editForm.get(['telefoneFixo'])!.value,
      celular: this.editForm.get(['celular'])!.value,
      dataCadastro: this.editForm.get(['dataCadastro'])!.value
        ? moment(this.editForm.get(['dataCadastro'])!.value, DATE_TIME_FORMAT)
        : undefined
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IProfissionalSaude>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }
}
