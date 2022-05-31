package com.example.findroom.controler;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.findroom.models.RoomModel;
import com.example.findroom.view.AddRoomActivity;
import com.example.findroom.view.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DatabaseControler {
    private FirebaseDatabase database ;
    private DatabaseReference myRef ;

    public DatabaseControler() {
        database = FirebaseDatabase.getInstance();
    }

    public void PushDataRoom(RoomModel roomitem){

        myRef = database.getReference("room_info/room1");
        myRef.setValue(roomitem);
    }

    public void ReadData(){
        myRef = database.getReference("connect");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                Log.e("value",value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
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