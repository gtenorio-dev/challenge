import { Component, OnInit } from '@angular/core';
import { AnagramService } from './anagram.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css'],
})
export class FormComponent implements OnInit {
  public words: string;

  constructor(
    private anagramService: AnagramService,
  ) {}

  ngOnInit(): void {}

  public saveAnagrams(): void {
    this.anagramService.sendWords(this.words).subscribe(
      (res) => {
        console.log('Saved: ' + res);
      },
      (error) => {
        alert('ERROR GETTING ANAGRAMS');
      }
    );
    this.words = '';
  }
}
