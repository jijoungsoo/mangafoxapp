package mangafox.shinae.co.kr.mangafox.data;

import java.util.ArrayList;
import java.util.Date;

public class BookInfo {
	public int numberOfVolumes;
	public String title;
	public String url;
	public ArrayList<String> genre = new ArrayList<String>();
	public String summary ="";
	public String Artist = "";
	public String Author ="";
	public Date released=null;

	public String imgSrc="";
	public String status = "";
	public String href;
	public String seriesName;	
	public double rating;
	public int views;
	public int chapters;
	public String latestChapter;
	public ArrayList<Volume> volumes;
	public	ArrayList<Discussion> discussions;
}