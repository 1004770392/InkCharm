package com.qpy.inkcharm.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.qpy.inkcharm.R;

/**
 * Created by 孤箫残月 on 2016/9/2.
 */
public class InkCharm_My_Article_MyCollect_Activity extends Activity{
    private TextView TV_activity_inkcharm_browse_myarticle_my_collect_ArticleName,TV_activity_inkcharm_browse_myarticle_my_collect_ArticleContent,TV_activity_inkcharm_browse_myarticle_my_collect_UserName;
    private Button BT_activity_inkcharm_browse_myarticle_my_collect_Back,BT_activity_inkcharm_browse_myarticle_my_collect_ReprintArticle,BT_activity_inkcharm_browse_myarticle_my_collect_ShareArticle;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inkcharm_browse_my_article_mycollect);

        TV_activity_inkcharm_browse_myarticle_my_collect_UserName = (TextView)findViewById(R.id.TV_activity_inkcharm_browse_myarticle_my_collect_UserName);
        TV_activity_inkcharm_browse_myarticle_my_collect_ArticleName = (TextView)findViewById(R.id.TV_activity_inkcharm_browse_myarticle_my_collect_ArticleName);
        TV_activity_inkcharm_browse_myarticle_my_collect_ArticleContent  = (TextView)findViewById(R.id.TV_activity_inkcharm_browse_myarticle_my_collect_ArticleContent);

        DataTransmission();

    }
    private void DataTransmission() {
        Bundle bundle = this.getIntent().getExtras();
        String UserName = bundle.getString("UserName");
        String ArticleName = bundle.getString("ArticleName");
        String ArticleContent = bundle.getString("ArticleContent");

        TV_activity_inkcharm_browse_myarticle_my_collect_UserName.setText(UserName);
        TV_activity_inkcharm_browse_myarticle_my_collect_ArticleName.setText(ArticleName);
        TV_activity_inkcharm_browse_myarticle_my_collect_ArticleContent.setText(ArticleContent);
    }
}
