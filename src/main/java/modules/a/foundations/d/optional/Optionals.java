package modules.a.foundations.d.optional;

import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
//        Optional<String> maybeItHasAValue = Optional.of(maybeItHasAValue()); // <--------- dont do this with nullable functions
        Optional<String> maybeItHasAValue = Optional.ofNullable(maybeItHasAValue()); // <-- do this instead
        Optional<String> itSurelyHasaValue = Optional.of("There is a value here, guaranteed");
        Optional<String> thisOneIsNullForSure = Optional.empty();

        maybeItHasAValue.ifPresent(System.out::println);

        if(maybeItHasAValue.isPresent()) {
            System.out.println("Testing a value, and it exists");
        }

        String itWillHaveAValue = (String) maybeItHasAValue
                .orElse("Fallback string, in case the first is missing");

        Object getTheValueAndItMightBeNull = itSurelyHasaValue.get();

        boolean checkIfTheValueIsThere = maybeItHasAValue.isEmpty();

        itSurelyHasaValue.orElseThrow(
                () -> new IllegalStateException("No value exists here") // supplier interface to build exceptions
        );

        String anotherChanceToHaveAValue = maybeItHasAValue.orElseGet(Optionals::maybeItHasAValue);
        Optional<String> anotherFromMapping = maybeItHasAValue.map(val -> "here is another value to the optional");

        anotherFromMapping.ifPresentOrElse(
                x -> System.out.println("the value of the optional is " + x)
                , () -> System.out.println("no value at all"));

        Optional<String> value = anotherFromMapping.or(()-> Optional.of("This one")); // um optional ou outro

    }

    private static String maybeItHasAValue() {
         if(Math.random() * 10 / 2 == 0) {
             return "It has a string";
         }

         return null;
    }
}
