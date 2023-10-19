import java.util.Scanner;

class Route {
    public String place;
    public double speed;
    public double distance;

    Route(String place, double speed, double distance) {
        this.place = place;
        this.speed = speed;
        this.distance = distance;
    }
}

public class InteractiveRoute {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter Speed: ");
        double speedInput = in.nextDouble();

        String[] placeName = {"Minglanilla", "San Fernando", "Carcar", "Barili",
            "Dumanjug", "Alcantara", "MoalBoal", "Sibonga", "Dumanjug",
            "Alcantara", "MoalBoal", "Argao", "Ronda", "Alcantara", "MoalBoal"};
        double[] distance = {14.2, 13.2, 10.7, 17.6, 15.9, 11.2, 2.1, 11.3,
            12.2, 18.5, 16.1, 2.1, 19.2, 15.5, 16.4, 8.3, 2.1};

        char ans;
        double totalDistance = 0;
        double ETA = 0;

        System.out.println("Route: ");
        for (int i = 0; i < placeName.length; i++) {
            Route newRoute = new Route(placeName[i], speedInput, distance[i]);

            totalDistance += newRoute.distance;

            if (newRoute.place.equals("MoalBoal")) {
                System.out.println(newRoute.place);
                break;
            }

            System.out.println(newRoute.place);

            if (i == 2) {
                System.out.print("Is " + placeName[3] + " obstructed? (Y/N): ");
                ans = in.next().charAt(0);

                if (Character.toUpperCase(ans) == 'Y') {
                    i = 6;
                }

            } else if (i == 7) {
                System.out.print("Is " + placeName[8] + " obstructed? (Y/N): ");
                ans = in.next().charAt(0);

                if (Character.toUpperCase(ans) == 'Y') {
                    i = 10;
                }
            }
            // Loop Bracket
        }
        
        int hours = (int) totalDistance/(int)speedInput;
        int minutes = (int)(totalDistance % speedInput)* 60 / (int)speedInput;

        System.out.printf("\nTotal Distance: %.1fkm\nSpeed: %.0fkm\nETA: %dhr %dmin(s)",
            totalDistance, speedInput ,hours, minutes);
            
           
    }
}