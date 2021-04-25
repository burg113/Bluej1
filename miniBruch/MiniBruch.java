public class MiniBruch {
    private long numerator=0;
    private long denominator=0;

    MiniBruch(long numerator,long denominator){
        this.numerator=numerator;
        this.denominator=denominator;
    }

    double berechne(){
        return (double)numerator/denominator;
    }

    boolean isNennerNull(){
        return denominator==0;
    }

    void print(){
        int lenN=(""+numerator).length();
        int lenD=(""+denominator).length();
        int max=Math.max(lenN,lenD);
        System.out.println(numerator);
        for(int i=0;i<Math.max(lenN,lenD);i++) System.out.print("-");
        System.out.println("");
        System.out.println(denominator);

    }

    public void setDenominator(long denominator) {
        this.denominator = denominator;
    }

    public void setNumerator(long numerator) {
        this.numerator = numerator;
    }


    public long getDenominator() {
        return denominator;
    }

    public long getNumerator() {
        return numerator;
    }


}
