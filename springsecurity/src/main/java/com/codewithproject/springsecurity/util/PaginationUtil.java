package com.codewithproject.springsecurity.util;

import java.util.List;

public class PaginationUtil {

    public static <T> List<T> paginate(List<T> list, int pageSize, int page) {
        int totalSize = list.size();
        int fromIndex = (page - 1) * pageSize;
        int toIndex = Math.min(fromIndex + pageSize, totalSize);

        if (fromIndex >= totalSize) {
            return List.of();
        }
        return list.subList(fromIndex, toIndex);
    }

    public static <T> int getTotalPages(List<T> list, int pageSize) {
        int totalSize = list.size();
        return (int) Math.ceil((double) totalSize / pageSize);
    }
}
