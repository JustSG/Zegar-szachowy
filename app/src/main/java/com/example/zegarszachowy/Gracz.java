package com.example.zegarszachowy;

import android.os.CountDownTimer;
import android.widget.Button;

public class Gracz {
    int liczbaSekund = 180;
    boolean czyAktywny = false;
    CountDownTimer countDownTimer;
    Button button;
    String czasDoWyswietlenia;
    int sekundy;

    public Gracz(boolean czyAktywny, Button button) {
        this.czyAktywny = czyAktywny;
        this.button = button;
    }

    public void liczCzas(){
        czyAktywny = true;
        countDownTimer = new CountDownTimer(liczbaSekund*1000, 1000) { // co będę liczył i jaki interwał \\ co 1000 interwałów uruchania się 1 tick zapisany jako l
            @Override
            public void onTick(long l) {
                liczbaSekund = (int)(l/1000);
                int s60 = liczbaSekund % 60;
                int h60 = liczbaSekund / 3600;
                int m60 = (liczbaSekund - h60 * 3600) / 60;
                czasDoWyswietlenia = String.format("%02d:%02d",m60, s60);
                button.setText(String.valueOf(czasDoWyswietlenia));
            }

            @Override
            public void onFinish() {
                button.setText("KONIEC");
                button.setActivated(false);
            }
        };
        countDownTimer.start();
    }
    public void stopCzas(){
        czyAktywny = false;
        countDownTimer.cancel();
    }
}
