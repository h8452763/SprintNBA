
package com.yuyh.cavaliers.ui.Interactor;

import com.yuyh.cavaliers.http.bean.player.Teams;
import com.yuyh.cavaliers.http.api.RequestCallback;

public interface TeamsListInteractor {

    void getAllTeams(RequestCallback<Teams> callback);
}
