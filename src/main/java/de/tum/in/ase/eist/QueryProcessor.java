package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
        query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
            return "Long";
        } else if (query.contains("largest:")) {
            query.replace(",", "");
            String[] array = query.split(" ");
            int counter = 0;
            for (String  s : array) {
                if(s.contains("1") || s.contains("2") ||
                        s.contains("3") || s.contains("4") || s.contains("5") || s.contains("6") || s.contains("7") ||s.contains("8") || s.contains("9")){
                    break;
                }
                counter++;
            }
            int[] zahlenarray = new int[array.length-counter];
            int j =0;
            for (int i = counter; i < array.length; i++) {
                zahlenarray[j++] = Integer.parseInt(array[i]);
            }
            int zahl1 = zahlenarray[0];
            for (int i = 0; i < zahlenarray.length; i++) {
                if(zahlenarray[i] > zahl1) {
                    zahl1 = zahlenarray[i];
                }
            }
            return ""+zahl1;
        } else {
            return "";
        }
    }
}
