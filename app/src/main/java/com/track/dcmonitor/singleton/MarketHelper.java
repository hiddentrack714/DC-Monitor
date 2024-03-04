package com.track.dcmonitor.singleton;

import com.binance.connector.client.SpotClient;
import com.binance.connector.client.impl.SpotClientImpl;
import com.binance.connector.client.impl.spot.Market;
import com.track.dcmonitor.constant.Constant;

public class MarketHelper {
    private static volatile Market instance;

    private MarketHelper() {

    }

    public static Market getInstance() {
        if (instance == null) {
            synchronized (MarketHelper.class) {
                if (instance == null) {
                    SpotClient client = new SpotClientImpl(Constant.apiKey, Constant.secretKey);
                    instance = client.createMarket();
                }
            }
        }
        return instance;
    }

}
