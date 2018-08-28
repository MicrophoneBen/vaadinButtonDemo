package com.ghostben.myvaadinapp;

import java.util.Date;

import javax.servlet.annotation.WebServlet;

import com.ghostben.myvaadinapp.button.ButtonListener;
import com.ghostben.myvaadinapp.content.WindowView;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Notification.Type;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Title("MyVaddinApp")
@Theme("mytheme")
public class MyUI extends UI {

	//创建一个我们自己的界面类，用来加入到UI中
	WindowView myview = new WindowView();
	
	Window mainWindow = new Window("Helloworld Application");
    private static ButtonListener buttonListener;

	@Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final Layout lay = new HorizontalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener( e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });
        
        
        //创建另外一个button
        Button buttons = new Button("Click Me");
    	buttons.addClickListener(e -> {
    		Notification.show(new Date().toLocaleString(), Type.WARNING_MESSAGE);
    	});
    	
        mainWindow.setContent(myview);
        mainWindow.setSizeUndefined();
        mainWindow.setPosition(150, 150);
        mainWindow.setHeight("200px");
        mainWindow.setWidth("200px");
        mainWindow.setResizable(isReadOnly());
        Label label = new Label("Hello Vaadin user");
        MyUI.getCurrent().addWindow(mainWindow);
        Button btnCloseWin = new Button("Close Window", 
        		event->event.getButton().addClickListener(e->
        				{
        					MyUI.getCurrent().removeWindow(mainWindow);	
        				}));
        Button btnOpenWin = new Button("Open Window", 
        		event->event.getButton().addClickListener(e->
        		{
        			MyUI.getCurrent().addWindow(mainWindow);	
        		}));
        
        layout.addComponent(btnOpenWin);
        layout.addComponent(btnCloseWin);
        layout.addComponent(label);
        layout.setMargin(true);
        layout.setSpacing(true);
        layout.addComponent(buttons);
        layout.addComponents(name, button);
        
        buttonListener = new ButtonListener(layout);
        
        setContent(layout);
        //setContent(lay);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
