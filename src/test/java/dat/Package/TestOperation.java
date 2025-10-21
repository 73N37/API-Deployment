//package dat.TestPackage;
//
//import org.junit.jupiter.api.*;
//import static org.junit.jupiter.api.Assertions.*;
//
//class TestOperation {
//
//    private static Operation.Factory factory;
//    private static jakarta.persistence.EntityManagerFactory emf;
//    private TestDAO dao;
//
//    // Concrete DAO implementation that extends TestOperation.DAO.Methods
//    private static class TestDAO extends Operation.DAO.Methods<
//            Information.Entity,
//            Integer>
//    {
//        public TestDAO() {
//            super();
//        }
//    }
//
//    @BeforeAll
//    static void setUpAll() {
//        // Initialize factory and EMF before any tests run
//        factory = new Operation.Factory();
//        emf = factory.getEMF();
//
//        // Set up entity and ID classes
//        factory.forEntity(Information.Entity.class, Integer.class);
//    }
//
//    @BeforeEach
//    void setUp() {
//        dao = new TestDAO();
//
//        // Populate test data
//        try (var em = emf.createEntityManager()) {
//            em.getTransaction().begin();
//            Information.Entity entity = new Information.Entity("Test");
//            entity.setId(1);
//            em.persist(entity);
//            em.getTransaction().commit();
//        }
//    }
//
//    @Test
//    void testGetExistingEntity() {
//        // Act
//        Information.Entity result = dao.get(1);
//
//        // Assert
//        assertNotNull(result);
//        assertEquals(1, result.getId());
//    }
//
//    @Test
//    void testGetNonExistingEntity() {
//        // Act & Assert
//        assertThrows(Operation.ApiException.class, () -> dao.get(999));
//    }
//
//    @AfterAll
//    static void tearDown() {
//        if (emf != null) {
//            emf.close();
//        }
//    }
//}