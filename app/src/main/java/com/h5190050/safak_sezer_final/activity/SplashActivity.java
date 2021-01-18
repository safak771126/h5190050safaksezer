package com.h5190050.safak_sezer_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import com.h5190050.safak_sezer_final.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        init(); // init methodunu çağırdım

    }

    private void init() {
        CountDownTimer timer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Log.e(getResources().getString(R.string.splashActivity_OnTick_Tag), getResources().getString(R.string.splashActivity_OnTick_Msg));
            }

            @Override
            public void onFinish() {
                if (InternetKontrol()) { // internet varsa listeEkranini Aç
                    listeEkraniniAc();
                } else { // İnternet Yoksa AlertDialogu çalıştır

                    AlertDialog.Builder builder = new AlertDialog.Builder(SplashActivity.this); // ALertdialog tanımladım
                    builder.setTitle(R.string.splashActivity_alertDialog_Title); // Alertdialogun başlığını Yazdım
                    builder.setMessage(R.string.splashActivity_alertDialog_Message); // ALertDİalogun Mesaj kısmını yazdım
                    builder.setPositiveButton(R.string.splashActivity_alertDialog_PositiveButton, new DialogInterface.OnClickListener() { // PositiveButton oluşturdum
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            startActivityForResult(new Intent(Settings.ACTION_WIFI_SETTINGS), 0); //Wifi Ayarlarına götürür
                        }
                    });
                    builder.setNegativeButton(R.string.splashActivity_alertDialog_NegativeButton, new DialogInterface.OnClickListener() { // NegativeButton oluşturdum
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish(); // bu ekranı öldürdüm
                        }
                    });
                    builder.show(); //ALertDialogu gösterdim
                }
            }
        }.start(); //ALertDialogu başlatttım
    }

    public boolean InternetKontrol() {
        ConnectivityManager manager = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        if (manager.getActiveNetworkInfo() != null
                && manager.getActiveNetworkInfo().isAvailable()   //Cihazın internete erişimi var mı kontrolü
                && manager.getActiveNetworkInfo().isConnected()) { // Cihaz internete Bağlımı kontrolü
            return true; // bağlıysa true değer dönüyor.
        } else {
            return false; // bağlı değilse false değer dönüyor
        }
    }

    private void listeEkraniniAc() {
        Intent intent = new Intent(getApplicationContext(), ListeActivity.class);
        startActivity(intent); // ListeActivity i açtım
        finish(); // bu ekranı öldürdüm
    }
}