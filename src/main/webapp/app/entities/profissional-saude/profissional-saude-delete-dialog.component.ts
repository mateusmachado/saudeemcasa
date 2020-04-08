import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IProfissionalSaude } from 'app/shared/model/profissional-saude.model';
import { ProfissionalSaudeService } from './profissional-saude.service';

@Component({
  templateUrl: './profissional-saude-delete-dialog.component.html'
})
export class ProfissionalSaudeDeleteDialogComponent {
  profissionalSaude?: IProfissionalSaude;

  constructor(
    protected profissionalSaudeService: ProfissionalSaudeService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.profissionalSaudeService.delete(id).subscribe(() => {
      this.eventManager.broadcast('profissionalSaudeListModification');
      this.activeModal.close();
    });
  }
}
