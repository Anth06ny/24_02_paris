package com.example.a24_02_paris;

import com.example.a24_02_paris.exo.ExoKotlinKt;
import com.example.a24_02_paris.model.CarBean;

public class TempJava {
    public static void main(String[] args) {
        ExoKotlinKt.boulangerie(1,2,3);

        CarBean car = new CarBean("", "");
        CarBean car2 = new CarBean();
        car.setColor("");
        car.setMarque(null);

        switch (12) {
            case 200:
                System.out.println("Ok");
                break;
            case 400:
                System.out.println("400");
            case 401:
                System.out.println("Erreur client");
                break;
            default :
                System.out.println("Autre");
        }

    }
}
