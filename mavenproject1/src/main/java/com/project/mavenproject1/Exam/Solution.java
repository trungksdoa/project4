/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.mavenproject1.Exam;

import java.io.*;
import java.util.*;
import java.lang.Math;
import javax.validation.constraints.Max;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int isValid = (int) n % 10;
        String value = (isValid == 0 || isValid == 1 || isValid == 4 || isValid == 5 || isValid == 6 || isValid == 9) ? "YES" : "NO";   
        System.out.println(value);
    }
}
