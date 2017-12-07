package common.exception;


public enum ExceptionCodeEnum {
	
	HENGFENG_BUILD_SIGN_EXCEPTION("100","签名构建异常"),
	
	HENGFENG_NOT_FIND_METHOD("840","未定义的服务"),

	HENGFENG_RETURN_FILE_CONTENT_ERROR("210","回盘文件内容不正确"),
	
	SERVER_INNER_ERROR("999","服务器内部错误");
    
	
	private String code;
	private String msg;

	final public String getCode() {
		return code;
	}

	final public String getMsg() {
		return msg;
	}

	ExceptionCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

}
