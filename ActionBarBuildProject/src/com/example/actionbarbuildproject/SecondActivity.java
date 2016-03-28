package com.example.actionbarbuildproject;

import android.os.Bundle;
import android.widget.Toast;

import com.example.actionbarbuildproject.base.BaseActionBarActivity;

public class SecondActivity extends BaseActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second_activity_layout);
		setCommonAction();
		setLeftTitle("子页面");
	}

	@Override
	protected void onClickActionBar(int type) {
		if (type == ACTION_LEFT) {
			Toast.makeText(this, "左边标题", Toast.LENGTH_SHORT).show();
		}
	}

}
