package com.mtlepberghenov.internship_playground.di;

import com.mtlepberghenov.internship_playground.di.modules.AppModule;
import com.mtlepberghenov.internship_playground.di.modules.VehicleListPresenterModule;
import dagger.Component;

@Component(modules = {
    AppModule.class,
    VehicleListPresenterModule.class
})
public interface AppComponent {
}
