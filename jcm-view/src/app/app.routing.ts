import { Routes, RouterModule } from '@angular/router';

import { UserProfileComponent } from './user_profile/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { ProjectDetailsComponent } from './project_details/index';
import { AuthGuard } from './_guards/index';

const appRoutes: Routes = [
    { path: '', component: UserProfileComponent, canActivate: [AuthGuard] },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'project/:name', component: ProjectDetailsComponent, canActivate: [AuthGuard] },

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const routing = RouterModule.forRoot(appRoutes);
