package com.yjf.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 余俊锋
 * @date 2020/10/13 18:29
 * @Description
 */
public class MyConvert implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd");
        try {
            Date date = dateFormat.parse(s);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
