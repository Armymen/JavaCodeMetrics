import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { User } from '../_models/index';

@Injectable()
export class UserService {
    constructor(private http: Http) {}

    create(user: User) {
        let createUserUrl = 'http://localhost:12800/createUser';
        return this.http.post(createUserUrl, user).map((response: Response) => response.json());
    }
}