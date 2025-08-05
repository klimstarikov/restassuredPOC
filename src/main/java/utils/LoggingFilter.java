package utils;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    public Response filter(FilterableRequestSpecification requestSpec,
                           FilterableResponseSpecification responseSpec,
                           FilterContext context) {

        // Log request
        logger.info("Request: {} {}", requestSpec.getMethod(), requestSpec.getURI());
        if (!requestSpec.getHeaders().asList().isEmpty())
            logger.info("Headers: {}", requestSpec.getHeaders());
        if (requestSpec.getBody() != null) {
            logger.info("Body: {}", (Object) requestSpec.getBody());
        }
        // Execute request
        Response response = context.next(requestSpec, responseSpec);

        // Log response
        logger.info("Response Status: {}", response.getStatusLine());
        logger.info("Response Body: {}", response.getBody().asPrettyString());

        return response;
    }
}
