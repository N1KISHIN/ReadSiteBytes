package com.n1kishin.repository;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class UserRepository {
    private String httpAnswer;

    /**
     * 2.Создать репозиторий UserRepository c конструктором,
     * принимающем на вход ссылку на ресурс, производящим
     * инициализацию поля типа String всей информации,
     * которую вернет сервер сайта
     */
    public UserRepository(String urlSite) throws IOException {
        URL url = new URL(urlSite);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        try (BufferedInputStream bufferedInputStream
                     = new BufferedInputStream(httpURLConnection.getInputStream())) {
            byte[] bytes = bufferedInputStream.readAllBytes();
            this.httpAnswer = new String(bytes);
        }
    }

    /**
     * 5.Через метод класса найти все вхождения заданной строки
     * в строке-поля класса, вернув их в виде списка.
     * Вхождением называется позиция, где встречается строка в строке
     */
    public ArrayList<Integer> getSubStringsIndexes(String subString) {
        ArrayList<Integer> res = new ArrayList<>();
        int currentIndex = 0;
        while ((currentIndex = this.httpAnswer.indexOf(subString, currentIndex)) != -1) {
            res.add(currentIndex);
            currentIndex += 1;
        }
        return res;
    }

    /**
     * 6.Найти для каждого символа }, {, ], [
     * сколько раз он встречается в строке-поля класса,
     * вернув результат в виде HashMap<Character, Integer>
     */
    public HashMap<Character, Integer> countBrakets() {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('{', 0);
        map.put('}', 0);
        map.put('[', 0);
        map.put(']', 0);
        for (int i = 0; i < this.httpAnswer.length(); i++) {
            char ch = this.httpAnswer.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            }
        }
        return map;
    }

    /**
     * 4.Написать метод toString
     */
    @Override
    public String toString() {
        return "UserRepository{" +
                "str='" + httpAnswer + '\'' +
                '}';
    }
}
