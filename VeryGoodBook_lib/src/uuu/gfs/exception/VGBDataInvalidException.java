package uuu.gfs.exception;

public class VGBDataInvalidException extends RuntimeException{
	// RuntimeException 使用者輸入的錯誤
	public VGBDataInvalidException() {
		super();
		
	}

	public VGBDataInvalidException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public VGBDataInvalidException(String message) {
		super(message);
		
	}
	
}
