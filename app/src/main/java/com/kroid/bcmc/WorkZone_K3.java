package com.kroid.bcmc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.kroid.Adptr.AdptrFol;
import com.kroid.Adptr.CustomGrid;
import com.kroid.MagicText.MagicTextView;
import com.kroid.ZoomView.TouchImageView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class WorkZone_K3 extends Activity {

	RelativeLayout relMain , relGrid , relList;
	LinearLayout path;
	TouchImageView imgMeme;
	ImageView im1;
	Button btnSave , btnNew , btnChangeLine, btnBaka , btnBack , btnRot;
	File f = null, f1; // **************************************************
	int screenWidthK, screenHeightK, refWidthK = 480, refHeightK = 800; // KROID
																		// KIT
	EditText ed , ed2;
	MagicTextView line1 , line2;
	int line = 1 , backGround = 1;
	GridView grid;
	CustomGrid adapter ;
	int[] Fol1 = {
		      R.drawable.meme1,
		      R.drawable.meme2,
		      R.drawable.meme3,
		      R.drawable.meme4,
		      R.drawable.meme5,
		      R.drawable.meme6,
		      R.drawable.meme7,
		      R.drawable.meme8,
		      R.drawable.meme9
		  };
	int[] Fol2 = {
		      R.drawable.famous1,
		      R.drawable.famous2,
		      R.drawable.famous3,
		      R.drawable.famous4,
		      R.drawable.famous5,
		      R.drawable.famous6,
		      R.drawable.famous7,
		      R.drawable.famous8
		  };
	int[] Fol3 = {
		      R.drawable.desi1,
		      R.drawable.desi2,
		      R.drawable.desi3,
		      R.drawable.desi4,
		      R.drawable.desi5,
		      R.drawable.desi6,
		      R.drawable.desi7,
		      R.drawable.desi8,
		      R.drawable.desi9,
		      R.drawable.desi10,
		      R.drawable.desi11,
		      R.drawable.desi12,
		      R.drawable.desi13,
		      R.drawable.desi14,
		      R.drawable.desi15,
		      R.drawable.desi16,
		      R.drawable.desi17,
		      R.drawable.desi18,
		      R.drawable.desi19,
		      R.drawable.desi20,
		      R.drawable.desi21,
		      R.drawable.desi22,
		      R.drawable.desi23,
		      R.drawable.desi24,
		      R.drawable.desi25,
		      R.drawable.desi26,
		      R.drawable.desi27,
		      R.drawable.desi28,
		      R.drawable.desi29,
		      R.drawable.desi30,
		      R.drawable.desi31,
		      R.drawable.desi32
		  };
	int[] Fol4 = {
			R.drawable.meme1,
		      R.drawable.meme2,
		      R.drawable.meme3,
		      R.drawable.meme4,
		      R.drawable.meme5,
		      R.drawable.meme6,
		      R.drawable.meme7,
		      R.drawable.meme8,
		      R.drawable.meme9
		  };
	int[] Fol5 = {
		      R.drawable.gg1,
		      R.drawable.gg2,
		      R.drawable.gg3,
		      R.drawable.gg4,
		      R.drawable.gg5,
		      R.drawable.gg6,
		      R.drawable.gg7
		  };
	
	int listNum ;
	Float rotAng = (float) 0.0;
	
	ListView list;
	ArrayList<String> itm;
	AdptrFol adpList;
	String[] datas;
	String folderName;
	boolean jobakaFlag = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.workzone_k3);
		//
		relMain = (RelativeLayout) findViewById(R.id.relWZMainMiddl);
		relGrid = (RelativeLayout) findViewById(R.id.relGrid);
		relList = (RelativeLayout) findViewById(R.id.relList);
		path = (LinearLayout) findViewById(R.id.linWZfilePath);
		im1 = (ImageView) findViewById(R.id.imageView1);
		imgMeme = (TouchImageView) findViewById(R.id.imgMeme);
		btnSave = (Button) findViewById(R.id.btnWZsave);
		btnNew = (Button) findViewById(R.id.btnNew);
		btnChangeLine = (Button) findViewById(R.id.btnLines);
		btnBack = (Button) findViewById(R.id.btnBack);
		btnBaka = (Button) findViewById(R.id.btnBaka);
		btnRot = (Button) findViewById(R.id.btnRot);
		ed = (EditText) findViewById(R.id.editText1);
		ed2 = (EditText) findViewById(R.id.editText2);
		line1 = (MagicTextView) findViewById(R.id.txtline1);
		line2 = (MagicTextView) findViewById(R.id.txtline2);
		grid = (GridView) findViewById(R.id.gridViewImgs);
		//
		datas = getResources().getStringArray(R.array.folder_list);
		list = (ListView) findViewById(R.id.listViewFolder);
		itm = new ArrayList<String>();
		//
		Display display = getWindowManager().getDefaultDisplay();
		screenWidthK = display.getWidth();
		screenHeightK = display.getHeight();
		relMain.getLayoutParams().height = screenWidthK+40;
		
		
		for (int i1 = 0; i1 < datas.length; i1++) {
			itm.add(datas[i1]);
		} // folder list
		adpList = new AdptrFol(WorkZone_K3.this, itm);
		list.setAdapter(adpList);
		
		ed.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
					line1.setText(ed.getText().toString());
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
			}
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}
		});
		
		ed2.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				// TODO Auto-generated method stub
					line2.setText(ed2.getText().toString());
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
			}
			@Override
			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}
		});

		f = new File(Environment.getExternalStorageDirectory(), "/BCMC");
		if (!f.exists()) {
			f.mkdir();
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		/*
		 * final File dir = new File(Environment.getExternalStorageDirectory()+
		 * "/BCMC"); dir.mkdirs(); //create folders where write files final File
		 * file = new File(dir, "bcmc.jpg"); Log.i("path11**",
		 * Environment.getExternalStorageDirectory()+ "/BCMC");
		 * Log.i("path22**", file.getAbsolutePath()+"");
		 */

		/*im1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			//	IsPathVisibleK3();
				imgMeme.setVisibility(View.VISIBLE);
				relGrid.setVisibility(View.VISIBLE);
			}
		});*/
		
		im1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final String[] choice1 = { "BCMC's", "Gallery","Cancel"};
				AlertDialog.Builder builder = new AlertDialog.Builder(WorkZone_K3.this);
				Button b1bak = new Button(WorkZone_K3.this);
				builder.setTitle("Please Choose an option:").setItems(choice1,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {
								imgMeme.setVisibility(View.VISIBLE);
								switch (which) {
								case 0:
									imgMeme.setVisibility(View.VISIBLE);
									relList.setVisibility(View.VISIBLE);
									break;
								case 1:
									Intent igall = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
								if (igall.resolveActivity(getPackageManager()) != null)
								{
							        startActivityForResult(igall, 102);
							    }
									break;
								default:
									break;
								}
							}
						});
				builder.create().show();
			}
		});
		
		/*grid.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				setImgKroid(arg2+1);
				relGrid.setVisibility(View.GONE);
			}
		});*/
		
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos,
					long arg3) {
				// TODO Auto-generated method stub
				listNum = pos ;
				if(pos == 4) 
				{
					alert2GGpasswordKroid(datas[pos],pos);
				}
				else 
				{
					folderName = datas[pos];
					gridSetUpK3(datas[pos] , pos);
					relList.setVisibility(View.GONE);
				}
			}
		});
		
		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				if(listNum == 4)
				{
					set2ggImgKroid(position+1+"");
					relGrid.setVisibility(View.GONE);
					relList.setVisibility(View.GONE);
				}
				else {
					setImgKroid(position+1+"");
					relGrid.setVisibility(View.GONE);
					relList.setVisibility(View.GONE);
				}
			}
		});
		
		
		btnNew.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				KintentNew();
			}
		});
		
		btnChangeLine.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
				
				if(ed.getVisibility()==View.VISIBLE)
				{
					ed.setVisibility(View.GONE);
					ed2.setVisibility(View.VISIBLE);
					imm.hideSoftInputFromWindow(ed. getWindowToken(), 0);
				} else {
					ed.setVisibility(View.VISIBLE);
					ed2.setVisibility(View.GONE);
					imm.hideSoftInputFromWindow(ed2.getWindowToken(), 0);
				}

				if(line ==1){
					line = 2 ;
					
				}else{
					line = 1 ;
					
				}
				Toast.makeText(WorkZone_K3.this,"line : " + line+" selected",300).show();
			}
		});
		
		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(!jobakaFlag)
				{
					if(backGround ==1){
						backGround = 0;
						Drawable bg1 = getResources().getDrawable( R.drawable.strokebackgorund_white );
						relMain.setBackgroundDrawable(bg1);
					}
					else{
						backGround = 1;
						Drawable bg2 = getResources().getDrawable( R.drawable.strokebackgorund );
						relMain.setBackgroundDrawable(bg2);
					}
				}
				
			}
		});
		
		btnBaka.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				AlertDialog.Builder adb=new AlertDialog.Builder(WorkZone_K3.this); //alert for each time an item is pressed
		        
		        adb.setMessage("Please Select Baka");
		        adb.setNegativeButton("Bako",new AlertDialog.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						relMain.setBackgroundResource(R.color.baka);
						//setImgKroid("baka");
						int id = getResources().getIdentifier("memebaka", "drawable", getPackageName());
					     Drawable drawable = getResources().getDrawable(id);
					     imgMeme.setImageDrawable(drawable);
					     jobakaFlag=true;
					}});
		        adb.setPositiveButton("Bakudi", new AlertDialog.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						relMain.setBackgroundResource(R.color.baka);
						//setImgKroid("baka");
						int id = getResources().getIdentifier("bakudi", "drawable", getPackageName());
					     Drawable drawable = getResources().getDrawable(id);
					     imgMeme.setImageDrawable(drawable);
					     jobakaFlag=true;
					}});
		        adb.show();
				
			}
		});
		
		btnRot.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rotAng = rotAng + 90;
				imgMeme.setRotation(rotAng);
			}
		});
		
		relGrid.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// do nothing on touch
			}
		});
		relList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// do nothing on touch
			}
		});

		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (line1.length() == 0) {
					Toast.makeText(getApplicationContext(), "Write comment",
							Toast.LENGTH_SHORT).show();
				} else {
					makeImageKroid();

					View content = findViewById(R.id.relWZMainMiddl);
					content.setDrawingCacheEnabled(true);
					Bitmap bitmap = content.getDrawingCache();
					try {
						if (!f1.exists()) {
							f1.createNewFile();
						}
						FileOutputStream ostream = new FileOutputStream(f1
								.getAbsolutePath());
						bitmap.compress(CompressFormat.PNG, 10, ostream);
						ostream.close();
						/*Toast.makeText(getApplicationContext(),
								"saved as : " + f1.getAbsolutePath(),
								Toast.LENGTH_SHORT).show();*/
						KalertShareKroid();
						content.invalidate();
						btnSave.setEnabled(false);
						btnNew.setEnabled(true);
					} catch (Exception e) {
						e.printStackTrace();
						f1.delete();
						/*
						 * finally { content.setDrawingCacheEnabled(false); }
						 */
					}
					content.setDrawingCacheEnabled(false);
				}
			}
		});

	}	// oncreate END **
	
	
	public void setUpCallKroid()// not worked
	{
		for(int i1 = 0 ; i1 < 8 ; i1++) 
		{
			Fol1[i1] = getINTdrawableKroid("meme"+(i1+1)) ;
		}	//	for folder "meme"
		
		for(int i2 = 0 ; i2 < 7 ; i2++) 
		{
			Fol2[i2] = getINTdrawableKroid("famous"+(i2+1)) ;
			line1.setText(Fol2[i2]+"kk");
		}	//	for folder "famous"
	
	}	// setUpCallKroid
	
	public int getINTdrawableKroid(String name)// not work
	{
		return getResources().getIdentifier(name, "drawable", getPackageName());
	}	// getINTdrawableKroid
	
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		switch (requestCode) {
		case 102:
			if(data!= null)
			{
				Uri selectedImg = data.getData();
				try
				{
					InputStream inputStream = getContentResolver().openInputStream(selectedImg); 
					
					BitmapFactory.Options bitmapOptions = new BitmapFactory.Options();
					bitmapOptions.inJustDecodeBounds = true;
					BitmapFactory.decodeStream(inputStream, null, bitmapOptions);
					int imageWidth = bitmapOptions.outWidth;
					int imageHeight = bitmapOptions.outHeight;
					//Toast.makeText(WorkZone_K3.this, imageWidth +" X "+imageHeight, Toast.LENGTH_LONG).show();
					inputStream.close();
				}
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				setImgKroid(selectedImg);
			}
			
			break;

		default:
			break;
		}
	}	// onActivityResult

	public void makeImageKroid() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss")
				.format(new Date());
		String imageFileName = f.getName() + "_" + timeStamp;
		try {
			f1 = File.createTempFile(imageFileName, ".png", f);

			Log.i("path_F1**", f1.getAbsolutePath() + "");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			Log.i("error_F1**", e1.toString() + "");
			f1.delete();
		}

		// **************************************************

	}	//makeImageKroid
	
	 public void setImgKroid(String code)
	 {
		 int id = getResources().getIdentifier(folderName+""+code, "drawable", getPackageName());
	     Drawable drawable = getResources().getDrawable(id);
	     imgMeme.setImageDrawable(drawable);
	 }	// setImgKroid
	 
	 public void set2ggImgKroid(String code)
	 {
		 int id = getResources().getIdentifier("gg"+code, "drawable", getPackageName());
	     Drawable drawable = getResources().getDrawable(id);
	     imgMeme.setImageDrawable(drawable);
	 }	// set2ggImgKroid
	 
	 public void setImgKroid(Uri uri)
	 {
	     imgMeme.setImageURI(uri);
	 }	// setImgKroid
	
	public void KalertShareKroid()
	{
		 AlertDialog.Builder adb=new AlertDialog.Builder(WorkZone_K3.this); //alert for each time an item is pressed
	        adb.setMessage("saved to : " + f1.getAbsolutePath());
	        adb.setNegativeButton("Ok", new AlertDialog.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	                 KintentNew();
	            }});
	        adb.setPositiveButton("Share to WhatsApp", new AlertDialog.OnClickListener() {
	            public void onClick(DialogInterface dialog, int which) {
	                 WhatsAppShareImgK3(f1.getAbsolutePath());
	            }});
	        adb.show();
	}	// KalertShareKroid
	
	public void WhatsAppShareImgK3(String path)
	{
		/*Intent whatsappIntent = new Intent(Intent.ACTION_SEND);
	    whatsappIntent.setType("text/plain");
	    whatsappIntent.setPackage("com.whatsapp");
	    whatsappIntent.putExtra(Intent.EXTRA_TEXT, "Hello World");*/
	    
	    Intent whatsappIntent = new Intent(android.content.Intent.ACTION_SEND);
	    whatsappIntent.setType("image/*");
	    whatsappIntent.setPackage("com.whatsapp");
	    whatsappIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + path));//add image path
	//    startActivity(Intent.createChooser(share, "Share image using"));
	    startActivity(whatsappIntent);
	    
	    /*try {
	        startActivity(whatsappIntent);
	    } catch (android.content.ActivityNotFoundException ex) {
	        Toast.makeText(WorkZone_K3.this, "Whatsapp have not been installed.", 1000).show();
	    }*/
	}	// WhatsAppShareImgK3
	
	public void KintentNew()
	{
		startActivity(new Intent(WorkZone_K3.this,WorkZone_K3.class));
		finish();
	}	// KintentNew

	public void IsPathVisibleK3() {
		if (path.getVisibility() == View.GONE) {
			path.setVisibility(View.VISIBLE);
		} else {
			path.setVisibility(View.GONE);
		}
	}	// IsPathVisibleK3
	
	public void gridSetUpK3(String FolNam , int pos)
	{
		/*
		for (int j = 1; j < 6; j++) 
		{
			 Drawable drawable = getResources().getDrawable(getResources().getIdentifier("d002_p00"+j, "drawable", getPackageName()));
		}
		*/
		
		/*String mDrawableName = "myimg";
		int resID = getResources().getIdentifier(mDrawableName , "drawable", getPackageName());*/
		
		relGrid.setVisibility(View.VISIBLE);
	
		switch (pos) {
		case 0:
			// 0 for "meme"
			adapter = new CustomGrid(WorkZone_K3.this, Fol1);
			grid.setAdapter(adapter);
			break;
			
		case 1:
			// 1 for "famous"
			adapter = new CustomGrid(WorkZone_K3.this, Fol2);
			grid.setAdapter(adapter);
			break;

		case 2:
			// 1 for "desi"
			adapter = new CustomGrid(WorkZone_K3.this, Fol3);
			grid.setAdapter(adapter);
			break;
			
		case 3:
			// 1 for "extra"
			adapter = new CustomGrid(WorkZone_K3.this, Fol4);
			grid.setAdapter(adapter);
			break;
			
		case 4:
			// 1 for "2gg"
			adapter = new CustomGrid(WorkZone_K3.this, Fol5);
			grid.setAdapter(adapter);
			break;
		default:
			break;
		}
		
		
		
	}	// gridSetUpK3
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		if(relGrid.getVisibility()==View.VISIBLE)
		{
			relGrid.setVisibility(View.GONE);
			relList.setVisibility(View.VISIBLE);
		}
		else if (relList.getVisibility()==View.VISIBLE) {
			relGrid.setVisibility(View.GONE);
			relList.setVisibility(View.GONE);
		}
		else
		{
			AlertDialog.Builder adb=new AlertDialog.Builder(WorkZone_K3.this); //alert for each time an item is pressed
	        adb.setTitle("Confirm Exit");
	        adb.setMessage("Wanna Exit BC ?");
	        adb.setNegativeButton("Cancel", null);
	        adb.setPositiveButton("Exit", new AlertDialog.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					 finish();
				}});
	        adb.show();
		}
	}	// onBackPressed
	
	
	public void alert2GGpasswordKroid(final String FolName , final int poss)
	{
		AlertDialog.Builder alertDialog = new AlertDialog.Builder(WorkZone_K3.this);

        // Setting Dialog Title
        alertDialog.setTitle("PASSWORD");

        // Setting Dialog Message
        alertDialog.setMessage("Enter Password");
        final EditText input = new EditText(WorkZone_K3.this);
        input.setHint("Password");
        input.setSingleLine(true);
        input.setTransformationMethod(PasswordTransformationMethod.getInstance());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                                LinearLayout.LayoutParams.MATCH_PARENT,
                                LinearLayout.LayoutParams.MATCH_PARENT);
          input.setLayoutParams(lp);
          alertDialog.setView(input);

        alertDialog.setPositiveButton("Ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        // Write your code here to execute after dialog
                    	if(input.getText().toString().equals("phusss"))
                    	{
                    		InputMethodManager imm = (InputMethodManager)getSystemService(
      						      Context.INPUT_METHOD_SERVICE);
      						imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
                    		folderName = FolName;
        					gridSetUpK3(FolName , poss);
        					relList.setVisibility(View.GONE);
        					dialog.cancel();
        					
                    	}
                    	else {
                    		InputMethodManager imm = (InputMethodManager)getSystemService(
      						      Context.INPUT_METHOD_SERVICE);
      						imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
                    		Toast.makeText(WorkZone_K3.this, "Wrong Password BC", Toast.LENGTH_SHORT).show();
                    		dialog.cancel();
                    	}
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to execute after dialog
                    	InputMethodManager imm = (InputMethodManager)getSystemService(
    						      Context.INPUT_METHOD_SERVICE);
    						imm.hideSoftInputFromWindow(input.getWindowToken(), 0);
                        dialog.cancel();
                    }
                });
        // Showing Alert Message
        alertDialog.show();
    }

}
