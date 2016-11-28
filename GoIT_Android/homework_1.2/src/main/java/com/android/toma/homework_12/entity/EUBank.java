package com.android.toma.homework_12.entity;

import com.android.toma.homework_12.enumeration.Currency;

public class EUBank extends Bank{
    public EUBank(String bankCountry, Currency currency, long totalCapital) {
        super(bankCountry, currency, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        return getCurrency() == Currency.USD ? 2000 : 2200;
    }

    @Override
    int getLimitOfFunding() {
        return getCurrency() == Currency.EUR ? 20000 : 10000;
    }

    @Override
    int getMonthlyRate() {
        return getCurrency() == Currency.USD ? 0 : 1;
    }

    @Override
    int getCommission(double sum) {
        int commission;
        if (sum <= 1000){
            commission = getCurrency() == Currency.USD ? 5 : 2;
        }else {
            commission = getCurrency() == Currency.USD ? 7 : 4;
        }
        return commission;
    }
}
