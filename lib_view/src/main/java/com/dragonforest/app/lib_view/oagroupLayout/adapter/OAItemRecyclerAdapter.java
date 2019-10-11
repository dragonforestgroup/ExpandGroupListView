package com.dragonforest.app.lib_view.oagroupLayout.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dragonforest.app.lib_view.R;
import com.dragonforest.app.lib_view.oagroupLayout.bean.OAItem;

import java.util.List;

/**
 * @author 韩龙林
 * @date 2019/10/10 20:14
 */
public class OAItemRecyclerAdapter extends RecyclerView.Adapter {
    private List<OAItem> list;
    private Context context;

    OARecyclerViewItemClickListener oARecyclerViewItemClickListener;

    public OAItemRecyclerAdapter(Context context, List<OAItem> list) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.libview_item_oa,viewGroup,false);
        OAItemViewHolder oaItemViewHolder=new OAItemViewHolder(v);
        return oaItemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((OAItemViewHolder)viewHolder).bind(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setData(List<OAItem> list){
        this.list=list;
        notifyDataSetChanged();
    }

    class OAItemViewHolder extends RecyclerView.ViewHolder{
        View view;
        ImageView img_oa_icon;
        TextView tv_oa_name;
        public OAItemViewHolder(@NonNull View itemView) {
            super(itemView);
            view=itemView;
            img_oa_icon=itemView.findViewById(R.id.img_oa_icon);
            tv_oa_name=itemView.findViewById(R.id.tv_oa_name);
        }
        public void bind(final int pos){
            img_oa_icon.setImageResource(list.get(pos).getImgId());
            tv_oa_name.setText(list.get(pos).getOaName());
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(oARecyclerViewItemClickListener!=null){
                        oARecyclerViewItemClickListener.onItemClick(list.get(pos));
                    }
                }
            });
        }
    }

    public void setoARecyclerViewItemClickListener(OARecyclerViewItemClickListener oARecyclerViewItemClickListener) {
        this.oARecyclerViewItemClickListener = oARecyclerViewItemClickListener;
    }

    public interface OARecyclerViewItemClickListener{
        void onItemClick(OAItem oaItem);
    }
}
