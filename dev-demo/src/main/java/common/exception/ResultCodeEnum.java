package common.exception;


public enum ResultCodeEnum {
    SUCCESS("000","成功"),
	
	CHECK_PARAM_ERROR("001","参数校验错误"),
	
	IS_NOT_EXIST("003","记录不存在"),

	SERVER_INNER_ERROR("999","服务器内部错误");

	
	private String code;
	private String msg;

	final public String getCode() {
		return code;
	}

	final public String getMsg() {
		return msg;
	}

	ResultCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

}
