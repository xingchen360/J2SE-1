package com.somnus.io;

/** 
 * @Title: NagativeThinking.java 
 * @Package com.somnus.io 
 * @Description: TODO
 * @author Somnus
 * @date 2015年5月20日 下午4:25:27 
 * @version V1.0 
 */
public class NagativeThinking {

    public static void main(String[] args) {
        /* Demo     7          -7               -7
         * 原码          00000111    1 0000111     1 000000000000000000000000000111
         * 反码          00000111    1 1111000     1 111111111111111111111111111000
         * 补码          00000111    1 1111001     1 111111111111111111111111111001
         */
        int a = -7;//
        byte b = -7;//
        
        System.out.println(Integer.toBinaryString(a));//1 1111111111111111111111111111001
        //111111111111111111111111 11111001 都要以补码的形式参与计算
        //  &
        //000000000000000000000000 11111111 都要以补码的形式参与计算（正数的补码是自身）
        //10000111
        System.out.println(Integer.toBinaryString(b & 0xff/*249*/));//1 1111001
        System.out.println(Integer.toHexString(b & 0xff/*249*/));//f9
        
        int c = 7;
        byte d = 7;
        
        System.out.println(Integer.toBinaryString(c));//0 0000000000000000000000000000111
        System.out.println(Integer.toBinaryString(d));//0 0000111
        System.out.println(Integer.toHexString(d));//7
    }

}
