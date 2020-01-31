import java.util.*;

/*Video: esta format por una URL, un títol i una llista de tags*.*/
public class Video {

	private String url;
	private String title;
	private List<String> tags;

	Video(String url, String title, List<String> tags) {

		this.url = url;
		this.title = title;
		this.tags = tags;
	}

	Video() {

	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	@Override
	public String toString() {
		return "Video [url=" + this.url + ", title=" + this.title + ", tags=" + this.tags + "]\n";
	}

}