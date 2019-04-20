package com.group6.placementportal;

import android.app.Activity;
<<<<<<< HEAD
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
=======
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.group6.placementportal.DatabasePackage.company;
<<<<<<< HEAD
=======
import com.group6.placementportal.DatabasePackage.job;

import java.util.ArrayList;

import static com.group6.placementportal.R.id.send_notification;
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6


public class company_dashboard extends AppCompatActivity {

    private company c;
        private Activity activity;
<<<<<<< HEAD


=======
        private DatabaseReference reference;
        private DatabaseReference database;
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
        public void onAttach(Activity activity) {
                this.activity = activity;
        }

<<<<<<< HEAD
        private Button send;
        private android.support.v7.widget.CardView profile;
        private android.support.v7.widget.CardView notices;
        private android.support.v7.widget.CardView enrollments;
=======
    private android.support.v7.widget.CardView manage_events;
    private android.support.v7.widget.CardView profile;
    private android.support.v7.widget.CardView notices;
    private android.support.v7.widget.CardView enrollments;
    private android.support.v7.widget.CardView events;
    private android.support.v7.widget.CardView notification;
    private android.support.v7.widget.CardView addnotices;
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6


        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_companydashboard);
<<<<<<< HEAD
              profile   = findViewById(R.id.profile_card);
              enrollments=findViewById(R.id.enrollments_card);
              send = findViewById(R.id.send_notifications);
=======

            if(isNetworkAvailable()==false){
                Toast.makeText(company_dashboard.this,"NO INTERNET CONNECTION", Toast.LENGTH_LONG).show();
                return;
            }

              profile   = findViewById(R.id.profile_card);
              enrollments=findViewById(R.id.enrollments_card);
              manage_events= findViewById(R.id.book_card);
              database= FirebaseDatabase.getInstance().getReference();
              addnotices = findViewById(R.id.AddNotices);
              notification=findViewById(R.id.notification);

>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6

            this.c=(company) getIntent().getSerializableExtra("MyClass");
            profile   = findViewById(R.id.profile_card);
            profile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent company_profile=new Intent(company_dashboard.this, company_profile.class);
<<<<<<< HEAD
                    //company_profile.putExtra("MyClass",c);
                    finish();
=======
                    company_profile.putExtra("MyClass",c);
                    company_profile.putExtra("coming_from","dashboard");
                    //finish();
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
                    startActivity(company_profile);
                }
            });

            notices=findViewById(R.id.notices_card);
<<<<<<< HEAD
            notices.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Intent company_notices=new Intent(company_dashboard.this, company_notices.class);
                    startActivity(company_notices);
                }
            });

            enrollments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent company_enrollements=new Intent(company_dashboard.this,company_enrollments.class);
                    startActivity(company_enrollements);
                }
            });

            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent intent=new Intent(company_dashboard.this, Sending_Notifications.class);
                    startActivity(intent);
=======

            notices.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    reference = FirebaseDatabase.getInstance().getReference().child("Company").child(c.getCompany_id());
                    reference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                            {
                                if(dataSnapshot.hasChild("notices"))
                                {
                                    Intent company_notices=new Intent(company_dashboard.this, company_notices.class);
                                    company_notices.putExtra("MyClass",c);
                                    startActivity(company_notices);
                                }
                                else
                                {
                                    Toast.makeText(company_dashboard.this, "No notice to show", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Toast.makeText(company_dashboard.this, "Oops ... something is wrong", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            });

            notification.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i=new Intent(company_dashboard.this,Sending_Notifications.class);
                    i.putExtra("MyClass",c);
                    startActivity(i);
                }
            });
            enrollments.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent company_enrollments_screen1=new Intent(company_dashboard.this,job_or_intern.class);
                    company_enrollments_screen1.putExtra("MyClass",c);
                    startActivity(company_enrollments_screen1);
                }
            });


            addnotices.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent company_enrollements=new Intent(company_dashboard.this, NoticeFromCompany.class);
                    startActivity(company_enrollements);
                }
            });
            manage_events.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        Intent company_enrollements = new Intent(company_dashboard.this, Company_Application_Slots.class);
                        company_enrollements.putExtra("id", c.getCompany_id());
                        Toast.makeText(company_dashboard.this,c.getCompany_id(),Toast.LENGTH_SHORT).show();
                        startActivity(company_enrollements);

>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
                }
            });


        }
<<<<<<< HEAD
=======
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6


}
