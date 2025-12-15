package model.Photo;

import java.util.concurrent.ThreadLocalRandom;

public class PhotoVORequestFactory {
    public static PhotoVORequest randomPhotoVORequest() {
        int albumId = ThreadLocalRandom.current().nextInt(1, 101);
        String title = "Photo title " + System.currentTimeMillis();
        String url = "https://via.placeholder.com/600/" + Long.toHexString(System.currentTimeMillis());
        String thumbnailUrl = "https://via.placeholder.com/150/" + Long.toHexString(System.currentTimeMillis());
        String body = "Photo body " + System.currentTimeMillis();
        return new PhotoVORequest(albumId, title, url, thumbnailUrl, body);
    }
}
