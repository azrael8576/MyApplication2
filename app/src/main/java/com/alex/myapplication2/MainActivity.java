package com.alex.myapplication2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<String> mData = new ArrayList<>();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 準備資料，塞50個項目到ArrayList裡
        for (int i = 0; i < 50; i++) {
            mData.add("項目"+i);
        }
        /* 初始Adapter
         *  第一個參數context
         *  第二個參數是列的外觀，這邊用android內建的
         *  第三個參數是要顯示的資料，即上面準備好的mData
         */
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mData);
        // 連結元件
        listView = findViewById(R.id.listview);
        // 設置adapter給listview
        listView.setAdapter(adapter);
        // 設置點擊事件
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 點擊某一列時要做的事寫在這兒

                // 顯示訊息
                Toast.makeText(MainActivity.this,
                        "您選了" + mData.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
