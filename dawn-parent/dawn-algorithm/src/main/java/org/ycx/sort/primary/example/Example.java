package org.ycx.sort.primary.example;

import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;

/**
 * 初级排序算法例子.
 * @author :     guowc
 * @version :    1.0
 * @package :    org.ycx.sort.primary.example
 * @date :       2021/9/27 10:02
 * @copyright :  wpwl
 */
public class Example {

    public static void sort(Comparable[] a){

    }

    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w) < 0;
    }


    private static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for (int i = 1; i < a.length ; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 1; i <a.length ; i++) {
            if (less(a[i],a[i-1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] a = StdIn.readAllStrings();
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
