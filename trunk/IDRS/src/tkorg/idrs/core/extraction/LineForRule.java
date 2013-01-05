/**
 * @author : Huynh Minh Duc
 * Mar 2, 2011
 * @comment : 
 */
package tkorg.idrs.core.extraction;

import java.util.ArrayList;

import tkorg.idrs.core.extraction.svm.domaindatabase.Dictionary;
/**
 * @author MinhDuc
 *
 */
public class LineForRule {
	private AnnotationPositon position;
	private String content;
	
	public LineForRule(){
		
	}
	
	public int perNameWordInLine(ArrayList<String> stopWordList, Dictionary nameDic){
		String[] tokens = content.split(" ");
		// Stop List Word
		int countIsNameWord = 0;
		for (int i = 0; i < tokens.length; i++) {
			if(nameDic.search(tokens[i].trim().toLowerCase()) == true){
				countIsNameWord++;
			}
		}
		return countIsNameWord;
	}
	
	/**
	 * @return the position
	 */
	public AnnotationPositon getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(AnnotationPositon position) {
		this.position = position;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
}
