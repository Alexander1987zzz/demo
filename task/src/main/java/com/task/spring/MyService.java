package com.task.spring;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

//@Service
//public class MyService {
//    private static ArrayList<String> words;
//    private static final int wordsCount = 10;
//
//    public static ArrayList<String> getWords() {
//        words = new ArrayList<>();
//        String response = requestRandomWord();
//        log.debug("getWords: " + response);
//        for (int i = 0; i < wordsCount; i++) {
//            try {
//                words.add(new JSONArray(response).getJSONObject(i).getString("word"));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//        return words;
//    }
//
//    private static String requestRandomWord() {
//        //go to 10.5.12.5
//    }
//}
