package cz.cvut.fit.miadp.mvcgame.config;

public class MvcGameConfig {
    public static final int MAX_X = 1280;
    public static final int MAX_Y = 720;

    public static final int CannonA_MOVE_STEP = 10;
    public static final int CannonB_MOVE_STEP = 20;

    public static final int ENEMY_STEP = 2;
    public static final int ADVANCED_ENEMY_STEP = 6;
    public static final int MAX_ENEMIES = 6;

    public static final int CANNON_POS_X = 50;
    public static final int CANNON_POS_Y = MAX_Y / 2;

    public static final int MAX_CANNON_POS_Y = 655;
    public static final int MIN_CANNON_POS_Y = 15;

    public static final double GRAVITY = 8.1;
    public static final double INIT_ANGLE = 0;

    public static final int CANNON_INIT_POWER = 5;
    public static final int CANNON_POWER_STEP = 1;
    public static final int CANNON_POWER_MAX = 10;
    public static final int CANNON_POWER_MIN = 0;

    public static final double ANGLE_STEP = 1;
    public static final double MAX_ANGLE = 90;
    public static final double MIN_ANGLE = 0;

    public static final double IMAGE_SIZE = 30;

    public static boolean BOLD_TEXT_ENABLED = true;
}