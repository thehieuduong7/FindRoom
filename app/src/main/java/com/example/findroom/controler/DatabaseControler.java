package com.example.findroom.controler;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.findroom.models.RoomModel;
import com.example.findroom.models.UserModel;
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

    public DatabaseControler() {
        database = FirebaseDatabase.getInstance();
    }

    public void PushDataRoom(RoomModel roomitem){
        Random generator = new Random();
        String room = String.valueOf(generator.nextInt(1000000));
        myRef = database.getReference("room_info/"+"r"+room);
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
