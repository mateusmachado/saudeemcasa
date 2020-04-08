import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { IProfissionalSaude } from 'app/shared/model/profissional-saude.model';

type EntityResponseType = HttpResponse<IProfissionalSaude>;
type EntityArrayResponseType = HttpResponse<IProfissionalSaude[]>;

@Injectable({ providedIn: 'root' })
export class ProfissionalSaudeService {
  public resourceUrl = SERVER_API_URL + 'api/profissional-saudes';

  constructor(protected http: HttpClient) {}

  create(profissionalSaude: IProfissionalSaude): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(profissionalSaude);
    return this.http
      .post<IProfissionalSaude>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(profissionalSaude: IProfissionalSaude): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(profissionalSaude);
    return this.http
      .put<IProfissionalSaude>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IProfissionalSaude>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IProfissionalSaude[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  protected convertDateFromClient(profissionalSaude: IProfissionalSaude): IProfissionalSaude {
    const copy: IProfissionalSaude = Object.assign({}, profissionalSaude, {
      dataNascimento:
        profissionalSaude.dataNascimento && profissionalSaude.dataNascimento.isValid()
          ? profissionalSaude.dataNascimento.toJSON()
          : undefined,
      dataCadastro:
        profissionalSaude.dataCadastro && profissionalSaude.dataCadastro.isValid() ? profissionalSaude.dataCadastro.toJSON() : undefined
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.dataNascimento = res.body.dataNascimento ? moment(res.body.dataNascimento) : undefined;
      res.body.dataCadastro = res.body.dataCadastro ? moment(res.body.dataCadastro) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((profissionalSaude: IProfissionalSaude) => {
        profissionalSaude.dataNascimento = profissionalSaude.dataNascimento ? moment(profissionalSaude.dataNascimento) : undefined;
        profissionalSaude.dataCadastro = profissionalSaude.dataCadastro ? moment(profissionalSaude.dataCadastro) : undefined;
      });
    }
    return res;
  }
}
