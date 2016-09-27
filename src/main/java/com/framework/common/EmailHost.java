/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.framework.common;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

/**
 *
 * @author S823509
 */
public class EmailHost {

    private String provider;

    private String host;
    private String port;
    private String protocol;
    private String folder;
    private String username;
    private String password;
    private PropertyHelper propsHelper = new PropertyHelper();

    public EmailHost() throws IOException {

        this.setProvider("main");
        setHost();
        setPort();
        setUsername();
        setPassword();
//        this.host = host;
//        this.port = port;
//        this.protocol = protocol;
//        this.folder = folder;
//        this.username = username;
//        this.password = password;

    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getHost() {

        return host;
    }

    public void setHost() throws IOException {
        this.host = propsHelper.readPropertyFromEmailPropertyFile(getProvider(), "EMAIL_HOST");
    }

    public String getPort() {
        return port;
    }

    public void setPort() throws IOException {
        this.port = propsHelper.readPropertyFromEmailPropertyFile(getProvider(), "EMAIL_PORT");
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol() throws IOException {
        this.protocol = propsHelper.readPropertyFromEmailPropertyFile(getProvider(), "EMAIL_PROTOCOL");
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder() throws IOException {
        this.folder = propsHelper.readPropertyFromEmailPropertyFile(getProvider(), "EMAIL_FOLDER");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername() throws IOException {
        this.username = propsHelper.readPropertyFromEmailPropertyFile(getProvider(), "EMAIL_USER");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword() throws IOException {
        this.password = propsHelper.readPropertyFromEmailPropertyFile(getProvider(), "EMAIL_PASSWORD");
    }

    public String retrieveCountEmailMessageBySubject(String subjectToCount) {

        int foundCounter = 0;

        try {
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", port);
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, username, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());

                if (message.getSubject().contains(subjectToCount)) {
                    foundCounter++;
                }

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();
        } catch (MessagingException e) {
            System.out.println("Exception while connecting to server: "
                    + e.getLocalizedMessage());
            e.printStackTrace();
            System.exit(2);
        } catch (IOException ex) {
            Logger.getLogger(EmailHost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.toString(foundCounter);
    }

    public String retrieveEmailMessageBySubject(String subjectToCount) {

        int foundCounter = 0;

        try {
            Properties properties = new Properties();

            properties.put("mail.pop3.host", host);
            properties.put("mail.pop3.port", port);
            properties.put("mail.pop3.starttls.enable", "true");
            Session emailSession = Session.getDefaultInstance(properties);

            //create the POP3 store object and connect with the pop server
            Store store = emailSession.getStore("pop3s");

            store.connect(host, username, password);

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());

                if (message.getSubject().contains(subjectToCount)) {
                    foundCounter++;
                }

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();
        } catch (MessagingException e) {
            System.out.println("Exception while connecting to server: "
                    + e.getLocalizedMessage());
            e.printStackTrace();
            System.exit(2);
        } catch (IOException ex) {
            Logger.getLogger(EmailHost.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.toString(foundCounter);
    }

    
}
