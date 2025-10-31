package main.java;

import annotations.Controller;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, SecurityException {
        TestController1 c1 = new TestController1();
        TestController2 c2 = new TestController2();
        TestController3 c3 = new TestController3();

        checkControllerAnnotation(c1);
        checkControllerAnnotation(c2);
        checkControllerAnnotation(c3);
    }

    private static void checkControllerAnnotation(Object obj) {
        Class<?> cls = obj.getClass();
        boolean isController = cls.isAnnotationPresent(Controller.class);
        if (isController) {
            System.out.println("La classe " + cls.getName() + " est annotée @Controller.");
        } else {
            System.out.println("La classe " + cls.getName() + " n'est pas annotée @Controller.");
        }
    }
}
