package com.h5190050.safak_sezer_final.util;

import com.google.gson.Gson;
import com.h5190050.safak_sezer_final.model.DiziModel;

public class ObjectUtil {

    public  static String diziToJsonString(DiziModel diziModel)
    {
        Gson gson = new Gson(); //gson adında Gson tanımladım.
        return   gson.toJson(diziModel); //gelen diziModeli return ettim.
    }

    public  static DiziModel jsonStringToDizi(String jsonString)
    {
        Gson gson = new Gson(); //gson adında Gson tanımladım.
        return  gson.fromJson(jsonString,DiziModel.class); // gelen jsonStringi return ettim.
    }
}
