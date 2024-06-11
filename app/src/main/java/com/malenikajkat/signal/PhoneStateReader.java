package com.malenikajkat.signal;

import android.content.Context;
import android.telephony.TelephonyManager;

public class PhoneStateReader {
    // Метод для получения IMEI
    public String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String IMEI = telephonyManager.getDeviceId();
        return IMEI;
    }

    // Метод для получения номера телефона
    public String getPhoneNumber(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String phoneNumber = telephonyManager.getLine1Number();
        return phoneNumber;
    }

}