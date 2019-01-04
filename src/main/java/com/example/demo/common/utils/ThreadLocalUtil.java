package com.example.demo.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * GO:
 * Created By JiWei.Chen 2018-12-28
 */
public class ThreadLocalUtil {

    private static final ThreadLocal<Map<String, Object>> local = new ThreadLocal(){
        @Override
        protected Map initialValue() {
            return new HashMap();
        }
    };

    public static void set(String key,Object obj){
        local.get().put(key, obj);
    }

    public static Object get(String key){
        return local.get().get(key);
    }

    public static void remove(String key){
        local.get().remove(key);
    }


}
