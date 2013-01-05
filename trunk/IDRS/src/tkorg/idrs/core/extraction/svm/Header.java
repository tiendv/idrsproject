/**
 * @author : Huynh Minh Duc
 * Feb 22, 2011
 * @comment : 
 */
package tkorg.idrs.core.extraction.svm;

import java.util.ArrayList;
import tkorg.idrs.utilily.extraction.svm.LabelConst;
import tkorg.idrs.utilily.extraction.svm.LineProcessUtilities;
import tkorg.idrs.utilily.extraction.svm.StringProcess;
import tkorg.idrs.utilily.extraction.svm.TagConst;

public class Header {
	
	private String content;
	private ArrayList<Line> lines = null;
	
	public Header(String headerTagText){
		lines = new ArrayList<Line>();
		content = headerTagText;
		intializeHeader(headerTagText);
	}
	
	/**
	 * 
	 * 
	 * @Author : Huynh Minh Duc
	 * @Comment :
	 */
	private void intializeHeader(String headerText){
				
		String contentHeaderNonTag = StringProcess.removeAllTagHeader(headerText);				
		String[] linesAndNumber = StringProcess.convertHeaderTextToLines(contentHeaderNonTag);
		
		String textTag = LineProcessUtilities.getSubString(headerText, TagConst.TITLE_TAG_START, TagConst.TITLE_TAG_END);
		if(textTag != null){
			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.TITLE);
			
			for (int i = 0; i < lineTemp.size(); i++) {
				for (int j = 0; j < linesAndNumber.length; j++) {
					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
						lineTemp.get(i).setNameLabel("TITLE");
					}
				}
				lines.add(lineTemp.get(i));
			}
		}
		
		textTag = LineProcessUtilities.getSubString(headerText, TagConst.AUTHOR_TAG_START, TagConst.AUTHOR_TAG_END);
		if(textTag != null){
			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.AUTHOR);
			for (int i = 0; i < lineTemp.size(); i++) {
				for (int j = 0; j < linesAndNumber.length; j++) {
					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
						lineTemp.get(i).setNameLabel("AUTHOR");
					}
				}
				lines.add(lineTemp.get(i));
			}
		}
		
		textTag = LineProcessUtilities.getSubString(headerText, TagConst.AFFILIATION_TAG_START, TagConst.AFFILIATION_TAG_END);
		if(textTag != null){
			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.AFFILIATION);
			for (int i = 0; i < lineTemp.size(); i++) {
				for (int j = 0; j < linesAndNumber.length; j++) {
					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
						lineTemp.get(i).setNameLabel("AFFILIATION");
					}
				}
				lines.add(lineTemp.get(i));
			}
		}
		
		textTag = LineProcessUtilities.getSubString(headerText, TagConst.ADDRESS_TAG_START, TagConst.ADDRESS_TAG_END);
		if(textTag != null){
			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.ADDRESS);
			for (int i = 0; i < lineTemp.size(); i++) {
				for (int j = 0; j < linesAndNumber.length; j++) {
					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
						lineTemp.get(i).setNameLabel("ADDRESS");
					}
				}
				lines.add(lineTemp.get(i));
			}
		}
		
//		textTag = LineProcessUtilities.getSubString(headerText, TagConst.NOTE_TAG_START, TagConst.NOTE_TAG_END);
//		if(textTag != null){
//			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.NOTE);
//			for (int i = 0; i < lineTemp.size(); i++) {
//				for (int j = 0; j < linesAndNumber.length; j++) {
//					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
//						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
//						lineTemp.get(i).setNameLabel("NOTE");
//					}
//				}
//				lines.add(lineTemp.get(i));
//			}
//		}
		
		textTag = LineProcessUtilities.getSubString(headerText, TagConst.EMAIL_TAG_START, TagConst.EMAIL_TAG_END);
		if(textTag != null){
			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.EMAIL);
			for (int i = 0; i < lineTemp.size(); i++) {
				for (int j = 0; j < linesAndNumber.length; j++) {
					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
						lineTemp.get(i).setNameLabel("EMAIL");
					}
				}
				lines.add(lineTemp.get(i));
			}
		}
		
		textTag = LineProcessUtilities.getSubString(headerText, TagConst.DATE_TAG_START, TagConst.DATE_TAG_END);
		if(textTag != null){
			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.DATE);
			for (int i = 0; i < lineTemp.size(); i++) {
				for (int j = 0; j < linesAndNumber.length; j++) {
					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
						lineTemp.get(i).setNameLabel("DATE");
					}
				}
				lines.add(lineTemp.get(i));
			}
		}
		
		textTag = LineProcessUtilities.getSubString(headerText, TagConst.ABSTRACT_TAG_START, TagConst.ABSTRACT_TAG_END);
		if(textTag != null){
			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.ABSTRACT);
			for (int i = 0; i < lineTemp.size(); i++) {
				for (int j = 0; j < linesAndNumber.length; j++) {
					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
						lineTemp.get(i).setNameLabel("ABSTRACT");
					}
				}
				lines.add(lineTemp.get(i));
			}
		}
		
//		textTag = LineProcessUtilities.getSubString(headerText, TagConst.INTRO_TAG_START, TagConst.INTRO_TAG_END);
//		if(textTag != null){
//			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.INTRODUCTION);
//			for (int i = 0; i < lineTemp.size(); i++) {
//				for (int j = 0; j < linesAndNumber.length; j++) {
//					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
//						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
//						lineTemp.get(i).setNameLabel("INTRODUCTION");
//					}
//				}
//				lines.add(lineTemp.get(i));
//			}
//		}
		
//		textTag = LineProcessUtilities.getSubString(headerText, TagConst.PHONE_TAG_START, TagConst.PHONE_TAG_END);
//		if(textTag != null){
//			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.PHONE);
//			for (int i = 0; i < lineTemp.size(); i++) {
//				for (int j = 0; j < linesAndNumber.length; j++) {
//					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
//						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
//						lineTemp.get(i).setNameLabel("PHONE");
//					}
//				}
//				lines.add(lineTemp.get(i));
//			}
//		}
//		
		textTag = LineProcessUtilities.getSubString(headerText, TagConst.KEYWORD_TAG_START, TagConst.KEYWORD_TAG_END);
		if(textTag != null){
			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.KEYWORD);
			for (int i = 0; i < lineTemp.size(); i++) {
				for (int j = 0; j < linesAndNumber.length; j++) {
					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
						lineTemp.get(i).setNameLabel("KEYWORD");
					}
				}
				lines.add(lineTemp.get(i));
			}
		}
		
//		textTag = LineProcessUtilities.getSubString(headerText, TagConst.WEB_TAG_START, TagConst.WEB_TAG_END);
//		if(textTag != null){
//			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.WEB);
//			for (int i = 0; i < lineTemp.size(); i++) {
//				for (int j = 0; j < linesAndNumber.length; j++) {
//					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
//						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
//						lineTemp.get(i).setNameLabel("WEB");
//					}
//				}
//				lines.add(lineTemp.get(i));
//			}
//		}
		
//		textTag = LineProcessUtilities.getSubString(headerText, TagConst.DEGREE_TAG_START, TagConst.DEGREE_TAG_END);
//		if(textTag != null){
//			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.DEGREE);
//			for (int i = 0; i < lineTemp.size(); i++) {
//				for (int j = 0; j < linesAndNumber.length; j++) {
//					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
//						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
//						lineTemp.get(i).setNameLabel("DEGREE");
//					}
//				}
//				lines.add(lineTemp.get(i));
//			}
//		}
		
//		textTag = LineProcessUtilities.getSubString(headerText, TagConst.PUBNUM_TAG_START, TagConst.PUBNUM_TAG_END);
//		if(textTag != null){
//			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.PUBNUM);
//			for (int i = 0; i < lineTemp.size(); i++) {
//				for (int j = 0; j < linesAndNumber.length; j++) {
//					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
//						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
//						lineTemp.get(i).setNameLabel("PUBNUM");
//					}
//				}
//				lines.add(lineTemp.get(i));
//			}
//		}
		
//		textTag = LineProcessUtilities.getSubString(headerText, TagConst.PAGE_TAG_START, TagConst.PAGE_TAG_END);
//		if(textTag != null){
//			ArrayList<Line> lineTemp = LineProcessUtilities.getLineFromContentTag(textTag, LabelConst.PAGE);
//			for (int i = 0; i < lineTemp.size(); i++) {
//				for (int j = 0; j < linesAndNumber.length; j++) {
//					if(lineTemp.get(i).getContent().equals(linesAndNumber[j].trim())){
//						lineTemp.get(i).getFeature().setCLinePosition(j + 1);
//						lineTemp.get(i).setNameLabel("PAGE");
//					}
//				}
//				lines.add(lineTemp.get(i));
//			}
//		}
	}
	
	public Line getLineWithPosition(float position){
		for (Line line : lines) {
			if(line.getFeature().getCLinePosition() == position){
				return line;
			}
		}		
		return null;
	}
	
	/**
	 * 
	 * @param label
	 * @return
	 * @Author : Huynh Minh Duc
	 * @Comment : get array list line with label.
	 */
	public ArrayList<Line> getLineWithLabel(int label){
		ArrayList<Line> list = new ArrayList<Line>();
		for (Line line : lines) {
			if(line.getLabel() == label){
				list.add(line);
			}
		}
		return list;
	}
	
	public Line get(int i){
		return lines.get(i);
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ArrayList<Line> getLine() {
		return lines;
	}

	public void setLine(ArrayList<Line> line) {
		this.lines = line;
	}
	
}
