package bozntouran;

import bozntouran.view.TextToSpeechEditorView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                TextToSpeechEditorView GUI =  TextToSpeechEditorView.getSingletonView();
                GUI.initComponents();
                GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                GUI.setVisible(true);
            }
        });
    }
}