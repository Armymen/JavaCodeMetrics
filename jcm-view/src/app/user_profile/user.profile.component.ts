import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../_models/index';

@Component({
    moduleId: module.id,
    templateUrl: '../../../app/user_profile/user.profile.component.html'
})

export class UserProfileComponent {
    currentUser: User;

    constructor() {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
    }
}
