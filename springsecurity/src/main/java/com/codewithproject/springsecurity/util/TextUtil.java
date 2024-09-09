package com.codewithproject.springsecurity.util;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.regex.Pattern;

public class TextUtil {

    // Mang cac ky tu goc co dau
    private static final char[] SOURCE_CHARACTERS = { 'À', 'Á', 'Â', 'Ã', 'È', 'É', 'Ê', 'Ì', 'Í', 'Ò', 'Ó', 'Ô', 'Õ', 'Ù',
            'Ú', 'Ý', 'à', 'á', 'â', 'ã', 'è', 'é', 'ê', 'ì', 'í', 'ò', 'ó', 'ô', 'õ', 'ù', 'ú', 'ý', 'Ă', 'ă', 'Đ',
            'đ', 'Ĩ', 'ĩ', 'Ũ', 'ũ', 'Ơ', 'ơ', 'Ư', 'ư', 'Ạ', 'ạ', 'Ả', 'ả', 'Ấ', 'ấ', 'Ầ', 'ầ', 'Ẩ', 'ẩ', 'Ẫ', 'ẫ',
            'Ậ', 'ậ', 'Ắ', 'ắ', 'Ằ', 'ằ', 'Ẳ', 'ẳ', 'Ẵ', 'ẵ', 'Ặ', 'ặ', 'Ẹ', 'ẹ', 'Ẻ', 'ẻ', 'Ẽ', 'ẽ', 'Ế', 'ế', 'Ề',
            'ề', 'Ể', 'ể', 'Ễ', 'ễ', 'Ệ', 'ệ', 'Ỉ', 'ỉ', 'Ị', 'ị', 'Ọ', 'ọ', 'Ỏ', 'ỏ', 'Ố', 'ố', 'Ồ', 'ồ', 'Ổ', 'ổ',
            'Ỗ', 'ỗ', 'Ộ', 'ộ', 'Ớ', 'ớ', 'Ờ', 'ờ', 'Ở', 'ở', 'Ỡ', 'ỡ', 'Ợ', 'ợ', 'Ụ', 'ụ', 'Ủ', 'ủ', 'Ứ', 'ứ', 'Ừ',
            'ừ', 'Ử', 'ử', 'Ữ', 'ữ', 'Ự', 'ự','Ỹ','ỹ' };

    // Mang cac ky tu thay the khong dau
    private static final char[] DESTINATION_CHARACTERS = { 'A', 'A', 'A', 'A', 'E', 'E', 'E', 'I', 'I', 'O', 'O', 'O', 'O',
            'U', 'U', 'Y', 'a', 'a', 'a', 'a', 'e', 'e', 'e', 'i', 'i', 'o', 'o', 'o', 'o', 'u', 'u', 'y', 'A', 'a',
            'D', 'd', 'I', 'i', 'U', 'u', 'O', 'o', 'U', 'u', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A',
            'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'A', 'a', 'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e',
            'E', 'e', 'E', 'e', 'E', 'e', 'E', 'e', 'I', 'i', 'I', 'i', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O',
            'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'O', 'o', 'U', 'u', 'U', 'u', 'U', 'u',
            'U', 'u', 'U', 'u', 'U', 'u', 'U', 'u','y','y' };

    /**
     * Bo dau 1 ky tu
     */
    public static char removeAccent(char ch) {
        int index = Arrays.binarySearch(SOURCE_CHARACTERS, ch);
        if (index >= 0) {
            ch = DESTINATION_CHARACTERS[index];
        }
        return ch;
    }

    /**
     * Bo dau 1 chuoi
     */
    public static String removeAccent(String s) {
        String result = null;
        if (s != null) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < sb.length(); i++) {
                sb.setCharAt(i, removeAccent(sb.charAt(i)));
            }
            result= sb.toString();
        }
        String temp = Normalizer.normalize(result, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(temp).replaceAll("");
    }

    public static boolean isNullOrEmpty(final String s) {
        return (s == null || s.trim().isEmpty());
    }

    /**
     * return: title_name_2021_12_15
     */
//    public static String getStringForFileNameHaveDate(String title, Date date, String format) {
//        String str = StringUtis.getStringForFileName(title);
//        String day = DateUtils.toDateString(date, format);
//        return str + "_" + day;
//    }

    /**
     * from: Nguyễn Việt Hải - Báo cáo công việc.
     * return: nguyen_viet_hai__bao_cao_cong_viec
     */
//    public static String getStringForFileName(String title) {
//        if (StringUtils.isNotBlank(title)) {
//            String result = replaceSpecialChar(title);
//            return result.replace(" ", "_");
//        }
//        return title;
//    }

    /**
     * from: Nguyễn Việt Hải - Báo cáo công việc.
     * return: nguyen viet hai  bao cao cong viec
     */
//    private static String replaceSpecialChar(String title) {
//        return VNCharacterUtls.removeAccent(title.toLowerCase())
//                .replaceAll("[^\\sa-zA-Z0-9]", "");
//    }

    /**
     * from: Báo cáo công việc.
     * return: bao-cao-cong-viec
     */
//    public static String getStringForURL(String title) {
//        if (StringUtils.isNotBlank(title)) {
//            String result = replaceSpecialChar(title);
//            return result.replace(" ", "-");
//        }
//        return title;
//    }
}
