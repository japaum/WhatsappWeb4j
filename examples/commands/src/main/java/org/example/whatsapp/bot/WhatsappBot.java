package org.example.whatsapp.bot;

import org.example.whatsapp.command.CommandManager;
import org.example.whatsapp.command.HelloCommand;

import it.auties.whatsapp4j.manager.WhatsappKeysManager;
import it.auties.whatsapp4j.whatsapp.WhatsappAPI;

// This is the main class of our bot
public class WhatsappBot {
    public static void main(String... args) {
        // Initialize the command manager
        var manager = new CommandManager();
        // Add all of our commands
        manager.addCommand(new HelloCommand());

        // Create a new instance of WhatsappAPI
        var api = new WhatsappAPI(WhatsappKeysManager.fromPreferences("Teste"));

        // Register the ban listener and pass the command manager with a dependency injection
        api.registerListener(new WhatsappBotListener(new Teste(),api, manager));

        // Connect to WhatsappWeb's Servers
        api.connect();
        
        
       
//        if(api.manager().
//        
//        var chats = api.manager().findChatByName("Nina").get();
//        api.sendMessage(chats, "teste");
    }
    
}