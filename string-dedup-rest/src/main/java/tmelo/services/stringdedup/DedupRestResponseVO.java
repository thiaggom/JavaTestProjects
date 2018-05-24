package tmelo.services.stringdedup;

public class DedupRestResponseVO {

	private String content;

	public DedupRestResponseVO(String content) {
		this.content = content;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
