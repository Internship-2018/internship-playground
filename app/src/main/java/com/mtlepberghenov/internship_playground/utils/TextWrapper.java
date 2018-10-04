package com.mtlepberghenov.internship_playground.utils;

import android.content.Context;
import com.mtlepberghenov.internship_playground.R;

public class TextWrapper {

  private static TextWrapper textWrapper;

  private Context context;

  private TextWrapper() {
  }

  public static TextWrapper newInstance() {
    if (textWrapper == null) {
      textWrapper = new TextWrapper();
    }
    return textWrapper;
  }

  public void setContext(Context context) {
    this.context = context;
  }

  public String getErrorMessage() {
    return context.getString(R.string.error);
  }

  public String getDoneMessage() {
    return context.getString(R.string.Done);
  }
}
