import { Component } from '@angular/core';
import { Platform } from '@ionic/angular';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss'],
})
export class AppComponent {

  rootPage:any = "LoginPage";
  constructor(
    private platform: Platform,
    private router: Router

  ) {
    this.initApp();
  }

  initApp(){
    this.platform.ready().then(() => {
      this.router.navigateByUrl('login');
    })
  }
}
