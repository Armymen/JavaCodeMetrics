import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { AuthenticationService } from './index';

@Injectable()
export class ProjectService {
    constructor(private http: Http, private authenticationService: AuthenticationService) {}

    private baseUrl = 'http://localhost:12800';

    addProject(name: string) {
        let authHeaders = new Headers({'Authorization': this.authenticationService.getToken()});
        return this.http.post(`${this.baseUrl}/projects/add/${name}`, null, {headers: authHeaders})
            .map((response: Response) => response.json());
    }
}