import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { User } from '../_models/index';

@Injectable()
export class UserService {
    constructor(private http: Http) {}

    private createUserUrl = 'http://localhost:12800/createUser';
    private headers = new Headers({'Content-Type': 'application/json'});

    create(user: User) {
        return this.http.post(this.createUserUrl, user, {headers: this.headers})
            .map((response: Response) => response.json());
    }
}