package cz.cvut.fit.miadp.mvcgame.model.gameObjects;

import cz.cvut.fit.miadp.mvcgame.model.Position;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class LifetimeLimitedGameObject extends GameObject {
    private LocalDateTime bornAt;

    public LifetimeLimitedGameObject(Position position) {
        this.position = position;
        this.bornAt = LocalDateTime.now();
    }

    public long getAge() {
        LocalDateTime now = LocalDateTime.now();

        return ChronoUnit.SECONDS.between(this.bornAt, now);
    }
}
