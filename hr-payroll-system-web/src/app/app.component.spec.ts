import { async, ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { RouterTestingModule } from '@angular/router/testing';
import { TranslateModule, TranslateService, TranslateLoader, TranslateFakeLoader } from '@ngx-translate/core';
import { HttpClientTestingModule,HttpTestingController  } from '@angular/common/http/testing';
import { AlertModule } from 'ngx-alerts';
describe('AppComponent', () => {
  
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        RouterTestingModule,
        HttpClientTestingModule ,
        TranslateModule.forRoot({
          loader: { provide: TranslateLoader, useClass: TranslateFakeLoader }}),
          AlertModule.forRoot({maxMessages: 5, timeout: 5000, position: 'right'}),
      ],
      declarations: [
        AppComponent
      ],
      providers: [TranslateService]
    }).compileComponents();
  }));

  it('should create the app', () => {
    let translateService:TranslateService;
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    translateService = fixture.debugElement.injector.get(TranslateService);
    fixture.detectChanges();
    //httpTestingController = TestBed.get(HttpTestingController);
    expect(app).toBeTruthy();
  });

  it(`should have as title 'hr-payroll-system-web'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('hr-payroll-system-web');
  });

  // it('should render title', () => {
  //   const fixture = TestBed.createComponent(AppComponent);
  //   fixture.detectChanges();
  //   const compiled = fixture.debugElement.nativeElement;
  //   expect(compiled.querySelector('.content span').textContent).toContain('hr-payroll-system-web app is running!');
  // });
});
