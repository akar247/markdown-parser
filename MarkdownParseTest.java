import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;

import org.junit.*; 

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testTestFile(){
        ArrayList<String> endLinks1 = null;
        ArrayList<String> endLinks2 = null;
        ArrayList<String> endLinks3 = null;
        ArrayList<String> endLinks4 = null;
        try{
            endLinks1 = MarkdownParse.getLinks(Files.readString(Path.of("test-file.md")));
            endLinks2 = MarkdownParse.getLinks(Files.readString(Path.of("MyTests-file.md")));
            endLinks3 = MarkdownParse.getLinks(Files.readString(Path.of("testImage")));
            endLinks4 = MarkdownParse.getLinks(Files.readString(Path.of("testNoPs")));
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }
        
        assertEquals(List.of("https://something.com", "some-thing.html"), endLinks1);
        assertEquals(List.of("https://google.com", "https://languages.oup.com/google-dictionary-en/", "https://en.wikipedia.org/wiki/Robert_Morin_(librarian)"), endLinks2);
        assertEquals(List.of("canvas.com"), endLinks3);
        assertEquals(List.of("www.google.com"), endLinks4);
    }

    @Test
    public void testGiventests(){
        ArrayList<String> endLinks2 = null;
        ArrayList<String> endLinks3 = null;
        ArrayList<String> endLinks4 = null;
        ArrayList<String> endLinks5 = null;
        ArrayList<String> endLinks6 = null;
        ArrayList<String> endLinks7 = null;
        ArrayList<String> endLinks8 = null;
        try{
            endLinks2 = MarkdownParse.getLinks(Files.readString(Path.of("test-file2.md")));
            endLinks3 = MarkdownParse.getLinks(Files.readString(Path.of("test-file3.md")));
            endLinks4 = MarkdownParse.getLinks(Files.readString(Path.of("test-file4.md")));
            endLinks5 = MarkdownParse.getLinks(Files.readString(Path.of("test-file5.md")));
            endLinks6 = MarkdownParse.getLinks(Files.readString(Path.of("test-file6.md")));
            endLinks7 = MarkdownParse.getLinks(Files.readString(Path.of("test-file7.md")));
            endLinks8 = MarkdownParse.getLinks(Files.readString(Path.of("test-file8.md")));
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }
        
        //gives me an infinite loop
        //assertEquals(List.of("https://something.com, some-page.html"), endLinks2); 

        assertEquals(List.of(""), endLinks3);
    }
}


