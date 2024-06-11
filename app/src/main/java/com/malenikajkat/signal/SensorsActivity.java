package com.malenikajkat.signal;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class SensorsActivity extends Activity implements SensorEventListener, SeekBar.OnSeekBarChangeListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor gyroscope;
    private TextView textViewAccelerometer;
    private TextView textViewGyroscope;
    private SeekBar seekBar;
    private float threshold = 2.0f; // Пороговое значение для активации действий
    private float initialAccelerometerValue = 0.0f; // Начальное значение акселерометра
    private float initialGyroscopeValue = 0.0f; // Начальное значение гироскопа

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        textViewAccelerometer = findViewById(R.id.textViewAccelerometer);
        textViewGyroscope = findViewById(R.id.textViewGyroscope);
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        if (accelerometer != null && gyroscope != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        } else {
            textViewAccelerometer.setText("Accelerometer not found");
            textViewGyroscope.setText("Gyroscope not found");
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            textViewAccelerometer.setText("Accelerometer: x=" + x + ", y=" + y + ", z=" + z);
            initialAccelerometerValue = x; // Фиксируем начальное значение акселерометра
        } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            textViewGyroscope.setText("Gyroscope: x=" + x + ", y=" + y + ", z=" + z);
            initialGyroscopeValue = x; // Фиксируем начальное значение гироскопа
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Обработка изменения точности сенсора
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // Обновление порогового значения в зависимости от положения ползунка
        threshold = progress / 100.0f;
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // Начало отслеживания перемещения ползунка
    }


    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // Окончание отслеживания перемещения ползунка
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}


