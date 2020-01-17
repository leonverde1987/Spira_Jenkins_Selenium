package TestCases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import com.inflectra.spiratest.addons.junitextension.*;
import java.io.FileNotFoundException;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;

import steps.stepsOne;

@SpiraTestConfiguration(
	    url="https://testing-it.spiraservice.net",
	    login="laguilar",
	    password="test1234", 
	    projectId=67,
	    testSetId=73
	)

public class TestOne extends stepsOne{
    public Properties Config = null;
    public Properties Datos = null;
    public WebDriver driver = null;

    @Before
    public void PrepararEjecucion() throws FileNotFoundException{
        Config = this.getPropetiesFile();
        Datos = this.getPropetiesFile();
        driver = this.openBrowser(Config.getProperty("Navegador"), Config.getProperty("urlApp"));
    }

    @Test
    @SpiraTestCase(testCaseId=6900)
    public void TestBuscarGoogle() throws InterruptedException {
        this.ingresar_contenido(driver, Config.getProperty("texto"));
        this.dormir10seg();
    }
    
    @Test
    @SpiraTestCase(testCaseId=7010)
    public void TestBuscarGoogle2() throws InterruptedException {
        this.ingresar_contenido(driver, Config.getProperty("texto2"));
        this.dormir10seg();
    }
    
    @Test
    @SpiraTestCase(testCaseId=7011)
    public void TestBuscarGoogle3() throws InterruptedException {
        this.ingresar_contenido(driver, Config.getProperty("texto3"));
        this.dormir10seg();
    }

    @After
    public void cerrarTest(){
        this.cerrar_Navegador(driver);
    }
}
