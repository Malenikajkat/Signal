package com.malenikajkat.signal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Настройка BottomNavigationView для обработки нажатий
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.sensors_button -> {
                    // Обработка нажатия на кнопку "Запуск"
                    R.id.sensors_button
                    true
                }
                R.id.training_button -> {
                    // Обработка нажатия на кнопку "Обучение"
                    R.id.training_button
                    true
                }
                R.id.settings_button -> {
                    // Обработка нажатия на кнопку "Настройки"
                    R.id.settings_button
                    true
                }
                else -> false
            }
        }
    }
}