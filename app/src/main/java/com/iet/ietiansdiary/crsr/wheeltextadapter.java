package com.iet.ietiansdiary.crsr;

import android.content.Context;
import android.support.v4.app.ActivityCompat;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.iet.ietiansdiary.R;

import java.util.List;

import github.hellocsl.cursorwheel.CursorWheelLayout;

public class wheeltextadapter extends CursorWheelLayout.CycleWheelAdapter {

    private Context context;
    private List<MenuItemData> menuItems;
    private LayoutInflater inflater;
    private int gravity;
    private int size=14;

    public wheeltextadapter(Context context, List<MenuItemData> menuItems) {
        this.context = context;
        this.menuItems = menuItems;
        gravity= Gravity.CENTER;
        inflater=LayoutInflater.from(context);
    }

    public wheeltextadapter(Context context, List<MenuItemData> menuItems, int gravity) {
        this.context = context;
        this.menuItems = menuItems;
        this.gravity = gravity;
    }

    @Override
    public int getCount() {
        return menuItems.size();

    }

    @Override
    public View getView(View parent, int position) {
        MenuItemData itemData=getItem(position);
        View root=inflater.inflate(R.layout.wheel_layout,null,false);
        TextView textView=(TextView) root.findViewById(R.id.wheel_menu_item);
        textView.setVisibility(parent.VISIBLE);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        textView.setText(itemData.mtitle);
        if(textView.getLayoutParams() instanceof FrameLayout.LayoutParams)((FrameLayout.LayoutParams)textView.getLayoutParams()).gravity=gravity;
        if(position==0) {
            textView.setTextColor(ActivityCompat.getColor(context, R.color.textColorPrimary));
            textView.setTextSize(size);
        }

        if(position==1) {
            textView.setTextColor(ActivityCompat.getColor(context, R.color.textColorPrimary));
            textView.setTextSize(size);
        }

        if(position==2) {
            textView.setTextColor(ActivityCompat.getColor(context, R.color.textColorPrimary));
            textView.setTextSize(size);
        }

        if(position==3) {
            textView.setTextColor(ActivityCompat.getColor(context, R.color.textColorPrimary));
            textView.setTextSize(size);
        }

        if(position==4) {
            textView.setTextColor(ActivityCompat.getColor(context, R.color.textColorPrimary));
            textView.setTextSize(size);
        }

        return root;

    }

    @Override
    public MenuItemData getItem(int position) {
        return menuItems.get(position);
    }
}
