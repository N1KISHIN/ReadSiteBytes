package com.n1kishin.repository;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class UserRepository {
    private String str;
    public UserRepository(String urlSite) throws IOException {
        URL url = new URL(urlSite);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        try (BufferedInputStream bufferedInputStream
                = new BufferedInputStream(httpURLConnection.getInputStream())){
            byte[] bytes = bufferedInputStream.readAllBytes();
            this.str = new String(bytes);
        }
    }

    public ArrayList<Integer> getSubStrings(String subString) {
        ArrayList<Integer> res = new ArrayList<>();
        while () {

        }
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "str='" + str + '\'' +
                '}';
    }
}
