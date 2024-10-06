import java.util.Scanner;

public class Menu {

    public static void printMenu() {

        System.out.println("""
                Available actions (select word or letter):
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit""");
    }

    public static void Program() {

        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        PlacesList placesList = new PlacesList();
        var iterator = placesList.listIterator();

        while(!quitLoop) {
            System.out.println("Enter Value: ");
            String menuItem = scanner.nextLine().toUpperCase().substring(0,1);

            switch (menuItem){
                case "F" -> {
                    if (iterator.hasNext()) {
                        Places place = iterator.next();
                        System.out.println("Moving forward to " + place.name());
                    } else {
                        System.out.println("End of the list, can't move forward.");
                    }
                }
                case "B" -> {
                    if (iterator.hasPrevious()) {
                        Places place = iterator.previous();
                        System.out.println("Moving backwards to " + place.name());
                    } else {
                        System.out.println("Start of the list, can't move backward.");
                    }
                }
                case "L" -> {
                    System.out.println();
                    placesList.placesIterator();
                }
                case "M" -> printMenu();
                default -> quitLoop = true;
            }
        }
    }
}
