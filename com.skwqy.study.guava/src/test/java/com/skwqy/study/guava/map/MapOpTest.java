package com.skwqy.study.guava.map;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Multimap;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author skwqy
 * @Created 2018 11 2018/11/17 10:51 AM
 */
public class MapOpTest {

    @Test
    public void testBiMap() {
        BiMap<String, String> weekNameMap = HashBiMap.create();
        weekNameMap.put("星期一", "Monday");
        weekNameMap.put("星期二", "Tuesday");
        weekNameMap.put("星期三", "Wednesday");
        weekNameMap.put("星期四", "Thursday");
        weekNameMap.put("星期五", "Friday");
        weekNameMap.put("星期六", "Saturday");
        weekNameMap.put("星期日", "Sunday");

        System.out.println("星期日的英文名是: " + weekNameMap.get("星期日"));
        System.out.println("Sunday的中文是: " + weekNameMap.inverse().get("Sunday"));
    }

    @Test
    public void testMultiMap() {
        Multimap<String, String> myMultimap = ArrayListMultimap.create();
        myMultimap.put("Fruits", "Bannana");
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Vegetables", "Carrot");

        Assert.assertEquals(4,myMultimap.size());

        // 获得Fruits对应的所有的值
        Collection<String> fruits = myMultimap.get("Fruits");
        System.out.println(fruits); // [Bannana, Apple, Pear]

        Collection<String> vegetables = myMultimap.get("Vegetables");
        System.out.println(vegetables); // [Carrot]

        //遍历Mutlimap
        for (String value : myMultimap.values()) {
            System.out.println(value);
        }
        //遍历Mutlimap
        for (Map.Entry<String,String> entry : myMultimap.entries()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }

        // Removing a single value
        myMultimap.remove("Fruits", "Pear");
        System.out.println(myMultimap.get("Fruits")); // [Bannana, Pear]

        // Remove all values for a key
        myMultimap.removeAll("Fruits");
        System.out.println(myMultimap.get("Fruits")); // [] (Empty Collection!)
    }

}