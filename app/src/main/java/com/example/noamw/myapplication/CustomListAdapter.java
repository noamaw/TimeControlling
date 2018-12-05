package com.example.noamw.myapplication;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter {

    private final ArrayList<TimerObject> timerObjects; //storing the timer objects created
    private final Activity context;     //to reference the Activity


    public CustomListAdapter(Activity context, ArrayList<TimerObject> timerObjects){

        super(context,R.layout.listview_row , timerObjects);

        this.context = context;
        this.timerObjects = timerObjects;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.name_TextView);
        TextView infoTextField = (TextView) rowView.findViewById(R.id.info_TextView);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1ID); //TODO decide if i should remove image from listView.

        TimerObject timer = timerObjects.get(position);
        nameTextField.setText(timer.getDescription());
        infoTextField.setText(timer.getStartTimer() + ""); //TODO decide what im going to display here.
        //imageView.setImageResource(imageIDarray[position]);

        return rowView;

    };
}
