package modules.d.spliterator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class SpliteratorExample {
    public static void main(String[] args) {
        spliteratorIntroduction();
        customAlbumSpliterator();
    }

    private static void customAlbumSpliterator() {
        Path path = Paths.get("src/main/java/modules/d/spliterator/musicAlbums.txt");
        try (Stream<String> lines = Files.lines(path)) {
            Spliterator<Album> albumSpliterator = new AlbumSpliterator(lines.spliterator());
            Stream<Album> stream = StreamSupport.stream(albumSpliterator, false);
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void spliteratorIntroduction() {
        List<Integer> list = List.of(1,2, 6,5,4,3);
        Spliterator<Integer> spliterator = list.spliterator();

        int characteristics = spliterator.characteristics();
        // this integer is an OR of all characteristics from the spliterator

        checkCharacteristics(spliterator);

        checkCharacteristics(list.stream().sorted().spliterator());
    }

    private static void checkCharacteristics(Spliterator<Integer> spliterator) {
        System.out.println("----------------------------");
        if(spliterator.hasCharacteristics(Spliterator.CONCURRENT)) {
            System.out.println("Is a concurrent stream");
        }
        if(spliterator.hasCharacteristics(Spliterator.DISTINCT)) {
            System.out.println("Is a distinct stream");
        }
        if(spliterator.hasCharacteristics(Spliterator.IMMUTABLE)) {
            System.out.println("Is an immutable stream");
        }
        if(spliterator.hasCharacteristics(Spliterator.NONNULL)) {
            System.out.println("Is a non-null stream");
        }
        if(spliterator.hasCharacteristics(Spliterator.ORDERED)) {
            System.out.println("Is an ordered stream");
        }
        if(spliterator.hasCharacteristics(Spliterator.SIZED)) {
            System.out.println("Is a sized stream");
        }
        if(spliterator.hasCharacteristics(Spliterator.SORTED)) {
            System.out.println("Is a sorted stream");
        }
        if(spliterator.hasCharacteristics(Spliterator.SUBSIZED)) {
            System.out.println("Is a subsized stream");
        }
    }
}
