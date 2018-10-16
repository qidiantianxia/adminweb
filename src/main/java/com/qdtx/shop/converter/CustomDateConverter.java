package com.qdtx.shop.converter;

/**
 * 自定义日期转换器
 * Created by yn on 2018-10-16
 */

import java.text.SimpleDateFormat;


public class CustomDateConverter implements Converter<String, Date> {

    public Date convert(String source) {
        if (source != null && source.trim().length() > 0) {
            // 进行日期转换
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(source);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

}