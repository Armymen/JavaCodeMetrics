import { Component, OnInit } from '@angular/core';

import { Greeting } from './greeting';
import { GreetingsService } from './greetings.service';

@Component({
  selector: 'my-app',
  template: '<h1>{{greeting.content}} Your id is {{greeting.id}}.</h1>',
  providers: [GreetingsService]
})

export class AppComponent implements OnInit { 
  name = 'Pawel';
  greeting: Greeting = {id: -1, content: 'default'};

  constructor(private greetingsService: GreetingsService) {}

  ngOnInit(): void {
    this.setGreeting();
  }

  setGreeting(): void {
    this.greetingsService.getGreeting(this.name).then(greeting => this.greeting = greeting);
  }
}
