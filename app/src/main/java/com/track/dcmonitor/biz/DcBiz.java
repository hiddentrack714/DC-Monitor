package com.track.dcmonitor.biz;

import android.util.Log;

import com.binance.connector.client.SpotClient;
import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.spot.Market;
import com.track.dcmonitor.constant.Constant;
import com.track.dcmonitor.singleton.MarketHelper;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.Request;

public class DcBiz {

    /**
     * 币安原生API，必须使用代理才能访问
     * @param list 要查询的货币集合
     * @param typeStr  查询类的内容是全部，还是部分(FULL,MINI)
     * @param windowSizeStr 查询间隔时间
     */
    public String qurDcByAPI(List<String> list, String typeStr, String windowSizeStr) {
        LinkedHashMap<String, Object> parameters = new LinkedHashMap<String, Object>();
        if(list.size() == 1){
            parameters.put("symbol", list.get(0));
        }else{
            parameters.put("symbols", list);
        }
        parameters.put("type", typeStr);
        parameters.put("windowSize", windowSizeStr);
        String result = MarketHelper.getInstance().ticker(parameters);
        Log.i("DcBiz", result);
        return result;
    }

    /**
     *web方式查询货币
     * @param list 要查询的货币集合
     * @param typeStr  查询类的内容是全部，还是部分(FULL,MINI)
     */
    public static String qurDcByWeb(List<String> list, String typeStr) {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        String url ="";
        Request request = new Request.Builder()
                .url("https://testnet.binance.vision/api/v3/ticker?symbol=XAIUSDT&windowSize=1m&type=MINI")
                .method("GET", null)
                .addHeader("Content-Type", "application/json")
                .build();
        try {
            Response response = client.newCall(request).execute();
            Log.i("DcBiz", response.body().string());
        } catch (Exception e) {

        }

        return url;
    }
}
