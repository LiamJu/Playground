package io.github.brightyoyo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.ObjectGraph;

public class DaggerActivity extends AppCompatActivity {

    @Inject CoffeeMaker mCoffeeMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dagger);
        ObjectGraph _objectGraph = ((CoffeeApplication) getApplication()).getObjectGraph();
        _objectGraph.inject(this);
    }


}
