package com.android.toma.homework_12.entity;

import com.android.toma.homework_12.enumeration.Currency;

public abstract class Bank {

    private String bankCountry;
    private Currency currency;
    private long totalCapital;

    public Bank(String bankCountry, Currency currency, long totalCapital) {
        this.bankCountry = bankCountry;
        this.currency = currency;
        this.totalCapital = totalCapital;
    }

    public String getBankCountry() {
        return bankCountry;
    }

    public Currency getCurrency() {
        return currency;
    }

    public long getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(long totalCapital) {
        this.totalCapital = totalCapital;
    }

    abstract int getLimitOfWithdrawal();
    abstract int getLimitOfFunding();
    abstract int getMonthlyRate();
    abstract int getCommission(double sum);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        if (totalCapital != bank.totalCapital) return false;
        if (bankCountry != null ? !bankCountry.equals(bank.bankCountry) : bank.bankCountry != null)
            return false;
        return currency == bank.currency;

    }

    @Override
    public int hashCode() {
        int result = bankCountry != null ? bankCountry.hashCode() : 0;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        result = 31 * result + (int) (totalCapital ^ (totalCapital >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                ", bankCountry = '" + bankCountry + '\'' +
                ", currency = " + currency +
                ", totalCapital = " + totalCapital +
                '}';
    }
}
