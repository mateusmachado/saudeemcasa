import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { ProfissionalSaudeService } from 'app/entities/profissional-saude/profissional-saude.service';
import { IProfissionalSaude, ProfissionalSaude } from 'app/shared/model/profissional-saude.model';

describe('Service Tests', () => {
  describe('ProfissionalSaude Service', () => {
    let injector: TestBed;
    let service: ProfissionalSaudeService;
    let httpMock: HttpTestingController;
    let elemDefault: IProfissionalSaude;
    let expectedResult: IProfissionalSaude | IProfissionalSaude[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(ProfissionalSaudeService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new ProfissionalSaude(
        0,
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        0,
        currentDate
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            dataNascimento: currentDate.format(DATE_TIME_FORMAT),
            dataCadastro: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a ProfissionalSaude', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            dataNascimento: currentDate.format(DATE_TIME_FORMAT),
            dataCadastro: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            dataNascimento: currentDate,
            dataCadastro: currentDate
          },
          returnedFromService
        );

        service.create(new ProfissionalSaude()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a ProfissionalSaude', () => {
        const returnedFromService = Object.assign(
          {
            email: 'BBBBBB',
            nomeCompleto: 'BBBBBB',
            dataNascimento: currentDate.format(DATE_TIME_FORMAT),
            nomeMae: 'BBBBBB',
            nomePai: 'BBBBBB',
            nacionalidade: 'BBBBBB',
            rgRne: 'BBBBBB',
            orgaExpedidorUf: 'BBBBBB',
            cpf: 1,
            estadoCivil: 'BBBBBB',
            pisPasep: 1,
            profissaoAreaAtuacao: 'BBBBBB',
            numeroRegistroProfissional: 1,
            uf: 'BBBBBB',
            rqeComprovanteEspecializacao: 'BBBBBB',
            comprovanteResidenciaMedica: 'BBBBBB',
            numeroCartaoSus: 1,
            enderecoResidencialComercial: 'BBBBBB',
            numero: 1,
            complemento: 'BBBBBB',
            bairro: 'BBBBBB',
            cidade: 'BBBBBB',
            cep: 1,
            telefoneFixo: 1,
            celular: 1,
            dataCadastro: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            dataNascimento: currentDate,
            dataCadastro: currentDate
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of ProfissionalSaude', () => {
        const returnedFromService = Object.assign(
          {
            email: 'BBBBBB',
            nomeCompleto: 'BBBBBB',
            dataNascimento: currentDate.format(DATE_TIME_FORMAT),
            nomeMae: 'BBBBBB',
            nomePai: 'BBBBBB',
            nacionalidade: 'BBBBBB',
            rgRne: 'BBBBBB',
            orgaExpedidorUf: 'BBBBBB',
            cpf: 1,
            estadoCivil: 'BBBBBB',
            pisPasep: 1,
            profissaoAreaAtuacao: 'BBBBBB',
            numeroRegistroProfissional: 1,
            uf: 'BBBBBB',
            rqeComprovanteEspecializacao: 'BBBBBB',
            comprovanteResidenciaMedica: 'BBBBBB',
            numeroCartaoSus: 1,
            enderecoResidencialComercial: 'BBBBBB',
            numero: 1,
            complemento: 'BBBBBB',
            bairro: 'BBBBBB',
            cidade: 'BBBBBB',
            cep: 1,
            telefoneFixo: 1,
            celular: 1,
            dataCadastro: currentDate.format(DATE_TIME_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            dataNascimento: currentDate,
            dataCadastro: currentDate
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a ProfissionalSaude', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
