/**
 * @author : Huynh Minh Duc
 * Feb 20, 2011
 * @comment : 
 */
package tkorg.idrs.gui.extraction;

import gate.creole.ExecutionException;
import gate.creole.ResourceInstantiationException;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import tkorg.idrs.action.extraction.RuleExtractionAction;
import tkorg.idrs.core.extraction.GateExtractionObject;
import tkorg.idrs.core.extraction.PaperCollection;
import tkorg.idrs.core.extraction.svm.Header;
import tkorg.idrs.core.extraction.svm.FeatureIndependentGenerator;
import tkorg.idrs.core.extraction.svm.Line;

import tkorg.idrs.gui.main.IDRSApplication;
import tkorg.idrs.gui.main.IDRSResourceBundle;
import tkorg.idrs.gui.main.IDRSStatusBar;

//VS4E -- DO NOT REMOVE THIS LINE!
public class RuleExtractionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JList jList1;
	private JScrollPane jScrollPane2;
	private JTextArea jTextArea2;
	private JScrollPane jScrollPane4;
	private JTextArea jTextArea1;
	private JScrollPane jScrollPane3;
	private JPanel jPanel1;
	private JList headerJList;
	private JScrollPane jScrollPane0;
	private JTextArea contenHeaderJTextArea;
	private JScrollPane jScrollPane1;
	private JPanel jPanel0;
	private JButton browersJButton;
	private JButton runButton;
	private JPanel jPanel2;
	
	public Header[] headers;

	public RuleExtractionPanel() {
		initComponents();
	}
	
	public Header[] getHeaders(){
		return headers;
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJPanel2(), new Constraints(new Bilateral(14, 12, 0), new Leading(12, 46, 99, 179)));
		add(getJPanel0(), new Constraints(new Bilateral(12, 13, 176), new Leading(64, 262, 10, 10)));
		add(getJPanel1(), new Constraints(new Bilateral(12, 12, 0), new Trailing(12, 193, 10, 10)));
		setSize(711, 534);
	}
	
	public DefaultListModel setHeaderModel(Header[] headers){
		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < headers.length; i++) {
			listModel.addElement("Header " + (i + 1));			
		}		
		return listModel;
	}
	
	private JList getJList1() {
		if (jList1 == null) {
			jList1 = new JList();
			jList1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null));
			DefaultListModel listModel = new DefaultListModel();
			jList1.setModel(listModel);
		}
		return jList1;
	}

	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			jPanel2 = new JPanel();
			jPanel2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null));
			jPanel2.setLayout(new GroupLayout());
			jPanel2.add(getBrowersJButton(), new Constraints(new Leading(12, 12, 12), new Leading(4, 32, 10, 10)));
			jPanel2.add(getRunButton(), new Constraints(new Leading(116, 12, 12), new Leading(4, 32, 12, 12)));
		}
		return jPanel2;
	}

	private JButton getRunButton() {
		if (runButton == null) {
			runButton = new JButton();
			runButton.setText("Run");
			runButton.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					final int headerSelected = headerJList.getSelectedIndex() + 1;
					String message = "Extract header : " + headerSelected;
					int result = JOptionPane.showConfirmDialog(IDRSApplication.idrsJFrame, message, "Extract Option", JOptionPane.OK_CANCEL_OPTION);
					if(result == JOptionPane.OK_OPTION){
						DefaultListModel listModel = new DefaultListModel();
						listModel.addElement("Header " + headerSelected);	
						jList1.setModel(listModel);
						Thread thread = new Thread(new Runnable() {
							@Override
							public void run() {		
								IDRSApplication.idrsJFrame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));									
								IDRSApplication.idrsStatus.setLoadingStatusBar(true);								
								IDRSApplication.idrsStatus.setMessage("Loading Annie.....");	
								
								final RuleExtractionAction ruleExtractionAction = new RuleExtractionAction();
								
								IDRSApplication.idrsJFrame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));									
								IDRSApplication.idrsStatus.setLoadingStatusBar(true);								
								IDRSApplication.idrsStatus.setMessage("Running.....");	
								
								PaperCollection paperCollection;
								try {
									paperCollection = ruleExtractionAction.extractHeader(headers, headerSelected);
									StringBuffer extract = new StringBuffer();
									extract.append("Title : " + paperCollection.getPaperObject(0).getTitle());
									extract.append("\n");
									extract.append("Authors : " + paperCollection.getPaperObject(0).getAuthor().get(0).getName());
									extract.append("\n");
									extract.append("Affiliation : " + paperCollection.getPaperObject(0).getAffiliation());
									extract.append("\n");
									extract.append("Email : " + paperCollection.getPaperObject(0).getEmail());							
									extract.append("\n");
									extract.append("Date : " + paperCollection.getPaperObject(0).getDate());
									extract.append("\n");
									extract.append("Abstract : " + paperCollection.getPaperObject(0).getAbstractPaper());
									extract.append("\n");
									jTextArea1.setText(extract.toString());
								} catch (ExecutionException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								} catch (ResourceInstantiationException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								IDRSApplication.idrsStatus.setLoadingStatusBar(false);
								IDRSApplication.idrsStatus.setMessage("Finish");
								IDRSApplication.idrsJFrame.setCursor(null);
							}							
						});
						thread.start();
					}	
				}
								
			});
			System.out.println();
		}
		return runButton;
	}

	private JButton getBrowersJButton() {
		if (browersJButton == null) {
			browersJButton = new JButton();
			browersJButton.setText("Browers...");
			
			browersJButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					OpenDialog openDialog = new OpenDialog();
					int resultChoose = openDialog.showOpenDialog(IDRSApplication.idrsJFrame);
					if(resultChoose == JFileChooser.APPROVE_OPTION){
						File file = openDialog.getSelectedFile();
						final FeatureIndependentGenerator featureIndependentGenerator = new FeatureIndependentGenerator(file.getAbsolutePath());
						Thread thread = new Thread(new Runnable() {
							@Override
							public void run() {						
								IDRSApplication.idrsJFrame.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));									
								IDRSApplication.idrsStatus.setLoadingStatusBar(true);								
								IDRSApplication.idrsStatus.setMessage("Loading");								
								
								try {
									headers = featureIndependentGenerator.runForRulePanel();
									headerJList.setModel(setHeaderModel(headers));
								}catch (Exception ex){
									JOptionPane.showMessageDialog(null, ex.getMessage());
								}
								
								IDRSApplication.idrsStatus.setLoadingStatusBar(false);
								IDRSApplication.idrsStatus.setMessage("Finish");
								IDRSApplication.idrsJFrame.setCursor(null);
								JOptionPane.showMessageDialog(IDRSApplication.idrsJFrame, "Loading...............");
								
							}							
						});
					thread.start();	
					}					
				}
				
			});
		}
		System.gc();
		return browersJButton;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setBorder(BorderFactory.createTitledBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, null, null, null, null), "Header",
					TitledBorder.LEADING, TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJScrollPane1(), new Constraints(new Bilateral(130, 12, 22), new Leading(0, 224, 12, 12)));
			jPanel0.add(getJScrollPane0(), new Constraints(new Leading(11, 108, 10, 10), new Leading(2, 224, 10, 10)));
		}
		return jPanel0;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getContenHeaderJTextArea());
		}
		return jScrollPane1;
	}

	private JTextArea getContenHeaderJTextArea() {
		if (contenHeaderJTextArea == null) {
			contenHeaderJTextArea = new JTextArea();
			contenHeaderJTextArea.setText("Content header");
		}
		return contenHeaderJTextArea;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null));
			jScrollPane0.setAutoscrolls(true);
			jScrollPane0.setViewportView(getHeaderJList());
		}
		return jScrollPane0;
	}

	private JList getHeaderJList() {
		if (headerJList == null) {
			headerJList = new JList();
			headerJList.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null));
			DefaultListModel listModel = new DefaultListModel();
			headerJList.setModel(listModel);
			headerJList.addListSelectionListener(new ListSelectionListener(){

				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					int number = headerJList.getSelectedIndex();
					ArrayList<Line> lines= headers[number].getLine();
					StringBuffer buffer = new StringBuffer();
					for (Line line : lines) {
						buffer.append(line.getContent());
						buffer.append("\n");
					}
					contenHeaderJTextArea.setText(buffer.toString());
					jTextArea2.setText(headers[number].getContent());
				}
				
			});
		}
		return headerJList;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null), "Result", TitledBorder.LEADING,
					TitledBorder.TOP, new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJScrollPane2(), new Constraints(new Leading(12, 111, 12, 12), new Bilateral(0, 12, 22)));
			jPanel1.add(getJScrollPane4(), new Constraints(new Trailing(12, 349, 10, 10), new Bilateral(0, 12, 22)));
			jPanel1.add(getJScrollPane3(), new Constraints(new Bilateral(134, 373, 22), new Bilateral(0, 12, 22)));
		}
		return jPanel1;
	}

	private JScrollPane getJScrollPane3() {
		if (jScrollPane3 == null) {
			jScrollPane3 = new JScrollPane();
			jScrollPane3.setViewportView(getJTextArea1());
		}
		return jScrollPane3;
	}

	private JTextArea getJTextArea1() {
		if (jTextArea1 == null) {
			jTextArea1 = new JTextArea();
			jTextArea1.setWrapStyleWord(true);
		}
		return jTextArea1;
	}

	private JScrollPane getJScrollPane4() {
		if (jScrollPane4 == null) {
			jScrollPane4 = new JScrollPane();
			jScrollPane4.setViewportView(getJTextArea2());
		}
		return jScrollPane4;
	}

	private JTextArea getJTextArea2() {
		if (jTextArea2 == null) {
			jTextArea2 = new JTextArea();
		}
		return jTextArea2;
	}

	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getJList1());
		}
		return jScrollPane2;
	}

}
