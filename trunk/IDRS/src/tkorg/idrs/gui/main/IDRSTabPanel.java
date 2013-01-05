package tkorg.idrs.gui.main;

/*
 * 
 * Author : Duchuynh.
 * Modifi: Tiendv.
 * 
 * 24/4  add tab seach.
 */

import javax.swing.JTabbedPane;

import tkorg.idrs.gui.extraction.InformationExtractionPanel;
import tkorg.idrs.gui.extraction.RuleExtractionPanel;
import tkorg.idrs.gui.extraction.SVMExtractionPanel;

public class IDRSTabPanel extends JTabbedPane{	
	
	private static final long serialVersionUID = 1L;
	private static InformationExtractionPanel informationExtractionPanel = null;
	
	public static RuleExtractionPanel ruleExtractionPanel = null;
	private static SVMExtractionPanel SVMExtractionPanel = null;
	
	
	public IDRSTabPanel() {
		super();	
		addTab(IDRSResourceBundle.res.getString("information.extraction"), getExtractionPanel());
		addTab(IDRSResourceBundle.res.getString("rule.panel"), getRuleExtractionPanel());
		addTab(IDRSResourceBundle.res.getString("svm.panel"), getSVMExtractionPanel());
	}
		
	/**
	 * 
	 */
	private InformationExtractionPanel getExtractionPanel() {
		if(informationExtractionPanel == null) {
			informationExtractionPanel = new InformationExtractionPanel();
		}
		return informationExtractionPanel;
	}
	
	private RuleExtractionPanel getRuleExtractionPanel() {
		if(ruleExtractionPanel == null) {
			ruleExtractionPanel = new RuleExtractionPanel();
		}
		return ruleExtractionPanel;
	}
	
	private SVMExtractionPanel getSVMExtractionPanel() {
		if(SVMExtractionPanel == null) {
			SVMExtractionPanel = new SVMExtractionPanel();
		}
		return SVMExtractionPanel;
	}
	
	/**
	 * 
	 * 
	 * @return
	 */
	public int getSelectedPanel() {
		return getSelectedIndex();
	};
	
	/**
	 * 
	 * 
	 */
	public static void updateTextOfComponents() {		
		
		//more panel update text of here....
	}
}
