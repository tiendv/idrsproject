/**
 * @author : Huynh Minh Duc
 * Mar 8, 2011
 * @comment : 
 */
package tkorg.idrs.action.extraction;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import tkorg.idrs.core.extraction.svm.FeatureIndependentGenerator;
import tkorg.idrs.core.extraction.svm.Header;
import tkorg.idrs.core.extraction.svm.SVMTest;
import tkorg.idrs.core.extraction.svm.SVMTrain;
import tkorg.idrs.gui.extraction.OpenDialog;
import tkorg.idrs.gui.main.IDRSApplication;


/**
 * @author MinhDuc
 *
 */
public class SVMMainAction {

	/**
	 * @author : Huynh Minh Duc
	 * Mar 8, 2011
	 * @param args
	 * @throws IOException 
	 * @comment :
	 */
	public static void main(String[] args) throws IOException {
		/*// TODO Auto-generated method stub
		Header[] headers = null;
		OpenDialog openDialog = new OpenDialog();
		int resultChoose = openDialog.showOpenDialog(IDRSApplication.idrsJFrame);
		if(resultChoose == JFileChooser.APPROVE_OPTION){
			File file = openDialog.getSelectedFile();
			final FeatureIndependentGenerator featureIndependentGenerator = new FeatureIndependentGenerator(file.getAbsolutePath());
			headers = featureIndependentGenerator.run();			
		}*/
		
//		// Training SVM.		
		/*try {
			SVMTrain t = new SVMTrain();
			String inputFileName = "out//train.scale.txt";
			String modelFileName = "out//train.model";
			t.run(inputFileName, modelFileName);
			System.gc();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error trainning SVM");
		}*/
		
		// Test SVM
		
		try {
			SVMTest testSVM = new SVMTest();
			String pathTestScaleFile = "out//test.scale.txt";
			String modelFileName = "out//train.model";
			String resultFileName = "out//result.txt";
			testSVM.run(pathTestScaleFile, modelFileName, resultFileName);
			System.gc();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error test SVM");
		}
	}

}
