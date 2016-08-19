package me.quasindro.jsnek.objects;

import me.quasindro.jsnek.PixelComponent;
import me.quasindro.jsnek.Window;

import java.util.Random;

import java.awt.*;

public class Apple extends PixelComponent {

    private Window window;

    public Apple(Window window) {
        this.window = window;
        getJPanel().setSize(PIXEL_SIZE, PIXEL_SIZE);
        getJPanel().setBackground(new Color(155, 33, 66));
        window.getBackground().add(getJPanel());
        setRandomLocation();
    }

    public void setRandomLocation() {
        Random random = new Random();
        Point point = new Point(random.nextInt(281/20)*20, random.nextInt(281/20)*20);
        if (!window.isLocationTaken(point)) {
            getJPanel().setLocation(point);
            window.addTakenLocation(point);
        } else {
            setRandomLocation();
        }
    }
}