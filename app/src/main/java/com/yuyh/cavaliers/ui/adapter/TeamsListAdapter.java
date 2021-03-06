package com.yuyh.cavaliers.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yuyh.cavaliers.R;
import com.yuyh.cavaliers.http.bean.player.Teams;
import com.yuyh.cavaliers.support.OnListItemClickListener;
import com.yuyh.cavaliers.utils.FrescoUtils;
import com.zengcanxiang.baseAdapter.absListView.HelperAdapter;
import com.zengcanxiang.baseAdapter.absListView.HelperViewHolder;

import java.util.List;

/**
 * @author yuyh.
 * @date 16/6/24.
 */
public class TeamsListAdapter extends HelperAdapter<Teams.TeamsBean.Team> {

    private OnListItemClickListener listener;

    public TeamsListAdapter(List<Teams.TeamsBean.Team> mList, Context context, int... layoutIds) {
        super(mList, context, layoutIds);
    }


    public void setOnListItemClickListener(OnListItemClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void HelpConvert(HelperViewHolder viewHolder, final int position, final Teams.TeamsBean.Team team) {
        viewHolder.setText(R.id.tvTeamFullName, team.fullCnName);
        SimpleDraweeView iv = viewHolder.getView(R.id.ivTeamLogo);
        iv.setController(FrescoUtils.getController(Uri.parse(team.logo), iv));
        viewHolder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onItemClick(v, position, team);
            }
        });
    }
}
