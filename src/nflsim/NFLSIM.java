package nflsim;
import java.util.Scanner; 
import java.util.InputMismatchException;
/*
* Runs Intro
* Runs Main Menu
*/
public class NFLSIM {
static int pickTeams = 0;
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // game intro
    System.out.println("==========WELCOME TO FRANCHISE SAVIOR==========");
    System.out.println("DO YOU HAVE WHAT IT TAKES TO WIN THE SUPERBOWL?");
    System.out.println("-----------------------------------------------");
    
    
    // displays teams and text describing user choices
    while (pickTeams == 0){
    System.out.println("**NFL TEAMS**");
    season.displayTeams();
    System.out.println("Type Number Of Team You Want To Coach...");
    System.out.print("Your Team Of Choice: ");
    
    
    
    // user inputs team they want to play as, multiple conditions based on inputs
    String choice = input.nextLine().trim();
    try{
    int teamChoice = Integer.parseInt(choice);
    if (teamChoice <= 32 && teamChoice > 0){
        team.teamName = season.nflTeams.get(teamChoice - 1);
        season.nflTeams.remove(teamChoice - 1);
        System.out.println("Congrats, You Are Now The Coach Of The " + team.teamName + "!");
        System.out.println("After Multiple Seasons Of Failure The Franchise Has Hired You As A Last Ditch Effort...");
        System.out.println("-----------------------------------------------");
        pickTeams++;
    }else{
         System.out.println("Invalid Input, Coach You Clearly Can't Type");
         System.out.println("-----------------------------------------------");    
 }   
} catch (NumberFormatException e){
     System.out.println("Invalid Input. Next Time Type A Number...");
     System.out.println("-----------------------------------------------");
 }
}
    

    // methods required for game to start properly 
    team.addPlayers();
    season.addTeamsToArray();
    team.teamOveralls();
    season.createSchedule();
    team.addHistory();
    
    // menu loop
        while (season.seasonActive){
          
            System.out.println("------------------------\n"
                    + "| Type 1: View Roster  |\n"
                    + "| Type 2: View Schedule|\n"
                    + "| Type 3: View History |\n"
                    + "| Type 4: Quit Game    |\n"
                    + "| Type 5: Continue     |\n"
                    + "------------------------");
            String myAnswer = input.nextLine().trim();
            try{
                int answer = Integer.parseInt(myAnswer);
                
            switch(answer){
                case 1:
                    season.displayMyTeam();
                    System.out.println("Team Overall: " + team.teamOverall);
                    break;
                case 2:
                    season.displaySchedule();
                    break;
                case 3:
                    team.displayHistory();
                    break;
                case 4:
                    System.out.println("Sad To See You go. Exiting The Game...");
                    season.seasonActive = false;
                    break;
                case 5:        
                    season.sequence();
                    season.sequence++; 
                    break;
                default:
                    break;  
    }      
   }catch (NumberFormatException e){
     System.out.println("Invalid Input. Next Time Type A Number...");
    }
   }
  }  
 }
