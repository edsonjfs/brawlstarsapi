package brawlstarsapi.infrastructure.maps.domain;

public class GameModeResponse {
	private String color;
	private String link;
	private String description;
	private String shortDescription;
	private String title;
	private int version;
	private String imageUrl2;
	private String imageUrl;
	private String name;
	private boolean disabled;
	private int id;
	private String tutorial;
	private int sort1;
	private int sort2;
	private String hash;

	public String getColor(){
		return color;
	}

	public String getLink(){
		return link;
	}

	public String getDescription(){
		return description;
	}

	public String getShortDescription(){
		return shortDescription;
	}

	public String getTitle(){
		return title;
	}

	public int getVersion(){
		return version;
	}

	public String getImageUrl2(){
		return imageUrl2;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public String getName(){
		return name;
	}

	public boolean isDisabled(){
		return disabled;
	}

	public int getId(){
		return id;
	}

	public String getTutorial(){
		return tutorial;
	}

	public int getSort1(){
		return sort1;
	}

	public int getSort2(){
		return sort2;
	}

	public String getHash(){
		return hash;
	}
}
