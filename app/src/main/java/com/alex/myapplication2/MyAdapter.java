package com.alex.myapplication2;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    // 1. 建立interface，命名為OnItemClickHandler，並在裡面寫好我們要發生的事件
    interface OnItemClickHandler{
        // 提供onItemClick方法作為點擊事件，括號內為接受的參數
        void onItemClick (String text);
        // 提供onItemRemove做為移除項目的事件
        void onItemRemove(int position,String text);
    }
    private List<String> mData;
    // 2. 宣告interface
    private OnItemClickHandler mClickHandler;
    // 3. 修改Constructor
    MyAdapter(List<String> data,OnItemClickHandler clickHandler){
        mData = data;
        mClickHandler = clickHandler;
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
        // 宣告元件
        private TextView txtItem;
        private Button btnRemove;
        public ViewHolder(final View itemView) {
            super(itemView);
            txtItem = itemView.findViewById(R.id.txtItem);
            btnRemove = itemView.findViewById(R.id.btnRemove);

            // 點擊項目時
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String msg = mData.get(getAdapterPosition());
                    // 4. 呼叫interface的method
                    mClickHandler.onItemClick(msg);
                }
            });
            // 點擊項目中的Button時
            btnRemove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 移除項目，getAdapterPosition為點擊的項目位置
                    int position = getAdapterPosition();
                    String text = mData.get(position);
                    // 4. 呼叫interface的method
                    mClickHandler.onItemRemove(position, text);
                }
            });
        }
    }
    //新增項目
    public void addItem(String text){
        // 為了示範效果，固定新增在位置3。若要新增在最前面就把3改成0
        mData.add(3,text);
        notifyItemInserted(3);
    }
    // 刪除項目
    public void removeItem(int position){
        mData.remove(position);
        notifyItemRemoved(position);
    }
}
