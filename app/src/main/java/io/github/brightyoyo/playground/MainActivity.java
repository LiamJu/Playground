package io.github.brightyoyo.playground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ListView _listView = (ListView) findViewById(android.R.id.list);
        List<String> items = new ArrayList<>();
        final String str = "Item ";
        for (int i = 0; i < 20; i++) {
            items.add(i, str + i);
        }
        _listView.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, android.R.id.text1, items));

    }
}
