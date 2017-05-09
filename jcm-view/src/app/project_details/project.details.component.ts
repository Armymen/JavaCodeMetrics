import { Component, ElementRef, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { Location } from '@angular/common';

import { ProjectService, AlertService } from '../_services/index';

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
        private alertService: AlertService,
        private location: Location) {}

    ngOnInit() {
        this.route.params
            .switchMap((params: Params) => this.projectService.getProject(params['name']))
            .subscribe(project => this.project = project);
        $(this.rootElement.nativeElement).find("#file-input-id").fileinput({
            'allowedFileExtensions': ['zip'],
            'fileActionSettings': {
                'showZoom': false
            }
        });
    }

    fileUpload(event: any) {
        let fileList: FileList = event.target.files;
        if (fileList.length > 0) {
            this.projectService.uploadFile(fileList[0], this.project.username + '|' + this.project.name)
                .subscribe(
                    data => {
                        if (data.status === "success") {
                            this.alertService.success(data.message);
                        } else {
                            this.alertService.error(data.message);
                        }
                    },
                    error => {
                        this.alertService.error(error);
                });    
        }
    }

    goBack() {
        this.location.back();
    }
}
