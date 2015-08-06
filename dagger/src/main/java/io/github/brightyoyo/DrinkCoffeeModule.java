package io.github.brightyoyo;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author goodev
 * @since 15/8/6
 */
@Module(injects = DaggerActivity.class, library = true, complete = false)
public class DrinkCoffeeModule {

    private final Context mContext;

    public DrinkCoffeeModule(Context pContext) {
        mContext = pContext.getApplicationContext();
    }

    @Provides @Singleton Context applicationContext() {
        return mContext;
    }

    @Provides @Singleton Heater provideHeater() {
        return new ElectricHeater();
    }

    @Provides @Singleton Drink provideDrink(PeopleDrink pDrink) {
        return pDrink;
    }

    @Provides @Singleton Pump providePump(Thermosiphon pump) {
        return pump;
    }
}
