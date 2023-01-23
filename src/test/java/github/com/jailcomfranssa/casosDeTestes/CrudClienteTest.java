package github.com.jailcomfranssa.casosDeTestes;

import github.com.jailcomfranssa.EntityManagerTest;
import github.com.jailcomfranssa.model.entities.Cliente;
import org.junit.Test;

public class CrudClienteTest extends EntityManagerTest {

    @Test
    public void inserindo(){
        Cliente cliente = new Cliente();
        cliente.setId(3);
        cliente.setNome("Jose Pinto");

        entityManager.getTransaction().begin();

        entityManager.persist(cliente);

        entityManager.getTransaction().commit();
    }

    @Test
    public void atulizando(){

        Cliente cliente = new Cliente();
        cliente.setId(3);
        cliente.setNome("Jose Pinto Filho");

        entityManager.getTransaction().begin();

        entityManager.merge(cliente);

        entityManager.getTransaction().commit();
    }

    @Test
    public void consultando(){

       Cliente cliente =  entityManager.find(Cliente.class,1);
    }

    @Test
    public void deletando(){
        Cliente cliente =  entityManager.find(Cliente.class,1);

        entityManager.getTransaction().begin();

        entityManager.remove(cliente);

        entityManager.getTransaction().commit();
    }
}
