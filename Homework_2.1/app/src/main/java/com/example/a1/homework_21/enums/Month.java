package com.example.a1.homework_21.enums;

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    public int getQuantityDays(){
        switch (this){
            case FEBRUARY: return 28;
            case APRIL: return 30;
            case JUNE: return 30;
            case SEPTEMBER: return 30;
            case NOVEMBER: return 30;
            default: return 31;
        }
    }
}
