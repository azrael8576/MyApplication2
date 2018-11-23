package com.alex.myapplication2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> mData;
    MyAdapter(List<String> data){
        mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // 連結項目布局檔list_item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        // 設置txtItem要顯示的內容
        viewHolder.txtItem.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // 建立ViewHolder
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtItem = itemView.findViewById(R.id.txtItem);
        }
    }
}
