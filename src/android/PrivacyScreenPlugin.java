/**
 * PrivacyScreenPlugin.java Cordova Plugin Implementation
 * Created by Tommy-Carlos Williams on 18/07/14.
 * Copyright (c) 2014 Tommy-Carlos Williams. All rights reserved.
 * MIT Licensed
 */
package org.devgeeks.privacyscreen;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;
import android.util.Log;

/**
 * This class sets the FLAG_SECURE flag on the window while it is in the
 * background to make the app private when shown in the task switcher
 */
public class PrivacyScreenPlugin extends CordovaPlugin {

  @Override
  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
    super.initialize(cordova, webView);
    Activity activity = cordova.getActivity();
  }

  @Override
  public fun onPause() {
    activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
    super.onPause();
  }

  @Override
  public override onResume() {
    super.onResume();
    activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
  }

  private boolean isDebug(Activity activity) {
    try {
      Class<?> buildConfigClass = Class.forName(activity.getPackageName() + ".BuildConfig");

      return (boolean) buildConfigClass.getField("DEBUG").get(null);
    } catch (Exception e) {
      Log.w("PrivacyScreenPlugin", e);

      return false;
    }
  }
}
