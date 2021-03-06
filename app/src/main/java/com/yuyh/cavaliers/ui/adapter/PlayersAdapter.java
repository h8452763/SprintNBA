package com.yuyh.cavaliers.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yuyh.cavaliers.R;
import com.yuyh.cavaliers.http.bean.player.Players;
import com.yuyh.cavaliers.utils.FrescoUtils;
import com.yuyh.library.view.list.indexablelistview.IndexableAdapter;


/**
 * Created by YoKeyword on 16/3/20.
 */
public class PlayersAdapter extends IndexableAdapter<Players.Player> {
    private Context mContext;

    public PlayersAdapter(Context context) {
        mContext = context;
    }

    @Override
    protected TextView onCreateTitleViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tv_title_city, parent, false);
        return (TextView) view.findViewById(R.id.tv_title);
    }

    @Override
    protected ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_list_teams, parent, false);
        return new PlayersHolder(view);
    }

    @Override
    protected void onBindViewHolder(ViewHolder holder, Players.Player entity) {
        PlayersHolder playersHolder = (PlayersHolder) holder;
        playersHolder.tvName.setText(entity.getName());
        playersHolder.ivHead.setController(FrescoUtils.getController(Uri.parse(entity.icon), playersHolder.ivHead));
    }


    class PlayersHolder extends IndexableAdapter.ViewHolder {
        TextView tvName;
        SimpleDraweeView ivHead;

        public PlayersHolder(View view) {
            super(view);
            tvName = (TextView) view.findViewById(R.id.tvTeamFullName);
            ivHead = (SimpleDraweeView) view.findViewById(R.id.ivTeamLogo);
        }
    }
}