import { Component, OnInit } from '@angular/core';
import { Anagram } from '../models/anagram';
import { AnagramService } from './anagram.service';

@Component({
  selector: 'app-anagram',
  templateUrl: './anagram.component.html',
  styleUrls: ['./anagram.component.css'],
})
export class AnagramComponent {
  anagrams: Anagram[];


  constructor(
    private anagramService: AnagramService,
  ) {}

  ngOnInit() {
    this.reloadResults();
  }

  public reloadResults(): void {
    console.log('helloworld!');
    this.anagramService.getResults().subscribe(
      (res) => {
        console.log(res);
        this.anagrams = res;
      },
      (error) => {
        alert('ERROR SAVING');
      }
    );
  }
}
