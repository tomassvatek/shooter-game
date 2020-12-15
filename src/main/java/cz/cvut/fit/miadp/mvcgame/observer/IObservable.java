package cz.cvut.fit.miadp.mvcgame.observer;

public interface IObservable {
    void register(IObserver observer);
    void unRegister(IObserver observer);

    void notifyObservers();
}
