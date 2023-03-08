package bozntouran.commands;

import bozntouran.encodingstrategies.EncodingStrategy;
import bozntouran.model.Document;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TuneEncodings implements ActionListener{

    private Document document;
    private EncodingStrategy encodingStrategy;
    public TuneEncodings(Document document,EncodingStrategy encodingStrategy){
        this.document = document;
        this.encodingStrategy = encodingStrategy;
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        document.tuneEncodingStrategy(encodingStrategy);
    }
}
