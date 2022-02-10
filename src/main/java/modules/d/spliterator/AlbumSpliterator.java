package modules.d.spliterator;

import java.util.Spliterator;
import java.util.function.Consumer;

public class AlbumSpliterator implements Spliterator<Album> {
    private String name;
    private String artist;
    private int year;
    private String genre;
    private Spliterator<String> spliterator;

    public AlbumSpliterator(Spliterator<String> spliterator) {
        this.spliterator = spliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Album> action) {
        if(spliterator.tryAdvance( name -> this.name = name) &&
            spliterator.tryAdvance( genre -> this.genre = genre) &&
            spliterator.tryAdvance( artist -> this.artist = artist) &&
            spliterator.tryAdvance( year -> this.year = Integer.parseInt(year))) {
                action.accept(new Album(name, artist, year, genre));
                return true;
        }
        return false;
    }

    @Override
    public Spliterator<Album> trySplit() {
        return null;
    }

    @Override
    public long estimateSize() {
        return spliterator.estimateSize()/4;
    }

    @Override
    public int characteristics() {
        return spliterator.characteristics();
    }
}
