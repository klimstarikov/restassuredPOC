package model.Post;

import org.apache.commons.lang3.RandomStringUtils;
import java.util.concurrent.ThreadLocalRandom;

public class PostVORequestFactory {
    public static PostVORequest randomPostVORequest() {
        return new PostVORequestBuilder()
                .withUserId(ThreadLocalRandom.current().nextInt(1, 101))
                .withTitle(RandomStringUtils.randomAlphabetic(5, 20))
                .withBody(RandomStringUtils.randomAlphabetic(10, 50))
                .build();
    }
}
