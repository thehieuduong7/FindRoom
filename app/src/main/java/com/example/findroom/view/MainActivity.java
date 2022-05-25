package com.example.findroom.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.findroom.R;
import com.example.findroom.models.RoomModel;
import com.example.findroom.view.roomAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvData;
    private roomAdapter rAdapter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvData =findViewById(R.id.rcv_main);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        RecyclerView.ItemDecoration itemDecoration =new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

        rAdapter =new roomAdapter(this ,getListRoom());

        rcvData.setAdapter(rAdapter);
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