package facade;

// Photos facade wrapper — no-op comment to trigger re-indexing
import api.PhotosAPIImpl;
import io.restassured.response.Response;

import java.util.List;

public class PhotosAPIFacade {
    private final PhotosAPIImpl photosAPIImpl;

    public PhotosAPIFacade() {
        this.photosAPIImpl = new PhotosAPIImpl();
    }

    public model.Photo.PhotoVO getPhotoById(int id) {
        return photosAPIImpl.getPhotoById(id)
                .then()
                .extract()
                .as(model.Photo.PhotoVO.class);
    }

    public List<model.Photo.PhotoVO> getPhotosByAlbumId(int albumId) {
        return photosAPIImpl.getPhotosByAlbumId(albumId)
                .then()
                .extract()
                .jsonPath()
                .getList("", model.Photo.PhotoVO.class);
    }

    public List<model.Photo.PhotoVO> getPhotosByAlbumPath(int albumId) {
        return photosAPIImpl.getPhotosByAlbumPath(albumId)
                .then()
                .extract()
                .jsonPath()
                .getList("", model.Photo.PhotoVO.class);
    }

    public Response postNewPhoto(model.Photo.PhotoVORequest body) {
        return photosAPIImpl.postNewPhoto(body)
                .then()
                .extract()
                .response();
    }

    public Response updatePhotoById(int photoId, model.Photo.PhotoVORequest body) {
        return photosAPIImpl.updatePhotoById(photoId, body)
                .then()
                .extract()
                .response();
    }

    public Response deletePhotoById(int photoId) {
        return photosAPIImpl.deletePhotoById(photoId)
                .then()
                .extract()
                .response();
    }
}
