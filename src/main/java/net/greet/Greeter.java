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
            switch (language.toUpperCase()){
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
        System.out.println( username + " is greeted " + greetedUsers.get(username)+ " time(s)");
        return this.greetedUsers.get(username);
    }

//    returns the number of users in the list
    public int counter(){
        System.out.println("greeted users: " + greetedUsers.size());

        return greetedUsers.size();
    }



// removes the user from greeted list
    public void clear(String username){
        if(greetedUsers.containsKey(username)){
            greetedUsers.remove(username);
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

        System.out.println("Type one of these commands for action");
        System.out.println("languages available: French, IsiXhosa and English");
        System.out.println("greet , username, language");
        System.out.println("greeted");
        System.out.println("greeted, username");
        System.out.println("counter");
        System.out.println("clear");
        System.out.println("clear, username");
        System.out.println("exit");

    }

//  Handle commands
    public void commands() {
        Scanner commandInput = new Scanner(System.in);
        System.out.println("Hi, please type help to see possible commands in proceeding with this app ");
        while (true) {

          String getCommand = commandInput.nextLine();
          String[] commandArr = getCommand.split(" ");
          String command = commandArr[0];

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
                          if(commandArr.length < 2){
                              language = commandArr[2];
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





