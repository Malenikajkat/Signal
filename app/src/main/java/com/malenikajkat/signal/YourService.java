package com.malenikajkat.signal;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class YourService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        // Инициализация сервиса
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Обработка команд для сервиса
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Возвращает ссылку на интерфейс IBinder, если сервис поддерживает интерфейс AIDL
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // Освобождение ресурсов сервиса
    }
}