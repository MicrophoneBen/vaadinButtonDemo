package com.ghostben.myvaadinapp.content;

import java.util.Date;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class WindowView extends CustomComponent {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Label label = new Label("Hello Vaadin user");
	TextField field = new TextField();
	Label display = new Label("See this");
	final Button click = new Button("Click This",new Button.ClickListener() {
		/**
		 * Button 监听器
		 */
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
			event.getButton().setCaption( "The time is " + new Date());
			}
		});
	
	public WindowView() {  
		Layout layout = new VerticalLayout();
		field.setSizeFull();
		layout.addComponent(field);
		layout.addComponent(label);
		layout.addComponent(display);
		layout.addComponent(click);
		setCompositionRoot(layout);
		setSizeFull();
	
	}
	
}
