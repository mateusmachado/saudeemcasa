import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';

import { SaudeemcasaTestModule } from '../../../test.module';
import { ProfissionalSaudeComponent } from 'app/entities/profissional-saude/profissional-saude.component';
import { ProfissionalSaudeService } from 'app/entities/profissional-saude/profissional-saude.service';
import { ProfissionalSaude } from 'app/shared/model/profissional-saude.model';

describe('Component Tests', () => {
  describe('ProfissionalSaude Management Component', () => {
    let comp: ProfissionalSaudeComponent;
    let fixture: ComponentFixture<ProfissionalSaudeComponent>;
    let service: ProfissionalSaudeService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [SaudeemcasaTestModule],
        declarations: [ProfissionalSaudeComponent]
      })
        .overrideTemplate(ProfissionalSaudeComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ProfissionalSaudeComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ProfissionalSaudeService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new ProfissionalSaude(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.profissionalSaudes && comp.profissionalSaudes[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });
  });
});
