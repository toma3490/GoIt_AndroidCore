package com.android.toma.homework_12.entity;

import com.android.toma.homework_12.enumeration.Currency;

public class ChinaBank extends Bank {
    public ChinaBank(String bankCountry, Currency currency, long totalCapital) {
        super(bankCountry, currency, totalCapital);
    }

    @Override
    int getLimitOfWithdrawal() {
        return getCurrency() == Currency.YUAN ? 1000 : 150;
    }

    @Override
    int getLimitOfFunding() {
        return getCurrency() == Currency.YUAN ? 50000 : 1000;
    }

    @Override
    int getMonthlyRate() {
        return getCurrency() == Currency.YUAN ? 5 : 1;
    }

    @Override
    int getCommission(double sum) {
        int commission;
        if (sum <= 1000){
            commission = getCurrency() == Currency.YUAN ? 5 : 10;
        }else {
            commission = getCurrency() == Currency.YUAN ? 1 : 11;
        }
        return commission;
    }
}
