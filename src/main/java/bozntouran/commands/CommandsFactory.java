package bozntouran.commands;

import bozntouran.encodingstrategies.EncodingStrategy;
import bozntouran.model.Document;


import java.awt.event.ActionListener;
import lombok.Data;

public class CommandsFactory {
    private Document document;
    private int selectedLine;
    private EncodingStrategy encodingStrategy;

    private ActionListener command;


    public CommandsFactory(Document document){
    	this.document = document;
    }

    public CommandsFactory(Document document, EncodingStrategy encodingStrategy){
        this.document = document;
        this.encodingStrategy = encodingStrategy;
    }
    public CommandsFactory(Document document, int selectedLine){
        this.document = document;
        this.selectedLine = selectedLine;
    }
/*
    public ActionListener createCommand(String commandToCreate){

        if (commandToCreate.equals("openDocument")){
            command =new OpenDocument(document);
        } else if (commandToCreate.equals("newDocument")){
            command = new NewDocument(document);
        } else if (commandToCreate.equals("saveDocument")){
            command = new SaveDocument(document);
        } else if (commandToCreate.equals("lineToSpeech")){
            command = new LineToSpeech(document, selectedLine);
        } else if (commandToCreate.equals("editDocument")){
            command = new EditDocument(document);
        } else if (commandToCreate.equals("documentToSpeech")){
            command = new DocumentToSpeech(document);
        } else if (commandToCreate.equals("reverseDocumentToSpeech")){
            command = new ReverseDocumentToSpeech(document);
        } else if (commandToCreate.equals("tuneEncodings")){
            command = new TuneEncodings(document,encodingStrategy);
        } else if (commandToCreate.equals("playEncodedLine")){
            command = new PlayEncodedLine(document, selectedLine);
        } else if (commandToCreate.equals("playReversedLine")){
            command = new PlayReverseLine(document, selectedLine);
        } else if (commandToCreate.equals("encodedDocumentToSpeech")){
            command = new EncodedDocumentToSpeech(document);
        }else if (commandToCreate.isEmpty()){
            System.err.println("Commnad to be created is empty");
        }
        return command;
    }
*/
    public ActionListener createCommand(CommandType commandType,int []tuneParameters){
        if (commandType.equals(CommandType.TUNE_AUDIO)) {
            command = new TuneAudio(document,tuneParameters);
        }else{
            command = null;
        }
        return command;
    }



        public ActionListener createCommand(CommandType commandType) {
            return switch (commandType) {
                case OPEN_DOCUMENT -> new OpenDocument(document);
                case NEW_DOCUMENT -> new NewDocument(document);
                case SAVE_DOCUMENT -> new SaveDocument(document);
                case LINE_TO_SPEECH -> new LineToSpeech(document, selectedLine);
                case EDIT_DOCUMENT -> new EditDocument(document);
                case DOCUMENT_TO_SPEECH -> new DocumentToSpeech(document);
                case REVERSE_DOCUMENT_TO_SPEECH -> new ReverseDocumentToSpeech(document);
                case TUNE_ENCODINGS -> new TuneEncodings(document, encodingStrategy);
                case PLAY_ENCODED_LINE -> new PlayEncodedLine(document, selectedLine);
                case PLAY_REVERSED_LINE -> new PlayReverseLine(document, selectedLine);
                case ENCODED_DOCUMENT_TO_SPEECH -> new EncodedDocumentToSpeech(document);
                default -> throw new IllegalArgumentException("Unknown command type: " + commandType);
            };
        }





}
