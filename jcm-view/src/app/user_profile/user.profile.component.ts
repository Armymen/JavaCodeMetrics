import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: '../../../app/user_profile/user.profile.component.html'
})

export class UserProfileComponent implements OnInit {
    currentUser: any = {};

    constructor(private userService: UserService) {}

    ngOnInit() {
        this.userService.getCurrentUser().subscribe(currentUser => this.currentUser = currentUser);
    }
}
