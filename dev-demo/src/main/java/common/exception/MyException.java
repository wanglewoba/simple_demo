package common.exception;

import java.util.Map;


public class MyException extends Exception {
	private String code;
	private String msg;
	private Map<String,String> reParams;
	public MyException(ResultCodeEnum exceptionCodeEnum, String appandMsg) {
		super();
		this.code = exceptionCodeEnum.getCode();
		this.msg = exceptionCodeEnum.getMsg()+appandMsg;
	}
	public MyException(ResultCodeEnum exceptionCodeEnum) {
		super(exceptionCodeEnum.getMsg());
		this.code = exceptionCodeEnum.getCode();
		this.msg = exceptionCodeEnum.getMsg();
	}
	public MyException(ResultCodeEnum exceptionCodeEnum, Throwable throwable) {
		super(throwable);
		this.code = exceptionCodeEnum.getCode();
		this.msg = exceptionCodeEnum.getMsg();
	}
	public MyException(String code, String msg) {
		super(msg);
		this.code = code;
		this.msg = msg;
	}
	public MyException(ExceptionCodeEnum exceptionCodeEnum) {
		super(exceptionCodeEnum.getMsg());
		this.code = exceptionCodeEnum.getCode();
		this.msg = exceptionCodeEnum.getMsg();
	}
	public MyException(ExceptionCodeEnum exceptionCodeEnum, Throwable throwable) {
		super(throwable);
		this.code = exceptionCodeEnum.getCode();
		this.msg = exceptionCodeEnum.getMsg();
	}
	
	/**
	 * @return the reParams
	 */
	public Map<String, String> getReParams() {
		return reParams;
	}
	/**
	 * @param reParams the reParams to set
	 */
	public void setReParams(Map<String, String> reParams) {
		this.reParams = reParams;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
