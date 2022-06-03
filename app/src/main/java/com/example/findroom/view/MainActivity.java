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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.findroom.R;
import com.example.findroom.controler.DatabaseControler;
import com.example.findroom.controler.ImageConvert;
import com.example.findroom.models.RoomModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DatabaseControler db ;
    private BottomNavigationView bottomNavigationView;
    private RecyclerView rcvData;
    private roomAdapter rAdapter ;
    private Button tempAdd;
    private ImageView test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvData =findViewById(R.id.rcv_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration =new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);


        bottomNavigationView =findViewById(R.id.bottom_nav_view);
        SetUpBottomNavigation();
        tempAdd =findViewById(R.id.btn_add);
        tempAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseControler db =new DatabaseControler();
                RoomModel roomitem =new RoomModel(10,"cho thue nha tro",100000,"quận 1 ,thành phố Hồ Chí Minh");
                db.PushDataRoom(roomitem);
                db.ReadData();
                //db.DeleteData("connect");
                Intent intent =new Intent(MainActivity.this,AddRoomActivity.class);
                startActivity(intent);
            }
        });

        rAdapter =new roomAdapter(this ,getListRoom());

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

                        Log.e("nice","noti");
                        return true;
                    case R.id.more:
                        Log.e("nice","more");
                        return true;
                    case R.id.edit:
                        try {
                            Intent intent =new Intent(MainActivity.this,RoomDetailActivity.class);
                            startActivity(intent);
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