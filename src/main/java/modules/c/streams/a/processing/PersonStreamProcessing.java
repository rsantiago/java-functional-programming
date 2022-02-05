package modules.c.streams.a.processing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PersonStreamProcessing {
    public static void main(String[] args) {
        List<Person> people = people();

        // in streams, each item will be applied to the whole pipe before considering the next item
        List<Person> brazilianPeople = people.stream()
                .peek(p -> System.out.println("first peek with " + p.getName()))
                .filter(p -> p.getCountry().equals("Brazil"))
                .peek(p -> System.out.println("second peek with " + p.getName()))
                .filter(p -> p.getLastName().equals("Silva"))
                .peek(p -> System.out.println("third peek with " + p.getName()))
                .collect(Collectors.toList());
        brazilianPeople.forEach(x -> System.out.println(x.getName()));
    }

    static List<Person> people() {
        return Arrays.asList(
                new Person("Jose", "Silva", "Maracá", "male", 22, 7000.0, "Architect", "Brazil"),
                new Person("Maria", "Silva", "Brisamar", "female", 54, 4050.0, "Test", "USA"),
                new Person("Joana", "Oliveira", "Sá Correia", "female", 44, 10000.0, "Software Engineer", "Chile"),
                new Person("Geane", "Carvalho", "Árvore da Vida", "female", 35, 1599.0, "Receptionist", "Uruguay"),
                new Person("Roberta", "Orestes", "Matracas", "female", 6, 0D, "Student", "Brazil")
        );
    }
}
