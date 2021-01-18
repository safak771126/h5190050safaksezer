package com.h5190050.safak_sezer_final.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190050.safak_sezer_final.model.DiziModel;
import com.h5190050.safak_sezer_final.R;
import com.h5190050.safak_sezer_final.util.GlideUtil;

import java.util.List;

public class DiziAdaptor extends RecyclerView.Adapter<DiziViewHolder> {


    List<DiziModel> diziler;
    Context context;
    OnItemClickListener listener;

    public interface OnItemClickListener { // Burada onclick özelliği vermek için interface özelliğini ekledik.
        void onClik(int position);
    }


    public DiziAdaptor(List<DiziModel> diziler, Context context, OnItemClickListener listener) {
        this.diziler = diziler; // gelen dizileri diziler değişkenine attım.
        this.context = context; // gelen contexti context değişkenine attım.
        this.listener = listener; // gelen listeneri listener değişkenine attım.
    }

    @NonNull
    @Override
    public DiziViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_diziler, parent, false);
        return new DiziViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull DiziViewHolder viewHolder, int position) {

        viewHolder.txtDiziAdi.setText(diziler.get(position).getDiziAdi()); // tıklanan dizinin adını viewholderdeki txtDiziAdi textViewinin textine attım.
        viewHolder.txtDiziTuru.setText(diziler.get(position).getDiziTuru());// tıklanan dizinin turunu viewholderdeki txtDiziTuru textViewinin textine attım.
        viewHolder.txtDiziSezon.setText(diziler.get(position).getDiziSezonu());// tıklanan dizinin Sezonunu viewholderdeki txtDiziSezon textViewinin textine attım.
        viewHolder.txtYapimYili.setText(diziler.get(position).getDiziYapimYili());// tıklanan dizinin Yapım Yılını viewholderdeki txtYapimYili textViewinin textine attım.
        GlideUtil.resmiIndiripGoster(context, diziler.get(position).getLogoUrl(), viewHolder.imgDiziLogo); //tıklanan dizinin logosunu glideUtildeki resimIndiripGoster methoduna
        //attım.
    }
    @Override
    public int getItemCount() {
        return diziler.size(); // dizilerin sizesini return ettim.
    }
}
