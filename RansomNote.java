/**
 *  Given an arbitrary ransom note string and another string containing letters from all the magazines,
 *  write a function that will return true if the ransom note can be constructed from the magazines ;
 *  otherwise, it will return false.
 Each letter in the magazine string can only be used once in your ransom note.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.*;

/**
 * Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true

 * */
public class RansomNote {
    //Not efficient enough
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        char[] ransomNoteArray = ransomNote.toCharArray();
        for (int i = 0; i <ransomNoteArray.length ; i++) {
           if(map.containsKey(ransomNoteArray[i])){
               int value = map.get(ransomNoteArray[i]);
               map.remove(ransomNoteArray[i]);
               map.put(ransomNoteArray[i],value+1);
           }
           else{
               map.put(ransomNoteArray[i],1);
           }
        }
        /*iterator of map
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        System.out.println();*/
        char[] magazineArray = magazine.toCharArray();
        for (int i = 0; i <magazineArray.length ; i++) {
            if(!map.containsKey(magazineArray[i])) continue;
            else{
               int value =map.get(magazineArray[i]);
                   map.remove(magazineArray[i]);
                   map.put(magazineArray[i],value-1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue()>0) return false;
        }
        return true;
    }

    public boolean canConstructEfficient(String ransomNote,String magazine){
        int[] table = new int[26];
        for (char c : magazine.toCharArray())   table[c - 'a']++;
        for (char c : ransomNote.toCharArray())
            if (--table[c - 'a'] < 0) return false;
        return true;
    }

    public static void main(String[] args) {
        RansomNote r = new RansomNote();
        long now = System.currentTimeMillis();
        System.out.println( r.canConstruct("baaaccd","aabccddd"));
        long finish = System.currentTimeMillis();
        System.out.println(finish-now);
        now=System.currentTimeMillis();
        System.out.println(r.canConstructEfficient("baaaccd","aabccddd"));
        System.out.println(System.currentTimeMillis()-now);
    }
}
