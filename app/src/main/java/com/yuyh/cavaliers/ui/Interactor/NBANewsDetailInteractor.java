
package com.yuyh.cavaliers.ui.Interactor;

import com.yuyh.cavaliers.http.bean.news.NewsDetail;
import com.yuyh.cavaliers.http.api.RequestCallback;

public interface NBANewsDetailInteractor {

    void getNewsDetail(String arcId, RequestCallback<NewsDetail> callback);
}
