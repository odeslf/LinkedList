import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

record Places(String name, double distance) {}

public class PlacesList {

    private List<Places> placesList;

    public PlacesList() {
        this.placesList = new LinkedList<>();

        placesList.add(new Places("Adelaide", 1374));
        placesList.add(new Places("Alice Springs", 2771));
        placesList.add(new Places("Brisbane", 917));
        placesList.add(new Places("Darwin", 3972));
        placesList.add(new Places("Melbourne", 877));
        placesList.add(new Places("Perth", 3923));
        ((LinkedList<Places>)placesList).addFirst(new Places("Sydney", 0));

        sortPlacesByDistance();
    }

    public void sortPlacesByDistance() {
        placesList.sort((p1, p2) -> Double.compare(p1.distance(), p2.distance()));
    }

    public ListIterator<Places> listIterator() {
        return placesList.listIterator();
    }

    public void placesIterator() {
        var iterator = placesList.iterator();
        while (iterator.hasNext()) {
            Places place = iterator.next();
            if (!place.name().equals("Sydney")) {
                System.out.println("Town: " + place.name() + ", Distance from Sydney: " + place.distance() + "Km");
            }
        }
    }
}
