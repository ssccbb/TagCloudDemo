package com.sung.tagclouddemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.sung.tagclouddemo.adapter.RapidTagCloudAdapter;
import com.sung.tagclouddemo.model.RapidMatchModel;
import com.sung.tagclouddemo.widget.TagCloudView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TagCloudView mTagCloudView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTagCloudView = findViewById(R.id.tag_cloud_view);

        set();
    }

    private void set() {
        RapidTagCloudAdapter adapter = new RapidTagCloudAdapter(getMatchList());
        if (mTagCloudView != null) {
            mTagCloudView.setAdapter(adapter);
            adapter.setOnItemClickListener(new RapidTagCloudAdapter.OnItemClick() {
                @Override
                public void onItemClick(RapidMatchModel rapidMatchModel) {
                }
            });
        }
    }

    private List<RapidMatchModel> getMatchList() {
        List<RapidMatchModel> list = new ArrayList<>();
        String[] stauts = {"0", "1", "2", "3"};
        for (int i = 0; i < 50; i++) {
            String uid = String.valueOf(111 + i);
            String nickname = "user" + i;
            String fitness = "fit" + i;
            String type = stauts[(int) (Math.random() * (3 - 0 + 1))];
            RapidMatchModel model = new RapidMatchModel(uid, nickname, fitness, type);
            list.add(model);
        }
        return list;
    }
}
