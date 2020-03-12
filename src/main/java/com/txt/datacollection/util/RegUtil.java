package com.txt.datacollection.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegUtil {

    public static String getNum(String str) {

        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(str);
        return m.replaceAll("").trim();
    }

}
