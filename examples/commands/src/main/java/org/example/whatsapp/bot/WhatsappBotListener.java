package org.example.whatsapp.bot;

import java.io.File;
import java.io.IOException;

import org.example.whatsapp.command.CommandManager;

import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

import it.auties.whatsapp4j.listener.RegisterListener;
import it.auties.whatsapp4j.listener.WhatsappListener;
import it.auties.whatsapp4j.protobuf.chat.Chat;
import it.auties.whatsapp4j.protobuf.info.MessageInfo;
import it.auties.whatsapp4j.response.impl.json.UserInformationResponse;
import it.auties.whatsapp4j.whatsapp.WhatsappAPI;
import lombok.NonNull;

@RegisterListener
public record WhatsappBotListener(Teste teste, WhatsappAPI api, CommandManager manager) implements WhatsappListener {
	
	
	
    @Override
    public void onNewMessage(@NonNull Chat chat, @NonNull MessageInfo info) {
        var textMessage = info.container().textMessage();
        if(textMessage == null){
            return;
        }

        manager.findCommand(textMessage.text()).ifPresent(command -> command.onCommand(api, chat, info));
    }
    
    @Override
    public void onLoggedIn(@NonNull UserInformationResponse info) {
    	// TODO Auto-generated method stub
    	WhatsappListener.super.onLoggedIn(info);
    	api.keys().serialize();
    	teste.sendHello(api);
    }
    
    @Override
    public void onQRCode(@NonNull BitMatrix qr) {
    	WhatsappListener.super.onQRCode(qr);
    	try {
			MatrixToImageWriter.writeToFile(qr,"png" , new File("C:\\work\\Nova pasta\\qrcode.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
