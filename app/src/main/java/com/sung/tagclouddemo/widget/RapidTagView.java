package com.sung.tagclouddemo.widget;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.sung.tagclouddemo.R;
import com.sung.tagclouddemo.model.RapidMatchModel;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import static com.sung.tagclouddemo.Constants.RAPID_STATE_MATCHING;
import static com.sung.tagclouddemo.Constants.RAPID_STATE_MATCH_MOST;
import static com.sung.tagclouddemo.Constants.RAPID_STATE_NEW;
import static com.sung.tagclouddemo.Constants.RAPID_STATE_NORMAL;

/**
 * Created by sun on 31/01/2018.
 */

public class RapidTagView extends BaseAssembleLinearLayout {

    private TextView mTVName;
    private ImageView mIVState;
    private TextView mTVNum;
    private ObjectAnimator mShineAnim;

    public RapidTagView(Context context) {
        super(context);
    }

    public RapidTagView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RapidTagView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RapidTagView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.layout_rapid_match_tag;
    }

    @Override
    protected void init(AttributeSet attributeSet) {
        mTVName = findViewById(R.id.tv_name);
        mIVState = findViewById(R.id.iv_state);
        mTVNum = findViewById(R.id.tv_match_num);
    }

    public void setData(RapidMatchModel rapidMatchModel) {
        if (rapidMatchModel != null) {
            setName(rapidMatchModel.nickname);
            setMatchNum(rapidMatchModel.fitness);
            setIVState(rapidMatchModel.type);
        }
    }

    public void setName(String name) {
        if (mTVName != null) {
            mTVName.setText(name);
        }
    }

    public void setMatchNum(String num) {
        if (mTVNum != null) {
            mTVNum.setText(num);
        }
    }

    public void setIVState(String state) {
        int resId = R.drawable.bg_rapid_match_normal;
        endAnim();
        switch (state) {
            case RAPID_STATE_NORMAL:
                resId = R.drawable.bg_rapid_match_normal;
                break;

            case RAPID_STATE_MATCHING:
                resId = R.drawable.bg_rapid_match_matching;
                startMatchingAnim();
                break;

            case RAPID_STATE_MATCH_MOST:
                resId = R.drawable.bg_rapid_match_most;
                break;
            case RAPID_STATE_NEW:
                resId = R.drawable.bg_rapid_match_new;
                break;
        }

        if (mIVState != null) {
            mIVState.setImageResource(resId);
        }
    }

    private void startMatchingAnim() {
        if (mIVState != null) {
            mShineAnim = ObjectAnimator.ofFloat(mIVState,"alpha", 0, 1);
            mShineAnim.setInterpolator(new AccelerateInterpolator());
            mShineAnim.setDuration(800);
            mShineAnim.setRepeatCount(-1);
            mShineAnim.setRepeatMode(ValueAnimator.REVERSE);
            mShineAnim.start();
        }
    }

    private void endAnim() {
        if (mShineAnim != null && mShineAnim.isRunning()) {
            mShineAnim.cancel();
        }

        if(mIVState!=null) {
            mIVState.setAlpha((float) 1);
        }
    }
}
