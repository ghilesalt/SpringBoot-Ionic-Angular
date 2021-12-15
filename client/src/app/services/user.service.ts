import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private ApiUrl = environment.ApiStartUrl;
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };
  constructor(private http: HttpClient) {}

  public getUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.ApiUrl + '/api/user');
  }

  public addUser(user: User): Observable<User> {
    return this.http.post<User>(this.ApiUrl +'/api/user',user);
  }

  public updateUser(userId: number, user: User): Observable<User[]> {
    return this.http.put<User[]>(this.ApiUrl + '/api/user',this.httpOptions);
  }

  public deleteUser(userId: number): Observable<User[]> {
    return this.http.delete<User[]>(this.ApiUrl + '/api/user'+ userId, this.httpOptions);
  }
}
