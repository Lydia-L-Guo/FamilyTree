package com.example.cfamilycontact;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

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

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_regist);
		init();
	}

	private Toast mToast;
	private Button mRegistBtn;
	private EditText mPasswordEdit;
	private EditText mPasswrodsEdit;
	private EditText mUserEdit;
	private Button mBackBtn;

	protected String mPassWord;
	private String mName;

	private void init() {
		mRegistBtn = (Button) findViewById(R.id.regist_btn);
		mPasswordEdit = (EditText) findViewById(R.id.regist_password_edit);
		mPasswrodsEdit = (EditText) findViewById(R.id.regist_passwrodonece_edit);
		mUserEdit = (EditText) findViewById(R.id.regist_username_edit);
		mToast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
		mBackBtn = (Button) findViewById(R.id.regist_close_btn);

		ClCick();
	}

	private void ClCick() {

		mBackBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});

		mRegistBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				regist();

			}
		});

	}

	private void regist() {

		String name = mUserEdit.getText().toString();
		String password = mPasswordEdit.getText().toString();
		String passwords = mPasswrodsEdit.getText().toString();

		if (name != null && !name.equals("") && password != null
				&& passwords != null && !password.equals("")
				&& !passwords.equals("") && !name.equals("admin")) {
			if (password.length() > 5 && passwords.length() > 5) {
				if (password.equals(passwords)) {

					try {

						registNet(name, password);
					} catch (Exception e) {
						// TODO: handle exception
					}

				} else {
					showTip("");
				}

			} else {
				showTip("");
			}

		} else {
			showTip("");
		}
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

	public void registNet(final String name, final String password) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(Constant.url + "Regist");

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
								if (response.equals("true")) {
									showTip("");
									finish();
								} else {
									showTip("");
								}

							}
						});

					} else {
						showTip(" ");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

}
