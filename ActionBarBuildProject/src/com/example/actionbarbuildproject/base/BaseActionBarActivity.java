package com.example.actionbarbuildproject.base;

import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.actionbarbuildproject.R;

/**
 * ActionBar管理类
 * 
 * @author 顾林海
 * 
 */
public abstract class BaseActionBarActivity extends Activity {

	protected final int ACTION_LEFT = 0x01;// 左边标题点击
	protected final int ACTION_MIDDLE = 0x02;// 中间标题点击
	protected final int ACTION_RIGHT = 0x03;// 右边标题点击

	private final int COMMON_ACTION_BAR_RESOURCE = R.layout.common_action_bar;

	private View mCommonActionBar;

	private ActionBar mActionBar;
	
	private LinearLayout ll_common_back;

	private ImageView iv_common_back;

	private TextView tv_common_left_title;

	private TextView tv_common_middle_title;

	private TextView tv_common_right_title;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initActionBar();
		initEvent();
	}

	protected abstract void onClickActionBar(int type);

	/**
	 * 初始化ActionBar
	 */
	private void initActionBar() {
		mCommonActionBar = LayoutInflater.from(this).inflate(
				COMMON_ACTION_BAR_RESOURCE, null);
		mActionBar = getActionBar();
		if (mActionBar != null) {
			mActionBar.setDisplayShowCustomEnabled(true);
			mActionBar.setDisplayShowTitleEnabled(false);
			mActionBar.setDisplayShowHomeEnabled(false);
			mActionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
			mActionBar.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.common_bg));
			initView(mCommonActionBar);
			ActionBar.LayoutParams params = new ActionBar.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			mActionBar.setCustomView(mCommonActionBar, params);
		}
	}

	/**
	 * 事件注册
	 */
	private void initEvent() {
		/**
		 * 返回
		 */
		ll_common_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onBackPressed();
			}
		});

		/**
		 * 右边标题点击
		 */
		tv_common_right_title.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onClickActionBar(ACTION_RIGHT);
			}
		});

		/**
		 * 左边标题点击
		 */
		tv_common_left_title.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onClickActionBar(ACTION_LEFT);
			}
		});

		/**
		 * 中间标题点击
		 */
		tv_common_middle_title.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				onClickActionBar(ACTION_MIDDLE);
			}
		});
	}

	/**
	 * 注册控件
	 * 
	 * @param rootView
	 */
	private void initView(View rootView) {
		ll_common_back=(LinearLayout)rootView.findViewById(R.id.ll_common_back);
		iv_common_back = (ImageView) rootView.findViewById(R.id.iv_common_back);
		tv_common_left_title = (TextView) rootView
				.findViewById(R.id.tv_common_left_title);
		tv_common_middle_title = (TextView) rootView
				.findViewById(R.id.tv_common_middle_title);
		tv_common_right_title = (TextView) rootView
				.findViewById(R.id.tv_common_right_title);
	}

	/**
	 * 设置左边的标题
	 * 
	 * @param leftTitle
	 */
	protected void setLeftTitle(String leftTitle) {
		tv_common_left_title.setText(leftTitle);
	}

	/**
	 * 设置中间标题
	 * 
	 * @param middleTitle
	 */
	protected void setMiddleTitle(String middleTitle) {
		tv_common_middle_title.setText(middleTitle);
	}

	/**
	 * 设置右边标题
	 * 
	 * @param rightTitle
	 */
	protected void setRightTitle(String rightTitle) {
		tv_common_middle_title.setText(rightTitle);
	}

	/**
	 * 主页的Actionbar样式
	 */
	protected void setMainAction() {
		ll_common_back.setVisibility(View.GONE);
	}

	/**
	 * 子页面通用样式
	 */
	protected void setCommonAction() {
		iv_common_back.setVisibility(View.VISIBLE);
	}

}
