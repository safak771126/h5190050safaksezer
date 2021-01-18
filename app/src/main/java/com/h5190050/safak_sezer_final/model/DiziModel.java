package com.h5190050.safak_sezer_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DiziModel {
    @SerializedName("DiziAdi")
    @Expose
    private String diziAdi;
    @SerializedName("DiziTuru")
    @Expose
    private String diziTuru;
    @SerializedName("DiziSezonu")
    @Expose
    private String diziSezonu;
    @SerializedName("DiziYapimYili")
    @Expose
    private String diziYapimYili;
    @SerializedName("KapakFotoUrl")
    @Expose
    private String kapakFotoUrl;
    @SerializedName("LogoUrl")
    @Expose
    private String logoUrl;
    @SerializedName("DiziKonusu")
    @Expose
    private String diziKonusu;

    public String getDiziAdi() {
        return diziAdi;
    }

    public void setDiziAdi(String diziAdi) {
        this.diziAdi = diziAdi;
    }

    public String getDiziTuru() {
        return diziTuru;
    }

    public void setDiziTuru(String diziTuru) {
        this.diziTuru = diziTuru;
    }

    public String getDiziSezonu() {
        return diziSezonu;
    }

    public void setDiziSezonu(String diziSezonu) {
        this.diziSezonu = diziSezonu;
    }

    public String getDiziYapimYili() {
        return diziYapimYili;
    }

    public void setDiziYapimYili(String diziYapimYili) {
        this.diziYapimYili = diziYapimYili;
    }

    public String getKapakFotoUrl() {
        return kapakFotoUrl;
    }

    public void setKapakFotoUrl(String kapakFotoUrl) {
        this.kapakFotoUrl = kapakFotoUrl;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getDiziKonusu() {
        return diziKonusu;
    }

    public void setDiziKonusu(String diziKonusu) {
        this.diziKonusu = diziKonusu;
    }
}
