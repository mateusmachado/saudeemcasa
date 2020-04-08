import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { SaudeemcasaTestModule } from '../../../test.module';
import { ProfissionalSaudeDetailComponent } from 'app/entities/profissional-saude/profissional-saude-detail.component';
import { ProfissionalSaude } from 'app/shared/model/profissional-saude.model';

describe('Component Tests', () => {
  describe('ProfissionalSaude Management Detail Component', () => {
    let comp: ProfissionalSaudeDetailComponent;
    let fixture: ComponentFixture<ProfissionalSaudeDetailComponent>;
    const route = ({ data: of({ profissionalSaude: new ProfissionalSaude(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [SaudeemcasaTestModule],
        declarations: [ProfissionalSaudeDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(ProfissionalSaudeDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ProfissionalSaudeDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load profissionalSaude on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.profissionalSaude).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
