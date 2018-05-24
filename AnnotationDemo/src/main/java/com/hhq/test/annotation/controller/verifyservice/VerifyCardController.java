package com.hhq.test.annotation.controller.verifyservice;

import com.hhq.test.annotation.api.BankCardDTO;
import com.hhq.test.annotation.customannotation.VerifyService;

/**
 * @author Kevin He
 * @date 2018/05/16
 * @version 1.0.0
 */
@VerifyService(verifyType = "verifycard")
public class VerifyCardController implements InvokeService {

    /* (non-Javadoc)
     * @see com.hhq.test.annotation.controller.verifyservice.InvokeService#invoke(java.lang.String)
     */
    @Override
    public Object invoke(String requestBody) {

        BankCardDTO bankcard = new BankCardDTO();
        bankcard.setId(1L);
        bankcard.setBankName("ICBC");
        bankcard.setCardName("Debit Card");
        bankcard.setCardType(1);
        bankcard.setCardNum("123456 1234568 98765");
        return bankcard;
    }

}
