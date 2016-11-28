package com.android.toma.homework_12.entity;

import com.android.toma.homework_12.enumeration.Currency;

public class USBank extends Bank{

    public USBank(String bankCountry, Currency currency, long totalCapital) {
        super(bankCountry, currency, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        return getCurrency() == Currency.USD ? 1000 : 1200;
    }

    @Override
    int getLimitOfFunding() {
        return getCurrency() == Currency.EUR ? 10000 : Integer.MAX_VALUE;
    }

    @Override
    int getMonthlyRate() {
        return getCurrency() == Currency.USD ? 1 : 2;
    }

    @Override
    int getCommission(double sum) {
        int commission;
        if (sum <= 1000){
            commission = getCurrency() == Currency.USD ? 5 : 6;
        }else {
            commission = getCurrency() == Currency.USD ? 7 : 8;
        }
        return commission;
    }
}
