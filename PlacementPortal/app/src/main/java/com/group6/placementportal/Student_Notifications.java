package com.group6.placementportal;

<<<<<<< HEAD
import android.content.Intent;
=======
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.group6.placementportal.DatabasePackage.Notifications;
import com.group6.placementportal.DatabasePackage.Student;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.Collections;
=======
import com.microsoft.identity.client.IAccount;
import com.microsoft.identity.client.PublicClientApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6

public class Student_Notifications extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

<<<<<<< HEAD
        private Student user;

        private int num;
=======
    private Student user;

    private int num;
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6

    private DatabaseReference reference;
    private RecyclerView recyclerView;
    private ArrayList<Notifications> list;
    private MyAdapter_Notifications adapter;
<<<<<<< HEAD
=======
    private PublicClientApplication sampleApp;
    private int flag;

    private static final String TAG = Student_Dashboard.class.getSimpleName();
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__notifications);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

<<<<<<< HEAD
=======
        if(isNetworkAvailable()==false){
            Toast.makeText(Student_Notifications.this,"NO INTERNET CONNECTION", Toast.LENGTH_LONG).show();
            return;
        }

>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

<<<<<<< HEAD
        user=(Student) getIntent().getSerializableExtra("user");
        recyclerView = findViewById(R.id.recycler_notifications);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
=======
        user = (Student) getIntent().getSerializableExtra("user");
        recyclerView = findViewById(R.id.recycler_notifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        sampleApp = null;
        if (sampleApp == null) {
            sampleApp = new PublicClientApplication(
                    this.getApplicationContext(),
                    R.raw.auth_config);
        }
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6


        reference = FirebaseDatabase.getInstance().getReference().child("Notifications");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
<<<<<<< HEAD
                list = new ArrayList<Notifications>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren())
                {
                    Notifications p = dataSnapshot1.getValue(Notifications.class);
                    String ID= p.getNotification_ID();
                    //TO DO TASK LEFT
                    //check for id in students list of notifications IDS and then add to the list
                    String list_of_IDs=user.getList_of_Notification_IDs();
                    String[] split_IDs =list_of_IDs.split("\\,");
                    boolean flag1=false;
                    for(int i=0;i<split_IDs.length;i++){
                        Log.d("myTag", split_IDs[i]+" "+ID+" "+ split_IDs[i].equals(ID));
                        if(split_IDs[i].equals(ID)){
                            flag1=true;
                        }
                    }
                    if(flag1==true) {
=======
                list = new ArrayList<>();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    Notifications p = dataSnapshot1.getValue(Notifications.class);
                    String ID = p.getNotification_ID();
                    //TO DO TASK LEFT
                    //check for id in students list of notifications IDS and then add to the list
                    String list_of_IDs = user.getList_of_Notification_IDs();
                    String[] split_IDs = list_of_IDs.split("\\,");
                    boolean flag1 = false;
                    for (int i = 0; i < split_IDs.length; i++) {
                        Log.d("myTag", split_IDs[i] + " " + ID + " " + split_IDs[i].equals(ID));
                        if (split_IDs[i].equals(ID)) {
                            flag1 = true;
                        }
                    }
                    if (flag1 == true) {
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
                        list.add(p);
                    }
                }
                Collections.reverse(list);
<<<<<<< HEAD
                adapter = new MyAdapter_Notifications(Student_Notifications.this,list);
=======
                adapter = new MyAdapter_Notifications(Student_Notifications.this, list);
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Student_Notifications.this, "Opsss.... Something is wrong", Toast.LENGTH_SHORT).show();
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
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_student__dashboard_drawer, menu);
        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_dash) {
            Intent i = new Intent(getApplicationContext(), Student_Dashboard.class);
            i.putExtra("user",user);
            startActivity(i);
<<<<<<< HEAD
=======
            exit();
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6

        } else if (id == R.id.nav_notifications) {
            Intent i = new Intent(getApplicationContext(), Student_Notifications.class);
            i.putExtra("user",user);
            startActivity(i);
<<<<<<< HEAD

        } else if (id == R.id.nav_prefr) {

        } else if (id == R.id.nav_company) {
            Intent i = new Intent(getApplicationContext(), View_Jobs.class);
            i.putExtra("user",user);
            startActivity(i);

        } else if (id == R.id.nav_calendar) {

        } else if (id == R.id.nav_my_profile) {

        } else if (id == R.id.nav_edit_profile) {
            Intent i = new Intent(getApplicationContext(), Student_Profile.class);
=======
            exit();

        } else if (id == R.id.nav_prefr_job) {
            Intent i = new Intent(getApplicationContext(), GivePreference.class);
            i.putExtra("user",user);
            startActivity(i);
            exit();

        } else if (id == R.id.nav_prefr_internships) {
            Intent i = new Intent(getApplicationContext(), GivePreference_Interns.class);
            i.putExtra("user",user);
            startActivity(i);
            exit();

        } else if (id == R.id.nav_jobs) {
            Intent i = new Intent(getApplicationContext(), View_Jobs.class);
            i.putExtra("user",user);
            startActivity(i);
            exit();

        } else if (id == R.id.nav_interns) {
            Intent i = new Intent(getApplicationContext(), View_Interns.class);
            i.putExtra("user",user);
            startActivity(i);
            exit();

        } else if (id == R.id.nav_my_profile) {
            Intent i = new Intent(getApplicationContext(), Student_View_Profile.class);
            i.putExtra("user",user);
            startActivity(i);
            exit();

        } else if (id == R.id.nav_edit_profile) {
            Intent i = new Intent(getApplicationContext(), Student_Complete_Profile.class);
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
            i.putExtra("user",user);
            startActivity(i);

        } else if (id == R.id.nav_change_pass) {
            Intent i = new Intent(getApplicationContext(), Student_ChangePassword.class);
            i.putExtra("user",user);
            startActivity(i);
<<<<<<< HEAD

        } else if (id == R.id.nav_help) {

=======
            exit();

        } else if (id == R.id.nav_applications) {
            Intent i = new Intent(getApplicationContext(), Student_Application_Forms.class);
            i.putExtra("user",user);
            startActivity(i);

        } else if (id == R.id.nav_help) {
            Intent i = new Intent(getApplicationContext(), FAQ.class);
            i.putExtra("user",user);
            startActivity(i);

        } else if (id == R.id.nav_inst_profile) {
            Intent i = new Intent(getApplicationContext(), Help_Students.class);
            i.putExtra("user",user);
            startActivity(i);

        } else if(id == R.id.nav_signout){
            onSignOutClicked();
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
<<<<<<< HEAD
=======

    /* Clears an account's tokens from the cache.
     * Logically similar to "sign out" but only signs out of this app.
     */
    private void onSignOutClicked() {

        /* Attempt to get a account and remove their cookies from cache */
        List<IAccount> accounts = null;

        try {
            accounts = sampleApp.getAccounts();

            if (accounts == null) {
                /* We have no accounts */
                updateSignedOutUI();

            } else if (accounts.size() == 1) {
                /* We have 1 account */
                /* Remove from token cache */
                sampleApp.removeAccount(accounts.get(0));
                updateSignedOutUI();

            }
            else {
                /* We have multiple accounts */
                for (int i = 0; i < accounts.size(); i++) {
                    sampleApp.removeAccount(accounts.get(i));
                }
                updateSignedOutUI();
            }

            Toast.makeText(getBaseContext(), "Signed Out!", Toast.LENGTH_SHORT).show();

        } catch (IndexOutOfBoundsException e) {
            Log.d(TAG, "User at this position does not exist: " + e.toString());
        }
    }

    private void updateSignedOutUI() {
        flag=1;
        Intent intent = new Intent(Student_Notifications.this,LoginPage.class);
        intent.putExtra("flag",flag);
        startActivity(intent);
        exit();
    }
    private void exit(){
        Student_Notifications.this.finish();
    }
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
}
