package com.aishidai.app.service.impl;

import com.pingplusplus.Pingpp;
import com.pingplusplus.model.Charge;
import com.pingplusplus.model.Refund;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class PingChangeServiceImpl {

    private static String API_KEY = "sk_live_P44yf1znDS8Ou5a1aTnDyXvT";
    private static String APP_ID = "app_4u5m9GHWXDmLeXHS";
    private static String KEY_PATH;

    Logger logger = LoggerFactory.getLogger(PingChangeServiceImpl.class);


    static {
        try {
            KEY_PATH = new PathMatchingResourcePatternResolver().
                    getResources("classpath:/pingprivatekey.pem")[0].
                    getFile().getAbsolutePath();
            Pingpp.apiKey = API_KEY;
            Pingpp.privateKeyPath = KEY_PATH;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Refund refund(long returnOrderId, double amount,  String ch_id) {
        try {
            Pingpp.apiKey = API_KEY;
            Pingpp.privateKeyPath = KEY_PATH;
            Charge ch = Charge.retrieve(ch_id);
            Map<String, Object> refundMap = new HashMap<String, Object>();
            refundMap.put("amount", (int)(amount * 100));
            refundMap.put("description", "退款申请id"+returnOrderId);
            //退款资金来源取值范围："unsettled_funds"：使用未结算资金退款；"recharge_funds"：使用可用余额退款。注：默认值"unsettled_funds"，该参数仅适用于微信渠道，包括  wx ,  wx_pub , wx_pub_qr ,  wx_lite 四个渠道；该参数仅在请求退款，传入该字段时返回。
            if (ch.getChannel() == "alipay") {
                refundMap.put("funding_source", "unsettled_funds");
            } else if (ch.getChannel().indexOf("wx") > 0) {
                refundMap.put("funding_source", "recharge_funds");
            }
            Map<String, String> initialMetadata = new HashMap<String, String>();
            refundMap.put("metadata", initialMetadata);
            return ch.getRefunds().create(refundMap);
        } catch (Exception e) {
            e.printStackTrace();
            logger.warn("ping++------refundError---------->"+ e.getMessage());
            return null;
        }
    }



}
