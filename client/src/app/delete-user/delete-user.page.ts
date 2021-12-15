import { Component, OnInit } from '@angular/core';
import { UserService } from './../services/user.service';
import { Router } from '@angular/router';
import { User } from '../models/user';

@Component({
  selector: 'app-delete-user',
  templateUrl: './delete-user.page.html',
  styleUrls: ['./delete-user.page.scss'],
})

export class DeleteUserPage implements OnInit {

  Users: any = [];

  constructor( 
    private userService: UserService,
    private router: Router
  ) { }

  ngOnInit() {  }

  ionViewDidEnter() {
    this.userService.getUsers().subscribe((response) => {
      this.Users = response;
    })
  }

  removeUser(user:User,id: number) {
    if (window.confirm('Etes-vous sûr ?')) {
      this.userService.deleteUser(user.id)
      .subscribe(() => {
          this.ionViewDidEnter();
          console.log('Utilisateur effacé !')
        }
      )
    }
  }

}