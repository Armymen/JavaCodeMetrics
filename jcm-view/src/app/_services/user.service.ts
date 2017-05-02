import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { AuthenticationService } from './index';

@Injectable()
export class UserService {
    constructor(private http: Http, private authenticationService: AuthenticationService) {}

    private baseUrl = 'http://localhost:12800';

    getCurrentUser() {
        let authHeaders = new Headers({'Authorization': this.authenticationService.getToken()});
        return this.http.get(this.baseUrl + '/user', {headers: authHeaders})
            .map((response: Response) => response.json());
    }

    create(username: string, password: string) {
        let jsonHeaders = new Headers({'Content-Type': 'application/json'});
        return this.http.post(this.baseUrl + '/users/create', JSON.stringify({username: username, password: password}), {headers: jsonHeaders})
            .map((response: Response) => response.json());
    }
}