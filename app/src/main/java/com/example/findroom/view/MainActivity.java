package com.example.findroom.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.findroom.R;
import com.example.findroom.controler.DatabaseControler;
import com.example.findroom.models.RoomModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static boolean logined ;
    static boolean ishome = true ;
    static String rid ;
    static String idUser ;
    static ArrayList<RoomModel> rRoomu;
    private FloatingActionButton btnAddRoom;
    private DatabaseControler db ;
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rcvData;
    private roomAdapter rAdapter ;
    private ArrayList<RoomModel> arrRoom ;
    private ImageView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logined =false;
        rcvData =findViewById(R.id.rcv_main);
        btnAddRoom =findViewById(R.id.fab_add_room);
        btnAddRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this ,AddRoomActivity.class);
                startActivity(intent);
            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration =new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);


        bottomNavigationView =findViewById(R.id.bottom_nav_view);
        SetUpBottomNavigation();



        // add room
        arrRoom =getListRoom();

        rAdapter =new roomAdapter(this ,arrRoom);

        rcvData.setAdapter(rAdapter);
    }



    public byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return stream.toByteArray();
    }

    @Override
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
                        Intent intentlogin = new Intent(MainActivity.this,LoginActivity.class);
                        startActivity(intentlogin);
                        Log.e("nice","noti");
                        return true;
                    case R.id.more:
                        Log.e("nice","more");
                        return true;
                    case R.id.edit:
                        try {
                            ishome =false ;

                        }catch (Exception e){
                            Log.e("error",e.toString());
                        }

                        Log.e("nice","edit");
                        return true;
                    case R.id.home:

                        Log.e("nice","home");
                        return true;

                    default:
                        return false;
                }
            }
        });
    }



    private ArrayList<RoomModel> getListRoom() {
        db =new DatabaseControler();
        ArrayList<RoomModel> r = db.ReadItemData();
        return r;
    }
}