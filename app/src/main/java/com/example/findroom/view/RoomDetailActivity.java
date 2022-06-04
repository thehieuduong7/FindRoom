package com.example.findroom.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.MonthDisplayHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.findroom.R;
import com.example.findroom.controler.ImageConvert;
import com.example.findroom.models.RoomModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RoomDetailActivity extends AppCompatActivity {

    private TextView rName, rLocation, rPrice, rNote, rDeposit, rArea, rType, rStatus ;

    private ImageConvert imageConvert ;
    private RoomModel lRoom ;

    Button select, previous, next;
    ImageSwitcher imageView;
    int PICK_IMAGE_MULTIPLE = 1;
    String imageEncoded;
    TextView total;
    ArrayList<Bitmap> mArrayBitmap;
    int position = 0;
    List<String> imagesEncodedList;

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
        setContentDetailRoom(lRoom);
        Log.e("data detail room" ,String.valueOf( convertArrStrtoArrBitmap(lRoom.getlImage()).size()));
    }

    public RoomModel getDataIntent(){
        Intent intent = getIntent();
        RoomModel temp =(RoomModel) intent.getSerializableExtra("object_room");
        return temp;
    }

    private void setContentDetailRoom(RoomModel room){

        rName = findViewById(R.id.tv_label_room);
        rType =findViewById(R.id.tv_detail_room_type);
        rArea =findViewById(R.id.tv_detail_area);
        rDeposit =findViewById(R.id.tv_detail_money_first);
        rNote =findViewById(R.id.tv_detail_note);
        rLocation =findViewById(R.id.tv_detail_location);
        rPrice =findViewById(R.id.tv_detail_price);
        rStatus = findViewById(R.id.tv_detail_status);

        rName.setText(room.getName());
        rType.setText("Loại                :  " + room.getType());
        rArea.setText("Diện tích        :  "+  String.valueOf(room.getArea()) + "m2");
        rDeposit.setText("Tiền cọc          :  "+ String.valueOf(room.getDeposit())+ "  VNĐ");
        rNote.setText("Chi tiết            :  "+String.valueOf(room.getNote()));
        rLocation.setText("Địa chỉ           :  "+room.getLocation());
        rPrice.setText("Giá                  :  "+String.valueOf(room.getPrice()) + "  VNĐ");
        rStatus.setText("Trạng thái      :  "+ room.getStatus());

        imageList(convertArrStrtoArrBitmap(room.getlImage()));
    }

    public ArrayList<Bitmap> convertArrStrtoArrBitmap(ArrayList<String> lStrImage){
        ArrayList<Bitmap> temp = new ArrayList<>();
        ImageConvert imageConvert = new ImageConvert();
        for (int i=0;i<lStrImage.size();i++){
            temp.add(imageConvert.ConvertStringToBitmapImage(lStrImage.get(i)));
        }
        return temp;
    }
    private void imageList(ArrayList<Bitmap> lStrImage){
        select = findViewById(R.id.select);
        total = findViewById(R.id.text);
        imageView = findViewById(R.id.image);
        previous = findViewById(R.id.previous);
        mArrayBitmap = new ArrayList<Bitmap>();
        mArrayBitmap = lStrImage;
        // showing all images in imageswitcher
        imageView.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView1 = new ImageView(getApplicationContext());
                imageView1.setImageBitmap(lStrImage.get(0));
                return imageView1;
            }
        });

        // click here to select next image
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position < mArrayBitmap.size() - 1) {
                    // increase the position by 1
                    position++;
                    imageView.setImageDrawable(new BitmapDrawable(getResources(), mArrayBitmap.get(position)));


//


                } else {
                    Log.e("pos",String.valueOf(position));
                    Toast.makeText(RoomDetailActivity.this, "Last Image Already Shown", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // click here to view previous image
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position > 0) {
                    // decrease the position by 1
                    position--;
                    imageView.setImageDrawable(new BitmapDrawable(getResources(), mArrayBitmap.get(position)));

                }
            }
        });

        imageView = findViewById(R.id.image);


        // click here to select image
//        select.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                // initialising intent
//                Intent intent = new Intent();
//
//                // setting type to select to be image
//                intent.setType("image/*");
//
//                // allowing multiple image to be selected
//                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_MULTIPLE);
//            }
//        });

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