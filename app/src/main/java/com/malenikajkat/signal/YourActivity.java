package com.malenikajkat.signal;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

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

    // Добавляем новую переменную для отслеживания состояния порога
    private boolean thresholdPassed = false;

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
                thresholdPassed = true;
            }

            if (Math.abs(y) > ACCEL_Y_THRESHOLD) {
                // Действие, если значение по оси y превышает порог
                thresholdPassed = true;
            }

            if (Math.abs(z) > ACCEL_Z_THRESHOLD) {
                // Действие, если значение по оси z превышает порог
                thresholdPassed = true;
            }
        } else if (event.sensor.getType() == Sensor.TYPE_GYROSCOPE) {
            // Обработка данных гироскопа
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];

            // Сравнение значений с пороговыми значениями
            if (Math.abs(x) > GYRO_X_THRESHOLD) {
                // Действие, если значение по оси x превышает порог
                thresholdPassed = true;
            }

            if (Math.abs(y) > GYRO_Y_THRESHOLD) {
                // Действие, если значение по оси y превышает порог
                thresholdPassed = true;
            }

            if (Math.abs(z) > GYRO_Z_THRESHOLD) {
                // Действие, если значение по оси z превышает порог
                thresholdPassed = true;
            }
        }

        // Проверяем, был ли порог пройден
        if (thresholdPassed) {

        }
    }

    @Override

    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Метод не требует реализации, но должен присутствовать
    }

    // Метод для отображения Toast-сообщения
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}


private void onButtonPressed() {

    Log.i("Button", "Button pressed");
}


public class ButtonPresser {
    // Метод для нажатия кнопки влево
    public void pressLeftButton() {
        // Здесь должен быть код, который выполняется при нажатии кнопки влево
        System.out.println("Кнопка влево нажата");
    }

    // Метод для нажатия кнопки вправо
    public void pressRightButton() {
        // Здесь должен быть код, который выполняется при нажатии кнопки вправо
        System.out.println("Кнопка вправо нажата");
    }

    // Метод для нажатия кнопки стоп
    public void pressStopButton() {
        // Здесь должен быть код, который выполняется при нажатии кнопки стоп
        System.out.println("Кнопка стоп нажата");
    }

    // Метод для нажатия кнопки вверх
    public void pressUpButton() {
        // Здесь должен быть код, который выполняется при нажатии кнопки вверх
        System.out.println("Кнопка вверх нажата");
    }

    // Метод для нажатия кнопки вниз
    public void pressDownButton() {
        // Здесь должен быть код, который выполняется при нажатии кнопки вниз
        System.out.println("Кнопка вниз нажата");
    }

    // Метод для нажатия кнопки вперед
    public void pressForwardButton() {
        // Здесь должен быть код, который выполняется при нажатии кнопки вперед
        System.out.println("Кнопка вперед нажата");
    }

    // Метод для нажатия кнопки назад
    public void pressBackButton() {
        // Здесь должен быть код, который выполняется при нажатии кнопки назад
        System.out.println("Кнопка назад нажата");
    }

    // Метод для нажатия кнопки "запуск"
    public void pressStartButton() {
        // Здесь должен быть код, который выполняется при нажатии кнопки "запуск"
        System.out.println("Кнопка 'запуск' нажата");
    }
}

}


public class YourActivity extends AppCompatActivity {

    private RadioButton radioButtonProsthesis;

    private RadioButton radioButtonPhone;

    private ChipGroup chipGroup;

    private ImageView indicatorLight;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);

        radioButtonProsthesis = findViewById(R.id.radioButton);
        radioButtonPhone = findViewById(R.id.radioButton2);
        chipGroup = findViewById(R.id.bottom_panel);
        indicatorLight = findViewById(R.id.bottom_panel); // Исправлено: Используйте правильный ID для индикатора

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

    private static boolean hasPermissions(Context context, String...permissions) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
            for (String permission: permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }

        return true;
    }

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_widget_layout);

        button = findViewById(R.id.app_widget_button); // Исправлено: Используйте правильный ID для кнопки
    }

    public void toggleFunction(View view) {
        if (button.getText().equals("Функция отключена. Активируйте переключатель, чтобы исправить функцию")) {
            button.setText("Функция включена. Чтобы выключить активируйте переключатель");
        } else {
            button.setText("Функция отключена Активируйте переключатель, чтобы исправить функцию");
        }
    }

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

public class YourActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_widget_layout);

        // Получаем ID виджета приложения
        int appWidgetId = getApplicationWidgetId();
        // Теперь вы можете использовать ID виджета для работы с виджетами приложения
    }
}

