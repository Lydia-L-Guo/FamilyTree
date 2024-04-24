package com.example.cfamilycontact;

import java.util.ArrayList;
import java.util.Calendar;
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
import org.json.JSONArray;
import org.json.JSONObject;
 
import com.example.adapter.BookAdapter;
import com.example.adapter.FamilyAdapter;
import com.example.adapter.TitleAdapter;
 
import com.example.data.BookData;
import com.example.data.Constant;
import com.example.data.FamilyData;
import com.example.data.FamilyGrounp;
 

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			Window window = getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
					| WindowManager.LayoutParams.FLAG_FULLSCREEN);
		} else {
			Window window = getWindow();
			window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

		}
		setContentView(R.layout.activity_home);
		init();
		controlTop();
		intToast();
		
		if (mMyID!=null&&!mMyID.equals("-1")&&!mMyID.equals("null")) {
 			getMyInfo();
 			Log.e("我的id",mMyID+"--");
 		  }
		View mPopView = LayoutInflater.from(this).inflate(
				R.layout.add_family, null);
		mAddView=mPopView.findViewById(R.id.add_info);
		
		View mPopViewa = LayoutInflater.from(this).inflate(
				R.layout.update_password, null);
		mUpdateNew = (EditText) mPopViewa.findViewById(R.id.update_new);
		mUpdateOld = (EditText) mPopViewa.findViewById(R.id.update_old);
 new Handler().postDelayed(new Runnable() {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		getClicp();
	}
}, 600);
		
		 
	}

    private String mMyID;//我的id
    private String mGid;//家谱ID
	private String mUser;
	private LinearLayout mAlayout, mBlayout, mClayout;
	private ImageView mFreshC;
	private ImageView mAddImg;
	private TextView mRunInfotv;
	private GridView mHomeAGridView;
	private GridView mHomeBateGridview;
	private ListView mHomeListview;
 
	private LinearLayout mTopShow;
	private ImageView mBotA, mBotB, mBotC;
	private String mInfo;
	private TextView mEditText;
    private TextView mChoiA,mChoiB,mChoiC,mChoiD;

	private TextView mNameTv;
	private TextView mInfotv, mLoginTv, mUpTv;
	private String mPassWord;
 
	private EditText mSearchEdit;
	
	private int mCate=Constant.CHOI_A;
	private void init() {

	 
		mUser = getIntent().getStringExtra("user");
		mPassWord = getIntent().getStringExtra("password");
		mMyID = getIntent().getStringExtra("info");//获得我的id
 
	 

		mHomeListview=findViewById(R.id.home_alistview);
		mHomeAGridView = (GridView) findViewById(R.id.home_agridview);
		mHomeBateGridview = (GridView) findViewById(R.id.home_bgridview);
		mAddImg=findViewById(R.id.a_addimg);
		mChoiA=(TextView)findViewById(R.id.c_choi_a);
		mChoiB=(TextView)findViewById(R.id.c_choi_b);
		mChoiC=(TextView)findViewById(R.id.c_choi_c);
		mChoiD=(TextView)findViewById(R.id.c_choi_d);
		
		

		mTopShow = (LinearLayout) findViewById(R.id.top_show);
		mAlayout = (LinearLayout) findViewById(R.id.h_alayout);
		mBlayout = (LinearLayout) findViewById(R.id.h_blayout);
		mClayout = (LinearLayout) findViewById(R.id.h_clayout);

	 
		mFreshC = (ImageView) findViewById(R.id.home_bfresh);
	 
		mBotA = (ImageView) findViewById(R.id.bot_abtn);
		mBotC = (ImageView) findViewById(R.id.bot_cbtn);
		mBotB = (ImageView) findViewById(R.id.bot_bbtn);

		mNameTv = (TextView) findViewById(R.id.set_usertv);
		mUpTv = (TextView) findViewById(R.id.set_sightv);
		mInfotv = (TextView) findViewById(R.id.set_infotv);
		mLoginTv = (TextView) findViewById(R.id.set_logintv);
		mSearchEdit=findViewById(R.id.search_edit);
		
		View mPopView = LayoutInflater.from(this).inflate(
				R.layout.edit_people, null);
		mEditxing=mPopView.findViewById(R.id.edit_xing);
		mEditName=mPopView.findViewById(R.id.edit_name);
		mEditEverName=mPopView.findViewById(R.id.add_checka);
		mEditSex=mPopView.findViewById(R.id.add_checkb);
		mEditPaihang=mPopView.findViewById(R.id.add_checkc);
		mEditBirthDate=mPopView.findViewById(R.id.add_checkd);
		mEditBirthAdrress=mPopView.findViewById(R.id.add_checke);
		mEditZihao=mPopView.findViewById(R.id.add_checkf);
		mEditBeiHao=mPopView.findViewById(R.id.add_checkg);
		mEditMark=mPopView.findViewById(R.id.add_checkh);
		mEditDeadDay=mPopView.findViewById(R.id.add_checkage);
		
		mEditDeadDate=mPopView.findViewById(R.id.add_checkdates);
		mEditDeadAddress=mPopView.findViewById(R.id.add_checkaddress);
		mEditInfo=mPopView.findViewById(R.id.edit_contenta);
		mEditMuTxt=mPopView.findViewById(R.id.edit_contentb);
		
		mSwitch=mPopView.findViewById(R.id.switchview);
		mOtherLayout=mPopView.findViewById(R.id.other_layout);
		
		
		View mPopViewa = LayoutInflater.from(this).inflate(
				R.layout.add_people, null);
		mAddEditName=mPopViewa.findViewById(R.id.add_peo_name);
		mAddEditSext=mPopViewa.findViewById(R.id.add_peo_sex);
		 mHeadImg=mPopViewa.findViewById(R.id.add_self_img);
		 mCoupImg=mPopViewa.findViewById(R.id.add_coup_img);
		 mCoupTv=mPopViewa.findViewById(R.id.add_peo_wif);
		if (mUser != null) {
			mNameTv.setText(mUser+"   "  );
		   }
		  
		initContent();
		click();

	}
	
	 private void initContent() {
		// TODO Auto-generated method stub
		 View mPopView = LayoutInflater.from(this).inflate(
					R.layout.content_people, null);
		    mContentImg=mPopView.findViewById(R.id.add_camear_img);
			mEditConxing=mPopView.findViewById(R.id.edit_xing);
			mEditConName=mPopView.findViewById(R.id.edit_name);
			mEditConEverName=mPopView.findViewById(R.id.add_checka);
			mEditConSex=mPopView.findViewById(R.id.add_checkb);
			mEditConPaihang=mPopView.findViewById(R.id.add_checkc);
			mEditConBirthDate=mPopView.findViewById(R.id.add_checkd);
			mEditConBirthAdrress=mPopView.findViewById(R.id.add_checke);
			mEditConZihao=mPopView.findViewById(R.id.add_checkf);
			mEditConBeiHao=mPopView.findViewById(R.id.add_checkg);
			mEditConMark=mPopView.findViewById(R.id.add_checkh);
			mEditConDeadDay=mPopView.findViewById(R.id.add_checkage);
			
			mEditConDeadDate=mPopView.findViewById(R.id.add_checkdates);
			mEditConDeadAddress=mPopView.findViewById(R.id.add_checkaddress);
			mEditConInfo=mPopView.findViewById(R.id.edit_contenta);
			mEditConMuTxt=mPopView.findViewById(R.id.edit_contentb);
			
			mConSwitch=mPopView.findViewById(R.id.switchview);
			mConOtherLayout=mPopView.findViewById(R.id.other_layout);
	}
    private FamilyAdapter mAdapter;
	private void click() {
		mHomeBateGridview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// 查看族谱
				
				contentPeople(mBookList.get(position).getFamily(), mBookList.get(position).getFamily().getGender());
				
			}
		});
		
		mSearchEdit.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
				
				  String str=s.toString();
				  
				 if (str!=null) {
					 mBookList.clear();
					 for (int i = 0; i < mBookBackList.size(); i++) {
						 if (mBookBackList.get(i).getFamily().getSurname().contains("str")
								 ||mBookBackList.get(i).getFamily().getGenealogy_name().contains(str)
								 
								 ) {
							  mBookList.add(mBookBackList.get(i));
							 
						}
						 
					}
				}else {
					 mBookList.clear();
					 for (int i = 0; i < mBookBackList.size(); i++) {
 					     mBookList.add(mBookBackList.get(i));
  					}
				}
				 
				 mHomeBateGridview.setAdapter(new BookAdapter(getApplicationContext(), mBookList, mHandler));
			}
		});
		
		
		mAddImg.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// 添加
				//addPeople();
				
 			}
		});
 		mChoiA.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 mChoiA.setBackgroundResource(R.drawable.mark_left_choi);
				 mChoiB.setBackgroundResource(R.drawable.mark_middle);
				 mChoiC.setBackgroundResource(R.drawable.mark_middle);
				 mChoiD.setBackgroundResource(R.drawable.mark_right);
				 mCate=Constant.CHOI_A;
				 if (mMyID!=null&&!mMyID.equals("-1")&&!mMyID.equals("null")) {
			 			getMyInfo();
			 			Log.e("我的id",mMyID+"--");
			 		  }
			}
		});
	mChoiB.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 mChoiA.setBackgroundResource(R.drawable.mark_left);
				 mChoiB.setBackgroundResource(R.drawable.mark_middlechoi);
				 mChoiC.setBackgroundResource(R.drawable.mark_middle);
				 mChoiD.setBackgroundResource(R.drawable.mark_right);
				 mCate=Constant.CHOI_B;
				 if (mMyID!=null&&!mMyID.equals("-1")&&!mMyID.equals("null")) {
			 			getMyInfo();
			 			Log.e("我的id",mMyID+"--");
			 		  }
			}
		});
	mChoiC.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 mChoiA.setBackgroundResource(R.drawable.mark_left);
			 mChoiB.setBackgroundResource(R.drawable.mark_middle);
			 mChoiC.setBackgroundResource(R.drawable.mark_middlechoi);
			 mChoiD.setBackgroundResource(R.drawable.mark_right);
			 
			 mCate=Constant.CHOI_C;
			 if (mMyID!=null&&!mMyID.equals("-1")&&!mMyID.equals("null")) {
		 			getMyInfo();
		 			Log.e("我的id",mMyID+"--");
		 		  }
			 
		      }
	     });
	mChoiD.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			 mChoiA.setBackgroundResource(R.drawable.mark_left);
			 mChoiB.setBackgroundResource(R.drawable.mark_middle);
			 mChoiC.setBackgroundResource(R.drawable.mark_middle);
			 mChoiD.setBackgroundResource(R.drawable.mark_right_choi);
			 mCate=Constant.CHOI_D;
			 if (mMyID!=null&&!mMyID.equals("-1")&&!mMyID.equals("null")) {
		 			getMyInfo();
		 			Log.e("我的id",mMyID+"--");
		 	  }
		}
	});
		
		
		mHomeAGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
             
 			  }
		});

		mHomeAGridView
				.setOnItemLongClickListener(new OnItemLongClickListener() {

					@Override
					public boolean onItemLongClick(AdapterView<?> parent,
							View view, int position, long id) {

						return true;
					}
				});

	 

		mFreshC.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				controlTop();

			}
		});

		mBotA.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				mAlayout.setVisibility(View.VISIBLE);
				mBlayout.setVisibility(View.GONE);
				mClayout.setVisibility(View.GONE);
				mBotA.setBackgroundResource(R.drawable.icon_enable_choi);
				mBotB.setBackgroundResource(R.drawable.icon_relation);
				mBotC.setBackgroundResource(R.drawable.app_assets_tab_iconme);
				controlTop();

			}
		});
		mBotB.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				mAlayout.setVisibility(View.GONE);
				mBlayout.setVisibility(View.VISIBLE);
				mClayout.setVisibility(View.GONE);
				mBotA.setBackgroundResource(R.drawable.icon_enable);
				mBotB.setBackgroundResource(R.drawable.icon_relation_choi);
				mBotC.setBackgroundResource(R.drawable.app_assets_tab_iconme);
				controlTop();
			 

			}
		});
		mBotC.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				mClayout.setVisibility(View.VISIBLE);
				mBlayout.setVisibility(View.GONE);
				mAlayout.setVisibility(View.GONE);
				mBotA.setBackgroundResource(R.drawable.icon_enable);
				mBotB.setBackgroundResource(R.drawable.icon_relation);
				mBotC.setBackgroundResource(R.drawable.app_assets_tab_iconme_choi);
				controlTop();

			}
		});

		mInfotv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(HomeActivity.this, AboutActivity.class));
			}
		});

		mLoginTv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				Intent in = new Intent(HomeActivity.this, LoginActivity.class);
				startActivity(in);
				finish();
			}
		});
		mUpTv.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			    update();
			}
		   });
 	      mAdapter=new FamilyAdapter(getApplicationContext(), mSortAllList, mHandler,mMyID);
		  mHomeAGridView.setAdapter(mAdapter);

		  mHomeAGridView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				//  编辑
				       if (!mSortAllList.get(position).isNull()) {
				    	   addPeople(position ) ;
					      }
				 
				    
				   // ShowToast(""+mSortAllList.get(position).getSurname()+ position);
				
			}
		});
		  
		  
	}
	
	private Handler mHandler=new Handler(){
		 public void handleMessage(android.os.Message msg) {
			 
			 
		 };
		
	};
	private void controlTop() {
		// 顶部显示
		runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				mTopShow.setVisibility(View.VISIBLE);
				new Handler().postDelayed(new Runnable() {

					@Override
					public void run() {
						// TODO Auto-generated method stub
						mTopShow.setVisibility(View.INVISIBLE);
					}
				}, 1500);
			}
		});

	}
	
	 private void delPerson(final String id) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						HttpClient httpclient = new DefaultHttpClient();
						HttpPost httpPost = new HttpPost(Constant.url + "delPerson");
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("id", id));

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
										 if (mMyGid>-1) {
							 					getMyFamily(mMyGid+"");
											  } 
									}  
								}
							});

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	
	 private TextView mAddEditName,mAddEditSext;
	 private TextView mHeadImg,mCoupImg,mCoupTv;
	 
	private void addPeople( final int pos) {
		View mPopView = LayoutInflater.from(this).inflate(
				R.layout.add_people, null);
		final PopupWindow mPopWindow = new PopupWindow(mPopView,
				getWindowManager().getDefaultDisplay().getWidth(),
				getWindowManager().getDefaultDisplay().getHeight(), true);
		mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

		mPopView.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		int popupWidth = mPopView.getMeasuredWidth();
		int popupHeight = mPopView.getMeasuredHeight();

		mPopWindow.showAtLocation(mBotA, Gravity.CENTER, 0, 0);
		mPopWindow.setAnimationStyle(R.style.MyStyle);
		mPopWindow.update();
 
		mAddEditName=mPopView.findViewById(R.id.add_peo_name);
		mAddEditSext=mPopView.findViewById(R.id.add_peo_sex);
		
		 mHeadImg=mPopView.findViewById(R.id.add_self_img);
		 mCoupImg=mPopView.findViewById(R.id.add_coup_img);
		 mCoupTv=mPopView.findViewById(R.id.add_peo_wif);
		 
		if (pos>-1) {
			mAddEditName.setText(getStr(mSortAllList.get(pos).getSurname()+mSortAllList.get(pos).getGenealogy_name()));
			mAddEditSext.setText(getStr(mSortAllList.get(pos).getGender()));
			if (getStr(mSortAllList.get(pos).getGender()).equals("男")) {
				
				 
//				mCoupImg.setBackgroundResource(R.drawable.ic_girl_portrait_unchecked);
//				mCoupTv.setText("添加丈夫");
				 
			}if (getStr(mSortAllList.get(pos).getGender()).equals("女")) {
				
				mHeadImg.setBackgroundResource(R.drawable.ic_girl_portrait_unchecked);
				mCoupImg.setBackgroundResource(R.drawable.ic_boy_portrait_unchecked);
				mCoupTv.setText("添加丈夫");
			}
			
		}
		
	   mPopView.findViewById(R.id.add_peo_father).setOnClickListener(
				  new OnClickListener() {
				
				@Override
				public void onClick(View v) {
			    // TODO Auto-generated method stub
				 
				 editPeople(-1, Constant.CATE_FATHER,mSortAllList.get(pos).getGeneration(),mSortAllList.get(pos).getId(),mSortAllList.get(pos).getGender());
					
				 mPopWindow.dismiss();
				}
			});
		  
		  mPopView.findViewById(R.id.add_peo_mather).setOnClickListener(
				  new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 
					 editPeople(-1, Constant.CATE_MOTHER,mSortAllList.get(pos).getGeneration(),mSortAllList.get(pos).getId(),mSortAllList.get(pos).getGender());
					 mPopWindow.dismiss();
					
				}
			});

		  
		  mPopView.findViewById(R.id.add_peo_wif).setOnClickListener(
				  new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 
					 editPeople(-1, Constant.CATE_WIFE,mSortAllList.get(pos).getGeneration(),mSortAllList.get(pos).getId(),mSortAllList.get(pos).getGender());
					 mPopWindow.dismiss();
					
				}
			});
		  mPopView.findViewById(R.id.add_peo_bro).setOnClickListener(
				  new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 
					
					 editPeople(-1, Constant.CATE_BROTER,mSortAllList.get(pos).getGeneration(),mSortAllList.get(pos).getId(),mSortAllList.get(pos).getGender());
					 mPopWindow.dismiss();
				}
			});
		  
		  mPopView.findViewById(R.id.add_peo_sis).setOnClickListener(
				  new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 
					 editPeople(-1, Constant.CATE_SISTER,mSortAllList.get(pos).getGeneration(),mSortAllList.get(pos).getId(),mSortAllList.get(pos).getGender());
					
					 mPopWindow.dismiss();
				}
			});
		
		  
		  mPopView.findViewById(R.id.add_peo_son).setOnClickListener(
				  new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 
					 editPeople(-1, Constant.CATE_SON,mSortAllList.get(pos).getGeneration(),mSortAllList.get(pos).getId(),mSortAllList.get(pos).getGender());
					 mPopWindow.dismiss();
					
				}
			});
		
		  
		  mPopView.findViewById(R.id.add_peo_dau).setOnClickListener(
				  new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 
					 editPeople(-1, Constant.CATE_DAU,mSortAllList.get(pos).getGeneration(),mSortAllList.get(pos).getId(),mSortAllList.get(pos).getGender());
					
					 mPopWindow.dismiss();
				}
			});
 
		  
		  
		  mPopView.findViewById(R.id.add_peo_editbtn).setOnClickListener(
				  new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 editPeople(pos, Constant.CATE_SELF,mSortAllList.get(pos).getGeneration(),mSortAllList.get(pos).getId(),mSortAllList.get(pos).getGender());
					 mPopWindow.dismiss();
				}
			});
		  mPopView.findViewById(R.id.add_peo_delbtn).setOnClickListener(
				  new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					 
					
					delPerson(mSortAllList.get(pos).getId()+"");
					mPopWindow.dismiss();
					
				}
			});
		  
		  mPopView.findViewById(R.id.add_peo_yaoqingbtn).setOnClickListener(
				  new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
 					   String str=Constant.ADD+"#"+mGid+"#"+mSortAllList.get(pos).getId()+"#"+mMyFamilyData.getSurname()+"氏家族";
  					   yaoqing(str);
 					  mPopWindow.dismiss();
				}
			});
      

	}
	 private void yaoqing(String str) {
		// 邀请
		 Intent intent = new Intent();
		 
		 intent.setAction(Intent.ACTION_SEND);
		 
		  intent.putExtra(Intent.EXTRA_TEXT,str);
		 
		 intent.setType("text/plain"); 
		 
		 startActivity(Intent.createChooser(intent,getResources().getText(R.string.app_name)));
	}
	
	  public   String getClicp(){
		  ClipboardManager cm = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
		  try {
			
		
		   ClipData data = cm.getPrimaryClip();
		   if (data!=null) {
			
		
		   for (int i = 0; i < data.getItemCount(); i++) {
			   Item item = data.getItemAt(i); 
			   String str=item.getText().toString()+"";
			   Log.e("截切版", str+"---");
			   if (str.contains(Constant.ADD)) {
				String [] ins=str.split("#");
				if (ins.length>3) {
					String gid=ins[1];
					String id=ins[2];
					addFamiy(gid, id, "是否加入"+ins[3]+"");
					
					
				}
				
			   }   
			}
					   
			   
		}
		  } catch (Exception e) {
				// TODO: handle exception
			}
		  
	        return "";
	    }
	  
	   private TextView mAddView;
	  
	  private void addFamiy(final String gid,final String id, final String info) {
			View mPopView = LayoutInflater.from(this).inflate(
					R.layout.add_family, null);
			final PopupWindow mPopWindow = new PopupWindow(mPopView,
					getWindowManager().getDefaultDisplay().getWidth(),
					getWindowManager().getDefaultDisplay().getHeight(), true);
			mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

			mPopView.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
			int popupWidth = mPopView.getMeasuredWidth();
			int popupHeight = mPopView.getMeasuredHeight();

			mPopWindow.showAtLocation(mBotA, Gravity.CENTER, 0, 0);
			mPopWindow.setAnimationStyle(R.style.MyStyle);
			mPopWindow.update();
			 
			mAddView=mPopView.findViewById(R.id.add_info);
			
			if (info!=null) {
				mAddView.setText(""+info);
				
			}
			mPopView.findViewById(R.id.add_sure).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					adToFamily(id);
					mPopWindow.dismiss();
				}
			});
			
           mPopView.findViewById(R.id.add_cancel).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					 
					
					mPopWindow.dismiss();
					
				}
			});
			
	  	  
            }
 
	  private void adToFamily(final String inid) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						HttpClient httpclient = new DefaultHttpClient();
						HttpPost httpPost = new HttpPost(Constant.url + "addFamily");
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("id", inid));
						params.add(new BasicNameValuePair("user", mUser));
						
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
										 
										 mMyID=inid;
										 if (mMyID!=null&&!mMyID.equals("-1")&&!mMyID.equals("null")) {
									 			getMyInfo();
									 			Log.e("我的id",mMyID+"--");
									 	    }
									}  
								}
							});

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}

	  
	  
	  
	  
	  
	  
	private EditText mEditxing,mEditName,mEditEverName,mEditSex,mEditPaihang,mEditBirthDate,mEditBirthAdrress,mEditZihao,mEditBeiHao,mEditMark,
	mEditDeadDay,mEditDeadDate,mEditDeadAddress,mEditInfo,mEditMuTxt;
	private View mSwitch;
	private LinearLayout mOtherLayout;
	
	
	private String mBirthdDay;
	private String mDeadDay;
	private String mLive;
	private void editPeople(final int pos,final int cate,final int gerne,final int id,final String gender) {
		View mPopView = LayoutInflater.from(this).inflate(
				R.layout.edit_people, null);
		final PopupWindow mPopWindow = new PopupWindow(mPopView,
				getWindowManager().getDefaultDisplay().getWidth(),
				getWindowManager().getDefaultDisplay().getHeight(), true);
		mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

		mPopView.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		int popupWidth = mPopView.getMeasuredWidth();
		int popupHeight = mPopView.getMeasuredHeight();

		mPopWindow.showAtLocation(mBotA, Gravity.CENTER, 0, 0);
		mPopWindow.setAnimationStyle(R.style.MyStyle);
		mPopWindow.update();
  
		
		mEditxing=mPopView.findViewById(R.id.edit_xing);
		mEditName=mPopView.findViewById(R.id.edit_name);
		mEditEverName=mPopView.findViewById(R.id.add_checka);
		mEditSex=mPopView.findViewById(R.id.add_checkb);
		mEditPaihang=mPopView.findViewById(R.id.add_checkc);
		mEditBirthDate=mPopView.findViewById(R.id.add_checkd);
		mEditBirthAdrress=mPopView.findViewById(R.id.add_checke);
		mEditZihao=mPopView.findViewById(R.id.add_checkf);
		mEditBeiHao=mPopView.findViewById(R.id.add_checkg);
		mEditMark=mPopView.findViewById(R.id.add_checkh);
		mEditDeadDay=mPopView.findViewById(R.id.add_checkage);
		
		mEditDeadDate=mPopView.findViewById(R.id.add_checkdates);
		mEditDeadAddress=mPopView.findViewById(R.id.add_checkaddress);
		mEditInfo=mPopView.findViewById(R.id.edit_contenta);
		mEditMuTxt=mPopView.findViewById(R.id.edit_contentb);
		
		mSwitch=mPopView.findViewById(R.id.switchview);
		mOtherLayout=mPopView.findViewById(R.id.other_layout);
		mLive=Constant.ALIVE_YES;
		mBirthdDay="";
		mDeadDay="";
		if (pos>-1) {
			mLive=mSortAllList.get(pos).getAlive_flag();
			if (mLive.equals(Constant.ALIVE_YES)) {
				mSwitch.setBackgroundResource(R.drawable.switch_off);
				mOtherLayout.setVisibility(View.GONE);
			}else {
				mSwitch.setBackgroundResource(R.drawable.switch_on);
				mOtherLayout.setVisibility(View.VISIBLE);
			}
			
			mBirthdDay=mSortAllList.get(pos).getAd_birth();
			mDeadDay=mSortAllList.get(pos).getAd_death();
			
			mEditxing.setText(getStr(mSortAllList.get(pos).getSurname()));
			mEditName.setText(getStr(mSortAllList.get(pos).getGenealogy_name()));
			
			mEditEverName.setText(getStr(mSortAllList.get(pos).getCommon_name()));
			mEditSex.setText(getStr(mSortAllList.get(pos).getGender()));
			mEditPaihang.setText(getStr(mSortAllList.get(pos).getRank()));
			mEditBirthDate.setText(getStr(mSortAllList.get(pos).getAd_birth()));
			mEditBirthAdrress.setText(getStr(mSortAllList.get(pos).getBirth_place()));
			mEditZihao.setText(getStr(mSortAllList.get(pos).getPrefix_name()));
			mEditBeiHao.setText(getStr(mSortAllList.get(pos).getLine_name()));
			mEditMark.setText(getStr(mSortAllList.get(pos).getTitle_name()));
			
			mEditDeadDay.setText(getStr(mSortAllList.get(pos).getGenealogy_name()));
			mEditDeadDate.setText(getStr(mSortAllList.get(pos).getAd_death()));
			mEditDeadAddress.setText(getStr(mSortAllList.get(pos).getDeath_place()));
			mEditMuTxt.setText(getStr(mSortAllList.get(pos).getEpitaph()));
			mEditInfo.setText(getStr(mSortAllList.get(pos).getBiography())); 
			 
		}
		
		 mEditBirthDate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	choiDate(mEditBirthDate, 0);
			}
		});
		 
		 mEditDeadDate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	choiDate(mEditDeadDate, 1);
			}
		});
		mSwitch.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (mLive.equals(Constant.ALIVE_YES)) {
					mLive=Constant.ALIVE_NO;
					mSwitch.setBackgroundResource(R.drawable.switch_on);
					mOtherLayout.setVisibility(View.VISIBLE);
				}else {
					mLive=Constant.ALIVE_YES;
					mSwitch.setBackgroundResource(R.drawable.switch_off);
					mOtherLayout.setVisibility(View.GONE);
				}
			}
		});
		
		
		 
		  mPopView.findViewById(R.id.add_done_tv).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					//完成编辑
					String a=mEditxing.getText().toString();
					String b=mEditName.getText().toString();
					String c=mEditEverName.getText().toString();
					String d=mEditSex.getText().toString();
					String e=mEditPaihang.getText().toString();
					
					String f=mEditBirthDate.getText().toString();
					String g=mEditBirthAdrress.getText().toString();
					
					String h=mEditZihao.getText().toString();
					String i=mEditBeiHao.getText().toString();
					String j=mEditMark.getText().toString();
					
					String k=mEditDeadDay.getText().toString();
					String m=mEditDeadDate.getText().toString();
					
					String l=mEditDeadAddress.getText().toString();
					
					String n=mEditInfo.getText().toString();
					
					String o=mEditMuTxt.getText().toString();
					 
					
					
					if (pos>-1) {
						updatePerson(mSortAllList.get(pos).getId()+""
								, a, b, d, f+"", m+"", "",
								"", "", "", e, h, c, i, 
								"", "", mLive, "", n, o, g, l);
					}else {
						//添加人员
						 int ger=gerne;
						String coup="";
						String motherid="";
						String fatherid="";
						if ( cate==Constant.CATE_MOTHER ) {
							 motherid=id+"";
						    }
						
						if ( cate==Constant.CATE_FATHER) {
							 fatherid=id+"";
						    }
						
						if ( cate==Constant.CATE_WIFE ) {
							 coup=id+"";
						    }
						
						
						
						 if (cate==Constant.CATE_FATHER||cate==Constant.CATE_MOTHER) {
							ger=ger-1;
						   }
						 
						 if (cate==Constant.CATE_SON||cate==Constant.CATE_DAU ) {
							     ger=ger+1;
							     
							     if ((gender+"").equals("男")) {
									 fatherid=id+"";
								}
							     
							     if ((gender+"").equals("女")) {
									 motherid=id+"";
								}
							     
						      }
						 
						 
						  
						 
						 ShowToast("添加父母id"+motherid);
						Log.e("添加父母亲id", motherid);
						addPerson(mGid +""
								, a, b, d, mBirthdDay+"", mDeadDay+"", coup ,
								fatherid, motherid, ger+"", e, h, c, i, 
								"", "", mLive, "", n, o, g, l);
						 
					}
					    mPopWindow.dismiss();
					
					
				}
			});
		
		
		
        mPopView.findViewById(R.id.add_closed).setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				mPopWindow.dismiss();
				
			}
		});
        

 	}
	
	 private String getStr(String str) {
		// TODO Auto-generated method stub

		 str=str+"";
		return str.replace("null", "");
		
	}
	 private String getDate(long date) {
			// TODO Auto-generated method stub
             if (date>0) {
            	 return  Constant.dayFormat(date);
			}else {
				 return"";
			}
		 
			
			
		}
	
	/**
	 * 我的族谱id
	 */
	 private int mMyGid=-1;
	 private FamilyData mMyFamilyData=new FamilyData();
	/**
	 * 获取我的信息
	 */
 	 private void getMyInfo() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(Constant.url + "getPerSonById");
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("id", mMyID));
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
									jsonMy(response);
								}  
							}
						});

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

 	  private int mMyGeneration;
	private void jsonMy(String s) {
		// json解析
		try {
 			
			JSONObject obj = new JSONObject(s);
			 JSONArray arr;
			arr = obj.getJSONArray("data");
			for (int i = 0; i < arr.length(); i++) {
				JSONObject ob = arr.getJSONObject(i);
				mMyFamilyData=new FamilyData();
				mMyFamilyData.setAd_birth(getStr(ob.getString("ad_birth")));
				mMyFamilyData.setAd_death(getStr(ob.getString("ad_death")));
				mMyFamilyData.setAlive_flag(ob.getString("alive_flag"));
				mMyFamilyData.setBiography( ob.getString("biography"));
				mMyFamilyData.setBirth_place( ob.getString("birth_place"));
				mMyFamilyData.setCe_birth( ob.getString("ce_birth"));
				mMyFamilyData.setCe_death( ob.getString("ce_death"));
				mMyFamilyData.setCommon_name( ob.getString("common_name"));
				mMyFamilyData.setDeath_place( ob.getString("death_place"));
				mMyFamilyData.setEpitaph( ob.getString("epitaph"));
				mMyFamilyData.setFather_id( ob.getString("father_id"));
				mMyFamilyData.setGender( ob.getString("gender"));
				mMyFamilyData.setGenealogy_name( ob.getString("genealogy_name"));
				mMyFamilyData.setGeneration(getInt( ob.getString("generation")));
				mMyFamilyData.setGid( getInt(ob.getString("gid")));
				mGid=mMyFamilyData.getGid()+"";
				
				mMyFamilyData.setLine_name( ob.getString("line_name"));
				mMyFamilyData.setMother_id( ob.getString("mother_id"));
				mMyFamilyData.setPrefix_name( ob.getString("prefix_name"));
				mMyFamilyData.setRank( ob.getString("rank"));
				mMyFamilyData.setShow_flag( ob.getString("show_flag"));
				mMyFamilyData.setSpouse( ob.getString("spouse"));
				mMyFamilyData.setSurname( ob.getString("surname"));
				mMyFamilyData.setTitle_name( ob.getString("title_name"));
				
				mMyGeneration=mMyFamilyData.getGeneration();
				try {
					mMyFamilyData.setId(Integer.parseInt(ob.getString("id")));
				} catch (Exception e) {
					 e.printStackTrace();
				}
			
				mMyGid=mMyFamilyData.getGid( );
  			}

		} catch (Exception e) {

			 addMy();
			
			e.printStackTrace();

		} finally {
			try {
				 if (mMyGid>-1) {
 					getMyFamily(mMyGid+"");
				  } 
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		}

	}
	
	
	
	
	
	
	private List<FamilyData> mMyFamilyList=new ArrayList<FamilyData>();
	/**
	 * 获取我的家族信息
	 */
 	 private void getMyFamily(final String gid) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					HttpClient httpclient = new DefaultHttpClient();
					HttpPost httpPost = new HttpPost(Constant.url + "getPserSonByGid");
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					params.add(new BasicNameValuePair("id", gid));

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
									jsonFamily(response);
								}  
							}
						});

					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	private void jsonFamily(String s) {
		// json解析
		  mMyFamilyList.clear();
		 
		try {
 			JSONObject obj = new JSONObject(s);
			JSONArray arr;
			arr = obj.getJSONArray("data");
			for (int i = 0; i < arr.length(); i++) {
				JSONObject ob = arr.getJSONObject(i);
			FamilyData	data=new FamilyData();
				data.setAd_birth(getStr(ob.getString("ad_birth")));
				data.setAd_death(getStr(ob.getString("ad_death")));
				data.setAlive_flag(ob.getString("alive_flag"));
				data.setBiography( ob.getString("biography"));
				data.setBirth_place( ob.getString("birth_place"));
				data.setCe_birth( ob.getString("ce_birth"));
				data.setCe_death( ob.getString("ce_death"));
				data.setCommon_name( ob.getString("common_name"));
				data.setDeath_place( ob.getString("death_place"));
				data.setEpitaph( ob.getString("epitaph"));
				data.setFather_id( ob.getString("father_id"));
				data.setGender( ob.getString("gender"));
				data.setGenealogy_name( ob.getString("genealogy_name"));
				data.setGeneration(getInt( ob.getString("generation")));
				data.setGid( getInt(ob.getString("gid")));
				data.setLine_name( ob.getString("line_name"));
				data.setMother_id( ob.getString("mother_id"));
				data.setPrefix_name( ob.getString("prefix_name"));
				data.setRank( ob.getString("rank"));
				data.setShow_flag( ob.getString("show_flag"));
				data.setSpouse( ob.getString("spouse"));
				data.setSurname( ob.getString("surname"));
				data.setTitle_name( ob.getString("title_name"));
 			
 				try {
					data.setId(Integer.parseInt(ob.getString("id")));
				} catch (Exception e) {
					 e.printStackTrace();
				}
 			//	Log.e("代书", data.getGeneration()+"---"+mGrounpMin);
 				if (mCate==Constant.CHOI_C) {
 					if (Math.abs(mMyGeneration-data.getGeneration())<=2) {
 						
// 						if (Math.abs(mMyGeneration-data.getGeneration())==1) {
//							 if (data.getMother_id().equals(mMyFamilyData.getId()+"")
//									 ||data.getFather_id().equals(mMyFamilyData.getId()+"")
//									  ||mMyFamilyData.getFather_id().equals(data.getId()+"")
//								      ||mMyFamilyData.getFather_id().equals(data.getId()+"")
//									 ) {
//								 mMyFamilyList.add(data);
//							}
// 							
//						}else {
//							mMyFamilyList.add(data);
//						}
 						
 						mMyFamilyList.add(data);
 						
 					}
 	 				
				}
 				if (mCate==Constant.CHOI_A) {
 				 
 						mMyFamilyList.add(data);
 				 
 	 				
				}
 				if (mCate==Constant.CHOI_B) {
 					 
 						mMyFamilyList.add(data);
 				 
 	 				
				}
 				if (mCate==Constant.CHOI_D) {
 				 
 						mMyFamilyList.add(data);
 				 
 	 				
				}
 				
 				
 				mGrounp=Math.max(mGrounp, data.getGeneration());
 				mGrounpMin=Math.min(mGrounpMin, data.getGeneration());
 			//	Log.e("最多的代数和人", mGrounp+"---"+mGrounpMin);
  			}

		} catch (Exception e) {
			 
			 addMy();
			
			e.printStackTrace();

		} finally {
			try {
				sortMyFamily();
			} catch (Exception e2) {
				Log.e("错误", e2.toString());
			}

		}

	}
	  
	 /**
	  * 代数
	  */
	 private List<Integer> mGenerat=new ArrayList<Integer>();
	
	  /*
	   * 最大的代数
	   */
	  private int mGrounp=0;
	  private int mGrounpMin=100000;
	  private int mMaxIndex;//最长的数据行
	  /**
	   * 最多人的一代
	   */
	  private int mMaxGenerNums=8;
	  private List<FamilyGrounp> mMyFamilyGrounps=new ArrayList<FamilyGrounp>();
 	  private void sortMyFamily() {
		//  
 		    mMaxGenerNums=8;
 		    mGenerat.clear();
 		    mMyFamilyGrounps.clear();
 		  for (int i = mGrounpMin; i < mGrounp+1; i++) {
 			    mGenerat.add(i);
 			  
 			    FamilyGrounp grounp=new FamilyGrounp();
 			    List<FamilyData> list=new ArrayList<FamilyData>();
//  			    FamilyData da=new FamilyData();
// 			    da.setPh(true);
// 			    list.add(da);//设置辈分
 			   
			     for (int j = 0; j <mMyFamilyList.size(); j++) {
				  if (mMyFamilyList.get(j).getGeneration()==i) {
					 list.add(mMyFamilyList.get(j));
 				        }
 			         }
			     grounp.setGeneration(i);
			     grounp.setList(list);
			       mMyFamilyGrounps.add(grounp);
			   //  Log.e("往代里添加人", list.size()+"---"+i);
//			     if (mMaxGenerNums<list.size()) {
//					 mMaxIndex=mMyFamilyGrounps.size()-1;//最长数据行的index
//				     }
			     mMaxGenerNums=Math.max(mMaxGenerNums, list.size());
			     
			     
		          }
 
 		    if  (mMaxGenerNums<8) {
			     mMaxGenerNums=8; 
		          } 
 		    mMaxGenerNums=mMaxGenerNums+(mMaxGenerNums/2);
 		       mHomeAGridView.setNumColumns(mMaxGenerNums);
 		         setTree();
 		         
 		         mHomeListview.setAdapter(new TitleAdapter(getApplicationContext(), mGenerat, mHandler));
          	   }
	    /**
	     * 最终排序的数据
	     */
 	    private List<FamilyGrounp> mAllList=new ArrayList<FamilyGrounp>();
 	   private List<FamilyGrounp> mAllBackList=new ArrayList<FamilyGrounp>();
 	    
 	 //   private List<Integer> mSetIntList=new ArrayList<Integer>();
 	    /**
 	     * 父系 按照夫妻关系进行排序
 	     */
 	     private void setTree() {
			// 开始制作树
 	     	 mAllList.clear();
 	     	mAllBackList.clear();
  	    	 for (int i = mMyFamilyGrounps.size()-1; i >=0; i--) {
  	    		    //  mSetIntList.clear();
  	    		
  	    		     List<FamilyData> inList=new ArrayList<FamilyData>(); 
  	    		     FamilyGrounp gr=new FamilyGrounp();
  	    		     gr.setGeneration(mMyFamilyGrounps.get(i).getGeneration());
  	    		     
  	    		     
 	    		     List<FamilyData> list=mMyFamilyGrounps.get(i).getList();
 	    		     Log.e("开始排序", list.size()+"--="+i);
 	    		 //   List<FamilyData> inAllList=new ArrayList<FamilyData>(); //夫妻排序的数据
 	    		     for (int j = 0; j <list.size(); j++) {
 	    		    	  FamilyData da=list.get(j);
 	    		    	  if (j==0) {
 	    		    		  da.setCoupleStart(true);//夫妻开头
  	    		    		  inList.add(da);
  	    		    		//  inAllList.add(da);
  	    		    		  Log.e("开始排序添加", list.size()+"---"+i);
 					    	  }else{
								
// 					    		 boolean has=false;
//								  for (int m = 0; m <inList.size(); m++) {
//								  if (inList.get(m).getId()==da.getId()) {
//								   has=true;
//								    break;
//								    }
//		 					        }
//								  if (!has) {
//									  da.setCoupleStart(true);//夫妻开头
//									  inList.add(da);
//								    }	 
 					    		 
							}
 	    		    	  
 	    		    	  
 	    		    	  
 	    		    	 if(j+1<list.size()){
   	    		    	 for (int k = j+1; k < list.size(); k++) {
 	    		    		String cour=list.get(k).getSpouse();
 	    		    		
							if (cour!=null) {
								if (cour.contains("#")) {
									  String [] str=cour.split("#");
								       for (int l = 0; l < str.length; l++) {
										 if (str[l].equals((da.getId()+""))) {
											    
											 boolean has=false;
											  for (int m = 0; m <inList.size(); m++) {
											  if (inList.get(m).getId()==list.get(k).getId()) {
											   has=true;
											    break;
											    }
					 					        }
											  if (!has) {
												  inList.add(list.get(k));
											    }
											
											  
											  
											  
										  }
									  }
								}else {
									   Log.e("配偶id", cour+"---");
									 if (cour.equals((da.getId()+""))) {
 										  boolean has=false;
										  for (int m = 0; m <inList.size(); m++) {
										  if (inList.get(m).getId()==list.get(k).getId()) {
										   has=true;
										    break;
										    }
				 					        }
										  if (!has) {
											  inList.add(list.get(k));
										    }
										 }
									
								}
								
							}
 	    		    		 
 	    		    	 }
   	    		    	 
   	    		    	   for (int k = 0; k < list.size(); k++) {
   	    		    		   boolean has=false;
							 for (int m = 0; m < inList.size(); m++) {
								  if (inList.get(m).getId()==list.get(k).getId()) {
									 has=true;
									 break;
								}
								 
							}
							  if (!has) {
								  inList.add(list.get(k));
							}
						}
   	    		    	   
   	    		    	 
   	    		    	 
 	    		    	 }
 	     
 		    }
 	    		     
 	    		    gr.setList(inList);
 	    		    
 	    		    Log.e("准备排版", inList.size()+"---"+i);
 	    		   mAllList.add(gr);
   			       }
  	    	 
  	    	 
  	     getMaxIndex() ;
  		
  	    	if (mCate==Constant.CHOI_D) {
				
  	    	        mSortAllList.clear();
	    	        mPanBanGroup.clear();
   	      for (int i = 0; i < mAllBackList.size(); i++) {
			     FamilyGrounp fa=new FamilyGrounp();
			     List<FamilyData> list=new ArrayList<FamilyData>();
			     for (int j = 0; j < mMaxGenerNums; j++) {
					  FamilyData da=new FamilyData();
					  da.setNull(true);
					  list.add(da);
					 Log.e("添加个数", i+"--"+j+"");
				  }
			    fa.setGeneration(mAllBackList.get(i).getGeneration());
			    fa.setList(list);
	    		    mPanBanGroup.add(fa);
	    		    
		       }
   	      
   	       mBookList.clear();
           mBookBackList.clear();
         
          for (int j = 0; j <mPanBanGroup.size(); j++){
 		  for (int k = 0; k <mPanBanGroup.get(j).getList().size(); k++) {
			   mSortAllList.add(mPanBanGroup.get(j).getList().get(k));
 		      }
		    }
          
          for (int j = 0; j <mAllBackList.size(); j++){
          	
    		  for (int k = 0; k <mAllBackList.get(j).getList().size(); k++) {
    			   mSortAllList.set(j*mMaxGenerNums+k,mAllBackList.get(j).getList().get(k));
    			  
    			  if (!mAllBackList.get(j).getList().get(k).isNull()) {//族谱全貌
    				  BookData data=new BookData();
    				  
    				  FamilyData da=mAllBackList.get(j).getList().get(k);
    				  
    				  data.setGerner(j);
    				  data.setFamily(da);
    				  mBookList.add(data);
    				  mBookBackList.add(data);
    			}
    		 
    		      }
    		 }
          
          
          
   mAdapter.notifyDataSetChanged();
   mHomeBateGridview.setAdapter(new BookAdapter(getApplicationContext(), mBookList, mHandler));	
			}else {
				
				  paiban();	
				
			}
   	    	
  	    	
  	    	//setSortByCate(0);
		}
 	     
 	      
 	      /**
 	       * 获取每一代中最多数据的行index
 	       */
 	      private void getMaxIndex() {
			// TODO Auto-generated method stub
 	  	      mAllBackList.clear();
	    	   for (int i = mAllList.size()-1; i >=0 ; i--) {
			  mAllBackList.add(mAllList.get(i));
		    }
	    	   
 	    	  
 	    	   mMaxIndex=0;
  	    	  for (int i = 0; i < mAllBackList.size(); i++) {
				
 	    		    if (i>0) {
						if (mAllBackList.get(i).getList().size()>mAllBackList.get(i-1).getList().size()) {
							   mMaxIndex=i;
 						}
 					}
 			}
  	    	   Log.e("最大数据的行", mMaxIndex+"-------------");
  	    	   

		}
 	     
 	      private List<FamilyGrounp> mPanBanGroup=new ArrayList<FamilyGrounp>();
 	       /**
 	        * 从数据最大的行开始排版
 	        */
 	       private void paiban() {
			// TODO Auto-generated method stub
 	    	        mSortAllList.clear();
   	    	        mPanBanGroup.clear();
 	    	  for (int i = 0; i < mAllBackList.size(); i++) {
				    FamilyGrounp fa=new FamilyGrounp();
				    List<FamilyData> list=new ArrayList<FamilyData>();
				    for (int j = 0; j < mMaxGenerNums; j++) {
						  FamilyData da=new FamilyData();
						  da.setNull(true);
						  list.add(da);
						 Log.e("添加个数", i+"--"+j+"");
 					 }
				    fa.setGeneration(mAllBackList.get(i).getGeneration());
				    fa.setList(list);
   	    		    mPanBanGroup.add(fa);
   	    		    
 			       }
 	    	  
 	    	   

 	    	   for (int i = mMaxIndex; i < mPanBanGroup.size(); i++) {
 	    		          FamilyGrounp g=mPanBanGroup.get(i);
				         if (i==mMaxIndex) {//全部添加
				        	 List<FamilyData> li=g.getList();
				        	 FamilyGrounp ge=mAllBackList.get(i);
				        	 for (int j = 0; j < ge.getList().size(); j++) {
				        		  if (mCate!=Constant.CHOI_C) {
 								   }else {
 								   }
				        		  li.set(j, ge.getList().get(j));
								  
 							          }
				        	  ge.setList(li);
				        	 
 				        	 mPanBanGroup.set(i, ge);
 						  }else{//大于的方向
 							  List<FamilyData> listPre=mPanBanGroup.get(i-1).getList();//上层的
 							  List<FamilyData> list=mAllBackList.get(i).getList();//下层的
 							  List<FamilyData> addinglist=g.getList();//空白的
 							 
 							 for (int j = 0; j < listPre.size(); j++) {
								  for (int k = 0; k <list.size(); k++) {//血缘关系 添加父母亲
								   	 if ((list.get(k).getMother_id()+"").equals((listPre.get(j).getId()+""))||
								   			 (list.get(k).getFather_id()+"").equals((listPre.get(j).getId()+""))){//父母亲的id
								   		 boolean has=false;
								   		 for (int l = 0; l <addinglist.size(); l++) {
											if (addinglist.get(l).getId()==list.get(k).getId()) {
 												has=true;
											    break;//已经添加过
											}
 										}
								   			
								   		if (!has) {
								   			 FamilyData da=list.get(k);
								   			 da.setNull(false);
 								   		 	 addinglist.set(j,da);
 								   		 	// max=j;//最后添加的位置
 										  } 
 									}
  								   }
 							}
 							 
 							 
 							   int max=-1;
 							  for (int j = 0; j <listPre.size(); j++) {
 	                               if (!listPre.get(j).isNull()) {
 	                            	   max=j;
 								   }							
 							    }
 								
 									  for (int k = 0; k < list.size() ; k++) {
 										   boolean has=false;
 									for (int j = 0; j < addinglist.size(); j++) {
 										    if ((addinglist.get(j).getId()+"").equals(list.get(k).getId()+"")) {
												has=true;//如果已经添加过
												
											 
												break;
											}
 										
											
										}
 									 if (!has) {
 										 if (mCate!=Constant.CHOI_C) {
											
									 
 										 try {
 											 addinglist.set(max+1, list.get(k));
 	  										 max++;
										} catch (Exception ex) {
											 Log.e ("添加错误", ex.toString());
										}
  										
									   }
 									 }
 									
 									}
 									
 										g.setList(addinglist);  
 	 									mPanBanGroup.set(i, g);
 							  
 							  
 						  }
				         
				         
 	    	   }
 	    	   
 	    	   
 	    	  if (mMaxIndex>0) {
				
		
 	    	 for (int i = mMaxIndex; i >=0; i--) {
				
 	    		  FamilyGrounp g=mPanBanGroup.get(i);
			         if (i==mMaxIndex) {//全部添加
//			        	 FamilyGrounp ge=mAllList.get(i);
//			        	 mPanBanGroup.set(i, ge);
					  }else {//大于的方向
						  List<FamilyData> listPre=mPanBanGroup.get(i+1).getList();//下层的
						  List<FamilyData> list=mAllBackList.get(i).getList();//上层的
						  List<FamilyData> addinglist=g.getList();//空白的
						 
						  for (int j = 0; j < listPre.size(); j++) {
							  for (int k = 0; k <list.size(); k++) {//血缘关系 无母亲添加
							   	 if ((listPre.get(j).getMother_id()+"").equals((list.get(k).getId()+""))||
							   			(listPre.get(j).getFather_id()+"").equals((list.get(k).getId()+""))){//父母亲的id
							   		 boolean has=false;
							   		 for (int l = 0; l <addinglist.size(); l++) {
										if (addinglist.get(l).getId()==list.get(k).getId()) {
											has=true;
										   break;//已经添加过
										}
									}
							   			
							   		if (!has) {
							   		     FamilyData da=list.get(k);
						   			     da.setNull(false);
							   		 	 addinglist.set(j,da);
//							   		     max=j;//最后添加的位置
// 							   		     Log.e ("最后添加的位置", max+"--"+i);
									  } 
							   		  
								}
								   
							}
							 
							  
						}
						   int max=-1;
						  for (int j = 0; j <listPre.size(); j++) {
                               if (!listPre.get(j).isNull()) {
                            	   max=j;
							   }							
						    }

						  for (int k = 0; k < list.size() ; k++) {
							   boolean has=false;
						for (int j = 0; j < addinglist.size(); j++) {
							    if ((addinglist.get(j).getId()+"").equals(list.get(k).getId()+"")) {
									has=true;//如果已经添加过
									break;
								}
							
								
							}
						
						 if (mCate!=Constant.CHOI_C) {
								
							 
						 if (!has) {
							 try {
								 addinglist.set(max+1, list.get(k));
									 max++;
							} catch (Exception ex) {
								 Log.e ("添加错误", ex.toString());
							}
								
						   }
						 }
						}
						
							g.setList(addinglist);  
								mPanBanGroup.set(i, g);
						  
						  
					  }
 	    	} 
 	    		 
 	    		 
 	    		 
 	    		 
			 }  
 	    	   
 	    	   
 	    	   /**
 	    	    * 测试代码
 	    	    */
 	    	         mBookList.clear();
 	    	         mBookBackList.clear();
 	    	    for (int j = 0; j <mPanBanGroup.size(); j++){
 	    	    	
					  for (int k = 0; k <mPanBanGroup.get(j).getList().size(); k++) {
						  mSortAllList.add(mPanBanGroup.get(j).getList().get(k));
						  
						  if (!mPanBanGroup.get(j).getList().get(k).isNull()) {//族谱全貌
							  BookData data=new BookData();
							  
							  FamilyData da=mPanBanGroup.get(j).getList().get(k);
							  
							  data.setGerner(j);
							  data.setFamily(da);
							  mBookList.add(data);
							  mBookBackList.add(data);
						}
						  
						  Log.e("添加数据", j+"---"+k+"当前个数"+mPanBanGroup.get(j).getList().size());
					      }
  				 }
 	    	    
 	    	      String myFatherId,myMotherId;
 	    	      
 	    	     if (mCate==Constant.CHOI_C) {//去除 非直系亲属
					 myFatherId=mMyFamilyData.getFather_id();
					 myMotherId=mMyFamilyData.getMother_id();
 	    	    	 int gener=mMyFamilyData.getGeneration();
 	    	    	 
 	    	    	   Log.i("我的 的上级", myFatherId+"--"+myMotherId);
 	    	    	 FamilyData  mFatherFater,mMaterMater;
 	    	    	 String mFatherFaterID="-1",mMaterMaterID="-1";
					  for (int j = 0; j < mSortAllList.size(); j++) {
						   if (mSortAllList.get(j).getGeneration()-gener==-1) {
							   if (!(myFatherId+"").equals("null")&&(mSortAllList.get(j).getId()+"").equals(myFatherId+"")) {
								   mFatherFaterID= mSortAllList.get(j).getFather_id();
 							  }
							   
							   if (!(myMotherId+"").equals("null")&&(mSortAllList.get(j).getId()+"").equals(myMotherId+"")) {
								   mMaterMaterID= mSortAllList.get(j).getMother_id();
							  }
							   
						   }
						   
					  }
						   Log.i("我的父亲母亲的上级", mFatherFaterID+"--"+mMaterMaterID);
						  
						 
						 
					   
					    	     
					    	     for (int i = 0; i < mSortAllList.size(); i++) {
					    	    	    if (mSortAllList.get(i).getGeneration()-gener==-2) {
					    	    	 try {
					    	    		 if (!mSortAllList.get(i).isNull()&& (mSortAllList.get(i).getGender()+"").equals("男")) {
					    	    			   Log.i("我的父亲母亲的上级内部", mSortAllList.get(i).getId()+"");
											 if (!(mSortAllList.get(i).getId()+"").equals(mFatherFaterID+"") ) {
												 FamilyData da=new FamilyData();
												 da.setNull(true); 
												 mSortAllList.set(i, da);
											}
										  }
									      if ( !mSortAllList.get(i).isNull()&& (mSortAllList.get(i).getGender()+"").equals("女")) {
									    	  if (!(mSortAllList.get(i).getId()+"").equals(mMaterMaterID+"") ) {
													 FamilyData da=new FamilyData();
													 da.setNull(true); 
													 mSortAllList.set(i, da);
												}
											}
									} catch (Exception e) {
										 Log.e("错误", e.toString());
									}
									     
					    	    	    }     
								}
					    	    
						  
 	    	    
//					    	     String mSonsonID="-1",mDauDouID="-1";
//								  for (int j = 0; j < mSortAllList.size(); j++) {
//									   if (mSortAllList.get(j).getGeneration()-gener==1) {
//										   if (!(mSortAllList.get(j).getFather_id()+"").equals("null")&&(mSortAllList.get(j).getFather_id()+"").equals(mMyID+"")) {
//											   mSonsonID= mSortAllList.get(j).getId()+"";
//			 							  }
//										   
//										   if (!(mSortAllList.get(j).getMother_id()+"").equals("null")&&(mSortAllList.get(j).getMother_id()+"").equals(mMyID+"")) {
//											   mDauDouID= mSortAllList.get(j).getId()+"";
//										  }
//										   
//									     }
//									   
//								  }
									   
								    	     
								    	     for (int i = 0; i < mSortAllList.size(); i++) {
								    	    	    if (mSortAllList.get(i).getGeneration()-gener==2) {
								    	    	    	 FamilyData da=mSortAllList.get(i);
								    	    	 try {
								    	    		  
								    	    		   for (int j = 0; j <mSortAllList.size(); j++) {
								    	    			   if (mSortAllList.get(i).getGeneration()-gener==1) { 
								    	    				   
								    	    				   if (!(da.getFather_id()+"").equals("null")
								    	    						&&  (da.getFather_id()+"").equals( mSortAllList.get(i).getId()+"")
								    	    						   ) { 
								    	    					   
								    	    					     if (!mSortAllList.get(i).isNull()) {
																		 if (!mSortAllList.get(i).getFather_id().equals(mMyID+"")) {
																			 FamilyData daa=new FamilyData();
																			 daa.setNull(true);
																			 mSortAllList.set(i, daa);
																		}
																	}
																
															}
								    	    		   }
													}
								    	    		 
								    	    		 
								    	    		 
												} catch (Exception e) {
													 Log.e("错误", e.toString());
												}
												     
								    	    	    }     
											}
					
 	    	    	 
 	    	    	 
				}
 	    	    
 	    	    
 	    	   mAdapter.notifyDataSetChanged();
  	    	   mHomeBateGridview.setAdapter(new BookAdapter(getApplicationContext(), mBookList, mHandler));
 	    	   
		}
 	      
 	      
 	      private List<BookData> mBookList=new ArrayList<BookData>();
 	       
 	       
 	     private List<BookData> mBookBackList=new ArrayList<BookData>();
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	       
 	      private void painBanIn( List<FamilyData> list,int i) {  
  	  	    		    if (i==0) {
  	  	    			  Log.e("开始排版0世代", list.size()+"---"+i); 
 	 					 for (int j = 0; j < list.size(); j++) {
 	 						  mSortAllList.add(list.get(j));
 	 					     }
 	 				     
 	  	    		   
 	  	    		       for (int j =  list.size(); j < mMaxGenerNums+1; j++) {//填满空白
 	   	    		    	       FamilyData da=new FamilyData();
 	  	    		    	       da.setNull(true);
 	  	    		    	       mSortAllList.add(da);
 	  					         }
 	  	    		       }
 	  	    		   
 	   	    		  if (i>0) {
 	  	    			 List<FamilyData> listpre=mAllList.get(i-1).getList();
 
 	 	    			    
 	  	    			  int addNum=0;//添加的数量
 	  	    			 
 	 					 for (int j = 0; j < list.size(); j++) {
 	  					   for (int k = 0; k < listpre.size(); k++) {
 	   						   if ((list.get(j).getId()+"").equals(listpre.get(k).getFather_id()+"")) {//寻找父亲id
 	   							    
 	   							   boolean has=false;
 	   							   for (int m = 0; m <mSortAllList.size(); m++) {
 	 								 if (mSortAllList.get(m).getId()==listpre.get(k).getId()) {//已添加父辈
 	  									 has=true;
 	 								 }
 	 							     }
 	   							   
 	   						    if (has) {
 	 								FamilyData da=new FamilyData();
 	 								da.setNull(true);//添加占位
 	 								addNum++;
 	 						  	  }else {
 	 								 mSortAllList.add( list.get(j));
 	 									addNum++;
 	 							  }
 	   						    
 	   						    
 	   						    
 	   						  for (int n = 0; n < listpre.size(); n++) {//添加配偶
 	    							    if (listpre.get(n).getSpouse().equals((listpre.get(k).getId()+""))) {
 	 									
 	   							      boolean hasa=false;
 	   	  							   for (int m = 0; m <mSortAllList.size(); m++) {
 	   									 if (mSortAllList.get(m).getId()==listpre.get(k).getId()) {//已添加过
 	   	 									 hasa=true;
 	   									   }
 	   								     }
 	    	  						    if (!hasa) {
 	    									 mSortAllList.add( listpre.get(k));
 	    									addNum++;
 	   								  }
 	  							    }
 	    						       }
 	   						    
 	   						    
 	  						      
 	  							}
 	  						   
 	 						 }
 	  					     }
 	  	    			 
 	 					    if (addNum<mMaxGenerNums) {//补充空位置
 	 							for (int j = addNum; j < mMaxGenerNums; j++) {
 	 								FamilyData da=new FamilyData();
 	 								da.setNull(true);//添加占位
 	 								mSortAllList.add(da);
 	 							}
 	 					    	
 	 						}

 	   	    		  }
 	    	  

		}
 	      
 	      
 	     
 	     private List<FamilyData> mSortAllList=new ArrayList<FamilyData>();
 	     private List<FamilyData> mSortAllBackList=new ArrayList<FamilyData>();//所有的数据
 	     
 	     /**
 	      * 开始进行排版
 	      */
 	     private void setSortByCate(int which) {
			//  
 	       for (int i =mAllList.size()-1; i >=0; i--) {
 	    	  Log.e("开始排版", mAllList.size()+"---"+i);
 	    		  List<FamilyData> list=mAllList.get(i).getList();
 	    		   if (i==0) {
// 	    			    FamilyData da=new FamilyData();
// 	    			    da.setPh(true);
// 	    			    mSortAllList.add(da);//添加一...世辈分
 	    			  Log.e("开始排版0世代", list.size()+"---"+i); 
					 for (int j = 0; j < list.size(); j++) {
						  mSortAllList.add(list.get(j));
					     }
				     
 	    		   
 	    		       for (int j =  list.size(); j < mMaxGenerNums; j++) {//填满空白
  	    		    	       FamilyData da=new FamilyData();
 	    		    	       da.setNull(true);
 	    		    	       mSortAllList.add(da);
 					         }
 	    		       }
 	    		   
  	    		  if (i>0) {
 	    			 List<FamilyData> listpre=mAllList.get(i-1).getList();
 	    			  
 	    			    
// 	    			    FamilyData da=new FamilyData();
//	    			    da.setPh(true);
//	    			    mSortAllList.add(da);//添加一...世辈分
	    			    
 	    			  int addNum=0;//添加的数量
 	    			 
					 for (int j = 0; j < list.size(); j++) {
 					   for (int k = 0; k < listpre.size(); k++) {
  						   if ((list.get(j).getId()+"").equals(listpre.get(k).getFather_id()+"")) {//寻找父亲id
  							    
  							   boolean has=false;
  							   for (int m = 0; m <mSortAllList.size(); m++) {
								 if (mSortAllList.get(m).getId()==listpre.get(k).getId()) {//已添加父辈
 									 has=true;
								 }
							     }
  							   
  						    if (has) {
								FamilyData da=new FamilyData();
								da.setNull(true);//添加占位
								addNum++;
						  	  }else {
								 mSortAllList.add( list.get(j));
									addNum++;
							  }
  						    
  						    
  						    
  						  for (int n = 0; n < listpre.size(); n++) {//添加配偶
   							    if (listpre.get(n).getSpouse().equals((listpre.get(k).getId()+""))) {
									
  							      boolean hasa=false;
  	  							   for (int m = 0; m <mSortAllList.size(); m++) {
  									 if (mSortAllList.get(m).getId()==listpre.get(k).getId()) {//已添加过
  	 									 hasa=true;
  									   }
  								     }
   	  						    if (!hasa) {
   									 mSortAllList.add( listpre.get(k));
   									addNum++;
  								  }
 							    }
   						       }
  						    
  						    
 						      
 							}
 						   
						 }
 					     }
 	    			 
					    if (addNum<mMaxGenerNums) {//补充空位置
							for (int j = addNum; j < mMaxGenerNums; j++) {
								FamilyData da=new FamilyData();
								da.setNull(true);//添加占位
								mSortAllList.add(da);
							}
					    	
						}
					 
				}
 	    		
 	    		 
 	    		 
		 }
 	    	 
 	      setData();
		}
 	      /**
 	       * 数据反向显示
 	       */
 	      private void setData() {
			// TODO Auto-generated method stub

 	    	  mSortAllBackList.clear();
 	    	  for (int i = mSortAllList.size()-1; i >0; i--) {
				
 	    		  mSortAllBackList.add(mSortAllList.get(i));
 	    		  
 	    		 Log.e("输出数据", mSortAllList.get(i).getId()+"");
 	    		 
 	    		 
			}
 	    	 mAdapter.notifyDataSetChanged();
 	    	  
		}
 	     
 	     
 	  
 	  
	
 	  
 	    private void addMy() {
		//无数据时 添加
  		    mMyFamilyList.clear();
 		    FamilyData	mMyFamilyData=new FamilyData();
			mMyFamilyData.setAd_birth("");
			mMyFamilyData.setAd_death("");
			
			mMyFamilyData.setAlive_flag("");
			mMyFamilyData.setBiography( "");
			mMyFamilyData.setBirth_place("");
			mMyFamilyData.setCe_birth("");
			mMyFamilyData.setCe_death("");
			mMyFamilyData.setCommon_name( "");
			mMyFamilyData.setDeath_place( "");
			mMyFamilyData.setEpitaph("");
			mMyFamilyData.setFather_id( "");
			mMyFamilyData.setGender( "");
			mMyFamilyData.setGenealogy_name( "");
			mMyFamilyData.setGeneration(-1);
			mMyFamilyData.setGid( -1);
			mMyFamilyData.setLine_name( "");
			mMyFamilyData.setMother_id("");
			mMyFamilyData.setPrefix_name( "");
			mMyFamilyData.setRank( "");
			mMyFamilyData.setShow_flag( "");
			mMyFamilyData.setSpouse( "");
			mMyFamilyData.setSurname("");
			mMyFamilyData.setTitle_name( "");
			mMyFamilyData.setId(mMyGid);
			mMyFamilyList.add(mMyFamilyData);
 		   
			sortMyFamily();
	}
	
	
	
	
	
	
	private long getLong(String str) {
	      long a=-1;
		 if (str!=null&&!str.equals("")&&!str.equals("null")) {
 			 try {
				 a=Long.parseLong(str);
			} catch (Exception e) {
 			}
		   }
 		 return a;
 	    }
	
	
	private int getInt(String str) {
	      int a=-1;
		 if (str!=null&&!str.equals("")&&!str.equals("null")) {
			 try {
				 a=Integer.parseInt(str);
			} catch (Exception e) {
			}
		   }
		 return a;
	    }
	
	
	
	
	
	
	
	 private void updatePerson(final String id,final String surname,final String genealogy_name,final String gender,
			 final String ad_birth,final String ad_death,final String spouse,
			 final String father_id,final String mother_id,final String generation,final String rank,
			 final String prefix_name,final String common_name,final String line_name,final String ce_birth,
			 final String ce_death,final String alive_flag,final String show_flag,final String biography,
			 final String epitaph,
			 final String birth_place,final String death_place ) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						HttpClient httpclient = new DefaultHttpClient();
						HttpPost httpPost = new HttpPost(Constant.url + "updatePerson");
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("id", id));
						params.add(new BasicNameValuePair("surname", surname));
						params.add(new BasicNameValuePair("genealogy_name", genealogy_name));
						params.add(new BasicNameValuePair("gender", gender));
						params.add(new BasicNameValuePair("ad_birth", ad_birth));
						params.add(new BasicNameValuePair("ad_death", ad_death));
						//params.add(new BasicNameValuePair("spouse", spouse));
//						params.add(new BasicNameValuePair("father_id", father_id));
//						params.add(new BasicNameValuePair("mother_id", mother_id));
						//params.add(new BasicNameValuePair("generation", generation));
						params.add(new BasicNameValuePair("rank", rank));
						params.add(new BasicNameValuePair("prefix_name", prefix_name));
						params.add(new BasicNameValuePair("common_name", common_name));
						params.add(new BasicNameValuePair("line_name", line_name));
//						params.add(new BasicNameValuePair("ce_birth", ce_birth));
//						params.add(new BasicNameValuePair("ce_death", ce_death));
						params.add(new BasicNameValuePair("alive_flag", alive_flag));
						params.add(new BasicNameValuePair("biography", biography));
						params.add(new BasicNameValuePair("epitaph", epitaph));
						params.add(new BasicNameValuePair("birth_place", birth_place));
						params.add(new BasicNameValuePair("death_place", death_place));
						 
						 
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
										 if (mMyGid>-1) {
							 					getMyFamily(mMyGid+"");
										  } 
										 
										 
									 
										 
									}  
								}
							});

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	
	
	
	

	 private void addPerson(final String gid,final String surname,final String genealogy_name,final String gender,
			 final String ad_birth,final String ad_death,final String spouse,
			 final String father_id,final String mother_id,final String generation,final String rank,
			 final String prefix_name,final String common_name,final String line_name,final String ce_birth,
			 final String ce_death,final String alive_flag,final String show_flag,final String biography,
			 final String epitaph,
			 final String birth_place,final String death_place ) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						HttpClient httpclient = new DefaultHttpClient();
						HttpPost httpPost = new HttpPost(Constant.url + "addPerson");
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("gid", gid));
						params.add(new BasicNameValuePair("surname", surname));
						params.add(new BasicNameValuePair("genealogy_name", genealogy_name));
						params.add(new BasicNameValuePair("gender", gender));
						params.add(new BasicNameValuePair("ad_birth", ad_birth));
						 
						params.add(new BasicNameValuePair("ad_death", ad_death));
					    params.add(new BasicNameValuePair("spouse", spouse));
						params.add(new BasicNameValuePair("father_id", father_id));
						params.add(new BasicNameValuePair("mother_id", mother_id));
						
					     params.add(new BasicNameValuePair("generation", generation));
					     
						params.add(new BasicNameValuePair("rank", rank));
						params.add(new BasicNameValuePair("prefix_name", prefix_name));
						params.add(new BasicNameValuePair("common_name", common_name));
						params.add(new BasicNameValuePair("line_name", line_name));
//						params.add(new BasicNameValuePair("ce_birth", ce_birth));
//						params.add(new BasicNameValuePair("ce_death", ce_death));
						params.add(new BasicNameValuePair("alive_flag", alive_flag));
						params.add(new BasicNameValuePair("biography", biography));
						params.add(new BasicNameValuePair("epitaph", epitaph));
						params.add(new BasicNameValuePair("birth_place", birth_place));
						params.add(new BasicNameValuePair("death_place", death_place));
						 
						 
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
										 if (mMyGid>-1) {
							 					getMyFamily(mMyGid+"");
										  } 
										 
										 
									 
										 
									}  
								}
							});

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	
	
	
	
	
	
	
	 

//		private Calendar mCalendar;
//		private long mCoiDates;
//		private String mChoiStr;
//
//		private void choiDate(final EditText textview,final int whi) {
//			// 选择日期
//			mCalendar = Calendar.getInstance();
//			new DatePickerDialog(this, new OnDateSetListener() {
//
//				@Override
//				public void onDateSet(DatePicker view, int year, int monthOfYear,
//						int dayOfMonth) {
//					String mou;
//					String day;
//					if (monthOfYear + 1 > 9) {
//						mou = monthOfYear + 1 + "";
//					} else {
//						mou = "0" + (monthOfYear + 1);
//					}
//					if (dayOfMonth > 9) {
//						day = dayOfMonth + "";
//					} else {
//						day = "0" + dayOfMonth;
//					}
//					mCalendar.set(Calendar.YEAR, year);
//					mCalendar.set(Calendar.MONTH, monthOfYear);
//					mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//
//					mCoiDates = mCalendar.getTimeInMillis();
//
//					String text = year + "年" + mou + "月" + day + "日";
//					
//					textview.setText(text);
//					if (whi==0) {
//						mBirthdDay=mCalendar.getTimeInMillis();
//					}else {
//						mDeadDay=mCalendar.getTimeInMillis();
//					}
//					if (mChoiStr == null) {
//						 
//					 
//					} else {
//						mChoiStr = text + " " + mChoiStr;
//						textview.setText(mChoiStr);
//					}
//
//				}
//			}, mCalendar.get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
//					mCalendar.get(Calendar.DAY_OF_MONTH)).show();
//
//		}

	
	
		
		
		
		private EditText mEditConxing,mEditConName,mEditConEverName,mEditConSex,mEditConPaihang,mEditConBirthDate,mEditConBirthAdrress,mEditConZihao,mEditConBeiHao,mEditConMark,
		mEditConDeadDay,mEditConDeadDate,mEditConDeadAddress,mEditConInfo,mEditConMuTxt;
		private View mConSwitch;
		private LinearLayout mConOtherLayout;
		
	   private ImageView mContentImg;
		private void contentPeople(final FamilyData data, final String gender) {
			View mPopView = LayoutInflater.from(this).inflate(
					R.layout.content_people, null);
			final PopupWindow mPopWindow = new PopupWindow(mPopView,
					getWindowManager().getDefaultDisplay().getWidth(),
					getWindowManager().getDefaultDisplay().getHeight(), true);
			mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

			mPopView.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
			int popupWidth = mPopView.getMeasuredWidth();
			int popupHeight = mPopView.getMeasuredHeight();

			mPopWindow.showAtLocation(mBotA, Gravity.CENTER, 0, 0);
			mPopWindow.setAnimationStyle(R.style.MyStyle);
			mPopWindow.update();
	   
			mContentImg=mPopView.findViewById(R.id.add_camear_img);
			mEditConxing=mPopView.findViewById(R.id.edit_xing);
			mEditConName=mPopView.findViewById(R.id.edit_name);
			mEditConEverName=mPopView.findViewById(R.id.add_checka);
			mEditConSex=mPopView.findViewById(R.id.add_checkb);
			mEditConPaihang=mPopView.findViewById(R.id.add_checkc);
			mEditConBirthDate=mPopView.findViewById(R.id.add_checkd);
			mEditConBirthAdrress=mPopView.findViewById(R.id.add_checke);
			mEditConZihao=mPopView.findViewById(R.id.add_checkf);
			mEditConBeiHao=mPopView.findViewById(R.id.add_checkg);
			mEditConMark=mPopView.findViewById(R.id.add_checkh);
			mEditConDeadDay=mPopView.findViewById(R.id.add_checkage);
			
			mEditConDeadDate=mPopView.findViewById(R.id.add_checkdates);
			mEditConDeadAddress=mPopView.findViewById(R.id.add_checkaddress);
			mEditConInfo=mPopView.findViewById(R.id.edit_contenta);
			mEditConMuTxt=mPopView.findViewById(R.id.edit_contentb);
			
			mConSwitch=mPopView.findViewById(R.id.switchview);
			mConOtherLayout=mPopView.findViewById(R.id.other_layout);
			String mLive=Constant.ALIVE_YES;
			 
			 
				mLive=data.getAlive_flag();
				if (mLive.equals(Constant.ALIVE_YES)) {
					mConSwitch.setBackgroundResource(R.drawable.switch_off);
					mConOtherLayout.setVisibility(View.GONE);
				}else {
					mConSwitch.setBackgroundResource(R.drawable.switch_on);
					mConOtherLayout.setVisibility(View.VISIBLE);
				}
				
				if (gender.equals("女")) {
					 mContentImg.setBackgroundResource(R.drawable.ic_girl_portrait_unchecked);
				}
				 
				
				mEditConxing.setText(getStr(data.getSurname()));
				mEditConName.setText(getStr(data.getGenealogy_name()));
				
				mEditConEverName.setText(getStr(data.getCommon_name()));
				mEditConSex.setText(getStr(data.getGender()));
				mEditConPaihang.setText(getStr(data.getRank()));
				mEditConBirthDate.setText(getStr(data.getAd_birth()));
				mEditConBirthAdrress.setText(getStr(data.getBirth_place()));
				mEditConZihao.setText(getStr(data.getPrefix_name()));
				mEditConBeiHao.setText(getStr(data.getLine_name()));
				mEditConMark.setText(getStr(data.getTitle_name()));
				
				mEditConDeadDay.setText(getStr(data.getGenealogy_name()));
				mEditConDeadDate.setText(getStr(data.getAd_death()));
				mEditConDeadAddress.setText(getStr(data.getDeath_place()));
				mEditConMuTxt.setText(getStr(data.getEpitaph()));
				mEditConInfo.setText(getStr(data.getBiography())); 
				 
			 
			 
			
	        mPopView.findViewById(R.id.add_closed).setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
					mPopWindow.dismiss();
					
				}
			});
	        

	 	}	
		
		
		
		
		
		
		
	
	private Toast tost;

	private void intToast() {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {

				// 加载Toast布局
				View toastRoot = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.toast_view, null);
				// 初始化布局控件
				TextView tv = (TextView) toastRoot.findViewById(R.id.toast_tv);
				tv.setText("");
				tost = new Toast(getApplicationContext());
				// 获取屏幕高度
				WindowManager wm = (WindowManager) HomeActivity.this
						.getSystemService(Context.WINDOW_SERVICE);
				int height = wm.getDefaultDisplay().getHeight();

				tost.setGravity(Gravity.TOP, 0, 2 * height / 3);
				tost.setDuration(Toast.LENGTH_SHORT);
				tost.setView(toastRoot);
				// tost.show();

			}
		});

	}

	
	private EditText mUpdateOld, mUpdateNew;
 
 

	@SuppressWarnings("deprecation")
	protected void update() { // 修改密码

		View mPopView = LayoutInflater.from(this).inflate(
				R.layout.update_password, null);
		final PopupWindow mPopWindow = new PopupWindow(mPopView,
				getWindowManager().getDefaultDisplay().getWidth(),
				getWindowManager().getDefaultDisplay().getHeight() + 100, true);
		mPopWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

		mPopView.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
		int popupWidth = mPopView.getMeasuredWidth();
		int popupHeight = mPopView.getMeasuredHeight();

		mPopWindow.showAtLocation(mBotA, Gravity.CENTER, 0, 0);
		mPopWindow.setAnimationStyle(R.style.AppTheme);
		mPopWindow.update();
		Animation animationa = AnimationUtils.loadAnimation(
				HomeActivity.this, R.anim.left);
		mPopView.startAnimation(animationa);
	 
		mUpdateNew = (EditText) mPopView.findViewById(R.id.update_new);
		mUpdateOld = (EditText) mPopView.findViewById(R.id.update_old);

		mPopView.findViewById(R.id.update_closed).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {

						mPopWindow.dismiss();
					}
				});

		mPopView.findViewById(R.id.update_update).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {

						String old = mUpdateOld.getText().toString();
						String newpa = mUpdateNew.getText().toString();
						if (old != null && old.equals(mPassWord)) {

							if (newpa != null && newpa.length() > 5) {
							   
								
								updatepassword(newpa);
							 
								mPopWindow.dismiss();
							 
							} else {
								Toast.makeText(getApplicationContext(),
										"新密码长度大于5", Toast.LENGTH_SHORT).show();
							}

						} else {

							Toast.makeText(getApplicationContext(), "原密码不正确",
									Toast.LENGTH_SHORT).show();
						}

					}
				});
	}
	
	

	 private void updatepassword(final String password) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						HttpClient httpclient = new DefaultHttpClient();
						HttpPost httpPost = new HttpPost(Constant.url + "updatePassword");
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("user", mUser));
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
										mPassWord = password;
										ShowToast("修改成功");
									}  
								}
							});

						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	
	
	
	
	private void ShowToast(final String msg) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {

				if (tost != null) {

					// 加载Toast布局
					View toastRoot = LayoutInflater.from(
							getApplicationContext()).inflate(
							R.layout.toast_view, null);
					// 初始化布局控件
					TextView tv = (TextView) toastRoot
							.findViewById(R.id.toast_tv);
					tv.setText(msg);

					tost.setView(toastRoot);
					tost.show();
				}
			}
		});

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == 5) {
			if (resultCode == RESULT_OK) {

				 
			}
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {

			moveTaskToBack(true);
		}
		return true;
	}

}
