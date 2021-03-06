package com.yuyh.cavaliers.ui.view;

import com.yuyh.cavaliers.http.bean.player.StatsRank;
import com.yuyh.cavaliers.http.constant.Constant;
import com.yuyh.cavaliers.ui.view.base.BaseView;

import java.util.List;
import java.util.Map;

public interface StatsRankView extends BaseView{

    void showStatsRank(Map<String, Constant.TabType> tab, Map<String, Constant.StatType> stat);

    void showStatList(List<StatsRank.RankItem> list);
}
