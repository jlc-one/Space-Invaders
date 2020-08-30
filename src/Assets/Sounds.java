package Assets;

import javafx.scene.media.AudioClip;

public class Sounds {


     private AudioClip shoot = new AudioClip("file:audio/shoot.wav");

     private AudioClip invaderKilled = new AudioClip("file:audio/kill.wav");

     private AudioClip song = new AudioClip("file:audio/song.mp3");

    static public AudioClip sound1 = new AudioClip("file:audio/fastinvader1.wav");
    static public AudioClip sound2 = new AudioClip("file:audio/fastinvader2.wav");
    static public AudioClip sound3 = new AudioClip("file:audio/fastinvader3.wav");
    static public AudioClip sound4 = new AudioClip("file:audio/fastinvader4.wav");


    public void playInvaderKilledSound() {
        invaderKilled.play();

    }

    public void stopInvaderKilledSound() {

    }

    public void playShootSound() {

        shoot.play();

    }

    public void stopShootSound() {
        shoot.stop();
    }

    static public void moveSoundPlay(int phase) {
        if (phase % 4 == 0) {
            sound1.play();
        } else if (phase % 4 == 1) {
            sound2.play();
        } else if (phase % 4 == 2) {
            sound3.play();
        } else {
            sound4.play();
        }
    }

    static public void moveSoundStop(int phase) {
        if (phase % 4 == 0) {
            sound1.stop();
        } else if (phase % 4 == 1) {
            sound2.stop();
        } else if (phase % 4 == 2) {
            sound3.stop();
        } else {
            sound4.stop();
        }
    }

}


