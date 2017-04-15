package com.example.busnotifier;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;

/**
 * Created by abhay on 6/4/17.
 */

public class BusAdapter extends ArrayAdapter<Bus> {
    public BusAdapter(Activity context, ArrayList<Bus> buses){
        super(context, 0, buses);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View busListItemView = convertView;
        if(busListItemView == null) {
            busListItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Typeface typeFace = Typeface.createFromAsset(getContext().getAssets(), "fonts/EraserRegular.ttf");
        Bus currentBus = getItem(position);

        final Button destinationsTextView = (Button) busListItemView.findViewById(R.id.busDestinations);
        destinationsTextView.setText(currentBus.getDestinations());
        destinationsTextView.setTypeface(typeFace);
        destinationsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Subscribed to: "+destinationsTextView.getText(), Toast.LENGTH_LONG).show();
                FirebaseMessaging.getInstance().subscribeToTopic(destinationsTextView.getText().toString());
            }
        });

        TextView busNumberTextView = (TextView) busListItemView.findViewById(R.id.busNumber);
        busNumberTextView.setText(String.valueOf(currentBus.getBusNumber()));
        busNumberTextView.setTypeface(typeFace);
        return busListItemView;
    }
}
