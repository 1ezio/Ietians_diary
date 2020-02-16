package com.iet.ietiansdiary.navigation_activities.developers;

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

public class dev_adapter extends RecyclerView.Adapter<dev_adapter.ViewHolder> {
    private List<list_data> list_data;
    private Context ct;

    public dev_adapter(List<list_data> list_data, Context ct) {
        this.list_data = list_data;
        this.ct = ct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_data,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        list_data ld=list_data.get(position);
        holder.tvname.setText(ld.getName());
        Picasso.with(ct)
                .load(ld.getImgUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView tvname;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView=(ImageView)itemView.findViewById(R.id.img_view);
            tvname=(TextView)itemView.findViewById(R.id.uName);
        }
    }
}
