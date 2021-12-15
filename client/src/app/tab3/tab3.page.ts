import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { NavController } from '@ionic/angular';
import { User } from '../models/user';
import { UserService } from '../services/user.service';


@Component({
  selector: 'app-tab3',
  templateUrl: 'tab3.page.html',
  styleUrls: ['tab3.page.scss']
})
export class Tab3Page implements OnInit {
  public users: User[];
  constructor(public navCtrl: NavController, public router: Router, 
    public userService: UserService) {}

    ngOnInit(): void {
      this.userService.getUsers().subscribe(users => {
        this.users = users;
      });
    }
    
}
