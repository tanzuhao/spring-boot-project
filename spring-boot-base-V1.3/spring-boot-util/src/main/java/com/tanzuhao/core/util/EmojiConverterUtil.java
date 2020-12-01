package com.tanzuhao.core.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @描述：
 * @author： Seven.
 * @公司名称: 广东叮趣科技有限公司
 * @创建日期：2018年12月17日 上午10:19:12.
 * @版本：V1.0
 */
public class EmojiConverterUtil {
 
    /**
     * @Description 将字符串中的emoji表情转换成可以在utf-8字符集数据库中保存的格式（表情占4个字节，需要utf8mb4字符集）
     * @param str
     * 待转换字符串
     * @return 转换后字符串
     * @throws UnsupportedEncodingException
     * exception
     */
    public static String emojiConvert1(String str)
           {
        String patternString = "([\\x{10000}-\\x{10ffff}\ud800-\udfff])";
 
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            try {
                matcher.appendReplacement(
                        sb,
                        "[["
                                + URLEncoder.encode(matcher.group(1),
                                "UTF-8") + "]]");
            } catch(UnsupportedEncodingException e) {
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
 
    /**
     * @Description 还原utf8数据库中保存的含转换后emoji表情的字符串
     * @param str
     * 转换后的字符串
     * @return 转换前的字符串
     * exception
     */
    public static String emojiRecovery2(String str){
        String patternString = "\\[\\[(.*?)\\]\\]";
 
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(str);
 
        StringBuffer sb = new StringBuffer();
        while(matcher.find()) {
            try {
                matcher.appendReplacement(sb,
                        URLDecoder.decode(matcher.group(1), "UTF-8"));
            } catch(UnsupportedEncodingException e) {
 
            }
        }
        matcher.appendTail(sb);
        return sb.toString();
    }
}