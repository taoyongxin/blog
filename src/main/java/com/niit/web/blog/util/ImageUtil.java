package com.niit.web.blog.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

/**
 * @author Tao
 * @ClassName ImageUtil
 * @Description TODO
 * @Date 2019/11/19
 * @Version 1.0
 **/
public class ImageUtil {
    public static BufferedImage getImage(int width, int height,String s){
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Random random = new Random();
        Graphics2D graphics = (Graphics2D) img.getGraphics();
        graphics.setBackground(Color.CYAN);
        graphics.fillRect(0,0,width,height);
        graphics.setPaint(Color.GREEN);
        Font font = new Font("Serif",Font.BOLD,50);
        graphics.setFont(font);
        Color[] colors = new Color[] { Color.BLUE, Color.GRAY, Color.GREEN, Color.RED, Color.BLACK, Color.ORANGE,
                Color.CYAN };
        graphics.setColor(colors[random.nextInt(colors.length)]);
        graphics.drawString(s,width/6,height/3);
        return img;
    }

    public static void main(String[] args) throws Exception{
        BufferedImage img = ImageUtil.getImage(240,120,CodeUtil.getRandomCode());
        File file = new File("E:/pic/java3.jpg");
        ImageIO.write(img,"jpg",file);
    }
}
