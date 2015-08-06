package io.github.brightyoyo;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * @author goodev
 * @since 15/8/6
 */
public class CoffeeMaker {

    @Inject Lazy<Heater> mHeater;
    @Inject Pump mPump;
    @Inject Drink mDrink;

    public void brew() {
        mHeater.get().on();
        mPump.pump();
        System.out.println("--------Pumped---------");
        mHeater.get().off();
        mDrink.drink();
    }
}
