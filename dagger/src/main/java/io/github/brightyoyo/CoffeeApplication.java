package io.github.brightyoyo;

import android.app.Application;

import dagger.ObjectGraph;

/**
 * @author goodev
 * @since 15/8/6
 */
public class CoffeeApplication extends Application {

    private ObjectGraph mObjectGraph;


    @Override public void onCreate() {
        super.onCreate();
        mObjectGraph = ObjectGraph.create(new DrinkCoffeeModule(this));
    }

    public ObjectGraph getObjectGraph() {
        return mObjectGraph;
    }
}
