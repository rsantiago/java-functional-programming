package modules.e.collectors;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CitySpliterator implements Spliterator<City> {
    private Spliterator<String> lines;
    private City nextCity;

    public CitySpliterator(Stream<String> lines) {
        this.lines = lines.spliterator();
    }


    @Override
    public boolean tryAdvance(Consumer<? super City> action) {
        if(lines.tryAdvance(this::getNextCity) &&
                nextCity!= null) {
            action.accept(nextCity);
            return true;
        }

        return false;
    }

    private void getNextCity(String line) {
        City nextCity = new City();

        Spliterator<String> spliterator = Arrays.stream(line.split(";")).spliterator();
        if(spliterator.tryAdvance(nextCity::setName) &&
            spliterator.tryAdvance(population -> nextCity.setPopulation(Long.parseLong(population.replace(",","").trim()))) &&
            spliterator.tryAdvance(nextCity::setCountry) &&
            spliterator.tryAdvance(nextCity::setContinent)) {
            this.nextCity = nextCity;
            return;
        }

        this.nextCity = null;
    }

    @Override
    public Spliterator<City> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return lines.estimateSize();
    }

    @Override
    public int characteristics() {
        return lines.characteristics();
    }
}
