package com.planifylab;

import com.google.gson.Gson;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonLoader {

    public static InputData load(String path) throws Exception {
        String json = Files.readString(Path.of(path));
        Gson gson = new Gson();
        return gson.fromJson(json, InputData.class);
    }
}
