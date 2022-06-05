package com.example.findroom.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.findroom.R;
import com.example.findroom.controler.DatabaseControler;
import com.example.findroom.controler.RegisterController;
import com.example.findroom.models.UserModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RegisterView extends AppCompatActivity {
    private FirebaseDatabase database ;
    private DatabaseReference myRef ;

    private RegisterController cRegis;
    private static final String TAG = "Register";
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRef ;
    Button btnLogin, btnRegis ;
    EditText edName , edSdt , edPw , edRpw ;

    DatabaseControler cdb =new DatabaseControler();
    UserModel userModel ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_view);

        Bind();

        Log.e("test",edSdt.getText().toString());

        btnRegis.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            database = FirebaseDatabase.getInstance();
                                            userModel = new UserModel(edSdt.getText().toString().trim(), edPw.getText().toString().trim(), edName.getText().toString().trim());
                                            Log.e("regis:", edName.getText().toString());
                                            Log.e("regis:", edSdt.getText().toString());
                                            Log.e("regis:", edRpw.getText().toString());
                                            Log.e("regis:", userModel.getSdt());
                                            //Regis(userModel);
                                            cdb.PushDataUser(userModel);
                                            Toast.makeText(RegisterView.this, "Register success", Toast.LENGTH_SHORT).show();
                                        }
                                    });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterView.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

//    private void Regis(UserModel user){
//        DatabaseReference userNameRef = mRef.child("Users").child(user.getUsername());
//        ValueEventListener eventListener = new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                UserModel dbUser = dataSnapshot.getValue(UserModel.class);
//                if(user.getPassword().equals(dbUser.getPassword())){
//                    Log.e("login","sc");
//                }
//                else{
//                    Log.e("login","fail");
//                }
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//                Log.d(TAG, databaseError.getMessage());
//            }
//        };
//        userNameRef.addListenerForSingleValueEvent(eventListener);
//
//
//
//    }



    private void Bind(){
        btnLogin =findViewById(R.id.btnLogin);
        btnRegis =findViewById(R.id.btnRegister);
        edName = findViewById(R.id.edt_name);
        edPw =findViewById(R.id.edt_pass_regis);
        edRpw =findViewById(R.id.edt_regis_pass_again);
        edSdt =findViewById(R.id.edt_phone);
    }
}