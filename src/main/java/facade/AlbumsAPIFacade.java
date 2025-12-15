package facade;

import api.AlbumsAPIImpl;
import io.restassured.response.Response;
import model.Album.AlbumVO;
import model.Album.AlbumVORequest;

import java.util.List;

public class AlbumsAPIFacade {
    private final AlbumsAPIImpl albumsAPIImpl;

    public AlbumsAPIFacade() {
        this.albumsAPIImpl = new AlbumsAPIImpl();
    }

    public AlbumVO getAlbumById(int id) {
        return albumsAPIImpl.getAlbumById(id)
                .then()
                .extract()
                .as(AlbumVO.class);
    }

    public List<AlbumVO> getAlbumsByUserId(int userId) {
        return albumsAPIImpl.getAlbumsByUserId(userId)
                .then()
                .extract()
                .jsonPath()
                .getList("", AlbumVO.class);
    }

    public Response postNewAlbum(AlbumVORequest body) {
        return albumsAPIImpl.postNewAlbum(body)
                .then()
                .extract()
                .response();
    }

    public Response updateAlbumById(int albumId, AlbumVORequest body) {
        return albumsAPIImpl.updateAlbumById(albumId, body)
                .then()
                .extract()
                .response();
    }

    public Response deleteAlbumById(int albumId) {
        return albumsAPIImpl.deleteAlbumById(albumId)
                .then()
                .extract()
                .response();
    }
}

