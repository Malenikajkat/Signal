package com.malenikajkat.signal;

import android.app.ActivityManager;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RemoteViews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.material.chip.ChipGroup;

public class AppWidgetService extends Service {

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        // Get the app widget id
        int appWidgetId = intent.getIntExtra(AppWpublic class YourActivity extends AppCompatActivity {

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
            private Button button;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.app_widget_layout);

                button = findViewById(R.id.app_widget_button);
            }

            public void toggleFunction(View view) {
                if (button.getText().equals("Функция отключена. Активируйте переключатель, чтобы исправить функцию")) {
                    button.setText("Функция включена. Чтобы выключить активируйте переключатель");
                } else {
                    button.setText("Функция отключена. Активируйте переключатель, чтобы исправить функцию");
                }
            }
        }
    }
}

