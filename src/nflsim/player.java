package nflsim;
import java.util.ArrayList;
import java.util.Arrays;
/* 
* holds values of player objects
* methods that create a player that can be added via draft or free agency
    & one method that creates a player for the initial team
*/
public class player {
    String name;
    String position;
    int age;
    int contractLength;
    int skillOne;
    int skillTwo;
    int potential;
    String potentialLetter;
    int overall;
    String skillOneText;
    String skillTwoText;
    static int qbOvr;
    
    static ArrayList<String> listSkills = new ArrayList<String>(Arrays.asList("Throw Power", "Throw Accuracy", "Vision", "Moves", "Catching", "Route Running",
    "Pass Blocking", "Run Blocking", "Run Blocking", "Catching", "Tackling", "Pass Rush", "Tackling", "Zone Coverage", "Man Coverage", "Awareness", "Zone Coverage",
    "Pursuit", "Kick Accuracy", "Kick Power"));
    
    static String[] playerFirstNames = {
    "John", "Mike", "Alex", "Chris", "James", "Robert", "David", "Brian", "Kevin",
    "Jason", "Matthew", "Daniel", "Anthony", "Mark", "Eric", "Steven", "Ryan",
    "Patrick", "Justin", "Adam", "Tyler", "Jordan", "Ethan", "Lucas", "Connor",
    "Noah", "Logan", "Caleb", "Isaac", "Hunter", "Miles", "Evan", "Cole", "Dominic",
    "Jared", "Parker", "Tristan", "Blake", "Grant", "Leo", "Max", "Spencer", "Nolan",
    "Chase", "Trevor", "Roman", "Ashton", "Micah", "Gavin", "Tyson", "Luke", "Kyle", "Zach"};
    
    static ArrayList<String> playerLastNames = new ArrayList<String>(Arrays.asList("Smith", "Johnson", "Brown", "Davis", "Wilson", "Miller", "Taylor", "Anderson",
    "Thomas", "Moore", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia",
    "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall",
    "Allen", "Young", "King", "Wright", "Scott", "Green", "Adams", "Baker", "Nelson",
    "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell",
    "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers",
    "Reed", "Cook", "Ramirez", "Flores", "Brooks", "Bennett", "Foster", "Howard",
    "Ward", "Butler", "Price", "Barnes", "Sullivan", "Griffin", "Kelly", "Sanders", "Smith","Johnson",
    "Brown", "Davis", "Wilson", "Miller", "Taylor", "Anderson", "Thomas", "Moore", "Jackson", "White", "Harris",
    "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker",
    "Hall", "Allen","Young","King","Wright","Scott","Green","Adams","Baker","Nelson",
    "Carter","Mitchell","Perez", "Roberts", "Turner", "Phillips","Campbell","Parker",
    "Evans","Edwards","Collins","Stewart","Sanchez","Morris","Rogers","Reed",
    "Cook","Ramirez","Flores","Brooks","Bennett","Foster","Howard","Ward","Butler","Price",
    "Barnes","Sullivan","Griffin","Kelly","Sanders", "Hughes", "Diaz", "Hayes", "Myers", "Ford", "Hamilton", "Graham", "Wallace", 
    "Woods", "Cole", "West", "Jordan", "Owens", "Reynolds", "Fisher", "Ellis",
    "Harrison", "Gibson", "McDonald", "Cruz", "Marshall", "Ortiz", "Gomez", "Murray",
    "Freeman", "Wells", "Webb", "Simpson", "Stevens", "Tucker", "Porter", "Hunter",
    "Hicks", "Crawford", "Henry", "Boyd", "Mason", "Morales", "Kennedy", "Warren",
    "Dixon", "Ramos", "Reyes", "Burns", "Gordon", "Shaw", "Payne", "Rice", "Potter", "Stone")); 
    
    static ArrayList<String> listPositions = new ArrayList<String>(Arrays.asList("QB", "RB", "OL", "WR", "TE", "DL", "LB", "CB", "S", "K"));


    
    // constructor - values for player object - used in playerCreator() & draftOrFreeAgent()
    public player(String playerName, int playerAge, String playerPosition, int playerContractLength, int playerSkillOne, int playerSkillTwo, int playerPotential, int playerOverall, String playerPotentialLetter,
            String playerSkillOneText, String playerSkillTwoText){
        this.name = playerName;
        this.age = playerAge;
        this.position = playerPosition;
        this.contractLength = playerContractLength;
        this.skillOne = playerSkillOne;
        this.skillTwo = playerSkillTwo;
        this.overall = playerOverall;
        this.potential = playerPotential;
        this.potentialLetter = playerPotentialLetter;
        this.skillOneText = playerSkillOneText;
        this.skillTwoText = playerSkillTwoText; 
    }
    
  
    
    // creates player1 object, used for initial team
    public static player playerCreator(){
        // assigns player a random first and last name & removes last name so players cannot have same last name
        int randomFirstName = (int)(Math.random() * playerFirstNames.length);
        int randomLastName = (int)(Math.random()* playerLastNames.size());
     String playerName = playerFirstNames[randomFirstName] + " " + playerLastNames.get(randomLastName);
     playerLastNames.remove(randomLastName);
     
     
     String playerSkillOneText = null;
     String playerSkillTwoText = null;
     
     // gets random number -> number determines position -> position determines skill Names -> removes position so two cannot have same position
     int randomPosition = (int)(Math.random() * listPositions.size());
     String playerPosition = listPositions.get(randomPosition);
     if (playerPosition.equals("QB")){
         playerSkillOneText = listSkills.get(0);
         playerSkillTwoText = listSkills.get(1);
     }
     else if (playerPosition.equals("RB")){
         playerSkillOneText = listSkills.get(2);
         playerSkillTwoText = listSkills.get(3);
     }
     else if (playerPosition.equals("WR")){
         playerSkillOneText = listSkills.get(4);
         playerSkillTwoText = listSkills.get(5);
     }
     else if (playerPosition.equals("OL")){
         playerSkillOneText = listSkills.get(6);
         playerSkillTwoText = listSkills.get(7);
     }
     else if (playerPosition.equals("TE")){
         playerSkillOneText = listSkills.get(8);
         playerSkillTwoText = listSkills.get(9);
     }
     else if (playerPosition.equals("DL")){
         playerSkillOneText = listSkills.get(10);
         playerSkillTwoText = listSkills.get(11);
     }
     else if (playerPosition.equals("LB")){
         playerSkillOneText = listSkills.get(12);
         playerSkillTwoText = listSkills.get(13);
     }
     else if (playerPosition.equals("CB")){
         playerSkillOneText = listSkills.get(14);
         playerSkillTwoText = listSkills.get(15);
     }
     else if (playerPosition.equals("S")){
         playerSkillOneText = listSkills.get(16);
         playerSkillTwoText = listSkills.get(17);
     }
     else if (playerPosition.equals("K")){
         playerSkillOneText = listSkills.get(18);
         playerSkillTwoText = listSkills.get(19);
     }
     listPositions.remove(randomPosition);

     // calculates overall based on skills
     int playerSkillOne = (int)(Math.random()*10)+70;
     int playerSkillTwo = (int)(Math.random()*10)+70;
     int playerOverall = (playerSkillOne + playerSkillTwo)/2;
  
     int playerPotential = (int)(Math.random()*15)+ playerOverall;
     
     int playerAge = (int)(Math.random()*11)+22;
     
     // finds contract length based on player age, older or younger = short contract
     int playerContractLength = 3;
    if (playerAge == 26 || playerAge == 27){
            playerContractLength = 3; 
    }
    else if (playerAge == 22 || playerAge == 23){
            playerContractLength = 2;
    }
    else if (playerAge == 24 || playerAge == 25){
            playerContractLength = 3;
            }
    else if (playerAge == 28 || playerAge == 29 || playerAge == 30){
            playerContractLength = 3;
    }
    else if (playerAge == 27 || playerAge == 31){
            playerContractLength = 2;
            }
    else if (playerAge >= 32){
            playerContractLength = 2;
            }

   String playerPotentialLetter = "F";
    // player gets a letter rating depending on potential
    if (playerPotential >= 90){
            playerPotentialLetter = "A+";
    }
    else if (playerPotential >= 85){
            playerPotentialLetter = "A";
    }
    else if (playerPotential >= 80){
            playerPotentialLetter = "B+";
    }
    else if (playerPotential >= 75){
            playerPotentialLetter = "B";
    }
    else if (playerPotential >= 70){
            playerPotentialLetter = "C";
    }
    else{
        playerPotentialLetter = "F";
    }
    
    // 
        player player1 = new player(playerName, playerAge, playerPosition, playerContractLength, playerSkillOne, playerSkillTwo, playerPotential, playerOverall, playerPotentialLetter, playerSkillOneText, playerSkillTwoText);
        return player1;
  }
    
    
    
 // creates player1 object, used when adding player via draft or free agency
    public static player draftOrFreeAgent(){
        
        // since 
        if (playerLastNames.isEmpty()){
            playerLastNames =  new ArrayList<String>(Arrays.asList("Smith", "Johnson", "Brown", "Davis", "Wilson", "Miller", "Taylor", "Anderson",
    "Thomas", "Moore", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia",
    "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall",
    "Allen", "Young", "King", "Wright", "Scott", "Green", "Adams", "Baker", "Nelson",
    "Carter", "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell",
    "Parker", "Evans", "Edwards", "Collins", "Stewart", "Sanchez", "Morris", "Rogers",
    "Reed", "Cook", "Ramirez", "Flores", "Brooks", "Bennett", "Foster", "Howard",
    "Ward", "Butler", "Price", "Barnes", "Sullivan", "Griffin", "Kelly", "Sanders", "Smith","Johnson",
    "Brown", "Davis", "Wilson", "Miller", "Taylor", "Anderson", "Thomas", "Moore", "Jackson", "White", "Harris",
    "Martin", "Thompson", "Garcia", "Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker",
    "Hall", "Allen","Young","King","Wright","Scott","Green","Adams","Baker","Nelson",
    "Carter","Mitchell","Perez", "Roberts", "Turner", "Phillips","Campbell","Parker",
    "Evans","Edwards","Collins","Stewart","Sanchez","Morris","Rogers","Reed",
    "Cook","Ramirez","Flores","Brooks","Bennett","Foster","Howard","Ward","Butler","Price",
    "Barnes","Sullivan","Griffin","Kelly","Sanders", "Hughes", "Diaz", "Hayes", "Myers", "Ford", "Hamilton", "Graham", "Wallace", 
    "Woods", "Cole", "West", "Jordan", "Owens", "Reynolds", "Fisher", "Ellis",
    "Harrison", "Gibson", "McDonald", "Cruz", "Marshall", "Ortiz", "Gomez", "Murray",
    "Freeman", "Wells", "Webb", "Simpson", "Stevens", "Tucker", "Porter", "Hunter",
    "Hicks", "Crawford", "Henry", "Boyd", "Mason", "Morales", "Kennedy", "Warren",
    "Dixon", "Ramos", "Reyes", "Burns", "Gordon", "Shaw", "Payne", "Rice", "Potter", "Stone")); 
        }
        
        
        
     // assigns player a random first and last name & removes last name so players cannot have same last name
     int randomFirstName = (int)(Math.random() * playerFirstNames.length);
     int randomLastName = (int)(Math.random()* playerLastNames.size());
     String playerName = playerFirstNames[randomFirstName] + " " + playerLastNames.get(randomLastName);
     playerLastNames.remove(randomLastName);
     // get a random position and assigns it to a player
     
     
     String playerSkillOneText = null;
     String playerSkillTwoText = null;
     /* 
     * assigns position(required for object return) the position that is empty on the roster
     * emptyPosition determined in draft or freeAgency methods
     */
     String playerPosition = season.emptyPosition;
    
    // emptyPosition determines skill Names
     int randomPosition = (int)(Math.random() * listPositions.size());    
     if (season.emptyPosition.equals("QB")){
         playerSkillOneText = listSkills.get(0);
         playerSkillTwoText = listSkills.get(1);
     }
     else if (season.emptyPosition.equals("RB")){
         playerSkillOneText = listSkills.get(2);
         playerSkillTwoText = listSkills.get(3);
     }
     else if (season.emptyPosition.equals("WR")){
         playerSkillOneText = listSkills.get(4);
         playerSkillTwoText = listSkills.get(5);
     }
     else if (season.emptyPosition.equals("OL")){
         playerSkillOneText = listSkills.get(6);
         playerSkillTwoText = listSkills.get(7);
     }
     else if (season.emptyPosition.equals("TE")){
         playerSkillOneText = listSkills.get(8);
         playerSkillTwoText = listSkills.get(9);
     }
     else if (season.emptyPosition.equals("DL")){
         playerSkillOneText = listSkills.get(10);
         playerSkillTwoText = listSkills.get(11);
     }
     else if (season.emptyPosition.equals("LB")){
         playerSkillOneText = listSkills.get(12);
         playerSkillTwoText = listSkills.get(13);
     }
     else if (season.emptyPosition.equals("CB")){
         playerSkillOneText = listSkills.get(14);
         playerSkillTwoText = listSkills.get(15);
     }
     else if (season.emptyPosition.equals("S")){
         playerSkillOneText = listSkills.get(16);
         playerSkillTwoText = listSkills.get(17);
     }
     else if (season.emptyPosition.equals("K")){
         playerSkillOneText = listSkills.get(18);
         playerSkillTwoText = listSkills.get(19);
      }      

     // skillOne and skillTwo get random value, calculates the players overall 
     int playerSkillOne = (int)(Math.random()*10)+70;
     int playerSkillTwo = (int)(Math.random()*10)+70;
     int playerOverall = (playerSkillOne + playerSkillTwo)/2;
     
     
     int playerPotential = (int)(Math.random()*15)+ playerOverall;
     
    
     int playerAge = (int)(Math.random()*11)+22;
     
     // finds contract length based on player age 
     int playerContractLength = 3;
    if (playerAge == 26 || playerAge == 27){
            playerContractLength = 3; 
    }
    else if (playerAge == 22 || playerAge == 23){
            playerContractLength = 2;
    }
    else if (playerAge == 24 || playerAge == 25){
            playerContractLength = 3;
            }
    else if (playerAge == 28 || playerAge == 29 || playerAge == 30){
            playerContractLength = 3;
    }
    else if (playerAge == 27 || playerAge == 31){
            playerContractLength = 2;
            }
    else if (playerAge >= 32){
            playerContractLength = 2;
            }

   String playerPotentialLetter = "F";
    // player gets a letter rating depending on potential
    if (playerPotential >= 90){
            playerPotentialLetter = "A+";
    }
    else if (playerPotential >= 85){
            playerPotentialLetter = "A";
    }
    else if (playerPotential >= 80){
            playerPotentialLetter = "B+";
    }
    else if (playerPotential >= 75){
            playerPotentialLetter = "B";
    }
    else if (playerPotential >= 70){
            playerPotentialLetter = "C";
    }
    else{
        playerPotentialLetter = "F";
    }
     // creates player object with values
        player player1 = new player(playerName, playerAge, playerPosition, playerContractLength, playerSkillOne, playerSkillTwo, playerPotential, playerOverall, playerPotentialLetter, playerSkillOneText, playerSkillTwoText);
        return player1;
  } 
 }
