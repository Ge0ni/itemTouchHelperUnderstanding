package com.owono.android.itemtouchhelperunderstanding;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.ListView;

import com.owono.android.itemtouchhelperunderstanding.ItemTouchHelper.SomeTouchHelperCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ItemTouchHelper mItemTouchHelper;

    RecyclerView recyclerView;

    SomeRecyclerViewAdapter someRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_View);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final List<String> stringList = new ArrayList<String>();
        stringList.add("first");
        stringList.add("second");
        stringList.add("third");
        stringList.add("fourth");
        stringList.add("fifth");

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
/*
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                return 2;
            }
        });
*/

        someRecyclerViewAdapter = new SomeRecyclerViewAdapter(this, stringList);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(someRecyclerViewAdapter);

        ItemTouchHelper.Callback callback = new SomeTouchHelperCallback(someRecyclerViewAdapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
