package com.example.findroom.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.findroom.R;
import com.example.findroom.models.RoomModel;

import java.util.List;

public class roomAdapter extends RecyclerView.Adapter<roomAdapter.roomViewHolder> {

    private List<RoomModel> mListRoom;
    private Context mContext ;

    public roomAdapter( Context mContext,List<RoomModel> mListRoom) {
        this.mListRoom = mListRoom;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public roomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_room,parent,false);
        return new roomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull roomViewHolder holder, int position) {
        final RoomModel room = mListRoom.get(position);
        if (room == null){
            return;
        }

        holder.imgRoom.setImageResource(room.getImgResoure());
        holder.tvLabelRoom.setText(room.getName());
        holder.tvPrice.setText(String.valueOf(room.getPrice()) );
        holder.tvLocation.setText(room.getLocation());

        // bắt sự kiện click vào item để sang trang detail
        holder.layoutRoomItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGoToRoomDetail(room);
            }
        });
    }

    private void onClickGoToRoomDetail(RoomModel room) {
        Intent intent =new Intent(mContext,RoomDetailActivity.class);

        Bundle bundle = new Bundle();

        bundle.putSerializable("object_room",room);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if (mListRoom != null){
            return mListRoom.size();
        }
        return 0;
    }

    public class roomViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout layoutRoomItem ;
        private ImageView imgRoom ;
        private TextView tvLabelRoom ;
        private TextView tvPrice ;
        private TextView tvLocation;

        public roomViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutRoomItem =itemView.findViewById(R.id.layout_room_item);
            imgRoom =itemView.findViewById(R.id.img_room);
            tvLabelRoom =itemView.findViewById(R.id.tv_label_room);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvLocation =itemView.findViewById(R.id.tv_location);
        }
    }
}