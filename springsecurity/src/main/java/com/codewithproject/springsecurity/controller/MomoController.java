package com.codewithproject.springsecurity.controller;

import com.codewithproject.springsecurity.dto.response.MomoTransactionReportResponse;
import com.codewithproject.springsecurity.services.impl.MomoServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MomoController {

    @Autowired
    private MomoServiceImpl momoServiceImpl;

    @GetMapping("/public/momo/login")
    public MomoTransactionReportResponse momoLogin() {
        MomoTransactionReportResponse response = new MomoTransactionReportResponse();
        String token = momoServiceImpl.login();
        if (!token.isEmpty()) {
            response = momoServiceImpl.transactionReport(token);
        }
        return response;
    }

    // API login POST
    // https://business.momo.vn/api/authentication/login?language=vi
    // {"username": "1m1kme", "password": "Momo4789!"}
//    {
//        "status": 0,
//            "message": "Thành công",
//            "data": {
//        "username": "1m1kme",
//                "token": "eyJhbGciOiJIUzUxMiJ9.eyJ0eXBlIjoibWVyY2hhbnQiLCJleHAiOjE3MTU3NDc0NzUsImlhdCI6MTcxNTczNjY3NSwidXNlcm5hbWUiOiIxbTFrbWUifQ.xAXlWHnNxAleqHKy0he9U3-Uf4N9oMltp2KoY-_-HblA1c4JFNCb6lWU0VLOK7SaV82jKi9jIcq0OiEc15dg2g"
//    }
//    }





    // API don hang GET (can Bearer Token)
    // https://business.momo.vn/api/transaction/v2/transactions?pageSize=10&pageNumber=0&fromDate=2024-05-15T00%3A00%3A00.00&toDate=2024-05-15T23%3A59%3A59.00&status=ALL&merchantId=63168&language=vi
    // {
    //    "status": 0,
    //    "message": "Thành công",
    //    "data": {
    //        "content": [
    //            {
    //                "id": "PAYMENT-58603637178",
    //                "createdDate": "2024-05-15T08:19:09.067",
    //                "billId": "qrc-MOMOZUBQ20200206-75450ae5-a282-4392-a696-841dabfe0b8d",
    //                "sourceBillId": "qrc-MOMOZUBQ20200206-75450ae5-a282-4392-a696-841dabfe0b8d",
    //                "coreTranId": 58603637178,
    //                "status": "SUCCESS",
    //                "statusDescription": "Thành công",
    //                "customerName": "Huynh Xuan An",
    //                "customerPhoneNumber": "****2662",
    //                "type": "PAYMENT",
    //                "typeDescription": "Thanh toán",
    //                "totalAmount": 1000,
    //                "voucherAmount": 0,
    //                "cashbackAmount": 0,
    //                "prepaidAmount": 0,
    //                "paymentChannel": "STATIC_QR_MULTI",
    //                "paymentChannelDescription": "QR Code tĩnh đa năng",
    //                "paymentMethod": "MOMO_WALLET",
    //                "paymentMethodDescription": "Ví MoMo",
    //                "description": "Thanh toán cho 1m1k",
    //                "storeCode": "1m1k_0002",
    //                "storeName": "1m1k",
    //                "contractCode": null,
    //                "classify": null,
    //                "companyName": "1m1kme",
    //                "product": null,
    //                "userName": null,
    //                "address": null,
    //                "contractId": null,
    //                "platform": null,
    //                "information1": "CARTID_MOMOZUBQ20200206_qrc-MOMOZUBQ20200206-75450ae5-a282-4392-a696-841dabfe0b8d_lkfb9qgi8elw74vrk0",
    //                "information2": null,
    //                "information3": null,
    //                "information4": null,
    //                "information5": null,
    //                "moneySource": "MOMO_WALLET",
    //                "merchantCode": "MOMOZUBQ20200206",
    //                "team": "PAYMENT",
    //                "enabledConfirm": false,
    //                "subTrans": []
    //            }
    //        ],
    //        "pageable": {
    //            "sort": {
    //                "empty": true,
    //                "sorted": false,
    //                "unsorted": true
    //            },
    //            "offset": 0,
    //            "pageNumber": 0,
    //            "pageSize": 10,
    //            "unpaged": false,
    //            "paged": true
    //        },
    //        "totalElements": 1,
    //        "totalPages": 1,
    //        "last": true,
    //        "size": 10,
    //        "number": 0,
    //        "sort": {
    //            "empty": true,
    //            "sorted": false,
    //            "unsorted": true
    //        },
    //        "numberOfElements": 1,
    //        "first": true,
    //        "empty": false
    //    }
    //}

}
