package cz.cvut.fit.miadp.mvcgame.model;

public class Vector {
    private int dX;
    private int dY;

    public Vector(int dx, int dY) {
        this.dX = dx;
        this.dY = dY;
    }

    public int getDx() {
        return dX;
    }

    public int getDy() {
        return dY;
    }

    public void setY(int y) {
        this.dY = y;
    }

    public void setX(int x) {
        this.dX = x;
    }
}
