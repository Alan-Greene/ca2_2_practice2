package ca_practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TestClass {

    public static void menu(){
        System.out.println("Please press 1 to view the cars");
        System.out.println("Please press 2 if you want to view the cars with the highest selling price");
        System.out.println("Please press 3 to see the import duty");
        System.out.println("Please press 4 to quit");
    }

    public static int menuInput(){
        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    public static ArrayList<Car> getCarsFromFile(String path){
        ArrayList<Car> cars = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            for (String line; (line = reader.readLine()) != null;) {
                String[] values = line.split(",");
                cars.add(new Car(values[0], values[1], Double.parseDouble(values[2]), Double.parseDouble(values[3]), (values[4].charAt(0)), Double.parseDouble(values[5])));
            }
        } catch (IOException e){
            System.err.println(e.getMessage());
            System.exit(-2);
        }

        return cars;
    }

    public static void main(String[] args) {
        CarDb cars_collection = new CarDb();

        ArrayList<Car> cars = getCarsFromFile("files/cars.txt");

        for (Car car: cars){
            cars_collection.addCar(car.getMake(), car.getModel(), car.getPurchase_price(), car.getShipping_cost(), car.getPort().charAt(0), car.getSelling_price());
        }

        while (true){
            menu();
            int user_choice = menuInput();
            switch (user_choice){
                case 1:
                    cars_collection.displayList();
                    break;
                case 2:
                    cars_collection.calcMostExpensive();
                    break;
                case 3:
                    cars_collection.calcImportDuty();
                    break;
                case 4:
                    System.exit(-1);
                    break;
                default:
                    System.err.println("err");
            }
        }
    }
}
