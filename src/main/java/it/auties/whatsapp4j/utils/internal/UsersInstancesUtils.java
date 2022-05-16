package it.auties.whatsapp4j.utils.internal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;

import it.auties.whatsapp4j.manager.WhatsappDataManager;


public class UsersInstancesUtils {
	
	@Autowired
	ObjectFactory<HttpSession> httpSessionFactory;
	
	
	public WhatsappDataManager getDataManager() {
		HttpSession session = httpSessionFactory.getObject();
		String user = (String) session.getAttribute("user");
		return WhatsappDataManagerUtils.getInstance().getDataManager(user);
	}
	
}
