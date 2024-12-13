public class TeilenummerException extends Exception{
    public String sTeilenummer;
    public String sFehlertext;





    public TeilenummerException(String sTeilenummer,String sFehlertext) {
        super(sFehlertext);

        this.sTeilenummer = sTeilenummer;
        this.sFehlertext= sFehlertext;


       }



}
