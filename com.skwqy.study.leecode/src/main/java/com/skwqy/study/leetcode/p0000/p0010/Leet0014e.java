package com.skwqy.study.leetcode.p0000.p0010;

/**
 * @author skwqy
 * @Created on 2019 08 2019-08-18 11:05
 */
public class Leet0014e {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        StringBuilder pubStr = new StringBuilder();
        String tmpStr = strs[0];

        boolean found = false;
        for (int i = 0, len = tmpStr.length(); i < len && !found; i++) {
            pubStr.append(tmpStr.charAt(i));
            for (String str : strs) {
                if (str.indexOf(pubStr.toString()) != 0) {
                    found = true;
                    break;
                }
            }
        }
        if(!found){
            return pubStr.toString();
        }
        if (pubStr.length() <= 1) {
            return "";
        }
        return pubStr.substring(0, pubStr.length() - 1).toString();
    }
}
