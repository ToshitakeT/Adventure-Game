package main.java;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class ParseFile {
//     public static void main(String[] argus) throws FileNotFoundException {
//       PageTree tree1 = parseFile("text.txt");
//       
//     }
    public static PageTree parseFile(String filePath) throws FileNotFoundException {
      Map<Integer, String> map = getPages(filePath);
      return new PageTree(map);
    }
    
    public static Map<Integer, String> getPages(String filePath) throws FileNotFoundException {
         Scanner scan = new Scanner(new File(filePath));
         Map<Integer, String> map = new HashMap<Integer, String>();
         int pageNumber = 1;
         while(scan.hasNextLine()){
            map.put(pageNumber, scan.nextLine());
            pageNumber++;
         }
         return map;
    }
}
