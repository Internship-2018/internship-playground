package com.mtlepberghenov.internship_playground.di.modules;

import com.mtlepberghenov.internship_playground.App;
import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

  private App app;

  public AppModule(App app) {
    this.app = app;
  }

  @Provides public App app() {
    return this.app;
  }
}
