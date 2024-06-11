package com.malenikajkat.signal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            // Запуск сервиса при перезагрузке устройства
            Intent serviceIntent = new Intent(context, YourService.class);
            context.startService(serviceIntent);
        }
    }
}
