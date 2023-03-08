package bozntouran.encodingstrategies;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AtBashEncoding extends TemplateEncoding {

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
            characteToReturn = (char) ('Z'-(letter - 'A')) ;
        } else if (letter >= 'a' && letter <= 'z') {
            characteToReturn = (char) ('z'-(letter - 'a'));
        }
        return characteToReturn;

    }


}
