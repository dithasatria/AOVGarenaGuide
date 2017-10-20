package com.example.android.aovgarenaguide.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by DITHA on 16/09/2017.
 */

public class Utility {
    public static final String URL_IMG_HERO = "http://igpdsd.pe.hu/AOVGuides/Hero/Images/";
    public static final String KEY_INTENT_HERO_DETAIL = "dataHeroDetail";

    public static final String KEY_ARCHER = "Archer";
    public static final String KEY_ASSASSIN = "Assassin";
    public static final String KEY_MAGE = "Mage";
    public static final String KEY_SUPPORT = "Support";
    public static final String KEY_TANK = "Tank";
    public static final String KEY_WARRIOR = "Warrior";

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 120);
        return noOfColumns;
    }
}
