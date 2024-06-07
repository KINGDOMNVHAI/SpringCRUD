package com.poscdx.odc.excan013.domain.utils;

import org.apache.commons.lang3.StringUtils;

public class Constants {
    public static final String SORT_ASC = "ASC";
    public static final String SORT_DESC = "DESC";

    public static final String STATUS = "status";
    public static final String MESSAGE = "message";
    public static final String PATH = "path";
    public static final int ERROR_NOT_FOUND = 404;

    public static String UPLOAD_URL = "";
    public static String UPLOAD_BUCKET = "";
//
//    public static String applyEmployeeAvatarPath(String avatar, String serviceName) {
//        if (!serviceName.isEmpty()) {
//            serviceName += "/";
//        }
//        return (avatar == null || avatar.isEmpty()) ? null :
//                Constants.UPLOAD_URL + Constants.UPLOAD_BUCKET + "/" + serviceName + avatar;

    public static String formatUrl(String path) {
        if (StringUtils.isBlank(path)) {
            return path;
        }
        return UPLOAD_URL + UPLOAD_BUCKET + "/" + path;
    }

}
