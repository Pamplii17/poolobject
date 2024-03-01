/**
 * 
 */
package ubu.gii.dass.test.c01;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ubu.gii.dass.c01.DuplicatedInstanceException;
import ubu.gii.dass.c01.NotFreeInstanceException;
import ubu.gii.dass.c01.Reusable;
import ubu.gii.dass.c01.ReusablePool;

/**
 * @author Sergio Martín Reizábal
 * @author Javier Pampliega Garcia
 *
 */
public class ReusablePoolTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	private ReusablePool pool;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.pool = ReusablePool.getInstance();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		this.pool.setInstance(null);
	}

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#getInstance()}.
	 */
	
	@Test
	public void testGetInstance() {
		ReusablePool pool2 = ReusablePool.getInstance();

		assertNotNull(pool2);

		assertTrue(pool2 instanceof ReusablePool);
	}
	
	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#acquireReusable()}.
	 */

	// ...

	@Test
	public void testAcquireReusable() {
		try {
			Reusable reusable = pool.acquireReusable();
			assertNotNull(reusable);
		} catch(NotFreeInstanceException e) {
			fail("No debería lanzar una excepción");
		}
	}
    

	/**
	 * Test method for {@link ubu.gii.dass.c01.ReusablePool#releaseReusable(ubu.gii.dass.c01.Reusable)}.
	 */
	@Test
	public void testReleaseReusable() throws DuplicatedInstanceException{
	
		// Al principio ReusablePool tiene únicamente dos instancias de Resusable
		assertTrue(pool.getVector().size() == 2);
		try {
			// Obtenemos el primer Reusable
			Reusable reusable1 = pool.acquireReusable();
			// Comprobamos que el tamaño de ReusablePool ha disminuido en una unidad
			assertTrue(pool.getVector().size() == 1);
			// Obtenemos el segundo Reusable
			Reusable reusable2 = pool.acquireReusable();
			// Comprobamos que el tamaño de ReusablePool es 0 (Ya no le quedan objetos de tipo Reusuable)
			assertTrue(pool.getVector().size() == 0);
			
			// Liberamos el primer reusable
			pool.releaseReusable(reusable1);
			// Comprobamos que el tamaño de ReusablePool ha aumentado en una unidad
			assertTrue(pool.getVector().size() == 1);
			// Comprobamos que ReusablePool contiene el Reusable que hemos liberado
			assertTrue(pool.getVector().contains(reusable1));
			
			// Liberamos el segundo reusable
			pool.releaseReusable(reusable2);
			// Comprobamos que el tamaño de ReusablePool ha aumentado en una unidad
			assertTrue(pool.getVector().size() == 2);
			// Comprobamos que ReusablePool contiene el Reusable que hemos liberado
			assertTrue(pool.getVector().contains(reusable2));

		} catch (NotFreeInstanceException ex) {
			fail("No deberia de lanzarse esta excepcion");
		}	
	}
	
	@Test
    public void testAcquireReusableWhenNoInstancesAvailableThrowsException() throws NotFreeInstanceException, DuplicatedInstanceException{

        // Intentamos adquirir dos instancias de reusables
        Reusable reusable1 = pool.acquireReusable();
        Reusable reusable2 = pool.acquireReusable();

        assertNotNull(reusable1);
        assertNotNull(reusable2);

        // Intentamos adquirir una tercera instancia (debería lanzar una excepción)
        try {
            Reusable reusable3 = pool.acquireReusable();
            fail("Debería haber lanzado una excepción");
        } catch (NotFreeInstanceException e) {
            // Excepción esperada
        }

        // Liberamos una instancia
        pool.releaseReusable(reusable1);

        // Intentamos adquirir una cuarta instancia (debería funcionar)
        Reusable reusable4 = pool.acquireReusable();
        assertNotNull(reusable4);
        
    }
}