package com.group6.placementportal;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.group6.placementportal.DatabasePackage.Jobs;
import com.group6.placementportal.DatabasePackage.company;
import com.group6.placementportal.DatabasePackage.job;

import java.util.ArrayList;

public class job_list extends AppCompatActivity {

    private String c;
    private DatabaseReference reference;
    private RecyclerView recyclerView;
    private job_adapter adapter;
    private ArrayList<job> list;
    private Button fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_list);

        c = getIntent().getSerializableExtra("id").toString();

        recyclerView =findViewById(R.id.add_job_list);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        fab=findViewById(R.id.fab);
        reference = FirebaseDatabase.getInstance().getReference().child("Company").child("jobs");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<job>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    job p = dataSnapshot1.getValue(job.class);
                    list.add(p);
                }
                adapter = new job_adapter(job_list.this,list,c);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(job_list.this, "Oops ... something is wrong", Toast.LENGTH_SHORT).show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent job_profile=new Intent(job_list.this, job_profile.class);
                job_profile.putExtra("MyClassID",c);
                job_profile.putExtra("PrevActivity","job_list");
                startActivity(job_profile);
            }
        });
    }
}

