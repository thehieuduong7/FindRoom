package com.example.findroom.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.findroom.R;
import com.example.findroom.models.RoomModel;

public class RoomDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);

//        Bundle bundle = getIntent().getExtras();
//
//        if(bundle == null){
//            return;
//        }
//
//        RoomModel room = (RoomModel) bundle.get("object_room");
//        TextView tvdLabelRoom ;
//        tvdLabelRoom =(TextView)findViewById(R.id.tv_detail_label_room);
//
//        try {
//            tvdLabelRoom.setText("change");
//            tvdLabelRoom.setText(String.valueOf(room.getName()));
//        }catch (Exception e){
//            for (int i=0 ;i<100;i++){
//                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
//            }
//
//        }
//
    }


}