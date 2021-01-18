package com.h5190050.safak_sezer_final.adaptor;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.h5190050.safak_sezer_final.R;

import org.w3c.dom.Text;

public class DiziViewHolder extends RecyclerView.ViewHolder {

    ImageView imgDiziLogo;
    TextView txtDiziAdi;
    TextView txtDiziTuru;
    TextView txtDiziSezon;
    TextView txtYapimYili;

    public DiziViewHolder(@NonNull View itemView, DiziAdaptor.OnItemClickListener listener) {
        super(itemView);

        imgDiziLogo =itemView.findViewById(R.id.imgDiziLogo);
        txtDiziAdi =itemView.findViewById(R.id.txtDiziAdi);
        txtDiziTuru =itemView.findViewById(R.id.txtDiziTuru);
        txtDiziSezon =itemView.findViewById(R.id.txtDiziSezon);
        txtYapimYili = itemView.findViewById(R.id.txtYapimYili);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClik(getAdapterPosition()); //Adaptörün pozisyonunu belirledik ve listenere gönderdik.
            }
        });
    }
}
