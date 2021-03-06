
package com.yuyh.cavaliers.ui.Interactor;

import com.yuyh.cavaliers.http.constant.Constant;

import java.util.Map;

public interface StatsRankInteractor {

    Map<String, Constant.TabType> getTabs();

    Map<String, Constant.StatType> getStats();
}
