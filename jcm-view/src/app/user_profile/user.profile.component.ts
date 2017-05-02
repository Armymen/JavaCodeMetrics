import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { UserService, ProjectService, AlertService } from '../_services/index';

@Component({
    moduleId: module.id,
    templateUrl: '../../../app/user_profile/user.profile.component.html'
})

export class UserProfileComponent implements OnInit {
    model: any = {};
    currentUser: any = {};

    constructor(private userService: UserService, private projectService: ProjectService, private alertService: AlertService) {}

    ngOnInit() {
        this.setCurrentUser();
    }

    addProject() {
        this.projectService.addProject(this.model.newProject)
            .subscribe(
                data => {
                    this.setCurrentUser();
                    this.alertService.success(`Project '${this.model.newProject}' was successfully added.`, true);
                },
                error => {
                    this.alertService.error(error);
                });
    }

    setCurrentUser() {
        this.userService.getCurrentUser().subscribe(currentUser => this.currentUser = currentUser);
    }
}
