package com.malenikajkat.signal;

import android.widget.SeekBar;

public class SeekBarController {
    private SeekBar seekBar;

    public SeekBarController(SeekBar seekBar) {
        this.seekBar = seekBar;
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Обработка изменения прогресса seekBar
                // Здесь можно вызвать методы для управления другими компонентами приложения
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // Обработка начала взаимодействия с seekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // Обработка окончания взаимодействия с seekBar
            }
        });
    }
}

