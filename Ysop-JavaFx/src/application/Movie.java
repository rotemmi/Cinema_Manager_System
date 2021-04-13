package application;
import java.io.Serializable;
import java.util.ArrayList;

public class Movie implements Serializable
{
	private String name;
	private String category;
	private String aboutMovie;
	private String image=null;
	private ArrayList<String> feedbackList  = new ArrayList<String>() ;
	private static final long serialVersionUID=1L;
	public Movie(String name, String category,String aboutMovie,String image) 
	{
		this.name = name;
		this.category = category;
		this.aboutMovie=aboutMovie;
		this.image=image;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public ArrayList<String> getFeedbackList() 
	{
		return feedbackList;
	}

	public void addFeedBack(String feedBack)
	{
		feedbackList.add(feedBack);
	}

	public String getAboutMovie() 
	{
		return aboutMovie;
	}

	public void setAboutMovie(String aboutMovie) {
		this.aboutMovie = aboutMovie;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCatgory(String category) {
		this.category = category;
	}

	public String getName() 
	{
		return this.name;
	}


	public String getCategory() 
	{
		return this.category;
	}
}
