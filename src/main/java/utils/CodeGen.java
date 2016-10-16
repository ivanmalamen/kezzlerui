package utils;

import java.util.UUID;

/**
 * Created by admin on 10/16/2016.
 */
public class CodeGen {

    public String generate(){
        String code = UUID.randomUUID().toString().replace("-","").toUpperCase()+".";
        return code;
    }
}
