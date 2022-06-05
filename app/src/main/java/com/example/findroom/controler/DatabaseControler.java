package com.example.findroom.controler;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.findroom.models.RoomModel;
import com.example.findroom.models.UserModel;
import com.example.findroom.models.connect;
import com.example.findroom.view.AddRoomActivity;
import com.example.findroom.view.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class DatabaseControler {
    private FirebaseDatabase database ;
    private DatabaseReference myRef ;

    Random generator = new Random();
    String room;
    public DatabaseControler() {

        this.room ="r"+ String.valueOf(generator.nextInt(1000000));
        database = FirebaseDatabase.getInstance();
    }

    public void PushDataConnect(connect connect){
        myRef = database.getReference("connect");
        myRef.setValue(connect);
    }


    public void PushDataRoom(RoomModel roomitem){

        myRef = database.getReference("room_info/"+room);
        myRef.setValue(roomitem);
    }
    public void PushDataUser(UserModel user){
        myRef = database.getReference("user/"+user.getSdt());
        myRef.setValue(user);
    }

    public void ReadData(){
        myRef = database.getReference("room_info");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                RoomModel value = snapshot.getValue(RoomModel.class);

                //Log.e("value",value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    public ArrayList<RoomModel> ReadItemData() {
        ArrayList<RoomModel> room =new ArrayList<>();
        myRef = database.getReference("room_info");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                room.clear();
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    RoomModel rItem = dataSnapshot.getValue(RoomModel.class);
                    Log.e("DONE read data",rItem.getName().toString());
                    room.add(rItem);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("DONE","NO DONE");

            }
        });
        return room;
    }
//    public ArrayList<UserModel> ReadUserData() {
//        ArrayList<UserModel> room =new ArrayList<>();
//        myRef = database.getReference("user");
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
//                    UserModel rItem = dataSnapshot.getValue(UserModel.class);
//                    Log.e("DONE read data",rItem.getSdt().toString());
//                    room.add(rItem);
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Log.e("DONE","NO DONE");
//
//            }
//            Log.e("romm",room.get)
//        });
//        return room;
//    }
    public void DeleteData(String path){
        myRef = database.getReference(path);
        myRef.removeValue(new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                Log.e("remove","done");
            }
        });
    }
}
