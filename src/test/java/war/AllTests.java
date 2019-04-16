package war;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import war.entity.WeatherTest;


@RunWith(Suite.class)
@SuiteClasses({ClientTest.class, ProviderTest.class, WeatherTest.class})
public class AllTests {

}


