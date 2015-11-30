package mangafox.shinae.co.kr.mangafox.data;

import java.util.Date;

public class Discussion {
    public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	private String title;
    private String href;
    private String text;
    public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	private String date;
}
