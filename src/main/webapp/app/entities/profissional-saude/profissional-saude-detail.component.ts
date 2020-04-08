import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IProfissionalSaude } from 'app/shared/model/profissional-saude.model';

@Component({
  selector: 'jhi-profissional-saude-detail',
  templateUrl: './profissional-saude-detail.component.html'
})
export class ProfissionalSaudeDetailComponent implements OnInit {
  profissionalSaude: IProfissionalSaude | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ profissionalSaude }) => (this.profissionalSaude = profissionalSaude));
  }

  previousState(): void {
    window.history.back();
  }
}
