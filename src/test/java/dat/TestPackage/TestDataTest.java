package dat.TestPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDataTest {

    @BeforeEach
    void setUp()
    {
        // Reset global state before each test to avoid test pollution
        TestInformation.Methods.entityConstructor("ResetEntity");
        TestInformation.Methods.recordConstructor("ResetRecord");
    }

    @Test
    void testGetInstanceReturnsSingleton()
    {
        TestInformation instance1 = new TestInformation().getInstance();
        TestInformation instance2 = new TestInformation().getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void testGetUnitClassForEntity()
    {
        Class<?> clazz = TestInformation.Methods.getUnitClass(TestInformation.DataType.ENTITY);
        assertNotNull(clazz);
        assertEquals("Entity", clazz.getSimpleName());
    }

    @Test
    void testGetUnitClassForRecord()
    {
        Class<?> clazz = TestInformation.Methods.getUnitClass(TestInformation.DataType.RECORD);
        assertNotNull(clazz);
        assertEquals("Record", clazz.getSimpleName());
    }

    @Test
    void testConstructorCreatesEntity()
    {
        TestInformation.DataUnit entity = TestInformation.Methods.entityConstructor("TestEntity");
        assertNotNull(entity, "Constructor should return a non-null entity");
        assertNotNull(TestInformation.Methods.getEntity(), "Global entity should be set");
        assertEquals("TestEntity", TestInformation.Methods.getEntityName());
    }

    @Test
    void testConstructorCreatesRecord()
    {
        TestInformation.DataUnit record = TestInformation.Methods.recordConstructor("TestRecord");
        assertNotNull(record);
        assertEquals("TestRecord", TestInformation.Methods.getRecordName());
    }

    @Test
    void testGetEntityReturnsGlobalEntity()
    {
        TestInformation.Methods.recordConstructor("GlobalEntity");
        TestInformation.DataUnit entity = TestInformation.Methods.getEntity();
        assertNotNull(entity);
    }

    @Test
    void testGetGlobalRecordReturnsGlobalRecord()
    {
        TestInformation.Methods.recordConstructor("GlobalRecord");
        TestInformation.Record record = TestInformation.Methods.getRecord();
        assertNotNull(record);
    }

    @Test
    void testPutRecordWithNameOnly()
    {
        TestInformation.DataUnit test = TestInformation.Methods.recordConstructor( "NewRecord");
        TestInformation.DataUnit record = TestInformation.Methods.putRecord((TestInformation.Record) test);
        assertNotNull(record);
        assertEquals("NewRecord", TestInformation.Methods.getRecordName());
    }

    @Test
    void testPutRecordWithIdAndName()
    {
        TestInformation.DataUnit record = TestInformation.Methods.putRecord(42, "RecordWithId");
        assertNotNull(record);
        Integer id = TestInformation.Methods.getId(record);
        assertEquals(42, id);
    }

    @Test
    void testGetIdFromRecord()
    {
        TestInformation.DataUnit record = TestInformation.Methods.putRecord(100, "TestRecord");
        Integer id = TestInformation.Methods.getId(record);
        assertEquals(100, id);
    }

    @Test
    void testEntityToRecord()
    {
        TestInformation.Methods.entityConstructor("EntityToConvert");
        TestInformation.DataUnit entity = TestInformation.Methods.getEntity();
        TestInformation.DataUnit record = TestInformation.Methods.entityToRecord((TestInformation.Entity) entity);
        assertNotNull(record);
    }

    @Test
    void TestPutGlobalEntity()
    {
        TestInformation.Entity entity = TestInformation.Methods.entityConstructor("global");
        TestInformation.Methods.putEntity(entity);
        assertEquals(entity, TestInformation.Methods.getEntity());
    }

    @Test
    void TestPutGlobalRecord()
    {

    }
}