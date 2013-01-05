package tkorg.idrs.core.extraction;

import java.util.List;

import org.json.XML;

import tkorg.idrs.utilities.StringUtility;

public class PaperObject {
	
	private String url;
	private String title;
	private List<Author> authors;
	private String email;
	private String affiliation;
	private String placeOfWork;
	private String publisher;
	private String yearPublish;
	private String abstractPaper;
	private List<PaperObject> references;
	private String content;
	private String address;
	private String date;
	private String Degree;
	
	/**
	 * 
	 * comment : non construction any thing. A object null attribute.
	 */
	public PaperObject(){
		this.url = "null";
		this.title = "null";
		this.authors = null;
		this.email = "null";
		this.affiliation = "null";
		this.placeOfWork = "null";
		this.yearPublish = "null";
		this.abstractPaper = "null";
		this.references = null;
		this.publisher = "null";
		address = null;
		date = null;
	}
	
	public PaperObject(String url,
							String title, 
							List<Author> authors, 
							String place, 
							String publisher, 
							String yearPublish,
							String abstr,
							List<PaperObject> ref){
		this.url = url.trim();
		this.title = title.trim();
		this.authors = authors;
		this.placeOfWork = place.trim();
		this.yearPublish = yearPublish.trim();
		this.abstractPaper = abstr.trim();
		this.references = ref;
		this.publisher = publisher.trim();
	}
	
	private String keyword = null;
	
	
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}
	
	private String note;
	private String phone;
	private String web;

	/**
	 * @return the web
	 */
	public String getWeb() {
		return web;
	}

	/**
	 * @param web the web to set
	 */
	public void setWeb(String web) {
		this.web = web;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the degree
	 */
	public String getDegree() {
		return Degree;
	}

	/**
	 * @param degree the degree to set
	 */
	public void setDegree(String degree) {
		Degree = degree;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 
	 * comment : convert Metadata Object to XML schema. 
	 * @return
	 * @author Huynh Minh Duc
	 */
	public XML toXML(){
		return null;
	}
	
	/**
	 * 
	 */
	public String toString(){
		return null;
	}
	
	public void setTitle(String title){
		String newContent = StringUtility.removeNewLineCharacter(title);
		this.title = newContent.trim();
	}
	
	public String getTitle(){
		return title;
	}
	
	public void setAuthor(List<Author> author){
		this.authors = author;
	}
	
	public List<Author> getAuthor(){
		return authors;
	}
	
	public void setPlaceOfWork(String place){
		String newContent = StringUtility.removeNewLineCharacter(place);
		this.placeOfWork = newContent.trim();
	}
	
	public String getPlaceOfWork(){
		return placeOfWork;
	}
	
	public void setPublisher(String publisher){
		String newContent = StringUtility.removeNewLineCharacter(publisher);
		this.publisher = newContent.trim();
	}
	
	public String getPublisher(){
		return publisher;
	}
	
	public void setYearPublish(String yearPublish){
		String newContent = StringUtility.removeNewLineCharacter(yearPublish);
		this.yearPublish = newContent.trim();
	}
	
	public String getYearPublish(){
		return yearPublish;
	}
	
	public List<PaperObject> getReferences() {
		return references;
	}

	public void setReferences(List<PaperObject> references) {
		this.references = references;
	}
	
	public String getAbstractPaper() {
		return abstractPaper;
	}

	public void setAbstractPaper(String abstractPaper) {
		if(abstractPaper != null) {
			String newContent = StringUtility.removeNewLineCharacter(abstractPaper);
			this.abstractPaper = newContent.trim();
		}
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		//String newContent = StringUtility.removeNewLineCharacter(content);
		this.content = content.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAffiliation() {
		return affiliation;
	}

	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	
	
}
