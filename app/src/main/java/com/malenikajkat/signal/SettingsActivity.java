package com.malenikajkat.signal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class SettingsActivity extends Activity {

    private Spinner musicAppSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Инициализация Spinner
        musicAppSpinner = findViewById(R.id.music_app_spinner);

        // Создание массива с названиями приложений
        String[] musicApps = new String[] {
                "Яндекс.Музыка",
                "VKМузыка",
                "МТС Музыка",
                "YouTube Music"
        };

        // Создание адаптера для Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, musicApps);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        musicAppSpinner.setAdapter(adapter);

        // Обработчик выбора элемента в Spinner
        musicAppSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Здесь можно добавить код для запуска выбранного приложения
                // Например, запуск приложения с помощью Intent
                Intent intent = null;
                switch (position) {
                    case 0:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("yandexmusic://"));
                        break;
                    case 1:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("vkmusic://"));
                        break;
                    case 2:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mtsmusic://"));
                        break;
                    case 3:
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("youtube://"));
                        break;
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nothing to do here
            }
        });
    }
}
