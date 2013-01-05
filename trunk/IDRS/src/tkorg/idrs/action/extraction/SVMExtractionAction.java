/**
 * @author : Huynh Minh Duc
 * Apr 22, 2011
 * @comment : 
 */
package tkorg.idrs.action.extraction;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import tkorg.idrs.core.extraction.svm.Header;
import tkorg.idrs.core.extraction.svm.Line;
import tkorg.idrs.core.extraction.svm.SVMScale;
import tkorg.idrs.core.extraction.svm.SVMTest;
import tkorg.idrs.utilily.extraction.svm.HeaderReaderWriter;

/**
 * @author DucHuynh
 *
 */
public class SVMExtractionAction {
	public void calculateFeatureForAHeader(Header header) throws IOException{
		ArrayList<Line> line = header.getLine();
		String pathTestFile = "out//test.txt";
		String pathTestScaleFile = "out//test.scale.txt";
		StringBuffer testContent = new StringBuffer();
		for(int j = 0; j < line.size(); j++){			
			StringBuffer aLine = new StringBuffer();
			aLine.append(line.get(j).getLabel());
			aLine.append(" ");
			aLine.append("1:" + line.get(j).getFeature().getCSentenceLength());
			aLine.append(" ");
			aLine.append("2:" + line.get(j).getFeature().getCLinePosition());
			aLine.append(" ");
			aLine.append("3:" + line.get(j).getFeature().getCDictWordNumPer());
			aLine.append(" ");
			aLine.append("4:" + line.get(j).getFeature().getCNonDictWordNumPer());
			aLine.append(" ");
			aLine.append("5:" + line.get(j).getFeature().getCCap1DictWordNumPer());
			aLine.append(" ");
			aLine.append("6:" + line.get(j).getFeature().getCCap1NonDictWordNumPer());
			aLine.append(" ");
			aLine.append("7:" + line.get(j).getFeature().getCDigitNumPer());
			aLine.append(" ");
			aLine.append("8:" + line.get(j).getFeature().getCAffiNumPer());
			aLine.append(" ");
			aLine.append("9:" + line.get(j).getFeature().getCAddNumPer());
			aLine.append(" ");
			aLine.append("10:" + line.get(j).getFeature().getCDateNumPer());
			aLine.append(" ");
			aLine.append("11:" + line.get(j).getFeature().getCDegreeNumPer());
			aLine.append(" ");
			aLine.append("12:" + line.get(j).getFeature().getCPubNumPer());
			aLine.append(" ");
			aLine.append("13:" + line.get(j).getFeature().getCNoteNumPer());
			aLine.append(" ");
			aLine.append("14:" + line.get(j).getFeature().getCPhoneNumPer());				
			aLine.append("\n");
			System.out.println(aLine.toString());
			testContent.append(aLine.toString());
		}
		File testFile = new File(pathTestFile);		
		try {
			HeaderReaderWriter.write(testFile, testContent.toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error in write train file process");
		}
		
		//Scale feature.
		
		SVMScale s = new SVMScale();
		String command = "-l 0 -u 1 -s range out//test.txt";
		String testScale = s.run(command);
		
		testFile = new File(pathTestScaleFile);		
		try {
			HeaderReaderWriter.write(testFile, testScale);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error in write train file process");
		}
	}
	
	public String extract(){
		try {
			SVMTest testSVM = new SVMTest();
			String pathTestScaleFile = "out//test.scale.txt";
			String modelFileName = "out//train.model";
			String resultFileName = "out//result.txt";
			String message = testSVM.run(pathTestScaleFile, modelFileName, resultFileName);
			System.gc();
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error test SVM");
			return null;
		}		
	}
}
