package com.h5190050.safak_sezer_final.network;

import com.h5190050.safak_sezer_final.model.DiziModel;
import java.util.List;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("YabanciDizilerApi.json")
    Observable<List<DiziModel>> dizileriGetir(); // dizileriGetir adında bir list tanımladım ve içine DiziModeli attım.
}
