package com.ghostben.myvaadinapp.content;

import java.util.Date;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

public class WindowView extends CustomComponent {
	
	Label label = new Label("Hello Vaadin user");
	TextField field = new TextField();
	final Button click = new Button("Click This",new Button.ClickListener() {
		/**
		 * Button 监听器
		 */
		private static final long serialVersionUID = 1L;

		public void buttonClick(ClickEvent event) {
			event.getButton().setCaption( "The time is " + new Date());
			}
		});
	@SuppressWarnings("deprecation")
	final Button button = new Button("系统时间", 
			event->event.getButton().addClickListener(e -> {
				Notification.show(new Date().toLocaleString(), "这是系统时间", Type.WARNING_MESSAGE);
			}));
	
	public WindowView() {  
		Layout layout = new VerticalLayout();
		layout.addComponent(button);
		layout.addComponent(field);
		layout.addComponent(label);
		layout.addComponent(click);
		setCompositionRoot(layout);
		setSizeFull();
	}
	
}
