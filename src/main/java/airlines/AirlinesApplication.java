package main.java.airlines;

import main.java.airlines.models.Airline;
import main.java.airlines.models.Airplane;
import main.java.airlines.models.AirplaneClass;
import main.java.airlines.models.Flight;

import java.util.List;
import java.util.Scanner;

public class AirlinesApplication {
    public static void main(String[] args) {

        Airline bulgariaAir = new Airline();
        boolean openMenu = true;
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Command and press Enter \n 1.Add Airplane Class \n 2.Add New Airplane \n 3.Add Destination \n 4.Find The Most Suitable Airplane For A Flight \n 5.Exit \n ================\n");

        String chosenCommand = sc.nextLine();

        while (chosenCommand != "5") {

            switch (chosenCommand) {
                case "1":
                    System.out.println("Enter class name");
                    String className = sc.nextLine();
                    System.out.println("Enter manufacturer");
                    String manufacturer = sc.nextLine();
                    System.out.println("Enter model");
                    String model = sc.nextLine();
                    System.out.println("Enter the number of seats");
                    int numberOfSeats = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter track length required for landing (in meters)");
                    double minTrackLength = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter average speed of this airplane class (kilometers per hour)");
                    double averageSpeed = Double.parseDouble(sc.nextLine());

                    AirplaneClass newClass = new AirplaneClass(className, manufacturer, model, numberOfSeats, minTrackLength, averageSpeed);

                    bulgariaAir.addClass(newClass);

                    System.out.println("Successfully added a new airplane class to the database! \n ===========");
                    System.out.println("Choose Command and press Enter \n 1.Add Airplane Class \n 2.Add New Airplane \n 3.Add Destination \n 4.Find The Most Suitable Airplane For A Flight \n 5.Exit \n ================");
                    break;
                case "2":
                    System.out.println("Select Airplane Class: \n");
                    List<AirplaneClass> Classes = bulgariaAir.getClasses();
                    for (int i = 0; i < Classes.size(); i++) {
                        System.out.println(i + 1 + "." + Classes.get(i).getClassName());
                    }
                    int selectedClass = Integer.parseInt(sc.nextLine()) - 1;
                    System.out.println("Enter airplane identification number");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Enter staff charges");
                    double staffCharges = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter fuel consumption (litres per kilometer)");
                    double fuelPerKilometer = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter reservoir size (in litres)");
                    double reservoirSize = Double.parseDouble(sc.nextLine());
                    Airplane newAirplane = new Airplane(id, Classes.get(selectedClass), staffCharges, fuelPerKilometer, reservoirSize);

                    bulgariaAir.addAirplane(newAirplane);

                    System.out.println("Successfully added a new airplane to the database! \n ===========");
                    System.out.println("Choose Command and press Enter \n 1.Add Airplane Class \n 2.Add New Airplane \n 3.Add Flight \n 4.Find The Most Suitable Airplane For A Flight \n 5.Exit \n ================");
                    break;

                case "3":
                    System.out.println("Enter flight departure location");
                    String departFrom = sc.nextLine();
                    System.out.println("Enter flight arrival location");
                    String arriveTo = sc.nextLine();
                    System.out.println("Enter flight length in kilometers");
                    Double flightLength = Double.parseDouble(sc.nextLine());
                    System.out.println("Enter the shortest track length for this flight");
                    Double trackLength = Double.parseDouble(sc.nextLine());

                    Flight newFlight = new Flight(departFrom, arriveTo, flightLength, trackLength);

                    bulgariaAir.addFlight(newFlight);

                    System.out.println("Successfully added a new flight to the database \n ===========");
                    System.out.println("Choose Command and press Enter \n 1.Add Airplane Class \n 2.Add New Airplane \n 3.Add Flight \n 4.Find The Most Suitable Airplane For A Flight\n 5.Exit \n ================");

                    break;
                case "4":
                    System.out.println("Select Flight: \n");
                    List<Flight> flights = bulgariaAir.getFlights();
                    for (int i = 0; i < flights.size(); i++) {
                        System.out.println(i + 1 + ".From " + flights.get(i).getDepartFrom() + " to " + flights.get(i).getArriveTo());
                    }
                    int selectedFlight = Integer.parseInt(sc.nextLine()) - 1;

                    System.out.println("Enter current fuel price");

                    double fuelPrice = Double.parseDouble(sc.nextLine());

                    double selectedTrackLength = flights.get(selectedFlight).getTrackLength();
                    double selectedFlightLength = flights.get(selectedFlight).getFlightLength();

                    List<Airplane> airplanes = bulgariaAir.getAirplanes();
                    int bestAirplaneId = 0;
                    String bestAirplaneClassName = "";
                    int bestAirplaneSeats = 0;
                    double bestAirplaneSpeed = 0;

                    double minCharges = Double.MAX_VALUE;

                    boolean foundAirplane = false;

                    for (int i = 0; i < airplanes.size(); i++) {
                        Airplane currentAirplane = airplanes.get(i);
                        if (currentAirplane.isCompatible(selectedTrackLength, selectedFlightLength)) {
                            if (currentAirplane.getCharges(selectedFlightLength, fuelPrice) < minCharges) {
                                minCharges = currentAirplane.getCharges(selectedFlightLength, fuelPrice);
                                bestAirplaneId = currentAirplane.getId();
                                bestAirplaneClassName = currentAirplane.get_class().getClassName();
                                bestAirplaneSeats = currentAirplane.get_class().getNumberOfSeats();
                                bestAirplaneSpeed = currentAirplane.get_class().getAverageSpeed();
                                foundAirplane = true;
                            }
                        }
                    }

                    double estimatedTime = selectedFlightLength / bestAirplaneSpeed;

                    if (foundAirplane) {
                        System.out.println("Best airplane for selected flight is: Airplane #" + bestAirplaneId + " of " + bestAirplaneClassName + " class");
                        System.out.println("Total seats: " + bestAirplaneSeats);
                        System.out.println("Total flight cost: $" + minCharges);
                        System.out.println("Estimated flight time: " + estimatedTime + " hours \n =========");
                    } else {
                        System.out.println("No Airplanes found for selected flight \n ============");
                    }

                    System.out.println("Choose Command and press Enter \n 1.Add Airplane Class \n 2.Add New Airplane \n 3.Add Flight \n 4.Find The Most Suitable Airplane For A Flight\n 5.Exit \n ================");
                    break;
            }
            chosenCommand = sc.nextLine();
        }
    }
}
