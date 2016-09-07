package com.qpy.inkcharm.views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.widget.Button;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qpy.inkcharm.R;
import com.qpy.inkcharm.models.InkCharm_Browse_Article_Item_Bean;
import com.qpy.inkcharm.models.InkCharm_My_Article_MyArticle_List_Item_Bean;
import com.qpy.inkcharm.models.InkCharm_My_Article_MyCollect_List_Item_Bean;
import com.qpy.inkcharm.models.InkCharm_My_Article_MyFriends_List_Item_Bean;
import com.qpy.inkcharm.tools.commom_adapter.CommonAdapter;
import com.qpy.inkcharm.tools.commom_adapter.ViewHolder;
import com.qpy.inkcharm.tools.viewpager_adapter.ViewPager_Adapter;

/**
 * Created by 鹏阳 on 2015/8/23.
 */
public class InkCharmActivity extends Activity {

    private List<View> ViewList;
    private List<String> TitleList;
    private PagerTabStrip PT_activity_inkcharm_my_article_title;
    private Button BT_activity_inkcharm_browse_article, BT_activity_inkcharm_my_article, BT_activity_inkcharm_setting;
    private PullToRefreshListView LV_activity_inkcharm_browse_article;
    private PullToRefreshListView LV_activity_inkcharm_my_article_myarticle_list, LV_activity_inkcharm_my_article_mycollect_list, LV_activity_inkcharm_my_article_myfriends_list;
    private LinearLayout LL_activity_inkcharm_browse_article, LL_activity_inkcharm_my_article, LL_activity_inkcharm_setting;
    private ViewPager VP_activity_inkcharm_my_article;
    private ImageButton IB_activity_inkcharm_my_article_myarticle_add_article;
    private Button BT_activity_inkcharm_setting_nightstyle_open, BT_activity_inkcharm_setting_nightstyle_close, BT_activity_inkcharm_setting_receivenews_open;
    private Button BT_activity_inkcharm_setting_receivenews_close, BT_activity_inkcharm_setting_receivenews_voice_open, BT_activity_inkcharm_setting_receivenews_voice_close;
    private Button BT_activity_inkcharm_setting_receivenews_shock_open, BT_activity_inkcharm_setting_receivenews_shock_close, BT_activity_inkcharm_setting_playnews_speaker_open, BT_activity_inkcharm_setting_playnews_speaker_close;
    private LinearLayout LL_activity_inkcharm_setting_receivenews_voice, LL_activity_inkcharm_setting_receivenews_shock;
    private LinearLayout LL_activity_inkcharm_setting_exit_app;
    private List<InkCharm_Browse_Article_Item_Bean> IBAI_Bean_Data = new ArrayList<InkCharm_Browse_Article_Item_Bean>();
    private List<InkCharm_My_Article_MyArticle_List_Item_Bean> IMAMALI_Bean_Data = new ArrayList<InkCharm_My_Article_MyArticle_List_Item_Bean>();
    private List<InkCharm_My_Article_MyCollect_List_Item_Bean> IMAMCLI_Bean_Data = new ArrayList<InkCharm_My_Article_MyCollect_List_Item_Bean>();
    private List<InkCharm_My_Article_MyFriends_List_Item_Bean> IMAMFLI_Bean_Data = new ArrayList<InkCharm_My_Article_MyFriends_List_Item_Bean>();
    private View LY_layout_inkcharm_my_article_myarticle_list, LY_layout_inkcharm_my_article_mycollect_list, LY_layout_inkcharm_my_article_myfriends_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inkcharm);

        Init_IBAI_Bean_Data();
        Init_IMAMALI_Bean_Data();
        Init_IMAMCLI_Bean_Data();
        Init_IMAMFLI_Bean_Data();
        Init_ViewPager();


        BT_activity_inkcharm_browse_article = (Button) findViewById(R.id.BT_activity_inkcharm_browse_article);
        BT_activity_inkcharm_my_article = (Button) findViewById(R.id.BT_activity_inkcharm_my_article);
        BT_activity_inkcharm_setting = (Button) findViewById(R.id.BT_activity_inkcharm_setting);

        LL_activity_inkcharm_browse_article = (LinearLayout) findViewById(R.id.LL_activity_inkcharm_browse_article);
        LL_activity_inkcharm_my_article = (LinearLayout) findViewById(R.id.LL_activity_inkcharm_my_article);
        LL_activity_inkcharm_setting = (LinearLayout) findViewById(R.id.LL_activity_inkcharm_setting);

        LL_activity_inkcharm_my_article = (LinearLayout) LL_activity_inkcharm_my_article.findViewById(R.id.LL_activity_inkcharm_my_article);
        LV_activity_inkcharm_my_article_myarticle_list = (PullToRefreshListView) LY_layout_inkcharm_my_article_myarticle_list.findViewById(R.id.LV_activity_inkcharm_my_article_myarticle_list);
        LV_activity_inkcharm_my_article_mycollect_list = (PullToRefreshListView) LY_layout_inkcharm_my_article_mycollect_list.findViewById(R.id.LV_activity_inkcharm_my_article_mycollect_list);
        LV_activity_inkcharm_my_article_myfriends_list = (PullToRefreshListView) LY_layout_inkcharm_my_article_myfriends_list.findViewById(R.id.LV_activity_inkcharm_my_article_myfriends_list);
        IB_activity_inkcharm_my_article_myarticle_add_article = (ImageButton) LY_layout_inkcharm_my_article_myarticle_list.findViewById(R.id.IB_activity_inkcharm_my_article_myarticle_add_article);


        LV_activity_inkcharm_browse_article = (PullToRefreshListView) findViewById(R.id.LV_activity_inkcharm_browse_article);

        VP_activity_inkcharm_my_article = (ViewPager) findViewById(R.id.VP_activity_inkcharm_my_article);

        BT_activity_inkcharm_setting_nightstyle_open = (Button) findViewById(R.id.BT_activity_inkcharm_setting_nightstyle_open);
        BT_activity_inkcharm_setting_nightstyle_close = (Button) findViewById(R.id.BT_activity_inkcharm_setting_nightstyle_close);
        BT_activity_inkcharm_setting_receivenews_open = (Button) findViewById(R.id.BT_activity_inkcharm_setting_receivenews_open);
        BT_activity_inkcharm_setting_receivenews_close = (Button) findViewById(R.id.BT_activity_inkcharm_setting_receivenews_close);
        BT_activity_inkcharm_setting_receivenews_voice_open = (Button) findViewById(R.id.BT_activity_inkcharm_setting_receivenews_voice_open);
        BT_activity_inkcharm_setting_receivenews_voice_close = (Button) findViewById(R.id.BT_activity_inkcharm_setting_receivenews_voice_close);
        BT_activity_inkcharm_setting_receivenews_shock_open = (Button) findViewById(R.id.BT_activity_inkcharm_setting_receivenews_shock_open);
        BT_activity_inkcharm_setting_receivenews_shock_close = (Button) findViewById(R.id.BT_activity_inkcharm_setting_receivenews_shock_close);
        BT_activity_inkcharm_setting_playnews_speaker_open = (Button) findViewById(R.id.BT_activity_inkcharm_setting_playnews_speaker_open);
        BT_activity_inkcharm_setting_playnews_speaker_close = (Button) findViewById(R.id.BT_activity_inkcharm_setting_playnews_speaker_close);

        LL_activity_inkcharm_setting_receivenews_voice = (LinearLayout) findViewById(R.id.LL_activity_inkcharm_setting_receivenews_voice);
        LL_activity_inkcharm_setting_receivenews_shock = (LinearLayout) findViewById(R.id.LL_activity_inkcharm_setting_receivenews_shock);

        LL_activity_inkcharm_setting_exit_app = (LinearLayout) findViewById(R.id.LL_activity_inkcharm_setting_exit_app);

        PT_activity_inkcharm_my_article_title = (PagerTabStrip) findViewById(R.id.PT_activity_inkcharm_my_article_title);

        BT_activity_inkcharm_browse_article.setEnabled(true);
        BT_activity_inkcharm_browse_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_browse_article.setBackgroundColor(getResources().getColor(R.color.InkCharm_Borwse_Article_Button_BLUE));
                BT_activity_inkcharm_my_article.setBackgroundColor(Color.TRANSPARENT);
                BT_activity_inkcharm_setting.setBackgroundColor(Color.TRANSPARENT);
                LL_activity_inkcharm_browse_article.setVisibility(View.VISIBLE);
                LL_activity_inkcharm_my_article.setVisibility(View.GONE);
                LL_activity_inkcharm_setting.setVisibility(View.GONE);
            }
        });
        BT_activity_inkcharm_my_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_my_article.setBackgroundColor(getResources().getColor(R.color.InkCharm_Borwse_Article_Button_BLUE));
                BT_activity_inkcharm_browse_article.setBackgroundColor(Color.TRANSPARENT);
                BT_activity_inkcharm_setting.setBackgroundColor(Color.TRANSPARENT);
                LL_activity_inkcharm_browse_article.setVisibility(View.GONE);
                LL_activity_inkcharm_my_article.setVisibility(View.VISIBLE);
                LL_activity_inkcharm_setting.setVisibility(View.GONE);
            }
        });
        BT_activity_inkcharm_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_setting.setBackgroundColor(getResources().getColor(R.color.InkCharm_Borwse_Article_Button_BLUE));
                BT_activity_inkcharm_browse_article.setBackgroundColor(Color.TRANSPARENT);
                BT_activity_inkcharm_my_article.setBackgroundColor(Color.TRANSPARENT);
                LL_activity_inkcharm_browse_article.setVisibility(View.GONE);
                LL_activity_inkcharm_my_article.setVisibility(View.GONE);
                LL_activity_inkcharm_setting.setVisibility(View.VISIBLE);
            }
        });

        BT_activity_inkcharm_setting_nightstyle_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_setting_nightstyle_close.setVisibility(View.VISIBLE);
                BT_activity_inkcharm_setting_nightstyle_open.setVisibility(View.GONE);
            }
        });
        BT_activity_inkcharm_setting_nightstyle_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_setting_nightstyle_close.setVisibility(View.GONE);
                BT_activity_inkcharm_setting_nightstyle_open.setVisibility(View.VISIBLE);
            }
        });
        BT_activity_inkcharm_setting_receivenews_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_setting_receivenews_open.setVisibility(View.GONE);
                BT_activity_inkcharm_setting_receivenews_close.setVisibility(View.VISIBLE);
                LL_activity_inkcharm_setting_receivenews_voice.setVisibility(View.GONE);
                LL_activity_inkcharm_setting_receivenews_shock.setVisibility(View.GONE);
            }
        });
        BT_activity_inkcharm_setting_receivenews_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_setting_receivenews_open.setVisibility(View.VISIBLE);
                BT_activity_inkcharm_setting_receivenews_close.setVisibility(View.GONE);
                LL_activity_inkcharm_setting_receivenews_voice.setVisibility(View.VISIBLE);
                LL_activity_inkcharm_setting_receivenews_shock.setVisibility(View.VISIBLE);
            }
        });
        BT_activity_inkcharm_setting_receivenews_voice_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_setting_receivenews_voice_open.setVisibility(View.GONE);
                BT_activity_inkcharm_setting_receivenews_voice_close.setVisibility(View.VISIBLE);
            }
        });
        BT_activity_inkcharm_setting_receivenews_voice_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_setting_receivenews_voice_open.setVisibility(View.VISIBLE);
                BT_activity_inkcharm_setting_receivenews_voice_close.setVisibility(View.GONE);
            }
        });
        BT_activity_inkcharm_setting_receivenews_shock_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_setting_receivenews_shock_open.setVisibility(View.GONE);
                BT_activity_inkcharm_setting_receivenews_shock_close.setVisibility(View.VISIBLE);
            }
        });
        BT_activity_inkcharm_setting_receivenews_shock_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_setting_receivenews_shock_open.setVisibility(View.VISIBLE);
                BT_activity_inkcharm_setting_receivenews_shock_close.setVisibility(View.GONE);
            }
        });
        BT_activity_inkcharm_setting_playnews_speaker_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_setting_playnews_speaker_open.setVisibility(View.GONE);
                BT_activity_inkcharm_setting_playnews_speaker_close.setVisibility(View.VISIBLE);
            }
        });
        BT_activity_inkcharm_setting_playnews_speaker_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BT_activity_inkcharm_setting_playnews_speaker_open.setVisibility(View.VISIBLE);
                BT_activity_inkcharm_setting_playnews_speaker_close.setVisibility(View.GONE);
            }
        });
        LL_activity_inkcharm_setting_exit_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        LV_activity_inkcharm_browse_article.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new GetDataTask(refreshView).execute();
            }
        });
        LV_activity_inkcharm_my_article_myarticle_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new GetDataTask(refreshView).execute();
            }
        });
        LV_activity_inkcharm_my_article_mycollect_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new GetDataTask(refreshView).execute();
            }
        });
        LV_activity_inkcharm_my_article_myfriends_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                new GetDataTask(refreshView).execute();
            }
        });
        LV_activity_inkcharm_browse_article.setAdapter(new CommonAdapter<InkCharm_Browse_Article_Item_Bean>(getApplicationContext(), IBAI_Bean_Data, R.layout.layout_inkcharm_browse_article_item) {
            @Override
            public void convert(ViewHolder helper, final InkCharm_Browse_Article_Item_Bean item) {
                helper.setImageResource(R.id.IB_layout_inkcharm_browse_article_ImageIcon, item.getImageRId());
                helper.getView(R.id.IB_layout_inkcharm_browse_article_ImageIcon).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(InkCharmActivity.this,InkCharm_Add_Article.class);
                        startActivity(intent);
                    }
                });
                helper.setText(R.id.TV_layout_inkcharm_browse_article_UserName, item.getUserName());
                helper.setText(R.id.TV_layout_inkcharm_browse_article_ArticleName, item.getArticleName());
                helper.setText(R.id.TV_layout_inkcharm_browse_article_ArticleContent, item.getArticleContent());
                helper.getView(R.id.LL_layout_inkcharm_borwse_article_item_linearlayout).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setClass(InkCharmActivity.this, InkCharm_Borwse_Article_Activity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("UserHead", item.getImageRId());
                        bundle.putString("UserName", item.getUserName());
                        bundle.putString("ArticleName", item.getArticleName());
                        bundle.putString("ArticleContent", item.getArticleContent());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
        });
        LV_activity_inkcharm_my_article_myarticle_list.setAdapter(new CommonAdapter<InkCharm_My_Article_MyArticle_List_Item_Bean>(getApplicationContext(), IMAMALI_Bean_Data, R.layout.layout_inkcharm_my_article_myarticle_item) {
            @Override
            public void convert(ViewHolder helper, final InkCharm_My_Article_MyArticle_List_Item_Bean item) {
                helper.setText(R.id.layout_inkcharm_my_article_myarticle_item_ArticleName, item.getArticleName());
                helper.setText(R.id.layout_inkcharm_my_article_myarticle_item_ArticleContent, item.getArticleContent());
                helper.setText(R.id.layout_inkcharm_my_article_myarticle_item_ReprintNum, item.getReprintNum());
                helper.setText(R.id.layout_inkcharm_my_article_myarticle_item_CollectNum, item.getCollectNum());
                helper.getView(R.id.layout_inkcharm_my_article_myarticle_item).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(InkCharmActivity.this, InkCharm_My_Article_MyArticle_Activity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("ArticleTitle", item.getArticleName());
                        bundle.putString("Article", item.getArticleContent());
                        bundle.putString("ReprintNum", item.getReprintNum());
                        bundle.putString("CollectNum", item.getCollectNum());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
        });
        LV_activity_inkcharm_my_article_mycollect_list.setAdapter(new CommonAdapter<InkCharm_My_Article_MyCollect_List_Item_Bean>(getApplicationContext(), IMAMCLI_Bean_Data, R.layout.layout_inkcharm_my_article_mycollect_item) {
            @Override
            public void convert(ViewHolder helper,final InkCharm_My_Article_MyCollect_List_Item_Bean item) {
                helper.setText(R.id.layout_inkcharm_my_article_mycollect_item_ArticleName, item.getArticle_Name());
                helper.setText(R.id.layout_inkcharm_my_article_mycollect_item_ArticleContent, item.getArticle_Content());
                helper.setText(R.id.layout_inkcharm_my_article_mycollect_item_AuthorName, item.getAuthor_Name());
                helper.getView(R.id.LL_layout_inkcharm_my_article_mycollect_item).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(InkCharmActivity.this, InkCharm_My_Article_MyCollect_Activity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("UserName", item.getAuthor_Name());
                        bundle.putString("ArticleName", item.getArticle_Name());
                        bundle.putString("ArticleContent", item.getArticle_Content());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
        });
        LV_activity_inkcharm_my_article_myfriends_list.setAdapter(new CommonAdapter<InkCharm_My_Article_MyFriends_List_Item_Bean>(getApplicationContext(), IMAMFLI_Bean_Data, R.layout.layout_inkcharm_my_article_myfriends_item) {
            @Override
            public void convert(ViewHolder helper,final InkCharm_My_Article_MyFriends_List_Item_Bean item) {
                helper.setText(R.id.layout_inkcharm_my_article_myfriends_item_FriendsName, item.getFriendsName());
                helper.setText(R.id.layout_inkcharm_my_article_myfriends_item_FriendsWord, item.getFreiendsWord());
                helper.setImageResource(R.id.layout_inkcharm_my_article_myfriends_item_FriendsHead, item.getFriendsHeadRId());
                helper.getView(R.id.LL_layout_inkcharm_my_article_myfriends_item).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.setClass(InkCharmActivity.this, InkCharm_Personal_Page_Activity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("FriendsName", item.getFriendsName());
                        bundle.putString("FreiendsWord", item.getFreiendsWord());
                        bundle.putInt("FriendsHeadRId", item.getFriendsHeadRId());
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }
                });
            }
        });
        PT_activity_inkcharm_my_article_title.setBackgroundColor(Color.WHITE);
        PT_activity_inkcharm_my_article_title.setTabIndicatorColor(Color.BLACK);
        PT_activity_inkcharm_my_article_title.setDrawFullUnderline(false);
        PT_activity_inkcharm_my_article_title.setTextColor(Color.BLACK);

        ViewPager_Adapter adapter = new ViewPager_Adapter(ViewList,TitleList);//初始化适配器
        VP_activity_inkcharm_my_article.setAdapter(adapter);

        IB_activity_inkcharm_my_article_myarticle_add_article.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InkCharmActivity.this,InkCharm_Add_Article.class);
                startActivity(intent);
            }
        });
    }

    private void Init_IBAI_Bean_Data() {
        InkCharm_Browse_Article_Item_Bean IBAI_Bean = null;
        for (int i = 0; i <= 1000; i++) {
            IBAI_Bean = new InkCharm_Browse_Article_Item_Bean(R.drawable.inkcharm_test_image, getResources().getString(R.string.InkCharm_Browse_Article_Test_UserName),
                    getResources().getString(R.string.InkCharm_Browse_Article_Test_ArticleName), getResources().getString(R.string.InkCharm_Browse_Article_Test_ArticleContent));
            IBAI_Bean_Data.add(IBAI_Bean);
        }
    }

    private void Init_IMAMALI_Bean_Data() {
        InkCharm_My_Article_MyArticle_List_Item_Bean IMAMALI_Bean = null;
        for (int i = 0; i <= 10; i++) {
            IMAMALI_Bean = new InkCharm_My_Article_MyArticle_List_Item_Bean(getResources().getString(R.string.InkCharm_Browse_Article_Test_ArticleName), getResources().getString(R.string.InkCharm_Browse_Article_Test_ArticleContent), "20", "20");
            IMAMALI_Bean_Data.add(IMAMALI_Bean);
        }
    }

    private void Init_IMAMCLI_Bean_Data() {
        InkCharm_My_Article_MyCollect_List_Item_Bean IMAMCLI_Bean = null;
        for (int i = 0; i <= 10; i++) {
            IMAMCLI_Bean = new InkCharm_My_Article_MyCollect_List_Item_Bean(getResources().getString(R.string.InkCharm_Browse_Article_Test_ArticleName), getResources().getString(R.string.InkCharm_Browse_Article_Test_ArticleContent), getResources().getString(R.string.InkCharm_Browse_Article_Test_UserName));
            IMAMCLI_Bean_Data.add(IMAMCLI_Bean);
        }
    }

    private void Init_IMAMFLI_Bean_Data() {
        InkCharm_My_Article_MyFriends_List_Item_Bean IMAMFLI_Bean = null;
        for (int i = 0; i <= 10; i++) {
            IMAMFLI_Bean = new InkCharm_My_Article_MyFriends_List_Item_Bean(getResources().getString(R.string.InkCharm_Browse_Article_Test_UserName), getResources().getString(R.string.InkCharm_Browse_Article_Test_UserWord), R.drawable.inkcharm_test_image);
            IMAMFLI_Bean_Data.add(IMAMFLI_Bean);
        }
    }

    protected void Init_ViewPager() {
        TitleList=new ArrayList<String>();
        TitleList.add("我的文章");
        TitleList.add("我的收藏");
        TitleList.add("我的好友");

        LY_layout_inkcharm_my_article_myarticle_list = View.inflate(this, R.layout.layout_inkcharm_my_article_myarticle_list, null);
        LY_layout_inkcharm_my_article_mycollect_list = View.inflate(this, R.layout.layout_inkcharm_my_article_mycollect_list, null);
        LY_layout_inkcharm_my_article_myfriends_list = View.inflate(this, R.layout.layout_inkcharm_my_article_myfriends_list, null);

        ViewList = new ArrayList<View>();
        ViewList.add(LY_layout_inkcharm_my_article_myarticle_list);
        ViewList.add(LY_layout_inkcharm_my_article_mycollect_list);
        ViewList.add(LY_layout_inkcharm_my_article_myfriends_list);
    }
    private static class GetDataTask extends AsyncTask<Void, Void, Void> {

        PullToRefreshBase<?> mRefreshedView;

        public GetDataTask(PullToRefreshBase<?> refreshedView) {
            mRefreshedView = refreshedView;
        }

        @Override
        protected Void doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            mRefreshedView.onRefreshComplete();
            super.onPostExecute(result);
        }
    }
}
