import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class MDParserTester2 {
    
    @Test
    public void testSnip1(){
        ArrayList<String> expected = new ArrayList<>(List.of("google.com", 
        "google.com", "ucsd.edu"));

        ArrayList<String> actual = null;

        try{
            actual = MarkdownParse.getLinks(Files.readString(Path.of("Snip1.md")));
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testSnip2(){
        ArrayList<String> expected = new ArrayList<>(List.of("a.com", 
        "a.com(())", "example.com"));

        ArrayList<String> actual = null;

        try{
            actual = MarkdownParse.getLinks(Files.readString(Path.of("Snip2.md")));
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void testSnip3(){
        ArrayList<String> expected = new ArrayList<>(List.of("https://twitter.com", 
        "https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule", 
        "https://cse.ucsd.edu/"));

        ArrayList<String> actual = null;

        try{
            actual = MarkdownParse.getLinks(Files.readString(Path.of("Snip3.md")));
        }
        catch(IOException io){
            System.out.println(io.getMessage());
        }

        assertEquals(expected, actual);
    }
}
