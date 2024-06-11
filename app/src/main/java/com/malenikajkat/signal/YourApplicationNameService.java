package com.malenikajkat.signal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class YourApplicationNameService extends Service {

    private static final String TAG = "YourApplicationNameService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "Service created");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service started");
        // Здесь вы можете выполнять операции, которые должны выполняться в фоновом режиме
        // Например, запуск асинхронных задач или работа с фоновыми потоками
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Возвращаем null, так как не используем интерфейс Binder для взаимодействия с сервисом
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Service destroyed");
    }
}