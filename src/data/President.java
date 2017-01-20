package data;

public class President {
	private String termNumber;
	private String name;
	private String years;
	private String party;
	private String funFact;
	private String image;
	
	public President(){}	
	
	public President(String termNumber, String name, String years, String party, String funFact, String image) {
		super();
		this.termNumber = termNumber;
		this.name = name;
		this.years = years;
		this.party = party;
		this.funFact = funFact;
		this.image = image;
	}

	public String getTermNumber() {
		return termNumber;
	}
	public void setTermNumber(String termNumber) {
		this.termNumber = termNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getYears() {
		return years;
	}
	public void setYears(String years) {
		this.years = years;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getFunFact() {
		return funFact;
	}
	public void setFunFact(String funFact) {
		this.funFact = funFact;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
