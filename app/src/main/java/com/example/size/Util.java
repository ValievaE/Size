package com.example.size;

import android.app.Activity;
import android.content.Intent;

public class Util {

    private static int Stheme = R.style.AppTheme;

    public static void changeToTheme(Activity activity, int theme) {
        Stheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateTheme(Activity activity) {
        activity.setTheme(Stheme);
    }
}
