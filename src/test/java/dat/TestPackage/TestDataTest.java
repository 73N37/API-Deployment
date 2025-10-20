package dat.TestPackage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestDataTest {

    @BeforeEach
    void setUp()
    {
        // Reset global state before each test to avoid test pollution
        new TestInformation.Data().putEntity("ResetEntity");
        new TestInformation.Data().putDTO("ResetDTO");
    }

    @Test
    void testGetInstanceInstanceReturnsSingleton()
    {
        TestInformation instance1 = new TestInformation.Data().getInstance();
        TestInformation instance2 = new TestInformation.Data().getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void testConstructorCreatesEntity()
    {
        TestInformation.Entity entity = new TestInformation.Data().putEntity("TestEntity");
        assertNotNull(entity, "Constructor should return a non-null entity");
        assertNotNull(new TestInformation.Data().getEntity(), "Global entity should be set");
        assertEquals("TestEntity", new TestInformation.Data().getEntityName());
    }

    @Test
    void testConstructorCreatesDTO()
    {
        TestInformation.DTO dto = new TestInformation.Data().putDTO("TestDTO");
        assertNotNull(dto);
        assertEquals("TestDTO", dto.getName());
    }

    @Test
    void testGetInstanceEntityReturnsGlobalEntity()
    {
        new TestInformation.Data().putDTO("GlobalEntity");
        TestInformation.DataUnit entity = new TestInformation.Data().getEntity();
        assertNotNull(entity);
    }

    @Test
    void testGetInstanceGlobalRecordReturnsGlobalRecord()
    {
        new TestInformation.Data().putDTO("GlobalRecord");
        TestInformation.DTO dto = new TestInformation.Data().getDTO();
        assertNotNull(dto);
    }

    @Test
    void testPutRecordWithNameOnly()
    {
        TestInformation.DTO dto = new TestInformation.Data().putDTO("NewDTO");
        assertNotNull(dto);
        assertEquals("NewDTO", new TestInformation.Data().getDtoName());
    }

    @Test
    void testPutRecordWithIdAndName()
    {
        TestInformation.DTO dto = new TestInformation.Data().putDTO(42, "DTOWithId");
        assertNotNull(dto);
        assertEquals(42, dto.getId());
    }

    @Test
    void testGetInstanceIdFromRecord()
    {
        TestInformation.DTO dto = new TestInformation.Data().putDTO(100, "TestRecord");
        Integer id = dto.getId();
        assertEquals(100, id);
    }

    @Test
    void testEntityToDTO()
    {
        new TestInformation.Data().putEntity("EntityToConvert");
        TestInformation.Entity entity = new TestInformation.Data().getEntity();
        TestInformation.DTO dto = new TestInformation.Data().entityToDTO(entity);
        assertEquals(dto.getName(), entity.getName());
    }

    @Test
    void TestPutGlobalEntity()
    {
        TestInformation.Entity entity = new TestInformation.Data().putEntity("global");
        assertEquals(entity, new TestInformation.Data().getEntity());
    }

    @Test
    void TestPutGlobalRecord()
    {
        TestInformation.DTO dto = new TestInformation.Data().putDTO("global");
        assertEquals(dto, new TestInformation.Data().getDTO());
    }
}