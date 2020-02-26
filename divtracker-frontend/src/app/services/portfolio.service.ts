import { Injectable } from '@angular/core';
import { Stock } from '../model/Stock';
import { HttpClient } from '@angular/common/http';
import { BACKEND_URL } from '../shared/global';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PortfolioService {

  constructor(private http: HttpClient) { }

  getPortfolio(userPk1: number): Observable<Array<Stock>> {
    return this.http.get<Array<Stock>>(`${BACKEND_URL}/users/${userPk1}/portfolio`);
  }
}
