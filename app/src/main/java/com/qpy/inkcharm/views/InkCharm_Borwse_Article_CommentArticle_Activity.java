package com.qpy.inkcharm.views;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.qpy.inkcharm.R;
import com.qpy.inkcharm.models.InkCharm_Borwse_Article_CommentArticle_List_Bean;
import com.qpy.inkcharm.tools.commom_adapter.CommonAdapter;
import com.qpy.inkcharm.tools.commom_adapter.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 鹏阳 on 2015/9/7.
 */
public class InkCharm_Borwse_Article_CommentArticle_Activity extends Activity {
    ListView LV_activity_inkcharm_borwse_commentArticle;
    Button BT_activity_inkcharm_borwse_commentArticle_Back,BT_activity_inkcharm_borwse_CommentArticle_GetComment;
    EditText ET_activity_inkcharm_borwse_CommentArticle_GetComment;

    List<InkCharm_Borwse_Article_CommentArticle_List_Bean> IBACAL_Bean_Data = new ArrayList<InkCharm_Borwse_Article_CommentArticle_List_Bean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inkcharm_browse_article_commentarticle);

        Init_IMAMFLI_Bean_Data();

        LV_activity_inkcharm_borwse_commentArticle = (ListView) findViewById(R.id.LV_activity_inkcharm_borwse_commentArticle);

        BT_activity_inkcharm_borwse_commentArticle_Back = (Button) findViewById(R.id.BT_activity_inkcharm_borwse_commentArticle_Back);
        BT_activity_inkcharm_borwse_CommentArticle_GetComment = (Button)findViewById(R.id.BT_activity_inkcharm_borwse_CommentArticle_GetComment);

        ET_activity_inkcharm_borwse_CommentArticle_GetComment = (EditText)findViewById(R.id.ET_activity_inkcharm_borwse_CommentArticle_GetComment);

        BT_activity_inkcharm_borwse_commentArticle_Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        LV_activity_inkcharm_borwse_commentArticle.setAdapter(new CommonAdapter<InkCharm_Borwse_Article_CommentArticle_List_Bean>(getApplicationContext(), IBACAL_Bean_Data, R.layout.layout_inkcharm_browse_article_commentarticle_item) {
            @Override
            public void convert(ViewHolder helper, InkCharm_Borwse_Article_CommentArticle_List_Bean item) {
                helper.setImageResource(R.id.CI_layout_inkcharm_browse_article_commentarticle_UserHead, item.getUserHeadRId());
                helper.setText(R.id.TV_layout_inkcharm_browse_article_commentarticle_UserName, item.getUserName());
                helper.setText(R.id.TV_layout_inkcharm_browse_article_commentarticle_UserComment, item.getUserComment());
                this.notifyDataSetChanged();
            }
        });

        BT_activity_inkcharm_borwse_CommentArticle_GetComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add_Init_IMAMFLI_Bean_Data();
                LV_activity_inkcharm_borwse_commentArticle.setTranscriptMode(ListView.TRANSCRIPT_MODE_ALWAYS_SCROLL);
            }
        });
    }

    private void Init_IMAMFLI_Bean_Data() {
        InkCharm_Borwse_Article_CommentArticle_List_Bean IBACAL_Bean = null;
        for (int i = 0; i <= 10; i++) {
            IBACAL_Bean = new InkCharm_Borwse_Article_CommentArticle_List_Bean(R.drawable.inkcharm_test_image, getResources().getString(R.string.InkCharm_Browse_Article_Test_UserName), getResources().getString(R.string.InkCharm_Browse_Article_Test_UserWord));
            IBACAL_Bean_Data.add(IBACAL_Bean);
        }
    }
    private void Add_Init_IMAMFLI_Bean_Data() {
        InkCharm_Borwse_Article_CommentArticle_List_Bean IBACAL_Bean = null;
        String a = ET_activity_inkcharm_borwse_CommentArticle_GetComment.getText().toString();
        IBACAL_Bean = new InkCharm_Borwse_Article_CommentArticle_List_Bean(R.drawable.inkcharm_test_image, getResources().getString(R.string.InkCharm_Browse_Article_Test_UserName),a);
        IBACAL_Bean_Data.add(IBACAL_Bean);
    }
}
