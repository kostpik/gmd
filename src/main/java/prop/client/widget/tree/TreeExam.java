package prop.client.widget.tree;

import org.eclipse.jetty.jndi.java.javaNameParser;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.i18n.server.testing.Child;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.addins.client.tree.MaterialTree;
import gwt.material.design.addins.client.tree.MaterialTreeItem;
import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialToast;

public class TreeExam extends Composite implements HasText {

	private static TreeExamUiBinder uiBinder = GWT.create(TreeExamUiBinder.class);

	interface TreeExamUiBinder extends UiBinder<Widget, TreeExam> {
	}

	public TreeExam() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiField
	MaterialTree root;
	
	@UiField
	MaterialLabel total;

	@UiField
	MaterialButton button;
	@UiField
	MaterialButton minus;
    double summaring=0;
    
	public TreeExam(String firstName) {
		initWidget(uiBinder.createAndBindUi(this));
		button.setText(firstName);
	}

	@UiHandler("button")
	void onClick(ClickEvent e) {
		if(root.getSelectedItem().isEnabled()) {
		Double rnd = Math.random()*100;
		summaring+=rnd;
		MaterialToast.fireToast("Total "+ summaring);
			addItemToTree(generateItem(rnd));		 		
		total.setText(String.valueOf(summaring));
		total.setTextColor(Color.CYAN_ACCENT_1);
		total.setBackgroundColor(Color.BLUE_ACCENT_1);
		}
	}
	
	@UiHandler("minus")
	void onClicked(ClickEvent e) {
		
       root.getSelectedItem().removeFromTree();
	}
	
	public void setText(String text) {
		button.setText(text);
	}

	public String getText() {
		return button.getText();
	}
	
	public MaterialTreeItem generateItem(Double id) {
		
		MaterialTreeItem item = new MaterialTreeItem();
		item.setText(String.valueOf(id));
		item.setVisible(true);
		return item;
	}
	
	public void addItemToTree(MaterialTreeItem item) {
		root.getSelectedItem().addItem(item);
		
	}
	

}
