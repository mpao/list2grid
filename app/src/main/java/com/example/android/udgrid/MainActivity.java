package com.example.android.udgrid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private int nColumns = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        final RecyclerView rv = findViewById(R.id.rv);

        rv.setAdapter(new MyAdapter(this, mockData()));
        rv.setLayoutManager(new GridLayoutManager(this, 1));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nColumns = nColumns == 1 ? 2 : 1;
                ((GridLayoutManager) rv.getLayoutManager()).setSpanCount(nColumns);
            }
        });
    }

    private String[] mockData(){
        String[] array = new String[100];
        for (int i = 0; i < array.length; i++)
            array[i] = "Value " + String.valueOf(i);
        return array;
    }
}