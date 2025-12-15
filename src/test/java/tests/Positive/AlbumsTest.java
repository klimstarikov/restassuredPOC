package tests.Positive;

import facade.AlbumsAPIFacade;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.Album.AlbumVO;
import model.Album.AlbumVORequest;
import model.Album.AlbumVORequestFactory;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.BaseTest;

import java.util.List;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

@Epic("Album API Tests")
@Feature("Album Feature")
public class AlbumsTest extends BaseTest {
    private final AlbumsAPIFacade albumsAPIFacade = new AlbumsAPIFacade();

    @Test
    @Story("Get album by id")
    public void getAlbumById() {
        AlbumVO album = albumsAPIFacade.getAlbumById(1);
        Assert.assertEquals(album.getId(), 1);
    }

    @Test
    @Story("Get albums by user id")
    public void getAlbumsByUserId() {
        List<AlbumVO> albums = albumsAPIFacade.getAlbumsByUserId(1);
        Assert.assertNotNull(albums);
        Assert.assertFalse(albums.isEmpty());
        Assert.assertTrue(albums.stream().allMatch(a -> a.getUserId() == 1));
    }

    @Test
    @Story("Create album")
    public void createAlbum() {
        AlbumVORequest request = AlbumVORequestFactory.randomAlbumVORequest();
        albumsAPIFacade.postNewAlbum(request)
                .then()
                .statusCode(HttpStatus.SC_CREATED)
                .body(matchesJsonSchemaInClasspath("schema/album-schema.json"));
    }
}

