package com.pret.api.service.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class TestClass {

    private List<Character> list;

    private Map<String, Integer> map;

    public void test() throws NoSuchFieldException {
        Field listField = TestClass.class.getDeclaredField("list");
        Field mapField = TestClass.class.getDeclaredField("map");
        //对比 Field 类的 getType() 和 getGenericType()
        System.out.println(listField.getType());        // interface java.util.List
        System.out.println(listField.getGenericType()); // java.util.List<java.lang.Character>
        System.out.println(mapField.getType());         // interface java.util.Map
        System.out.println(mapField.getGenericType());  // java.util.Map<java.lang.String, java.lang.Integer>

        //获取 list 字段的泛型参数
        ParameterizedType listGenericType = (ParameterizedType) listField.getGenericType();
        Type[] listActualTypeArguments = listGenericType.getActualTypeArguments();
        for (int i = 0; i < listActualTypeArguments.length; i++) {
            System.out.println(listActualTypeArguments[i]);
        }
        // class java.lang.Character

        //获取 map 字段的泛型参数
        ParameterizedType mapGenericType = (ParameterizedType) mapField.getGenericType();
        Type[] mapActualTypeArguments = mapGenericType.getActualTypeArguments();
        for (int i = 0; i < mapActualTypeArguments.length; i++) {
            System.out.println(mapActualTypeArguments[i]);
        }
        // class java.lang.String
        // class java.lang.Integer
    }

    public static void main(String[] args) throws NoSuchFieldException {
        new TestClass().test();
    }
}
