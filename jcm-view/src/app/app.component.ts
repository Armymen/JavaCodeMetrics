import { Component, OnInit } from '@angular/core';

import { Greeting } from './greeting';
import { GreetingsService } from './greetings.service';

@Component({
  selector: 'my-app',
  template: `<h1>Hello {{greeting.name}}. Your id is {{greeting.id}}.</h1>`,
  providers: [GreetingsService]
})

export class AppComponent implements OnInit { 
  name = 'Pawel';
  greeting: Greeting;

  constructor(private greetingsService: GreetingsService) {}

  ngOnInit(): void {
    this.setGreeting();
  }

  setGreeting(): void {
    this.greetingsService.getGreeting(name).then(greeting => this.greeting = greeting);
  }
}
