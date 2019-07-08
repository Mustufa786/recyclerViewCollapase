package com.codixlab.collapsingrecyclerview.ui;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.codixlab.collapsingrecyclerview.R;
import com.codixlab.collapsingrecyclerview.adapter.CollapseAdapter;
import com.codixlab.collapsingrecyclerview.databinding.ActivityMainBinding;
import com.codixlab.collapsingrecyclerview.model.Person;
import com.codixlab.collapsingrecyclerview.util.Data;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding bi;
    CollapseAdapter adapter;
    List<Person> personList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bi = DataBindingUtil.setContentView(this, R.layout.activity_main);


        init();


    }

    private void init() {


        setSupportActionBar(bi.toolbar);
        getSupportActionBar().setTitle("Expandable");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);




        personList = new ArrayList<>();
        personList = Data.getPersonsData(this);
        personList.addAll(Data.getPersonsData(this));
        adapter = new CollapseAdapter(this, personList);
        bi.list.setLayoutManager(new LinearLayoutManager(this));
        bi.list.setHasFixedSize(true);
        bi.list.setAdapter(adapter);


    }
}
