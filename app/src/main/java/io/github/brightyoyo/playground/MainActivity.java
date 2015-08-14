package io.github.brightyoyo.playground;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.ObjectGraph;

public class MainActivity extends AppCompatActivity {

    private ObjectGraph mObjectGraph;

    @Inject Student mStudent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mObjectGraph = ObjectGraph.create(new MainModule());
        mObjectGraph.inject(this);

        setContentView(R.layout.activity_main);

        ((TextView) findViewById(android.R.id.text1)).setText(mStudent.getName());
    }
}
