import { Component, OnInit, Input } from '@angular/core';

import { Greeting } from '../_models/index';
import { GreetingsService } from '../_services/index';

@Component({
  selector: 'greeting',
  template: '<h1>{{greeting.content}} Your id is {{greeting.id}}.</h1>',
  providers: [GreetingsService]
})

export class GreetingComponent implements OnInit {
  @Input()
  name: string;
  greeting: Greeting = {id: -1, content: ''};

  constructor(private greetingsService: GreetingsService) {}

  ngOnInit(): void {
    this.setGreeting();
  }

  setGreeting(): void {
    this.greetingsService.getGreeting(this.name).subscribe(greeting => this.greeting = greeting); 
  }
}
