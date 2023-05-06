package Model;

import java.awt.Color;

/**
 *
 * @author LinhptPC04737
 */
public enum Colors {
    LEFT, RIGHT, ACTIVE;

    public static Color homeColor(Colors type) {
        Color c;
        switch (type) {
            case LEFT -> {
                c = new Color(176, 212, 184);
            }
            case RIGHT -> {
                c = new Color(176, 212, 184);
            }
            default -> {
                c = new Color(255, 255, 255);
            }
        }
        return c;
    }

    public static Color menuColor(Colors type) {
        Color c = new Color(255, 255, 255);
        switch (type) {
            case LEFT -> {
                c = new Color(114,163,136);
            }
            case RIGHT -> {
                c = new Color(114,163,136);
            }
            case ACTIVE -> {
                c = new Color(176, 212, 184);
            }
        }
        return c;
    }

}
