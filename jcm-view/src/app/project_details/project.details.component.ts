import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { ProjectService } from '../_services/index';

import 'rxjs/add/operator/switchMap';

@Component({
    moduleId: module.id,
    templateUrl: '../../../app/project_details/project.details.component.html'
})

export class ProjectDetailsComponent implements OnInit {
    project: any = {};

    constructor(
        private route: ActivatedRoute,
        private projectService: ProjectService,
        private location: Location) {}

    ngOnInit() {
        this.route.params
            .switchMap((params: Params) => this.projectService.getProject(params['name']))
            .subscribe(project => this.project = project);
    }

    goBack(): void {
        this.location.back();
    }
}
