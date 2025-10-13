package dat.TestPackage.TestBlueprint;

import lombok.Getter;
import net.bytebuddy.description.type.TypeDescription;

import java.io.Serializable;

public final class Test<ID extends java.io.Serializable> {
    // TODO
    /*  Global-scope Fields:
        Since these Fields doesn't have getters or setters,
        The ONLY way to access them is though my entity methods
    */
    private static boolean testGlobalBoolean = true;
    private static String testGlobalString;

    // Can be String & Integer.
    // Serializable avoids int since it CAN'T be assigned to null;
    private ID testId;

    // Constructor
    public Test(String testString){
        this.testGlobalString = testString;
    }

    @lombok.Setter
    @lombok.Getter
    public static class TestEntity
    {   // The ONLY purpose of this class is to be manipulated from an outside classes
        // This class must ONLY contain a Constructor with public static Fields
        public static String name;
        public static Integer id;
        public static String test = TestDTO.test;      // takes data directly from TestDTO's test Field
        public TestInterface TestInterface;

        public TestEntity(TestDTO dto){
            this.name = dto.name();
            this.id = dto.id();
        }
    }

    public abstract static class TestMethods implements TestInterface<Integer>
    {   // TODO: This class is exclusively used for defining Methods

        public boolean getGlobalBoolean(){
            // This method takes a private Field and returns it.
            // This is to ensure the integrity of the var
            return Test.testGlobalBoolean;
        }
         public static String testString(){
            return "testString1";
        }
    }

    public record TestDTO(Integer id, String name)
    {   // TODO: This method is exclusively used to store data between Methods, Fields & Classes
        // Since records are immutable data can ONLY be assigned on instantiation
        public static String test = TestMethods.testString();  // Field is static because the method testString is static

        public TestDTO(Integer id){
            this(id, null);
        }

    }

    public interface TestInterface<ID extends java.io.Serializable>
    {   // TODO: This class is exclusively for defining Method signatures
        ID getId();
        static String testString(){
            return "testString2";
        };
    }

    public @interface TestAnnotation
    {

    }
}
