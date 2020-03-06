package game;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.*;
public class AudioPlayer extends Thread{
	Player player;
    File music;
    //���췽��
    public AudioPlayer(File file) {
        this.music = file;
    }
    //���ŷ���
    public void play() throws FileNotFoundException, JavaLayerException {
        
            BufferedInputStream buffer =
                    new BufferedInputStream(new FileInputStream(music));
            player = new Player(buffer);
            player.play();
    }
    //��дrun����
    @Override
    public void run() {
        super.run();
        try {
            play();     
        } catch (FileNotFoundException | JavaLayerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
