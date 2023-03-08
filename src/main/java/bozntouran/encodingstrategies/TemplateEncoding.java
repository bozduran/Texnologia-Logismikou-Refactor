package bozntouran.encodingstrategies;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class TemplateEncoding implements EncodingStrategy {

    public String encode(String stringToEncode){
        return stringToEncode;
    }

    abstract protected char mapCharacter(char letter);
}
