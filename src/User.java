import java.util.*;
/*Usuari: esta format per un nom, cognom, password i una data de registre.*/

public class User {
	private String name;
	private String surname;
	private String password;
	private Date date;
	private List<Video> videos;

	public User() {
	}

	public User(String name, String surname, String password, Date date) {
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.date = date;
		this.videos = new ArrayList<Video>();
	}
	
	

	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Video> getVideos() {
		return videos;
	}

	public void setVideos(List<Video> videos) {
		this.videos = videos;
	}
	
	public void AddVideo(Video videoToAdd) {
		
		this.getVideos().add(videoToAdd);
		
		
	}
	
	
	
	

	@Override
	public String toString() {
		return "User [name=" + this.name + ", surname=" + this.surname + ", password= ********  "+"date=" + date + ",videos=" + videos + "]";
	}

	public void ShowVideos() {
		System.out.println(this.getVideos().toString());
	
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


	


	

}
