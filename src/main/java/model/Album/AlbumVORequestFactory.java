package model.Album;

import java.util.concurrent.ThreadLocalRandom;

public class AlbumVORequestFactory {
    public static AlbumVORequest randomAlbumVORequest() {
        int userId = ThreadLocalRandom.current().nextInt(1, 11);
        String title = "Album title " + System.currentTimeMillis();
        String body = "Album body " + System.currentTimeMillis();
        return new AlbumVORequest(userId, title, body);
    }
}
