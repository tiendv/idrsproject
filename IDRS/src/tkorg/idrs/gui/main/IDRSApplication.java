package tkorg.idrs.gui.main;
/*
 * 
 * author: duchuynh
 *  modif :tiendv
 *  
 *  27/4 add seach menu 
 */

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Event;
import java.awt.BorderLayout;
import java.util.Locale;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.KeyStroke;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import tkorg.idrs.gui.extraction.InformationExtractionMenu;
import tkorg.idrs.properties.files.IDRSModulesProperties;
public class IDRSApplication {
	
	public static JFrame idrsJFrame = null;  //  @jve:decl-index=0:visual-constraint="170,36"

	private JMenuBar jJMenuBar = null;
	
	private static JMenu fileMenu = null;
	private static JMenu editMenu = null;
	private static JMenu optionMenu = null;
	private static JMenu helpMenu = null;
	private static InformationExtractionMenu informationExtractionMenu = null;
	
	private static JMenuItem exitMenuItem = null;
	private static JMenuItem cutMenuItem = null;
	private static JMenuItem copyMenuItem = null;
	private static JMenuItem pasteMenuItem = null;
	private static JMenuItem saveMenuItem = null;
	private static JMenuItem configuarionMenuItem = null;	
	private static JMenuItem aboutMenuItem = null;
	
	public static IDRSStatusBar idrsStatus = null;
	private IDRSToolBar idrsToolBar = null;	
	private static IDRSTabPanel idrsTabPanel = null;	
	
	  //  @jve:decl-index=0:
	/**
	 * This method initializes idrsJFrame
	 */
	private JFrame getIDRSJFrame() {
		if (idrsJFrame == null) {
			idrsJFrame = new JFrame();
			idrsJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			idrsJFrame.setJMenuBar(getJJMenuBar());
			idrsJFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);

			ComponentUtilities.setMiniSize(idrsJFrame);
			idrsJFrame.setTitle(IDRSResourceBundle.res.getString("application.name"));
			idrsJFrame.getContentPane().add(getIDRSToolBar(), BorderLayout.NORTH);
			idrsJFrame.getContentPane().add(getIDRSTabPanel(), BorderLayout.CENTER);
			idrsJFrame.getContentPane().add(getIDRSStatusBar(), BorderLayout.SOUTH);
		
			
		}
		return idrsJFrame;
	}

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getEditMenu());
			jJMenuBar.add(getOptionMenu());
			jJMenuBar.add(getExtractionMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}


	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText(IDRSResourceBundle.res.getString("file"));
			fileMenu.add(getSaveMenuItem());
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getEditMenu() {
		if (editMenu == null) {
			editMenu = new JMenu();
			editMenu.setText(IDRSResourceBundle.res.getString("edit"));
			editMenu.add(getCutMenuItem());
			editMenu.add(getCopyMenuItem());
			editMenu.add(getPasteMenuItem());
		}
		return editMenu;
	}

	/**
	 * 
	 * @return
	 */
	private JMenu getOptionMenu() {
		if (optionMenu == null) {
			optionMenu = new JMenu();
			optionMenu.setText(IDRSResourceBundle.res.getString("option"));
			optionMenu.add(getConfigurationMenuItem());
		}
		return optionMenu;
	}
	
	
	/**
	 * 
	 * 
	 * @return
	 */
	private InformationExtractionMenu getExtractionMenu(){
		if(informationExtractionMenu == null){
			informationExtractionMenu = new InformationExtractionMenu();
			informationExtractionMenu.setText(IDRSResourceBundle.res.getString("information.extraction"));
		}
		return informationExtractionMenu;	
	}
	
	/**
	 * This method initializes jMenu	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText(IDRSResourceBundle.res.getString("help"));
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}
	
	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText(IDRSResourceBundle.res.getString("edit"));
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}
	
	/**
	 * 
	 * @return
	 */
	private JMenuItem getConfigurationMenuItem() {
		if (configuarionMenuItem == null) {
			configuarionMenuItem = new JMenuItem();
			configuarionMenuItem.setText(IDRSResourceBundle.res.getString("configuation"));
			configuarionMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IDRSConfigurationDialog configurationDlg = new IDRSConfigurationDialog(idrsJFrame);
					configurationDlg.setVisible(true);
				}
			});
		}
		return configuarionMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText(IDRSResourceBundle.res.getString("about"));
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IDRSAboutDialog aboutDialog = new IDRSAboutDialog(idrsJFrame);
					aboutDialog.setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}
	
	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCutMenuItem() {
		if (cutMenuItem == null) {
			cutMenuItem = new JMenuItem();
			cutMenuItem.setText(IDRSResourceBundle.res.getString("cut"));
			cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,
					Event.CTRL_MASK, true));
		}
		return cutMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCopyMenuItem() {
		if (copyMenuItem == null) {
			copyMenuItem = new JMenuItem();
			copyMenuItem.setText(IDRSResourceBundle.res.getString("copy"));
			copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
					Event.CTRL_MASK, true));
		}
		return copyMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getPasteMenuItem() {
		if (pasteMenuItem == null) {
			pasteMenuItem = new JMenuItem();
			pasteMenuItem.setText(IDRSResourceBundle.res.getString("paste"));
			pasteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,
					Event.CTRL_MASK, true));
		}
		return pasteMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText(IDRSResourceBundle.res.getString("save"));
			saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
					Event.CTRL_MASK, true));
		}
		return saveMenuItem;
	}
	
	/**
	 * This method initializes IDRS Status Bar	
	 * 	
	 * @return tkorg.idrs.gui.ontology.IDRSStatusBar	
	 */
	private IDRSStatusBar getIDRSStatusBar() {
		if(idrsStatus == null) {
			idrsStatus = new IDRSStatusBar();
		}		
		return idrsStatus;
	}
	
	
	/**
	 * This method initializes IDRS Status Bar	
	 * 	
	 * @return tkorg.idrs.gui.ontology.IDRSStatusBar	
	 */
	private IDRSToolBar getIDRSToolBar() {
		if(idrsToolBar == null) {
			idrsToolBar = new IDRSToolBar();
			
		}
		return idrsToolBar;
	}	
	
	
	/**
	 * 
	 * 
	 */
	public void disableIDRSToolBar() {
		if(idrsToolBar != null){
			idrsJFrame.getContentPane().remove(idrsToolBar);
		}
	}
	
	/*
	 * 
	 * 
	 */
	private IDRSTabPanel getIDRSTabPanel() {
		if(idrsTabPanel == null){
			idrsTabPanel = new IDRSTabPanel();
			idrsTabPanel.addChangeListener(new ChangeListener(){

				@Override
				public void stateChanged(ChangeEvent e) {
					// TODO Auto-generated method stub
					setIDRSToolBar(idrsTabPanel.getSelectedIndex() + 1);
				}
				
			});
		}
		return idrsTabPanel;
	}
	/**
	 *  
	 * @param IDToolBar
	 */
	public void setIDRSToolBar(int IDToolBar){
		switch (IDToolBar) {
			case IDRSModulesProperties.EXTRACTION_MODULE_NAME:				
				
				idrsJFrame.getContentPane().repaint();			
				//idrsJFrame.getContentPane().add(getInformationExtractionToolBar(), BorderLayout.NORTH);
				idrsJFrame.invalidate();
				idrsJFrame.validate();
				idrsJFrame.getContentPane().repaint();
				break;			
		}
	}	
	
	/**
	 * 
	 * 
	 */
	public static void updateTextOfComponents(){
		
		idrsJFrame.setTitle(IDRSResourceBundle.res.getString("application.name"));
		
		fileMenu.setText(IDRSResourceBundle.res.getString("file"));
		editMenu.setText(IDRSResourceBundle.res.getString("edit"));
		optionMenu.setText(IDRSResourceBundle.res.getString("option"));		
		informationExtractionMenu.setText(IDRSResourceBundle.res.getString("information.extraction"));		
		helpMenu.setText(IDRSResourceBundle.res.getString("help"));
		
		exitMenuItem.setText(IDRSResourceBundle.res.getString("edit"));
		configuarionMenuItem.setText(IDRSResourceBundle.res.getString("configuation"));
		aboutMenuItem.setText(IDRSResourceBundle.res.getString("about"));
		cutMenuItem.setText(IDRSResourceBundle.res.getString("cut"));
		copyMenuItem.setText(IDRSResourceBundle.res.getString("copy"));
		pasteMenuItem.setText(IDRSResourceBundle.res.getString("paste"));
		saveMenuItem.setText(IDRSResourceBundle.res.getString("save"));
		
		idrsTabPanel.updateTextOfComponents();
		idrsStatus.setMessage(IDRSResourceBundle.res.getString("copyright"));
				
		//idrsTabPanel.setTitleAt(3, IDRSResourceBundle.res.getString("information.extraction"));		
	}
	
	/**
	 * 
	 * Launches this application
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					Locale locale = Locale.US;
					Locale.setDefault(locale);	
					IDRSResourceBundle.res = IDRSResourceBundle.initResources();
					UIManager.setLookAndFeel("ch.randelshofer.quaqua.QuaquaLookAndFeel");
					IDRSApplication application = new IDRSApplication();
					application.getIDRSJFrame().setVisible(true);
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
}
