import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        ArrayList<Car> parking = new ArrayList<>();


        Car car1 = new Car("Toyota Corolla", 1.4, 2011);
        Car car2 = new Car("Mini Cooper", 1.3, 2019);
        Car car3 = new Car("Honda Civic", 2.5, 1998);
        Car car4 = new Car("Jeep Wrangler", 3.2, 2001);
        Car car5 = new Car("Subaru Outback", 1.1, 2020);
        Car car6 = new Car("Honda Accord", 4.4, 2000);


        Car car7 = new Car("Jeep Wrangler", 2.5, 1998);
        Car car8 = new Car("Subaru Outback", 3.2, 2001);
        Car car9 = new Car("Honda Accord", 1.1, 2020);
        Car car10 = new Car("Honda Civic", 4.4, 2000);

        parking.add(car1);
        parking.add(car2);
        parking.add(car3);
        parking.add(car4);
        parking.add(car5);
        parking.add(car6);
        parking.add(car7);
        parking.add(car8);
        parking.add(car9);
        parking.add(car10);


//        ONE
       parking.forEach((n) -> System.out.println(n.toString()));

//       TWO
        Collections.sort(parking);
        System.out.println("SORTED BY MAKE/MODEL USING COMPARABLE: ");
        parking.forEach((n) -> System.out.println(n.toString()));

        CarComparator carComparator = new CarComparator();
        parking.sort(carComparator);
        System.out.println("SORTED BY ENGINE SIZE USING COMPARATOR: ");
        parking.forEach((n) -> System.out.println(n.toString()));


//        THREE
        System.out.println("SORTED BY PRODUCTION YEAR USING LAMBDA: ");
        Collections.sort(parking, (o1, o2) -> Integer.valueOf(o1.getProdYear()).compareTo(Integer.valueOf(o2.getProdYear())));
        parking.forEach((n) -> System.out.println(n.toString()));

        //    FOUR
        System.out.println("SORTED BY PRODUCTION YEAR THEN MAKE/MODEL ");
        parking.sort(
                Comparator.comparing(Car::getProdYear).thenComparing(Car::getMakeModel)
        );

        parking.forEach((n) -> System.out.println(n.toString()));






    }
}

//    ArrayList<String> teamNames = teams.get(name);
//                    teamNames.add(lineArr[0]);