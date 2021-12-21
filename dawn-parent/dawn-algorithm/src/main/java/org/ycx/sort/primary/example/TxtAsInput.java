package org.ycx.sort.primary.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * 将txt文件做为输入参数
 *
 * @author :     guowc
 * @version :    1.0
 * @package :    org.ycx.sort.primary.example
 * @date :       2021/10/21 14:11
 * @copyright :  wpwl
 */
public class TxtAsInput {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("D:\\install\\算法\\algs4-data\\tiny.txt"));

        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
