
import java.util.*;

class Song {
    String title, artist;

    Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String toString() {
        return title + " / " + artist;
    }

    public boolean equals(Song s) {
        return title.equalsIgnoreCase(s.title) &&
                artist.equalsIgnoreCase(s.artist);
    }

    public int hashCode() {
        return Objects.hash(title.toLowerCase(), artist.toLowerCase());
    }
}

public class Main2 {
    static LinkedList<Song> playlist = new LinkedList<>();
    static LinkedList<Song> history = new LinkedList<>();
    static ListIterator<Song> it = playlist.listIterator();

    static void addFront(Song s) {
        playlist.addFirst(s);
        it = playlist.listIterator();
    }

    static void addAt(int pos, Song s) {
        playlist.add(pos, s);
        it = playlist.listIterator();
    }

    static void removeDuplicates() {
        HashSet<Song> seen = new HashSet<>();
        Iterator<Song> i = playlist.iterator();
        while (i.hasNext())
            if (!seen.add(i.next()))
                i.remove();
        it = playlist.listIterator();
    }

    static void removeSong(String title) {
        playlist.removeIf(s -> s.title.equalsIgnoreCase(title));
        it = playlist.listIterator();
    }

    static Song nextSong() {
        if (!it.hasNext())
            return null;
        Song s = it.next();
        history.add(s);
        return s;
    }

    static Song previousSong() {
        if (!it.hasPrevious())
            return null;
        Song s = it.previous();
        history.add(s);
        return s;
    }

    static void displayPlaylist() {
        ListIterator<Song> i = playlist.listIterator();
        while (i.hasNext())
            System.out.println(i.next());
        while (i.hasPrevious())
            System.out.println(i.previous());
    }

    static void displayHistory() {
        for (Song s : history)
            System.out.println(s);
    }

    public static void main(String[] args) {
        addAt(0, new Song("S1", "Demo1"));
        addAt(1, new Song("S2", "Demo2"));
        addAt(2, new Song("S3", "Demo3"));
        addFront(new Song("S3", "Demo3"));
        removeDuplicates();
        System.out.println("Next: " + nextSong());
        System.out.println("Next: " + nextSong());
        System.out.println("Previous: " + previousSong());
        System.out.println("Playlist:");
        displayPlaylist();
        System.out.println("History:");
        displayHistory();
    }
}
