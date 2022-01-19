import { Injectable } from '@angular/core';
import { Anagram } from '../models/anagram';
import { of, Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})
export class AnagramService {
  private urlEndPoint = 'http://localhost:8080/api/';

  constructor(private http: HttpClient) {}

  getResults(): Observable<Anagram[]> {
    return this.http
      .get(this.urlEndPoint + 'results')
      .pipe(map((response) => response as Anagram[]));
  }

  sendWords(words: string): Observable<boolean> {
    const params = new HttpParams().set('words', words);
    return this.http.post<any>(this.urlEndPoint + 'save', params);
  }
}
