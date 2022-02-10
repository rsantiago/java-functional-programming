package modules.d.spliterator;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Album {
    private String name;
    private String artist;
    private int year;
    private String genre;
}
