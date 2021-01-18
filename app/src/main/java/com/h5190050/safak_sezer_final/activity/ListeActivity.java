package com.h5190050.safak_sezer_final.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.h5190050.safak_sezer_final.R;
import com.h5190050.safak_sezer_final.adaptor.DiziAdaptor;
import com.h5190050.safak_sezer_final.model.DiziModel;
import com.h5190050.safak_sezer_final.network.Service;
import com.h5190050.safak_sezer_final.util.Constants;
import com.h5190050.safak_sezer_final.util.ObjectUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ListeActivity extends AppCompatActivity {

    ProgressDialog progressDialog;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        init();//init methodunu çagırdım
    }

    private void init() {
        progressDialog = new ProgressDialog(ListeActivity.this); //ListeActivityde progressDialog oluşturdum.
        progressDialog.setMessage(getResources().getString(R.string.listeActivity_progressDialog_message)); //progressDialoga lütfen bekleyiniz mesajı bastım
        progressDialog.show(); // progressDialogu gösterdim
        dizileriGetir(); // dizileriGetir methodunu çağırdım
    }

    @Override
    public void onBackPressed() { //Geri Tuşuna Basılırsa;
        AlertDialog.Builder builder = new AlertDialog.Builder(ListeActivity.this); // builder adında AlertDialog oluşturdum.
        builder.setMessage(R.string.listeActivity_alertDialog_Message); // alertDialogun mesaj kısmını yazdım.
        builder.setPositiveButton(R.string.listeActivity_alertDialog_PositiveButton, new DialogInterface.OnClickListener() { // positiveButton oluşturdum
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // eğer kullanıcı evete tıklarsa ekran ölecek.
            }
        });
        builder.setNegativeButton(R.string.listeActivity_alertDialog_NegativeButton, new DialogInterface.OnClickListener() { // negativeButton oluşturdum
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); // eğer kullanıcı hayıra tıklarsa dialog kapatılacak.
            }
        });
        builder.show(); // alertDialogu gösterdim
    }

    void dizileriGetir() {

        new Service().getServiceApi().dizileriGetir(). //serviceApinin içindeki dizileriGetir methoduna eriştim
                subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()) // değişiklik var mı diye dinliyorum.
                .subscribe(new Observer<List<DiziModel>>() { //subcribe oldum ve diziModel listine eriştim

                    List<DiziModel> diziler = new ArrayList<>();

                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e(getResources().getString(R.string.listeActivity_onSubscribe_log_tag), getResources().getString(R.string.listeActivity_onSubscribe_log_msg));
                    }

                    @Override
                    public void onNext(List<DiziModel> diziModelList) {
                        Log.e(getResources().getString(R.string.listeActivity_onNext_log_tag), getResources().getString(R.string.listeActivity_onNext_log_msg));
                        diziler = diziModelList; //DiziModelListi diziler Arraylistine ekledim.
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(getResources().getString(R.string.listeActivity_onError_log_tag), getResources().getString(R.string.listeActivity_onError_log_msg) + e.getLocalizedMessage()); // gelecek olan erroru bastım.
                    }

                    @Override
                    public void onComplete() {
                        Log.e(getResources().getString(R.string.listeActivity_onComplete_log_tag), getResources().getString(R.string.listeActivity_onComplete_log_msg));
                        if (diziler.size() > 0) {

                            initRecycleView(diziler); // dizilerin sizesi 0 dan büyükse initReycleViewe dizileri yolla
                        }
                        progressDialog.dismiss(); // progressDialogu liste yüklenince kapattım.
                    }
                });
    }


    private void initRecycleView(List<DiziModel> diziModelList) {
        recyclerView = findViewById(R.id.rcvDiziler);
        DiziAdaptor diziAdaptor = new DiziAdaptor(diziModelList, getApplicationContext(), new DiziAdaptor.OnItemClickListener() {//gelen dizileri diziAdaptore attık
            @Override
            public void onClik(int position) {

                DiziModel tiklananDizi = diziModelList.get(position); // tıklanan dizinin pozisyonunu alıp tıklananDizi'ye atadım.
                Toast.makeText(getApplicationContext(), getResources().getString(R.string.listeActivity_Toast) + tiklananDizi.getDiziAdi(), Toast.LENGTH_SHORT).show();// tıklanan dizinin adını Toast bastım
                openNextActivity(tiklananDizi); //tıklananDizinin pozisyonunu openNextActivity e gönderdim
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(diziAdaptor);
    }

    private void openNextActivity(DiziModel tiklananDizi) {
        Intent intent = new Intent(getApplicationContext(), DiziDetayActivity.class); // intent adında bir Intent tanımladım
        String tiklananDiziString = ObjectUtil.diziToJsonString(tiklananDizi); // tıklananDizinin pozistonunu objectUtildeki diziToJsonStringe attım sonra onuda,
        // tıklananDiziString değişkenine atım
        intent.putExtra(Constants.TIKLANAN_DIZI_TASINAN_BASLIK, tiklananDiziString);//tıklanan dizinin başlığını putExtrayla put ettim
        startActivity(intent); //ve startActivityle ekranı açtım
    }
}