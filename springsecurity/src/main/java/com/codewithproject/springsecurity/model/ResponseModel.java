package com.codewithproject.springsecurity.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel<T> {

    private boolean result;
    private Integer status;
    private String message;
    private T data;

    // ============== Message OK ==============
    public static <T> ResponseModel<T> ok(T data, String successMsg) {
        final ResponseModel<T> instance = ResponseModel.okInstance(successMsg);
        instance.setData(data);
        return instance;
    }

    public static <T> ResponseModel<T> okInstance() {
        ResponseModel<T> model = new ResponseModel<>();
        model.result = true;
        model.status = HttpStatus.OK.value();
        model.message = HttpStatus.OK.getReasonPhrase();
        return model;
    }

    public static <T> ResponseModel<T> okInstance(String successMsg) {
        ResponseModel<T> model = new ResponseModel<>();
        model.result = true;
        model.status = HttpStatus.OK.value();
        model.message = successMsg;
        return model;
    }

    // ============== Message Error ==============

    public static <T> ResponseModel<T> error(String errorMsg) {
        return ResponseModel.errorInstance(errorMsg);
    }

    public static <T> ResponseModel<T> errorInstance(String errorMsg) {
        ResponseModel<T> model = new ResponseModel<>();
        model.result = false;
        model.status = HttpStatus.BAD_REQUEST.value();
        model.message = errorMsg;
        return model;
    }
}
