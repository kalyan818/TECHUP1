package com.example.kalya.techup1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Page extends AppCompatActivity {
    Button hum,temp;
    TextView thum,ttem;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef1 = database.getReferenceFromUrl("https://tehup-64565.firebaseio.com/Humidity-current");
    DatabaseReference myRef2 = database.getReferenceFromUrl("https://tehup-64565.firebaseio.com/Temperature-current");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        hum = (Button)findViewById(R.id.hum);
        temp = (Button)findViewById(R.id.temp);
        thum = (TextView) findViewById(R.id.texthum);
        ttem = (TextView) findViewById(R.id.texttemp);
        hum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef1.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue().toString();
                        thum.setText(value);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
        temp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue().toString();
                        ttem.setText(value);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
