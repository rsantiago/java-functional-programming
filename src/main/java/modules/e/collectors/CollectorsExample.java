package modules.e.collectors;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CollectorsExample {
    public static void main(String[] args) {
        List<City> cityList = cityStream();

        assert cityList != null;
        setCollector(cityList);
        unmodifiableListCollector(cityList);
        treeSetCollector(cityList);
        mapCollector(cityList);
        partitionedMap(cityList);
        groupingMap(cityList);
        groupCounter(cityList);
        groupDoubleSum(cityList);
        groupMaxValue(cityList);
        groupCascading(cityList);
        customCollector(cityList);
        customSortedCollector(cityList);
    }

    private static void customCollector(List<City> cityList) {
        // the element type (city), the input type (city array list), the output type (city array list)
        Collector<City, ArrayList<City>, ArrayList<City>> myListCollector = Collector.of(
                ArrayList::new, // supplier, offers the container
                ArrayList::add,
                (list1, list2) -> { list1.addAll(list2); return list1;},
                Collector.Characteristics.IDENTITY_FINISH); // no need to map the result into another object

        ArrayList<City> europeCities = cityList.stream().filter(city -> city.getContinent().equals("Europe")).collect(myListCollector);

        header("Custom collector");
        europeCities.forEach(System.out::println);
    }

    private static void customSortedCollector(List<City> cityList) {
        // the element type (city), the input type (city array list), the output type (city array list)
        Collector<City, ArrayList<City>, ArrayList<City>> sortedCollector = Collector.of(
                ArrayList::new, // supplier, offers the container
                ArrayList::add, // binaryConsumer, takes the container + the element to be added
                (list1, list2) -> { list1.addAll(list2); return list1;}, // combine the elements in parallel processing
                list -> { Collections.sort(list); return list; }, // sort the list
                Collector.Characteristics.UNORDERED); // tells the list is not sorted, so that the finish method is called

        ArrayList<City> europeCities = cityList.stream().filter(city -> city.getContinent().equals("Europe")).collect(sortedCollector);

        header("Custom sorted collector");
        europeCities.forEach(System.out::println);
    }

    private static void groupCascading(List<City> cityList) {
        header("max number in a group cascading");
        Map<String, Optional<Long>> maxPopulation = cityList.stream().collect(Collectors.groupingBy(
                City::getContinent,
                Collectors.mapping(City::getPopulation,
                        Collectors.maxBy(Comparator.comparingLong(pop -> pop)))
        ));
        maxPopulation.forEach((continent, maxCityPopulation) -> System.out.println(continent + " = " + maxCityPopulation));
    }

    private static void groupMaxValue(List<City> cityList) {
        header("Element with max value in a group");
        Map<String, Optional<City>> mostPopulatedCity = cityList.stream().collect(
                Collectors.groupingBy(City::getContinent,
                        Collectors.maxBy(Comparator.comparingLong(City::getPopulation))));

        mostPopulatedCity.forEach((continent, city) -> System.out.println(continent + "-" + city.get() ));
    }

    private static void groupDoubleSum(List<City> cityList) {
        header("group summing stream element field");
        Map<String, Long> collect = cityList.stream().collect(Collectors.groupingBy(
                City::getContinent,
                Collectors.summingLong(City::getPopulation)));
        collect.forEach((key, value) -> System.out.println(key + " " + value));
    }

    private static void groupCounter(List<City> cityList) {
        header("group counter");
        Map<String, Long> collect = cityList.stream().collect(Collectors.groupingBy(City::getContinent, Collectors.counting()));
        collect.forEach((key, value) -> System.out.println(key + " - " + value));
    }

    private static void groupingMap(List<City> cityList) {
        header("grouping map");
        Map<String, List<City>> cityMap = cityList.stream().collect(Collectors.groupingBy(City::getContinent));
        cityMap.forEach((id, value) -> System.out.println(id + " - " + (value.stream().map(City::getName).collect(Collectors.joining(";")))));
    }

    private static void unmodifiableListCollector(List<City> cityList) {
        List<String> unmodCountryList = cityList.stream().map(City::getCountry).collect(Collectors.toUnmodifiableList());
    }

    private static void partitionedMap(List<City> cityList) {
        Map<Boolean, List<City>> europe = cityList.stream().collect(Collectors.partitioningBy(x -> x.getContinent().equals("Europe")));
        europe.forEach((x, y)-> System.out.println(x + " " + y.stream().map(City::getName).collect(Collectors.joining(";"))));
    }

    private static void mapCollector(List<City> cityList) {
        Map<String, City> unmodCountryList = cityList.stream().collect(
                        Collectors.toMap(city -> city.getName(), city -> city));
    }

    private static void treeSetCollector(List<City> cityList) {
        header("tree set");
        TreeSet<City> collect = cityList.stream().collect(Collectors.toCollection(TreeSet::new));
        collect.forEach(System.out::println);
    }

    private static void setCollector(List<City> cityList) {
        Set<String> continents = cityList.stream().map(City::getContinent).collect(Collectors.toSet());
    }

    private static List<City> cityStream() {
        Path path = Paths.get("src/main/java/modules/e/collectors/cities.txt");
        try (Stream<String> lines = Files.lines(path)) {
            Spliterator<City> cityrator = new CitySpliterator(lines);
            return StreamSupport.stream(cityrator, false).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void header(String headerName) {
        System.out.println("------------- " + headerName + " --------------");
    }

}
