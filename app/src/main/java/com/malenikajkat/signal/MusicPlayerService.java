package com.malenikajkat.signal;


import static android.content.Context.SENSOR_SERVICE;
import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.IBinder;

import java.io.IOException;

public class MusicPlayerService {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor gyroscope;

    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (gyroscope != null) {
            sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        }

        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource("path_to_your_music_file");
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            // Обработка данных акселерометра
            // Например, если акселерометр показывает, что пользователь бежит, можно воспроизводить бодрую музыку
        }
        if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            // Обработка данных гироскопа
            // Например, если гироскоп показывает, что пользователь вращается, можно воспроизводить музыку с вращательным эффектом
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
        mediaPlayer.release();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Возвращаем null, так как не используем интерфейс Binder для взаимодействия с сервисом
        return null;
    }
}

