package com.example.findroom.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.MonthDisplayHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.findroom.R;
import com.example.findroom.controler.ImageConvert;
import com.example.findroom.models.RoomModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.Serializable;
import java.util.ArrayList;

public class RoomDetailActivity extends AppCompatActivity {

    private EditText rName, rLocation, rPrice, rNote, rDeposit, rArea, rType ;

    private ImageConvert imageConvert ;
    private RoomModel lRoom ;

    private BottomNavigationView bottomNavigationView;
    private MenuItem item ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
        bottomNavigationView =findViewById(R.id.bottom_nav_view);
        bottomNavigationView.setSelectedItemId(R.id.edit);
        SetUpBottomNavigation();


        // get data intent
        lRoom = getDataIntent();
        Log.e("data detail room" ,lRoom.getName());
    }

    public RoomModel getDataIntent(){
        Intent intent = getIntent();
        RoomModel temp =(RoomModel) intent.getSerializableExtra("object_room");
        return temp;
    }

    private void setContentDetailRoom(){

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.botton_nav_menu, menu);
        return true;
    }

    public void SetUpBottomNavigation() {

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.noti:

                        Log.e("nice","noti");
                        return true;
                    case R.id.more:
                        Log.e("nice","more");
                        return true;
                    case R.id.edit:
                        Log.e("nice","edit");
                        return true;
                    case R.id.home:
                        try {
                            Intent intent =new Intent(RoomDetailActivity.this,MainActivity.class);
                            startActivity(intent);

                        }catch (Exception e){
                            Log.e("error",e.toString());
                        }
                        Log.e("nice","home");
                        return true;

                    default:
                        return false;
                }
            }
        });
    }
}