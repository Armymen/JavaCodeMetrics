import { Injectable }    from '@angular/core';
import { Headers, Http, Response } from '@angular/http';

import 'rxjs/add/operator/map';

@Injectable()
export class AuthenticationService {

    private authUrl = 'http://localhost:12800/auth';
    private headers = new Headers({'Content-Type': 'application/json'});
 
    constructor(private http: Http) {}

    login(username: string, password: string) {
        return this.http.post(this.authUrl, JSON.stringify({username: username, password: password}), {headers: this.headers})
            .map((response: Response) => {
                let user = response.json();
                if (user && user.token) {
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }
            });
    }

    checkPassword(username: string, password: string) {
        return this.http.post(this.authUrl, JSON.stringify({username: username, password: password}), {headers: this.headers})
            .map((response: Response) => response.json());
    }
 
    getToken(): string {
        var currentUser = JSON.parse(localStorage.getItem('currentUser'));
        var token = currentUser && currentUser.token;
        return token ? token : "";
    }

    logout(): void {
        localStorage.removeItem('currentUser');
    }
}