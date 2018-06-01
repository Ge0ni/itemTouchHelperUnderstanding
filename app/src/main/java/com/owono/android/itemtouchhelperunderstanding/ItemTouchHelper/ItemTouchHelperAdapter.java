package com.owono.android.itemtouchhelperunderstanding.ItemTouchHelper;

/**
 * Created by owono on 28.05.2018.
 */

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

public interface ItemTouchHelperAdapter {

    boolean onItemMove(int fromPosition, int toPosition);

    void onItemDismiss(int position);
}
