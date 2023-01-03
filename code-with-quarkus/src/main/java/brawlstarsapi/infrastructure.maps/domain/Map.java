package brawlstarsapi.infrastructure.maps.domain;


public class Map{
	private int id;
	private boolean jsonMemberNew;
	private boolean disabled;
	private String name;
	private String hash;
	private int version;
	private String link;
	private String imageUrl;
	private String credit;
	private int lastActive;
	private int dataUpdated;
	private Environment environment;
	private GameMode gameMode;

	public void setJsonMemberNew(boolean jsonMemberNew){
		this.jsonMemberNew = jsonMemberNew;
	}

	public boolean isJsonMemberNew(){
		return jsonMemberNew;
	}

	public void setLastActive(int lastActive){
		this.lastActive = lastActive;
	}

	public int getLastActive(){
		return lastActive;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setDataUpdated(int dataUpdated){
		this.dataUpdated = dataUpdated;
	}

	public int getDataUpdated(){
		return dataUpdated;
	}

	public void setVersion(int version){
		this.version = version;
	}

	public int getVersion(){
		return version;
	}

	public void setEnvironment(Environment environment){
		this.environment = environment;
	}

	public Environment getEnvironment(){
		return environment;
	}

	public void setImageUrl(String imageUrl){
		this.imageUrl = imageUrl;
	}

	public String getImageUrl(){
		return imageUrl;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDisabled(boolean disabled){
		this.disabled = disabled;
	}

	public boolean isDisabled(){
		return disabled;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCredit(String credit){
		this.credit = credit;
	}

	public Object getCredit(){
		return credit;
	}

	public void setGameMode(GameMode gameMode){
		this.gameMode = gameMode;
	}

	public GameMode getGameMode(){
		return gameMode;
	}

	public void setHash(String hash){
		this.hash = hash;
	}

	public String getHash(){
		return hash;
	}
}
