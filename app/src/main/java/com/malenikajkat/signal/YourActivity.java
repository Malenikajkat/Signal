package com.malenikajkat.signal;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.chip.ChipGroup;

public class YourActivity extends Activity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometer;
    private Sensor gyroscope;
    private SeekBar seekBar;

    private float initialAccelerometerValueX = 0;
    private float initialAccelerometerValueY = 0;
    private float initialAccelerometerValueZ = 0;
    private float initialGyroscopeValueX = 0;
    private float initialGyroscopeValueY = 0;
    private float initialGyroscopeValueZ = 0;

    private int initialSeekBarValue = 0;

    private final float GYRO_X_THRESHOLD = -9;
    private final float GYRO_X_THRESHOLD_MAX = 0;
    private final float GYRO_X_THRESHOLD_MAX2 = 9;
    private final float GYRO_Y_THRESHOLD = 0;
    private final float GYRO_Y_THRESHOLD_MAX = 1;
    private final float GYRO_Y_THRESHOLD_MAX2 = 2;

    private final float GYRO_Z_THRESHOLD = -9;
    private final float GYRO_Z_THRESHOLD_MAX = 0;
    private final float GYRO_Z_THRESHOLD_MAX2 = 4;
    private final float GYRO_Z_THRESHOLD_MAX3 = 9;

    private final float ACCEL_X_THRESHOLD = -9;
    private final float ACCEL_X_THRESHOLD_MAX = 0;
    private final float ACCEL_X_THRESHOLD_MAX2 = 9;

    private final float ACCEL_Y_THRESHOLD = 0;
    private final float ACCEL_Y_THRESHOLD_MAX = 1;
    private final float ACCEL_Y_THRESHOLD_MAX2 = 2;

    private final float ACCEL_Z_THRESHOLD = -9;
    private final float ACCEL_Z_THRESHOLD_MAX = 0;
    private final float ACCEL_Z_THRESHOLD_MAX2 = 7;
    private final float ACCEL_Z_THRESHOLD_MAX3 = 9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация SensorManager
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Инициализация датчиков и добавление слушателя
        if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER) != null) {
            accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        }
        if (sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE) != null) {
            gyroscope = sensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        }

        // Инициализация seekBar
        seekBar = findViewById(R.id.seekBar);

        // Задание начальных значений
        initialAccelerometerValueX = 0;
        initialAccelerometerValueY = 4;
        initialAccelerometerValueZ = 8;
        initialGyroscopeValueX = 0;
        initialGyroscopeValueY = 4;
        initialGyroscopeValueZ = 8;

        initialSeekBarValue = 0;


        // Регистрация слушателя
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (gyroscope != null) {
            sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Регистрация слушателя при возобновлении активности
        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        }
        if (gyroscope != null) {
            sensorManager.registerListener(this, gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Отмена регистрации слушателя при приостановке активности
        if (accelerometer != null) {
            sensorManager.unregisterListener(this, accelerometer);
        }
        if (gyroscope != null) {
            sensorManager.unregisterListener(this, gyroscope);
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            // Обработка данных акселерометра
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            // Сравнение значений с пороговыми значениями
            if (Math.abs(x) > ACCEL_X_THRESHOLD) {
                // Действие, если значение по оси x превышает порог
                // Например:
                // showToast("Accelerometer X exceeded threshold: " + x);
            }
            if (Math.abs(y) > ACCEL_Y_THRESHOLD) {
                // Действие, если значение по оси y превышает порог
                // Например:
                // showToast("Accelerometer Y exceeded threshold: " + y);
            }
            if (Math.abs(z) > ACCEL_Z_THRESHOLD) {
                // Действие, если значение по оси z превышает порог
                // Например:
                // showToast("Accelerometer Z exceeded threshold: " + z);
            }
        } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            // Обработка данных гироскопа
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            // Сравнение значений с пороговыми значениями
            if (Math.abs(x) > GYRO_X_THRESHOLD) {
                // Действие, если значение по оси x превышает порог
                // Например:
                // showToast("Gyroscope X exceeded threshold: " + x);
            }
            if (Math.abs(y) > GYRO_Y_THRESHOLD) {
                // Действие, если значение по оси y превышает порог
                // Например:
                // showToast("Gyroscope Y exceeded threshold: " + y);
            }
            if (Math.abs(z) > GYRO_Z_THRESHOLD) {
                // Действие, если значение по оси z превышает порог
                // Например:
                // showToast("Gyroscope Z exceeded threshold: " + z);
            }
        }

        // Дополнительные условия для кнопок
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER && seekBar.getProgress() == 0) {
            float x = event.values[0];
            float z = event.values[2];

            if (Math.abs(x) > ACCEL_X_THRESHOLD) {
                // Нажимается кнопка влево
                onButtonPressed();
            }
            if (Math.abs(x) < ACCEL_X_THRESHOLD_MAX && seekBar.getProgress() == 0) {
                // Нажимается кнопка вправо
                onButtonPressed();
            }
            if (Math.abs(z) > ACCEL_Z_THRESHOLD_MAX && seekBar.getProgress() == 0) {
                // Нажимается кнопка стоп
                onButtonPressed();
            }
            if (Math.abs(z) > ACCEL_Z_THRESHOLD_MAX2 && seekBar.getProgress() == 0) {
                // Нажимается кнопка вверх
                onButtonPressed();
            }
            if (Math.abs(z) > ACCEL_Z_THRESHOLD_MAX3 && seekBar.getProgress() == 0) {
                // Нажимается кнопка вниз
                onButtonPressed();
            }
            if (Math.abs(y) > ACCEL_Y_THRESHOLD && seekBar.getProgress() == 0) {
                // Нажимается кнопка вперед
                onButtonPressed();
            }
            if (Math.abs(y) > ACCEL_Y_THRESHOLD && seekBar.getProgress() == 0) {
                // Нажимается кнопка назад
                onButtonPressed();
            }
            if (seekBar.getProgress() == 255) {
                // Нажимается кнопка "запуск"
                onButtonPressed();
            }
        }


        @Override
        public void onAccuracyChanged (Sensor sensor,int accuracy){
            // Метод не требует реализации, но должен присутствовать
        }

        // Метод для отображения Toast-сообщения
        private void showToast (String message){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

    }
}

public class YourActivity extends AppCompatActivity {

    private RadioButton radioButtonProsthesis;
    private RadioButton radioButtonPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        radioButtonProsthesis = findViewById(R.id.radioButton);
        radioButtonPhone = findViewById(R.id.radioButton2);
        ChipGroup chipGroup = findViewById(R.id.bottom_panel);
        ImageView indicatorLight = chipGroup.findViewById(R.id.bottom_panel);

        // Добавляем обработчик событий для выбранного радиобаттона
        radioButtonProsthesis.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Зажигаем точку, когда выбран сигнал протеза
                indicatorLight.setVisibility(View.VISIBLE);
            } else {
                // Гасим точку, когда сигнал протеза не выбран
                indicatorLight.setVisibility(View.GONE);
            }
        });

        radioButtonPhone.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                // Зажигаем точку, когда выбран сигнал телефона
                indicatorLight.setVisibility(View.VISIBLE);
            } else {
                // Гасим точку, когда сигнал телефона не выбран
                indicatorLight.setVisibility(View.GONE);
            }
        });
    }
    private static final int REQUEST_CODE_PERMISSIONS = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Проверяем, есть ли у нас необходимые разрешения
        if (!hasPermissions(this, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS)) {
            // Если нет, запрашиваем их
            requestPermissions(new String[]{Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.READ_CONTACTS}, REQUEST_CODE_PERMISSIONS);
        } else {
            // Если разрешения есть, продолжаем работу

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Разрешения предоставлены, продолжаем работу

            } else {
                // Пользователь отказал в предоставлении разрешений

            }
        }
    }

    private static boolean hasPermissions(Context context, String... permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }
}
}
public class YourActivity<findViewById> extends AppCompatActivity {

    // Объявляем переменную для хранения экземпляра класса ButtonHandler.
    // Этот класс будет обрабатывать нажатия на кнопки.
    private ButtonHandler buttonHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Создаем новый экземпляр класса ButtonHandler.
        buttonHandler = new ButtonHandler();

        findViewById<Button> (R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Вызываем метод onBackButtonPressed из ButtonHandler, когда пользователь нажимает кнопку.
                buttonHandler.onBackButtonPressed();
            }
        });

        findViewById<Button> (R.id.stop_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonHandler.onStopButtonPressed();
            }
        });
        findViewById<Button> (R.id.play_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonHandler.onPlayButtonPressed();
            }
        });
        findViewById<Button> (R.id.next_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonHandler.onNextButtonPressed();
            }
        });
        findViewById<Button> (R.id.down_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonHandler.onDownButtonPressed();
            }
        });
        findViewById<Button> (R.id.up_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonHandler.onUpButtonPressed();
            }
        });

    }

    // Методы, которые будут вызваны из ButtonHandler для обработки нажатий на кнопки
    public void onBackButtonPressed() {
        // Логика закрытия
    }

    public void onStopButtonPressed() {
        // Логика остановки
    }

    public void onPlayButtonPressed() {
        // Логика воспроизведения
    }

    public void onNextButtonPressed() {
        // Логика перехода к следующему элементу
    }

    public void onDownButtonPressed() {
        // Логика перемещения вниз
    }

    public void onUpButtonPressed() {
        // Логика перемещения вверх
    }

}

}

