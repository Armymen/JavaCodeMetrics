import { Component, OnInit, Input } from '@angular/core';

import { Greeting } from '../_models/index';
import { GreetingsService } from '../_services/index';

@Component({
  moduleId: module.id,
  selector: 'greeting',
  template: `<h2>{{greeting.content}} Your id is {{greeting.id}}.</h2><p><a [routerLink]="['/login']">Logout</a></p>`
})

export class GreetingComponent implements OnInit {
  @Input()
  name: string = 'Pawel';
  greeting: Greeting = {id: -1, content: ''};

  constructor(private greetingsService: GreetingsService) {}

  ngOnInit(): void {
    this.setGreeting();
  }

  setGreeting(): void {
    this.greetingsService.getGreeting(this.name).subscribe(greeting => this.greeting = greeting); 
  }
}
