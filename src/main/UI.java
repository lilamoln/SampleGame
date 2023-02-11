package main;

import objects.OBJ_Key;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {
    GamePanel gp;
    Font arial_40;
    BufferedImage keyImage;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        OBJ_Key key = new OBJ_Key();
        keyImage = key.image;
    }
    public void showMessage(String text) {
        message = text;
        messageOn = true;

    }
    public void draw(Graphics2D g2) {
        g2.setFont(arial_40);
        g2.setColor(Color.WHITE);
        g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2, gp.tileSize, gp.tileSize, null);
        g2.drawString("x " + gp.player.hasKey, 74, 65);
        // Show message
        if(messageOn == true) {
            g2.setFont(g2.getFont().deriveFont(30F));
            g2.drawString(message, gp.tileSize*5, gp.tileSize * 5);

            messageCounter++;

            if(messageCounter > 60) {
                messageCounter = 0;
                messageOn = false;
            }
        }


    }
}