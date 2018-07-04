package com.wangj.smartion.smartion.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

public class GsonUtils {
    private static Gson mGson = null;

    static {
        if (mGson == null) {
            mGson = new Gson();
        }
    }

    private GsonUtils() {
    }

    /**
     * 转成json
     *
     * @param object
     * @return
     */
    public static String GsonString(Object object) {
        String gsonString = null;
        if (mGson != null) {
            gsonString = mGson.toJson(object);
        }
        return gsonString;
    }

    /**
     * 转成bean
     * @param gsonString
     * @param cls
     * @param <T>
     * @return
     */
    public static <T> T GsonToBean(String gsonString, Class<T> cls) {
        T t = null;
        if (mGson != null) {
            t = mGson.fromJson(gsonString, cls);
        }
        return t;
    }

    /**
     * 转成List
     * @param <T>
     * @return
     */
    public  static <T> List<T> GsonToList(String gsonString,Class<T> cls){
        List<T> list = null;
        if (mGson != null)
        {
            list = mGson.fromJson(gsonString ,new TypeToken<List<T>>(){}.getType());
        }
        return list;
    }

    /**
     * 转成list中有map的
     * @param gsonString
     * @param <T>
     * @return
     */
    public static <T> List<Map<String ,T>> GsonToListMap(String gsonString){
        List<Map<String,T>> list = null;
        if (mGson !=null){
            list = mGson.fromJson(gsonString,new TypeToken<List<Map<String,T>>>(){}.getType());
        }
        return list;
    }


    /**
     * 转成map
     * @param gsonString
     * @param <T>
     * @return
     */
    public static <T> Map<String,T> GsonToMap(String gsonString){
        Map<String ,T> map = null;
        if (mGson !=null)
        {
            map = mGson.fromJson(gsonString , new TypeToken<Map<String,T>>(){}.getType());
        }
        return map;
    }

}
