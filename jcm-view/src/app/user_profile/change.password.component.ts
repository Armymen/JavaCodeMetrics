import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

import { AlertService, AuthenticationService, UserService } from '../_services/index';

@Component({
    moduleId: module.id,
    selector: 'changePassword',
    templateUrl: '../../../app/user_profile/change.password.component.html'
})

export class ChangePasswordComponent {
    @Input()
    currentUser: any;
    model: any = {};
    loading = false;

    constructor(
        private router: Router,
        private userService: UserService,
        private authenticationService: AuthenticationService,
        private alertService: AlertService) { }

    changePassword() {
        this.loading = true;
        this.authenticationService.checkPassword(this.currentUser.username, this.model.currentPassword)
            .subscribe(
                data => {
                    this.userService.changePassword(this.currentUser.username, this.model.newPassword)
                        .subscribe(
                            data => {
                                this.alertService.success('Password was successfully changed', true);
                                this.router.navigate(['/login']);
                            },
                            error => {
                                this.alertService.error(error);
                                this.loading = false;
                    });    
                },
                error => {
                    this.alertService.error(error);
                    this.loading = false;
                });
    }
}
