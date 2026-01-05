package nflsim;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;
/*
* methods for all actions of the season
* creates nfl teams for user to go up against
* holds many boolean variables for loops
*/
public class season {
    static boolean seasonActive = true;
     String NFLTeamNames;
     int TeamsOveralls;
    String difficulty;
    static int week = 0; 
    static boolean draftActive = false;
    static boolean inSeasonConferenceChamp = true;
    static String emptyPosition ;
    static String draftSkillOneText = null;
    static String draftSkillTwoText = null;
    static boolean freeAgencyActive = false; 
    static int sequence = 0;
    static int round = 0;
    static int pos;
    static boolean sequenceActive = true; 
    static boolean draftInputLoop;
    
    static Scanner input = new Scanner(System.in);
    
    static  ArrayList<String> nflTeams = new ArrayList<String>(Arrays.asList("Arizona Cardinals",
    "Atlanta Falcons",
    "Baltimore Ravens",
    "Buffalo Bills",
    "Carolina Panthers",
    "Chicago Bears",
    "Cincinnati Bengals",
    "Cleveland Browns",
    "Dallas Cowboys",
    "Denver Broncos",
    "Detroit Lions",
    "Green Bay Packers",
    "Houston Texans",
    "Indianapolis Colts",
    "Jacksonville Jaguars",
    "Kansas City Chiefs",
    "Las Vegas Raiders",
    "Los Angeles Chargers",
    "Los Angeles Rams",
    "Miami Dolphins",
    "Minnesota Vikings",
    "New England Patriots",
    "New Orleans Saints",
    "New York Giants",
    "New York Jets",
    "Philadelphia Eagles",
    "Pittsburgh Steelers",
    "San Francisco 49ers",
    "Seattle Seahawks",
    "Tampa Bay Buccaneers",
    "Tennessee Titans",
    "Washington Commanders"));
    
    static int[] schedule = new int[17];
    
    static ArrayList<player> draft = new ArrayList<>(); 
    
    static ArrayList<season> theOtherTeams = new ArrayList<>();
    
    // constructor - holds values for all nfl teams
    public season(String otherTeamName, int otherTeamOverall, String otherTeamDifficulty){
    this.NFLTeamNames = otherTeamName;
    this.TeamsOveralls = otherTeamOverall;
    this.difficulty = otherTeamDifficulty;
    
}

// when called -> displays nfl teams 
    public static void displayTeams(){
        for (int i = 0; i < nflTeams.size(); i++){
            System.out.print((i + 1) + ". ");
            System.out.println(nflTeams.get(i));
     }
    }
    
    
    
    // when called -> displays your current team attributes
    public static void displayMyTeam(){
            for (player p : team.myTeam){
                if (p == null){
                    System.out.println("----------------------------------------------------- Empty Roster Spot ------------------------------------------------------");
                }
                else{
            System.out.println("Name: " + p.name + " Age: " + p.age + " Position: " + p.position + " Contract Length: " + p.contractLength +
                    " " + p.skillOneText + ": " + p.skillOne + " " + p.skillTwoText + ": " + p.skillTwo + " Overall: " + p.overall + " Player Potential: " + p.potentialLetter);
            // initial teams qb ovr
            if (p.position.equalsIgnoreCase("qb")){
                player.qbOvr = p.overall;
            }
           }
            System.out.println("------------------------------------------------------------------------------------------------------------------------------");
     }
    }
    
    
    
    // nfl teams assign a name from array - ovr - and star rating based on that 
    public static season createATeam(){
        
        int otherTeamNumber = (int)(Math.random() * nflTeams.size());
         String otherTeamName = nflTeams.get(otherTeamNumber);
         nflTeams.remove(otherTeamNumber);
         
         int otherTeamOverall = (int)(Math.random()*22)+70;

         String otherTeamDifficulty = "*";
         if (otherTeamOverall >= 90){
             otherTeamDifficulty = "*****";
         }
         else if (otherTeamOverall >= 85 && otherTeamOverall < 90){
             otherTeamDifficulty = "****";
         }
         else if (otherTeamOverall >= 80 && otherTeamOverall < 85){
             otherTeamDifficulty = "***";
         } else if (otherTeamOverall >= 75 && otherTeamOverall < 80){
             otherTeamDifficulty = "**";
         } else if (otherTeamOverall >= 70 && otherTeamOverall < 75){
             otherTeamDifficulty = "*";
         }
         season teamOpponent = new season(otherTeamName, otherTeamOverall, otherTeamDifficulty);
         return teamOpponent;
}
    
    
    
    
    // adds all teams to the league 
public static void addTeamsToArray(){
    for (int g = 0; g < 30; g++){
        season.theOtherTeams.add(createATeam());
    }
    for (int p = 0; p < 30; p++){
        nflTeams.add(theOtherTeams.get(p).NFLTeamNames);
    }
}

// removes all teams from league because each season they need new values
public static void removeTeamsFromArray(){
    for (int g = 29; g >= 0; g--){
        theOtherTeams.remove(g);
 }
}


// list of teams users team will play through season
    public static void createSchedule(){
        
        for (int j = 0; j < 17; j++){
        int randomNumber = (int)(Math.random()* theOtherTeams.size()); 
        schedule[j] = randomNumber;
     }
    }
    
    // displays schedule & the team names & difficulty
    public static void displaySchedule(){
        System.out.println("Schedule: ");
        System.out.println("Team Name            Difficulty\n"
                + "---------            ----------");
    for (int j = 0; j < 17; j++){
        System.out.print((j + 1) + ". ");
    System.out.print(theOtherTeams.get(schedule[j]).NFLTeamNames);
    System.out.println(" " + theOtherTeams.get(schedule[j]).difficulty);
}
    }
    
    
    
    // creates 10 players of the empty roster spots position, all young, for user to choose
    public static void draft(){
    draftInputLoop = true;
    
    
        for (int p = 0; p < team.myTeam.size(); p++){
            // roster spot open
        if ((team.myTeam.get(p) == null) && !draftActive){

            // if position available -> emptyPosition = that position
        for (int g = 0; g < player.listPositions.size(); g++){
                if (player.listPositions != null){
                    
            emptyPosition = player.listPositions.get(g);
            
            // gets player skills to assign to draftees
     draftSkillOneText = null;
     draftSkillTwoText = null;
     if (emptyPosition.equals("QB")){
         draftSkillOneText = player.listSkills.get(0);
         draftSkillTwoText = player.listSkills.get(1);
     }
     else if (emptyPosition.equals("RB")){
         draftSkillOneText = player.listSkills.get(2);
         draftSkillTwoText = player.listSkills.get(3);
     }
     else if (emptyPosition.equals("WR")){
         draftSkillOneText = player.listSkills.get(4);
         draftSkillTwoText = player.listSkills.get(5);
     }
     else if (emptyPosition.equals("OL")){
         draftSkillOneText = player.listSkills.get(6);
         draftSkillTwoText = player.listSkills.get(7);
     }
     else if (emptyPosition.equals("TE")){
         draftSkillOneText = player.listSkills.get(8);
         draftSkillTwoText = player.listSkills.get(9);
     }
     else if (emptyPosition.equals("DL")){
         draftSkillOneText = player.listSkills.get(10);
         draftSkillTwoText = player.listSkills.get(11);
     }
     else if (emptyPosition.equals("LB")){
         draftSkillOneText = player.listSkills.get(12);
         draftSkillTwoText = player.listSkills.get(13);
     }
     else if (emptyPosition.equals("CB")){
         draftSkillOneText = player.listSkills.get(14);
         draftSkillTwoText = player.listSkills.get(15);
     }
     else if (emptyPosition.equals("S")){
         draftSkillOneText = player.listSkills.get(16);
         draftSkillTwoText = player.listSkills.get(17);
     }
     else if (emptyPosition.equals("K")){
         draftSkillOneText = player.listSkills.get(18);
         draftSkillTwoText = player.listSkills.get(19);
     }  
    }
   } 
        team.myTeam.remove(p);
   draftActive = true;
  }
 }
    
        // if draft active --> generate players and have user pick player
        if (draftActive){
            draft.add(player.draftOrFreeAgent());
            draft.add(player.draftOrFreeAgent());
            draft.add(player.draftOrFreeAgent());
            draft.add(player.draftOrFreeAgent());
            draft.add(player.draftOrFreeAgent());
            draft.add(player.draftOrFreeAgent());
            draft.add(player.draftOrFreeAgent());
            draft.add(player.draftOrFreeAgent());
            draft.add(player.draftOrFreeAgent());
            draft.add(player.draftOrFreeAgent());
            
            player.listPositions.remove(emptyPosition);
            
            System.out.println("Welcome To The " + team.history.get(team.yearCounter).year + " NFL Draft\n"
                    + "This Years Draft Pool Looks Promising..."); 
            
            for (int i = 0; i < draft.size(); i++){
                draft.get(i).position = emptyPosition;
                draft.get(i).skillOneText = draftSkillOneText;
                draft.get(i).skillTwoText = draftSkillTwoText;
                draft.get(i).age = (int)(Math.random()*2)+21;
                int randomNum = (int)(Math.random()*5)+2;
                int higherOverallRating = (int)(Math.random()*randomNum) + draft.get(i).overall;
                int lowerOverallRating = (int)(Math.random()-randomNum) + draft.get(i).overall;
                System.out.println((i + 1) + "." + " Name: " + draft.get(i).name + " Position: " + draft.get(i).position + " Age: " + draft.get(i).age + " Potential: " + draft.get(i).potentialLetter + " Overall Range: " + lowerOverallRating + "-" + higherOverallRating);
       }
            while (draftInputLoop){

            System.out.print("Enter The Number Of The Player You Want On Your Team: ");
            
            String stringInput = input.nextLine().trim();
            try{
                int draftInput = Integer.parseInt(stringInput);

            switch (draftInput){         
                case 1:
                   team.myTeam.add(draft.get(0));
                   draftInputLoop = false;
                    break;
                case 2:
                   team.myTeam.add(draft.get(1)); 
                   draftInputLoop = false;
                    break;
                case 3:
                    team.myTeam.add(draft.get(2));
                    draftInputLoop = false;
                    break;
                case 4:
                    team.myTeam.add(draft.get(3));
                    draftInputLoop = false;
                    break;
                case 5:
                    team.myTeam.add(draft.get(4));
                    draftInputLoop = false;
                    break;
                case 6:
                    team.myTeam.add(draft.get(5));
                    draftInputLoop = false;
                    break;
                case 7:
                    team.myTeam.add(draft.get(6));
                    draftInputLoop = false;
                    break;
                case 8:
                    team.myTeam.add(draft.get(7));
                    draftInputLoop = false;
                    break;
                case 9:
                    team.myTeam.add(draft.get(8));
                    draftInputLoop = false;
                    break;
                case 10:
                    team.myTeam.add(draft.get(9));
                    draftInputLoop = false;
                    break; 
                default:
                System.out.println("Invalid Number... Please Enter A Valid Number");
                
            }
           }catch(NumberFormatException e){
              System.out.println("Invalid Input... Please Enter A Valid Number");
        }  
       }
      }
        // removes all the players from the draft array that were added 
        if (draftActive){
           draft.remove(0);
           draft.remove(0);
           draft.remove(0);
           draft.remove(0);
           draft.remove(0);
           draft.remove(0);
           draft.remove(0);
           draft.remove(0);
           draft.remove(0);
           draft.remove(0);
           // does not loop
       draftActive = false;
        }
        System.out.println("Ending The " + team.history.get(team.yearCounter).year + " NFL Draft!");
     }
    
    
    
    // random player added to empty spot on team
    public static void freeAgency(){
        
        // i-- because it removes a player from myTeam
        for (int i = team.myTeam.size() - 1; i >= 0; i--){
  
        if (team.myTeam.get(i) == null){
            freeAgencyActive = true;
            team.myTeam.remove(i);
        
            // finds empty position from list, assigns that to emptyPosition
        for (int g = player.listPositions.size() - 1; g >= 0;  g--){
                
                if (player.listPositions.get(g) != null){
            emptyPosition = player.listPositions.get(g);
            // pos used as index later
            pos = g;
         }
        }
     draftSkillOneText = null;
     draftSkillTwoText = null;
     
     if (emptyPosition.equals("QB")){
         draftSkillOneText = player.listSkills.get(0);
         draftSkillTwoText = player.listSkills.get(1);
     }
     else if (emptyPosition.equals("RB")){
         draftSkillOneText = player.listSkills.get(2);
         draftSkillTwoText = player.listSkills.get(3);
     }
     else if (emptyPosition.equals("WR")){
         draftSkillOneText = player.listSkills.get(4);
         draftSkillTwoText = player.listSkills.get(5);
     }
     else if (emptyPosition.equals("OL")){
         draftSkillOneText = player.listSkills.get(6);
         draftSkillTwoText = player.listSkills.get(7);
     }
     else if (emptyPosition.equals("TE")){
         draftSkillOneText = player.listSkills.get(8);
         draftSkillTwoText = player.listSkills.get(9);
     }
     else if (emptyPosition.equals("DL")){
         draftSkillOneText = player.listSkills.get(10);
         draftSkillTwoText = player.listSkills.get(11);
     }
     else if (emptyPosition.equals("LB")){
         draftSkillOneText = player.listSkills.get(12);
         draftSkillTwoText = player.listSkills.get(13);
     }
     else if (emptyPosition.equals("CB")){
         draftSkillOneText = player.listSkills.get(14);
         draftSkillTwoText = player.listSkills.get(15);
     }
     else if (emptyPosition.equals("S")){
         draftSkillOneText = player.listSkills.get(16);
         draftSkillTwoText = player.listSkills.get(17);
     }
     else if (emptyPosition.equals("K")){
         draftSkillOneText = player.listSkills.get(18);
         draftSkillTwoText = player.listSkills.get(19);
     }  
        
        // assign position to new player --> add player to team --> display player
         if (freeAgencyActive){
             
            draft.add(player.draftOrFreeAgent());
            draft.get(0).skillOneText = draftSkillOneText;
            draft.get(0).skillTwoText = draftSkillTwoText;
            draft.get(0).position = emptyPosition;
            System.out.println("Since You Have An Open Roster Spot On Your Team, Your " + team.teamName + " Owner Has Chosen To Add A Flashy Player From Free Agency...");
            team.myTeam.add(draft.get(0));
            System.out.println("Name: " + draft.get(0).name + " Age: " + draft.get(0).age + " Position: " + draft.get(0).position + " Contract Length: " +
                    draft.get(0).contractLength + " " +
                    draft.get(0).skillOneText + ": " + draft.get(0).skillOne  + " " +  draft.get(0).skillTwoText + ": " +
                   draft.get(0).skillTwo +  " Overall: " + draft.get(0).overall  +
                    " Potential: " + draft.get(0).potentialLetter);
            System.out.println("-----------------------------------------------");
            draft.remove(0);
            player.listPositions.remove(pos);
     }
    } 
   }
      System.out.println("That Is The End Of Free Agency");  
  }
        
    
    // player contract at end, user can sign them or not
    public static void contractNegotiations(){
       
        for (int i = team.myTeam.size()-1; i >= 0; i--){
            
            // only allows user to sign player if they are at contract 0
            if ((team.myTeam.get(i) != null) && (team.myTeam.get(i).contractLength == 0)){
                
                
                System.out.println("--This Player Is At The End Of His Contract--");
                System.out.println("Name: " + team.myTeam.get(i).name + " Age: " + team.myTeam.get(i).age + " Position: " + team.myTeam.get(i).position + " Contract Length: " +
                    team.myTeam.get(i).contractLength +
                    " Overall: " + team.myTeam.get(i).overall  +
                    " Potential: " + team.myTeam.get(i).potentialLetter);
                System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
                
                System.out.println("Are You Willing To Resign " + team.myTeam.get(i).name + " |Yes Or No?|");
                
                String contractAnswer = input.nextLine().trim();
                
                // makes sure if user types wrong -> does not skip ahead
                if (contractAnswer.isEmpty()) {
                    System.out.println("Invalid Input...");
                 i++; 
                 continue;
                    }

                // if answer yes, sign to 3 year contract, if answer no remove that player from team --> add blank player
                            if (contractAnswer.equalsIgnoreCase("yes")){    
                   team.myTeam.get(i).contractLength = 3;  
               }
                            else if (contractAnswer.equalsIgnoreCase("No")){
                                player.listPositions.add(team.myTeam.get(i).position);
                                team.myTeam.remove(i);
                                team.myTeam.add(null);
                            }
                            else {
                                System.out.println("Invalid Input...");
                                i++;
                                continue;
                            }
      }  
     }
        System.out.println("Ending Contract Negotiations..");
    }
    
    // in conference champ = user must win 3 playoff games for super bowl win | if not = user plays 4
    public static void playoffs(){
        
        // three arrays to hold values of the four highest overall teams
        int[] overall = {0,0,0,0};
        String[] text = {"","","",""};
        String[] difficulty = {"","","",""};
        
        // loops through all teams - gets four highest ovr teams - assigns the values to the arrays above 
        for (int i = theOtherTeams.size() - 1; i >= 0; i--){
            if (theOtherTeams.get(i).TeamsOveralls > overall[3]){
                overall[3] = theOtherTeams.get(i).TeamsOveralls;
                 text[3] = theOtherTeams.get(i).NFLTeamNames;
                difficulty[3] = theOtherTeams.get(i).difficulty;
                        }
            else if (theOtherTeams.get(i).NFLTeamNames != text[3] && theOtherTeams.get(i).TeamsOveralls > overall[2]){
                 overall[2] = theOtherTeams.get(i).TeamsOveralls;
                text[2] = theOtherTeams.get(i).NFLTeamNames;
                difficulty[2] = theOtherTeams.get(i).difficulty;
            }
            else if (theOtherTeams.get(i).NFLTeamNames != text[2] && theOtherTeams.get(i).TeamsOveralls > overall[1]){
                overall[1] = theOtherTeams.get(i).TeamsOveralls;
                text[1] = theOtherTeams.get(i).NFLTeamNames;
                difficulty[1] = theOtherTeams.get(i).difficulty;
            }
            else if (theOtherTeams.get(i).NFLTeamNames != text[1] && theOtherTeams.get(i).TeamsOveralls > overall[0]){
             overall[0] = theOtherTeams.get(i).TeamsOveralls;
                text[0] = theOtherTeams.get(i).NFLTeamNames;
                difficulty[0] = theOtherTeams.get(i).difficulty;   
         }
        }
        
        // since inseason conference champ should play less games need to display differently 
           if (round != 3 && inSeasonConferenceChamp){
            System.out.println("Playoff Round: " + (round + 1));   
           }
           else if (round == 3 && inSeasonConferenceChamp){
               System.out.println("This Is It...\n"
                       + "The Biggest Stage, The Brightest Lights, Fans Across The World Watching\n"
                       + "THE SUPER BOWL!");
           }
           else if (round != 3 && inSeasonConferenceChamp == false){
             System.out.println("Playoff Round: " + (round + 1));   
           }
           else if (round == 3){
           System.out.println("This Is It...\n"
                       + "The Biggest Stage, The Brightest Lights, Fans Across The World Watching\n"
                       + "THE SUPER BOWL!");    
           }
           
           
           
           
        System.out.println(team.teamName  + " vs " + text[round] + "\n"
                + "Overall: " + team.teamOverall + " Difficulty: " + difficulty[round]);
        
        
        // calculates teams ratings and adds modifier to your rating based on qb overall
        int modifier = player.qbOvr / 20; 
        int yourTeamRating = (int)(Math.random()*5) + (team.teamOverall + modifier);
        
        int opponentTeamRating = overall[round];
        
        
        // your team wins
        if (yourTeamRating > opponentTeamRating){
            int overallDifference = yourTeamRating % opponentTeamRating;
            
            System.out.println("The " + team.teamName + " Defeated The " + text[round]);
        team.history.get(team.yearCounter).wins++;
        
                    if (overallDifference >= 10){
            int opponentScore = (int)(Math.random()*21)+7;
            int yourScore = (int)(Math.random()*21) + (opponentScore + 7);
            
            System.out.println(team.teamName + ":" + yourScore + " " + text[round] + ":" + opponentScore);
                    }
                    else if (overallDifference >= 5 && overallDifference < 10){
                      int opponentScore = (int)(Math.random()*28)+7;
                      int yourScore = (int)(Math.random()*14) + (opponentScore + 3);
                      System.out.println(team.teamName + ":" + yourScore + " " + text[round] + ":" + opponentScore);
                    }
                    else if (overallDifference >= 1 && overallDifference < 5){
                      int opponentScore = (int)(Math.random()*35)+7;
                      int yourScore = (int)(Math.random()*7) + (opponentScore + 1);
                      System.out.println(team.teamName + ":" + yourScore + " " + text[round] + ":" + opponentScore);
                    }
            
          if (round == 1 && inSeasonConferenceChamp){
          System.out.println("You Won The Divisional Game");
      }
          else if (round == 0 && inSeasonConferenceChamp == false){
          System.out.println("You Won The Wild Card Game");    
          }
      else if (round == 2 && inSeasonConferenceChamp){
         System.out.println("You Won The Conference Championship And Are Heading To The SUPER BOWL!!!");
         team.history.get(team.yearCounter).conference = "Yes";
      }
      else if (round == 1 && inSeasonConferenceChamp == false){
        System.out.println("You Won The Divisional Game");  
      }
      else if (round == 3 && inSeasonConferenceChamp){
          System.out.println("You Won The Super Bowl, Congratulations!");
          team.history.get(team.yearCounter).superBowl = team.teamName;
          System.out.println("-----------------------------------------------");
          sequence = 22;
      }
      else if (round == 2 && inSeasonConferenceChamp == false){
          System.out.println("You Won The Conference Championship And Are Heading To The SUPER BOWL!!!");
          team.history.get(team.yearCounter).conference = "Yes";
      }
      else if (round == 3 && inSeasonConferenceChamp == false){
         System.out.println("You Won The Super Bowl, Congratulations!"); 
         team.history.get(team.yearCounter).superBowl = team.teamName;
         System.out.println("-----------------------------------------------");
         sequence = 22; 
        System.out.println(team.teamName + " Record: " + team.history.get(team.yearCounter).wins + "-" + team.history.get(team.yearCounter).losses + "-" + team.history.get(team.yearCounter).ties); 
       
         
         
      }
          round++;    
        }
        // your team lost
        else if (yourTeamRating < opponentTeamRating){
            int overallDifference = opponentTeamRating % yourTeamRating;
            System.out.println("The " + text[round] + " Defeated The " + team.teamName);
            team.history.get(team.yearCounter).losses++;
                  if (overallDifference >= 10){
                      int yourScore = (int)(Math.random()*21)+7;
                      int opponentScore = (int)(Math.random()*21)+  (yourScore + 7);
                  System.out.println(team.teamName + ":" + yourScore + " " + text[round] + ":" + opponentScore);            
                  }
                  else if (overallDifference >= 5 && overallDifference < 10){
                      int yourScore = (int)(Math.random()*28)+7;
                      int opponentScore = (int)(Math.random()*14) + (yourScore + 3);
                  System.out.println(team.teamName + ":" + yourScore + " " + text[round] + ":" + opponentScore);
                  }
                  else if (overallDifference >= 1 && overallDifference < 5){
                      int yourScore = (int)(Math.random()*35)+7;
                      int opponentScore = (int)(Math.random()*7) + (yourScore + 1);
                  System.out.println(team.teamName + ":" + yourScore + " " + text[round] + ":" + opponentScore);
                  }
               sequence = 22;
               
              if (round == 1 && inSeasonConferenceChamp){
          System.out.println("You Lost The Divisional Game");
          System.out.println("-----------------------------------------------");
          team.history.get(team.yearCounter).superBowl = text[3];
      }
          else if (round == 0 && inSeasonConferenceChamp == false){
          System.out.println("You Lost The Wild Card Game"); 
          System.out.println("-----------------------------------------------");
          team.history.get(team.yearCounter).superBowl = text[3];
          }
      else if (round == 2 && inSeasonConferenceChamp){
         System.out.println("You Lost The Conference Championship...");
         System.out.println("-----------------------------------------------");
          int coinFlip = (int)(Math.random()*1)+0;
          if (coinFlip == 1){
          team.history.get(team.yearCounter).superBowl = text[round];
                  }
          else if (coinFlip == 0){
          team.history.get(team.yearCounter).superBowl = text[3];    
          }
      }
      else if (round == 1 && inSeasonConferenceChamp == false){
        System.out.println("You Lost The Divisional Game");
        team.history.get(team.yearCounter).superBowl = text[3];
        System.out.println("-----------------------------------------------");
      }
      else if (round == 3 && inSeasonConferenceChamp){
          System.out.println("You Lost The Super Bowl, You Came So Close...");
          team.history.get(team.yearCounter).superBowl = text[round];
          System.out.println("-----------------------------------------------");
      }
      else if (round == 2 && inSeasonConferenceChamp == false){
          System.out.println("You Lost The Conference Championship...");
          System.out.println("-----------------------------------------------");
          int coinFlip = (int)(Math.random()*1)+0;
          if (coinFlip == 1){
          team.history.get(team.yearCounter).superBowl = text[round];
                  }
          else if (coinFlip == 0){
          team.history.get(team.yearCounter).superBowl = text[3];    
          }
      }
      else if (round == 3 && inSeasonConferenceChamp == false){
         System.out.println("You Lost The Super Bowl, You Came So Close.."); 
         team.history.get(team.yearCounter).superBowl = text[round];
         System.out.println("-----------------------------------------------");                               
        }
       }
        // since there are no ties in the playoffs, your team wins by 1 
        else if (yourTeamRating == opponentTeamRating){
            System.out.println("The " + team.teamName + " Defeated The " + text[round]);
            team.history.get(team.yearCounter).wins++;
            int yourScore = (int)(Math.random()*35)+7;
            int opponentScore = yourScore - 1;
            System.out.println(team.teamName + ":" + yourScore + " " + text[round] + ":" + opponentScore);
            
        if (round == 1 && inSeasonConferenceChamp){
          System.out.println("You Won The Divisional Game");
      }
          else if (round == 0 && inSeasonConferenceChamp == false){
          System.out.println("You Won The Wild Card Game");    
          }
      else if (round == 2 && inSeasonConferenceChamp){
         System.out.println("You Won The Conference Championship And Are Heading To The SUPERBOWL!!!");
         team.history.get(team.yearCounter).conference = "Yes";
      }
      else if (round == 1 && inSeasonConferenceChamp == false){
        System.out.println("You Won The Divisional Game");  
      }
      else if (round == 3 && inSeasonConferenceChamp){
          System.out.println("You Won The Super Bowl, Congratulations!");
          team.history.get(team.yearCounter).superBowl = team.teamName;
          System.out.println("-----------------------------------------------");
          sequence = 22; 
      }
      else if (round == 2 && inSeasonConferenceChamp == false){
          System.out.println("You Won The Conference Championship And Are Heading To The SUPER BOWL!!!");
          team.history.get(team.yearCounter).conference = "Yes";
      }
      else if (round == 3 && inSeasonConferenceChamp == false){
         System.out.println("You Won The Super Bowl, Congratulations!");
         team.history.get(team.yearCounter).superBowl = team.teamName;
         System.out.println("-----------------------------------------------");
         sequence = 22; 
         
        System.out.println(team.teamName + " Record: " + team.history.get(team.yearCounter).wins + "-" + team.history.get(team.yearCounter).losses + "-" + team.history.get(team.yearCounter).ties); 
       
        }
       round++;   
    }
   }
    // recaps season, depending on what you achieved - will print different things
    public static void endOfSeasonResults(){
        System.out.println("The " + team.history.get(team.yearCounter).year + " NFL Season Has Come To An End\n"
                + "Your " + team.teamName + " Finished With A " + team.history.get(team.yearCounter).wins + "-" +
                team.history.get(team.yearCounter).losses + "-" + team.history.get(team.yearCounter).ties + " Record");
        if (team.history.get(team.yearCounter).superBowl == team.teamName){
            System.out.println("Your Team Won The Super Bowl!");
            
        }
        else if (team.history.get(team.yearCounter).superBowl != team.teamName){
            System.out.println("The " + team.history.get(team.yearCounter).superBowl + " Won The Super Bowl");
            }
        if (team.history.get(team.yearCounter).playoffs.equals("No")){
            System.out.println("Your Team Missed The Playoffs, Fans Are Disappointed");
        }
        else if (team.history.get(team.yearCounter).conference.equals("Yes") && team.history.get(team.yearCounter).superBowl != team.teamName){
            System.out.println("Your Team Is Conference Champions, Thats Great! However, Your Fans Expect A Super Bowl Win Next Season...");
            }
        else if ((team.history.get(team.yearCounter).conference.equals("No") && team.history.get(team.yearCounter).playoffs.equals("Yes")) && team.history.get(team.yearCounter).superBowl != team.teamName){
            System.out.println("Your Team Made The Playoffs! Expectations are even higher for next season...");
            }
    }
    
    // allows for the user to press 5 in the menu to continue and different parts of season will be activated 
    public static void sequence(){
        if (sequence >= 0 && sequence <= 17){
        weekSim();
        }
        if (sequence > 17 && sequence <= 21){
            playoffs();         
        }
        if (sequence == 22){
            endOfSeasonResults();
        }
        if (sequence == 23){
           team.attributeChanges();     
        }
        if (sequence == 23){
            contractNegotiations();   
        }
        if (sequence == 24){
            draft();   
        }
        if (sequence == 25){
            freeAgency();
            sequence = -1; 
            week = 0;
        team.teamOveralls();
     }
    }
    
    
    
    // sims a week of football -> your team versus another
    public static void weekSim(){
        
        // displays schedule, then the week, and the team titles 
        if (week >= 0 && week <= 16){
        System.out.println("Week: " + (week + 1));
        System.out.println(team.teamName  + " vs " + theOtherTeams.get(schedule[week]).NFLTeamNames + "\n"
                + "Overall: " + team.teamOverall + " Difficulty: " + theOtherTeams.get(schedule[week]).difficulty);
        
        
        // calculates teams ratings and adds modifier to your rating based on qb overall
        int modifier = player.qbOvr / 20; 
        int yourTeamRating = (int)(Math.random()*5) + (team.teamOverall + modifier);
       
        int opponentTeamRating = (int)(Math.random()*5) + theOtherTeams.get(schedule[week]).TeamsOveralls;
        
        
        // your team wins
        if (yourTeamRating > opponentTeamRating){
            int overallDifference = yourTeamRating % opponentTeamRating;
            
            System.out.println("The " + team.teamName + " Defeated The " + theOtherTeams.get(schedule[week]).NFLTeamNames);
        team.history.get(team.yearCounter).wins++;
        
                    if (overallDifference >= 10){
            int opponentScore = (int)(Math.random()*21)+7;
            int yourScore = (int)(Math.random()*21) + (opponentScore + 7);
            
            System.out.println(team.teamName + ":" + yourScore + " " + theOtherTeams.get(schedule[week]).NFLTeamNames + ":" + opponentScore);
                    }
                    else if (overallDifference >= 5 && overallDifference < 10){
                      int opponentScore = (int)(Math.random()*28)+7;
                      int yourScore = (int)(Math.random()*14) + (opponentScore + 3);
                      System.out.println(team.teamName + ":" + yourScore + " " + theOtherTeams.get(schedule[week]).NFLTeamNames + ":" + opponentScore);
                    }
                    else if (overallDifference >= 1 && overallDifference < 5){
                      int opponentScore = (int)(Math.random()*35)+7;
                      int yourScore = (int)(Math.random()*7) + (opponentScore + 1);
                      System.out.println(team.teamName + ":" + yourScore + " " + theOtherTeams.get(schedule[week]).NFLTeamNames + ":" + opponentScore);
         }
        }
        
        // your team losses 
        else if (yourTeamRating < opponentTeamRating){
            int overallDifference = opponentTeamRating % yourTeamRating;
            
            System.out.println("The " + theOtherTeams.get(schedule[week]).NFLTeamNames + " Defeated The " + team.teamName);
            team.history.get(team.yearCounter).losses++;
            
                  if (overallDifference >= 10){
                      int yourScore = (int)(Math.random()*21)+7;
                      int opponentScore = (int)(Math.random()*21)+  (yourScore + 7);
                  System.out.println(team.teamName + ":" + yourScore + " " + theOtherTeams.get(schedule[week]).NFLTeamNames + ":" + opponentScore);            
                  }
                  else if (overallDifference >= 5 && overallDifference < 10){
                      int yourScore = (int)(Math.random()*28)+7;
                      int opponentScore = (int)(Math.random()*14) + (yourScore + 3);
                  System.out.println(team.teamName + ":" + yourScore + " " + theOtherTeams.get(schedule[week]).NFLTeamNames + ":" + opponentScore);
                  }
                  else if (overallDifference >= 1 && overallDifference < 5){
                      int yourScore = (int)(Math.random()*35)+7;
                      int opponentScore = (int)(Math.random()*7) + (yourScore + 1);
                  System.out.println(team.teamName + ":" + yourScore + " " + theOtherTeams.get(schedule[week]).NFLTeamNames + ":" + opponentScore);
         }           
        }
        // both teams tie
        else if (yourTeamRating == opponentTeamRating){
            System.out.println("The" + team.teamName + " Tied With The " + theOtherTeams.get(schedule[week]).NFLTeamNames);
            team.history.get(team.yearCounter).ties++;
            int yourScore = (int)(Math.random()*35);
            int opponentScore = yourScore;
            System.out.println(team.teamName + ":" + yourScore + " " + theOtherTeams.get(schedule[week]).NFLTeamNames + ":" + opponentScore);
        }
        System.out.println(team.teamName + " Record: " + team.history.get(team.yearCounter).wins + "-" + team.history.get(team.yearCounter).losses + "-" + team.history.get(team.yearCounter).ties);
        week++;
    }
        // season over
        else if (week >= 17){
            
            // if requirements = playoffs if not = no playoffs 
                if (team.history.get(team.yearCounter).wins  >= 10 || team.history.get(team.yearCounter).wins  >= 9 && team.history.get(team.yearCounter).ties >= 1){
            System.out.println("The Regular Season Has Finished");
            System.out.println("The " + team.teamName + " Have A Record Of " + team.history.get(team.yearCounter).wins + "-" + team.history.get(team.yearCounter).losses + "-" + team.history.get(team.yearCounter).ties);
        System.out.println("Which Is Enough Wins To Make The Playoffs! Great Job Coach!");
        team.history.get(team.yearCounter).playoffs = "Yes";
        
        //requirement met = 1 less game you need to play in playoffs
        int winDivCondition = (int)(Math.random()*1)+13;
        if (team.history.get(team.yearCounter).wins >= winDivCondition){
           inSeasonConferenceChamp = true;
           round++;
       }
                }else if (team.history.get(team.yearCounter).wins <= 8 || team.history.get(team.yearCounter).wins == 9 && team.history.get(team.yearCounter).ties == 0){
                System.out.println("Sorry Coach, Your Team Did Not Meet The Requirements To Make The Playoffs\n"
                        + "Better Luck Next Season...");
                System.out.println("-----------------------------------------------");
                int random = (int)(Math.random()*30)+0;
                
                
                
                // if you dont make playoffs super bowl winner is...
                // first two seasons random team wins, so if coinFlip == 2 the same team wont win for many years in a row
                if (team.history.get(team.yearCounter).year == 2026){
                team.history.get(team.yearCounter).superBowl = season.theOtherTeams.get(random).NFLTeamNames;
                } else if (team.history.get(team.yearCounter).year == 2027){
                    team.history.get(team.yearCounter).superBowl = season.theOtherTeams.get(random).NFLTeamNames;
                }
                // allows for teams to make dynasties - realism, same team may win multiple years
                else {
                int coinFlip = (int)(Math.random()*2)+1;
                        if (coinFlip == 2){
                            int randomNum = (int)(Math.random()* (team.history.size() - 1));
                            String superBowlWinner = team.history.get(randomNum).superBowl;
                                    // so your own team wont be displayed as winnin the superbowl
                                    if (superBowlWinner.equals(team.myTeam)){
                                    team.history.get(team.yearCounter).superBowl = season.theOtherTeams.get(random).NFLTeamNames;
                                        }
                                    else{
                                    team.history.get(team.yearCounter).superBowl = team.history.get(randomNum).superBowl;
                                        }
                            }
                        else if (coinFlip == 1){
                            team.history.get(team.yearCounter).superBowl = season.theOtherTeams.get(random).NFLTeamNames;
                            }
                    }
                sequence = 22;
    }  
   }
  }
 }


