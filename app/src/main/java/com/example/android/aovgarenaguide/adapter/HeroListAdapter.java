package com.example.android.aovgarenaguide.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.aovgarenaguide.R;
import com.example.android.aovgarenaguide.activity.detail_hero.DetailHeroActivity;
import com.example.android.aovgarenaguide.model.select_hero.ResultItem;
import com.example.android.aovgarenaguide.util.Utility;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DITHA on 16/09/2017.
 */

public class HeroListAdapter extends RecyclerView.Adapter<HeroListAdapter.HeroListViewHolder> {

    private List<ResultItem> resultItems;
    private Activity activity;

    public HeroListAdapter(List<ResultItem> resultItems, Activity activity) {
        this.resultItems = resultItems;
        this.activity = activity;
    }

    @Override
    public HeroListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hero_list, parent, false);
        HeroListViewHolder viewHolder = new HeroListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(HeroListViewHolder holder, int position) {
        ResultItem item = resultItems.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return resultItems.size();
    }

    public void setData(List<ResultItem> datas){
        this.resultItems.clear();
        resultItems.addAll(datas);
        notifyDataSetChanged();
    }

    static class HeroListViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.img_select_hero) ImageView IMG_SELECT_HERO;
        @BindView(R.id.tv_hero_name) TextView TV_HERO_NAME;

        public HeroListViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bind(final ResultItem item){
            Glide.with(itemView.getContext()).load(Utility.URL_IMG_HERO + item.getRoleHero() +"/" + item.getImgHero()).into(IMG_SELECT_HERO);
            TV_HERO_NAME.setText(item.getHeroName());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent in = new Intent(itemView.getContext(), DetailHeroActivity.class);
                    in.putExtra(Utility.KEY_INTENT_HERO_DETAIL, item);
                    itemView.getContext().startActivity(in);
                }
            });
        }
    }
}
