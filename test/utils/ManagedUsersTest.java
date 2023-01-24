package utils;

import dades.usuari;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lluís Barbó
 */
public class ManagedUsersTest {
    
    public ManagedUsersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId_con method, of class ManagedUsers.
     */
    @Test
    public void testGetId_con() {
        System.out.println("getId_con");
        usuari instance = new usuari();
        int expResult = 0;
       int result = instance.getIduser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId_con method, of class ManagedUsers.
     */
    @Test
    public void testSetId_con() {
        System.out.println("setId_con");
        int id = 0;
        usuari instance = new usuari();
        instance.setIduser(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class ManagedUsers.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        usuari instance = new usuari();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class ManagedUsers.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        usuari instance = new usuari();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class ManagedUsers.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        usuari instance = new usuari();
        String expResult = "";
        String result = instance.getLastname();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class ManagedUsers.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        usuari instance = new usuari();
        instance.setLastname(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocType method, of class ManagedUsers.
     */
    @Test
    public void testGetDocType() {
        System.out.println("getDocType");
        usuari instance = new usuari();
        String expResult = "";
        String result = instance.getDoctype();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDocType method, of class ManagedUsers.
     */
    @Test
    public void testSetDocType() {
        System.out.println("setDocType");
        String docType = "";
        usuari instance = new usuari();
        instance.setDoctype(docType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumDoc method, of class ManagedUsers.
     */
    @Test
    public void testGetNumDoc() {
        System.out.println("getNumDoc");
        usuari instance = new usuari();
        String expResult = "";
        String result = instance.getNumdoc();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumDoc method, of class ManagedUsers.
     */
    @Test
    public void testSetNumDoc() {
        System.out.println("setNumDoc");
        String numDoc = "";
        usuari instance = new usuari();
        instance.setNumdoc(numDoc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class ManagedUsers.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        usuari instance = new usuari();
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class ManagedUsers.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        usuari instance = new usuari();
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class ManagedUsers.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        usuari instance = new usuari();
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class ManagedUsers.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        usuari instance = new usuari();
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class ManagedUsers.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        usuari instance = new usuari();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class ManagedUsers.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        usuari instance = new usuari();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAcces method, of class ManagedUsers.
     */
    @Test
    public void testGetAcces() {
        System.out.println("getAcces");
        usuari instance = new usuari();
        int expResult = 0;
        int result = instance.getRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAcces method, of class ManagedUsers.
     */
    @Test
    public void testSetAcces() {
        System.out.println("setAcces");
        int acces = 0;
        usuari instance = new usuari();
        instance.setRol(acces);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class ManagedUsers.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        usuari instance = new usuari();
        String expResult = "";
        String result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class ManagedUsers.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        String user = "";
        usuari instance = new usuari();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassword method, of class ManagedUsers.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        usuari instance = new usuari();
        String expResult = "";
        String result = instance.getPassword();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassword method, of class ManagedUsers.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "";
        usuari instance = new usuari();
        instance.setPassword(password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSex method, of class ManagedUsers.
     */
    @Test
    public void testGetSex() {
        System.out.println("getSex");
        usuari instance = new usuari();
        String expResult = "";
        String result = instance.getSex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSex method, of class ManagedUsers.
     */
    @Test
    public void testSetSex() {
        System.out.println("setSex");
        String sex = "";
        usuari instance = new usuari();
        instance.setSex(sex);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    /**
     * Test of addUser method, of class ManagedUsers.
     */
  /*  @Test
    public void testAddUser() {
        System.out.println("addUser");
        ManagedUsers instance = new ManagedUsers();
        boolean expResult = false;
        boolean result = instance.addUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }**/
    
}
