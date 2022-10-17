package com.shortstv.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.util.Map;

/**
 * @Author xu xiao wei
 * @description GSON基础工具类
 * @ClassName shortsTV
 * @Package com.shortstv.utils
 * @Date 2022/10/17 23:44
 * @Version 1.0
 */
public class GsonUtil {
    private static Gson GSON = new Gson();

    private GsonUtil() {
    }

    /**
     * 对象转json字符串
     *
     * @param obj 待转换object
     * @return 返回转换后的json字符串
     */
    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }

    /**
     * 字符串转对象
     *
     * @param json 待转字符串
     * @param clz  需要转换的类型
     * @param <T>  泛型支持各种类型
     * @return 返回的转换结果
     */
    public static <T> T toBean(String json, Class<T> clz) {
        return GSON.fromJson(json, clz);
    }

    /**
     * 字符串转为List，List里面的需要是Object
     *
     * @param json  待转字符串
     * @param clz   需要转换的类型
     * @param <T>   泛型【T为object】
     * @return  返回转换的结果 List<T>
     */
    public static <T> List<T> toBeanList(String json, Class<T> clz) {
        return GSON.fromJson(json, new TypeToken<List<T>>() {
        }.getType());
    }

    /**
     * 字符串转为List，List里面的需要是Map<String, T>
     *
     * @param json 待转字符串
     * @param <T> 泛型【T为Map】
     * @return 返回转换的结果 List<Map<String, T>>
     */
    public static <T> List<T> toMapList(String json) {
        return GSON.fromJson(json, new TypeToken<List<Map<String, T>>>() {
        }.getType());
    }

    /**
     * 字符串转为Map<String, Object>
     *
     * @param json 待转字符串
     * @param <T> 泛型【T为Object】
     * @return 返回转换的结果Map<String, T>
     */
    public static <T> Map<String, T> toMap(String json) {
        return GSON.fromJson(json, new TypeToken<Map<String, T>>() {
        }.getType());
    }
}
