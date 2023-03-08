import bozntouran.commands.CommandsFactory;
import bozntouran.model.Document;
import bozntouran.model.Line;
import org.junit.Test;
import bozntouran.texttospeechapis.FakeTextToSpeechAPI;
import bozntouran.texttospeechapis.TextToSpeechAPI;
import bozntouran.texttospeechapis.TextToSpeechAPIFactory;

import java.awt.event.ActionListener;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ReverseLineToSpeechTest {

    private Document document;
    @Test
    public void test(){
        String testFileName = "testFile.txt";
        String authorName = "Hobbit";
        String title = "A small story about a naugthy dragon.";
        String contentLine = "The mountain obsseion.";
        String secondContentLine = "Ancient ruins.";

        document = new Document(authorName,title,testFileName);
        ArrayList<Line> contents = new ArrayList<Line>();
        Line firstLine = new Line(contentLine);
        Line secondLine = new Line(secondContentLine);
        contents.add(firstLine);
        contents.add(secondLine);
        document.setContents(contents);

        TextToSpeechAPIFactory factory = new TextToSpeechAPIFactory();
        TextToSpeechAPI api = factory.createTTSAPI("FakeTextToSpeechAPI");
        document.setAudioManager(api);

        CommandsFactory commandsFactory = new CommandsFactory(document,1);
        ActionListener command = commandsFactory.createCommand("playReversedLine");
        command.actionPerformed(null);

        api = document.getAudioManager();
        ArrayList<String> contentToPlay = ((FakeTextToSpeechAPI) api).getContentToPlay();
        String reversedLine = contentToPlay.get(0);
        String []splitedLine = contentLine.split("\\s+");
        String line = splitedLine[2] +" "+ splitedLine[1]+" "+splitedLine[0]+" ";
        assertEquals(line,reversedLine);
    }
}
