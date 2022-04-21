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
    public void testTestFile() throws IOException {
        ArrayList<String> endLinks = null;
        try{
            endLinks = MarkdownParse.getLinks(Files.readString(Path.of("test-file.md")));
        }
        catch(IOException io){
            System.out.println(io.getMessage());
            throw io;
        }
        
        System.out.println(endLinks);
        assertEquals(List.of("https://something.com", "some-thing.html"), endLinks);
    }
}
