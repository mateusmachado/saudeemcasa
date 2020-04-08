import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { SaudeemcasaSharedModule } from 'app/shared/shared.module';
import { ProfissionalSaudeComponent } from './profissional-saude.component';
import { ProfissionalSaudeDetailComponent } from './profissional-saude-detail.component';
import { ProfissionalSaudeUpdateComponent } from './profissional-saude-update.component';
import { ProfissionalSaudeDeleteDialogComponent } from './profissional-saude-delete-dialog.component';
import { profissionalSaudeRoute } from './profissional-saude.route';

@NgModule({
  imports: [SaudeemcasaSharedModule, RouterModule.forChild(profissionalSaudeRoute)],
  declarations: [
    ProfissionalSaudeComponent,
    ProfissionalSaudeDetailComponent,
    ProfissionalSaudeUpdateComponent,
    ProfissionalSaudeDeleteDialogComponent
  ],
  entryComponents: [ProfissionalSaudeDeleteDialogComponent]
})
export class SaudeemcasaProfissionalSaudeModule {}
