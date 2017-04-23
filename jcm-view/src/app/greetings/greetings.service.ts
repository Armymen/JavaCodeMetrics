import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Greeting } from './greeting';
import { AuthenticationService } from '../login/authentication.service';

@Injectable()
export class GreetingsService {

    private serverUrl = 'http://localhost:12800';

    constructor(private http: Http, private authService: AuthenticationService) {}

    getGreeting(name: string): Promise<Greeting> {
        const url = `${this.serverUrl}/greeting?name=${name}`;
        let authHeaders = new Headers({'Authorization': this.authService.getToken()});
        return this.http.get(url, {headers: authHeaders})
               .toPromise()
               .then(response => response.json())
               .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }   
}