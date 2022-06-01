package com.example.findroom.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.findroom.R;
import com.example.findroom.controler.DatabaseControler;
import com.example.findroom.controler.ImageConvert;
import com.example.findroom.models.RoomModel;


import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

    private List<RoomModel> getListRoom() {
        List<RoomModel> list =new ArrayList<>();


        list.add(new RoomModel(R.drawable.roomgood, "this is girl", 10 ,"viet nam"));
        list.add(new RoomModel(R.drawable.download, "this is good", 10 ,"viet nam"));
        list.add(new RoomModel(R.drawable.roooom, "this is good", 10 ,"viet nam"));
        list.add(new RoomModel(R.drawable.download, "this is good", 10 ,"viet nam"));
        list.add(new RoomModel(R.drawable.download, "this is good", 10 ,"viet nam"));

        return list;
    }
}