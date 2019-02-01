package chushka.entities;

public enum Type {

    FOOD,
    DOMESTIC,
    HEALTH,
    COSMETIC;

    @Override
    public String toString() {
        return (this.name().substring(0,1) + this.name().substring(1).toLowerCase());
    }
}
