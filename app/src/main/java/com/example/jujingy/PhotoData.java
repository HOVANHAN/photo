package com.example.jujingy;

import java.util.ArrayList;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PhotoData {
    private static Context context;

    public static void init(Context context) {
        PhotoData.context = context;
    }

    public static ArrayList<Photo> getPhotos() {
        ArrayList<Photo> photos = new ArrayList<>();

        try {
            String jsonString = loadJSONFromAsset("photo.json"); // Assuming the JSON file is named photos.json and is located in the assets folder
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int id = jsonObject.getInt("id");
                String source = jsonObject.getString("source");
                String title = jsonObject.getString("title");
                String description = jsonObject.getString("description");
                photos.add(new Photo(id, source, title, description));
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        return photos;
    }

    private static String loadJSONFromAsset(String fileName) throws IOException {
        String jsonString;
        InputStream inputStream = context.getAssets().open(fileName);
        int size = inputStream.available();
        byte[] buffer = new byte[size];
        inputStream.read(buffer);
        inputStream.close();
        jsonString = new String(buffer, "UTF-8");
        return jsonString;
    }

    public static Photo getPhotoById(int id) {
        Photo photo = null;

        try {
            String jsonString = loadJSONFromAsset("photo.json"); // Assuming the JSON file is named photos.json and is located in the assets folder
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                int photoId = jsonObject.getInt("id");

                if (photoId == id) {
                    String source = jsonObject.getString("source");
                    String title = jsonObject.getString("title");
                    String description = jsonObject.getString("description");
                    photo = new Photo(id, source, title, description);
                    break;
                }
            }

        } catch (JSONException | IOException e) {
            e.printStackTrace();
        }

        return photo;
    }
}

