//package dat.TestPackage;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//class TestDataTest {
//
//    @BeforeEach
//    void setUp()
//    {
//        // Reset global state before each test to avoid test pollution
//        new Information.Data().putEntity("ResetEntity");
//        new Information.Data().putDTO("ResetDTO");
//    }
//
//    @Test
//    void testGetInstanceInstanceReturnsSingleton()
//    {
//        Information instance1 = new Information.Data().getInstance();
//        Information instance2 = new Information.Data().getInstance();
//        assertSame(instance1, instance2);
//    }
//
//    @Test
//    void testConstructorCreatesEntity()
//    {
//        Information.Entity entity = new Information.Data().putEntity("TestEntity");
//        assertNotNull(entity, "Constructor should return a non-null entity");
//        assertNotNull(new Information.Data().getEntity(), "Global entity should be set");
//        assertEquals("TestEntity", new Information.Data().getEntityName());
//    }
//
//    @Test
//    void testConstructorCreatesDTO()
//    {
//        Information.DTO dto = new Information.Data().putDTO("TestDTO");
//        assertNotNull(dto);
//        assertEquals("TestDTO", dto.getName());
//    }
//
//    @Test
//    void testGetInstanceEntityReturnsGlobalEntity()
//    {
//        new Information.Data().putDTO("GlobalEntity");
//        Information.DataUnit entity = new Information.Data().getEntity();
//        assertNotNull(entity);
//    }
//
//    @Test
//    void testGetInstanceGlobalRecordReturnsGlobalRecord()
//    {
//        new Information.Data().putDTO("GlobalRecord");
//        Information.DTO dto = new Information.Data().getDTO();
//        assertNotNull(dto);
//    }
//
//    @Test
//    void testPutRecordWithNameOnly()
//    {
//        Information.DTO dto = new Information.Data().putDTO("NewDTO");
//        assertNotNull(dto);
//        assertEquals("NewDTO", new Information.Data().getDtoName());
//    }
//
//    @Test
//    void testPutRecordWithIdAndName()
//    {
//        Information.DTO dto = new Information.Data().putDTO(42, "DTOWithId");
//        assertNotNull(dto);
//        assertEquals(42, dto.getId());
//    }
//
//    @Test
//    void testGetInstanceIdFromRecord()
//    {
//        Information.DTO dto = new Information.Data().putDTO(100, "TestRecord");
//        Integer id = dto.getId();
//        assertEquals(100, id);
//    }
//
//    @Test
//    void testEntityToDTO()
//    {
//        new Information.Data().putEntity("EntityToConvert");
//        Information.Entity entity = new Information.Data().getEntity();
//        Information.DTO dto = new Information.Data().entityToDTO(entity);
//        assertEquals(dto.getName(), entity.getName());
//    }
//
//    @Test
//    void TestPutGlobalEntity()
//    {
//        Information.Entity entity = new Information.Data().putEntity("global");
//        assertEquals(entity, new Information.Data().getEntity());
//    }
//
//    @Test
//    void TestPutGlobalRecord()
//    {
//        Information.DTO dto = new Information.Data().putDTO("global");
//        assertEquals(dto, new Information.Data().getDTO());
//    }
//}