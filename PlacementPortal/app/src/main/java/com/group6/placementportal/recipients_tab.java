<<<<<<< HEAD
package com.group6.placementportal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
=======
/*
package com.group6.placementportal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
<<<<<<< HEAD
import com.group6.placementportal.DatabasePackage.notices2company;
=======
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6

public class recipients_tab extends AppCompatActivity {
    private CardArrayAdapter cardArrayAdapter;
    private ListView listView;
    private DatabaseReference db= FirebaseDatabase.getInstance().getReference("Company");



    protected void onStart() {
        super.onStart();

        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    Log.d("check", dataSnapshot.getRef().toString());
                    for (DataSnapshot c : dataSnapshot.getChildren()) {
                        // Log.d("check notices",notice.getRef().toString());
                        if(!c.getKey().equals("Max_entry")){
                            Log.d("check check", c.getRef().toString());
                            String company_name = c.child("company_name").getValue().toString();
<<<<<<< HEAD
                            String company_id = c.child("compnany_id").getValue().toString();
                            Card card_new = new Card("Name: " + company_name, "ID: " + company_id);

                            cardArrayAdapter.add(card_new);
                        }
                      //  Log.d("check check", c.getRef().toString());
                       // String company_name = c.child("company_name").getValue().toString();
                        //String company_id = c.child("compnany_id").getValue().toString();
=======
                            String company_id = c.child("company_id").getValue().toString();
                           // Card card_new = new Card("Name: " + company_name, "ID: " + company_id);

                           // cardArrayAdapter.add(card_new);
                        }
                      //  Log.d("check check", c.getRef().toString());
                       // String company_name = c.child("company_name").getValue().toString();
                        //String company_id = c.child("company_id").getValue().toString();
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
                        //Card card_new = new Card("Name" + company_name, "ID" + company_id);
                        //cardArrayAdapter.add(card_new);
                        // Log.d(nc.getTitle().toString(),nc.getDescription().toString());


                    }
                    ListView listview = findViewById(R.id.card_listView);
                    listview.addHeaderView(new View(recipients_tab.this));
                    listview.addHeaderView(new View(recipients_tab.this));
                    listview.setAdapter(cardArrayAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipients_tab);

<<<<<<< HEAD
=======
        if(isNetworkAvailable()==false){
            Toast.makeText(recipients_tab.this,"NO INTERNET CONNECTION", Toast.LENGTH_LONG).show();
            return;
        }

>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
        listView = (ListView) findViewById(R.id.card_listView);

        listView.addHeaderView(new View(this));
        listView.addFooterView(new View(this));

        cardArrayAdapter = new CardArrayAdapter(getApplicationContext(), R.layout.list_item_card);


        listView.setAdapter(cardArrayAdapter);
    }
<<<<<<< HEAD



}
=======
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

}
*/
>>>>>>> e163f38a9195dbe1e94cd8f150a6c0cb43dd67f6
