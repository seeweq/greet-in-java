package net.greet;

import java.util.HashMap;


import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Greeter {

        Map<String, Integer> greetedUsers = new HashMap<>();

    //Add the greeted user
    public void  addGreetedUser(String username){


    //add name for the first time
        if (!greetedUsers.containsKey(username)) {
            greetedUsers.put(username ,1);

    //updates counter for existing user
        }else if(greetedUsers.containsKey(username)){
            greetedUsers.put(username, greetedUsers.get(username) + 1);

        }

    }

//    greet the user
    public void greet(String username, String language) {
        String name = username.substring(0,1).toUpperCase() + username.substring(1);

        addGreetedUser(name);
            switch (language){
                case "FRENCH":
                    System.out.println("Bonjour " + name);
                    break;
                case "ISIXHOSA":
                    System.out.println("Molo " + name);
                    break;
                case "ENGLISH":
                    System.out.println("Hello " + name);
                    break;
                default:
                    System.out.println("Hi " + name);

            }


        }
//return the users greeted and number of times each user was greeted
    public void greetedUser() {
        for (Map.Entry<String,Integer> entry : greetedUsers.entrySet())
            System.out.println("Username = " + entry.getKey() +
                    ", greetedTimes = " + entry.getValue());


    }
//    greets the user
    public int greeted(String username){
        String name = username.substring(0,1).toUpperCase() + username.substring(1);
        System.out.println( name + " is greeted " + greetedUsers.get(name)+ " time(s)");
        return this.greetedUsers.get(name);
    }

//    returns the number of users in the list
    public int counter(){
        System.out.println("greeted users: " + greetedUsers.size());

        return greetedUsers.size();
    }



// removes the user from greeted list
    public void clear(String username){
        String name = username.substring(0,1).toUpperCase() + username.substring(1);
        if(greetedUsers.containsKey(name)){
            greetedUsers.remove(name);
            System.out.println("Users left:" + greetedUsers.size() );
        }else{
            System.out.println("no such user");
        }

    }
//    clear all users from greeted list
    public void clear(){
        greetedUsers.clear();
        System.out.println("cleared all greeted users");

    }

//prints all available commands
    public void help(){

        System.out.println("Type one of these commands to greet a friend in the following languages :");
        System.out.println("French,");
        System.out.println("IsiXhosa,");
        System.out.println("English");
        System.out.println("1. greet , name, language");
        System.out.println("2. greeted");
        System.out.println("3. greeted, name");
        System.out.println("4. counter");
        System.out.println("5. clear");
        System.out.println("6. clear, name");
        System.out.println("7. exit");

    }

//  Handle commands
    public void commands() {
        Scanner commandInput = new Scanner(System.in);
        System.out.println("Hi, please type help to see possible commands in proceeding with this app ");
        while (true) {

          String getCommand = commandInput.nextLine();
          String[] commandArr = getCommand.split(" ");
          String appCommand = commandArr[0];
          String command = appCommand.substring(0,1).toLowerCase() + appCommand.substring(1);

          if(command.equals("exit")){
              System.out.println("Bye");
              break;
          }else {
              switch (command) {
                  case "help":
                      help();
                      break;
                  case "greet":
                      if(commandArr.length <= 1){
                          System.out.println("please type greet, your name and language you wish");
                      }else {
                          String username = commandArr[1];
                          String language = "";
                          if(commandArr.length > 2){
                              language =  commandArr[2].toUpperCase();
                          }
                          greet(username, language);
                      }
                      break;
                  case "greeted":
                      if(commandArr.length > 1){
                          String name = commandArr[1];
                          greeted(name);
                      }else{
                          greetedUser();
                      }
                      break;
                  case "clear":
                      if(commandArr.length > 1){
                          String clearName = commandArr[1];
                          clear(clearName);
                      }else{
                          clear();
                      }
                      break;
                  case "counter":
                      counter();

              }

          }


        }

   }








}





