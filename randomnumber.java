import java.util.Random;

public class randomnumber {
    private final 
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVQXYZ";
private final 
        char [] RANDOM;

    public randomnumber() {
        this.RANDOM = (LETTERS +"0123456789").toCharArray();
    }
public String generateRandomAlphanumeric(int length)   
{
    StringBuilder result = new StringBuilder();
    for (int i=0 ; i<length;i++)
    {
        result.append(RANDOM[new Random().nextInt(RANDOM.length)]);
    }
    return result.toString();
}
}