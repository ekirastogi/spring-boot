package com.ekiras.base;

import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author ekansh
 * @since 22/7/16
 */
@WebAppConfiguration
@IntegrationTest("server.port:0")
public abstract class AbstractWebTest extends AbstractTest {

}
