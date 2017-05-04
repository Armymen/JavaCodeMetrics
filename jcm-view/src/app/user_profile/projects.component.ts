import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

import { UserService, ProjectService, AlertService } from '../_services/index';

@Component({
    moduleId: module.id,
    selector: 'projects',
    templateUrl: '../../../app/user_profile/projects.component.html'
})

export class ProjectsComponent {
    @Input()
    currentUser: any;
    model: any = {};

    constructor(private userService: UserService, private projectService: ProjectService, private alertService: AlertService) {}

    addProject() {
        this.projectService.addProject(this.model.newProject)
            .subscribe(
                data => {
                    this.setCurrentUser();
                    this.alertService.success(`Project '${this.model.newProject}' was successfully added.`, false);
                },
                error => {
                    this.alertService.error(error);
                });
    }

    setCurrentUser() {
        this.userService.getCurrentUser().subscribe(currentUser => this.currentUser = currentUser);
    }
}
