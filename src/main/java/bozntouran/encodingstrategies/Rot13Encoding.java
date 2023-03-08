package bozntouran.encodingstrategies;


public class Rot13Encoding extends TemplateEncoding {

    public Rot13Encoding(){
    }

    @Override
    public String encode(String stringToEncode) {
        char[] encodedChars = new char[stringToEncode.length()];
        for (int i = 0; i < stringToEncode.length(); i++) {
            encodedChars[i] = mapCharacter(stringToEncode.charAt(i));
        }
        return new String(encodedChars);
    }

    protected char mapCharacter(char letter){
        char characteToReturn = 0;
        if (letter >= 'A' && letter <= 'Z') {
            characteToReturn = (char) (((letter - 'A') + 13) % 26 + 'A') ;
        } else if (letter >= 'a' && letter <= 'z') {
            characteToReturn = (char) (((letter - 'a') + 13) % 26 + 'a');
        }
        return characteToReturn;

    }
}
