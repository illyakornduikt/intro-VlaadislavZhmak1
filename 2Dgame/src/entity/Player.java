package entity;

import main.KeyHandler;
import main.Panel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity{
    Panel gp;
    KeyHandler keyHandler;

    public Player(Panel gp, KeyHandler keyHandler){
        this.gp = gp;
        this.keyHandler = keyHandler;
        setDefaultValues();
        getPlayerImage();
    }
    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
        direction = "down";
    }
    public void getPlayerImage(){
        try{
            up1 = ImageIO.read(getClass().getResourceAsStream("res/player/boy_up1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("res/player/boy_up2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("res/player/boy_down1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("res/player/boy_down2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("res/player/boy_left1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("res/player/boy_left2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("res/player/boy_right1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("res/player/boy_right2.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void update(){
        if(keyHandler.upPressed == true){
            direction = "up";
            y -= speed;
        }else if(keyHandler.downPressed == true){
            direction = "down";
            y += speed;
        }else if(keyHandler.leftPressed == true){
            direction = "left";
            x -= speed;
        }else if(keyHandler.rightPressed == true){
            direction = "right";
            x += speed;
        }
    }
    public void draw(Graphics2D g2){
        /*g2.setColor(Color.white);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);*/
        BufferedImage image = null;
        switch (direction){
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
                case "left":
                    image = left1;
                    break;
                    case "right":
                        image = right1;
                        break;

        }
        g2.drawImage(image, x, y, gp.tileSize,gp.tileSize, null);
    }

}
