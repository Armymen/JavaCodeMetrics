import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, Response } from '@angular/http';

import { AuthenticationService } from './index';

@Injectable()
export class ProjectService {
    constructor(private http: Http, private authenticationService: AuthenticationService) {}

    private baseUrl = 'http://localhost:12800';
    private authHeaders = new Headers({'Authorization': this.authenticationService.getToken()});

    addProject(name: string) {
        return this.http.post(`${this.baseUrl}/projects/add/${name}`, null, {headers: this.authHeaders})
            .map((response: Response) => response.json());
    }

    getProject(name: String) {
        return this.http.get(`${this.baseUrl}/projects/${name}`, {headers: this.authHeaders})
            .map((response: Response) => response.json());    
    }
}