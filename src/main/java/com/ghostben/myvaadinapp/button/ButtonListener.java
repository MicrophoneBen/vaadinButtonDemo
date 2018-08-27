package com.ghostben.myvaadinapp.button;

import java.util.Date;

import com.vaadin.ui.AbstractComponentContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Button.ClickEvent;

public class ButtonListener extends CustomComponent implements Button.ClickListener{
	
	/**
	 * 创建一个唯一的UID代表这个组件的使用存在
	 */
	private static final long serialVersionUID = 1L;

	Button btnone = new Button("按钮一");

	Button btntwo = new Button("按钮二");

	@Override
	public void buttonClick(ClickEvent event) {
		// TODO Auto-generated method stub
		
		if(event.getButton() == btnone) {
			String gmtString = new Date().toGMTString();
			btnone.addClickListener(e->{				
				Notification.show(gmtString);
			});
		}else if(event.getButton() == btntwo) {
			btntwo.addClickListener(e->{
				Notification.show("这是按钮二", "按钮二绑定的监听器", Type.HUMANIZED_MESSAGE);
			});
		}
		
	}
	
	/**
	 * 把创建好的button添加到我们的容器中，然后把容器做我们的组件
	 * 添加到UI界面
	 */	
	@SuppressWarnings("deprecation")
	public ButtonListener(AbstractComponentContainer contain) {
		btnone.addListener(this);
		contain.addComponent(btnone);
		
		
		btntwo.addListener(this);
		contain.addComponent(btntwo);
	}
	
}
