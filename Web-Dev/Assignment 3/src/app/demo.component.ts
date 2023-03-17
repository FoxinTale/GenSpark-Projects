import { Component } from "@angular/core";


@Component(
    {
    selector: 'demo-comp',
    template: `<h1>First app!</h1> <p>It is working</p>`
})

export class demoComponent{
    title = "Hi there, I'm working."
}