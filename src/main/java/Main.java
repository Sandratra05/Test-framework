package main.java;


import annotations.TestUrl;
import annotations.UrlMapping;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        
        Class<?> clazz = TestUrl.class;
        
        if (clazz.getMethod("greeting").isAnnotationPresent(UrlMapping.class)) {
            UrlMapping url = clazz.getMethod("greeting").getAnnotation(UrlMapping.class);
            System.out.println("Valeur de l'url : " + url.value());
            System.out.println("Nom du methode : " + clazz.getMethod("greeting").getName());
        }
    }
}
