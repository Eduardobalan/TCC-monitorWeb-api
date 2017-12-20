package br.com.monitorweb;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Eduardo Balan on 02/09/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebIntegrationTest({"server.port=0", "management.port=0"})
@DbUnitConfiguration
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class, DbUnitTestExecutionListener.class})
@Transactional
@DirtiesContext(
        classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD
)
@SpringApplicationConfiguration(classes = WebMonitorAppTest.class)
public abstract class GenericTest {
    public GenericTest() {
    }
}

