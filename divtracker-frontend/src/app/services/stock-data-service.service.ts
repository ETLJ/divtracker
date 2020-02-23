import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from "@angular/common/http";
import { BACKEND_URL } from "../shared/global";
import { throwError, Observable } from 'rxjs';
import { Stock } from '../model/Stock';

@Injectable({
  providedIn: 'root'
})
export class StockDataServiceService {

  constructor(private http: HttpClient) { }

  getStockData(symbol: string): Observable<Stock> {
    return this.http.get<Stock>(`${BACKEND_URL}/stock/${symbol}`);
  }

  private handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      console.error("instanceof ErrorEvent", error.error.message);
    } else {
      console.error(`Backend returned code ${error.status} ` + `Body was: ${error.error}`);
    }
    return throwError('Something bad happened')
  }

}