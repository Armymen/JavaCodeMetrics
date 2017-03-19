import { NgModule }      from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpModule }    from '@angular/http';
import { AppComponent }  from './app.component';
import { GreetingComponent } from './greetings/greeting.component';

@NgModule({
  imports: [ 
      BrowserModule,
      HttpModule ],
  declarations: [ 
      AppComponent, 
      GreetingComponent ],
  bootstrap: [ AppComponent ] 
})
export class AppModule { }
