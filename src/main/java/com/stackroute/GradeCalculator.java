package com.stackroute;


import java.util.*;
import java.util.Arrays;


import java.util.Map;
import java.util.HashMap;

import static java.lang.Integer.valueOf;

public class GradeCalculator {

    public static Map<Integer, String> calculateGrade(Map<Integer, Integer> scores) {


        Map<Integer, String> Map = new HashMap<Integer, String>();
        if (scores == null || scores.isEmpty()) {
            return null;
        }
        for (Integer key : scores.keySet()) {
            // System.out.println(key);
            int x = scores.get(key);
            if (x > 100) {
                // System.out.println("ignore");
                continue;

            } else if (x >=80 ) {
                // System.out.println("A");
                Map.put(key, "A");
            } else if (x < 80 && x >= 60) {
                //System.out.println("B");
                Map.put(key, "B");
            } else if (x < 60 && x >= 45) {
                //System.out.println("c");
                Map.put(key, "C");
            } else  {
                // System.out.println("d");
                Map.put(key, "D");
            }

        }
        //System.out.println("Initial Mappings are: " +Map);
        Map<Integer, String> sortedMap = new TreeMap<Integer, String>(Map);

        // System.out.println("Sorted Map   : " + sortedMap);

        return (sortedMap);


    }

    //Do not print anything other than what's expected/asked in problem
    public static void main(String[] args) {
        //Use Scanner to get input from console
        //get roll number and score

        Scanner sc = new Scanner(System.in);
       // Scanner sc1 = new Scanner(System.in);
        HashMap<Integer, Integer> scores = new HashMap<Integer, Integer>();
        Integer num;
        Integer i = 0;

        num = sc.nextInt();
        //get roll number and score
        String input;
        for (i = 0; i < num; i++) {
            // System.out.println("enter");
            int key=sc.nextInt();
            int value=sc.nextInt();

            //System.out.println(splitStr.length);
            //Integer key = valueOf(keys);
            //Integer value = valueOf(values);
            scores.put(key, value);
        }
        // System.out.println("Initial Mappings are: " + scores);
       Map<Integer,String> out= GradeCalculator.calculateGrade(scores);
        for (Map.Entry map:out.entrySet()) {
            System.out.println(map.getKey().toString() + " " + map.getValue().toString()+" ");
        }
    }
}