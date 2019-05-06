package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Date 2019/2/26 17:11
 **/
public class test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("12");
        list.add("123");
        list.add("1234");

        List<String> list1 = list.stream().filter(s -> s.equals("12`123")).collect(Collectors.toList());

        Thread thread = new Thread(()-> System.out.println(""));


        List<Double> cost = Arrays.asList(10.0, 20.0, 30.0);
        cost.stream().map(x -> x + x * 0.05).forEach(x -> System.out.println(x));
    }

}
