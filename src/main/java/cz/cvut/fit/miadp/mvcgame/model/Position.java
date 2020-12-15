package cz.cvut.fit.miadp.mvcgame.model;

import cz.cvut.fit.miadp.mvcgame.config.MvcGameConfig;
import cz.cvut.fit.miadp.mvcgame.prototype.IPrototype;

public class Position implements IPrototype<Position> {
    private int dimX = 0;
    private int dimY = 0;

    public Position() {
    }

    public Position(int posX, int posY) {
        this.dimX = posX;
        this.dimY = posY;
    }

    public int getX() {
        return dimX;
    }

    public int getY() {
        return dimY;
    }

    public void setY(int y) {
        this.dimY = y;
    }

    public void setX(int x) {
        this.dimX = x;
    }


    public void add(Vector v) {
        this.setX((this.getX() + v.getDx()));
        this.setY(this.getY() + v.getDy());
    }

    public Boolean isInRadius(Position pos) {
        if (Math.abs(this.dimX - pos.getX()) <= MvcGameConfig.IMAGE_SIZE && Math.abs(this.dimY - pos.getY()) <= MvcGameConfig.IMAGE_SIZE)
            return true;
        else
            return false;
    }

    @Override
    public Position clone() {
        return new Position(this.getX(), this.getY());
    }
}