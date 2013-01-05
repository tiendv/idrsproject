/**
 * @author : Huynh Minh Duc
 * Feb 21, 2011
 * @comment : 
 */
package tkorg.idrs.gui.extraction;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.dyno.visual.swing.layouts.Bilateral;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

import tkorg.idrs.action.extraction.SVMExtractionAction;
import tkorg.idrs.core.extraction.svm.FeatureIndependentGenerator;
import tkorg.idrs.core.extraction.svm.Header;
import tkorg.idrs.core.extraction.svm.Line;
import tkorg.idrs.core.extraction.svm.LineSpecificFeature;
import tkorg.idrs.gui.main.IDRSApplication;
import tkorg.idrs.utilily.extraction.svm.HeaderReaderWriter;
import tkorg.idrs.utilily.extraction.svm.LabelConst;
import tkorg.idrs.utilily.extraction.svm.StatisticResult;

//VS4E -- DO NOT REMOVE THIS LINE!
public class SVMExtractionPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton openJButton;
	private JButton trainJButton;
	private JButton testJButton;
	private JPanel jPanel4;
	private JList headerJList;
	private JScrollPane jScrollPane0;
	private JTable featureJTable;
	private JScrollPane jScrollPane1;
	private JTable headerJTable;
	private JScrollPane jScrollPane2;
	private JPanel jPanel5;
	private JPanel jPanel0;
	private JPanel jPanel1;
	private JSplitPane jSplitPane0;
	private JList jList2;
	private JScrollPane jScrollPane6;
	private JTextArea statasticJTextArea;
	private JScrollPane jScrollPane7;
	private JScrollPane jScrollPane8;
	private JTable resultHeaderJTable;
	private JPanel jPanel6;
	
	public Header[] headers;

	public SVMExtractionPanel() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJSplitPane0(), new Constraints(new Bilateral(0, 0, 101), new Bilateral(0, 0, 64)));
		setSize(719, 517);
	}

	private JPanel getJPanel6() {
		if (jPanel6 == null) {
			jPanel6 = new JPanel();
			jPanel6.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null));
			jPanel6.setLayout(new GroupLayout());
			jPanel6.add(getJScrollPane6(), new Constraints(new Leading(11, 100, 12, 12), new Bilateral(11, 12, 22)));
			jPanel6.add(getJScrollPane7(), new Constraints(new Bilateral(495, 12, 22), new Bilateral(11, 12, 22)));
			jPanel6.add(getJScrollPane8(), new Constraints(new Leading(123, 360, 40, 78), new Bilateral(11, 12, 26, 403)));
		}
		return jPanel6;
	}

	private JScrollPane getJScrollPane8() {
		if (jScrollPane8 == null) {
			jScrollPane8 = new JScrollPane();
			jScrollPane8.setViewportView(getResultHeaderJTable());
		}
		return jScrollPane8;
	}

	private JTable getResultHeaderJTable() {
		if (resultHeaderJTable == null) {
			resultHeaderJTable = new JTable();
			resultHeaderJTable.setModel(new DefaultTableModel(new Object[][] { }, new String[] { "Line", "Lable", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return resultHeaderJTable;
	}

	private JScrollPane getJScrollPane7() {
		if (jScrollPane7 == null) {
			jScrollPane7 = new JScrollPane();
			jScrollPane7.setViewportView(getStatasticJTextArea());
		}
		return jScrollPane7;
	}

	private JTextArea getStatasticJTextArea() {
		if (statasticJTextArea == null) {
			statasticJTextArea = new JTextArea();
			statasticJTextArea.setText("Statistic");
		}
		return statasticJTextArea;
	}

	private JScrollPane getJScrollPane6() {
		if (jScrollPane6 == null) {
			jScrollPane6 = new JScrollPane();
			jScrollPane6.setViewportView(getJList2());
		}
		return jScrollPane6;
	}

	private JList getJList2() {
		if (jList2 == null) {
			jList2 = new JList();
			DefaultListModel listModel = new DefaultListModel();
			jList2.setModel(listModel);
		}
		return jList2;
	}

	private JSplitPane getJSplitPane0() {
		if (jSplitPane0 == null) {
			jSplitPane0 = new JSplitPane();
			jSplitPane0.setDividerLocation(318);
			jSplitPane0.setOrientation(JSplitPane.VERTICAL_SPLIT);
			jSplitPane0.setTopComponent(getJPanel0());
			jSplitPane0.setBottomComponent(getJPanel1());
		}
		return jSplitPane0;
	}

	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GroupLayout());
			jPanel1.add(getJPanel6(), new Constraints(new Bilateral(12, 12, 0), new Bilateral(12, 12, 0)));
		}
		return jPanel1;
	}

	private JPanel getJPanel0() {
		if (jPanel0 == null) {
			jPanel0 = new JPanel();
			jPanel0.setLayout(new GroupLayout());
			jPanel0.add(getJPanel4(), new Constraints(new Bilateral(12, 12, 0), new Leading(12, 51, 10, 10)));
			jPanel0.add(getJPanel5(), new Constraints(new Bilateral(12, 12, 0), new Bilateral(69, 12, 0)));
		}
		return jPanel0;
	}

	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			jPanel5 = new JPanel();
			jPanel5.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null));
			jPanel5.setLayout(new GroupLayout());
			jPanel5.add(getJScrollPane0(), new Constraints(new Leading(11, 100, 12, 12), new Bilateral(11, 12, 22)));
			jPanel5.add(getJScrollPane1(), new Constraints(new Trailing(12, 200, 45, 123), new Bilateral(12, 12, 26, 403)));
			jPanel5.add(getJScrollPane2(), new Constraints(new Bilateral(122, 224, 22), new Bilateral(13, 12, 26, 403)));
		}
		return jPanel5;
	}

	private JScrollPane getJScrollPane2() {
		if (jScrollPane2 == null) {
			jScrollPane2 = new JScrollPane();
			jScrollPane2.setViewportView(getHeaderJTable());
		}
		return jScrollPane2;
	}
	
	private DefaultTableModel setDefaultTableModel(Header headers){	
		ArrayList<Line> lines = headers.getLine();
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Line");
		defaultTableModel.addColumn("Label");
		Object[] dataLineColumnObjects = new Object[2];			
		for (int i = 0; i < lines.size(); i++) {			
			dataLineColumnObjects[0] = lines.get(i).getContent();
			dataLineColumnObjects[1] = lines.get(i).getLabel() + " (" + lines.get(i).getNameLabel() + ")";
			defaultTableModel.addRow(dataLineColumnObjects);
		}
		return defaultTableModel;
	}
	
	private JTable getHeaderJTable() {
		if (headerJTable == null) {
			headerJTable = new JTable();	
			headerJTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			headerJTable.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "Line", "Label", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});		
			headerJTable.getColumnModel().getColumn(0).setPreferredWidth(500);
			headerJTable.getColumnModel().getColumn(1).setPreferredWidth(40);
			headerJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					int headerNumber = headerJList.getSelectedIndex();
					int lineNumber = headerJTable.getSelectedRow();
					ArrayList<Line> lines = headers[headerNumber].getLine();
					featureJTable.setModel(setFeatureTableModel(lines.get(lineNumber)));									
				}				
			});
		}
		return headerJTable;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getFeatureJTable());
		}
		return jScrollPane1;
	}
	
	private DefaultTableModel setFeatureTableModel(Line line){
		DefaultTableModel defaultTableModel = new DefaultTableModel();
		LineSpecificFeature featureOfLine = line.getFeature();
		defaultTableModel.addColumn("Line");
		defaultTableModel.addColumn("Label");
		Object[] dataLineColumnObjects = new Object[2];	
		
		dataLineColumnObjects[0] = "cSentenceLength";
		dataLineColumnObjects[1] = featureOfLine.getCSentenceLength();
		defaultTableModel.addRow(dataLineColumnObjects);		
		
		dataLineColumnObjects[0] = "cLinePosition";
		dataLineColumnObjects[1] = featureOfLine.getCLinePosition();
		defaultTableModel.addRow(dataLineColumnObjects);		
		
		dataLineColumnObjects[0] = "cDictWordNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCDictWordNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);		
		
		dataLineColumnObjects[0] = "cNonDictWordNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCNonDictWordNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);		
		
		dataLineColumnObjects[0] = "cCap1DictWordNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCCap1DictWordNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);		
		
		dataLineColumnObjects[0] = "cCap1NonDictWordNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCCap1NonDictWordNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);	
		
		dataLineColumnObjects[0] = "cAffiNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCAffiNumPer();		
		defaultTableModel.addRow(dataLineColumnObjects);	
		
		dataLineColumnObjects[0] = "cDigitNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCDigitNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);	
		
		dataLineColumnObjects[0] = "cDateNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCDateNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);	
		
		dataLineColumnObjects[0] = "cAddNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCAddNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);
		
		dataLineColumnObjects[0] = "cDegreeNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCDegreeNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);	
		
		dataLineColumnObjects[0] = "cPhoneNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCPhoneNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);	
		
		dataLineColumnObjects[0] = "cPubNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCPubNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);	
		
		dataLineColumnObjects[0] = "cNoteNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCNoteNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);	
		
		dataLineColumnObjects[0] = "cPageNumPer";
		dataLineColumnObjects[1] = featureOfLine.getCPageNumPer();
		defaultTableModel.addRow(dataLineColumnObjects);
	
		return defaultTableModel;
	}
	
	private JTable getFeatureJTable() {
		if (featureJTable == null) {
			featureJTable = new JTable();
			featureJTable.setModel(new DefaultTableModel(new Object[][] { }, new String[] { "Feature", "Value", }) {
				private static final long serialVersionUID = 1L;
				Class<?>[] types = new Class<?>[] { Object.class, Object.class, };
	
				public Class<?> getColumnClass(int columnIndex) {
					return types[columnIndex];
				}
			});
		}
		return featureJTable;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getHeaderJList());
		}
		return jScrollPane0;
	}

	private JList getHeaderJList() {
		if (headerJList == null) {
			headerJList = new JList();
			DefaultListModel listModel = new DefaultListModel();
			headerJList.setModel(listModel);
			headerJList.addListSelectionListener(new ListSelectionListener(){

				@Override
				public void valueChanged(ListSelectionEvent e) {
					// TODO Auto-generated method stub
					int number = headerJList.getSelectedIndex();					
					DefaultTableModel defaultTableModel = setDefaultTableModel(headers[number]);
					headerJTable.setModel(defaultTableModel);	
					headerJTable.getColumnModel().getColumn(0).setPreferredWidth(500);
					headerJTable.getColumnModel().getColumn(1).setPreferredWidth(40);
				}				
			});
		}
		return headerJList;
	}

	private JPanel getJPanel4() {
		if (jPanel4 == null) {
			jPanel4 = new JPanel();
			jPanel4.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null));
			jPanel4.setLayout(new GroupLayout());
			jPanel4.add(getOpenJButton(), new Constraints(new Leading(12, 12, 12), new Leading(12, 12, 12)));
			jPanel4.add(getTestJButton(), new Constraints(new Trailing(12, 613, 613), new Leading(12, 12, 12)));
			jPanel4.add(getTrainJButton(), new Constraints(new Trailing(89, 110, 110), new Leading(12, 12, 12)));
		}
		return jPanel4;
	}

	private JButton getTestJButton() {
		if (testJButton == null) {
			testJButton = new JButton();
			testJButton.setText("Test");
			testJButton.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					SVMExtractionAction action = new SVMExtractionAction();
					int number = headerJList.getSelectedIndex();	
					jList2.setModel(setHeaderModel(number + 1));	
					try {
						action.calculateFeatureForAHeader(headers[number]);						
						String message = action.extract();
						
						String resultFileName = "out//result.txt";
						ArrayList<String> listResultLine = new ArrayList<String>();
						listResultLine = HeaderReaderWriter.readTextFile(resultFileName);
						
						ArrayList<Line> lines = headers[number].getLine();
						DefaultTableModel defaultTableModel = new DefaultTableModel();
						defaultTableModel.addColumn("Line");
						defaultTableModel.addColumn("Label");
						Object[] dataLineColumnObjects = new Object[2];	
						
						for (int i = 0; i < lines.size(); i++) {			
							dataLineColumnObjects[0] = lines.get(i).getContent();
							int numberSwitch = (int) Float.parseFloat(listResultLine.get(i));
							switch (numberSwitch){
							case 1:
								dataLineColumnObjects[1] = listResultLine.get(i) + " TITLE";
								break;
							case 2:
								dataLineColumnObjects[1] = listResultLine.get(i) +  " AUTHOR";
								break;
							case 3:
								dataLineColumnObjects[1] = listResultLine.get(i) + " AFFILIATION";
								break;
							case 4:
								dataLineColumnObjects[1] = listResultLine.get(i) + " ADDRESS";
								break;
//							case 5:
//								dataLineColumnObjects[1] = listResultLine.get(i) + " NOTE";
//								break;
							case 5:
								dataLineColumnObjects[1] = listResultLine.get(i) + " EMAIL";
								break;
							case 6:
								dataLineColumnObjects[1] = listResultLine.get(i) + " DATE";
								break;
							case 7:
								dataLineColumnObjects[1] = listResultLine.get(i) + " ABTRACT";
								break;
//							case 9:
//								dataLineColumnObjects[1] = listResultLine.get(i) + " INTRODUCTION";
//								break;
//							case 10:
//								dataLineColumnObjects[1] = listResultLine.get(i) + " PHONE";
//								break;
							case 8:
								dataLineColumnObjects[1] = listResultLine.get(i) + " KEYWORD";
								break;
//							case 12:
//								dataLineColumnObjects[1] = listResultLine.get(i) + " WEB";
//								break;
//							case 13:
//								dataLineColumnObjects[1] = listResultLine.get(i) + " DEGREE";
//								break;
//							case 14:
//								dataLineColumnObjects[1] = listResultLine.get(i) + " PUBNUM";
//								break;
//							case 15:
//								dataLineColumnObjects[1] = listResultLine.get(i) + " PAGE";
//								break;	
							default:
								dataLineColumnObjects[1] = listResultLine.get(i) +  " null";
								break;
							}
							defaultTableModel.addRow(dataLineColumnObjects);
						}
						
						resultHeaderJTable.setModel(defaultTableModel);
						
						/// Statistic for result : 
						String pathTestScaleFile = "out//test.scale.txt";
						StatisticResult sr = new StatisticResult();
						
						StringBuffer stringBuffer = new StringBuffer();
						
						sr.buildLableMap(resultFileName, pathTestScaleFile);
						stringBuffer.append(message);
						stringBuffer.append("\n");
						stringBuffer.append(sr.returnResultBy(LabelConst.ABSTRACT));
						stringBuffer.append("\n");
						stringBuffer.append(sr.returnResultBy(LabelConst.ADDRESS));
						stringBuffer.append("\n");
						stringBuffer.append(sr.returnResultBy(LabelConst.AFFILIATION));
						stringBuffer.append("\n");
						stringBuffer.append(sr.returnResultBy(LabelConst.AUTHOR));
						stringBuffer.append("\n");
						stringBuffer.append(sr.returnResultBy(LabelConst.DATE));
						stringBuffer.append("\n");
//						stringBuffer.append(sr.returnResultBy(LabelConst.DEGREE));
						stringBuffer.append("\n");
						stringBuffer.append(sr.returnResultBy(LabelConst.EMAIL));
						stringBuffer.append("\n");
//						stringBuffer.append(sr.returnResultBy(LabelConst.INTRODUCTION));
						stringBuffer.append("\n");
						stringBuffer.append(sr.returnResultBy(LabelConst.KEYWORD));
						stringBuffer.append("\n");
//						stringBuffer.append(sr.returnResultBy(LabelConst.NOTE));
//						stringBuffer.append("\n");
//						stringBuffer.append(sr.returnResultBy(LabelConst.PAGE));
//						stringBuffer.append("\n");
//						stringBuffer.append(sr.returnResultBy(LabelConst.PHONE));
						stringBuffer.append("\n");
////						stringBuffer.append(sr.returnResultBy(LabelConst.PUBNUM));
//						stringBuffer.append("\n");
						stringBuffer.append(sr.returnResultBy(LabelConst.TITLE));
//						stringBuffer.append("\n");
////						stringBuffer.append(sr.returnResultBy(LabelConst.WEB));
						
						statasticJTextArea.setText(stringBuffer.toString());
						
						System.out.println("Done");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			});
		}
		return testJButton;
	}

	private JButton getTrainJButton() {
		if (trainJButton == null) {
			trainJButton = new JButton();
			trainJButton.setText("Train");
			trainJButton.setVisible(false);
		}
		return trainJButton;
	}

	private JButton getOpenJButton() {
		if (openJButton == null) {
			openJButton = new JButton();
			openJButton.setText("Open File");
			openJButton.addActionListener(new ActionListener(){

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
									headers = featureIndependentGenerator.run();
									headerJList.setModel(setHeaderModel(headers));
								}catch (Exception ex){
									JOptionPane.showMessageDialog(null, ex.getMessage());
								}

								IDRSApplication.idrsStatus.setLoadingStatusBar(false);
								IDRSApplication.idrsStatus.setMessage("Finish");
								IDRSApplication.idrsJFrame.setCursor(null);
								JOptionPane.showMessageDialog(IDRSApplication.idrsJFrame, "Loaded");

							}							
						});
						thread.start();			
					}
				}
			});
		}
		return openJButton;
	}
	
	public DefaultListModel setHeaderModel(Header[] headers){
		DefaultListModel listModel = new DefaultListModel();
		for (int i = 0; i < headers.length; i++) {
			listModel.addElement("Header " + (i + 1));			
		}		
		return listModel;
	}
	
	public DefaultListModel setHeaderModel(int number){
		DefaultListModel listModel = new DefaultListModel();		
		listModel.addElement("Header " + number);			
			
		return listModel;
	}
}
