package com.example.tp2.Helpers;

import com.example.tp2.models.Article;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;

public class GsonHelper {

    public static List<Article> parseJson(String json) {
        Gson gson = new Gson();
        Type listType = new TypeToken<List<Article>>(){}.getType();
        return gson.fromJson(json, listType);
    }
}
