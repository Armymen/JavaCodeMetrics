import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';
import { FormsModule }    from '@angular/forms';
import { AppComponent }  from './app.component';
import { routing }        from './app.routing';
import { AuthenticationService, AlertService, UserService, ProjectService } from './_services/index';
import { AuthGuard } from './_guards/index';
import { AlertComponent } from './_alerts/index';
import { UserProfileComponent } from './user_profile/index';
import { LoginComponent } from './login/index';
import { RegisterComponent } from './register/index';
import { EqualValidator } from './_validators/index';

@NgModule({
  imports: [ 
      BrowserModule,
      HttpModule,
      FormsModule,
      routing ],
  declarations: [ 
      AppComponent, 
      UserProfileComponent,
      LoginComponent,
      RegisterComponent,
      AlertComponent,
      EqualValidator ],
  providers: [ 
      AuthGuard,
      AuthenticationService, 
      AlertService,
      UserService,
      ProjectService ],
  bootstrap: [ AppComponent ] 
})
export class AppModule { }
