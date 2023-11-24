/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author dell
 */
public class Flight {
    
    Date date; /*Choose a date from calendar ... in DDMMMYYYY FORMAT*/
    char[] flight_no; /*Contain of letters and number – English only*/
    char[] org; /*Text field max 4 letters English only*/
    char[] dest1; /*Text field max 4 letters English only*/
    char[] dest2; /*Text field max 4 letters English only*/
    char[] dest3; /*Text field max 4 letters English only*/
    int[] sta; /*Text field – 24 hours’ time format*/
    char[] ac_type; /*Drop down list from database... (330-200 P2F) by default*/
    char[] reg; /*5 letters – English and numbers only mandatory*/
}
