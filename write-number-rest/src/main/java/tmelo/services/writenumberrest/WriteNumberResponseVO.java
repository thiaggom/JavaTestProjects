package tmelo.services.writenumberrest;

/**
 * Wrapper class used as response of the method writeNumber of the class {@link WriteNumberRestController}
 * 
 * @author Thiago Melo
 * @see WriteNumberRestController
 */
public class WriteNumberResponseVO {

	private String content;

	public WriteNumberResponseVO(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
