package bozntouran.encodingstrategies;

import lombok.NoArgsConstructor;
import lombok.NonNull;

@NoArgsConstructor
public class StrategiesFactory {

    private EncodingStrategy ret;

    public EncodingStrategy createEncodingStrategy(@NonNull String encoding) {

        if (encoding.equals("Rot13") ){
            ret = new Rot13Encoding();
        } else if (encoding.equals("AtBash")){
            ret = new AtBashEncoding();
        }else {
            System.err.println("Unknown error");
        }
        return ret;
    }

}

