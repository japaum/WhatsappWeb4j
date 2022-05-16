package it.auties.whatsapp4j.utils.internal;

import java.util.HashMap;
import java.util.Map;

import it.auties.whatsapp4j.manager.WhatsappDataManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class WhatsappDataManagerUtils {

	private static final WhatsappDataManagerUtils WHATSAPP_DATA_MANAGER_UTILS = new WhatsappDataManagerUtils();
	private Map<String,WhatsappDataManager> datas = new HashMap<String,WhatsappDataManager>();
	
	public static WhatsappDataManagerUtils getInstance() {
		return WHATSAPP_DATA_MANAGER_UTILS;
	}
	
	public WhatsappDataManager getDataManager(String user) {
		if(!datas.containsKey(user)) {
			datas.put(user, WhatsappDataManager.instance());
		}
		return datas.get(user);
	}
}
