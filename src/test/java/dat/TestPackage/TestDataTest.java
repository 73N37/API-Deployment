package dat.TestPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDataTest {

    @BeforeEach
    void setUp()
    {
        // Reset global state before each test to avoid test pollution
        TestData.Methods.entityConstructor("ResetEntity");
        TestData.Methods.recordConstructor("ResetRecord");
    }

    @Test
    void testGetInstanceReturnsSingleton()
    {
        TestData instance1 = new TestData().getInstance();
        TestData instance2 = new TestData().getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void testGetUnitClassForEntity()
    {
        Class<?> clazz = TestData.Methods.getUnitClass(TestData.DataType.ENTITY);
        assertNotNull(clazz);
        assertEquals("Entity", clazz.getSimpleName());
    }

    @Test
    void testGetUnitClassForRecord()
    {
        Class<?> clazz = TestData.Methods.getUnitClass(TestData.DataType.RECORD);
        assertNotNull(clazz);
        assertEquals("Record", clazz.getSimpleName());
    }

    @Test
    void testConstructorCreatesEntity()
    {
        dat.TestPackage.TestData.DataUnit entity = TestData.Methods.entityConstructor("TestEntity");
        assertNotNull(entity, "Constructor should return a non-null entity");
        assertNotNull(TestData.Methods.getEntity(), "Global entity should be set");
        assertEquals("TestEntity", TestData.Methods.getEntityName());
    }

    @Test
    void testConstructorCreatesRecord()
    {
        dat.TestPackage.TestData.DataUnit record = TestData.Methods.recordConstructor("TestRecord");
        assertNotNull(record);
        assertEquals("TestRecord", TestData.Methods.getRecordName());
    }

    @Test
    void testGetEntityReturnsGlobalEntity()
    {
        TestData.Methods.recordConstructor("GlobalEntity");
        TestData.DataUnit entity = TestData.Methods.getEntity();
        assertNotNull(entity);
    }

    @Test
    void testGetGlobalRecordReturnsGlobalRecord()
    {
        TestData.Methods.recordConstructor("GlobalRecord");
        TestData.Record record = TestData.Methods.getRecord();
        assertNotNull(record);
    }

    @Test
    void testPutRecordWithNameOnly()
    {
        TestData.DataUnit test = dat.TestPackage.TestData.Methods.recordConstructor( "NewRecord");
        TestData.DataUnit record = TestData.Methods.putRecord((dat.TestPackage.TestData.Record) test);
        assertNotNull(record);
        assertEquals("NewRecord", TestData.Methods.getRecordName());
    }

    @Test
    void testPutRecordWithIdAndName()
    {
        TestData.DataUnit record = TestData.Methods.putRecord(42, "RecordWithId");
        assertNotNull(record);
        Integer id = TestData.Methods.getId(record);
        assertEquals(42, id);
    }

    @Test
    void testGetIdFromRecord()
    {
        TestData.DataUnit record = TestData.Methods.putRecord(100, "TestRecord");
        Integer id = TestData.Methods.getId(record);
        assertEquals(100, id);
    }

    @Test
    void testEntityToRecord()
    {
        TestData.Methods.entityConstructor("EntityToConvert");
        TestData.DataUnit entity = TestData.Methods.getEntity();
        TestData.DataUnit record = TestData.Methods.entityToRecord((TestData.Entity) entity);
        assertNotNull(record);
    }

    @Test
    void TestPutGlobalEntity()
    {
        dat.TestPackage.TestData.Entity entity = TestData.Methods.entityConstructor("global");
        dat.TestPackage.TestData.Methods.putEntity(entity);
        assertEquals(entity, dat.TestPackage.TestData.Methods.getEntity());
    }

    @Test
    void TestPutGlobalRecord()
    {

    }
}