package com.pret.api.vo;

import org.apache.commons.lang3.StringUtils;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

@XmlRootElement
public class ErrorResponseBody extends ResBody {

    /**
     *
     */
    private static final long serialVersionUID = -5406188646545695869L;

    /*	private String status = CommonConstants.SUCCUSS_CODE;// 状态 (000000:正常)

        private String memo;// 备注
    */    private static Map<String, String> tppOperateCode = new HashMap<String, String>();

    static {
        tppOperateCode.put("200001", "200038");
        tppOperateCode.put("200003", "200039");
        tppOperateCode.put("200002", "200040");
        tppOperateCode.put("000000", "000000");
    }

    public static ErrorResponseBody createErrorResponseBody(String status, String memo) {
        ErrorResponseBody responseBody = new ErrorResponseBody();
        responseBody.setStatus(status);
        responseBody.setMessage(memo);
        return responseBody;
    }

    public static ErrorResponseBody createTppBankInfoResponseBody(String status, String memo) {
        ErrorResponseBody responseBody = new ErrorResponseBody();
        if (StringUtils.isNotEmpty(tppOperateCode.get(status))) {
            responseBody.setStatus(tppOperateCode.get(status));
        } else {
            responseBody.setStatus(status);
        }
        responseBody.setMessage(memo);
        return responseBody;
    }

/*	@NotBlank
	@Size(max = 30)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Size(max = 3000)
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}*/
}
