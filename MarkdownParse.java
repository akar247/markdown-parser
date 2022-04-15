//https://howtodoinjava.com/java/io/java-read-file-to-string-examples/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class MarkdownParse {

    public static ArrayList<String> getLinks(String markdown) {
        ArrayList<String> toReturn = new ArrayList<>();
        // find the next [, then find the ], then find the (, then read link upto next )
        int currentIndex = 0;
        while(currentIndex < markdown.length()) {
            int openBracket = markdown.indexOf("[", currentIndex);
            int nextOpen = markdown.indexOf("[", openBracket+1);
            int closeBracket = markdown.indexOf("]", openBracket);
            int openParen = markdown.indexOf("(", closeBracket);
            int closeParen = markdown.indexOf(")", openParen);
            if(nextOpen != -1){
                while(markdown.indexOf(")", closeParen+1) < nextOpen){
                    if(markdown.indexOf(")", closeParen+1) == -1){
                        break;
                    }
                    closeParen = markdown.indexOf(")", closeParen+1);
                }
            }
            else{
                while(markdown.indexOf(")", closeParen+1) != -1){

                    closeParen = markdown.indexOf(")", closeParen+1);
                }
            }
            if(openParen == -1 || closeParen == -1){
                if(openParen == -1){
                    openParen = closeBracket;
                }
                if(closeParen == -1){
                    if(nextOpen == -1){
                        closeParen = markdown.length();
                    }
                    else{
                        closeParen = nextOpen - 1;
                    }
                }
            }
            if(openBracket != 0 && markdown.charAt(openBracket-1) == '!'){
                currentIndex = closeParen + 1;
            }
            else{
                toReturn.add(markdown.substring(openParen + 1, closeParen));
                currentIndex = closeParen + 1;
            }
        }
        return toReturn;
    }


    public static void main(String[] args) throws IOException {
        Path fileName = Path.of(args[0]);
        String content = Files.readString(fileName);
        ArrayList<String> links = getLinks(content);
	    System.out.println(links);
    }
}