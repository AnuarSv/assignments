// AudioPlayer.java
interface AudioPlayer {
    void play(String audioType, String fileName);
}

// MP3Player.java
class MP3Player implements AudioPlayer {
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing MP3 file: " + fileName);
        } else {
            System.out.println("Invalid audio type for MP3Player");
        }
    }
}

// WAVPlayer.java
interface WAVPlayer {
    void playWAV(String fileName);
}

// AACPlayer.java
interface AACPlayer {
    void playAAC(String fileName);
}

// AdvancedAudioPlayer.java
class AdvancedAudioPlayer implements WAVPlayer, AACPlayer {
    public void playWAV(String fileName) {
        System.out.println("Playing WAV file: " + fileName);
    }

    public void playAAC(String fileName) {
        System.out.println("Playing AAC file: " + fileName);
    }
}

// AudioAdapter.java
class AudioAdapter implements AudioPlayer {
    AdvancedAudioPlayer advancedAudioPlayer;

    public AudioAdapter(String audioType) {
        if (audioType.equalsIgnoreCase("wav")) {
            advancedAudioPlayer = new AdvancedAudioPlayer();
        } else if (audioType.equalsIgnoreCase("aac")) {
            advancedAudioPlayer = new AdvancedAudioPlayer();
        }
    }

    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("wav")) {
            advancedAudioPlayer.playWAV(fileName);
        } else if (audioType.equalsIgnoreCase("aac")) {
            advancedAudioPlayer.playAAC(fileName);
        }
    }
}

// MusicPlayerApp.java
public class MusicPlayerApp {
    public static void main(String[] args) {
        AudioPlayer player = new MP3Player();
        player.play("mp3", "song1.mp3");

        AudioPlayer adapter = new AudioAdapter("wav");
        adapter.play("wav", "song2.wav");

        adapter = new AudioAdapter("aac");
        adapter.play("aac", "song3.aac");
    }
}
