package com.example.findroom.controler;

import android.util.Log;

import com.example.findroom.models.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginController {
    private static final String TAG = "Register";
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef = mDatabase.getReference();

    public LoginController(){}

    public void registerUser(UserModel user){
        DatabaseReference userNameRef = mRef.child("Users").child(user.getUsername());
        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                UserModel dbUser = dataSnapshot.getValue(UserModel.class);
                if(user.getPassword().equals(dbUser.getPassword())){
                    //Login thanh cong
                }
                else{
                    //Sai mat khau
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d(TAG, databaseError.getMessage());
            }
        };
        userNameRef.addListenerForSingleValueEvent(eventListener);

    }
}
