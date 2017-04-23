import { Injectable }    from '@angular/core';
import { Headers, Http, Response } from '@angular/http';

import { Greeting } from '../_models/index';
import { AuthenticationService } from './index';

@Injectable()
export class GreetingsService {

    private serverUrl = 'http://localhost:12800';

    constructor(private http: Http, private authService: AuthenticationService) {}

    getGreeting(name: string) {
        const url = `${this.serverUrl}/greeting?name=${name}`;
        let authHeaders = new Headers({'Authorization': this.authService.getToken()});
        return this.http.get(url, {headers: authHeaders}).map((response: Response) => response.json());;
    }   
}