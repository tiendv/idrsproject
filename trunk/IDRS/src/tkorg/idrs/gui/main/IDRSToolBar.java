package tkorg.idrs.gui.main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import tkorg.idrs.properties.files.GUIProperties;

public class IDRSToolBar extends JToolBar {
	
	private static final long serialVersionUID = 1L;
	
	private JButton openButton = null;
	private JButton runButton = null;
	private JButton manageButton = null;
	private JButton exportButton = null;
	
	public JButton getOpenButton() {
		if(openButton == null) {
			openButton = new JButton(new ImageIcon(getClass().getResource(GUIProperties.OPEN_ONTOLOGY_BUTTON_TOOLBAR)));
		}
		return openButton;
	}
	
	public JButton getRunButton() {
		if(runButton == null) {
			runButton = new JButton(new ImageIcon(getClass().getResource(GUIProperties.RUN_BUTTON_APPEAR_BUTTON_TOOLBAR)));
			runButton.setToolTipText(IDRSResourceBundle.res.getString("run"));
			runButton.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					ImageIcon icon = new ImageIcon(getClass().getResource(GUIProperties.RUN_BUTTON_PRESSED_BUTTON_TOOLBAR));
					runButton.setIcon(icon);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					ImageIcon icon = new ImageIcon(getClass().getResource(GUIProperties.RUN_BUTTON_APPEAR_BUTTON_TOOLBAR));
					runButton.setIcon(icon);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}});
		}
		return runButton;
	}
	
	public JButton getManageButton() {
		if(manageButton == null) {
			manageButton = new JButton(new ImageIcon(getClass().getResource(GUIProperties.OPEN_ONTOLOGY_BUTTON_TOOLBAR)));
		}
		return manageButton;
	}
	
	public JButton getExportButton() {
		if(exportButton == null) {
			exportButton = new JButton(new ImageIcon(getClass().getResource(GUIProperties.EXPORT_BUTTON_APPEAR_BUTTON_TOOLBAR)));
			exportButton.setToolTipText(IDRSResourceBundle.res.getString("export"));
			exportButton.addMouseListener(new MouseListener(){

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub
					ImageIcon icon = new ImageIcon(getClass().getResource(GUIProperties.EXPORT_BUTTON_PRESSED_BUTTON_TOOLBAR));
					exportButton.setIcon(icon);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub
					ImageIcon icon = new ImageIcon(getClass().getResource(GUIProperties.EXPORT_BUTTON_APPEAR_BUTTON_TOOLBAR));
					exportButton.setIcon(icon);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub
					
				}});
		}
		return exportButton;
	}
	public IDRSToolBar() {
		super();				
		add(getOpenButton());	
		add(getRunButton());
		add(getExportButton());
		add(getManageButton());
	}
}
