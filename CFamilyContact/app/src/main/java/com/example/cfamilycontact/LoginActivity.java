package com.example.cfamilycontact;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.example.data.Constant;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_login);
		init();
		getPermission();
	}

	private Toast mToast;
	private Button mLoginBtn;
	private EditText mUserEdit;
	private Button mRegistBtn;
	private EditText mPasswordEdit;
	private boolean isLogined = false;
	protected String mPassWord;
	private String mName;

	private void init() {

		mLoginBtn = (Button) findViewById(R.id.login_sure);
		mRegistBtn = (Button) findViewById(R.id.login_regist_btn);

		mUserEdit = (EditText) findViewById(R.id.login_name_edit);
		mPasswordEdit = (EditText) findViewById(R.id.login_password_edit);

		mToast = Toast.makeText(getApplication(), "", Toast.LENGTH_SHORT);

		Click();
	}

	private void Click() {

		mRegistBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				startActivity(new Intent(LoginActivity.this,
						RegistActivity.class));

			}
		});

		mLoginBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				login();

			}
		});

	}

	private void login() {
		String name = mUserEdit.getText().toString();
		String password = mPasswordEdit.getText().toString();
		if (name != null && password != null && name.length() > 0
				&& password.length() > 0) {

			loginHttpClient(name, password);

		} else {
			showTip("请填写数据");
		}
		
//		Intent in = new Intent(LoginActivity.this,
//				HomeActivity.class);
//
//		in.putExtra("name", mName);
//		in.putExtra("password", password);
//		in.putExtra("info", "");
//		startActivity(in);  
		
	}

	private void showTip(final String s) {
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mToast.setText(s + "");
				mToast.show();
			}
		});

	}

	public void loginHttpClient(final String name, final String password) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(Constant.url + "Login");

					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("username", name));
					params.add(new BasicNameValuePair("password", password));
					final UrlEncodedFormEntity entity = new UrlEncodedFormEntity(
							params, "utf-8");
					httpPost.setEntity(entity);
					HttpResponse httpResponse = httpclient.execute(httpPost);
					if (httpResponse.getStatusLine().getStatusCode() == 200) {
						HttpEntity entity1 = httpResponse.getEntity();
						final String response = EntityUtils.toString(entity1,
								"utf-8");
						runOnUiThread(new Runnable() {
							public void run() {
								if (!response.equals("false")) {
									isLogined = true;

									mName = name;
									mPassWord = password;

									Intent in = null;

									if (response != null&& !response.equals("")) {
										in = new Intent(LoginActivity.this,HomeActivity.class);
										in.putExtra("user", mName);
										in.putExtra("password", password);
										in.putExtra("info", response);
										startActivity(in);
									}

									if (isLogined) {
										finish();
									}

								} else {
									showTip("失败");
								}

							}
						});

					} else {
						showTip("");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	protected void getPermission() {

		if (Build.VERSION.SDK_INT >= 23) {

			List<String> permissionList = new ArrayList<String>();
			if (ContextCompat.checkSelfPermission(this,
					Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
				permissionList.add(Manifest.permission.READ_EXTERNAL_STORAGE);
			}
			if (ContextCompat.checkSelfPermission(this,
					Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
				permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
			}

			if (ContextCompat.checkSelfPermission(this,
					Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
				permissionList.add(Manifest.permission.INTERNET);
			}

			if (ContextCompat.checkSelfPermission(this,
					Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
				permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
			}
			if (ContextCompat.checkSelfPermission(this,
					Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
				permissionList.add(Manifest.permission.ACCESS_COARSE_LOCATION);
			}
			if (!permissionList.isEmpty()) {
				String[] permissions = permissionList
						.toArray(new String[permissionList.size()]);
				ActivityCompat.requestPermissions(this, permissions, 1);
			}
		}
	}

}
