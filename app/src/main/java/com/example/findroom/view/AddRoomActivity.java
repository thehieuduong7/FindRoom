package com.example.findroom.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.example.findroom.R;
import com.example.findroom.models.RoomModel;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

public class AddRoomActivity extends AppCompatActivity {

    // ------ upload image ------------------
    Button select, previous, next;
    ImageSwitcher imageView;
    int PICK_IMAGE_MULTIPLE = 1;
    String imageEncoded;
    TextView total;
    ArrayList<Uri> mArrayUri;
    int position = 0;
    List<String> imagesEncodedList;
    // ------- end of upload image ----------

    private Button btnAddRoom;
    TextInputLayout txtName;
    private RadioButton rdbType;
    private String typeRoom = " ";
    private TextInputEditText txtInputNameRoom,itxtPrice,itxtLocation,itxtStatus,itxtArea,itxtDeposit,itxtNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_room);

        ChoiceImage();
        btnAddRoom = findViewById(R.id.btn_submit);
        btnAddRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }

    private void ChoiceImage(){
        select = findViewById(R.id.select);
        total = findViewById(R.id.text);
        imageView = findViewById(R.id.image);
        previous = findViewById(R.id.previous);
        mArrayUri = new ArrayList<Uri>();

        // showing all images in imageswitcher
        imageView.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView1 = new ImageView(getApplicationContext());
                return imageView1;
            }
        });

        // click here to select next image
        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position < mArrayUri.size() - 1) {
                    // increase the position by 1
                    position++;
                    imageView.setImageURI(mArrayUri.get(position));
                } else {
                    Toast.makeText(AddRoomActivity.this, "Last Image Already Shown", Toast.LENGTH_SHORT).show();
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
                    imageView.setImageURI(mArrayUri.get(position));
                }
            }
        });

        imageView = findViewById(R.id.image);

        // click here to select image
        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // initialising intent
                Intent intent = new Intent();

                // setting type to select to be image
                intent.setType("image/*");

                // allowing multiple image to be selected
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_MULTIPLE);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // When an Image is picked
        if (requestCode == PICK_IMAGE_MULTIPLE && resultCode == RESULT_OK && null != data) {
            // Get the Image from data
            if (data.getClipData() != null) {
                ClipData mClipData = data.getClipData();
                int cout = data.getClipData().getItemCount();
                for (int i = 0; i < cout; i++) {
                    // adding imageuri in array
                    Uri imageurl = data.getClipData().getItemAt(i).getUri();
                    mArrayUri.add(imageurl);
                }
                // setting 1st selected image into image switcher
                imageView.setImageURI(mArrayUri.get(0));
                position = 0;
            } else {
                Uri imageurl = data.getData();
                mArrayUri.add(imageurl);
                imageView.setImageURI(mArrayUri.get(0));
                position = 0;
            }
        } else {
            // show this if no image is selected
            Toast.makeText(this, "You haven't picked Image", Toast.LENGTH_LONG).show();
        }
    }

    private String getTypeRoomStr() {
        RadioGroup gr = findViewById(R.id.radioGroup);
        RadioButton test;
        String typeRoom;
        switch (gr.getCheckedRadioButtonId()) {
            case (R.id.rb_type_tro):
                test = findViewById(R.id.rb_type_tro);
                typeRoom = test.getText().toString();
                break;
            case (R.id.rb_type_chungcu):
                test = findViewById(R.id.rb_type_chungcu);
                typeRoom = test.getText().toString();
                break;
            case (R.id.rb_type_ktx):
                test = findViewById(R.id.rb_type_ktx);
                typeRoom = test.getText().toString();
                break;
            case (R.id.rb_type_homestay):
                test = findViewById(R.id.rb_type_homestay);
                typeRoom = test.getText().toString();
                break;
            default:
                typeRoom ="nothing";
                throw new IllegalStateException("Unexpected value: " + gr.getCheckedRadioButtonId());
        }
        return typeRoom;
    }

    private String getStatusRoom() {
        RadioGroup gr = findViewById(R.id.radioGroup_status);
        RadioButton test;
        String typeRoom;
        switch (gr.getCheckedRadioButtonId()) {
            case (R.id.rb_status_controng):
                test = findViewById(R.id.rb_status_controng);
                typeRoom = test.getText().toString();
                break;
            case (R.id.rb_type_dachothue):
                test = findViewById(R.id.rb_type_dachothue);
                typeRoom = test.getText().toString();
                break;
            default:
                typeRoom ="nothing";
                throw new IllegalStateException("Unexpected value: " + gr.getCheckedRadioButtonId());
        }
        return typeRoom;
    }

    private RoomModel getItemRoom()
    {
        RoomModel roomModel = new RoomModel() ;

        String rname ;
        String typeRoom ;
        Float rPrice ;
        String rStatus ;
        Float rArea ,rDeposit;
        String rLocation ,rNote;
        List<String> rListImage ;

        txtInputNameRoom =findViewById(R.id.txt_input_room_name);
        itxtArea =findViewById(R.id.txt_input_room_area);
        itxtDeposit =findViewById(R.id.txt_input_room_deposit);
        itxtLocation =findViewById(R.id.txt_input_room_location);
        itxtNote =findViewById(R.id.txt_input_room_note);
        itxtPrice =findViewById(R.id.txt_input_room_price);

        rname =txtInputNameRoom.getText().toString();
        typeRoom =getTypeRoomStr();
        rPrice = Float.valueOf(itxtPrice.getText().toString()) ;
        rArea = Float.valueOf(itxtArea.getText().toString()) ;
        rDeposit = Float.valueOf(itxtDeposit.getText().toString()) ;
        rStatus =getStatusRoom();
        rLocation = itxtLocation.getText().toString();
        rNote = itxtNote.getText().toString();

        return roomModel;
    }
}