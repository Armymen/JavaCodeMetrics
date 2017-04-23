import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

@Injectable()
export class UserService {
    constructor(private http: Http) {}

    private createUserUrl = 'http://localhost:12800/createUser';
    private headers = new Headers({'Content-Type': 'application/json'});

    create(username: string, password: string) {
        return this.http.post(this.createUserUrl, JSON.stringify({username: username, password: password}), {headers: this.headers})
            .map((response: Response) => response.json());
    }
}