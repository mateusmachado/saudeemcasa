import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { IProfissionalSaude } from 'app/shared/model/profissional-saude.model';
import { ProfissionalSaudeService } from './profissional-saude.service';
import { ProfissionalSaudeDeleteDialogComponent } from './profissional-saude-delete-dialog.component';

@Component({
  selector: 'jhi-profissional-saude',
  templateUrl: './profissional-saude.component.html'
})
export class ProfissionalSaudeComponent implements OnInit, OnDestroy {
  profissionalSaudes?: IProfissionalSaude[];
  eventSubscriber?: Subscription;

  constructor(
    protected profissionalSaudeService: ProfissionalSaudeService,
    protected eventManager: JhiEventManager,
    protected modalService: NgbModal
  ) {}

  loadAll(): void {
    this.profissionalSaudeService
      .query()
      .subscribe((res: HttpResponse<IProfissionalSaude[]>) => (this.profissionalSaudes = res.body || []));
  }

  ngOnInit(): void {
    this.loadAll();
    this.registerChangeInProfissionalSaudes();
  }

  ngOnDestroy(): void {
    if (this.eventSubscriber) {
      this.eventManager.destroy(this.eventSubscriber);
    }
  }

  trackId(index: number, item: IProfissionalSaude): number {
    // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
    return item.id!;
  }

  registerChangeInProfissionalSaudes(): void {
    this.eventSubscriber = this.eventManager.subscribe('profissionalSaudeListModification', () => this.loadAll());
  }

  delete(profissionalSaude: IProfissionalSaude): void {
    const modalRef = this.modalService.open(ProfissionalSaudeDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
    modalRef.componentInstance.profissionalSaude = profissionalSaude;
  }
}
