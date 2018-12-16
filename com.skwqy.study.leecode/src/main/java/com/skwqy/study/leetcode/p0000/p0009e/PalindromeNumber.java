package com.skwqy.study.leetcode.p0000.p0009e;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/16 11:23 AM
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        String tmp = String.valueOf(x);
        int length = tmp.length();
        int leftIndex = 0;
        int rightIndex = 0;
        if (length%2 !=0){
            leftIndex=rightIndex=length/2;
        }
        else{
            leftIndex=length/2-1;
            rightIndex=leftIndex+1;
        }

        for(;leftIndex>=0;){
            if(tmp.charAt(leftIndex) != tmp.charAt(rightIndex)){
                return false;
            }
            leftIndex--;
            rightIndex++;
        }
        return true;
    }
}
