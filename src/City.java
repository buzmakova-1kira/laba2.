import java.util.ArrayList;
import java.util.List;

public class City {
    private String name;
    private List<City> connectedCities;
    private List<Integer> travelCosts;

    public City() {
        this.name = "";
        this.connectedCities = new ArrayList<>();
        this.travelCosts = new ArrayList<>();
    }

    public City(String name) {
        this.name = name;
        this.connectedCities = new ArrayList<>();
        this.travelCosts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<City> getConnectedCities() {
        return connectedCities;
    }

    public List<Integer> getTravelCosts() {
        return travelCosts;
    }

    // Метод для добавления пути к другому городу со стоимостью
    public void addPath(City city, int cost) {
        if (city != null && !connectedCities.contains(city)) {
            connectedCities.add(city);
            travelCosts.add(cost);
        }
    }

    public City(String name, List<City> cities, List<Integer> costs) {
        this.name = name;
        this.connectedCities = new ArrayList<>();
        this.travelCosts = new ArrayList<>();

        // добавляем связи
        if (cities != null && costs != null && cities.size() == costs.size()) {
            for (int i = 0; i < cities.size(); i++) {
                if (cities.get(i) != null) {
                    this.connectedCities.add(cities.get(i));
                    this.travelCosts.add(costs.get(i));
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Город: ").append(name);

        if (!connectedCities.isEmpty()) {
            result.append("\nПути: ");
            for (int i = 0; i < connectedCities.size(); i++) {
                if (i > 0) {
                    result.append(", ");
                }
                result.append(connectedCities.get(i).getName())
                        .append("(").append(travelCosts.get(i)).append(")");
            }
        }

        return result.toString();
    }
}