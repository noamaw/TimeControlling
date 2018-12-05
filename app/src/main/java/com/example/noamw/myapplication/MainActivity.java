package com.example.noamw.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<TimerObject> list;
    ListView listView; //TODO change from listView to RecyclerView... in future.

    Button newTimerBtn, infoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newTimerBtn = (Button) findViewById(R.id.newTimer_button);
        infoBtn = (Button) findViewById(R.id.information_button);

        if(savedInstanceState == null || !savedInstanceState.containsKey("key")) {
            list = new ArrayList<TimerObject>();
        }
        else {
            list = savedInstanceState.getParcelableArrayList("key");
        }

        CustomListAdapter timers = new CustomListAdapter(this, list);

        listView = (ListView) findViewById(R.id.timersListView);
        listView.setAdapter(timers);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO add fragment opening with the information regarding specific timer instead of activity.
                Intent intent = new Intent(MainActivity.this, timerDetailActivity.class);
                String message = list.get(position).getDescription();
                intent.putExtra("description", message);
                Long time = list.get(position).getStartTimer();
                intent.putExtra("timer", time);
                startActivity(intent);
            }
        });

        setClickListeners();
    }

    private void setClickListeners() {
        infoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO open Activity with accumulated information regarding total timers gathered
            }
        });

        newTimerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO open new fragment with new timer options: gather appropriate information for new TimerObject creation. which will be added to our timers arrayList
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("key", list);
        super.onSaveInstanceState(outState);
    }
}
