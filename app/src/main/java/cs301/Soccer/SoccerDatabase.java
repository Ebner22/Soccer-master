package cs301.Soccer;

import android.util.Log;
import cs301.Soccer.soccerPlayer.SoccerPlayer;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Soccer player database -- presently, all dummied up
 *
 * @author *** put your name here ***
 * @version *** put date of completion here ***
 *
 */
public class SoccerDatabase implements SoccerDB {

    private Hashtable<String,SoccerPlayer> hTable = new Hashtable<String, SoccerPlayer>();

    /**
     * add a player
     *
     * @see SoccerDB#addPlayer(String, String, int, String)
     */
    @Override
    public boolean addPlayer(String firstName, String lastName,
                             int uniformNumber, String teamName) {

        String nameString = firstName + "##" + lastName;
        if (hTable.get(nameString) != null) {
            return false;
        }//check if player is already in database

        SoccerPlayer np = new SoccerPlayer(firstName, lastName, uniformNumber, teamName);

        hTable.put(nameString,np);
        return true;
    }

    /**
     * remove a player
     *
     * @see SoccerDB#removePlayer(String, String)
     */
    @Override
    public boolean removePlayer(String firstName, String lastName) {
        String nameStringGetPlayer = firstName + "##" + lastName;
        if (hTable.containsKey(nameStringGetPlayer)){
            hTable.remove(nameStringGetPlayer);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * look up a player
     *
     * @see SoccerDB#getPlayer(String, String)
     */
    @Override
    public SoccerPlayer getPlayer(String firstName, String lastName) {
        String nameStringGetPlayer = firstName + "##" + lastName;
        return hTable.get(nameStringGetPlayer);
    }

    /**
     * increment a player's goals
     *
     * @see SoccerDB#bumpGoals(String, String)
     */
    @Override
    public boolean bumpGoals(String firstName, String lastName) {
        String nameStringGetPlayer = firstName + "##" + lastName;
        if (hTable.containsKey(nameStringGetPlayer)){
            SoccerPlayer sp=hTable.get(nameStringGetPlayer);
            sp.bumpGoals();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's assists
     *
     * @see SoccerDB#bumpAssists(String, String)
     */
    @Override
    public boolean bumpAssists(String firstName, String lastName) {
        String nameStringGetPlayer = firstName + "##" + lastName;
        if (hTable.containsKey(nameStringGetPlayer)){
            SoccerPlayer sp=hTable.get(nameStringGetPlayer);
            sp.bumpAssists();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's shots
     *
     * @see SoccerDB#bumpShots(String, String)
     */
    @Override
    public boolean bumpShots(String firstName, String lastName) {
        String nameStringGetPlayer = firstName + "##" + lastName;
        if (hTable.containsKey(nameStringGetPlayer)){
            SoccerPlayer sp=hTable.get(nameStringGetPlayer);
            sp.bumpShots();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's saves
     *
     * @see SoccerDB#bumpSaves(String, String)
     */
    @Override
    public boolean bumpSaves(String firstName, String lastName) {
        String nameStringGetPlayer = firstName + "##" + lastName;
        if (hTable.containsKey(nameStringGetPlayer)){
            SoccerPlayer sp=hTable.get(nameStringGetPlayer);
            sp.bumpSaves();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's fouls
     *
     * @see SoccerDB#bumpFouls(String, String)
     */
    @Override
    public boolean bumpFouls(String firstName, String lastName) {
        String nameStringGetPlayer = firstName + "##" + lastName;
        if (hTable.containsKey(nameStringGetPlayer)){
            SoccerPlayer sp=hTable.get(nameStringGetPlayer);
            sp.bumpFouls();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's yellow cards
     *
     * @see SoccerDB#bumpYellowCards(String, String)
     */
    @Override
    public boolean bumpYellowCards(String firstName, String lastName) {
        String nameStringGetPlayer = firstName + "##" + lastName;
        if (hTable.containsKey(nameStringGetPlayer)){
            SoccerPlayer sp=hTable.get(nameStringGetPlayer);
            sp.bumpYellowCards();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * increment a player's red cards
     *
     * @see SoccerDB#bumpRedCards(String, String)
     */
    @Override
    public boolean bumpRedCards(String firstName, String lastName) {
        String nameStringGetPlayer = firstName + "##" + lastName;
        if (hTable.containsKey(nameStringGetPlayer)){
            SoccerPlayer sp=hTable.get(nameStringGetPlayer);
            sp.bumpRedCards();
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * tells the number of players on a given team
     *
     * @see SoccerDB#numPlayers(String)
     */
    @Override
    // report number of players on a given team (or all players, if null)
    public int numPlayers(String teamName) {
        int numCount = 0;
        if(teamName == null) {
            return hTable.size();
        }
        else {
            for (SoccerPlayer p: hTable.values()){
                if (p.getTeamName().equals(teamName)){
                    numCount++;
                    }
                }
            }
        return numCount;
        }

    /**
     * gives the nth player on a the given team
     *
     * @see SoccerDB#playerNum(int, String)
     */
    // get the nTH player
    @Override
    public SoccerPlayer playerNum(int idx, String teamName) {
        int count=0;
        if (teamName==null) {
            for (SoccerPlayer p: hTable.values()){
                if (count==idx){
                    return p;
                }
                else{
                    count++;
                }
                
            }
        }
        else{
            for (SoccerPlayer p: hTable.values()){
                if (p.getTeamName().equals(teamName)){
                    if (count==idx){return p;}
                    else{count++;}
                }
            }
        }
        return null;
    }

    /**
     * reads database data from a file
     *
     * @see SoccerDB#readData(java.io.File)
     */
    // read data from file
    @Override
    public boolean readData(File file) {
        return file.exists();
    }

    /**
     * write database data to a file
     *
     * @see SoccerDB#writeData(java.io.File)
     */
    // write data to file
    @Override
    public boolean writeData(File file) {
        try {
            FileWriter fw=new FileWriter(file);
            for (SoccerPlayer p: hTable.values()){
                fw.write(logString(p.getFirstName()));
                fw.write(logString(p.getLastName()));
                fw.write(logString(""+p.getUniform()));
                fw.write(logString(p.getTeamName()));
                fw.write(logString(""+p.getAssists()));
                fw.write(logString(""+p.getFouls()));
                fw.write(logString(""+p.getGoals()));
                fw.write(logString(""+p.getSaves()));
                fw.write(logString(""+p.getShots()));
                fw.write(logString(""+p.getYellowCards()));
                fw.write(logString(""+p.getRedCards()));
                fw.close();

            }
        } catch (IOException e) {
            Log.e("File","An error occurred");
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * helper method that logcat-logs a string, and then returns the string.
     * @param s the string to log
     * @return the string s, unchanged
     */
    private String logString(String s) {
        Log.i("write string", s);
        return s;
    }

    /**
     * returns the list of team names in the database
     *
     * @see cs301.Soccer.SoccerDB#getTeams()
     */
    // return list of teams
    @Override
    public HashSet<String> getTeams() {
        return new HashSet<String>();
    }

}
