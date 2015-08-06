package io.github.brightyoyo;

import javax.inject.Inject;

/**
 * @author goodev
 * @since 15/8/6
 */
public class PeopleDrink implements Drink {

    private Pump mPump;

    @Inject PeopleDrink(Pump pPump) {
        mPump = pPump;
    }

    @Override public void drink() {
        if (mPump.isPumped()) {
            System.out.println("------Drinking------");

        }
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
