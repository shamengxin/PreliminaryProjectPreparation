package com.shamengxin.test;

import java.util.UUID;

public class Test1 {
    public static void main(String[] args) {
        UUID uuid=UUID.randomUUID();

        String str=uuid.toString();

        str = str.replaceAll("-", "");
        System.out.println(str);
        System.out.println(str.length());

    }
}
