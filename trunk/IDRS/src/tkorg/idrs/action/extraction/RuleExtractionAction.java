/**
 * @author : Huynh Minh Duc
 * Mar 1, 2011
 * @comment : 
 */
package tkorg.idrs.action.extraction;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;

import gate.creole.ExecutionException;
import gate.creole.ResourceInstantiationException;
import tkorg.idrs.core.extraction.GateExtractionObject;
import tkorg.idrs.core.extraction.PaperCollection;
import tkorg.idrs.core.extraction.svm.FeatureIndependentGenerator;
import tkorg.idrs.core.extraction.svm.Header;
import tkorg.idrs.core.extraction.svm.SVMScale;
import tkorg.idrs.gui.extraction.OpenDialog;
import tkorg.idrs.gui.main.IDRSApplication;

/**
 * @author MinhDuc
 *
 */
public class RuleExtractionAction {
	GateExtractionObject gateExtractionObject = null;
	public RuleExtractionAction(){
		System.gc();
		gateExtractionObject = new GateExtractionObject(1);
	}
	
	public PaperCollection extractHeader(Header[] headers, int selected) throws ExecutionException, ResourceInstantiationException{
		PaperCollection paperCollection = null;
		System.gc();
		paperCollection = gateExtractionObject.executeForRulePanel(headers, selected);
		return paperCollection;
	}
	public static void main(String argv[]) throws IOException, ExecutionException, ResourceInstantiationException
	{
		Header[] headers = null;
	
		File file = new File("tagged_headers.txt");
		final FeatureIndependentGenerator featureIndependentGenerator = new FeatureIndependentGenerator(file.getAbsolutePath());
		headers = featureIndependentGenerator.runForRulePanel();			
		
		RuleExtractionAction ruleExtractionAction = new RuleExtractionAction();	
		PaperCollection paperCollection = ruleExtractionAction.extractHeader(headers, 611);
		System.exit(0);		
	}
}
