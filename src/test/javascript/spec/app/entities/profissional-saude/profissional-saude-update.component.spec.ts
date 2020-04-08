import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { SaudeemcasaTestModule } from '../../../test.module';
import { ProfissionalSaudeUpdateComponent } from 'app/entities/profissional-saude/profissional-saude-update.component';
import { ProfissionalSaudeService } from 'app/entities/profissional-saude/profissional-saude.service';
import { ProfissionalSaude } from 'app/shared/model/profissional-saude.model';

describe('Component Tests', () => {
  describe('ProfissionalSaude Management Update Component', () => {
    let comp: ProfissionalSaudeUpdateComponent;
    let fixture: ComponentFixture<ProfissionalSaudeUpdateComponent>;
    let service: ProfissionalSaudeService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [SaudeemcasaTestModule],
        declarations: [ProfissionalSaudeUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(ProfissionalSaudeUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ProfissionalSaudeUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ProfissionalSaudeService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new ProfissionalSaude(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new ProfissionalSaude();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
