package io.github.brightyoyo;

/**
 * @author goodev
 * @since 15/8/6
 */
public class ElectricHeater implements Heater {
    boolean isHeating = false;

    @Override public void on() {
        isHeating = true;
        System.out.println("------Heating------");
    }

    @Override public void off() {
        isHeating = false;
    }

    @Override public boolean isHot() {
        return isHeating;
    }
}
