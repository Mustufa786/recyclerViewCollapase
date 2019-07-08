package com.codixlab.collapsingrecyclerview.util.decorator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class LineItemDecorator extends RecyclerView.ItemDecoration {

    public static final int VERTICAL = LinearLayoutManager.VERTICAL;
    public static final  int[] ATTR = new int[]{
            android.R.attr.listDivider
    };
    private Drawable divider;

    public LineItemDecorator(Context context,int orientation){

        TypedArray a = context.obtainStyledAttributes(ATTR);
        divider = a.getDrawable(0);
        a.recycle();



    }
}
