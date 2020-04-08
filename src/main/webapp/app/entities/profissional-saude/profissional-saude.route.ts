import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IProfissionalSaude, ProfissionalSaude } from 'app/shared/model/profissional-saude.model';
import { ProfissionalSaudeService } from './profissional-saude.service';
import { ProfissionalSaudeComponent } from './profissional-saude.component';
import { ProfissionalSaudeDetailComponent } from './profissional-saude-detail.component';
import { ProfissionalSaudeUpdateComponent } from './profissional-saude-update.component';

@Injectable({ providedIn: 'root' })
export class ProfissionalSaudeResolve implements Resolve<IProfissionalSaude> {
  constructor(private service: ProfissionalSaudeService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IProfissionalSaude> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((profissionalSaude: HttpResponse<ProfissionalSaude>) => {
          if (profissionalSaude.body) {
            return of(profissionalSaude.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new ProfissionalSaude());
  }
}

export const profissionalSaudeRoute: Routes = [
  {
    path: '',
    component: ProfissionalSaudeComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'saudeemcasaApp.profissionalSaude.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: ProfissionalSaudeDetailComponent,
    resolve: {
      profissionalSaude: ProfissionalSaudeResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'saudeemcasaApp.profissionalSaude.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: ProfissionalSaudeUpdateComponent,
    resolve: {
      profissionalSaude: ProfissionalSaudeResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'saudeemcasaApp.profissionalSaude.home.title'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: ProfissionalSaudeUpdateComponent,
    resolve: {
      profissionalSaude: ProfissionalSaudeResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'saudeemcasaApp.profissionalSaude.home.title'
    },
    canActivate: [UserRouteAccessService]
  }
];
