package com.yuyh.cavaliers.ui.fragment;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.yuyh.cavaliers.R;
import com.yuyh.cavaliers.base.BaseLazyFragment;
import com.yuyh.cavaliers.http.bean.match.MatchStat;
import com.yuyh.cavaliers.ui.adapter.MatchPlayerDataAdapter;
import com.yuyh.cavaliers.ui.presenter.Presenter;
import com.yuyh.cavaliers.ui.presenter.impl.MatchPlayerDataPresenter;
import com.yuyh.cavaliers.ui.view.MatchPlayerDataView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * @author yuyh.
 * @date 2016/7/5.
 */
public class MatchPlayerDataFragment extends BaseLazyFragment implements MatchPlayerDataView {

    @InjectView(R.id.tvPlayerDataLeft)
    TextView tvPlayerDataLeft;
    @InjectView(R.id.lvPlayerDataLeft)
    ListView lvPlayerDataLeft;

    @InjectView(R.id.tvPlayerDataRight)
    TextView tvPlayerDataRight;
    @InjectView(R.id.lvPlayerDataRight)
    ListView lvPlayerDataRight;

    private Presenter presenter;
    private List<MatchStat.MatchStatInfo.StatsBean.PlayerStats> left = new ArrayList<>();
    private List<MatchStat.MatchStatInfo.StatsBean.PlayerStats> right = new ArrayList<>();
    private MatchPlayerDataAdapter leftAdapter;
    private MatchPlayerDataAdapter rightAdapter;

    public static MatchPlayerDataFragment newInstance(String mid) {
        Bundle args = new Bundle();
        args.putString("mid", mid);
        MatchPlayerDataFragment fragment = new MatchPlayerDataFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void onCreateViewLazy(Bundle savedInstanceState) {
        super.onCreateViewLazy(savedInstanceState);
        setContentView(R.layout.fragment_match_player_data);
        ButterKnife.inject(this, getContentView());
        initData();
    }

    private void initData() {
        leftAdapter = new MatchPlayerDataAdapter(left, mActivity, R.layout.item_list_match_player);
        lvPlayerDataLeft.setAdapter(leftAdapter);
        rightAdapter = new MatchPlayerDataAdapter(right, mActivity, R.layout.item_list_match_player);
        lvPlayerDataRight.setAdapter(rightAdapter);
        presenter = new MatchPlayerDataPresenter(mActivity, this, getArguments().getString("mid"));
        presenter.initialized();
    }

    @Override
    public void showLoading(String msg) {
        showLoadingDialog();
    }

    @Override
    public void hideLoading() {
        hideLoadingDialog();
    }

    @Override
    public void showError(String msg) {
        hideLoading();
    }

    @Override
    public void showPlayerData(List<MatchStat.MatchStatInfo.StatsBean.PlayerStats> playerStatses) {
        boolean isLeft = false;
        boolean isRight = false;
        left.clear();
        right.clear();
        for (MatchStat.MatchStatInfo.StatsBean.PlayerStats item : playerStatses) {
            if (item.subText != null && !isLeft) {
                isLeft = true;
                tvPlayerDataLeft.setText(item.subText);
            } else if (item.subText != null && isLeft) {
                isRight = true;
                tvPlayerDataRight.setText(item.subText);
            } else {
                if (isRight) {
                    right.add(item);
                } else {
                    left.add(item);
                }
            }
        }
        leftAdapter.notifyDataSetChanged();
        rightAdapter.notifyDataSetChanged();
        hideLoading();
    }
}
