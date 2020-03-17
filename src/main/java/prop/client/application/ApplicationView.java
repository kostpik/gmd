/*
 * #%L
 * GwtMaterial
 * %%
 * Copyright (C) 2015 - 2017 GwtMaterialDesign
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package prop.client.application;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Document;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewImpl;

import gwt.material.design.addins.client.dnd.MaterialDnd;
import gwt.material.design.addins.client.dnd.constants.DragEvents;
import gwt.material.design.addins.client.dnd.constants.Restriction;
import gwt.material.design.addins.client.dnd.js.JsDragOptions;
import gwt.material.design.addins.client.splitpanel.MaterialSplitPanel;
import gwt.material.design.client.ui.*;
import prop.client.widget.breadcrumb.BreadcrumbEx;
import prop.client.widget.tree.TreeExam;

public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }
    
    

    @UiField
    MaterialContainer container;

    @UiField
    MaterialButton btnAdd;
    @UiField
    MaterialLink addDrag;
    
    @UiField
    MaterialLink deleteDrag;
    
    @UiField
    MaterialLink splitPanelButton;
    
    @UiField
    MaterialLink name;

    @UiField
    TreeExam tree;
    
    private int count;

	@UiField
	MaterialButton dragButton;
	
	@UiField
	MaterialSplitPanel splitPanel;
	
	private HandlerRegistration dragHandlerRegistration;

	private MaterialDnd dnd;

//    
//    @UiField
//    BreadcrumbEx breadcrumb;

    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    protected void onAttach() {
        super.onAttach();

        Document.get().getElementById("splashscreen").removeFromParent();
    }

    @UiHandler("btnAdd")
    void onAdd(ClickEvent e) {
        MaterialToast.fireToast("I love GMD");
        splitPanel.setStyleName("splitter");
    }
    
    @UiHandler("name")
    void printName(ClickEvent event) {
    	MaterialToast.fireToast("ТИХОН молодец");
    	name.setText("Тихон исправлется "+String.valueOf(count++));
    	splitPanel.removeStyleName("splitter");;
    
    }
    
    @UiHandler("addDrag")
    	void addDrag(ClickEvent event) {
    	 Restriction restriction = new Restriction();
    	 restriction.setEndOnly(false);
    	  dnd=MaterialDnd.draggable(dragButton, JsDragOptions.create(restriction));
//    	 restriction
    }
    @UiHandler("deleteDrag")
    void deleteDrag(ClickEvent event) {
      dragButton.getHandlerRegistry().clearHandlers();
      
    }
}

