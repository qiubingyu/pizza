package com.bin.util;

import java.util.Collection;

public class Collections {

    public static boolean isEmpty(Collection c){
        return c == null || c.isEmpty();
    }

    public static boolean isNotEmpty(Collection c){
        return !isEmpty(c);
    }

}
