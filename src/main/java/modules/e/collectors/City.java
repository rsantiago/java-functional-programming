package modules.e.collectors;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class City implements Comparable<City> {
    private String name;
    private long population;
    private String country;
    private String continent;

    @Override
    public int compareTo(City that) {
        return this.name.compareTo(that.name);
    }
}
