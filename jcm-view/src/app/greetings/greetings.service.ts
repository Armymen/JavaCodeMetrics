import { Injectable }    from '@angular/core';
import { Headers, Http } from '@angular/http';

import 'rxjs/add/operator/toPromise';

import { Greeting } from './greeting';

@Injectable()
export class GreetingsService {

    private headers = new Headers({'Content-Type': 'application/json'});
    private greetingsUrl = 'http://localhost:12800';

    constructor(private http: Http) {}

    getGreeting(name: string): Promise<Greeting> {
        const url = `${this.greetingsUrl}/greeting?name=${name}`;
        return this.http.get(url)
               .toPromise()
               .then(response => response.json())
               .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error);
        return Promise.reject(error.message || error);
    }   
}