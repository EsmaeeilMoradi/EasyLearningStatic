package com.esmaeeil_moradi.easy_learning_static.equilibrium;


import android.util.Log;

import java.util.ArrayList;

public class Vector {
    private static float LENGTH;
    private static double ANGLE;
    private float x;
    private float y;


    Vector(String SIZE_VECTOR, String ANGLE_VECTOR) {
        LENGTH = Float.parseFloat(SIZE_VECTOR);
        ANGLE = Double.parseDouble(ANGLE_VECTOR);
    }


    float CreateVectorX() {
        double Radians_ANGLE = Math.toRadians(ANGLE);
        Log.e("Essi", "Vector Radians_ANGLE : " + String.valueOf(Radians_ANGLE));
        double cosAngle = Math.cos(Radians_ANGLE);
        Log.e("Essi", "Vector cosAngle : " + cosAngle);
        setX((float) (LENGTH * (cosAngle)));
        Log.e("Essi", "Vector x : " + getX());


        return getX();
    }


    float CreateVectorY() {
        double Radians_ANGLE = Math.toRadians(ANGLE);
        Log.e("Essi", "Vector Radians_ANGLE : " + String.valueOf(Radians_ANGLE));
        double sinAngle = Math.sin(Radians_ANGLE);
        Log.e("Essi", "Vector sin Angle : " + sinAngle);
        setY((float) (LENGTH * (sinAngle)));
        Log.e("Essi", "Vector y : " + getY());
        return getY();
    }


    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }


}


