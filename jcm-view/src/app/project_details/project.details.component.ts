import { Component, ElementRef, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { ProjectService } from '../_services/index';

import 'rxjs/add/operator/switchMap';

declare var $: any;

@Component({
    moduleId: module.id,
    templateUrl: '../../../app/project_details/project.details.component.html'
})

export class ProjectDetailsComponent implements OnInit {
    project: any = {};

    constructor(
        private rootElement: ElementRef,
        private route: ActivatedRoute,
        private projectService: ProjectService,
        private location: Location) {}

    ngOnInit() {
        this.route.params
            .switchMap((params: Params) => this.projectService.getProject(params['name']))
            .subscribe(project => this.project = project);
        $(this.rootElement.nativeElement).find("#file-input-id").fileinput({
            'allowedFileExtensions': ['zip']
        });
    }

    goBack(): void {
        this.location.back();
    }
}
