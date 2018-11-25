package com.alex.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recycler_view;
    private ArrayList<String> mData = new ArrayList<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 準備資料，塞50個項目到ArrayList裡
        for (int i = 0; i < 50; i++) {
            mData.add("項目"+i);
        }
        // 連結元件
        recycler_view = findViewById(R.id.recycler_view);
        // 設置RecyclerView為列表型態
        // Linear型態，第二個參數控制垂直或水平，第三個參數為是否reverse順序
        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        // Grid型態，第二個參數控制一列顯示幾項
//        recycler_view.setLayoutManager(new GridLayoutManager(this, 2));
        // 設置格線
        // 第二個參數VERTICAL或HORIZONTAL控制垂直或水平
        recycler_view.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        // 將資料交給adapter
        adapter = new MyAdapter(mData);
        // 設置adapter給recycler_view
        recycler_view.setAdapter(adapter);

        Button btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 新增一個項目
                adapter.addItem("New Item");
            }
        });
    }
}
