package ca_practice;

public class CarDb {
    Car[] cars = new Car[9];
    Double[] total_costs;
    int i = 0;

    public void addCar(String make, String model, Double purchase_price, Double shipping_cost, char port, Double selling_price){
        cars[i] = new Car(make, model, purchase_price, shipping_cost, port, selling_price);
        i++;
    }

    public void displayList(){
        int i = 1;
        System.out.println("Cars");
        for (Car car: cars){
            System.out.printf("No: %-20d |Make: %-20s |Model: %-20s |Purchase price: €%,-20.2f |Shipping cost: €%,-20.2f |Port: %-20s |Selling price €%,-20.2f%n",
                    i, car.getMake(), car.getModel(), car.getPurchase_price(), car.getShipping_cost(), car.getPort(), car.getSelling_price());
            i++;
        }
    }

    public void calcMostExpensive(){
        Double highest_price = cars[0].getSelling_price();

        System.out.println("Most expensive cars");
        for (Car car: cars){
            if(car.getSelling_price() > highest_price){
                highest_price = car.getSelling_price();
            }
        }

        for (Car car: cars){
            if (car.getSelling_price().equals(highest_price)){
                System.out.printf("%-20s at €%,.2f%n", car.getModel(), car.getSelling_price());
            }
        }
    }

    public void calcImportDuty(){

        int i = 0;
        final Double VAT_RATE = .23;
        final Double BROKER_FEE = 120.0;
        Double port_rate = 0.0;
        Double vat = 0.0;
        Double unloading_fee = 0.0;
        Double import_cost = 0.0;
        Double port_duty = 0.0;
        Double total_cost = 0.0;
        total_costs = new Double[cars.length];

        System.out.printf("%-30s %-20s %-20s %-20s%n", "Model", "Cost", "Import cost", "Total cost");
        for (Car car: cars){
            if (car.getPort().equals("Osaka")){
                port_rate = 0.10;
                unloading_fee = 100.0;
            } else if (car.getPort().equals("Tokyo")){
                port_rate = 0.15;
                unloading_fee = 150.0;
            }

            port_duty = (car.getPurchase_price() + car.getShipping_cost()) * port_rate;
            vat = (car.getPurchase_price() + car.getShipping_cost() + port_duty) * VAT_RATE;
            import_cost = port_duty + vat + unloading_fee + BROKER_FEE;
            total_cost = car.getPurchase_price() + car.getShipping_cost() + import_cost;
            total_costs[i] = total_cost;
            i++;

            System.out.printf("%-30s €%,-20.2f €%,-20.2f €%,-20.2f%n", car.getModel(), car.getPurchase_price() + car.getShipping_cost(), import_cost, total_cost);
        }


    }


}
