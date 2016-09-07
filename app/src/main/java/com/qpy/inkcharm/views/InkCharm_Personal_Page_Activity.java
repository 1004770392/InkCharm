package com.qpy.inkcharm.views;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.qpy.inkcharm.R;
import com.qpy.inkcharm.tools.Blur.BlurBitmap;
import com.qpy.inkcharm.tools.round_icon.CircularImage;

/**
 * Created by 孤箫残月 on 2016/9/3.
 */
public class InkCharm_Personal_Page_Activity extends Activity{

    ImageView IV_activity_inkcharm_personal_page_UserImage_BG;
    CircularImage CI_activity_inkcharm_personal_page_UserImage;
    TextView TV_activity_inkcharm_personal_page_UserName,TV_activity_inkcharm_personal_page_UserWord;
    int IV_activity_inkcharm_personal_page_UserImage_BG_High,IV_activity_inkcharm_personal_page_UserImage_BG_Width;


    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inkcharm_personal_page);

        IV_activity_inkcharm_personal_page_UserImage_BG = (ImageView) findViewById(R.id.IV_activity_inkcharm_personal_page_UserImage_BG);
        CI_activity_inkcharm_personal_page_UserImage = (CircularImage) findViewById(R.id.CI_activity_inkcharm_personal_page_UserImage);
        TV_activity_inkcharm_personal_page_UserName = (TextView) findViewById(R.id.TV_activity_inkcharm_personal_page_UserName);
        TV_activity_inkcharm_personal_page_UserWord = (TextView) findViewById(R.id.TV_activity_inkcharm_personal_page_UserWord);

        DataTransmission();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void DataTransmission() {
        Bundle bundle = this.getIntent().getExtras();
        String FriendsName = bundle.getString("FriendsName");
        String FreiendsWord = bundle.getString("FreiendsWord");
        int FriendsHeadRId = bundle.getInt("FriendsHeadRId");

        Drawable drawable = getDrawable(FriendsHeadRId);


        BitmapDrawable bd = (BitmapDrawable) drawable;
        Bitmap bitmap = bd.getBitmap();

        Bitmap bitmap1 = BlurBitmap.blur(InkCharm_Personal_Page_Activity.this,bitmap);


        IV_activity_inkcharm_personal_page_UserImage_BG.setImageBitmap(bitmap1);
        CI_activity_inkcharm_personal_page_UserImage.setImageResource(FriendsHeadRId);
        TV_activity_inkcharm_personal_page_UserName.setText(FriendsName);
        TV_activity_inkcharm_personal_page_UserWord.setText(FreiendsWord);
    }
}
