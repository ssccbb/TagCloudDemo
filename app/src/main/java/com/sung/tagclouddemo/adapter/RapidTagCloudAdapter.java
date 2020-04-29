package com.sung.tagclouddemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.sung.tagclouddemo.Constants;
import com.sung.tagclouddemo.model.RapidMatchModel;
import com.sung.tagclouddemo.widget.RapidTagView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sun on 31/01/2018.
 */

public class RapidTagCloudAdapter extends TagsAdapter {

    private List<RapidMatchModel> mList = new ArrayList<>();
    private OnItemClick mListener;

    public RapidTagCloudAdapter(List<RapidMatchModel> list) {
        if (list != null) {
            mList = list;
        }
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public View getView(final Context context, final int position, ViewGroup parent) {
        final RapidTagView rapidTagView = new RapidTagView(context);
        rapidTagView.setData(mList.get(position));
        rapidTagView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onItemClick(mList.get(position));
                }
                RapidMatchModel rapidMatchModel = mList.get(position);
                if (rapidMatchModel.type.equals(Constants.RAPID_STATE_MATCHING)) {
                    rapidMatchModel.type = Constants.RAPID_STATE_NORMAL;
                    rapidTagView.setData(rapidMatchModel);
                }
            }
        });
        return rapidTagView;
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public int getPopularity(int position) {
        return position % 7;
    }

    @Override
    public void onThemeColorChanged(View view, int themeColor) {
        // TODO: 31/01/2018 改变主题颜色
    }

    public interface OnItemClick {
        void onItemClick(RapidMatchModel rapidMatchModel);
    }

    public void setOnItemClickListener(OnItemClick onItemClickListener) {
        mListener = onItemClickListener;
    }
}
