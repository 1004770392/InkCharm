package com.qpy.inkcharm.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.qpy.inkcharm.R;

/**
 * Created by 孤箫残月 on 2016/9/2.
 */
public class InkCharm_My_Article_MyArticle_Activity extends Activity{
    private TextView TV_activity_inkcharm_browse_myarticle_my_article_ArticleTitle,TV_activity_inkcharm_browse_myarticle_my_article_Article,TV_activity_inkcharm_browse_myarticle_my_article_Article_ReprintNum,TV_activity_inkcharm_browse_myarticle_my_article_Article_CollectNum;
    private Button BT_activity_inkcharm_browse_myarticle_my_article_Back;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inkcharm_browse_my_article_myarticle);

        TV_activity_inkcharm_browse_myarticle_my_article_ArticleTitle = (TextView)findViewById(R.id.TV_activity_inkcharm_browse_myarticle_my_article_ArticleTitle);
        TV_activity_inkcharm_browse_myarticle_my_article_Article = (TextView)findViewById(R.id.TV_activity_inkcharm_browse_myarticle_my_article_Article);
        TV_activity_inkcharm_browse_myarticle_my_article_Article_ReprintNum = (TextView)findViewById(R.id.TV_activity_inkcharm_browse_myarticle_my_article_Article_ReprintNum);
        TV_activity_inkcharm_browse_myarticle_my_article_Article_CollectNum = (TextView)findViewById(R.id.TV_activity_inkcharm_browse_myarticle_my_article_Article_CollectNum);

        BT_activity_inkcharm_browse_myarticle_my_article_Back = (Button)findViewById(R.id.BT_activity_inkcharm_browse_myarticle_my_article_Back);

        DataTransmission();
    }
    private void DataTransmission() {
        Bundle bundle = this.getIntent().getExtras();
        String ArticleTitle = bundle.getString("ArticleTitle");
        String Article = bundle.getString("Article");
        String ReprintNum = bundle.getString("ReprintNum");
        String CollectNum = bundle.getString("CollectNum");

        TV_activity_inkcharm_browse_myarticle_my_article_ArticleTitle.setText(ArticleTitle);
        TV_activity_inkcharm_browse_myarticle_my_article_Article.setText(Article);
        TV_activity_inkcharm_browse_myarticle_my_article_Article_ReprintNum.setText(ReprintNum);
        TV_activity_inkcharm_browse_myarticle_my_article_Article_CollectNum.setText(CollectNum);
    }
}
