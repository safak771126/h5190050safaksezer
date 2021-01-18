package com.h5190050.safak_sezer_final.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.h5190050.safak_sezer_final.R;
import com.h5190050.safak_sezer_final.model.DiziModel;
import com.h5190050.safak_sezer_final.util.Constants;
import com.h5190050.safak_sezer_final.util.GlideUtil;
import com.h5190050.safak_sezer_final.util.ObjectUtil;

public class DiziDetayActivity extends AppCompatActivity {

    ImageView imgKapak;
    TextView txtBaslik;
    TextView txtDetay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dizi_detay);
        init(); // init methodunu çağırdık.
    }

    private void init() {
        String tasinanDiziBasligi = getIntent().getStringExtra(Constants.TIKLANAN_DIZI_TASINAN_BASLIK);// put ettiğimiz dizinin başlığını aldık ve değişkene attık.
        DiziModel diziModel = ObjectUtil.jsonStringToDizi(tasinanDiziBasligi); //tasinanDiziBasligi değişkenini ObjectUtildeki jsonStringToDizi methoduna atıp onuda,
        //diziModel değişkenine attık.
        imgKapak = findViewById(R.id.imgKapak);
        txtBaslik = findViewById(R.id.txtBaslik);
        txtDetay = findViewById(R.id.txtDetay);

        txtBaslik.setText(diziModel.getDiziAdi());// dizinin adını txtBaslik TextViewinin textine attık

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            txtDetay.setText(Html.fromHtml(diziModel.getDiziKonusu(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            txtDetay.setText(Html.fromHtml(diziModel.getDiziKonusu())); //diziKonusunu txtDetay TextViewinin texttine attık.
        }

        GlideUtil.resmiIndiripGoster(getApplicationContext(), diziModel.getKapakFotoUrl(), imgKapak);
    }

}