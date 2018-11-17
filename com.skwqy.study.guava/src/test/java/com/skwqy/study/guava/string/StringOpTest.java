package com.skwqy.study.guava.string;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class StringOpTest {

    /**
     * 字符串分割
     * <p>
     * 1 根据正则表达式分割
     * 2 trim分割后的字符串
     * 3 去除空字符串
     * 4 返回字符串迭代器，便于操作
     */
    @Test
    public void testStringSplit() {
        Iterable<String> splitResults = Splitter.onPattern("[,，]{1,}")
                .trimResults()
                .omitEmptyStrings()
                .split("hello,word,,世界，水平");
        for (String item : splitResults) {
            System.out.println(item);
        }
    }

    /**
     * 字符串二次分割
     * <p>
     * 1 正则表达式一次分割
     * 2 KeyValue形式二次分割
     *
     * 缺点：好像没办法将key、value做trim操作
     */
    @Test
    public void testString2ndSplit() {
        String toSplitString = "a=b;c=d,e=f;=keyEmpty,,valueEmpty=";
        Map<String, String> kvs = Splitter.onPattern("[,;]{1,}").withKeyValueSeparator('=').split(toSplitString);
        for (Map.Entry<String, String> entry : kvs.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(entry.getKey()).append(" = ").append(entry.getValue());
            System.out.println(sb.toString());
        }
    }

}