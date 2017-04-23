import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';
import { AppComponent }  from './app.component';
import { GreetingComponent } from './greetings/greeting.component';
import { AuthenticationService } from './_services/index';

@NgModule({
  imports: [ 
      BrowserModule,
      HttpModule ],
  declarations: [ 
      AppComponent, 
      GreetingComponent ],
  providers: [ AuthenticationService ],
  bootstrap: [ AppComponent ] 
})
export class AppModule { }
