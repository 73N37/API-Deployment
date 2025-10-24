package dat.HelloWorld;

@lombok.Getter
public class HelloWorldDTO
{
    String message;
    public HelloWorldDTO(String message)
    {
        this.message = message;
    }
}
