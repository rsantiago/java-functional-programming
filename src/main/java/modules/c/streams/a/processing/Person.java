package modules.c.streams.a.processing;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private String lastName;
    private String streetName;
    private String gender;
    private Integer age;
    private Double income;
    private String profession;
    private String country;
}
