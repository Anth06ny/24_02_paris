package com.example.a24_02_sagemcom;

import com.example.a24_02_sagemcom.exo.ExoKotlinKt;
import com.example.a24_02_sagemcom.model.CarBean;

public class TempJava {
    public static void main(String[] args) {
        ExoKotlinKt.boulangerie(1,2,3);

        CarBean car = new CarBean("", "");
        CarBean car2 = new CarBean();
        car.setColor("");
        car.setMarque(null);

    }
}
