package com.example.busnotifier;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Bus> buses = new ArrayList<Bus>();
        buses.add(new Bus("परदेसीपुरा विजयनगर", 1));
        buses.add(new Bus("साई मन्दिर विजयनगर ", 2));
        buses.add(new Bus("कालानि नगर फ़ुटी कोठी", 2));
        buses.add(new Bus("भवरकुवा राऊ पम्प", 3));
        buses.add(new Bus("सपना संगीता रिगल गर्ल्स होस्टल", 2));
        buses.add(new Bus("तिलक नगर वन्दना नगर", 0));
        buses.add(new Bus("देव्गुरदिया इंडस्टृी होउस पलासिया", 3));
        buses.add(new Bus("शालीमार स्कीम खन्डवा नाका", 4));
        buses.add(new Bus("तीन ईमली खजराना बोय्ज होस्टल", 1));
        buses.add(new Bus("खातीवाला राजवाडा अग्निबाण रानी सती गेट", 0));

        BusAdapter busAdapter= new BusAdapter(this, buses);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) findViewById(R.id.busListView);
        listView.setAdapter(busAdapter);

//        Button button = (Button) findViewById(R.id.busDestinations);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Clicked on ", Toast.LENGTH_LONG).show();
//            }
//        });
    }
}
