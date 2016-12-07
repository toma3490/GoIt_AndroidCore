package com.example.homework_219;

public class Sales {

    private String product;
    private String manufacturer;
    private String customer;
    private int quantity;
    private int price;
    private int totalPrice;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotalPrice() {
        return totalPrice = getQuantity() * getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sales sales = (Sales) o;

        if (quantity != sales.quantity) return false;
        if (price != sales.price) return false;
        if (totalPrice != sales.totalPrice) return false;
        if (product != null ? !product.equals(sales.product) : sales.product != null) return false;
        if (manufacturer != null ? !manufacturer.equals(sales.manufacturer) : sales.manufacturer != null)
            return false;
        return customer != null ? customer.equals(sales.customer) : sales.customer == null;

    }

    @Override
    public int hashCode() {
        int result = product != null ? product.hashCode() : 0;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + quantity;
        result = 31 * result + price;
        result = 31 * result + totalPrice;
        return result;
    }

    @Override
    public String toString() {
        return "Sales{" +
                "product = '" + product + '\'' +
                ", manufacturer = '" + manufacturer + '\'' +
                ", customer = '" + customer + '\'' +
                ", quantity = " + quantity +
                ", price = " + price +
                ", totalPrice = " + totalPrice +
                '}';
    }
}
