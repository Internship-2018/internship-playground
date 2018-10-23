package com.mtlepberghenov.internship_playground.di.dialog;

import com.mtlepberghenov.internship_playground.di.dialog.modules.DialogModule;
import com.mtlepberghenov.internship_playground.ui.start.StartActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = DialogModule.class)
public interface DialogComponent {
  void inject(StartActivity activity);
}
