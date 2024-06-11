package com.malenikajkat.signal;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.IBinder;

public class YourApplicationName extends Activity {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor gyroscope;
    private SensorEventListener sensorEventListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация SensorManager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        // Проверка наличия акселерометра
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        if (accelerometer != null) {
            sensorManager.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }

        // Проверка наличия гироскопа
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        if (gyroscope != null) {
            sensorManager.registerListener(sensorEventListener, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        }

        // Инициализация SensorEventListener
        sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                // Обработка данных с датчиков
                if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    // Обработка данных акселерометра
                } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
                    // Обработка данных гироскопа
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {
                // Обработка изменения точности датчиков
            }
        };
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Отмена регистрации слушателя при выходе из активности
        sensorManager.unregisterListener(sensorEventListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Регистрация слушателя при возвращении в активность
        if (accelerometer != null) {
            sensorManager.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (gyroscope != null) {
            sensorManager.registerListener(sensorEventListener, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    public class YourService extends Service {
        @Override
        public void onCreate() {
            super.onCreate();
            // Инициализация сервиса
        }

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            // Обработка команд на запуск сервиса
            return START_STICKY;
        }

        @Override
        public IBinder onBind(Intent intent) {
            // Возврат IBinder для взаимодействия с сервисом
            return null;
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            // Очистка ресурсов сервиса
        }
    }
}
