import { Component, OnInit, Input, Output, EventEmitter  } from '@angular/core';
import { ApiService } from '../../apiservice.service';
import { InvestmentGroup } from '../../Models/InvestmentGroup';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {Router} from '@angular/router';
import { GetRequiredTextValidators, GetRequiredNumberValidators, EntityTypes, SelectEntitiesComponent } from '../../Utilities';
import { CheckModel } from '../../Models/CheckModel';
import { SelectItemsComponent } from './select-items';
import { Region } from '../../Models/Region';
import { InvestmentService } from '../../investment.service';



@Component({
  selector: 'app-associate-regions',
  templateUrl: 'select-entities.html',
  })

export class AssociateRegionsComponent extends SelectEntitiesComponent implements OnInit {
  constructor(private apiService: ApiService,
              private route: ActivatedRoute,
              private location: Location,
              private router: Router) {
                  super();
              }


ngOnInit(): void {
    this.apiService.GetRegions().subscribe(regions => {
        this.Items = this.ConvertRegionsToCheckModels(regions);
        },
        error => this.error = <any>error);
  }
  onNext() {const investmentId = +this.route.snapshot.paramMap.get('id');
  const entityIds = this.GetEntityIds();

  this.apiService
  .AssociateEntityWithInvestment(EntityTypes.Region, entityIds, investmentId)
  .subscribe((value) => {
      this.router.navigateByUrl('/InvestmentDetails/' + investmentId);
  }, error => {});
  }
}
