package com.copywrite.slacker.util;

import com.copywrite.slacker.storage.Env;

public class FileEncoder{

    public static byte[] getBytes(String content){
        return content.getBytes(Env.encodeFrom);
    }

    public static String encode(String content){
        byte[] bytes = getBytes(content);
        return new String(bytes, Env.encodeTo);
    }
}
