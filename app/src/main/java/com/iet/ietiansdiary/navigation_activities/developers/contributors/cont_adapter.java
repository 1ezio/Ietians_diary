package com.iet.ietiansdiary.navigation_activities.developers.contributors;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.iet.ietiansdiary.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class cont_adapter extends RecyclerView.Adapter<cont_adapter.ViewHolder> {

    private List<clist_data> clist_data;
    private Context ct;

    public cont_adapter(List<clist_data> clist_data, Context ct) {
        this.clist_data = clist_data;
        this.ct = ct;
    }
    @NonNull
    @Override
    public cont_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.clist_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        clist_data ld=clist_data.get(i);
        viewHolder.ctvname.setText(ld.getName());
        Picasso.with(ct)
                .load(ld.getImgUrl())
                .into(viewHolder.cimageView);
    }

    @Override
    public int getItemCount() {
        return clist_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView cimageView;
        private TextView ctvname;
        public ViewHolder(View itemView) {
            super(itemView);
            cimageView=(ImageView)itemView.findViewById(R.id.cimg_view);
            ctvname=(TextView)itemView.findViewById(R.id.cuName);
        }
    }

    }



