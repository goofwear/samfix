package com.dharmapoudel.samfix;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {

    SharedPreferences mSharedPreferences;

    public boolean  pref_disable_max_volume_warning;
    public boolean  pref_disable_max_brightness_warning;
    public boolean  pref_enable_greyscale;
    public boolean  pref_auto_backup;
    public boolean  pref_no_popup_on_bt;
    public boolean  pref_no_popup_on_wifi;
    public boolean  pref_no_popup_on_sync;
    public boolean  pref_no_popup_gm_location;
    //public boolean   supportEnabled;
    public boolean pref_license_check_broadcast_value, license_check_broadcast_sent;

    public float    pref_animation_duration = 0.50f;

    public Preferences(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        loadSavedPreferences();
    }

    private void loadSavedPreferences() {
        pref_disable_max_volume_warning = mSharedPreferences.getBoolean("pref_disable_max_volume_warning", false);
        pref_disable_max_brightness_warning = mSharedPreferences.getBoolean("pref_disable_max_brightness_warning", false);
        pref_enable_greyscale = mSharedPreferences.getBoolean("pref_enable_greyscale", false);
        pref_animation_duration = mSharedPreferences.getFloat("pref_animation_duration", pref_animation_duration);

        pref_auto_backup = mSharedPreferences.getBoolean("pref_auto_backup", false);
        pref_no_popup_on_bt = mSharedPreferences.getBoolean("pref_no_popup_on_bt", false);
        pref_no_popup_on_wifi = mSharedPreferences.getBoolean("pref_no_popup_on_wifi", false);
        pref_no_popup_on_sync = mSharedPreferences.getBoolean("pref_no_popup_on_sync", false);
        pref_no_popup_gm_location = mSharedPreferences.getBoolean("pref_no_popup_gm_location", false);
        //supportEnabled = mSharedPreferences.getBoolean("samfix", false);
        pref_license_check_broadcast_value = mSharedPreferences.getBoolean("pref_license_check_broadcast_value", false);
        license_check_broadcast_sent = mSharedPreferences.getBoolean("license_check_broadcast_sent", false);
    }

    public void savePreference(String key, boolean value){
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public SharedPreferences.Editor getEditor(){
        return mSharedPreferences.edit();
    }

}
