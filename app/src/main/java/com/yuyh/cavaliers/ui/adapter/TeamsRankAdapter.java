package com.yuyh.cavaliers.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.yuyh.cavaliers.R;
import com.yuyh.cavaliers.http.bean.player.TeamsRank;
import com.yuyh.cavaliers.support.NoDoubleClickListener;
import com.yuyh.cavaliers.support.OnListItemClickListener;
import com.yuyh.cavaliers.utils.FrescoUtils;
import com.zengcanxiang.baseAdapter.recyclerView.HelperAdapter;
import com.zengcanxiang.baseAdapter.recyclerView.HelperViewHolder;

import java.util.List;

/**
 * Created by Kyrie.Y on 2016/6/6.
 */
public class TeamsRankAdapter extends HelperAdapter<TeamsRank.TeamBean> {

    private OnListItemClickListener mOnItemClickListener = null;

    /**
     * @param data     数据源
     * @param context  上下文
     * @param layoutId 布局Id
     */
    public TeamsRankAdapter(List<TeamsRank.TeamBean> data, Context context, int... layoutId) {
        super(data, context, layoutId);
    }

    @Override
    protected void HelperBindData(final HelperViewHolder viewHolder, final int position, final TeamsRank.TeamBean item) {
        if (item.type == 0) {
            SimpleDraweeView iv = viewHolder.getView(R.id.team_icon);
            iv.setController(FrescoUtils.getController(Uri.parse(item.badge), iv));

            viewHolder.setText(R.id.team_name, item.name)
                    .setText(R.id.win, item.win + "")
                    .setText(R.id.lose, item.lose + "")
                    .setText(R.id.win_percent, item.rate)
                    .setText(R.id.difference, item.difference);
            viewHolder.getItemView().setOnClickListener(new NoDoubleClickListener() {
                @Override
                protected void onNoDoubleClick(View view) {
                    if (mOnItemClickListener != null)
                        mOnItemClickListener.onItemClick(viewHolder.getItemView(), position, item);
                }
            });
        } else {
            viewHolder.setText(R.id.team_name, item.name);
        }
    }

    public void setOnItemClickListener(OnListItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public int checkLayoutIndex(TeamsRank.TeamBean item, int position) {
        if (item.type == 0)
            return 0;
        else
            return 1;
    }
}
