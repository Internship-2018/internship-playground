package com.mtlepberghenov.internship_playground.di.dialog.modules;

import com.mtlepberghenov.internship_playground.ui.dialog.DefaultDialogFragment;
import dagger.Module;
import dagger.Provides;

@Module
public class DialogModule {

  @Provides public DefaultDialogFragment provideDefaultDialogFragment() {
    return new DefaultDialogFragment();
  }
}
