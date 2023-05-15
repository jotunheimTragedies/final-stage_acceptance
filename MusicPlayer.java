import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class MusicPlayer {
    private File musicPath; 
    private Clip musicClip; 

    void playMusic(String musicLocation) {
        try {

            musicPath = new File(musicLocation);
            
            if(musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                musicClip = AudioSystem.getClip();
                musicClip.open(audioInput);
                musicClip.start();
                musicClip.loop(musicClip.LOOP_CONTINUOUSLY);
            
            } else {
                System.out.println("Cannot find file.");
            }

        } catch (Exception e) {
            System.out.println("Exception from playMusic() musicPlayer");
        }

    }

    public Clip getMusicClip() {
        return musicClip;
    }
}
