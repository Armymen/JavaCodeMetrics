import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';
import { FormsModule }    from '@angular/forms';
import { AppComponent }  from './app.component';
import { routing }        from './app.routing';
import { AuthenticationService, GreetingsService, AlertService, UserService } from './_services/index';
import { AuthGuard } from './_guards/index';
import { AlertComponent } from './_alerts/index';
import { GreetingComponent } from './greetings/greeting.component';
import { LoginComponent } from './login/index';

@NgModule({
  imports: [ 
      BrowserModule,
      HttpModule,
      FormsModule,
      routing ],
  declarations: [ 
      AppComponent, 
      GreetingComponent,
      LoginComponent,
      AlertComponent ],
  providers: [ 
      AuthGuard,
      AuthenticationService, 
      GreetingsService, 
      AlertService,
      UserService ],
  bootstrap: [ AppComponent ] 
})
export class AppModule { }
