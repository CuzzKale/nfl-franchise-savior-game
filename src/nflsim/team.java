package nflsim;
import java.util.ArrayList;
/*
* stores general team values 
* methods that add players to team & get overall
* method that changes team & player values
* methods that change and display league history
*/
public class team {
    static String teamName;
    static int salaryCap = 150;
    static ArrayList<player> myTeam = new ArrayList<>();
    static int teamOverall = 0;
     int wins;
     int losses;
     int ties;
    int year;
    static int yearActual = 2026;
     String superBowl;
     String playoffs;
     String conference;
     // important field -> used as index in history array.get() | adds +1 eaach year
    static int yearCounter = 0;
    
    static ArrayList<team> history = new ArrayList<>();
    
    
    
    // constructor - values for history object
    public team(int teamWins, int teamLosses, int teamTies, int seasonYear, String superBowlWinner, String makePlayoffs, String winConference){
        this.wins = teamWins;
        this.losses = teamLosses;
        this.ties = teamTies;
        this.year = seasonYear;
        this.superBowl = superBowlWinner;
        this.playoffs = makePlayoffs;
        this.conference = winConference;
    }
    
    
    
    // adds initial players to team
    public static void addPlayers(){
        
        for (int i = 0; i < 10; i++){
        myTeam.add(player.playerCreator()); 
     }   
    }
    
    
    
    // when called --> generates team overall
    public static void teamOveralls(){
            for (int i = 0; i < myTeam.size(); i++){
               teamOverall += myTeam.get(i).overall;
            }
            teamOverall /= myTeam.size();
            System.out.println("Team Overall: " + teamOverall);
        }
    
    
    
    /// assigns initial values for each season - returns history object
    public static team history(){
        int seasonYear = 2026;
        int teamWins = 0;
        int teamLosses = 0;
        int teamTies = 0;
        String superBowlWinner = "None";
        String makePlayoffs = "No";
        String winConference = "No";  
        team history = new team(teamWins, teamLosses, teamTies, seasonYear, superBowlWinner, makePlayoffs, winConference);
        return history;
    }
    
    
    // adds each season stats to array that stores the season stats
    public static void addHistory(){
        history.add(history());
    }
    
    
    
    // displays each seasons facts & stats
    public static void displayHistory(){
        System.out.println("TEAM HISTORY\n"
                + "------------");
        System.out.println("Year  Record  Playoffs   Win Conf   Superbowl Winner\n"
                + "----  ------  --------   --------   ----------------");
        for (team t: history){
        System.out.println(t.year + ": " + t.wins + "-" + t.losses + "-" + t.ties
        + "   " + t.playoffs + "         " + t.conference + "         " + t.superBowl);
        
        }
    }
    
    
    
    // changes player values every season, resets or changes team values 
    public static void attributeChanges(){
        
        teamOverall = 0;
        team.addHistory();
        team.yearCounter += 1;
        team.yearActual++;
        history.get(yearCounter).year = yearActual;
        history.get(yearCounter).wins = 0;
        history.get(yearCounter).losses = 0;
        history.get(yearCounter).ties = 0;
        history.get(yearCounter).playoffs = "No";
        history.get(yearCounter).conference = "No";
        history.get(yearCounter).superBowl = "None";
        season.round = 0;
        season.inSeasonConferenceChamp = false;
        season.removeTeamsFromArray();
        season.addTeamsToArray();
        
        
        
        // intro
        System.out.println("Welcome To The Offseason! Some Players May Retire, Others Will Put In The Work And Get Better...\n"
                + "Older Players May Regress. You Will Have The Opportunity To Resign Players At The End Of Their Contracts\n"
                + "If There Are Open Spots On The Team You Can Select A Player In The Draft\n"
                + "Or Your Owner Will Sign A Free Agent To Fill The Vacancy");    
        System.out.println("**PLAYER UPDATES AND RETIREMENTS**"); 
        System.out.println("----------------------------------");
        
      
        for (int i = 0; i < myTeam.size(); i++){
            // roster spot not open
            if (myTeam.get(i) != null) {
                int previousOverall =  myTeam.get(i).overall;
                myTeam.get(i).age += 1;
                myTeam.get(i).contractLength -= 1;
                
                // younger = increase ovr
                if (myTeam.get(i).age >= 21 && myTeam.get(i).age < 30){
                myTeam.get(i).skillOne += (int)(Math.random()*4)+1;
                myTeam.get(i).skillTwo += (int)(Math.random()*4)+1;
                myTeam.get(i).overall = (myTeam.get(i).skillOne + myTeam.get(i).skillTwo)/2;
                }
                // older = decrease ovr
                else if (myTeam.get(i).age >= 30){
                    myTeam.get(i).skillOne -= (int)(Math.random()*2)+1;
                    myTeam.get(i).skillOne -= (int)(Math.random()*2)+1; 
                    myTeam.get(i).overall = (myTeam.get(i).skillOne + myTeam.get(i).skillTwo)/2;
                }
                // overall cannot go over potetial
                if (myTeam.get(i).overall > myTeam.get(i).potential){
                    myTeam.get(i).overall = myTeam.get(i).potential;
                }
                // retires player if requirements met
              if (myTeam.get(i).age == 34){
                  System.out.println(myTeam.get(i).name + " Has Retired From The " + teamName + " At Age " + myTeam.get(i).age + " Fans Will Aways Remember Him For His Hard Work And Toughness...");
                  player.listPositions.add(myTeam.get(i).position);
                  myTeam.remove(i);
                  myTeam.add(null);
                  System.out.println("----------------------------------------------------------------------------------------------------------------------");
              } 
              if (myTeam.get(i) != null){
               System.out.println("Name: " + team.myTeam.get(i).name + " Age: " + team.myTeam.get(i).age + " Position: " + team.myTeam.get(i).position + " Contract Length: " +
                    team.myTeam.get(i).contractLength + " " +
                    team.myTeam.get(i).skillOneText + ": " + team.myTeam.get(i).skillOne  + " " +  myTeam.get(i).skillTwoText + ": " +
                   team.myTeam.get(i).skillTwo +  " Overall: " + team.myTeam.get(i).overall  +
                    " Potential: " + team.myTeam.get(i).potentialLetter);
               // since qbs ovr will be used as modifier when simming games, needs to be put in variable 
               if (myTeam.get(i).position.equalsIgnoreCase("qb")){
                player.qbOvr = myTeam.get(i).overall;
            }
               
               if (myTeam.get(i).overall > previousOverall){
              System.out.println("Overall Change: +" + (myTeam.get(i).overall - previousOverall));
              System.out.println("----------------------------------------------------------------------------------------------------------------------");
               }
               else if (myTeam.get(i).overall < previousOverall){
              System.out.println("Overall Change: -" + (previousOverall - myTeam.get(i).overall)); 
              System.out.println("----------------------------------------------------------------------------------------------------------------------");
               } 
               else if (myTeam.get(i).overall == previousOverall){
                   System.out.println("Overall Change: 0");
                   System.out.println("----------------------------------------------------------------------------------------------------------------------");
     }
    }
   }
  } 
 }
}

