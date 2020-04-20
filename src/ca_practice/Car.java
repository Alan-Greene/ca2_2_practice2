package ca_practice;

public class Car {
    String make, model;
    Double purchase_price, shipping_cost, selling_price;
    char port;

    public Car(String make, String model, Double purchase_price, Double shipping_cost, char port, Double selling_price){
        this.make = make;
        this.model = model;
        this.purchase_price = purchase_price;
        this.shipping_cost = shipping_cost;
        this.port = port;
        this.selling_price = selling_price;
    }

    // getters
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Double getPurchase_price() {
        return purchase_price;
    }

    public Double getShipping_cost() {
        return shipping_cost;
    }

    public Double getSelling_price() {
        return selling_price;
    }

    public String getPort() {
        if (port == 'o' || port == 'O') {
            return "Osaka";
        } else if (port == 't' || port == 'T'){
            return "Tokyo";
        } else {
            return "Error";
        }
    }

    //setters
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setPurchase_price(Double purchase_price) {
        this.purchase_price = purchase_price;
    }

    public void setShipping_cost(Double shipping_cost) {
        this.shipping_cost = shipping_cost;
    }

    public void setSelling_price(Double selling_price) {
        this.selling_price = selling_price;
    }

    public void setPort(char port) {
        this.port = port;
    }
}
