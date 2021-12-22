package org.example.whatsapp.bot;

import it.auties.whatsapp4j.protobuf.message.standard.TextMessage;
import it.auties.whatsapp4j.whatsapp.WhatsappAPI;

public class Teste{
	
	public void sendHello(WhatsappAPI api) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	var chat = api.manager().findChatByJid("5511976990997@s.whatsapp.net").orElseThrow();
    	api.sendMessage(chat, new TextMessage("Teste :)"));
	}
	
}