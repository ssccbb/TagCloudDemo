package com.sung.tagclouddemo.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/**
 * Created by Sun on 15/12/2017.
 */

public abstract class BaseAssembleLinearLayout extends LinearLayout {

    private Context mContext;
    private LayoutInflater mInflater;

    public BaseAssembleLinearLayout(Context context) {
        this(context, null);
    }

    public BaseAssembleLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseAssembleLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        inflateView(context, attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public BaseAssembleLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        inflateView(context, attrs);
    }

    private void inflateView(Context context, AttributeSet attributeSet) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        try {
            if (getLayoutId() != -1) {
                mInflater.inflate(getLayoutId(), this, true);
                init(attributeSet);
            }
        } catch (OutOfMemoryError error) {
            error.printStackTrace();
        }
    }

    protected abstract int getLayoutId();

    protected abstract void init(AttributeSet attributeSet);
}
