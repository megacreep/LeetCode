package com.megacreep.LeetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        int length = 1;
        Set<String> fromSet = new HashSet<String>();
        fromSet.add(start);
        dict.add(end);

        while (true) {
            Set<String> nextLayer = new HashSet<String>();
            for (String from : fromSet) {
                nextLayer.addAll(nextTrans(from, dict));
                if (nextLayer.contains(end)) {
                    return length + 1;
                }
            }
            System.out.println(nextLayer);
            if (nextLayer.isEmpty()) {
                break;
            }
            length++;
            fromSet = nextLayer;
        }
        return 0;
    }

    private Set<String> nextTrans(String from, Set<String> dict) {
        Set<String> result = new HashSet<String>();
        for (int i = 0; i < from.length(); i++) {
            char[] array = from.toCharArray();
            for (array[i] = 'a'; array[i] <= 'z'; array[i]++) {
                String temp = new String(array);
                if (dict.contains(temp)) {
                    dict.remove(temp);
                    result.add(temp);
                }
            }
        }
        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        Set<String> dict = Utils.generateSet(new String[] { "dose", "ends",
                "dine", "jars", "prow", "soap", "guns", "hops", "cray", "hove",
                "ella", "hour", "lens", "jive", "wiry", "earl", "mara", "part",
                "flue", "putt", "rory", "bull", "york", "ruts", "lily", "vamp",
                "bask", "peer", "boat", "dens", "lyre", "jets", "wide", "rile",
                "boos", "down", "path", "onyx", "mows", "toke", "soto", "dork",
                "nape", "mans", "loin", "jots", "male", "sits", "minn", "sale",
                "pets", "hugo", "woke", "suds", "rugs", "vole", "warp", "mite",
                "pews", "lips", "pals", "nigh", "sulk", "vice", "clod", "iowa",
                "gibe", "shad", "carl", "huns", "coot", "sera", "mils", "rose",
                "orly", "ford", "void", "time", "eloy", "risk", "veep", "reps",
                "dolt", "hens", "tray", "melt", "rung", "rich", "saga", "lust",
                "yews", "rode", "many", "cods", "rape", "last", "tile", "nosy",
                "take", "nope", "toni", "bank", "jock", "jody", "diss", "nips",
                "bake", "lima", "wore", "kins", "cult", "hart", "wuss", "tale",
                "sing", "lake", "bogy", "wigs", "kari", "magi", "bass", "pent",
                "tost", "fops", "bags", "duns", "will", "tart", "drug", "gale",
                "mold", "disk", "spay", "hows", "naps", "puss", "gina", "kara",
                "zorn", "boll", "cams", "boas", "rave", "sets", "lego", "hays",
                "judy", "chap", "live", "bahs", "ohio", "nibs", "cuts", "pups",
                "data", "kate", "rump", "hews", "mary", "stow", "fang", "bolt",
                "rues", "mesh", "mice", "rise", "rant", "dune", "jell", "laws",
                "jove", "bode", "sung", "nils", "vila", "mode", "hued", "cell",
                "fies", "swat", "wags", "nate", "wist", "honk", "goth", "told",
                "oise", "wail", "tels", "sore", "hunk", "mate", "luke", "tore",
                "bond", "bast", "vows", "ripe", "fond", "benz", "firs", "zeds",
                "wary", "baas", "wins", "pair", "tags", "cost", "woes", "buns",
                "lend", "bops", "code", "eddy", "siva", "oops", "toed", "bale",
                "hutu", "jolt", "rife", "darn", "tape", "bold", "cope", "cake",
                "wisp", "vats", "wave", "hems", "bill", "cord", "pert", "type",
                "kroc", "ucla", "albs", "yoko", "silt", "pock", "drub", "puny",
                "fads", "mull", "pray", "mole", "talc", "east", "slay", "jamb",
                "mill", "dung", "jack", "lynx", "nome", "leos", "lade", "sana",
                "tike", "cali", "toge", "pled", "mile", "mass", "leon", "sloe",
                "lube", "kans", "cory", "burs", "race", "toss", "mild", "tops",
                "maze", "city", "sadr", "bays", "poet", "volt", "laze", "gold",
                "zuni", "shea", "gags", "fist", "ping", "pope", "cora", "yaks",
                "cosy", "foci", "plan", "colo", "hume", "yowl", "craw", "pied",
                "toga", "lobs", "love", "lode", "duds", "bled", "juts", "gabs",
                "fink", "rock", "pant", "wipe", "pele", "suez", "nina", "ring",
                "okra", "warm", "lyle", "gape", "bead", "lead", "jane", "oink",
                "ware", "zibo", "inns", "mope", "hang", "made", "fobs", "gamy",
                "fort", "peak", "gill", "dino", "dina", "tier" });
        System.out.println(new WordLadder().ladderLength("nape", "mild", dict));
    }

}
