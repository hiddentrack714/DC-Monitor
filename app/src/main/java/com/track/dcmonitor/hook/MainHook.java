package com.track.dcmonitor.hook;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.track.dcmonitor.activity.MainActivity;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;


public class MainHook implements IXposedHookLoadPackage {

    public String  abc;
    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        Log.i("MainHook","开始设置0");
        Log.i("MainHook",lpparam.packageName);
        Log.i("MainHook",lpparam.processName);
        XposedBridge.log("MainHook:" + lpparam.packageName);

        if (lpparam.packageName.equals("com.android.systemui")) {
            Log.i("MainHook","开始设置1");
            XposedHelpers.findAndHookMethod("com.android.systemui.statusbar.phone.PhoneStatusBarView", lpparam.classLoader, "setBar", new dc_XC_MethodHook());
        }
    }


    public class dc_XC_MethodHook extends XC_MethodHook{
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                //super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                Log.i("MainHook","开始设置2");
                // Get StatusBar instance
                Object statusBar = param.thisObject;

                // Access mStatusBar field
                Object statusBarView = XposedHelpers.getObjectField(statusBar, "mStatusBar");

                // Add custom TextView
                TextView customTextView = new TextView((android.content.Context) statusBarView);
                customTextView.setText("BTC 60000");

                // Access mStatusBarContent field
                Object statusBarContent = XposedHelpers.getObjectField(statusBarView, "mStatusBarContent");

                // Add custom TextView to mStatusBarContent
                XposedHelpers.callMethod(statusBarContent, "addView", customTextView);
                Log.i("MainHook","开始设置3");
            }
        }
}
