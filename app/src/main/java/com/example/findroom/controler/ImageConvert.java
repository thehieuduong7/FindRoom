package com.example.findroom.controler;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import androidx.appcompat.app.AppCompatActivity;

import com.example.findroom.R;

import java.io.ByteArrayOutputStream;

public class ImageConvert extends AppCompatActivity {
    public Bitmap ConvertStringToBitmapImage(String imgString){
        byte[] decodedString = Base64.decode(imgString, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        return decodedByte;
    }

    public String convertImageToString(){
        Bitmap bitmapImage;
        bitmapImage = BitmapFactory.decodeResource(getResources(), R.drawable.download);
        String imgString = Base64.encodeToString(getBytesFromBitmap(bitmapImage),
                Base64.NO_WRAP);
        return imgString;
    }

    public byte[] getBytesFromBitmap(Bitmap bitmap) {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, stream);
        return stream.toByteArray();
    }
}




