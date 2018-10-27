import { RouterModule, Routes } from '@angular/router';
import { ReportsListComponent } from './reports-list/reports-list.component';
import { ReportsViewComponent } from './reports-view/reports-view.component';

const routes: Routes = [
  { 
     path: 'reports', 
     component: ReportsListComponent 
   },
   {
    path: 'reports/:name',
    component: ReportsViewComponent
  }
];

export const routing = RouterModule.forRoot(routes);