package com.qpy.inkcharm.tools.viewpager_adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 孤箫残月 on 2016/9/2.
 */
public class ViewPager_Adapter extends PagerAdapter {

    private List<View> viewList;
    private List<String> viewTag;

    public ViewPager_Adapter(List<View> viewList,List<String> viewTag)
    {
        this.viewList = viewList;
        this.viewTag = viewTag;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return viewList.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        // TODO Auto-generated method stub
        return arg0==arg1;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // TODO Auto-generated method stub
        container.addView(viewList.get(position));
        return viewList.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // TODO Auto-generated method stub
        container.removeView(viewList.get(position));
    }
    @Override
    public CharSequence getPageTitle(int position) {
        // TODO Auto-generated method stub
        return viewTag.get(position);
    }

}
