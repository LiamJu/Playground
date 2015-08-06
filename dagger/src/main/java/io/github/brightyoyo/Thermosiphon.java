package io.github.brightyoyo;

import javax.inject.Inject;

/**
 * @author goodev
 * @since 15/8/6
 */
public class Thermosiphon implements Pump {
    private final Heater mHeater;
    boolean pumped = false;

    @Inject
    public Thermosiphon(Heater pHeater) {
        mHeater = pHeater;
    }

    @Override public void pump() {
        if (mHeater.isHot()) {
            System.out.println("-----Pumping------");
            pumped = true;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override public boolean isPumped() {
        return pumped;
    }
}
