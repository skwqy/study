package com.skwqy.study.leetcode.p0000.p0005m;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/8 8:27 PM
 */
public class LongestSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2){
            return s;
        }

        String maxLenStr = s.substring(0,1);
        String tmpLenStr;
        for (int idx=0;idx<s.length();idx++){
            // 中心位置为1个字母
            tmpLenStr = getPalindromicSubStr(s,idx,idx);
            if(tmpLenStr.length()>maxLenStr.length()){
                maxLenStr = tmpLenStr;
            }

            // 中心位置为2个相同的字母
            tmpLenStr = getPalindromicSubStr(s,idx,idx+1);
            if(tmpLenStr.length()>maxLenStr.length()){
                maxLenStr = tmpLenStr;
            }

        }
        return maxLenStr;
    }

    private String getPalindromicSubStr(String str,int startIdx,int endIdx){
        while(startIdx>=0 && endIdx< str.length()&& str.charAt(startIdx) == str.charAt(endIdx)){
            startIdx--;
            endIdx++;
        }
        return str.substring(startIdx+1,endIdx);
    }
}
