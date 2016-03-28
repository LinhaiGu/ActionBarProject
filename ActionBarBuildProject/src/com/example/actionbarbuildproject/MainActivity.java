package com.example.actionbarbuildproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.example.actionbarbuildproject.base.BaseActionBarActivity;

public class MainActivity extends BaseActionBarActivity {

	private Button btn_start;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setMainAction();
		setMiddleTitle("主页");
		initViews();
		initEvent();
	}

	private void initViews() {
		btn_start = (Button) findViewById(R.id.btn_start);
	}

	private void initEvent() {
		btn_start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,
						SecondActivity.class));
			}
		});
	}

	@Override
	protected void onClickActionBar(int type) {
		if (type == ACTION_MIDDLE) {
			Toast.makeText(this, "点击了中间标题", Toast.LENGTH_SHORT).show();
		}
	}

}
