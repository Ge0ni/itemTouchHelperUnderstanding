package com.owono.android.itemtouchhelperunderstanding;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.owono.android.itemtouchhelperunderstanding.ItemTouchHelper.ItemTouchHelperAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by owono on 28.05.2018.
 */

public class SomeRecyclerViewAdapter  extends RecyclerView.Adapter<SomeRecyclerViewAdapter.SomeViewHolder> implements ItemTouchHelperAdapter{

    private List<String> mStringList = new ArrayList<>();
    private Context mContext;

    public SomeRecyclerViewAdapter(Context context, List<String> stringList) {
        mContext = context;
        mStringList = stringList;
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mStringList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mStringList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {

    }

    public class SomeViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public SomeViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text_view);
        }
    }

    @Override
    public SomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_item, parent, false);
        return new SomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SomeViewHolder holder, int position) {
        final String currentString = mStringList.get(position);
        holder.textView.setText(currentString);
    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }
}
