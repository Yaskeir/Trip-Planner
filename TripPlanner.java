import java.util.Scanner;

public class TripPlanner {
    public static void main(String[] args) {
    greeting();
    travelTimeAndBudget();
    timeDifference();
    countryArea();
    hackerProblem();
    };
    // credit to Jason Winn for the distance calculation using haversine
    public static double distance(double startLat, double startLong, double endLat, double endLong) {
    
        int EARTH_RADIUS = 6371;
        double dLat  = Math.toRadians((endLat - startLat));
        double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c; // <-- d
    }

    public static double haversin(double val) {
        return Math.pow(Math.sin(val / 2), 2);
    };
    // hello 
    public static void greeting() {
        System.out.print("Hello, what is your name? ");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        System.out.println("Hello " + name + "!");
        System.out.println("Where would you like to go to?");
        Scanner input1 = new Scanner(System.in);
        String location = input1.next();
        System.out.print(location + " is a great place to visit!");
    };
    // calculate travel time & budget per day in USD and local currency
    public static void travelTimeAndBudget() {
        System.out.print(" Alright, so how long do you wanna stay?\nSpecify the number of days: ");
        Scanner input2 = new Scanner(System.in);
        int stay = input2.nextInt();
        System.out.print("What is your total budget for the trip? USD: $");
        Scanner input3 = new Scanner(System.in);
        double budget = input3.nextDouble();
        System.out.print("What's the currency symbol for your destination? Currency: ");
        Scanner input4 = new Scanner(System.in);
        String currency = input4.nextLine();
        System.out.print("Now specify the conversion rate: ");
        Scanner input5 = new Scanner(System.in);
        double rate = input5.nextDouble();
        System.out.println("Okay! So you're going to spend there " + stay + " days, equal to " + stay * 24  + " hours or " + stay * 1440 + " minutes.");
        System.out.println("You're going to spend $" + budget + " USD, which per day is $" + (double)Math.round(budget/stay * 100) / 100 + " USD.");
        System.out.println("In the local currency it is " + (double)Math.round(budget * rate * 1000) / 1000 + " " + currency);
    }
    // used to calculate time in reference to noon at home
    public static void timeDifference() {
        System.out.println("Alright! Now that we know all that, let's find out the time difference.");
        System.out.print("Time difference, in hours: ");
        Scanner input6 = new Scanner(System.in);
        int time = input6.nextInt();
        System.out.println("This means that at noon at home it will be " + (12 + (time % 24)) + ":00 there.");
    }
    // used to calculate surface area in miles^2
    public static void countryArea() {
        System.out.println("What's the surface area of the location, in km^2?");
        Scanner input7 = new Scanner(System.in);
        double surface = input7.nextDouble();
        System.out.println("Yup! So the surface area is " + surface + " km^2, or " + Math.round(surface * 0.386 * 100)/ 100 + " miles^2.");
    }
    //used to calculate the distance given latitude and longitude
    public static void hackerProblem() {
        System.out.println("Lastly, provide the longitude and latitude for both home and travel destination.");
        System.out.print("Home latitude: ");
        Scanner input8 = new Scanner(System.in);
        double f1 = input8.nextDouble();
        System.out.print("Home longitude: ");
        Scanner input9 = new Scanner(System.in);
        double l1 = input9.nextDouble();
        System.out.print("Destination latitude: ");
        Scanner input10 = new Scanner(System.in);
        double f2 = input10.nextDouble();
        System.out.print("Destination longitude: ");
        Scanner input11 = new Scanner(System.in);
        double l2 = input11.nextDouble();
        System.out.print("The distance between your home and your travel destination is " + distance(f1, l1, f2, l2) + " km.");
    }
};