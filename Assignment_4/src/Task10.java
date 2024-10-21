import java.util.*;

class Song {
    private String title;
    private String genre;

    public Song(String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
}

interface SongIterator {
    boolean hasNext();
    Song next();
}

class SequentialIterator implements SongIterator {
    private List<Song> songs;
    private int position = 0;

    public SequentialIterator(List<Song> songs) {
        this.songs = songs;
    }

    public boolean hasNext() {
        return position < songs.size();
    }

    public Song next() {
        return songs.get(position++);
    }
}

class Playlist {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public SongIterator createSequentialIterator() {
        return new SequentialIterator(songs);
    }
}

public class Task10 {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong(new Song("Song 1", "Rock"));
        playlist.addSong(new Song("Song 2", "Pop"));
        playlist.addSong(new Song("Song 3", "Jazz"));

        SongIterator iterator = playlist.createSequentialIterator();

        while (iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println("Playing: " + song.getTitle());
        }
    }
}
