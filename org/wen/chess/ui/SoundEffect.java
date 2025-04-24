package org.wen.chess.ui;

import org.wen.chess.Constant;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

class SoundEffect extends Thread {

    URL url = null;

    public SoundEffect(int k) {
        this.setDaemon(true);
        switch (k) {
            case Constant.MOVE_SOUND:
                url = Constant.MOVEPATHURL;
                break;
            case Constant.CAPTURE_SOUND:
                url = Constant.CAPTUREURL;
                break;
            case Constant.CHECKED_SOUND:
                url = Constant.CHECKEDURL;
                break;
            case Constant.LOSS_SOUND:
                url = Constant.LOSSURL;
                break;
        }
    }

    @Override
    public void run() {
        AudioClip clip = Applet.newAudioClip(url);
        clip.play();
    }
}