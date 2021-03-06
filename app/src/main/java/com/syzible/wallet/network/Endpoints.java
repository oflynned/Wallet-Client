package com.syzible.wallet.network;

import android.os.Build;

/**
 * Created by ed on 17/05/2017.
 */

public class Endpoints {
    private static final int API_VERSION = 1;

    private static final String LOCAL_ENDPOINT = "http://10.0.2.2:3000";
    private static final String APP_ENDPOINT = "https://syzible-wallet.herokuapp.com";

    private static final String STEM_URL = isDebugMode() ? LOCAL_ENDPOINT : APP_ENDPOINT;
    private static final String API_URL = STEM_URL + "/api/v" + API_VERSION;

    private static boolean isDebugMode() {
        return Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT);
    }

    // users
    public static final String CREATE_USER = API_URL + "/user/create";
    public static final String GET_USER = API_URL + "/user/get";
    public static final String GET_OTHER_USERS = API_URL + "/user/get-other-users";
    public static final String EDIT_USER_FCM = API_URL + "/user/edit-fcm";

    // messages
    public static final String SEND_MESSAGE = API_URL + "/message/send";
    public static final String GET_MESSAGES = API_URL + "/message/get";
    public static final String MARK_MESSAGE_SEEN = API_URL + "/message/mark-seen";
    public static final String GET_MESSAGE_PREVIEWS = API_URL + "/message/get-message-previews";

    // transactions
    public static final String GET_BALANCE = API_URL + "/transaction/balance";
    public static final String GET_PAST_TRANSACTIONS = API_URL + "/transaction/query";
    public static final String USER_TRANSACTION = API_URL + "/transaction/make-individual-transaction";
    public static final String CARD_PAYMENT = API_URL + "/transaction/make-card-payment";
    public static final String CARD_TOPUP = API_URL + "/transaction/make-card-topup";
    public static final String WITHDRAW_TO_BANK = API_URL + "/transaction/withdraw-to-bank";

    // cards
    public static final String GET_DIGITAL_CARD_DATA = API_URL + "/user/get-digital-card";
    public static final String ADD_BANK_CARD = API_URL + "/user/add-bank-card";
    public static final String GET_BANK_CARD = API_URL + "/user/get-bank-card";
}
