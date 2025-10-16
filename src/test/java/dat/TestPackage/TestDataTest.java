package dat.TestPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDataTest {

    @BeforeEach
    void setUp()
    {
        // Reset global state before each test to avoid test pollution
        TestData.Methods.constructor(TestData.DataType.ENTITY, "ResetEntity");
        TestData.Methods.constructor(TestData.DataType.RECORD, "ResetRecord");
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
        dat.TestPackage.TestData.DataUnit entity = TestData.Methods.constructor(TestData.DataType.ENTITY, "TestEntity");
        assertNotNull(entity);
        assertEquals("TestEntity", TestData.Methods.getEntityName());
    }

    @Test
    void testConstructorCreatesRecord()
    {
        dat.TestPackage.TestData.DataUnit record = TestData.Methods.constructor(TestData.DataType.RECORD, "TestRecord");
        assertNotNull(record);
        assertEquals("TestRecord", TestData.Methods.getRecordName());
    }

    @Test
    void testGetEntityReturnsGlobalEntity()
    {
        TestData.Methods.constructor(TestData.DataType.ENTITY, "GlobalEntity");
        TestData.DataUnit entity = TestData.Methods.getEntity();
        assertNotNull(entity);
    }

    @Test
    void testGetGlobalRecordReturnsGlobalRecord()
    {
        TestData.Methods.constructor(TestData.DataType.RECORD, "GlobalRecord");
        TestData.Record record = TestData.Methods.getRecord();
        assertNotNull(record);
    }

    @Test
    void testPutRecordWithNameOnly()
    {
        TestData.DataUnit test = dat.TestPackage.TestData.Methods.constructor( true, "NewRecord");
        TestData.DataUnit record = TestData.Methods.putRecord((dat.TestPackage.TestData.Record) test);
        assertNotNull(record);
        assertEquals("NewRecord", TestData.Methods.getRecordName());
    }

    @Test
    void testPutRecordWithIdAndName()
    {
        TestData.DataUnit record = TestData.Methods.putRecord(42, "RecordWithId");
        assertNotNull(record);
        Integer id = TestData.Methods.getId( record);
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
        TestData.Methods.constructor(TestData.DataType.ENTITY, "EntityToConvert");
        TestData.DataUnit entity = TestData.Methods.getEntity();
        TestData.DataUnit record = TestData.Methods.entityToRecord((TestData.Entity) entity);
        assertNotNull(record);
    }

    @Test
    void TestPutGlobalEntity()
    {
        TestData.DataUnit global = TestData.Methods.constructor(TestData.DataType.ENTITY, "GlobalEntity");
        Class<? extends dat.TestPackage.TestData.DataUnit> globalEntity = TestData.Methods.dataUnitToEntity(global);
        dat.TestPackage.TestData.Entity test =(dat.TestPackage.TestData.Entity)  dat.TestPackage.TestData.Methods.create(globalEntity);
        TestData.Methods.putEntity(test);
        assertEquals(global, TestData.getGlobalEntity());
    }

    @Test
    void TestPutGlobalRecord()
    {
        TestData.DataUnit global = TestData.Methods.constructor(TestData.DataType.RECORD, "GlobalRecord");
        Class<? extends dat.TestPackage.TestData.DataUnit> globalRecord = TestData.Methods.dataUnitToEntity(global);
        dat.TestPackage.TestData.Record test =(dat.TestPackage.TestData.Record)  dat.TestPackage.TestData.Methods.create(globalRecord);
        TestData.Methods.putRecord(test);
        assertEquals(global, TestData.getGlobalRecord());
    }
}