package com.pret.common.util;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.DeviceType;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.*;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.*;
import cn.jpush.api.push.model.notification.IosNotification.Builder;
import com.pret.common.constant.CommonConstants;

import java.util.Map;


public class PushUtil {

    private String project;
    private boolean environment;
    private JPushClient jpushClient;

    public void setEnvironment(boolean environment) {
        this.environment = environment;
    }

    public boolean isEnvironment() {
        return environment;
    }

    public JPushClient getJpushClient() {
        return jpushClient;
    }

    public PushUtil() {

    }


    public PushUtil(String project) throws Exception {
        this.project = project;
        this.environment = false;
        String appKey = CommonConstants.jg_app_key;
        String masterSecret = CommonConstants.jq_secret;
        this.jpushClient = new JPushClient(masterSecret, appKey, 3);
    }


    public PushResult pushAll(String content) throws Exception {
        PushPayload payload = PushPayload
                .newBuilder()
                .setPlatform(Platform.newBuilder().addDeviceType(DeviceType.IOS).addDeviceType(DeviceType.Android).build())
                .setNotification(Notification.alert(content))
                .setAudience(Audience.newBuilder().setAll(true).build())
                .setOptions(Options.newBuilder().setApnsProduction(this.environment).build())
                .build();
        return this.jpushClient.sendPush(payload);
    }

    public PushResult pushOne(String id, String content) throws Exception {
        PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.all()).
                setAudience(Audience.alias(id)).setNotification(Notification.alert(content)).
                setOptions(Options.newBuilder().setApnsProduction(this.environment).build()).build();
        return this.jpushClient.sendPush(payload);
    }


    public PushResult pushOne(String id, String content, Map<String, String> extra) throws Exception {
        try {
            pushOneForAndroid(id, content, extra);
        } catch (Exception e) {
        }
        return pushOneForIos(id, content, extra);
    }


    public PushResult pushOneWithBadge(String id, String content) throws Exception {
        try {
            pushOneForAndroid(id, content);
        } catch (Exception e) {
        }
        return pushOneForIosWithBadge(id, content);
    }

    public PushResult pushOneForIosWithBadge(String id, String content) throws APIConnectionException, APIRequestException {
        PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.alias(id)).setNotification(Notification.newBuilder().addPlatformNotification(IosNotification.newBuilder().setAlert(content).setSound("happy").autoBadge().build()).build()).setMessage(Message.content(content)).setOptions(Options.newBuilder().setApnsProduction(this.environment).build()).build();
        return this.jpushClient.sendPush(payload);
    }

    public PushResult pushOneForAndroid(String id, String content) throws Exception {
        PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.alias(id)).setNotification(Notification.android(content, content, null)).setOptions(Options.newBuilder().setApnsProduction(this.environment).build()).build();
        return this.jpushClient.sendPush(payload);
    }

    public PushResult pushOneForAndroid(String id, String content, Map<String, String> extra) throws Exception {
        PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.android()).setAudience(Audience.alias(id)).setNotification(Notification.android(content, content, extra)).setOptions(Options.newBuilder().setApnsProduction(this.environment).build()).build();
        return this.jpushClient.sendPush(payload);
    }


    public PushResult pushOneForIos(String id, String content, Map<String, String> extra) throws Exception {
        Builder builder = IosNotification.newBuilder().setAlert(content).setBadge(5).setSound("happy");
        for (String key : extra.keySet())
            builder.addExtra(key, extra.get(key));
        IosNotification notification = builder.build();
        PushPayload payload = PushPayload.newBuilder().setPlatform(Platform.ios()).setAudience(Audience.alias(id)).setNotification(Notification.newBuilder().addPlatformNotification(notification).build()).setOptions(Options.newBuilder().setApnsProduction(this.environment).build()).build();
        return this.jpushClient.sendPush(payload);
    }

    public PushResult pushOneForIos(String id, String content) throws Exception {
        PushPayload payload =
                PushPayload.newBuilder()
                        .setPlatform(Platform.ios())
                        .setAudience(Audience.alias(id))
                        .setNotification(
                                Notification.newBuilder()
                                        .addPlatformNotification(
                                                IosNotification.newBuilder()
                                                        .setAlert(content)
                                                        .setSound("happy")
                                                        .build()
                                        ).build()
                        )
                        .setMessage(Message.content(content))
                        .setOptions(
                                Options.newBuilder().setApnsProduction(this.environment).build()
                        ).build();
        return this.jpushClient.sendPush(payload);
    }
}