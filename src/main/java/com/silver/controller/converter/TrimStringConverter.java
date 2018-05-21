package com.silver.controller.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 去除前后空格的转换器
 * @author 光玉
 * @create 2018-05-20 16:45
 **/
public class TrimStringConverter implements Converter<String,String> {
    // 编写去除前后空格的转换器
    // 若去除空格后字符串为空，则返回null，否则返回去空格后的字符串
    @Override
    public String convert(String source){
        try{
            if(source != null){
                source=source.trim();
                if(source.equals("")){
                    return null;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return source;
    }
}
